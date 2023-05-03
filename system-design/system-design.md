# System Design

Source: grokking-the-system-design-interview

## Key characteristics of distributed systems

1. Scalability - Scalability is the capability of a system to grow and manage increased demand - increased data volume, increased amount of work etc., without losing any performance. Horizontal scaling is scaling by adding more machines to the existing pool. It is easier to scale dynamically this way than vertically. MongoDb and Cassandra use horizontal scaling. Vertical scaling is scaling by adding more power (RAM, Processor etc.) to the existing pool of machines. This type of scaling is limited by individual machine capacity. Good example is MySQL.
2. Reliability - Reliability is the probability a system might fail in a given period. A distribute system is reliable if it continues to deliver the services even if one of more software or hardware components fail. Achieving this might lead to redundancy. 
3. Availability - Availability is the time a system remains operational to perform its function in a given period. Usually measured in percentages. Reliability vs Availability - if a system is reliable it is available. However, if it is available, it is not necessarily reliable. 
4. Efficiency - Efficiency is the performance of a given service or system. 
5. Manageability or Servicability - This is the simplicity with which a system can be repaired or manitained. If this process is too complex or time taking, the availability of the system decreases. Ease of diagnosing, ease of making updates and ease of operation also factor into defining the Manageability of a system. 


## Load Balancing

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

## Caching

Caching enables for vastly better use of resources we already have. Caches take advantage of locality of reference principle: recently requested resource is likely to be requested again. Caching can be used between every layer but often used near to the front-end layer.

Application Server Cache - a response data is stored in the cache and when the request is received the node checks the cache and returns it if found or it fetches the data from the service. 

Content Distribution Network (CDN) - CDN serves large amounts of static media. CDN will serve the file if it is in cache or it will fetch the file from back-end service. Only used for large systems.

Cache invalidation - cache requires invalidation for removing wrong or old data. Following are the algorithms for effective cache invalidation:

1. Write-through cache - write data to cache and database at the same time. This has higher latency since write operation is performed more than once. 
2. Write-around cache - write data to database directly bypassing cache. This method will require the cache to get data from database later and will cause "cache-miss"
3. Write-back cache - write data to cache only. perform database persistance from cache at regular intervals. This is efficient but there is a risk of data loss in the event of a crash or power failure. 

Cache Evicition policies:

1. FIFO - cache evicts the first block of data accessed first without any other considerations.
2. LIFO - cache evicts the block accessed most recently without any other considerations.
3. LRU - cache evicts the least recently used items first
4. MRU - cache evicts the most recently used items first
5. LFU - cache evicts the least frequently used items first
6. RR - cache randomly evicts an item

## Data Partioning

Data Partioning - split a database / table into many machines to improve Manageability, performance and availability. We need a load balancer here.

In Horizontal Partioning, the data is split based on a range of values, like all records with even ids in one table and odd ids in another. The split should be chosen carefully as the tables can be unevenly balanced. This is also called Data Sharding.

In Vertical Partioning, the data is split into different servers. Like storing user information in one database in one server, posts in another server etc. This is easier to implement and has low impact on the system. Depending on the size, the data within each server has to be split horizontally.

In Directory based Partioning, we have a directory server that abstract the partioning schema away from the database and queries data based on a key-value kind of logic. 

Partioning Criteria: 
1. Hash-based: a hash function is applied to the key attributes of data which yields a partition number. This approach is not flexible with the number of db servers changing.
2. List: each partition is assigned a list of values.
3. Round robin: store data in partition `i mod n`, ith record and n partitions.
4. Composite: combination of any of the above

Problems:

a. joins on tables when data and databases are split, yield bad performance . A workaround is to denormalize the data but this would mean redundancy and inconsistency.
b. Enforcing referencial integrity constraints could be hard. This would mean extra effort to clean or correct data.
c. There might be an effort to rebalance data on different servers, which means create more db servers or split huge tables across databases again.

## Indexes

Indexes are used in database tables to hasten up search queries. Indexes should only be used in tables if the tables are used more heavily for reading than for writing. Indexes increase the time taken to write to a table.

## SQL vs NoSQL

In SQL databases, the data is stored in a structured fashion like, according to the principles of RDBMS. In NoSQL databases, data is stored in the form of documents, key-value pairs or graphs etc. which don't follow a definite structure. 

SQL databases are schema-based (all data types and relationships should be determined beforehand), use some form of Structured Query Language (SQL) and are vertically scalable more easily than are horizontally scalable. NoSQL databases have dynamic schemas, use Unstructured query languages which differ with database and are easily horizantally scalable. 

Since SQL databases are generally `ACID (Atomicity, Consistency, Isolation, Durability)` compliant, they are better in terms of safe transactions and data reliability. Since NoSQL databases are easily scalable and easier for development, they are better when an MVP needs to be pushed out fast.

## CAP Theorem

CAP Theorem states that it is impossible to achieve all of Consistency, Availability and Partition Tolerance in a single system.

## Consistent Hashing
Consistent Hashing

## Long-Polling vs WebSockets vs Server-sent Events
events









