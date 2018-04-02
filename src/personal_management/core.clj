(ns personal-management.core
  (:require [ring.adapter.jetty :as jty])
  (:gen-class))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})

(defonce server-atom (atom :not-initialized))

(defn start [port]
  (reset! server-atom (jty/run-jetty #'handler {:port port :join? false})))

(defn stop []
  (.stop @server-atom))

(defn -main [& args]
  (start 4000))

