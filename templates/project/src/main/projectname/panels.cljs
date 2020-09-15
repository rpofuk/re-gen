(ns projectname.panels
  (:require
    [projectname.home.views :as home]
    [projectname.about.views :as about]))

(def pages
  {:home  home/main-panel
   :about about/main-panel})
