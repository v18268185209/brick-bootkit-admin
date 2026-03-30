param(
    [switch]$SkipTests
)

$ErrorActionPreference = "Stop"

$mvn = "mvn"
$resolvedMvn = Get-Command $mvn -ErrorAction SilentlyContinue
if (-not $resolvedMvn) {
    $ideaMvn = "D:\Program Files\IntelliJ IDEA 2025.3.3\plugins\maven\lib\maven3\bin\mvn.cmd"
    if (Test-Path $ideaMvn) {
        $mvn = $ideaMvn
    } else {
        throw "Maven was not found in PATH and IntelliJ bundled Maven was not found."
    }
}

$arguments = @("clean", "deploy", "-Prelease", "-f", "pom.xml")
if ($SkipTests) {
    $arguments = @("-DskipTests") + $arguments
}

& $mvn @arguments
exit $LASTEXITCODE
