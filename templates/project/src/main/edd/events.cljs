(ns edd.events
  (:import goog.history.Html5History)
  (:require
    [re-frame.core :as re-frame]
    [edd.db :as db]))

(re-frame/reg-event-db
  ::initialize-db
  (fn [_ [_ event]]
    (assoc db/default-db :config event)))

(re-frame/reg-event-fx
  :set-active-panel
  (fn [{:keys [db]} [_ page & [params]]]
    {:db       (assoc db ::db/active-panel page
                         ::db/drawer false)
     :dispatch [(keyword (str "initialize-" (name page) "-db"))
                params]}))

(re-frame/reg-event-db
  :toggle-drawer
  (fn [db _]
    (update db ::db/drawer #(not %))))

(re-frame/reg-event-db
  :menu-toggle
  (fn [db event]
    (update-in db [::db/menu-expanded (second event)] #(not %))))

(re-frame/reg-event-db
  :navigate
  (fn [db event]
    (assoc db ::db/drawer false)))


