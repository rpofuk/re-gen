(ns edd.routing
  (:require
   [bidi.bidi :as bidi]))

(defn path-for
  [routes page & [params]]
  (apply (partial bidi/path-for routes page)
         params))
