# interview-prep-epi
Preparation for interviews 
- 1 month course from elements of programming interviews
- Notable [Leetcode](https://leetcode.com/problemset/all/) problems in key concepts

## Trips and Tricks

### Seven steps to solving a problem

1. Listen for clues in the problem
2. Draw a generic and large example for the problem
3. Come up with a brute force algorithm
4. Optimize it - most of the time in the interview is to be spent here
5. Walk through the example with algorithm
6. Write Code
7. Verify everything

### Coding

1. Wait until you and your interviewer are ready - wait for the optimized algorithm to be ready.
2. Write code that is correct, readable, maintainable and efficient
3. Use the features of the language
4. Use consistent writing style
5. Think about corner cases, edge cases etc.
6. Write structured code - modularize

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
1. Strings are immutable but character arrays and `StringBuilder` aren't.
2. To check if a string is a palindrome just compare the first and last character of the string until you reach the middle
3. Use Stringbuilder to construct Strings instead of appending characters to a String. O(n) vs O(n^2)

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

