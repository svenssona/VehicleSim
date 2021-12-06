# Answers for lab2a

## Task 2

What classes are dependent of each other that should not be?
- CarView och CarController have a cyclical dependency.

Are there stronger dependencies than necessary?
- Fråga TA:s om aggregation är svagare än composition för CarControl och Car.

Kan ni identifiera några brott mot övriga designprinciper vi pratat om i kursen?
- There are two methods in CarController that breach openclose relating to Scania and Turbo.
- There are multiple listeners in the view.

## Task 3

With regards to separation of Concern (SoC) and Single Responsibility Principle (SRP). 
- CarController has a main function that should be made into its own application class.
This gives us clearer responsibilities (SoC & SPR).
- Otherwise we think our model has applied these principles, we thought of these when writing the code. 
For example unload cargo has a helper method called get getUnloadPosition which we implemented with regards to SoC. 
## Refactoring plan for lab2b

1. Refactor Car to Vehicle.
2. Add a marker interface Car.
1. Create an application class.
2. Fix the cyclical dependencies by moving the actionlisteners from the view to the controller.
3. Remove the point map from Drawpanel.

Everything can be done in parallel except for Car -> Vehicle and the interface.
