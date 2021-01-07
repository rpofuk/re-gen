(ns projectname.i18n
  (:require [edd.i18n :as i18n]))

(def translations
  {:languages    {:en {:en "English"
                       :de "Englisch"}
                  :de {:en "German"
                       :de "Deutsch"}}
   :menu         {:home  {:en "Home"
                          :de "Home"}
                  :about {:en "About"
                          :de "Úber uns"}}
   :language     {:en "Language"
                  :de "Sprache"}
   :about        {:en "About"
                  :de "Űber uns"}
   :home         {:en "Home"
                  :de "Home"}
   :welcome-home {:en "Welcome home"
                  :de "Willkommen"}})
