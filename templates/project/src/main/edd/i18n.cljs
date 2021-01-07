(ns edd.i18n
  (:require [re-frame.core :as rf]
            [edd.db :as db]
            [edd.subs :as subs]))



(defn tr
  [key]
  (let [lang @(rf/subscribe [::subs/selected-language])
        prop (if (vector? key)
               key
               [key])]
    (get-in
      @(rf/subscribe [::subs/translations])
      (concat prop
              [lang])
      (str "tr (" key " " lang ")"))))