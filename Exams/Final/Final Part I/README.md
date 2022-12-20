
Problem Solving Practice
=========

## Question: Overlapping Ranges

Suppose you want to devise a method to schedule a meeting between many friends tomorrow. Each of them provides a time range for when they are available (in 24-hour format). A suitable meeting time would when a majority of time ranges overlap.

To make the problem a bit more precise and a bit more general, suppose a range is on the non-negative number line with each endpoint being an integer, and the first endpoint being smaller than the other. 

+ `5` to `12` is a valid range. 
+ `-10` to `20` is not a valid range because one endpoint is negative. 
+ `10` to `33.6` is not a valid range because one of the endpoints is not an integer. 
+ `32` to `11` is not a valid range because the first endpoint should be smaller than the second endpoint.
+ `11` to `11` is not a valid range because the first endpoint is not smaller than the second endpoint (this condition also eliminates empty ranges).

The problem to solve is as follows: Given `N` ranges, find the *smallest integer* that is included in the maximum number of ranges.

#### Examples

1. Range1 is 1 to 6. Range2 is 2 to 5. Range3 is 3 to 4. Range4 is 7 to 10. In this example, 3 is the smallest integer present in a maximum number of ranges.
1. Range1 is 2 to 5. Range2 is 1 to 10. In this example, 2 is the smallest integer present in the maximum number of ranges.
1. Range1 is 10 to 15. Range2 is 1 to 20. Range3 is 11 to 25. Range4 is 0 to 2. In this example, 11 is the smallest integer present in the maximum number of ranges.

#### Notes

1. The ranges will be provided as arguments to the method to implement using two `ArrayList`s. The first `ArrayList` will contain the starting points of all the ranges. The second `ArrayList` will contain the end points of all the ranges. The i-th entry in each `ArrayList` corresponds to the i-th range.
1. Improperly constructed or invalid ranges should be ignored.
1. If the ranges do not overlap then a `NoOverlapException` should be thrown.