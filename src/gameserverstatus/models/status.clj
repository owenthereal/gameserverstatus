(ns gameserverstatus.models.status
  (:require [clojure.string :as str]))

(defn hyphenate [word]
  (-> word
    str/trim
    (str/replace #"(\s+|-|_)" "-")
    str/lower-case))

(defn game-key [name]
  (str "games:" name))
