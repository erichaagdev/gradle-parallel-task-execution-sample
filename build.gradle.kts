@file:Suppress("UnstableApiUsage", "UNUSED_VARIABLE")

plugins {
  id("java")
}

testing {
  suites {
    val integrationTest by registering(JvmTestSuite::class)
    val functionalTest by registering(JvmTestSuite::class)

    withType(JvmTestSuite::class).configureEach {
      useJUnitJupiter()
    }
  }
}

tasks.named("check").configure {
  dependsOn(testing.suites.withType<JvmTestSuite>())
}
