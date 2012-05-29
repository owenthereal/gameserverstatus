(ns gameserverstatus.views.index
  (:require [gameserverstatus.views.common :as common])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/my-page" []
  (html
    [:h1 "This is my first page!"]))

(defpage "/" []
         (common/layout
           [:p "Welcome to gameserverstatus"]))
