Build tensorflow jars and target java 8 on macos with M2 chip

* activate python env with tensorflow installed
* set compiler target source to java 8 and exclude the module-info.java from compilation (add it to base pom.xml)
    * https://maven.apache.org/plugins/maven-compiler-plugin/examples/module-info.html
* export BAZEL_CACHE="--remote_cache=https://storage.googleapis.com/tensorflow-sigs-jvm --remote_upload_local_results=false"
* mvn clean install -B -U -e -Djavacpp.platform=macosx-arm64 -pl tensorflow-core/tensorflow-core-generator,tensorflow-core/tensorflow-core-api,tensorflow-core/tensorflow-core-platform -am "-Dnative.build.flags=$BAZEL_CACHE"

