# clojurists-just-want-to-have-puns

Nice fun puns in Clojure

Takes a word and a list of phrases and generates puns like:
* the test of both worlds
* the test things in life are free
* hit me with your test shot

## Installation

Download jar file [here](https://github.com/SoftwareWarlock/clojirls-just-want-to-have-puns/releases/download/0.1.0/clojirls-just-want-to-have-puns-0.1.0-SNAPSHOT-standalone.jar)

## Usage

    $ java -jar clojurists-just-want-to-have-puns-0.1.0-standalone.jar [word] [phrases_file]

    *OR*, if you have Leiningen

    $ lein run test phrases/wikipedia-idioms.txt 

## Options

* `word` - the word to make a pun with
* `phrases_file` - the path to a file with a list of phrases in it (each phrase must be on its own line)

## Examples

    $ lein run test phrases/wikipedia-idioms.txt 
    => be my test (pun of be my guest)
       be one's test (pun of be one's guest)
       test interests at heart (pun of best interests at heart)
       test laid plans (pun of best laid plans)
       close to the test (pun of close to the vest)
    $ java -jar clojurists-just-want-to-have-puns-0.1.0-standalone.jar cat phrases/wikipedia-idioms.txt 
    => cat a thousand (pun of bat a thousand)
       cat an eye (pun of bat an eye)
       cat an eyelash (pun of bat an eyelash)
       cat five hundred (pun of bat five hundred)
       cat one's eyes (pun of bat one's eyes)
       big, cat, hairy deal (pun of big, fat, hairy deal)
       bite the hand cat feeds one (pun of bite the hand that feeds one)

## License

Copyright © 2015 SoftwareWarlock

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
