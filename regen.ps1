# Regenerate ANTLR parser (requires Java 11+; use JAVA_HOME if you have Java 25)
# If you use Java 25: $env:JAVA_HOME = "C:\Program Files\Java\jdk-25"  (or your JDK path)
$ErrorActionPreference = "Stop"
$projectRoot = $PSScriptRoot

$java = $null
if ($env:JAVA_HOME) {
    $java = Join-Path $env:JAVA_HOME "bin\java.exe"
    if (Test-Path $java) { Write-Host "Using Java from JAVA_HOME: $env:JAVA_HOME" }
}
if (-not $java -or -not (Test-Path $java)) {
    $java = (Get-Command java -ErrorAction SilentlyContinue).Source
}
if (-not $java) {
    Write-Error "Java not found. Set JAVA_HOME to your JDK (e.g. Java 25): `$env:JAVA_HOME = 'C:\Path\To\jdk-25'"
    exit 1
}

# Check Java version (need 11+). java -version writes to stderr; use cmd to avoid PowerShell NativeCommandError
$versionOutput = cmd /c "`"$java`" -version 2>&1"
if ($versionOutput -is [array]) { $versionOutput = $versionOutput -join " " }
$versionMatch = [regex]::Match($versionOutput, 'version\s+"(\d+)')
if ($versionMatch.Success) {
    $ver = [int]$versionMatch.Groups[1].Value
    if ($ver -lt 11) {
        Write-Error "ANTLR 4.13 needs Java 11+. Current: $ver. Set JAVA_HOME to your Java 25 (or 11+) JDK."
        exit 1
    }
    Write-Host "Java version: $ver"
}

Write-Host "Regenerating parser from delphi.g4..."
Push-Location $projectRoot
try {
    & $java -jar antlr-4.13.2-complete.jar -Dlanguage=Java -visitor -no-listener delphi.g4 -o gen
    if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
    Write-Host "Done. Run .\build.ps1 to compile and run."
} finally {
    Pop-Location
}
