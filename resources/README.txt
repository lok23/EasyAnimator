ADDITION OF CONTROLLER:

The controller is the final component of the MVC design. In our assignment, the
controller implements IController, which contains one method go(), and 
ActionListener, which contains the actionPerformed method. The Controller is
given an IModel and IView as parameters to its constructor. Depending on which
IView is used (as determined with instanceof), the go() method will take
different actions to properly set up the view. The actionPerformed method is 
called whenever enough time has passed (as determined by Timer), or whenever
the user clicks on one of the menubar items. 
The controller successfully separates responsibility
of the model and the view. For instance, the model has methods like addShape,
and addMove that are responsible for parsing the file and calculating the 
shapes and moves while the view has methods like render and setEcho which are
responsible for creating the user facing product.

This design is functional, but there are a few issues
with it:

-The controller communicates with the view in a manner that reveals how the 
view is implemented.

-The controller itself depends on view-specific interfaces like ActionListener 
As a result, view-specific details leak out of the view.

This is the result of not reading enough of the lectures before starting the
assignment. :( Had we done the reading, we would have instead captured the
high-level capabilities of our program, and putting them in an interface named
Features.



ADDITION OF VIEWIMPLPLAYBACKGUI

ViewImplPlayBackGUI is very similar to the visual GUI that we created in the
last assignment. It was so similar, that we extended it and added the features
ontop of it. We added a menubar, and setListeners to listen to clicks on 
items from the menubar. setListener sets the Controller to listen to the
menuItems. 



ADDITION OF MOCK CLASSES
These Mock classes help test the final product.