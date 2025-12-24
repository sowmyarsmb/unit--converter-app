# 📱 Unit Converter App

A modern **Android Unit Converter application** built using **Kotlin** and **Jetpack Compose**, following **MVVM architecture** and Android best practices.  
The app demonstrates clean architecture, state management, dependency injection, persistence, and testing.

---

## ✨ Features
- 🔢 Convert values between different units
- 🎨 Modern, declarative UI using Jetpack Compose
- ⚡ Smooth state handling with Compose
- 💾 Local data persistence using Room
- 🧩 Scalable architecture using MVVM
- 🧪 Unit & UI testing support
- 🔄 Lifecycle-aware components

---

## 🛠 Tech Stack

### Language & UI
- **Kotlin**
- **Jetpack Compose**
- **Material Design 3**

### Architecture
- **MVVM (Model–View–ViewModel)**
- **State handling with Jetpack Compose**

### Dependency Injection
- **Hilt**
- **Dagger**

### Data Layer
- **Room Database**
- **Repository pattern**

### Testing
- **JUnit** – Unit testing
- **Espresso** – UI testing

### Tooling
- **Gradle**
- **Git & GitHub**
- **GitHub Actions (CI/CD)**

---

## 🧩 Architecture Overview

The app follows a **clean separation of concerns**, where:
- UI observes state from ViewModel
- Business logic stays inside ViewModel
- Data access is abstracted via repositories

---

## 🚀 CI/CD Pipeline

This project uses **GitHub Actions** for Continuous Integration:
- ✅ Runs unit tests using JUnit
- 🏗 Builds debug APK on every push & pull request
- 📦 Generates APK artifacts automatically

---

## ▶️ How to Run the App

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/unit-converter-app.git


