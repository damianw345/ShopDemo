#!/bin/bash

./gradlew build

echo 'killing running java process and removing old jar...'
ssh ubuntu@aws "kill $(pgrep java); rm shop-demo.jar;"

echo 'sending new jar to the server...'
scp build/libs/shop-demo-0.0.1-SNAPSHOT.jar ubuntu@aws:shop-demo.jar

echo 'running new jar on the server'
ssh ubuntu@aws "screen -d -m java -jar shop-demo.jar;"
