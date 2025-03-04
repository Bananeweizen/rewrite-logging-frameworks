plugins {
    id("org.openrewrite.build.recipe-library") version "latest.release"
}

group = "org.openrewrite.recipe"
description = "Enforce logging best practices and migrate between logging frameworks. Automatically."

val rewriteVersion = if (project.hasProperty("releasing")) {
    "latest.release"
} else {
    "latest.integration"
}

dependencies {
    compileOnly("org.projectlombok:lombok:latest.release")
    annotationProcessor("org.projectlombok:lombok:latest.release")

    implementation("org.kohsuke:wordnet-random-name:latest.release")

    implementation(platform("org.openrewrite:rewrite-bom:${rewriteVersion}"))
    implementation("org.openrewrite:rewrite-java")
    implementation("org.openrewrite:rewrite-maven")
    runtimeOnly("org.openrewrite:rewrite-java-17")

    testImplementation("org.junit.jupiter:junit-jupiter-api:latest.release")
    testImplementation("org.junit.jupiter:junit-jupiter-params:latest.release")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:latest.release")

    testImplementation("org.openrewrite:rewrite-test")
    testImplementation("org.openrewrite:rewrite-java-tck")

    testImplementation("org.projectlombok:lombok:latest.release")
    testImplementation("org.assertj:assertj-core:latest.release")

    testRuntimeOnly("org.openrewrite:rewrite-java-17")
    testRuntimeOnly("commons-logging:commons-logging:1.2")
    testRuntimeOnly("ch.qos.logback:logback-classic:1.2.11")

    testRuntimeOnly("org.apache.logging.log4j:log4j-core:2.+")
    testRuntimeOnly("org.apache.logging.log4j:log4j-api:2.+")

    testRuntimeOnly("org.slf4j:slf4j-api:1.+")
    testRuntimeOnly("log4j:log4j:1.+")
}
