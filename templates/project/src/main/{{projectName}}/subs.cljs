(ns {{projectName}}.subs
  (:require
    [{{projectName}}.db :as db]
    [re-frame.core :as re-frame]))

(re-frame/reg-sub
  ::name
  (fn [db]
    (:name db)))

(re-frame/reg-sub
 ::active-panel
 (fn [db]
   (::db/active-panel db)))

(re-frame/reg-sub
  ::menu
  (fn [db]
    (:drawer db)))
