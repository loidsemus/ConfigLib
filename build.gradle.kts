plugins {
    id("java-library")
    id("maven-publish")
}

group = "me.loidsemus"
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

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    repositories {
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/loidsemus/ConfigLib")
            credentials {
                username = System.getenv("GH_USERNAME")
                password = System.getenv("GH_PKG_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("gh-pkg") {
            artifactId = "configlib"
            from(components["java"])
            pom {
                name.set("configlib")
                description.set("Annotation-driven YAML config library")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
