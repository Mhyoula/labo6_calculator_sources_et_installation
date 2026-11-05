# SEG3502 — Laboratoire 6 — REST Calculator

Projet Kotlin / Spring Boot conforme à l'exercice évalué de la partie 6 du laboratoire : quatre opérations GET et documentation OpenAPI.

## Prérequis

- Java JDK 21 (`java -version`)
- Git (`git --version`)
- Connexion Internet pour télécharger les dépendances Gradle à la première exécution

**Important :** cette archive comprend les sources de l'application et deux scripts de préparation. Pour fournir les scripts Gradle Wrapper officiels (`gradlew`, `gradlew.bat` et le `.jar`), les scripts recopient la base publique `stephanesome/converter-api`, sans conserver son historique Git.

## Installation sur Windows (PowerShell)

1. Décompresser `labo6_calculator.zip`.
2. Ouvrir PowerShell dans le dossier décompressé.
3. Exécuter `./preparer-projet.ps1` (ou `Set-ExecutionPolicy -Scope Process Bypass` si PowerShell bloque ce script local).
4. Exécuter :

```powershell
cd rest-calculator-pret
.\gradlew.bat test
.\gradlew.bat bootRun
```

## Installation sur macOS / Linux

```bash
bash preparer-projet.sh
cd rest-calculator-pret
./gradlew test
./gradlew bootRun
```

## Routes HTTP GET

| URL | Résultat attendu |
| --- | --- |
| http://localhost:8080/calculator/add/10/5 | `15.0` |
| http://localhost:8080/calculator/subtract/10/5 | `5.0` |
| http://localhost:8080/calculator/multiply/10/5 | `50.0` |
| http://localhost:8080/calculator/divide/10/5 | `2.0` |
| http://localhost:8080/calculator/divide/10/0 | HTTP 400, JSON `{"erreur":"Division par zéro impossible."}` |

Les nombres sont interprétés comme des `Double` : les résultats ont généralement une décimale.

## Documentation OpenAPI

- Swagger UI : http://localhost:8080/swagger-ui.html
- OpenAPI JSON : http://localhost:8080/v3/api-docs
- OpenAPI YAML : http://localhost:8080/v3/api-docs.yaml

Le starter `springdoc-openapi-starter-webmvc-ui:2.8.9` est choisi pour Spring Boot 3.4.5.

## Structure du projet

```text
rest-calculator/
├── build.gradle.kts
├── settings.gradle.kts
└── src/
    ├── main/
    │   ├── kotlin/seg3x02/calculator/
    │   │   ├── RestCalculatorApplication.kt
    │   │   └── controller/
    │   │       ├── CalculatorController.kt
    │   │       └── CalculatorExceptionHandler.kt
    │   └── resources/application.properties
    └── test/kotlin/seg3x02/calculator/
        └── CalculatorControllerTest.kt
```

## Remettre sur GitHub Classroom

1. Accepter l'invitation au dépôt de la classe depuis le lien donné par le professeur.
2. Cloner **votre dépôt Classroom**, pas celui du professeur.
3. Recopier les fichiers du dossier `rest-calculator-pret` dans votre dépôt Classroom en préservant le dossier caché `.git` et les éventuels fichiers de consignes Classroom.
4. Depuis votre dépôt Classroom :

```bash
git add .
git commit -m "Labo 6 - REST Calculator"
git push
```

5. Ouvrir votre dépôt Classroom sur GitHub pour confirmer la présence des fichiers.

## Limite de la vérification

Les fichiers ont été vérifiés statiquement ; les tests Gradle ne peuvent pas être exécutés dans l'environnement de préparation sans téléchargement externe des dépendances. Lancez `./gradlew test` sur votre machine avant la remise.
