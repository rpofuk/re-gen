(ns {{projectName}}.styles)

(def rules
  {:root  {
           :flexGrow 1
           "& p"     {
                      "color"  "green"
                      "& span" {
                                "color" "blue"
                                }}}
   :title {
           :flexGrow 1
           }})