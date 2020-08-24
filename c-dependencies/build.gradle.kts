plugins {
    application
}

tasks.jar{
    manifest{
        attributes("Main-Class" to "com.contrastsecurity.HelloWorld")
    }
    from({
        configurations.runtimeClasspath.get().filter{
            it.name.endsWith("jar")
        }.map {
            zipTree(it)
        }
    })
}
dependencies {
    implementation("org.apache.commons:commons-text:1.8")
}