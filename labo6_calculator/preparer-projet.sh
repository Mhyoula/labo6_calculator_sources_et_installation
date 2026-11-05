#!/usr/bin/env bash
set -euo pipefail
source_dir="$(cd "$(dirname "$0")" && pwd)"
destination="$source_dir/rest-calculator-pret"
if [ -e "$destination" ]; then
  echo 'Le dossier rest-calculator-pret existe déjà.' >&2
  exit 1
fi

git clone --depth 1 https://github.com/stephanesome/converter-api.git "$destination"
# Le projet du professeur sert de base Gradle. On ne conserve pas son historique Git.
rm -rf "$destination/.git" "$destination/src"
cp -R "$source_dir/src" "$destination/src"
cp "$source_dir/build.gradle.kts" "$source_dir/settings.gradle.kts" "$source_dir/README.md" "$source_dir/.gitignore" "$destination/"
chmod +x "$destination/gradlew"
echo "Projet créé : $destination"
echo 'Ensuite : cd rest-calculator-pret && ./gradlew test && ./gradlew bootRun'
