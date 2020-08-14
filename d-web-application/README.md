# Build a JAX-RS web application

This project involves the creation of a simple web application, using the JAX-RS specification. 
To do this, an endpoint class is created, as well as a class which extends the `Application` interface.

The endpoint class is marked using the `@Path()` annotation, to denote the uri that should be followed to access
the endpoint.  A method returning a `Response` is also created, denoted with the `@GET` annotation to signify that 
the method is an HTTP GET request.

The `Application` class is created with the `@ApplicationPath()` annotation, to identify the base URI 
for all resource URIs.  Application's `getClasses()` method is then overridden, to allow us to specify
the endpoint class.

To actually reach the endpoint, a configuration and an HttpServer need to be made.  In the main method,
a `ResourceConfig` for our `TestApplication` is initialized, as well as a Grizzly `HttpServer`.  Initializing this 
HttpServer activates it by default, so it can now be reached at the URI defined by the parameters to the 
`GrizzlyHttpServerFactory` plus the path specified in `@Path()`.