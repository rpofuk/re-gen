#!/bin/bash 

rm -rf templates/project/.shadow-cljs
rm -rf templates/project/node_modules
rm -rf templates/project/.cpcache
rm -rf templates/project/resources/public/js
rm -rf templates/project/.idea
rm -rf templates/project/*.iml

sudo npm install -g ./
