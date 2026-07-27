@echo off
setlocal EnableDelayedExpansion

set /p VER=Enter Version:

for %%f in (target\JapaneseDictionary-*.jar) do (
	set JAR=%%~nxf
	echo !JAR!
)

if "%JAR"=="" (
	echo No JAR File Found !
	pause
	exit /b 1
)

echo Building version %VER%
echo Packaging : %JAR%

jpackage --type msi ^
  --input target ^
  --dest output ^
  --name "JapaneseDictionary" ^
  --main-jar %JAR% ^
  --main-class japanese_dictionary.JapaneseDictionary ^
  --app-version %VER% ^
  --description "A Local SQLite Powered Japanese Kanji Dictionary" ^
  --vendor "SuperAnand" ^
  --win-dir-chooser ^
  --win-shortcut ^
  --win-menu ^
  --win-shortcut-prompt ^
  --icon app.ico

echo .
echo MSI Build Finished!
pause