(ns personal-management.handlers
  (:require [personal-management.views :as views]
            [compojure.core :refer :all]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/"
       []
       (views/home-page))
  (GET "/add-task"
       []
       (views/add-task-page))
  (POST "/add-task"
        {params :params}
        (views/add-task-results-page params))
  (GET "/task/:loc-id"
       [task-id]
       (views/task-page task-id))
  (GET "/all-tasks"
       []
       (views/all-tasks-page))
  (route/resources "/")
  (route/not-found "Not Found"))