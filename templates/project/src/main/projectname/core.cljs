(ns projectname.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [projectname.events :as events]
            [projectname.views :as views]
            [projectname.config :as config]
            ["@material-ui/core/styles" :refer [withStyles, createMuiTheme, MuiThemeProvider]]
            [clojure.walk :refer [keywordize-keys]]
            [reagent.core :as r]
            [reagent.dom :as dom]
            [projectname.styles :as styles]
            [projectname.routes :refer [routes]]
            [bidi.bidi :as bidi]
            [pushy.core :as pushy]))

(defn dev-setup
  []
  (when config/debug? (enable-console-print!) (println "dev mode")))

(defn raw-theme
  "Convert styles into javascript map"
  [theme]
  (clj->js
    (styles/rules theme)))

(defn with-custom-styles
  [component]
  ((withStyles raw-theme) component))

(defn content
  "Wrapper to help remove JS style access to class names (.-root classes) to (:root classes)"
  [props]
  (views/page
    (keywordize-keys
      (:classes (js->clj props)))))

(def body
  "Initialize body with custom style"
  [:> MuiThemeProvider {:theme (createMuiTheme (clj->js
                                                 styles/theme))}
   [:> (with-custom-styles (r/reactify-component content))]])

(defn- parse-url [url]
  (bidi/match-route routes url))

(defn- dispatch-route [{:keys [handler route-params]}]
  (re-frame/dispatch [::events/set-active-panel
                      handler
                      route-params]))

(defn app-routes []
  (pushy/start! (pushy/pushy dispatch-route parse-url)))

(defn mount-root
  []
  (re-frame/clear-subscription-cache!)
  (app-routes)
  (dom/render body (.getElementById js/document "app")))

(defn ^:export init
  [config]
  (re-frame/dispatch [::events/initialize-db (js->clj config)])
  (dev-setup)
  (mount-root))
