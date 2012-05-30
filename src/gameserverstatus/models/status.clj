(ns gameserverstatus.models.status
  (:use [korma.db])
  (:require [clojure.string :as str])
  (:require [gameserverstatus.config.db :as config]))

(defdb db (postgres config/db-spec))

(defn hyphenate [word]
  (-> word
    str/trim
    (str/replace #"(\s+|-|_)" "-")
    str/lower-case))

(defn game-key [name]
  (str "games:" name))
