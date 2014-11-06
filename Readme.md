### Messaging for module communication in MVC Java framework programs

This java package includes classes necessary to include messaging between controllers in an MVC framework
Java application.

#### Instructions:

#### Step 1: Your app must instantiate an instance of class Messenger.  

You may have more than one instance of
this class providing multiple message spaces.  You should subscribe pass the instance(s) of Messages to the 
controllers in your app so the controllers can subscribe to messages and send messages to other controllers.

#### Step 2: All modules in your app must be descendants of the <code>MessageHandler</code> interface.  

Your controller must implement 
the message handler method <code>public void messageHandler(String messageName, Object messagePayload);</code>.  This method will be executed
by Messenger when the module is subscribed to a message that is sent by itself, or another module.  You
should pass the Messenger instance to the module in the module's constructor; in this way, the module
can subscribe itself to messages and send messages to other modules.

##### Assume that all modules have an instance variable <code>messenger</code> of class Messenger that was passed from the app's initialization code.

#### Step 3: Use <code>messenger.subscribe(messageName, this)</code> to subscribe

Call <code>messenger.subscribe(messageName, this)</code> from inside the module or <code>messenger.subscribe(messageName, module)</code> 
from outside the module where <code>messageName</code> is a string and <code>module</code> is the module instance.

#### Step 4: Send a message with <code>messenger.notify(messageName, [payload])</code>

Call <code>messenger.notify(messageName, [payload])</code> where 
<code>messageName</code> is a string and <code>payload</code> is any object descended from an <code>Object</code> class.
<code>payload</code> may be omitted.  All modules that have subscribed to <code>messageName</code> will have their <code>messageHandler</code> methods 
that were defined in Step 2 executed.  
