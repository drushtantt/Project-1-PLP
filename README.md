# Delphi Interpreter (ANTLR4 + Java)

A Pascal-like language with Delphi-style OO: classes, constructors/destructors, encapsulation, and integer I/O.

## What Works

- **Classes and objects** – Class types, `type T = class ... end`, object creation via `T.Create(...)`, fields and methods
- **Constructors and destructors** – `constructor Create(...);`, `destructor Destroy();`, explicit `obj.Destroy()` call
- **Encapsulation** – `private:`, `public:`, `protected:` sections; runtime enforcement (accessing private field/method outside class raises an error)
- **Integer I/O** – `readln(x)` and `writeln(expr)` for terminal input/output
- **Inheritance** – `type TChild = class(TParent) ... end`; method/field lookup up the chain; protected visible in subclasses
- **Interfaces** – `type IName = interface ... end` and `type TClass = class implements I1, I2`; assignment to interface-typed variables checked at runtime

## Requirements

- **Java 11+** (tested with Java 25)
- **ANTLR 4** – use the complete JAR (e.g. `antlr-4.13.2-complete.jar`) in the project root

## How to Run

### Option A: Windows (PowerShell or cmd)

1. **Regenerate parser**:
   ```powershell
   .\regen.ps1
   ```
   Or with Java on PATH:
   ```powershell
   java -jar antlr-4.13.2-complete.jar -Dlanguage=Java -visitor -no-listener delphi.g4 -o gen
   ```

2. **Compile and run:**
   ```powershell
   .\build.ps1
   ```
   This compiles and runs `tests\test1_class_basic.pas` (output: `11`).

   To run test 2:
   ```powershell
   .\build.ps1 tests\test2_ctor_dtor.pas
   ```
   To run test 3:
   ```powershell
   .\build.ps1 tests\test3_encapsulation_fail.pas
   ```
   To run test 4:
   ```powershell
   .\build.ps1 tests\test4_io.pas
   ```
   To run test 5:
   ```powershell
   .\build.ps1 tests\test5_inheritance.pas
   ```
   To run test 6:
   ```powershell
   .\build.ps1 tests\test6_interface.pas
   ```

   On cmd use `build.bat` the same way.

### Option B: Mac/Linux (or any OS with Java)

1. **Generate parser/lexer:**
   ```bash
   java -jar antlr-4.13.2-complete.jar -Dlanguage=Java -visitor -no-listener delphi.g4 -o gen
   ```

2. **Compile:**
   ```bash
   javac -cp ".:antlr-4.13.2-complete.jar:gen" -d out gen/*.java src/*.java
   ```
   (On Windows use `;` instead of `:` in the classpath.)

3. **Run:**
   ```bash
   java -cp "out:antlr-4.13.2-complete.jar" Main tests/test1_class_basic.pas
   ```

## Test Cases

| File | Purpose |
|------|--------|
| `tests/test1_class_basic.pas` | Classes, constructor, procedures, functions, encapsulation, writeln (expect 11) |
| `tests/test2_ctor_dtor.pas` | Constructor and destructor (expect 1 then 2) |
| `tests/test3_encapsulation_fail.pas` | Encapsulation: accessing private field outside class (expect runtime error) |
| `tests/test4_io.pas` | readln + writeln for integer I/O |
| `tests/test5_inheritance.pas` | Inheritance: TAnimal, TDog extends TAnimal; writeln (expect 10, 30, 20, 40, 1, 2) |
| `tests/test6_interface.pas` | Interface IPrintable; class implements; readln + writeln; assign to interface variable |


Exclude: `out/` (compiled classes), `.cursor/`, IDE files.

## Steps for running:

1. Unzip the archive.
2. Ensure Java 11+ is installed and `antlr-4.13.2-complete.jar` is in the project root.
3. **Windows:** Run `.\build.ps1` (or `build.bat`).  
   **Mac/Linux:** Run the javac and java commands from “Option B” above, using the same classpath with `:`.
4. To run a specific test: `java -cp "out;antlr-4.13.2-complete.jar" Main tests/test2_ctor_dtor.pas` (use `;` on Windows, `:` on Unix).
