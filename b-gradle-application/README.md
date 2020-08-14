# Hello World Java program using Gradle

This directory is an exercise meant to create a simple Java program, built using 
gradle to understand how it operates and the advantages of doing so.  To create the project, a gradle 
wrapper is initialized.  Using the gradle wrapper allows the program to consistently use the same version of
gradle specified by the wrapper, rather than the version defined locally on the user's machine.  

This program creates the wrapper in the root directory, with this directory included as a subproject 
by the settings.gradle file. With this, building with the gradle wrapper generates the build files from
the behavior created in this directory's `build.gradle` file.  

To run the program, you can call `./gradlew run`, which will run the HelloWorld.java file, defined as 
the main class name in the build file.  After being built, a .tar file is also created. Unpacking this 
provides a .jar file and a script, which can be called to execute the jar. The scripts allow for further 
specification of the dependencies that may be needed to run the jar file.