(ns {{projectName}}.events
  (:import goog.history.Html5History)
  (:require
    [re-frame.core :as re-frame]
    [{{projectName}}.db :as db]
    ))

(re-frame/reg-event-db
  ::initialize-db
  (fn [_ _]
    db/default-db))




(re-frame/reg-event-fx                                      ;; -fx registration, not -db registration
  ::set-active-panel
  (fn [cofx event]                                          ;; 1st argument is coeffects, instead of db
    {:db       (assoc (:db cofx) ::db/active-panel (second event))
     :dispatch [(keyword (str "initialize-" (name (second event)) "-db"))]})) ;; return effects

(re-frame/reg-event-db
  ::test
  (fn [db event]
    (assoc db ::db/test (second event))))

(re-frame/reg-event-db
  ::toggle-drawer
  (fn [db event]
    (update db ::db/drawer #(not %))))


(re-frame/reg-event-db
  ::menu-toggle
  (fn [db event]
    (update-in db [::db/menu-expanded (second event)] #(not %))))

(re-frame/reg-event-db
  :navigate
  (fn [db event]
    (assoc db ::db/drawer false)
    ))


