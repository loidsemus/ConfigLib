plugins {
    id("java")
    id("nebula.maven-publish") version "17.0.0"
    id("nebula.javadoc-jar") version "17.0.0"
}

group = "de.exlll"
version = "2.2.0"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0-M1")
    testImplementation("org.junit.platform:junit-platform-runner:1.7.0-M1")
    testImplementation("org.junit.platform:junit-platform-suite-api:1.7.0-M1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0-M1")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("com.google.jimfs:jimfs:1.1")

    implementation("org.yaml:snakeyaml:1.26")
}

tasks.test {
    useJUnitPlatform()
}
