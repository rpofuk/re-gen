(ns {{projectName}}.subs
  (:require
    [re-frame.core :as re-frame]))

(re-frame/reg-sub
  ::name
  (fn [db]
    (:name db)))

(re-frame/reg-sub
 ::decks
 (fn [db]
   (:decks db)))

(re-frame/reg-sub
  ::menu
  (fn [db]
    (:drawer db)))
