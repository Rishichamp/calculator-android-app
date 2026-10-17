# Android Calculator App

[![build](https://github.com/Rishichamp/calculator-android-app/actions/workflows/build.yml/badge.svg)](https://github.com/Rishichamp/calculator-android-app/actions/workflows/build.yml)

This Android application performs basic arithmetic operations such as **addition, subtraction, multiplication, division, and modulus**.

The app is built using **Java and Android Studio** and demonstrates how Android UI components like **EditText, Button, Spinner, and TextView** can be used to create an interactive calculator application.

---

## Purpose

This project was created as a learning exercise to understand how to build a **basic calculator application in Android**.

It demonstrates how to:

- Take numeric input from users
- Use a **Spinner dropdown menu** to select mathematical operations
- Perform arithmetic calculations using Java
- Display results dynamically in an Android user interface

---

## Features

- Addition of two numbers
- Subtraction of two numbers
- Multiplication of two numbers
- Division of two numbers
- Modulus operation
- Operation selection using **Spinner**
- Result displayed with formatted output
- Input validation for empty fields

---

## Technologies Used

- Java
- Android Studio
- Android SDK
- XML Layouts
- Spinner (Dropdown UI Component)

---

## Project Structure

Main components of the project:

- `MainActivity.java` → Handles user input, spinner selection, and arithmetic calculations  
- `activity_main.xml` → Defines the user interface layout  
- `strings.xml` → Stores operator values for the Spinner dropdown  

---

## How the App Works

1. The user enters two numbers in the input fields.
2. The user selects a mathematical operation from the **Spinner dropdown**.
3. The user presses the **Calculate button**.
4. The application performs the selected arithmetic operation.
5. The result is displayed on the screen.

Example:

```
Input: 10 and 5
Operation: Addition
Output: Answer = 15.00
```

---

## Screenshots

<p align="center">
  <img src="cal_1.png" width="200">
  <img src="cal_2.png" width="200">
  <img src="cal_3.png" width="200">
</p>

<p align="center">
  <img src="cal_4.png" width="200">
  <img src="cal_5.png" width="200">
  <img src="cal_6.png" width="200">
  <img src="cal_7.png" width="200">
</p>

---

## 2026 update

- **Tooling:** upgraded from Gradle 7.3 / AGP 7.2 (which don't run on the JDK 21 in current Android Studio) to Gradle 8.11.1, AGP 8.7.3, compileSdk 35 / targetSdk 34, Java 17 and current AndroidX libraries.
- Typing just "." crashed the app; now it shows an error.
- Dividing by zero showed "Infinity" and remainder by zero showed "NaN"; both now show a clear error.
- The empty-field message was set on a hidden view, so it never appeared.
- The result box no longer cuts off long answers; the button reads **Calculate**.
- **Tests:** 4 unit tests and 4 on-device UI tests, all passing on an Android 11 emulator, plus a 2,000-event monkey stress test with no crashes. GitHub Actions builds, unit-tests and lints the app on every push.

## Author

**Rishi Singh** — [GitHub](https://github.com/Rishichamp)
