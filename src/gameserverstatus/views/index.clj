(ns gameserverstatus.views.index
  (:require [gameserverstatus.views.common :as common])
  (:require [noir.response :as response])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(def games
  (list {:id 1, :name "Diablo 3"}
        {:id 2, :name "War of Warcraft"}))

(def servers
  {"1" {:id 1, :game-id 1, :name "Game Server (America)", :status "Up"}
   "2" {:id 2, :game-id 1, :name "Game Server (Europe)", :status "Down"}
   "3" {:id 3, :game-id 1, :name "Game Server (Asia)", :status "Unknown"}})

(defpage "/" []
         (common/layout
           [:p "Welcome to gameserverstatus"]))

(defpage "/games" []
         (response/json games))

(defpage "/servers/:id" {server-id :id}
         (if-let [server (servers server-id)]
           (response/json (servers server-id))
           (response/empty)))
