# Japanese Kanji Dictionary

## Description
​It is a Java-based Japanese kanji dictionary that uses JavaFX for the UI and SQLite for the local database. 
It displays the kanji, its meaning, its onyomi and kunyomi readings, and the number of strokes.

<img width="527" height="454" alt="Screenshot from 2026-02-23 22-06-24" src="https://github.com/user-attachments/assets/b964e15f-3b35-4677-ab26-b53ba57ce671" />


## Features
-  Supports searching for the specific kanji.
- ​ Can also search using the English meaning.
-  Lists all kanji with similar meanings in an interactive menu.
-  0  % lag because of the use of a local database.
-  Incredibly fast and efficient UI rendering.

## Technologies Used
- **Language :** Java
- **GUI :** Java FX
- **DataBase :** SQLite
- **Connector :** Java DataBase Connectivity API for database interaction (JDBC)

## Installation
1. Goto [Releases](https://github.com/SuperAnand67/Japanese-Dictionary-JavaFX/releases) Page and Download the Latest version.
2. Open your terminal in Downloads folder and run :

```bash
sudo dpkg -i japanesedictionary_1.0_amd64.deb
```

3. If there are any missing dependencies ,run :

```bash
sudo apt install -f
```

## How to Launch
To launch the App :

```bash
japanesedictionary
```

## Note on Database
Make sure that the Database File (kanjiDict.db) in the /opt/japanesedictionary/lib/app/ Folder.
The Installer automatically places it there and set the neccessary Read/Write Permissions.
