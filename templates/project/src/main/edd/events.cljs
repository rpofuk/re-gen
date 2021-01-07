(ns edd.events
  (:import goog.history.Html5History)
  (:require
    [re-frame.core :as rf]
    [edd.db :as db]))

(rf/reg-event-db
  ::initialize-db
  (fn [db [_ {:keys [config languages translations] :or {languages [:en "English"]}}]]
    (-> db
        (merge db/default-db)
        (update ::db/config #(merge % config))
        (update ::db/languages #(vec (concat % languages)))
        (update ::db/translations #(merge % translations))
        (assoc ::db/selected-language (first languages)))))


(rf/reg-event-fx
  ::set-active-panel
  (fn [{:keys [db]} [_ page & [params]]]
    {:db (assoc db ::db/active-panel page
                   ::db/drawer false)
     :fx [[:dispatch [(keyword (str "initialize-" (name page) "-db"))
                      params]]]}))

(rf/reg-event-db
  ::toggle-drawer
  (fn [db _]
    (update db ::db/drawer #(not %))))

(rf/reg-event-db
  ::change-language
  (fn [db [_ value]]
    (assoc db ::db/selected-language value)))

(rf/reg-event-db
  :menu-toggle
  (fn [db event]
    (update-in db [::db/menu-expanded (second event)] #(not %))))

(rf/reg-event-db
  :add-translation
  (fn [db [_ body]]
    (update-in db [::db/i18n] #(merge body))))


(rf/reg-event-db
  ::register-menu-item
  (fn [db [_ {:keys [key] :as item}]]
    (assoc db [::db/menu key] item)))


