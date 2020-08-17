# Build a Servlet web application

This project involves creating a servlet web application, deployed using a docker container.
In addition to this, the `war` plugin is used, rather than the `application` plugin.  The war file 
is a web archive file, and differs from the jar file by actually containing the web application itself,
rather than simply the properties and resources of the program like a jar file.  

Using a war file allows the web application to be directly deployed by a servlet.  To do this, an endpoint
is created using the servlet specification, and overrides `HttpServlet`'s `doGet` method to respond
to GET requests with a simple text response. 

A Dockerfile is created, using `tomcat` as the base image.  Tomcat is a servlet container, which we can
take the base behavior from to use as a platform for our images.  With tomcat's file system in mind, we can
set our war file to be autodeployed when the image is created.

To create the docker image, we can run ```docker build /e-app-server``` from root,
using the Dockerfile in this directory.  The image can be run using ```docker run -p 8080:8080 {image_name}```, according to
the port defined in the Dockerfile.  

The docker image created here is a static artifact which tells the computer at runtime what container to make, 
allowing for easy deployment across other machines.  The container itself is thus like an "instance" of the image, 
created from the template defined by the image.  By using the `docker exec` command, actions can 
be executed and performed on single docker containers, such as ```docker exec -it {container_name} bash``` allowing one 
to explore the container using bash.