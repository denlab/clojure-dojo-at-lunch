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
  ([s] (conj (set
              (if (empty? s)
                #{}
                (map #(conj % (first s))
                     (power-set (rest s)))))
             #{})))

(fact
 (power-set #{1 2}) => #{#{} #{1} #{2} #{1 2}})

(fact
 (power-set #{1}) => #{#{} #{1}})

(fact
 (power-set #{}) => #{#{}})

(println "--------- END OF DOJO ----------" (java.util.Date.))
