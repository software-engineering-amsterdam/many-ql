rm -rf src/main/java/org/uva/student/calinwouter/qlqls/generated
java -jar sablecc3/sablecc-3.7/lib/sablecc.jar qlqls.sablecc3
cp -r org src/main/java
rm -rf org
