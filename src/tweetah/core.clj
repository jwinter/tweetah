(ns tweetah.core
  (:require [oauth.client :as oauth])
  )


(defn init []
  (def creds (load-file "creds.twitter"))
  
  )

;(def consumer [consumer-token consumer-token-secret]
;  (oauth/make-consumer
  
