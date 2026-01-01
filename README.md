# Media Analytics Library (Java)

A Java media analytics library that models and analyzes multiple media types
(**Books**, **Movies**, **Albums**) using clean object-oriented design.

## What it does
- Defines a common `MediaItem` interface for shared behavior
- Uses an abstract `BaseItem` class to centralize:
  - automatic unique ID generation
  - input validation (length >= 0, rating clamped to 0–5)
- Stores items in a `MediaLibrary` repository and provides analytics:
  - titles by creator
  - top-k titles by rating (with tie-breaking by title)
  - item counts by media type
  - average length per media type
- Includes a **custom lazy filtered iterator** (`filterByRating`) that traverses
  only items meeting a minimum rating threshold without creating a temporary list.

## Key concepts demonstrated
- Interfaces & abstract classes
- Inheritance & polymorphism
- Iterators / `Iterable`
- Collections (`ArrayList`, `Map`) and sorting with comparators
- Defensive programming / validation

## How to run
```bash
javac -d out src/*.java
java -cp out Main


