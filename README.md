# mmdist-java-avx2

Euclidian distance implementation leveraging the Java Vector API and AVX-compatible CPUs. Inspired on https://blog.cloudflare.com/computing-euclidean-distance-on-144-dimensions/.

## Prerequisites

* OpenJDK 7+
* Gradle 7+
* CPU supporting the SIMD instruction set

## Preparing the environment

Point the JAVA_HOME environment variable to the directory of the selected JDK 
For example: 

$ export JAVA_HOME=/usr/local/Cellar/openjdk@17/17.0.6 

## Run the unit tests

Run the following command: 

$ gradle test

## Run the benchmarking suite 

$ gradle jmh

## Benchmarking options 

The Java Microbenchmark Harness (JMH) plugin for Gradle exposes a substantial number of options that allow customizing the benchmarking.
Please refer to 'jmh' section within the 'build.gradle' file. For more information refer to https://github.com/melix/jmh-gradle-plugin#configuration-options.








