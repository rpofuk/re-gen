(ns projectname.core
  (:require [edd.core :as core]
            [projectname.i18n :as i18n]
            [projectname.styles :refer [theme styles]]
            [projectname.home.views :as home]
            [projectname.about.views :as about]))



(defn ^:export init
  [config]
  (core/init
    {:config       (js->clj config)
     :panels       {:home  home/main-panel
                    :about about/main-panel}
     :languages    [:en :de]
     :translations i18n/translations
     :routes       ["/" {""             :home
                         [:id "/about"] :about}]
     :menu         [:home :about]
     :theme        (theme)
     :styles       styles
     :name         "projetname"}))
