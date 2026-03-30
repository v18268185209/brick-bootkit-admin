param(
    [Parameter(Mandatory = $true, Position = 0)]
    [string]$Version,

    [switch]$DryRun
)

$ErrorActionPreference = "Stop"

$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$pythonScript = Join-Path $scriptDir "set-version.py"

$pythonCommand = $null
foreach ($candidate in @("python", "py", "python3")) {
    $resolved = Get-Command $candidate -ErrorAction SilentlyContinue
    if ($resolved) {
        $pythonCommand = $resolved.Source
        break
    }
}

if (-not $pythonCommand) {
    throw "Python was not found. Install Python 3 and try again."
}

$arguments = @($pythonScript, $Version)
if ($DryRun) {
    $arguments += "--dry-run"
}

& $pythonCommand @arguments
exit $LASTEXITCODE
