(ns {{projectName}}.views
  (:require [re-frame.core :as rf]
            [{{projectName}}.subs :as subs]
            [goog.object :as gobj]
            [reagent.core :as r]
            [{{projectName}}.events :as events]
            [{{projectName}}.routes :as routes]
            [{{projectName}}.home.views :as home]
            ["@material-ui/icons/Menu" :default MenuIcon]
            ["@material-ui/core/AppBar" :default AppBar]
            ["@material-ui/core/Toolbar" :default Toolbar]
            ["@material-ui/core/Typography" :default Typography]
            ["@material-ui/core/Button" :default Button]
            ["@material-ui/core/IconButton" :default IconButton]
            ["@material-ui/icons/Menu" :default MenuIcon]))



(defn about []
  [:h2 "About"])

(def components
  {:home  home/main-panel
   :about about})

(defn component
  []
  (let [panel @(rf/subscribe [::subs/active-panel])]
    (if (contains? components panel)
      ((panel components))
      [:h2 "Loading"])
    )
  )



(defn page
  []
  (routes/app-routes)
  [:div

   [:> AppBar {:position "static"}
    [:> Toolbar
     [:> IconButton {:edge "start" :bel "Menu"}
      [:> MenuIcon]
      ]
     [:> Typography {:variant "h6"} "Imhere"]
     [:> Button "Login"]]]
   [:div
    (component)
    [:nav
     [:ul
      [:li
       [:> Button {:href "/"} "Home"]]
      [:li
       [:> Button {:href "/about"} "About"]]
      ]]
    ]])



