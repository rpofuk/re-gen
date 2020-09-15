(ns projectname.about.events
  (:require
   [re-frame.core :as re-frame]
   [projectname.about.db :as db]))

(re-frame/reg-event-db
 :initialize-about-db
 (fn [db _]
   (merge db db/default-db)))

(re-frame/reg-event-db
 ::click
 (fn [db _]
   (update-in db [::db/clicks] inc)))
