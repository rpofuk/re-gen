(ns edd.views

  (:require [re-frame.core :as rf]
            [edd.subs :as subs]
            [reagent.core :as r]
            [edd.events :as events]
            [edd.util :as util]
            [edd.routing :refer [path-for]]
            [edd.i18n :refer [tr]]
            [reagent.core :as reagent]

            ["@material-ui/core/AppBar" :default AppBar]
            ["@material-ui/core/Toolbar" :default Toolbar]
            ["@material-ui/core/Typography" :default Typography]
            ["@material-ui/core/Button" :default Button]
            ["@material-ui/core/IconButton" :default IconButton]
            ["@material-ui/core/Drawer" :default Drawer]
            ["@material-ui/core/List" :default List]
            ["@material-ui/core/ListItem" :default ListItem]
            ["@material-ui/core/ListItemText" :default ListItemText]
            ["@material-ui/core/ListItemIcon" :default ListItemIcon]
            ["@material-ui/core/ListSubheader" :default ListSubheader]
            ["@material-ui/core/Grid" :default Grid]
            ["@material-ui/core/Collapse" :default Collapse]

            ["@material-ui/icons/ChevronRight" :default ChevronRight]
            ["@material-ui/icons/StarBorder" :default StarBorder]

            ["@material-ui/icons/KeyboardArrowRight" :default KeyboardArrowRightIcon]



            ["@material-ui/core/FormControl" :default FormControl]
            ["@material-ui/core/FormHelperText" :default FormHelperText]
            ["@material-ui/core/Select" :default Select]
            ["@material-ui/core/InputLabel" :default InputLabel]
            ["@material-ui/core/MenuItem" :default MenuItem]
            ["@material-ui/icons/Menu" :default MenuIcon]))

(defn menu-item
  [{:keys [classes]} item]
  [:> Grid {:item true
            :xs   12}
   [:> Button {:on-click   #(rf/dispatch [::events/set-active-panel item])
               :key        item
               :class-name (:nested classes)
               :start-icon (reagent/as-element [:> KeyboardArrowRightIcon])}
    (tr [:menu item])]])


(defn drawer
  [{:keys [classes menu] :as ctx}]
  [:> Drawer {:open     @(rf/subscribe [::subs/drawer])
              :on-close #(rf/dispatch [::events/toggle-drawer])}

   [:div {:class-name (:drawer-list classes)
          :role       "presentation"}

    [:> Grid {:container true}
     [:> Grid {:item true
               :xs   12}]
     [:> Grid {:item true
               :xs   1}]
     [:> Grid {:item true
               :xs   10}
      (into
        [:> Grid {:container true
                  :item      true
                  :spacing   1}

         [:> Grid {:item true
                   :xs   12}
          [:> FormControl
           (let [langs @(rf/subscribe [::subs/languages])]
             (into [:> Select {:value     @(rf/subscribe [::subs/selected-language])
                               :on-change #(rf/dispatch [::events/change-language (-> (.-target %) (.-value) (keyword))])}]
                   (map
                     (fn [l]
                       [:> MenuItem {:value l} (tr [:languages l])])
                     langs)))

           [:> FormHelperText (tr :language)]
           ]]]
        ; filter here for example non public pages
        (let [menu-items menu]
          (map
            (fn [item]
              (menu-item ctx item))
            menu-items)))]]]])

(defn page
  [{:keys [classes panels] :as ctx}]

  (if @(rf/subscribe [::subs/ready])
    [:div {:class-name (:root classes)}
     @(rf/subscribe [::subs/ready])
     (drawer ctx)
     [:> Grid {:container  true
               :class-name (:root classes)}
      [:> Grid {:item true
                :xs   12 :class-name (:header classes)}
       [:> AppBar {:class-name (:app-bar classes)
                   :position   "static"}

        [:> Toolbar
         [:> IconButton {:edge     "start"
                         :bel      "Menu"
                         :on-click #(rf/dispatch [::events/toggle-drawer])}
          [:> MenuIcon]]

         [:> Grid {:container true
                   :direction "row-reverse"}
          [:> Grid {:item true}
           "Login Placeholder"]]]]]

      [:> Grid {:container true}
       (util/placeholder panels classes)]]]
    [:> Grid {:container true :item true} "Loading"]))




