# Labmaj

This is a mobile application that implements animations with physics, user interface, sound functionality, and state saving. The application features:

- **Main Activity**: The entry point of the application with navigation to settings and about screens.
- **Physics View**: A custom view that handles animations and physics calculations, including gravity, air resistance, and velocity reduction for graphical objects.
- **Settings Activity**: A screen for users to adjust application preferences.
- **About Activity**: Displays information about the application, such as version and developer details.
- **Sound Manager**: Manages sound effects, including loading and playing sound files.

## Project Structure

```
app
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── labmaj
│   │   │               ├── MainActivity.java
│   │   │               ├── PhysicsView.java
│   │   │               ├── SettingsActivity.java
│   │   │               ├── AboutActivity.java
│   │   │               └── SoundManager.java
│   │   ├── res
│   │   │   ├── layout
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── activity_settings.xml
│   │   │   │   └── activity_about.xml
│   │   │   ├── menu
│   │   │   │   └── main_menu.xml
│   │   │   ├── values
│   │   │   │   ├── strings.xml
│   │   │   │   ├── colors.xml
│   │   │   │   └── themes.xml
│   │   │   └── raw
│   │   │       └── bounce.wav
│   │   └── AndroidManifest.xml
├── build.gradle.kts
├── proguard-rules.pro
└── README.md
```

## Features

- **Animations**: The application includes animations that simulate physical properties such as gravity and air resistance.
- **User Interface**: A clean and intuitive interface with navigation options.
- **Sound Effects**: Sound effects are integrated to enhance user experience.
- **State Management**: The application saves its state to ensure a seamless user experience.

## Getting Started

To run the application, clone the repository and open it in Android Studio. Ensure you have the necessary SDKs installed and run the app on an Android device or emulator.