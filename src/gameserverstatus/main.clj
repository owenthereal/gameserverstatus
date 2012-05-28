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
  (start-http-server hello-world {:port 8080}))
