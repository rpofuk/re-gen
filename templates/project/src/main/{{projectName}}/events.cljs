(ns {{projectName}}.events
  (:require
    [re-frame.core :as re-frame]
    [{{projectName}}.db :as db]
    ))

(re-frame/reg-event-db
  ::initialize-db
  (fn [_ _]
    (.log js/console "Init")
    db/default-db))




(re-frame/reg-event-fx                                      ;; -fx registration, not -db registration
  ::set-active-panel
  (fn [cofx event]                                          ;; 1st argument is coeffects, instead of db
    (.log js/console (:db cofx) (second event))
    {:db       (assoc (:db cofx) ::db/active-panel (second event))
     :dispatch [(keyword (str "initialize-" (name (second event)) "-db"))]})) ;; return effects

(re-frame/reg-event-db
  ::test
  (fn [db event]
    (.log js/console db (second event))
    (assoc db ::db/test (second event))))

(re-frame/reg-event-db
  :menu
  (fn [db _]
    (update db :drawer #(not %))))
