# 📖 Japanese Dictionary & Kanji Learning Platform

A lightweight, offline-first Japanese learning desktop application built with **Java**, **JavaFX**, and **SQLite**.

Designed for Japanese learners who want fast Kanji lookup, personal vocabulary tracking, and a distraction-free study experience — without depending on an internet connection.

![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk)
![JavaFX](https://img.shields.io/badge/JavaFX-25-blue?style=for-the-badge)
![SQLite](https://img.shields.io/badge/SQLite-Local%20Database-003B57?style=for-the-badge&logo=sqlite)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36?style=for-the-badge&logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

---

## ✨ Features

- 🔍 **Kanji Lookup** — Quickly search and view Kanji information
- 🇬🇧 **English Meaning Search** — Find Kanji using English meanings
- ⭐ **Bookmarks** — Save Kanji for later study
- 🈶 **Kanji Information** — View Onyomi, Kunyomi, meanings, stroke count, and related information
- 🌙 **Dark & Light Themes** — Switch between themes based on your preference
- 💾 **Persistent Local Data** — Bookmarks and user data are stored locally
- ⚡ **Fast Local Search** — SQLite-powered search without network requests
- 📶 **Fully Offline** — No internet connection required
- 💻 **Cross-Platform** — Supports Windows and Linux
- 📦 **Native Installers** — Distributed as Windows `.msi` and Linux `.deb` packages

---

## 📸 Screenshots

<p align="center">
  <img src="https://github.com/user-attachments/assets/b56f7c78-acde-4efc-93f8-c3b82faa9e7a" width="45%">
  <img src="https://github.com/user-attachments/assets/a084e6d9-1c84-4190-8fa4-7c08a3ec78b6" width="45%">
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/58eb0b87-1806-410c-a8b4-f175ab6c937b" width="45%">
  <img src="https://github.com/user-attachments/assets/ec2ddb50-f3dc-470b-bdff-3dc23b562b52" width="45%">
</p>

---

## 🎯 Motivation

I built this application while learning Japanese and preparing for the **JLPT N5**.

I wanted a desktop application that was:

- Fast
- Lightweight
- Completely offline
- Focused on Kanji learning
- Available on both Windows and Linux

Instead of relying on a web-based dictionary, this project provides a local learning environment with persistent user data and a native desktop experience.

---

## 🏗️ Architecture

The application follows the **Model–View–Controller (MVC)** architecture.

```text
                    ┌─────────────────┐
                    │      User       │
                    └────────┬────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │   JavaFX UI     │
                    │      View       │
                    └────────┬────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │   Controller    │
                    └────────┬────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │     Model       │
                    └────────┬────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │ SQLite Database │
                    │      JDBC       │
                    └─────────────────┘
```

The UI is separated from database operations, allowing the application logic and persistence layer to remain independent of the JavaFX interface.

---

## 🛠️ Technology Stack

| Category | Technology |
|---|---|
| Language | Java |
| UI Framework | JavaFX |
| Database | SQLite |
| Database Access | JDBC |
| Build System | Maven |
| UI Theme | AtlantaFX |
| Packaging | `jpackage` |
| Version Control | Git / GitHub |

---

## 📂 Project Structure

```text
src/
├── model/
├── controller/
├── database/
├── ui/
├── utils/
└── resources/
```

The project is organized around the MVC architecture with dedicated components for models, controllers, database operations, UI components, utilities, and application resources.

---

## 📦 Installation

### Windows

Download the latest `.msi` installer from the **Releases** page.

1. Download the installer.
2. Run the `.msi` file.
3. Follow the installation wizard.
4. Launch the application from the Start Menu.

### Linux

Download the latest `.deb` package from the **Releases** page.

Install it with:

```bash
sudo dpkg -i japanesedictionary_*.deb
```

If dependencies are required:

```bash
sudo apt install -f
```

Then launch:

```bash
japanesedictionary
```

---

## 🔨 Building From Source

### Requirements

- **JDK 25**
- **Maven**
- Linux or Windows

Clone the repository:

```bash
git clone https://github.com/SuperAnand67/Japanese-Dictionary-JavaFX.git
cd Japanese-Dictionary-JavaFX
```

Build:

```bash
mvn clean package
```

Run:

```bash
mvn javafx:run
```

---

## 💾 Data & Privacy

The application is designed to work entirely locally.

User data such as bookmarks is stored in a local SQLite database. The application does not require an external server or continuous internet connection for its core functionality.

---

## 🛣️ Roadmap

### ✅ Completed

- [x] Offline Kanji Dictionary
- [x] English Meaning Search
- [x] Bookmark System
- [x] Dark / Light Themes
- [x] Native Windows Installer
- [x] Native Linux Package
- [x] Maven Migration
- [x] MVC Refactoring
- [x] Cross-platform Support

### 🚧 Planned

- [ ] Radical (部首) Search
- [ ] JLPT Vocabulary Lists
- [ ] Example Sentences
- [ ] Furigana Support
- [ ] Flashcards
- [ ] Search History
- [ ] Bookmark Import / Export
- [ ] Audio Pronunciation
- [ ] Stroke Order Animations

---

## 📋 Version History

See [`CHANGELOG.md`](CHANGELOG.md) for the complete project history.

Recent development includes:

- **v1.4.0** — AtlantaFX themes, dark/light theme switching, theme persistence, Maven migration, and project restructuring
- **v1.3.0** — Kanji management improvements, tooltips, navigation redesign, and ListView performance improvements
- **v1.2.0** — Bookmarks and native Windows/Linux packaging
- **v1.1.0** — MVC architecture and database separation
- **v1.0.0** — Initial release

---

## 🤝 Contributing

Contributions, bug reports, feature requests, and suggestions are welcome.

If you would like to contribute:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Commit your changes
5. Push the branch
6. Open a Pull Request

---

## 📄 License

This project is licensed under the **MIT License**.

See [`LICENSE`](LICENSE) for the full license text.

---

## 👨‍💻 Author

**Anand P**

Computer Science Engineering Student • Java Developer • Linux Enthusiast

GitHub: [@SuperAnand67](https://github.com/SuperAnand67)

---

<p align="center">
  Built with ☕ Java and ❤️ for Japanese learning.
</p>
