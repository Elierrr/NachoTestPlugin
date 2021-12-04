plugins {
    java
}

repositories {
    //maven("https://jitpack.io")
    mavenLocal()
}

dependencies {
    //compileOnly("com.github.CobbleSword.NachoSpigot:api:master-SNAPSHOT") // jitpack currently doesnt work
    compileOnly("dev.cobblesword.nachospigot:api:1.8.8-R0.2-SNAPSHOT")
}
