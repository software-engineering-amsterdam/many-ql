rm -rf src/org/uva/student/calinwouter/ql/generated
java -jar sablecc3/sablecc-3.7/lib/sablecc.jar ql.sablecc3
cp -r org src
rm -rf org
