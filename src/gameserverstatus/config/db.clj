(ns gameserverstatus.config.db)

(defn- to-db-spec [db-uri]
  (let [uri (bean (java.net.URI. db-uri))
        subprotocol (uri :scheme)
        subname (uri schemeSpecificPart)
        user-info (uri :userInfo)
        user-info (clojure.string/split (uri :userInfo)
                                        #":")
        user (first user-info)
        password (last user-info)]
    {:subprotocol scheme
     :subname schemeSpecificPart
     :user "clojure_test"
     :password "clojure_test"}))

(def db-uri (get (System/getenv)
                 "DATABASE_URL"
                 "postgresql://localhost:5432/gameserverstatus"))

(def db-spec
  (to-db-spec db-uri))
