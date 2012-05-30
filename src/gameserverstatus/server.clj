(ns gameserverstatus.server
  (:use [korma.db])
  (:require [noir.server :as server]))

(server/load-views "src/gameserverstatus/views/")

(defn gameserverstatus [& [env]]
  (let [mode (keyword (or env :dev))
        port (Integer.
               (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'gameserverstatus})))

(defn -main [& args]
  (gameserverstatus (first args)))
