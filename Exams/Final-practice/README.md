Programming Test
=========

## General Instructions

+ There are two questions that you need to complete.
+ You have 125 minutes (2h 05m) to complete the tasks.
+ Take your time to read the questions. 
+ Skeleton code can be obtained by cloning this repository. Add JUnit to your build path in Eclipse.
+ Best of luck!


## Question 1: Permutation Cipher

> The skeleton source code for this question is in the package `permutationcipher`. The main task is to implement the method `encrypt` in the class `PermutationCipher`, but you also have to define `IllegalKeyException` as needed.

Your goal is to implement an encryption scheme that produces _ciphertext_ (the encrypted message) by taking the _plaintext_ (the original message) and permuting the symbols in the plaintext.

To perform the encryption of a `String` with _n_ characters, one takes a permutation array with _n_ integers, `int[ ] permutationArray`. For a single round encryption, the i<sup>th</sup> character &mdash; assuming that the starting character is at index 0 &mdash; will appear at index position `permutationArray[i]`. (We will assume 0-based indexing where the first character has position index 0.)

> Example: If the plaintext `String` was "abc" and the `permutationArray` was `{1, 2, 0}` then the ciphertext `String` would be "cab". 

For multi-round encryption, one can repeat the process multiple times. 

> Example: To continue with the example using "abc" and `permutationArray` `{1, 2, 0}`, after two rounds of encryption we would obtain "bca" as the ciphertext.
	 
Clearly, for this operation to work correctly, the length of the plaintext and the permutation array must be identical. Further, if the permutation array has length _n_ then its contents must be a permutation of the integers between 0 and n-1, both limits inclusive. If the permutation array does not satisfy these requirements then your implementation should throw a checked exception named `IllegalKeyException`.

#### Example 1
+ Plaintext: "abc"
+ Permutation array: { 1, 2, 0 }
+ Rounds of encryption: 1
+ Returns: "cab"

#### Example 2
+ Plaintext: "abcde"
+ Permutation array: {4, 3, 2, 1, 0}
+ Rounds of encryption: 1
+ Returns: "edcba"

#### Example 3
+ Plaintext: "abcde"
+ Permutation array: {4, 3, 2, 1, 0}
+ Rounds of encryption: 2
+ Returns: "abcde"

> This is the same message and the same key as in Example 2, but now with two rounds of encryption, so we scramble the message twice. For this particular key we see that each scrambling reverses the order of letters, which means that the final message is the same as the original we started with.

#### Example 4
+ Plaintext: "uogcodlk"
+ Permutation array: {4, 3, 6, 2, 5, 1, 0, 7}
+ Rounds of encryption: 44
+ Returns: "goodluck"

#### Example 5
+ Plaintext: "tomorrow"
+ Permutation array: {7, 3, 4, 4, 5, 2, 1, 0}
+ Rounds of encryption: 8
+ `IllegalKeyException` should be thrown because the permutation array is not a permutation of {0, 1, 2, 3, 4, 5, 6, 7}.

## Question 2: Travel on the Number Line

> The skeleton source code for this question is in the package `numberlinetravel`. Your task is to implement the method `howManyCitiesCanIVisit` in the class `NumberLineTravel`.

We've had the feeling that the world was flat only to have that sense of comfort shattered by the fact that the world is sort-of a sphere. Now imagine that the world is a line (beautiful &mdash; if you admire linearity!) starting at the smallest possible integer and ending at the largest possible integer that Java can represent. 

Cities are located at certain integer points on this line, and travel from one city to another is achieved via a monorail system. If we think of the line as having an east-west orientation then the monorail system has trains travelling in both directions with no wraparound (you do not go from maximum integer to minimum integer). 

If your world is defined by cities at locations x0, x2, ..., xN, and you have a Compass Card that allows you to travel K kilometres on the monorail in one journey, how many cities can you reach assuming you start at x1 and are allowed an inifinite number of trips with only the K km distance restriction?

Specifically, you are given an array `int[ ] x` that provides the city locations and the valid travel distance `K`. You start your travels from your home at `x[0]`. You can change trains at intermediate cities but a single monorail trip cannot cover more than a distance of `K`.
+ There are no restrictions on how often you return home, etc. 
+ You are only interested in boasting to your friends about the number of _unique_ cities you have visited so you have to plan your trips by developing this program that will compute the number of cities you can visit. 
+ Do not include your home city in the list of cities visited.

> For simplictity we will assume that the linear world works in kilometer increments.

#### Example 1
+ x = {4, 7, 1, 3, 5}
+ K = 1
+ Return 2

> You start at 4, and cities 3 and 5 are both 1 km from 4, and your travel limit is 1 km. So you can visit two unique cities.

#### Example 3

+ x = {100, 101, 103, 105, 107}
+ K = 2
+ Returns: 4

> You can reach 101, 103, 105 and 107 (100 -> 101 -> 103 -> 105 -> 107) with your Compass Card.
    	
#### Example 3
+ x = {17, 10, 22, 14, 6, 1, 2, 3}
+ K = 4
+ Return 6

#### Example 4
+ x = {0}
+ K = 1000
+ Return 0

> Alas, a boring world!

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes (except where specified).
+ You can use additional standard Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.

