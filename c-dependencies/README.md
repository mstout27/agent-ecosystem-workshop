# Java program using a third-party dependency

This project is an exercise to create a simple Java program, built using gradle and using a third-party dependency.
In this instance, the main method implements the Apache Commons text library. To allow it to be used without directly
downloading it, it is specified as a dependency in the project's build file.  Much like the last subproject, building with the 
established gradle wrapper causes a tar ball to be created.  However, unpacking this now also creates other jar files, representing the
dependencies being used.

To run the program, you can no longer simply execute the jar in build/libs, as it does not include the dependencies.
This is because the classpath only includes one of the jar files, where it needs to be an amalgamation of the program jar plus its 
dependencies.  One way to do this is by including the classpath manually, using the -cp flag:
```java -cp c-dependencies/build/c-dependencies/lib/c-dependencies.jar:c-dependencies/build/c-dependencies/lib/commons-lang3-3.9.jar:c-dependencies/build/c-dependencies/lib/commons-text-1.8.jar com.contrastsecurity.HelloWorld```

A more convenient solution, however, is to create an uber-jar/fat jar, which contains all the classes and dependencies needed to run 
the application.  This uber-jar can be run on its own like usual, with the classpaths of the dependencies already set.