(ns edd.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [edd.events :as events]
            [edd.views :as views]
            ["@material-ui/core/styles" :refer [withStyles, createMuiTheme, MuiThemeProvider]]
            [clojure.walk :refer [keywordize-keys]]
            [reagent.core :as r]
            [reagent.dom :as dom]
            [bidi.bidi :as bidi]
            [pushy.core :as pushy]))

(defn with-custom-styles
  [{:keys [styles]} component]
  ((withStyles
     (fn [theme]
       (clj->js
         (styles theme)))) component))

(defn body
  [{:keys [theme panels] :as ctx}]
  "Initialize body with custom style"
  [:> MuiThemeProvider {:theme (createMuiTheme (clj->js theme))}
   [:> (with-custom-styles
         ctx
         (r/reactify-component
           (fn [props]
             (views/page
               (assoc
                 ctx
                 :classes (keywordize-keys
                            (:classes (js->clj props))))))))]])

(defn- dispatch-route [{:keys [handler route-params]}]
  (re-frame/dispatch [::events/set-active-panel
                      handler
                      route-params]))

(defn app-routes
  [parse-fn]
  (pushy/start!
    (pushy/pushy dispatch-route parse-fn)))

(defn mount-root
  [{:keys [routes] :as ctx}]
  (re-frame/clear-subscription-cache!)
  (app-routes
    (fn [url]
      (bidi/match-route routes url)))
  (dom/render
    (body ctx)
    (.getElementById js/document "app")))

(defn init
  [ctx]
  (re-frame/dispatch [::events/initialize-db ctx])
  (mount-root ctx))
