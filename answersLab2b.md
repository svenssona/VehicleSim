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
- Hur bör de olika komponenterna kommunicera med varandra?


## Task 4
- Factory Method lets us hide the model from the application hiding abstraction for the user.
## Task 6
- Kan något designmönster vara relevant att använda för denna utökning?
