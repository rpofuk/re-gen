(ns {{projectName}}.events
  (:require
    [re-frame.core :as re-frame]
    [{{projectName}}.db :as db]
    ))

(re-frame/reg-event-db
  ::initialize-db
  (fn [_ _]
    db/default-db))

(re-frame/reg-event-db
 :menu
 (fn [db _]
   (update db :drawer #(not %))))
