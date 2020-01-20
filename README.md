# interview-prep-epi
Preparation for interviews - 1 month course from elements of programming interviews

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
8. Use Stringbuilder to construct Strings instead of appending characters to a String.

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
 
### System Design

#### Steps to solve a system design interview question

1. Requirement Clarification
2. Back-Of-The-Envelope Estimate
3. System Interface Definition
4. Defining Data Model
5. High-level design
6. Low-level design
7. Identify Bottlenecks and resolve

### Behavioral Questions

1. Why do you want to work for X company?
1. Why do you want to leave your current/last company?
1. What are you looking for in your next role?
1. Tell me about a time when you had a conflict with a co-worker.
1. Tell me about a time in which you had a conflict and needed to influence somebody else.
1. What project are you currently working on?
1. What is the most challenging aspect of your current project?
1. What was the most difficult bug that you fixed in the past 6 months?
1. How do you tackle challenges? Name a difficult challenge you faced while working on a project, how you overcame it, and what you learned.
1. What are you excited about?
1. What frustrates you?
1. Imagine it is your first day here at the company. What do you want to work on? What features would you improve on?
1. What are the most interesting projects you have worked on and how might they be relevant to this company's environment?
1. Tell me about a time you had a disagreement with your manager.
1. Talk about a project you are most passionate about, or one where you did your best work.
1. What does your best day of work look like?
1. What is something that you had to push for in your previous projects?
1. What is the most constructive feedback you have received in your career?
1. What is something you had to persevere at for multiple months?
1. Tell me about a time you met a tight deadline.
