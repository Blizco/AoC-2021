#!/bin/bash

YEAR=$1
DAY=$(printf %02d $2)

TARGET=$YEAR/src/main/java/com/buildfunthings/aoc/days/Day$2.java

if [ -f "$TARGET" ]; then
    echo "Watching for changes in $TARGET"
else 
    echo "$TARGET does not exist, exiting"
    exit
fi

inotifywait -q -m -e close_write $TARGET |
    while read -r filename event; do
        ./mvnw -q exec:java -pl $YEAR -Dexec.mainClass="com.buildfunthings.aoc.days.Day$DAY"
    done
