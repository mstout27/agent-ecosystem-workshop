# Hello World Java program using only Java primitives
This project is an exercise to create a very simple .jar file, to understand what goes into it and how to run one. 
A very simple "Hello World" application is created and compiled with $, to generate the .class file. 
This class file must be put into a separate package to allow the .jar file to recognize it when it is made, 
to prevent possible interference from the bytecode of other class files.

A jar file is a Java archive file, used to merge several files together.  This file type allows for 
simple HTTP transactions, as well as easier loading and downloading times due to the compression of files.
As such, the jar file contains compiled bytecode, rather than the slower uncompiled .java files.

In this instance, the compiled **HelloWorld.class** is used to generate the **hello.jar** file using 
>jar cf hello.jar com/contrastsecurity/HelloWorld.class  

However, to run the main method within the .jar file, you need to specify 
the full classpath of the main method:
>java -cp hello.jar com.contrastsecurity.HelloWorld

To alleviate this, a manifest file is added that includes all necessary information, such as the version and the classpath of the main method.
By recreating the jar file including the manifest, the main method can be run directly with the command
>java -jar hello.jar
