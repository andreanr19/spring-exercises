#!/bin/bash

echo "build ..."
if [ "local_bundle_mock" = $1 ] ; then
    mvn clean package -pl learnmvc-bundle-mock -am -Dbdmgc.skip=false -Dcodeg.author=fastjrun
elif [ "provider_mock" = $1 ] ; then
    mvn clean package -pl learnmvc-provider-mock -am -Dbdmgc.skip=false -Dcodeg.author=fastjrun
    cp learnmvc-provider-mock/target/learnmvc-provider-mock.war ~/server/tomcat8/webapps/learnmvc-provider-mock.war
elif [ "package_api_test" = $1 ] ; then
    mvn clean package -pl learnmvc-api-test -am -Dclientgc.skip=false -Dcodeg.author=fastjrun
elif [ "unitTest" = $1 ] ; then
    mvn clean verify -pl learnmvc-test -PunitTest -am
elif [ "mock_test" = $1 ] ; then
    mvn clean package -pl learnmvc-api-test -Dclientgc.skip=false -Dcodeg.author=fastjrun -Pmock
elif [ "package_provider" = $1 ] ; then
    mvn clean package -pl learnmvc-provider -am -Dbasegc.skip=false -Dbdgc.skip=false -Dcodeg.author=fastjrun -P$2
    cp learnmvc-provider/target/learnmvc-provider.war ~/server/tomcat8/webapps/learnmvc-provider.war
elif [ "api_test" = $1 ] ; then
    mvn clean package -pl learnmvc-api-test -Dclientgc.skip=false -Dcodeg.author=fastjrun -P$2
elif [ "package_task" = $1 ] ; then
    mvn clean package -pl learnmvc-task -am -Dbasegc.skip=false -Dbdgc.skip=false -Dcodeg.author=fastjrun -P$2
    rm -rf ~/app/learnmvc/learnmvc-task
    cp -r learnmvc-task/target/learnmvc-task/learnmvc-task ~/app/learnmvc/learnmvc-task
elif [ "package_ci" = $1 ] ; then
    mvn clean package -pl learnmvc-base -am -Dbasegc.skip=false -Dcodeg.author=fastjrun
    mvn clean package -pl learnmvc-bundle -am -Dbdgc.skip=false -Dcodeg.author=fastjrun
    mvn clean package -pl learnmvc-api-test -am -Dclientgc.skip=false -Dcodeg.author=fastjrun -Dmaven.test.skip=true
    mvn clean package -pl learnmvc-bundle-mock -am -Dbdmgc.skip=false -Dcodeg.author=fastjrun
    mvn clean package -pl learnmvc-api -am -Dapigc.skip=false -Dcodeg.author=fastjrun
elif [ "service_ut" = $1 ] ; then
    mvn clean package -pl learnmvc-test -am -Dbasegc.skip=false -Dbdgc.skip=false -Dcodeg.author=fastjrun -P$2
fi
echo "build done."