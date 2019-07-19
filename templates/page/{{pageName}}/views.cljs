(ns {{projectName}}.home.views
  (:require [re-frame.core :as rf]
            [{{projectName}}.home.subs :as subs]
            [{{projectName}}.home.events :as events]

            [goog.object :as gobj]
            [reagent.core :as r]

            ))




(defn main-panel []
  [:h2 "Hpme"])

(def home (r/reactify-component main-panel))






