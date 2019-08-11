(ns {{projectName}}.routes
  (:require
    [re-frame.core :as re-frame]
    [{{projectName}}.events :as events]))

(def routes ["/" {""      :home
                  "about" :about}])

