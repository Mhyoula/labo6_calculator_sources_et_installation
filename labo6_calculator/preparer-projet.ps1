# À exécuter depuis le dossier extrait de labo6_calculator.zip
# Récupère le Gradle Wrapper original du professeur puis ajoute le code du labo 6.
$ErrorActionPreference = "Stop"
$source = $PSScriptRoot
$destination = Join-Path $source "rest-calculator-pret"
if (Test-Path $destination) { throw "Le dossier rest-calculator-pret existe déjà. Renommez-le ou supprimez-le avant de relancer." }

git clone --depth 1 https://github.com/stephanesome/converter-api.git $destination
if ($LASTEXITCODE -ne 0) { throw "Échec du clonage. Vérifiez Git et votre connexion Internet." }

# Le travail est local : on ne doit pas publier dans le dépôt du professeur.
Remove-Item (Join-Path $destination ".git") -Recurse -Force
Remove-Item (Join-Path $destination "src") -Recurse -Force
Copy-Item (Join-Path $source "src") (Join-Path $destination "src") -Recurse
foreach ($name in @("build.gradle.kts", "settings.gradle.kts", "README.md", ".gitignore")) {
    Copy-Item (Join-Path $source $name) (Join-Path $destination $name) -Force
}
Write-Host "Projet créé : $destination" -ForegroundColor Green
Write-Host "Ensuite : cd rest-calculator-pret; .\gradlew.bat test; .\gradlew.bat bootRun"
