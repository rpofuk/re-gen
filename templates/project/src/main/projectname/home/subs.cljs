(ns projectname.home.subs
  (:require
   [projectname.home.db :as db]
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (::db/name db)))

(re-frame/reg-sub
 ::clicks
 (fn [db]
   (::db/clicks db)))


