@echo off
setlocal
set "PROJECT_ROOT=%~dp0"
set "PROJECT_ROOT=%PROJECT_ROOT:~0,-1%"

if defined JAVA_HOME (
    set "JAVAC=%JAVA_HOME%\bin\javac.exe"
    set "JAVA=%JAVA_HOME%\bin\java.exe"
) else (
    set "JAVAC=javac"
    set "JAVA=java"
)

echo Compiling...
"%JAVAC%" -cp ".;antlr-4.13.2-complete.jar;gen" -d out gen\*.java src\*.java
if errorlevel 1 exit /b 1

if "%~1"=="" (
    "%JAVA%" -cp "out;antlr-4.13.2-complete.jar" Main tests\test1_class_basic.pas
) else (
    "%JAVA%" -cp "out;antlr-4.13.2-complete.jar" Main %*
)
