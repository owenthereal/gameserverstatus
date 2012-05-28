(ns gameserverstatus.main
  (:use [lamina core])
  (:use [aleph http])
  (:use [clojure.data [json :only [json-str]]])
  (:require [gameserverstatus.games.d3 :as d3]))

(defn hello-world [channel request]
  (enqueue channel
           {:status 200
            :headers {"content-type" "application/json"}
            :body (json-str (d3/fetch-status))}))

(defn -main []
  (let [port (Integer/parseInt (or (System/getenv "PORT") "8080"))]
    (start-http-server hello-world {:port port})))
