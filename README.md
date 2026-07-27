# Japanese Kanji Dictionary

## Description
A fast, offline Japanese Kanji Dictionary built with JavaFX and SQLite.
Built by a Japanese learner, for Japanese learners.
It displays the kanji, its meaning, its onyomi and kunyomi readings, and the number of strokes.

## Screenshots
<img width="617" height="545" alt="JapaneseDictionary-1" src="https://github.com/user-attachments/assets/b56f7c78-acde-4efc-93f8-c3b82faa9e7a" />

<img width="617" height="545" alt="JapaneseDictionary-2" src="https://github.com/user-attachments/assets/a084e6d9-1c84-4190-8fa4-7c08a3ec78b6" />

<img width="617" height="545" alt="JapaneseDictionary-5" src="https://github.com/user-attachments/assets/58eb0b87-1806-410c-a8b4-f175ab6c937b" />

<img width="617" height="545" alt="JapaneseDictionary-3" src="https://github.com/user-attachments/assets/ec2ddb50-f3dc-470b-bdff-3dc23b562b52" />

<img width="612" height="546" alt="JapaneseDictionary-6" src="https://github.com/user-attachments/assets/9a8f9f8c-2545-470c-b118-c671b68f37d3" />


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

### Building from Source
If you want to run or modify the code in your own IDE (like NetBeans):

1. **Prerequisite:** You must use the **BellSoft Liberica JDK (Full version)** (e.g., version 21). The "Full" version includes the necessary JavaFX modules bundled directly into the JDK.
2. Clone the repository:
   ```bash
   git clone [https://github.com/SuperAnand67/Japanese-Dictionary-JavaFX.git](https://github.com/SuperAnand67/Japanese-Dictionary-JavaFX.git
   ```

## Note on Database
~~Make sure that the Database File (kanjiDict.db) in the /opt/japanesedictionary/lib/app/ Folder.~~
~~The Installer automatically places it there and set the neccessary Read/Write Permissions.~~
Now the App automatically places the Database File (kanjiDict.db) directly in the User Folder during Installation.

## Planned Features
- Search by radical (部首)
- Furigana display
- Many More Coming Soon !!!

## License
MIT License
