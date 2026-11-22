# Observer pattern on Deck (Post-Class 10, Exercises 8.1 to 8.4)

Source: "Introduction to Software Design with Java" (Robillard), Chapter 8, Exercises 1 to 4.

| Package | Exercise | Idea |
|---------|----------|------|
| `base`  | -        | `Card`, `Rank`, `Suit` and the original (non-observable) `Deck` |
| `ex1`   | 8.1      | Observer pattern, **push** data-flow |
| `ex2`   | 8.2      | **Pull** data-flow + Interface Segregation (`ReadOnlyDeck`) |
| `ex3`   | 8.3      | Observer code in a **superclass** (`DeckObservable`) |
| `ex4`   | 8.4      | Observer code in a **subclass** (`ObservableDeck`) |

## Build and run

```bash
mkdir out
javac -d out src/*/*.java
java -ea -cp out ex1.Client   # or ex2, ex3, ex4
```
