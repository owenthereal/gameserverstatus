(ns gameserverstatus.games.d3
  (:use net.cgrand.enlive-html)
  (:import java.net.URL))

(defn fetch-status []
  (let [:america-status (-> "http://us.battle.net/d3/en/status"
                          URL.
                          html-resource
                          (select [:div :.status-icon])
                          first
                          :attrs
                          :data-tooltip)]
    ))
