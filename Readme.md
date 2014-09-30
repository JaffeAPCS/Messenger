### Messaging for controller communication in MVC Java framework programs

This java package includes classes necessary to include messaging between controllers in an MVC framework
Java application.

#### Instructions:

#### Step 1: Your app must instantiate an instance of class Messages.  

You may have more than one instance of
this class providing multiple message spaces.  You should subscribe pass the instance(s) of Messages to the 
controllers in your app so the controllers can subscribe to messages and send messages to other controllers.

#### Step 2: All controllers must be descendants of the <code>MessageController</code> interface.  

Your controller must implement 
the message handler method <code>public void messageHandler(String messageName, Object messagePayload);</code>.  This method will be executed
by Messages when the controller is subscribed to a message that is sent by itself, or another controller.  You
should pass the Messages instance to the controller in the controller's constructor; in this way, the controller
can subscribe itself to messages and send messages to other controllers.

##### Assume that all controllers have an instance variable <code>messenger</code> of class Messages that was passed from the
app's initialization code.

#### Step 3: Use <code>messenger.subscribe(messageName, this)</code> to subscribe

Call <code>messenger.subscribe(messageName, this)</code> from inside the controller or <code>messenger.subscribe(messageName, controller)</code> 
from outside the controller where <code>messageName</code> is a string and <code>controller</code> is the controller instance.

#### Step 4: Send a message with <code>messenger.notify(messageName, [payload])</code>

Call <code>messenger.notify(messageName, [payload])</code> where 
<code>messageName</code> is a string and <code>payload</code> is any object descended from an <code>Object</code> class.
<code>payload</code> may be omitted.  All controllers that have subscribed to <code>messageName</code> will have their <code>messageHandler</code> methods 
that were defined in Step 2 executed.  