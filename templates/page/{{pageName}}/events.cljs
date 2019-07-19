(ns {{projectName}}.home.events
  (:require
    [re-frame.core :as re-frame]
    [{{projectName}}.home.db :as db]
    ))

(re-frame/reg-event-db
  :initialize-home-db
  (fn [db _]
    (merge db db/default-db)))

(re-frame/reg-event-db
 :menu
 (fn [db _]
   (update db :drawer #(not %))))
