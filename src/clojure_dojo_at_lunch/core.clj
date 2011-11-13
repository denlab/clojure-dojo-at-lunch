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

(defn power-set [s]
 (if (empty? s) #{#{}}
   (let [subset (power-set (next s))]
     (set (concat subset (map #(conj % (first s)) subset))))))

(fact
 (power-set #{1 2 3}) => #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})

;.;. Effort only fully releases its reward after a person refuses to quit.
;.;. -- Hill
(fact
 (power-set #{1 2}) => #{#{} #{1} #{2} #{1 2}})

(fact
 (power-set #{1}) => #{#{} #{1}})

(fact
 (power-set #{}) => #{#{}})

(println "--------- END OF DOJO ----------" (java.util.Date.))
