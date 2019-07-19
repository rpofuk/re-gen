(ns {{projectName}}.{{pageName}}.views
  (:require [re-frame.core :as rf]
            [{{projectName}}.{{pageName}}.subs :as subs]
            [{{projectName}}.{{pageName}}.events :as events]

            [goog.object :as gobj]
            [reagent.core :as r]

            ))




(defn main-panel []
  [:h2 "{{pageName}}"])

(def {{pageName}} (r/reactify-component main-panel))






