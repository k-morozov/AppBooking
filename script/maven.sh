#!/bin/bash
mvn archetype:generate -DgroupId=com.appbooking -DartifactId=AppBooking -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn exec:java -Dexec.mainClass="com.appbooking.App"