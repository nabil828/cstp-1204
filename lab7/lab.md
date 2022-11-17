## SortaSquares

> The skeleton source code for this question is in the package `sortasquares`. You have to implement the method _getSortaSquares_ in the class _SortaSquare_.

A positive integer _n_ is a perfect square if and only if there is a positive integer _r_ such that _r * r = n_.

A _SortaSquare_ is a positive integer _n_ that can be expressed as _n = a * b * b_ for positive integers _a_, _b_ and _a < b_.

Given a `Set` of integers, return a `Set` that represents the subset of positive integers that are also SortaSquares.

#### Examples

+ { 16, 25 }
	+ Returns: { 16, 25 }
	+ _16 = 1 * 4 * 4_ and _25 = 1 * 5 * 5_.

+ { -1, 7, 18, 49 }
	+ Returns: { 18, 49 }
	+ _18 = 2 * 3 * 3_ and _49 = 1 * 7 * 7_

+ { 12, 125 }
	+ Returns: { }
	+ _12 = 3 * 2 * 2_ but it is not a SortaSquare because _3 > 2_. Similarly _125 = 5 * 5 * 5_ is not a SortaSquare because _5 = 5_.

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional standard Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.