plugins {
  id("com.gradle.enterprise") version "3.12.3"
  id("com.gradle.common-custom-user-data-gradle-plugin") version "1.8.2"
}

val isCI = !System.getenv("CI").isNullOrEmpty()

gradleEnterprise {
  server = "https://ge.solutions-team.gradle.com"
  buildScan {
    capture { isTaskInputFiles = true }
    isUploadInBackground = !isCI
    publishAlways()
  }
}

buildCache {
  local {
    isEnabled = true
  }
  remote(gradleEnterprise.buildCache) {
    isEnabled = true
    isPush = isCI
  }
}

rootProject.name = "gradle-parallel-task-execution-sample"
