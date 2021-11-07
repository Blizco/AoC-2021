#!/bin/bash

YEAR=$1
DAY=$(printf %02d $2)

TARGET=$YEAR/src/main/java/com/buildfunthings/aoc/days/Day$DAY.java

if [ -f "$TARGET" ]; then
    echo "Watching for changes in $TARGET (update Day$DAY.java to run its tests)"
else 
    echo "$TARGET does not exist, exiting"
    exit
fi

inotifywait -q -m -e close_write $TARGET |
    while read -r filename event; do
        ./mvnw -q clean test -pl $YEAR -Dtest="com.buildfunthings.aoc.days.Day${DAY}Test"
    done
