# personal-management

A small web application written in clojure for personal management and capable of running on raspberry pi using docker and kuberenetes.

## Usage

lein uberjar
lein run

docker build -t umerkayani/personal-management:v3 .
docker run -d -p 8080:4000 umerkayani/personal-management:v3

## License

Copyright © 2018 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
