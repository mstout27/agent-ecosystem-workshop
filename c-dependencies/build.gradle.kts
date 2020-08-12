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
    implementation("org.apache.commons:commons-text:1.8")
}