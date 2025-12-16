#!/bin/sh
# Licensed to the Apache Software Foundation (ASF)

set -e

PRG="$0"
while [ -h "$PRG" ] ; do
  ls=$(ls -ld "$PRG")
  link=$(expr "$ls" : '.*-> \(.*\)$')
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=$(dirname "$PRG")/"$link"
  fi
done

MAVEN_HOME=$(dirname "$PRG")/../
exec "$MAVEN_HOME/bin/mvn" "$@"

