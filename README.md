# Japanese Kanji Dictionary

## Description
A fast, offline Japanese Kanji Dictionary built with JavaFX and SQLite.
Built by a Japanese learner, for Japanese learners.
It displays the kanji, its meaning, its onyomi and kunyomi readings, and the number of strokes.

## Screenshots
<img width="527" height="454" alt="Image" src="https://github.com/user-attachments/assets/5f544450-07bc-4c30-84cd-0ef0b5f9ff83" />

## Why I Built This
I am currently learning Japanese and preparing for JLPT N5.
I needed a fast, offline kanji reference tool that worked on both 
Windows and Linux without internet dependency.
So I built one.

## Features
-  Supports searching for the specific kanji.
- ​ Can also search using the English meaning.
-  Can BookMark Favourite Kanji and View then on through BookMark Menu.
-  Lists all kanji with similar meanings in an interactive menu.
-  Displays onyomi, kunyomi readings and stroke count.
-  0  % lag because of the use of a local database.
-  Incredibly fast and efficient UI rendering.
-  Cross-platform — runs on Windows and Linux.

## Technologies Used
- **Language :** Java
- **GUI :** Java FX
- **DataBase :** SQLite
- **Connector :** Java DataBase Connectivity API for database interaction (JDBC)

## Installation

### Linux (Debian/Ubuntu)
1. Goto [Releases](https://github.com/SuperAnand67/Japanese-Dictionary-JavaFX/releases) page and Download the Latest version.
2. Open your terminal in Downloads folder and run :

```bash
sudo dpkg -i japanesedictionary_1.0_amd64.deb
```

3. If there are any missing dependencies ,run :

```bash
sudo apt install -f
```

4. To launch the App :

```bash
japanesedictionary
```

### Windows
1. Go to [Releases](https://github.com/SuperAnand67/Japanese-Dictionary-JavaFX/releases) page and download latest .msi file.
2. Double click the installer.
3. Follow installation wizard.
4. Launch from Start Menu.

## Note on Database
~~Make sure that the Database File (kanjiDict.db) in the /opt/japanesedictionary/lib/app/ Folder.~~
~~The Installer automatically places it there and set the neccessary Read/Write Permissions.~~
Now the App automatically places the Database File (kanjiDict.db) directly in the User Folder during Installation.

## Planned Features
- Search by stroke count
- Search by radical (部首)
- Furigana display
- Add New Kanji
- Edit and Delete Existing Kanji
- Dark mode

## License
MIT License
