#!/bin/bash

mvn clean package
JAR=$(basename target/JapaneseDictionary-*.jar)

jpackage --type deb \
--dest output \
--name JapaneseDictionary \
--input target \
--main-jar "$JAR" \
--main-class japanese_dictionary.JapaneseDictionary \
--icon app-icon.png \
--app-version "$1" \
--vendor "SuperAnand" \
--description "A Local SQLite Powered Japanese Kanji Dictionary" \
--linux-menu-group Education \
--linux-app-category Education \
--linux-shortcut \
