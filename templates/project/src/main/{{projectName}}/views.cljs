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
            ["@material-ui/icons/Menu" :default MenuIcon]))



(def components
  {:home  home/main-panel
   :about about/main-panel})


(defn page
  [classes]
  [:div {:class-name (:root classes)}
   [:> AppBar {:position "static"}

    [:> Toolbar
     [:> IconButton {:edge "start" :bel "Menu"}
      [:> MenuIcon]
      ]

     [:> Typography {:variant "h6" :class-name (:title classes)} "Imhere"]
     [:> Button "Login"]]]
   [:div
    (util/placeholder components classes)
    [:nav
     [:ul
       [:li
        [:> Button {:href "/"} "Home"]]
       [:li
        [:> Button {:href "/about"} "About"]]
       ]
     ]

    ]]

  )




