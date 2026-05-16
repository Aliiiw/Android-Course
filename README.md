# Android-Course

Android-Course is a starter Android project created for an Android programming course in Winter 2024. The current repository is a clean baseline app using Kotlin, XML layouts, AppCompat, Material Components, and ConstraintLayout.

## Current State

The app currently contains a single `MainActivity` that loads `activity_main.xml`. The layout displays a centered `Hello World!` text, making this repository a simple starting point for future Android course exercises.

## Tech Stack

- Kotlin
- Android XML layouts
- AppCompat
- Material Components
- ConstraintLayout
- Gradle

## Project Structure

```text
.
├── app
│   ├── build.gradle
│   ├── src/main
│   │   ├── AndroidManifest.xml
│   │   ├── java/com/alirahimi/androidcourse/MainActivity.kt
│   │   └── res
│   │       ├── layout/activity_main.xml
│   │       ├── values
│   │       └── mipmap-* / drawable resources
│   └── src/test / src/androidTest
├── build.gradle
├── settings.gradle
└── gradle/wrapper
```

## App Details

- Package name: `com.alirahimi.androidcourse`
- Minimum SDK: 24
- Target SDK: 34
- Compile SDK: 34
- Main screen: `MainActivity`
- UI system: XML View system

## Getting Started

1. Clone the repository.
2. Open the project in Android Studio.
3. Sync Gradle.
4. Run the `app` configuration on an Android device or emulator.

## Build

```bash
./gradlew assembleDebug
```

## Notes

This repository is intended as a course workspace. As new lessons and exercises are added, the README can be expanded with topic-by-topic notes, screenshots, and implementation details.
