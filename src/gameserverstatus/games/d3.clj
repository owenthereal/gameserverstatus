(ns gameserverstatus.games.d3
  (:use net.cgrand.enlive-html)
  (:import java.net.URL))

(defn parse-d3-status [s]
  (cond
    (= s "Available") "Up"
    (= s "Mainentance") "Down"
    :else "Unknown"))

(defn fetch-status []
  (let [america-status (-> "http://us.battle.net/d3/en/status"
                         URL.
                         html-resource
                         (select [:div :.status-icon])
                         first
                         :attrs
                         :data-tooltip)
        parsed-america-status (parse-d3-status america-status)]
    (list {:game "diablo-3", :server "/amercia/game-server", :status parsed-america-status})))
