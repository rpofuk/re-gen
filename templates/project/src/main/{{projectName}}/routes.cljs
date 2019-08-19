(ns {{projectName}}.routes
  (:require
    [re-frame.core :as re-frame]
    [bidi.bidi :as bidi] ))



(def routes ["/" {""      :home
                  "about" :about}])


(defn path-for
  [page]
  (bidi/path-for routes page))
