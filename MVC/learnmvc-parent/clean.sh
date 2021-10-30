#!/bin/bash

echo "clean ..."
# rm learnmvc-api
rm -rf learnmvc-api/src/

# rm learnmvc-api-test
rm -rf learnmvc-api-test/src/main/
rm -rf learnmvc-api-test/src/test/java/
rm -rf learnmvc-api-test/src/test/resources/testng.xml
rm -rf learnmvc-api-test/src/test/data/

# rm learnmvc-base
rm -rf learnmvc-base/src/

# rm learnmvc-api
rm -rf learnmvc-api/src/

# rm learnmvc-bundle
rm -rf learnmvc-bundle/src/

# rm learnmvc-bundle-mock
rm -rf learnmvc-bundle-mock/src/

mvn clean
echo "clean done."