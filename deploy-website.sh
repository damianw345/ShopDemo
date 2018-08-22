#!/bin/bash

# kill http-server run by nodejs
ssh ubuntu@aws "kill $(pgrep node); rm -r website/;"

#copy updated website folder
scp -rp website ubuntu@aws:~/

#run http-server
ssh ubuntu@aws "http-server ./website -p 8081 -c10 http.log 2>&1 &"
