(ns projectname.panels
  (:require
    [projectname.home.views :as home]
    [projectname.about.views :as about]))

(defn panels
  []
  {:home  home/main-panel
   :about about/main-panel})
