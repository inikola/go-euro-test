- This code is written for testing purposes.

-The project consists of two modules, go-euro-common which contains the model, and some utility classes,
and go-euro having some service implementation, bussines logic and the Main class.

How to build the project.
From command line:

1. Go to the root folder go-euro-test and run:

        mvn clean install

2. Go to folder of go-euro  module and run;

        mvn assembly:assembly

3. Each time you want to search, go to go-euro/target folder and run:

        java -jar go-euro-1.0-jar-with-dependencies.jar "STRING"

4. File named results.csv should be created in target/classes folder


