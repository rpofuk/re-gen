(ns {{projectName}}.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]

            [{{projectName}}.events :as events]
            [{{projectName}}.views :as views]
            [{{projectName}}.config :as config]
            ["@material-ui/core/styles" :refer [withStyles, createMuiTheme, MuiThemeProvider]]
            [clojure.walk :refer [keywordize-keys]]
            [reagent.core :as r]
            [{{projectName}}.styles :as styles]
            [{{projectName}}.routes :refer [routes]]
            [bidi.bidi :as bidi]
            [pushy.core :as pushy]))


(defn dev-setup
  []
  (when config/debug? (enable-console-print!) (println "dev mode")))

(defn raw-theme
  "Convert styles into javascript map"
  [theme]
  (clj->js
    (styles/rules theme)
    ))

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
                                                 styles/theme
                                                 ))}
   [:> (with-custom-styles (r/reactify-component content))]])



(defn- parse-url [url]
  (bidi/match-route routes url))

(defn- dispatch-route [matched-route]
  (let [panel-name (:handler matched-route)]
    (re-frame/dispatch [::events/set-active-panel panel-name])))

(defn app-routes []
  (pushy/start! (pushy/pushy dispatch-route parse-url)))

(def url-for (partial bidi/path-for routes))


(defn mount-root
  []
  (re-frame/clear-subscription-cache!)
  (app-routes)
  (reagent/render body (.getElementById js/document "app")))

(defn ^:export init
  []
  (re-frame/dispatch [::events/initialize-db])
  (dev-setup)
  (mount-root))
