**CPEN 221 / Fall 2020 / Exercise 8**

# Evaluating Arithmetic Expressions

------

In this activity, you will evaluate arithmetic expressions in two different ways:

1. when the expression is provided in the postfix notation, and
2. when the expression is provided in the more common infix notation.

Through this activity, you will learn to work with stacks and [binary] trees.

## Evaluating Postfix Expressions

### Suggested Reading

- Wikipedia entry on 

   Postfix Notation

   - You are expected to support only the four basic arithmetic operations: addition, subtraction, multiplication and division.
      - You do not need to support unary operations such as unary - directly.

- Java's [Stack](http://docs.oracle.com/javase/8/docs/api/java/util/Stack.html) class

### Tasks

- Using the provided skeleton code, implement a method to evaluate an arithmetic expression given in Postfix notation.
- If the provided expression string is not in the correct form then, when evaluating the expression, a `MalformedExpressionException` should be thrown.

## Evaluating Infix Expressions using Binary Trees

This part of the activity demonstrates how to convert a provided arithmetic expression into an arithmetic expression tree. The example only works with fully parenthesized expressions with only three operations: addition, subtraction and multiplication.

The purpose of this example is to demonstrate the following:

- how to create simple *subtypes* using *subclassing* in Java (`extends`);
- how to parse a simple arithmetic expression;
- how to construct a binary tree;
- how to exploit the recursive nature of a binary tree;
- how to evaluate an arithmetic expression from its binary tree representation.

This activity involves infix arithmetic expression evaluation. This contrasts with postfix expression evaluation that used only a stack.

### Tasks

- Implement support for multiplication and division.

### Suggested Reading/Viewing

- Tutorial on [subclasses](http://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html) in Java
- [Binary trees](https://www.dropbox.com/s/gimc51wa6my7lhs/9-BinaryTrees.pdf?dl=0)
- Videos on binary trees: [Video 1](http://media.pearsoncmg.com/aw/aw_reges_bjp_2/videoPlayer.php?id=c17-1), [Video 2](http://media.pearsoncmg.com/aw/aw_reges_bjp_2/videoPlayer.php?id=c17-2), [Video 3](http://www.youtube.com/watch?v=FKvL3Duawv8)