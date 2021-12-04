#!/usr/bin/env bash

YEAR=$1
DAY=$2

mkdir -p aoc-$YEAR/src/main/java/nl/arjenwiersma/aoc/days
touch aoc-$YEAR/src/main/java/nl/arjenwiersma/aoc/days/Day$(printf %02d $DAY).java
mkdir -p aoc-$YEAR/src/main/resources
touch aoc-$YEAR/src/main/resources/Day$(printf %02d $DAY).txt
mkdir -p aoc-$YEAR/src/test/java/nl/arjenwiersma/aoc/days
touch aoc-$YEAR/src/test/java/nl/arjenwiersma/aoc/days/Day$(printf %02d $DAY)Test.java
mkdir -p aoc-$YEAR/src/test/resources
touch aoc-$YEAR/src/test/resources/input-$(printf %02d $DAY).txt
