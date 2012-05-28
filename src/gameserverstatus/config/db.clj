(ns gameserverstatus.config.db
  (:use [aleph redis]))

(def redis-to-go-uri (System/getenv "REDISTOGO_URL"))

(defn parse-redis-uri [uri]
  (let [uri (bean (java.net.URI. uri))
        host (uri :host)
        port (uri :port)
        user-info (clojure.string/split (uri :userInfo)
                                        #":")
        password (last user-info)]
    {:host host
     :port port
     :password password}))

(def redis-options
  (if redis-to-go-uri
    (parse-redis-uri redis-to-go-uri)))

(def redis (redis-client redis-options))
