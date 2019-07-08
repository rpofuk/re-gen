(ns {{projectName}}.views
  (:require [re-frame.core :as rf]
            [{{projectName}}.subs :as subs]
            [goog.object :as gobj]
            [reagent.core :as r]
            ["react-router-dom" :refer (Route Link) :rename {BrowserRouter Router}]

            ["@material-ui/icons/Menu" :default MenuIcon]
            ["@material-ui/core/AppBar" :default AppBar]
            ["@material-ui/core/Toolbar" :default Toolbar]
            ["@material-ui/core/Typography" :default Typography]
            ["@material-ui/core/Button" :default Button]
            ["@material-ui/core/IconButton" :default IconButton]
            ["@material-ui/icons/Menu" :default MenuIcon]))


(defn index []
  [:h2 "Home"])

(defn users []
  [:h2 "Users"])

(defn about []
  [:h2 "About"])

(def Index (r/reactify-component index))
(def Users (r/reactify-component users))
(def About (r/reactify-component about))


(defn page
  []
  [:> Router
   [:> AppBar {:position "static"}
    [:> Toolbar
     [:> IconButton {:edge "start" :area-label "Menu"}
      [:> MenuIcon]
      ]
     [:> Typography {:variant "h6"} "Imhere"]
     [:> Button "Login"]]]
   [:div
    [:nav
     [:ul
      [:li
       [:> Link {:to "/"} "Home"]]
      [:li
       [:> Link {:to "/about/"} "About"]]
      [:li
       [:> Link {:to "/users/"} "Users"]]]]
    [:> Route {:path "/" :exact true :component Index}]
    [:> Route {:path "/about/" :component About}]
    [:> Route {:path "/users/" :component Users}]
    ]])



