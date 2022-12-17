#!/bin/sh

echo "Running static analysis..."

# Format code using KtLint, then run Detekt and KtLint static analysis
./gradlew ktlintCheck
./gradlew detekt