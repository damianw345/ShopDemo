#!/bin/bash

./gradlew build
ssh ubuntu@aws -v "kill $(pgrep java); rm shop-demo.jar;"
scp ./build/libs/shop-demo-0.0.1-SNAPSHOT.jar ubuntu@aws:shop-demo.jar
ssh ubuntu@aws "screen -m -d java -jar shop-demo.jar;"

