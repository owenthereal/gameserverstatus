(ns gameserverstatus.main
  (:require [gameserverstatus.config.db :as db]))

(defn -main []
  (println @(db/redis [:smembers :servers])))
