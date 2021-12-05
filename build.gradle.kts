plugins {
    java
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
}

repositories {
    //maven("https://jitpack.io")
    mavenLocal()
}

dependencies {
    //compileOnly("com.github.CobbleSword.NachoSpigot:api:master-SNAPSHOT") // jitpack currently doesnt work
    compileOnly("dev.cobblesword.nachospigot:api:1.8.8-R0.2-SNAPSHOT")
}

bukkit {
    main = "me.elier.nachospigot.testplugin.TestPlugin"
    version = "1.0.0"
    description = "A test plugin for testing."
}