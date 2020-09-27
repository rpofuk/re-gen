(ns projectname.core
  (:require [edd.core :as core]
            [projectname.panels :refer [panels]]
            [projectname.routes :refer [routes]]
            [projectname.styles :refer [theme styles]]))



(defn ^:export init
  [config]
  (core/init
    {:config config
     :panels (panels)
     :routes (routes)
     :theme (theme)
     :styles styles
     :name "projetname"}))
