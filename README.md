# interview-prep-epi
Preparation for interviews - 1 month course from elements of programming interviews

## Trips and Tricks

### Primitive Types and Bit Manipulation

1. find if x is a power of 2 : (x & (x-1)) == 0
2. clear all bits to the left of a bit : (num & ((1 << i)- 1))
3. divide x by 2: x >>= 1
4. multiply x by 2: x <<= 1;
5. find if x is even: (n&1) == 0
6. XOR with 0 retains the value of the bit while with 1 flips the value
7. clear the lowermost set bit - num & (num -1)

### Arrays and Strings
1. Simple brute force solutions in arrays involve additional space complexity of O(n). To use the array itself would be subtler and use O(1) space.
2. Filling an array from front is slow, so should see if it is possible to do this from the back.
3. instead of deleting an entry consider overwriting it since deletion involves shifting all the other elements.
4. Be comfortable dealing with subarrays.
5. Don't worry about the integrity of the array until it is time return it.
6. Strings are immutable but character arrays and `StringBuilder`s aren't.
7. To check if a string is a palindrome just compare the first and last character of the string until you reach the middle

### Linked Lists
1. Similar to arrays, linked list problems also have trivial solutions involving O(n) space.
2. Consider using two iterators; many problems benefit from this
3. Arrays.asList() can be used to replace simple classes -> `Point` class vs `Arrays.asList(x,y)`
