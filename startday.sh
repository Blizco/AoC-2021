#!/usr/bin/env bash

YEAR=$1
DAY=$2

touch $YEAR/src/main/java/com/buildfunthings/aoc/days/Day$(printf %02d $DAY).java
touch $YEAR/src/main/resources/Day$(printf %02d $DAY).txt
touch $YEAR/src/test/java/com/buildfunthings/aoc/days/Day$(printf %02d $DAY)Test.java
touch $YEAR/src/test/resources/input-$(printf %02d $DAY).txt
