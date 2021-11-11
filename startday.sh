#!/usr/bin/env bash

YEAR=$1
DAY=$2

mkdir -p $YEAR/src/main/java/com/buildfunthings/aoc/days
touch $YEAR/src/main/java/com/buildfunthings/aoc/days/Day$(printf %02d $DAY).java
mkdir -p $YEAR/src/main/resources
touch $YEAR/src/main/resources/Day$(printf %02d $DAY).txt
mkdir -p $YEAR/src/test/java/com/buildfunthings/aoc/days
touch $YEAR/src/test/java/com/buildfunthings/aoc/days/Day$(printf %02d $DAY)Test.java
mkdir -p $YEAR/src/test/resources
touch $YEAR/src/test/resources/input-$(printf %02d $DAY).txt
