(ns {{projectName}}.{{pageName}}.events
  (:require
    [re-frame.core :as re-frame]
    [{{projectName}}.{{pageName}}.db :as db]
    ))

(re-frame/reg-event-db
  :initialize-{{pageName}}-db
  (fn [db _]
    (merge db db/default-db)))

(re-frame/reg-event-db
  ::click
  (fn [db _]
    (update-in db [::db/clicks] inc)))
