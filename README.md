# tweetah

Command-line tools for reading twitter

## Usage

creds.twitter should look like (dummy data below):
{
 :consumer-key "oasijdfoajsodfj3892" ; not real, obviously
 :consumer-secret "aosjdfoijwoijfoiwejf32ijfo32ijfoij23ojf2oi3jf" ; also not real
 :verifier "123456" ; only used once, this is the PIN you get from 
 ; You get access-token-response by following the URL you get from get-verify-url
 ; You use the PIN that gives you in get-access-token-response
 :access-token-response { ; this is important and every time once you've got it
                         :oauth_token "USER_ID-291189382093029308409384",
                         :oauth_token_secret "asodifjoajoejfoiajewofj23323f",
                         :user_id "111122223333",
                         :screen_name "fake_rich_hickey"
                         }
 }



## License

Copyright © 2013 Joe Winter

Distributed under the Eclipse Public License, the same as Clojure.
