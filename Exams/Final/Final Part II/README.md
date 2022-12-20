Programming Test
=========



## Honour Code

By submitting your work to Github you agree to the following:

+ You did not consult with any other person in completing the examination.
+ You did not aid any other person in the class in completing their examination.
+ If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
+ You are not aware of any infractions of the honour code for this examination.


## Go Ahead, Make That a Fibonacci Number

> The skeleton source code for this question is in the package `fibonacciTransform`. You have to implement the methods `isPossible_onlyOneDoubling` and `isPossible` in the class `FibTransform`.

You are given an integer `n` and you want to determine if it is possible to transform `n` to a Fibonacci number in at most `m` steps, where `m` is also a given bound. At each step, you can:
* add 1 to the number at hand (addition step),
* or multiply it by 2 (doubling step).

Implement two methods:

1. The first method, `isPossible_onlyOneDoubling`, where you check if `n` can be transformed into a Fibonacci number using *at most* `m` steps in total, and of these steps *at most one can be a doubling step*. The doubling does not have to be the first or last step (see the examples). **If you complete only this method correctly then you will receive partial credit of 50% for this question.**

2. The second method, `isPossible`, generalizes the earlier method to permit any number of `+ 1` or `* 2` operations as long as the total number of operations is no more than `m`.

See the skeleton code for preconditions for these methods. We are only interested in Fibonacci numbers that can be represented using the Java types `Integer` or `int`.

For this implementation, we will consider the Fibonacci sequence to be 0, 1, 1, 2, 3, 5, 8, 13, 21, ...

### Examples

+ `n` = 10, `m` = 3
	+ One can obtain 21 as follows: `(10 * 2)+1`.
	+ Both `isPossible_onlyOneDoubling(10, 3)` and `isPossible(10,3)` should return `true`.
+ `n` = 22, `m` = 3
	+ One can obtain 89 as follows: `((22*2)*2)+1`
	+ `isPossible_onlyOneDoubling(22, 3)` should return `false` and `isPossible(22, 3)` should return `true`.
+ `n` = 6, `m` = 2
	+ We can obtain 8 as: `(6+1)+1`.
	+ Both `isPossible_onlyOneDoubling(6, 2)` and `isPossible(6, 2)` should return `true`.
+ `n` = 8, `m` = 10
	+ 8 is already a Fibonacci number. No transformation steps are needed.
	+ Both `isPossible_onlyOneDoubling(8,10)` and `isPossible(8,10)` should return `true`.
+ `n` = 0, `m` = 0
	+ 0 is already a Fibonacci number for our purposes. No transformation steps are needed.
	+ Both `isPossible_onlyOneDoubling(0, 0)` and `isPossible(0, 0)` should return `true`.
+ `n` = 20, `m` = 0
	+ 20 is not a Fibonacci number. We cannot transform it into a Fibonacci number in 0 steps.
	+ Both `isPossible_onlyOneDoubling(20, 0)` and `isPossible(20, 0)` should return `false`.
+ `n` = 24, `m` = 6.
	+ 24 can be transformed to 55: `((((24+1)+1)+1)*2)+1`.
	+ Both `isPossible_onlyOneDoubling(24, 6)` and `isPossible(24, 6)` should return `true`.
+ `n` = 1000, `m` = 18.
	+ 1000 can be transformed to 514229 in 18 steps with more than one doubling.
	+ `isPossible_onlyOneDoubling(1000, 18)` should return `false` and `isPossible(1000, 18)` should return `true`.

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional standard Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.
+ **You will receive no credit if any part of your submission fails to compile.** Make sure that you only use standard Java libraries (your import statements should only use libraries that begin with `java.`; for example `import java.util.Set` is fine).
