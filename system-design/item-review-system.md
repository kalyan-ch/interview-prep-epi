# Item Review System

Design a feature that accepts reviews from customers for an item ordered in a delivery app. Show the average rating for an item for each item under a store.

## Requirements

### Functional requirements

1. Users should be able to review items on their order. Review consists of rating value (number out of 5) and review text. 
2. Users should be able to see the average rating of reviews on each item when they visit a restaurant / store.
3. Users should be able to see top reviews for the item when they click on the item

### Non-functional requirements

1. System should be highly available so need not be consistent - eventual consistency should suffice 
2. System will be read heavy (10:1) as more users will read reviews / ratings as opposed to writing the same.

### Constraints and Scale determination

1. 100M DAU - 10 million daily writes / 100M daily reads
2. review - id(4), reviewText(255), rating(1), userId(4), itemId(4) - 270 bytes per review / 10M * 264 = 2.5 GB per day or ~10 TB for 10 years 
3. AverageRating - id, itemId, averageRating - 24 bytes * 30M items total = 1 GB   

## Data model

1. Review - id, userId, itemId, text, rating, totalUpvotes 
2. AverageRating - id, itemId, averageRating

## Core Components

These APIs will be used in the system.

1. write_review(userId, itemId, reviewText, rating);
   1. persists review to DB
   2. slow operation
2. rate_review(isHelpful);
   1. rates a review with either - is Helpful / not helpful
   2. helps gauge quality of reviews
   3. updates the review record in the record table with increment / decrement to the current value
3. get_avg_rating(itemIdList);
   1. gets the average rating of a list of item
   2. this needs to be called when - user visits app home when app displays popular dishes in the area or when the user visits store home page
   3. input list changes based on where the user is
   4. since this is the heaviest service by call volume, the data for the service needs to reside in cache
4. get_reviews_for_item(itemId);
   1. this service gets top 5 most helpful reviews for a food item when the item is clicked
   2. sends the list of reviews to the UI system to display it 
   3. this needs to be fast - low latency
   4. can utilize cache to quickly get the reviews for relevant items for the user
5. calculate_average_rating(itemId);
   1. this service calculates average rating of an item based on all reviews
   2. gets all reviews for an itemId, performs calculation and persists to average rating table
   3. this service can run within the DB itself in terms of a store procedure or can run as a batch process 

## High Level Design

![item-review-system-hld](https://i.imgur.com/XFsJGqX.jpeg)

## Core Component design

The functionality of `write_service` and `rate_review` is straightforward - write data to DB directly. since the data need not be consistent, slow writes are fine. Since we will incorporate data redundancy, eventual consistency is achieved.