plugins {
    application
}

application {
    mainClass.set("com.contrastsecurity.HelloWorld")
}

tasks.jar {
    manifest {
        attributes(
                "Main-Class" to "com.contrastsecurity.HelloWorld"
        )
    }
}

dependencies {
    implementation("org.glassfish.jersey.containers:jersey-container-grizzly2-http:2.26")
    runtimeOnly("org.glassfish.jersey.inject" , "jersey-hk2", "2.31")
    runtimeOnly("org.glassfish.jaxb", "jaxb-runtime", "2.3.2")
}