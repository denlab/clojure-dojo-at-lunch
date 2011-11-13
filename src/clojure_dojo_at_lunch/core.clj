(ns clojure-dojo-at-lunch.core
  (:use     [midje.sweet])
  (:use     [clojure.pprint :only [pprint]])
  (:use     [clojure.walk   :only [walk macroexpand-all]])
  (:require [clojure.set     :as set])
  (:import (java.text SimpleDateFormat))
  (:import (java.util Date)))

;; ----------------------------------------------------------------------------
;; DOJO 20111109
;; ----------------------------------------------------------------------------

;; ----------------------------------------------------------------------------
;; From 4clojure.com:
;;
;; generate the power set of the given set (all permutations)

(defn power-set "Generate the power set of the given set (all permutations)"
  ([s]
     (set (conj
           (if (empty? s)
             #{}
             (let [pset (power-set (rest s))]
               (concat (map (fn [one-set] (conj one-set (first s))) pset)
                       pset)))
           #{}))))

;.;. This is the future you were hoping for. -- @Vaguery
(fact
 (power-set #{1 2 3}) => #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})

(fact
 (power-set #{1 2}) => #{#{} #{1} #{2} #{1 2}})

(fact
 (power-set #{1}) => #{#{} #{1}})

(fact
 (power-set #{}) => #{#{}})

(println "--------- END OF DOJO ----------" (java.util.Date.))
