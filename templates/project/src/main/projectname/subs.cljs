(ns projectname.subs
  (:require
   [projectname.db :as db]
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
 ::drawer
 (fn [db]
   (::db/drawer db)))

(re-frame/reg-sub
 ::ready
 (fn [db]
   (::db/ready db)))

(re-frame/reg-sub
 ::menu-expanded
 (fn [db]
   (::db/menu-expanded db)))

