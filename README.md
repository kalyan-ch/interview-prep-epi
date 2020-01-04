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

### Arrays and Strings
#### Arrays
1. Simple brute force solutions in arrays involve additional space complexity of O(n). To use the array itself would be subtler and use O(1) space.
2. Filling an array from front is slow, so should see if it is possible to do this from the back.
3. instead of deleting an entry consider overwriting it since deletion involves shifting all the other elements.
4. Be comfortable dealing with sub-arrays - use different indexes for indicating start or end of each sub-arrays
5. Don't worry about the integrity of the array until it is time return it.

#### Strings
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
 
### System Design

#### Key characteristics of distributed systems

##### Scalability 

Scalability is the capability of a system to grow and manage increased demand - increased data volume, increased amount of work etc., without losing any performance.

Horizontal scaling is scaling by adding more machines to the existing pool. It is easier to scale dynamically this way than vertically. MongoDb and Cassandra use horizontal scaling

Vertical scaling is scaling by adding more power (RAM, Processor etc.) to the existing pool of machines. This type of scaling is limited by individual machine capacity. Good example is MySQL.

##### Reliability

Reliability is the probability a system might fail in a given period. A distribute system is reliable if it continues to deliver the services even if one of more software or hardware components fail. Achieving this might lead to redundancy. 

##### Availability

Availability is the time a system remains operational to perform its function in a given period. Usually measured in percentages. 

Reliability vs Availability - if a system is reliable it is available. However, if it is available, it is not necessarily reliable. 


##### Efficiency

Efficiency is the performance of a given service or system. 

##### Manageability or Servicability

This is the simplicity with which a system can be repaired or manitained. If this process is too complex or time taking, the availability of the system decreases. 

Ease of diagnosing, ease of making updates and ease of operation also factor into defining the Manageability of a system. 


#### Load Balancing

Load balancer spreads the traffic across the cluster of servers to improve availability and performance of a system. It avoids any server to be a single 
point of failure and keeps availability high by spreading the traffic.

It should ideally keep track of all the servers and stop sending traffic to any servers that are down for whatever reason.

We can add a load balancer at each layer of the system to ulitize full scalability: between clients and web servers, between web servers and app servers, between app servers and database etc.

Load balancing algorithms chose a backend server by consiering if the server is healthy. If there are many servers that are healthy one is chosen using:

1. Least Connection Method - server with fewest active connections.
2. Least Responsive Time Method - server with fewest active connections and least average response time. 
3. Least Bandwidth Method - server with least amount of traffic measured in Mbps
4. Round Robin Method - cycle through list of servers and issue request to the next server. starts from beginning if it reaches the end. 
5. Weighted Round Robin Method - same as the above but each server is assigned a weight based on processing capacity and the LB selects next heaviest server
6. IP Hash - a hash of IP addresses of servers is maintained and request is redirected to one of them.

