(ns {{projectName}}.styles)

(def rules
  {:root  {
           :flexGrow 1
           "& p"     {
                      "color"  "green"
                      "& span" {
                                "color" "blue"
                                }
                      }}
   :page  {}
   :title {
           :flexGrow 1
           }})