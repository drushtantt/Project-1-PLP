# Build and run Delphi interpreter (uses JAVA_HOME if set, e.g. for Java 25)
# If you use Java 25: $env:JAVA_HOME = "C:\Program Files\Java\jdk-25"
$ErrorActionPreference = "Stop"
$projectRoot = $PSScriptRoot

$javac = $null
$java = $null

if ($env:JAVA_HOME) {
    $javac = Join-Path $env:JAVA_HOME "bin\javac.exe"
    $java = Join-Path $env:JAVA_HOME "bin\java.exe"
    if ((Test-Path $javac) -and (Test-Path $java)) {
        Write-Host "Using Java from JAVA_HOME: $env:JAVA_HOME"
    }
}
if (-not $javac -or -not (Test-Path $javac)) {
    $javac = (Get-Command javac -ErrorAction SilentlyContinue).Source
    $java = (Get-Command java -ErrorAction SilentlyContinue).Source
}

if (-not $javac) {
    Write-Error "No JDK found. Set JAVA_HOME to a JDK (e.g. Java 11+) or add javac to PATH."
    exit 1
}

$cp = ".;antlr-4.13.2-complete.jar;gen"
$outDir = Join-Path $projectRoot "out"

Write-Host "Compiling..."
$sources = @(
    (Get-ChildItem -Path (Join-Path $projectRoot "gen") -Filter "*.java").FullName
    (Get-ChildItem -Path (Join-Path $projectRoot "src") -Filter "*.java").FullName
)
& $javac -cp $cp -d $outDir $sources
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }

$runCp = "out;antlr-4.13.2-complete.jar"
$mainClass = "Main"
$defaultTest = Join-Path $projectRoot "tests\test1_class_basic.pas"

$fileToRun = if ($args.Count -gt 0) {
    $p = $args[0]
    if (-not [System.IO.Path]::IsPathRooted($p)) { $p = Join-Path $projectRoot $p }
    if (-not (Test-Path $p)) {
        Write-Error "File not found: $($args[0])"
        exit 1
    }
    (Resolve-Path $p).Path
} else {
    $defaultTest
}

Push-Location $projectRoot
try {
    & $java -cp $runCp $mainClass $fileToRun
} finally {
    Pop-Location
}
