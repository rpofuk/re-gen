(ns projectname.styles
  (:require
    ["@material-ui/core/colors/pink" :refer [pink]]))

(defn theme
  []
  {:palette {:primary   {"main" "rgba(255, 234, 0, 0.87)"}
             :secondary {"main" "rgba(255, 224, 225, 0.86)"}}})

(defn styles
  [theme]
  {:root                        {:flexGrow 1
                                 "& p"     {"color"  "green"
                                            "& span" {"color" "blue"}}}

   :page                        {}
   :app-bar                     {:background-size "contain"}

   :drawer-profile              {:background-image "url('images/drawer.jpg')"
                                 :height           380
                                 :background-size  "cover"}
   :drawer-list                 {:width            250
                                 "& .MuiList-root" {:padding-top 0}}

   :nested                      {}
   :title                       {:flexGrow 1}
   :card-media                  {:height      0
                                 :padding-top "50%"}
   :card-expand-button          {:transform   "rotate(0deg)"
                                 :margin-left "auto"}
   :card-expand-button-expanded {:transform   "rotate(180deg)"
                                 :margin-left "auto"}})