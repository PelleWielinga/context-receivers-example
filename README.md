# Some thoughts on context receivers and their use cases

This project was used for a talk on Kotlin Dev Day Amsterdam 2022. It contains two examples of context receivers.

`LoggingContext` is a trivial example that shows how the feature works. In practice this example is not very useful.

The example with `withAuthenticatedUser` shows where context receivers could be used in a real life scenario.

## How to read this repository

The `main` branch contains a clean state for the repository before the live coding session. The `after-live-coding` branch has the finished state that uses context receivers.

Due to time constraints there are a lot of TODOs in the code. The code compiles but that is it. Expect some changes in the near future.
