(ns gameserverstatus.test.games.d3
  (:use [gameserverstatus.games.d3])
  (:use [clojure test pprint]))

(pprint (fetch-status))

(deftest test-fetch-status
         (pprint 
           (fetch-status)))
