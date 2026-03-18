# Changelog

All notable changes to the **Japanese Dictionary (JavaFX)** project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.3.0] - 2026-03-18

### Added
- **Show All Kanji:** Dedicated button on the Home Screen to view the complete saved list.
- **Add Kanji:** Quick-access button directly on the Home Screen for faster data entry.
- **Delete Kanji:** Action button in the detailed Kanji view to remove entries from the database.
- **Tooltips:** Hover text added to navigation and action buttons for better user accessibility.

### Changed
- **Navigation Redesign:** Moved the "Home" button to the top-left within the permanent search bar area. It now dynamically hides on the Home Screen and reappears when navigating elsewhere.
- **Action Button Placement:** Relocated the Bookmark and Delete buttons to the bottom-right of the detail view to align with natural reading flow and prevent accidental clicks.
- **List Rendering Optimization:** Implemented JavaFX `cellFactory` for the `ListView`, significantly improving scrolling performance and custom layout rendering.
- **Codebase Refactoring:** Broke down large UI code blocks into smaller, modular methods to improve the maintainability of the pure Java UI logic.

## [1.2.0]

### Added
- **Bookmarks:** Feature to save and easily access favorite or difficult Kanji.
- **Cross-Platform Installers:** Bundled the application into standalone Windows (`.msi`) and Linux binaries using the BellSoft Liberica JDK (Full).

### Changed
- **Data Persistence Strategy:** The SQLite database now automatically initializes and copies to the user's home directory, ensuring saved vocabulary and bookmarks are not lost during application updates.

## [1.1.0]

### Changed
- **Architecture Overhaul:** Completely refactored the application to follow the Model-View-Controller (MVC) design pattern.
- **Database Decoupling:** Separated the SQLite database operations entirely from the pure Java UI components to improve scalability for the growing JLPT N5 vocabulary list.

## [1.0.0]

### Added
- **Initial Release:** Core desktop application built using a pure Java UI (JavaFX without FXML).
- **Mastered Kanji Tracking:** Dynamic text filtering that displays explicit Mastered Kanji while keeping unlearned vocabulary in Kana.
- **Bilingual Semantic Mapping:** Integration of both English meanings and Tamil language references to intuitively explain Japanese grammar and sentence structure.
- **Local Database:** Lightweight SQLite integration to store and track custom JLPT N5 vocabulary.
