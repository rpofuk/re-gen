(ns {{projectName}}.{{pageName}}.views
  (:require [re-frame.core :as rf]
            [{{projectName}}.{{pageName}}.subs :as subs]
            [{{projectName}}.{{pageName}}.events :as events]
            ))


(defn main-panel
  [classes]
  [:div
   [:h2
    {:class-name (:page classes)
     :on-click   #(rf/dispatch [::events/click])}
    @(rf/subscribe [::subs/name])
    ]
   [:div @(rf/subscribe [::subs/clicks])]])







