(ns tweetah.core
  (:require [oauth.client :as oauth]
            [clj-http.client :as client]
            )
  )


(defn init []
  (def creds (load-file "creds.twitter")))

(def consumer (oauth/make-consumer (creds :consumer-key)
                                   (creds :consumer-secret)
                                   "http://api.twitter.com/oauth/request_token"
                                   "http://api.twitter.com/oauth/access_token"
                                   "http://api.twitter.com/oauth/authorize"
                                   :hmac-sha1))

(def request-token (oauth/request-token consumer))

(defn get-verify-url [] (oauth/user-approval-uri
                         consumer 
                         (:oauth_token request-token)))

(defn get-access-token-response [] (oauth/access-token consumer 
                                                       request-token
                                                       "PIN from hitting the verify URL above"))

; This is defined once, then you're done; ^ above ceremony is for getting to this
(def access-token-response (creds :access-token-response))

(defn sign-home-feed []
  (oauth/credentials consumer
                     (:oauth_token access-token-response)
                     (:oauth_token_secret access-token-response)
                     :GET
                     "https://api.twitter.com/1.1/statuses/home_timeline.json"))

(defn get-home-feed []
  (client/get "https://api.twitter.com/1.1/statuses/home_timeline.json"
              :query-params (sign-home-feed)))


