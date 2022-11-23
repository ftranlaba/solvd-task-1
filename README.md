# Solvd Task 1

Hello! I hope you are doing well! Welcome to my code. I have provided a sample console log output or an example of how
the program should look.

I have also provided a UML diagram. The classes marked in red are the ones I have implemented. As I was translating task
requirements to UML, I noticed a lot of overlapping properties in my data model. I went ahead and did requirement 1 and
3 together. If I begun with just requirement 1 then I would have done a lot of unnecessary repeated code. I also have
the revision history of me working on my UML diagram. If you would like to see that ping me.

With that being done, I went ahead and combined requirements 2 and 4 since its structure depends on how 1 and 3 is
structured.

For requirements 5 and 6, I used it throughout the project.

I did not use interfaces as it did not make sense in my data model. I wanted to pass on instance variables. My knowledge
on interfaces is that it's mainly used to differentiate functionality. For example, List can be implemented in different
ways. LinkedList has O(1) insertion and deletion compared to O(n) ArrayList. However, ArrayList beats LinkedList when it
comes to accessing and adding objects O(1) vs O(n)
The interface List abstracts the functionality of both implementations.

NOTE: I did not implement all the classes in my UML diagram because I figured out the algorithm to creating child
classes from abstract classes.

1) If the child class is abstract then it does not need to override abstract functions
2) If the child class is not abstract then it needs to override abstract functions
3) The child class needs to use super(n1, n2, .. n) in its constructor to initialize its inherited proeprties.
4) @Override must be used when overriding a method

## Resources Used

https://www.baeldung.com/java-interfaces

https://www.baeldung.com/java-abstract-class

https://www.baeldung.com/java-interface-vs-abstract-class

https://www.baeldung.com/java-abstract-classes-constructors

https://www.geeksforgeeks.org/inheritance-in-java/

https://www.geeksforgeeks.org/static-blocks-in-java/

https://www.geeksforgeeks.org/final-keyword-in-java/

Ping me if you have questions, comments, or concerns. Thank you for your time!