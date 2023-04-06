#!/bin/bash

# -Xms64m -Xmx512M -XX:ActiveProcessorCount=1 -XX:+ExitOnOutOfMemoryError -Xlog:gc -Dfile.encoding=UTF-8 
# -XX:MinHeapFreeRatio=10 -XX:MaxHeapFreeRatio=20 -XX:GCTimeRatio=4 -XX:AdaptiveSizePolicyWeight=90 -XX:+ExitOnOutOfMemoryError -XX:+PrintGCDetails
# NATIVE: -XX:+UnlockDiagnosticVMOptions -XX:+PrintNMTStatistics -XX:+PrintGCDetails
# -XX:+UseZGC
# -XX:+UseG1GC 

mvn clean package -Dmaven.test.skip=true

export JAVA_OPTS=" -Xmx128M -XX:+UseZGC -Xlog:gc -XX:+ExitOnOutOfMemoryError"
java $JAVA_OPTS -jar target/quarkus-app/quarkus-run.jar