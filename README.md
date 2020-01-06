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
2. LIFO is ideal when parsing is involved

### Binary Trees
1. Recursive algorithms are well suited for problems on trees. Therefore, the space complexity might increase because of the function call stack
2. Consider left and right skewed trees for complexity analysis
3. If a parent node exists we can use it to reduce time and space complexity
 

