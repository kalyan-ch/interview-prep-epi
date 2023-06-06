# interview-prep-epi
Preparation for interviews 
- 1 month course from elements of programming interviews
- Notable [Leetcode](https://leetcode.com/problemset/all/) problems in key concepts

## Trips and Tricks

### Primitive Types and Bit Manipulation

1. find if x is a power of 2 : `(x & (x-1)) == 0`
2. clear all bits to the left of a bit : `(num & ((1 << i)- 1))`
3. divide x by 2: `x >>= 1`
4. multiply x by 2: `x <<= 1`
5. find if x is even: `(n&1) == 0`
6. XOR with 0 retains the value of the bit while with 1 flips the value
7. clear the lowermost set bit - `num & (num -1)`
8. find `x % (power of 2)` : x & (twoPow - 1)

### Arrays
1. Simple brute force solutions in arrays involve additional space complexity of O(n). To use the array itself would be subtler and use O(1) space.
2. Filling an array from front is slow, so should see if it is possible to do this from the back.
3. instead of deleting an entry consider overwriting it since deletion involves shifting all the other elements.
4. Be comfortable dealing with sub-arrays - use different indexes for indicating start or end of each sub-arrays
5. Don't worry about the integrity of the array until it is time return it.

### Strings
6. Strings are immutable but character arrays and `StringBuilder` aren't.
7. To check if a string is a palindrome just compare the first and last character of the string until you reach the middle
8. Use Stringbuilder to construct Strings instead of appending characters to a String. O(n) vs O(n^2)

### Linked Lists
1. Similar to arrays, linked list problems also have trivial solutions involving O(n) space.
2. Consider using two iterators; many problems benefit from this
3. Arrays.asList() can be used to replace simple classes -> `Point` class vs `Arrays.asList(x,y)`

### Stacks and Queues
1. FIFO is ideal when order needs to be preserved
1. ArrayDeque for stacks - `addFirst(e), peekFirst(), removeFirst() - push(e), peek() and pop()`
1. LIFO is ideal when parsing is involved
1. ArrayDeque for Queues - `addLast(e), peekFirst(), removeFirst() - push(e), peek() and pop()`

### Binary Trees
1. Recursive algorithms are well suited for problems on trees. Therefore, the space complexity might increase because of the function call stack
2. Consider left and right skewed trees for complexity analysis
3. If a parent node exists we can use it to reduce time and space complexity

### Dynamic Programming

#### Framework for solving DP problems
 
Usually when a problem asks for maximum or minimum of anything and when choices need to be made at each step and when the current answer depends on answer in previous state, the problem can be solved using dynamic programming. 

DP problems can be solved in three main components:

1. Some data structure to store memoized results - usually an array that contains the state of current element. The next state is usually a sum, product or in some way related to current and/or previous states.
1. Recurrence relation - a way to transition between one state to the next. 
1. Base case - the absolute base case where we know the answer if only one element or one condition is considered.


## System Design

Software Interviews have design problems in them and below is a compilation of threads.

### Links

1. [System Design Primer](https://github.com/donnemartin/system-design-primer)
2. [Problems](https://github.com/donnemartin/system-design-primer#system-design-interview-questions-with-solutions)
3. [Scalability lecture - Harvard](https://www.youtube.com/watch?v=-W9F__D3oY4)
4. [Scalability for dummies](https://web.archive.org/web/20220530193911/https://www.lecloud.net/post/7295452622/scalability-for-dummies-part-1-clones)

### Steps to solve a system design interview question

1. Requirement Clarification
2. Back-Of-The-Envelope Estimate
3. System Interface Definition
4. Defining Data Model
5. High-level design
6. Low-level design
7. Identify Bottlenecks and resolve

### Design Problems and Solutions

1. [Twitter Timeline problem](system-design/twitter-timeline.md)
2. [Mint.com Website](system-design/mint-website.md)

### Common Object-Oriented Design Patterns
1. Template - defines a structure for sub-classes in which steps of an algo and their order are defined. Example - inheritance in java, interfaces, sub-classes etc.
2. Strategy - this is similar to template pattern but the algorithm is chosen at run time rather than at compile time. Example - different compression algos selected based on the type of compression  
3. Observer - in this pattern the observer objects subscribe to an observable object to be notified everytime there's any change in data. Two variants - __Push__ where the observable class pushes information to the observers and __Pull__ where the observers may pull the information from observable class. Push design puts control in observable class by making it the final controller of the information and the frequency of updates. Pull design puts control in observer classes by giving them the ability to customize aspects of information updates.   
4. Singleton - ensures that only one instance of the object exists throughout the session. Example - Loggers
5. Abstract Factory - provides an interface for creating families of related objects without having to specify the concrete classes. Example - interfaces in java
6. Factory method - defines an interface for creating an object but lets subclasses decide which class to instantiate.
7. Builder - enables specification of fields that are needed for object creation. Makes code readable. Example - when an object needs to be created with different fields set in different circumstances
8. Prototype - uses a clone method to duplicate existing objects to be used as prototypes for new instances. Example - creating similar objects especially when creating new objects in expensive. 
9. Adapter - allows interface of an existing class to be used from another instance. Example - when dealing with third party library code we often need to convert data from the type defined in our code to the type that works with the library code.
10. Flyweight - allows objects to be shared to reduce memory load. Example - object pools
11. Proxy - allows an object to act like a proxy - a lightweight version of the object and can be used in times of memory crunch. Example - like using a proxy image instead of real image for its metadata

