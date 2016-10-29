# Create Database

createuser --createdb --login -P modus
createdb --username=modus --password modus

# Will soon replacing JPA migration with flyway

# How to run
 ./gradlew build && java -jar build/libs/modus-0.0.1-SNAPSHOT.jar
(0.0.1-SNAPSHOT is the version specified in build.gradle)