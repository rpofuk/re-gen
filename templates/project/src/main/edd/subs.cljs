(ns edd.subs
  (:require
    [edd.db :as db]
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

(re-frame/reg-sub
  ::translations
  (fn [db]
    (::db/translations db)))

(re-frame/reg-sub
  ::languages
  (fn [db]
    (::db/languages db)))

(re-frame/reg-sub
  ::selected-language
  (fn [db]
    (::db/selected-language db)))


(re-frame/reg-sub
  ::menu-items
  (fn [db]
    (::db/menu-items db)))

