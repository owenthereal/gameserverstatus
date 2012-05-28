(ns gameserverstatus.main
  (:use [lamina core])
  (:use [aleph http])
  (:require [gameserverstatus.games.d3 :as d3]))

(defn hello-world [channel request]
  (enqueue channel
           {:status 200
            :headers {"content-type" "text/html"}
            :body "Hello World!"}))

(defn -main []
  (let [port (Integer/parseInt (or (System/getenv "PORT") 8080))]
    (start-http-server hello-world {:port port})))
