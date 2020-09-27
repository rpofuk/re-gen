(ns projectname.routes)

(defn routes
  []
  ["/" {""             :home
        [:id "/about"] :about}])


