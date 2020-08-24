plugins {
    application
}

tasks.jar{
    manifest{
        attributes("Premain-Class" to "com.contrastsecurity.TestAgent")
        attributes("Can-Redefine-Classes" to true)
    }
    from({
        configurations.runtimeClasspath.get().filter{
            it.name.endsWith("jar")
        }.map {
            zipTree(it)
        }
    })
}

dependencies{
    implementation("org.ow2.asm:asm:7.0")
    implementation("org.ow2.asm:asm-commons:7.0")
}
