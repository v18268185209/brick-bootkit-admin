#!/usr/bin/env sh
set -eu

MVN_BIN="mvn"
if ! command -v "$MVN_BIN" >/dev/null 2>&1; then
  IDEA_MVN="/d/Program Files/IntelliJ IDEA 2025.3.3/plugins/maven/lib/maven3/bin/mvn.cmd"
  if [ -x "$IDEA_MVN" ]; then
    MVN_BIN="$IDEA_MVN"
  else
    echo "Maven was not found in PATH." >&2
    exit 1
  fi
fi

exec "$MVN_BIN" clean deploy -Prelease -f pom.xml "$@"
