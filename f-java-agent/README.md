# Building a java agent, and attaching it to all other directories

This project involves creating a javaagent, to be attached to the other 6 java projects created.  All other projects involve some 
form of printing "Hello world", and the end goal of this agent is to transform this ldc instruction and replace it with
"Goodbye world".

To begin, we create a `MethodVisitor` class, which outlines the desired instrumentation.  In our case, printing "Hello world"
will be loaded as an ldc instruction, so we override the `visitLdcInsn` method to substitute "Hello world" with "Goodbye world".
We then create a custom `ClassVisitor` class, which will go through a class and apply our custom `MethodVisitor` logic on the
desired methods.

To actually use these custom classes, however, we must have access to the byte[] that provides us with the information about
the classes and methods being run.  A class is created that implements the `ClassFileTransformer` interface, and the 
`transform` method is overridden. By doing so, the following variables can be created:

-A `ClassReader`, constructed using the `classFileBuffer` to read which class is being referred to.
-A `ClassWriter`, which allows us to write the instruction to the byte[] buffer.
-Our custom `ClassVisitor` to provide our custom instrumentation to the class. 
By calling `classReader.accept(visitor, 0);`, the ClassReader passes the information regarding the class to the ClassVisitor.
We can then return `writer.toByteArray()` to return the new, altered instruction.

In a separate class, the transformer is initialized by a unique `premain` method, and its location specified in the 
gradle build file.

For simple applications, the java agent jar can be directly attached using
```java -javaagent:{path/to/agent.jar} -jar {path/to/javaprogram}```
For web applications such as d-web-application and e-app-server, the `-javaagent:{path/to/agent.jar}` must 
instead be specified in the gradle build file and docker file, respectively.
