(ns {{projectName}}.{{pageName}}.views
  (:require [re-frame.core :as rf]
            [{{projectName}}.{{pageName}}.subs :as subs]
            [{{projectName}}.{{pageName}}.events :as events]

            ["@material-ui/core/Grid" :default Grid]))


(defn main-panel
  [classes]
  [:> Grid {:container true
            :item      true
            :xs        12}
   [:> Grid {:item true
             :xs   12}
    [:h2
     {:class-name (:page classes)
      :on-click   #(rf/dispatch [::events/click])}
     @(rf/subscribe [::subs/name])]]
   [:> Grid {:item true
             :xs   12}
    @(rf/subscribe [::subs/clicks])]])







