(ns gameserverstatus.main
  (:require [gameserverstatus.games.d3 :as d3]))

(defn -main []
  (println (d3/fetch-status)))
