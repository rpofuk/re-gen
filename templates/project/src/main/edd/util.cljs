(ns edd.util
  (:require
   [re-frame.core :as rf]
   [edd.subs :as subs]))

(defn placeholder
  [components classes]
  (let [panel @(rf/subscribe [::subs/active-panel])]
    (if (contains? components panel)
      ((panel components) classes)
      [:h2 "Not found"])))
