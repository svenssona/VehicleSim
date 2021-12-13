# Answers for lab2b
## Task 2
- Vilka avvikelser från MVC-idealet kan ni identifiera i det ursprungliga användargränssnittet? Vad borde ha gjorts 
smartare, dummare eller tunnare?
- Vilka av dessa brister åtgärdade ni med er nya design från del 2? Hur då? Vilka brister åtgärdade ni inte?

The application was mostly in CarController, so the controller needed to be made thinner and handle much less logic. 
The view was already pretty dumb, so no changes were needed. We also thought it reasonable to have the buttons in here, 
as the view is allowed to interact with the controller that way.
There was a cyclic dependency between view and controller, lowering cohesion of the components of MVC.
The model was already smart and completely independent from view, controller and application.

We made an application class for running the program, lessening the responsibilities on the controller. 
The controller is no longer dependent on the view.


## Task 3
- Hur bör eran MVC-lösning vara utformad för att möjliggöra att ovanstående förändring blir en utökning snarare än en modifikation?
It should allow the new view to get information about the model in a non intrusive way.
Also by listening for events via the observer pattern.

- Hur bör de olika komponenterna kommunicera med varandra?
By the observer pattern.


## Task 4
- Finns det något ställe i er design där ni redan använder detta pattern, avsiktligt eller oavsiktligt? Vilka designproblem löste ni genom att använda det?
    - Observer: We use the observer pattern from our vehicles intentionally to tell our controller when the car has moved so that it can update the view. Since CarController implements ActionListener it is an observer of CarView.
    - Factory Method: Not right now.
    - State: We used the state pattern to controll the motion of the vehicles through their directions with the enum Direction. The main design problem solved by this is that more than just one class needed to have a way to represent directions.
    - Composite: We use the composite pattern for all the vehicles that have a bed. We treat the transporter as one object but it really consits of one vehicle and one bed, all interfaced through the vehicle.
- Finns det något ställe där ni kan förbättra er design genom att använda detta design pattern? 
    - Observer: This is already implemented where it needs to be.
    - Factory Method: We should have a factory to create our vehicles. 
    - State: This is already implemented where it needs to be.
    - Composite: This is already implemented where it needs to be.
- Vilka designproblem skulle ni lösa genom att använda det?
    - A factory would let us hide the model from the application creating abstraction for the user decreasing coupling.
- Om inte, varför skulle er design inte förbättras av att använda det?
    - The other patterns are already implemented.
## Task 6
- Kan något designmönster vara relevant att använda för denna utökning?
    - Like we have been using the observer pattern would be essential. We would do the same thing we did in assignment 3.
