# Japanese Dictionary & Kanji Learning Platform

A modern, **offline-first** Japanese learning desktop application built
with **JavaFX**, **SQLite**, and **Maven**. Designed for fast Kanji
lookup, structured study, and cross-platform compatibility without
requiring an internet connection.

------------------------------------------------------------------------

## ✨ Features

-   🔍 Instant Kanji lookup
-   🇬🇧 Search Kanji using English meanings
-   ⭐ Bookmark favorite Kanji
-   📚 View Kanji with similar meanings
-   🈶 Display Onyomi, Kunyomi, stroke count, and meanings
-   🌙 Dark & Light theme support
-   ⚡ Fast local database with zero network dependency
-   💻 Native support for Windows and Linux
-   📦 Offline-first design

------------------------------------------------------------------------

# 📸 Screenshots

<img width="617" height="545" alt="JapaneseDictionary-1" src="https://github.com/user-attachments/assets/b56f7c78-acde-4efc-93f8-c3b82faa9e7a" />

<img width="617" height="545" alt="JapaneseDictionary-2" src="https://github.com/user-attachments/assets/a084e6d9-1c84-4190-8fa4-7c08a3ec78b6" />

<img width="617" height="545" alt="JapaneseDictionary-5" src="https://github.com/user-attachments/assets/58eb0b87-1806-410c-a8b4-f175ab6c937b" />

<img width="617" height="545" alt="JapaneseDictionary-3" src="https://github.com/user-attachments/assets/ec2ddb50-f3dc-470b-bdff-3dc23b562b52" />

<img width="612" height="546" alt="JapaneseDictionary-6" src="https://github.com/user-attachments/assets/9a8f9f8c-2545-470c-b118-c671b68f37d3" />

------------------------------------------------------------------------

# 🎯 Why I Built This

As someone learning Japanese and preparing for the **JLPT N5**, I wanted
a lightweight, distraction-free dictionary that worked entirely offline.

Most available solutions were either web-based, mobile-focused, or
required a constant internet connection. I built this application to
provide a fast, cross-platform desktop experience for studying Kanji
efficiently on both Windows and Linux.

------------------------------------------------------------------------

# 🏗 Architecture

The application follows the **Model--View--Controller (MVC)**
architecture to keep the codebase modular, maintainable, and scalable.

``` text
User
   │
JavaFX UI
   │
Controller
   │
SQLite Database (JDBC)
```

------------------------------------------------------------------------

# 🚀 Performance

Since all data is stored locally in SQLite:

-   No internet connection required
-   Near-instant search results
-   Low memory usage
-   Fast application startup
-   Minimal latency

------------------------------------------------------------------------

# 🛠 Technology Stack

  Category          Technology
  ----------------- ------------
  Language          Java
  UI Framework      JavaFX
  Database          SQLite
  Database Access   JDBC
  Build Tool        Maven
  UI Theme          AtlantaFX

------------------------------------------------------------------------

# 📂 Project Structure

``` text
src/
├── model/
├── controller/
├── database/
├── ui/
├── utils/
└── resources/
```

------------------------------------------------------------------------

# 📦 Installation

## Windows

1.  Download the latest **.msi** installer from the Releases page.
2.  Run the installer.
3.  Follow the installation wizard.
4.  Launch the application from the Start Menu.

## Linux (Debian / Ubuntu)

Download the latest **.deb** package from the Releases page.

Install it using:

``` bash
sudo dpkg -i japanesedictionary_1.0_amd64.deb
```

If any dependencies are missing:

``` bash
sudo apt install -f
```

Launch the application:

``` bash
japanesedictionary
```

------------------------------------------------------------------------

# 💻 Building From Source

## Requirements

-   BellSoft Liberica JDK (Full Edition)
-   Maven

Clone the repository:

``` bash
git clone https://github.com/SuperAnand67/Japanese-Dictionary-JavaFX.git
```

Build:

``` bash
mvn clean package
```

Run:

``` bash
mvn javafx:run
```

------------------------------------------------------------------------

# 💾 Database

The application automatically creates and manages its local SQLite
database inside the user's directory during installation.

No manual configuration is required.

------------------------------------------------------------------------

# 🛣 Roadmap

## Completed

-   ✔ Offline Kanji Dictionary
-   ✔ English Meaning Search
-   ✔ Bookmark System
-   ✔ Dark / Light Themes
-   ✔ Cross-platform Packaging
-   ✔ Native Windows Installer
-   ✔ Native Linux Package
-   ✔ Maven Migration

## Planned

-   🔲 Radical (部首) Search
-   🔲 JLPT Vocabulary Lists
-   🔲 Example Sentences
-   🔲 Flashcards
-   🔲 Furigana Support
-   🔲 Search History
-   🔲 Import / Export Bookmarks

------------------------------------------------------------------------

# 🤝 Contributing

Suggestions, bug reports, and feature requests are always welcome.

1.  Fork the repository
2.  Create a feature branch
3.  Commit your changes
4.  Open a Pull Request

------------------------------------------------------------------------

# 📄 License

This project is licensed under the **MIT License**.
