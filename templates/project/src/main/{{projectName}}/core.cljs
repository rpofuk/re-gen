(ns {{projectName}}.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]

            [{{projectName}}.events :as events]
            [{{projectName}}.views :as views]
            [{{projectName}}.config :as config]))


(defn dev-setup
  []
  (when config/debug? (enable-console-print!) (println "dev mode")))

(defn mount-root
  []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/page] (.getElementById js/document "app")))


(defn ^:export init
  []
  (re-frame/dispatch [::events/initialize-db])
  (.log js/console "bla")
  (dev-setup)

  (mount-root))
