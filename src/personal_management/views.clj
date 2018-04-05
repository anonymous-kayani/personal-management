(ns personal-management.views
  (:require #_[personal-management.db :as db]
            [clojure.string :as str]
            [hiccup.page :as page]
            #_[ring.util.anti-forgery :as util]))

(defn gen-page-head
  [title]
  [:head
   [:title (str "Tasks: " title)]
   (page/include-css "/css/styles.css")])

(def header-links
  [:div#header-links
   "[ "
   [:a {:href "/"} "Home"]
   " | "
   [:a {:href "/add-task"} "Add a Task"]
   " | "
   [:a {:href "/all-tasks"} "View All Tasks"]
   " ]"])

(defn home-page
  []
  (page/html5
   (gen-page-head "Home")
   header-links
   [:h1 "Home"]
   [:p "A Webapp for storing and viewing Tasks."]))

(defn add-task-page
  []
  (page/html5
   (gen-page-head "Add a Task")
   header-links
   [:h1 "Add a Task"]
   [:form {:action "/add-task" :method "POST"}
    [:p "Description:  " [:input {:type "text" :name "x"}]]
    [:p "Hours req.: " [:input {:type "text" :name "y"}]]
    [:p [:input {:type "submit" :value "submit task"}]]]))

(defn add-task-results-page
  [{:keys [x y]}]
  (let [id 1]
    (page/html5
     (gen-page-head "Added a Task")
     header-links
     [:h1 "Added a Task"]
     [:p "Added [" x ", " y "] (id: " id ") to the db. "
      [:a {:href (str "/task/" id)} "See for yourself"]
      "."])))

(defn task-page
  [task-id]
  (let [{x :x y :y} {:x 1 :y 2}]
    (page/html5
     (gen-page-head (str "Task " task-id))
     header-links
     [:h1 "A Single Task"]
     [:p "id: " task-id]
     [:p "Description: " x]
     [:p "Hours req.: " y])))

(defn all-tasks-page
  []
  (let [all-tasks [{:id 1 :x "Workout" :y "2 Hours"}]]
    (page/html5
     (gen-page-head "All tasks in the db")
     header-links
     [:h1 "All Tasks"]
     [:table
      [:tr [:th "id"] [:th "Desc."] [:th "Hours req."]]
      (for [task all-tasks]
        [:tr [:td (:id task)] [:td (:x task)] [:td (:y task)]])])))

