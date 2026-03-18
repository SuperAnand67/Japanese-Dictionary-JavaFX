# Contributing to the Japanese Dictionary (JavaFX)

First off, thank you for considering contributing to this project! It is a custom-built dictionary aimed at helping students master JLPT N5 vocabulary through focused, mixed-writing reading practices and bilingual (English/Tamil) semantic mapping.

This document outlines the process for contributing to the repository and the technical standards required to keep the codebase clean and maintainable.

## 🛠️ Development Setup

To build and run this project on your local machine, you must use the specific JDK that bundles JavaFX modules:

1. **Install BellSoft Liberica JDK (Full)**: You must download the **Full** version (e.g., Java 21) from BellSoft. Standard Oracle or OpenJDK distributions will throw "package javafx does not exist" errors unless manually configured.
2. **IDE Setup**: You can use NetBeans, IntelliJ, or Eclipse. Ensure your project's Java Platform is pointed to the Liberica JDK Full installation.
3. **Database**: The project uses SQLite. The JDBC driver is required (managed via Maven `pom.xml` if using the Maven build, or added to the library path if using Ant).

## 🏗️ Architecture & Coding Guidelines

To maintain performance and code readability, this project strictly adheres to the following rules:

### 1. Pure Java UI (NO FXML)
* We do **not** use Scene Builder or `.fxml` files. 
* All user interface components, layouts, and styling must be instantiated and configured directly in Java code. 
* Use JavaFX layout panes (`BorderPane`, `VBox`, `HBox`, `StackPane`) to structure the UI.

### 2. Strict MVC Pattern
* **Model:** Handles the SQLite database queries, Kanji lists, and state logic.
* **View:** Pure JavaFX UI rendering. Do not put database calls inside button click events.
* **Controller:** The bridge. Use controllers to fetch data from the Model and pass it to the View.

### 3. List Optimization
* For any scrolling lists (like the main vocabulary list), you must use a `cellFactory` to render custom list items. Do not load thousands of UI nodes into a standard ScrollPane.

## 📝 How to Contribute

### Reporting Bugs
If you find a bug, please open an Issue and include:
* A clear title and description.
* Steps to reproduce the bug.
* The OS you are using (Windows/Linux).

### Suggesting Features
Got an idea for a new study tool or UI improvement? Open an Issue first so we can discuss it before you write any code!

### Pull Request Process
1. Fork the repository and create your feature branch: `git checkout -b feature/MyNewFeature`
2. Ensure your code follows the pure Java UI rules (no FXML).
3. Commit your changes with a clear, descriptive message.
4. Push to the branch: `git push origin feature/MyNewFeature`
5. Open a Pull Request against the `main` branch.

Thank you for helping make this study tool better!
