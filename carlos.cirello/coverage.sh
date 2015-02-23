#!/bin/sh
set -e

workdir=.cover
profile="$workdir/cover.out"
mode=set

generateCoverData() {
    for package in "$@"; do
        f="$workdir/$(echo $package | tr / _).cover"
        go test -covermode="$mode" -coverprofile="$f" "$package"
    done

    echo "mode: $mode" >"$profile"
    grep -h -v "^mode:" "$workdir"/*.cover >>"$profile"
}

showCoverReport() {
    go tool cover -${1}="$profile"
}

rm -rf "$workdir"
mkdir "$workdir"
generateCoverData $(go list ./...)
# showCoverReport func
showCoverReport html
rm -rf "$workdir"