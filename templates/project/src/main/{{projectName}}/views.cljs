(ns {{projectName}}.views

  (:require [re-frame.core :as rf]
    [{{projectName}}.subs :as subs]
    [reagent.core :as r]
    [{{projectName}}.events :as events]
    [{{projectName}}.util :as util]
    [{{projectName}}.routes :as routes]
    [{{projectName}}.home.views :as home]
    [{{projectName}}.about.views :as about]

    ["@material-ui/icons/Menu" :default MenuIcon]
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
    ["@material-ui/core/Grid" :default Grid]

    ["@material-ui/icons/ChevronRight" :default ChevronRight]
    ["@material-ui/icons/StarBorder" :default StarBorder]
    ["@material-ui/icons/Menu" :default MenuIcon]))



(def components
  {:home  home/main-panel
   :about about/main-panel})




(defn menu-item
  [item classes]
  (let [expanded @(rf/subscribe [::subs/menu-expanded])]
    [:> ListItem {:button     true
                  :href       (routes/path-for (:key item))
                  :component  "a"
                  :on-click   (fn [e]
                                (.preventDefault e))
                  :key        (:key item)
                  :class-name (:nested classes)}
     [:> ListItemIcon
      [:> StarBorder]]
     [:> ListItemText {:primary (:name item)}]
     ]))



(defn menu
  []
  [{
    :key  :home
    :name "Home"}
   {:key  :about
    :name "About"
    }])



(defn drawer
  [classes]
  [:> Drawer {:open     @(rf/subscribe [::subs/drawer])
              :on-close #(rf/dispatch [::events/toggle-drawer])}

   [:div {:class-name (:drawer-list classes)
          :role       "presentation"}

    (into [] (concat
               [:> List {:component "nav"}]
               (for [item (menu)]
                 (menu-item item classes))))
    ]])

(defn page
  [classes]

  (if @(rf/subscribe [::subs/ready])
    [:div {:class-name (:root classes)}
     @(rf/subscribe [::subs/ready])
     (drawer classes)
     [:> Grid {:container  true
               :class-name (:root classes)
               :spacing    1}
      [:> Grid {:item true
                :xs   12}
       [:> AppBar {:class-name (:app-bar classes)
                   :position   "static"}

        [:> Toolbar
         [:> IconButton {:edge     "start"
                         :bel      "Menu"
                         :on-click #(rf/dispatch [::events/toggle-drawer])}
          [:> MenuIcon]
          ]

         [:> Typography {:variant "h6" :class-name (:title classes)} "{{projectName}}"]
         [:> Grid {:container true
                   :direction "row-reverse"
                   :spacing   3}
          [:> Grid {:item true}
           [:> Button "Login"]]
          [:> Grid {:item true}
           [:> Button {:variant "contained"
                       :color   "secondary"} "Register"]]]]]]

      [:div {:style {:margin "16px"}}
       (util/placeholder components classes)]]]
    [:div "Loading"]))




