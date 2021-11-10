# Problems
This chapter includes 18 problems that involve objects, immutability, and
switch expressions. The chapter starts with several problems about dealing
with null references. It continues with problems regarding checking indexes,
equals() and hashCode(), and immutability (for example, writing immutable
classes and passing/returning mutable objects from immutable classes). The
last part of the chapter deals with cloning objects and the JDK 12 switch
expressions. By the end of this chapter, you will have a fundamental
knowledge of objects and immutability. Moreover, you will know how to deal
with the new switch expressions. These are valuable and non-optional bits of
knowledge in any Java developer's arsenal.

Problems
Use the following problems to test your object, immutability, and switch
expression programming prowess. I strongly encourage you to give each
problem a try before you turn to the solutions and download the example
programs:

40. Checking null references in functional style
and imperative code: Write a program that performs the null
checks on the given references in a functional style and
imperative code.
41. Checking null references and throwing a customized
NullPointerException error: Write a program that performs
the null checks on the given references and throws
NullPointerException with custom messages.
42. Checking null references and throwing the specified
exception (example, IllegalArgumentException): Write a
program that performs the null checks on the given references
and throws the specified exception.
43. Checking null references and returning non-null default
references: Write a program that performs the null checks on
the given reference, and if it is non-null, then return it; otherwise,
return a non-null default reference.
44. Checking the index in the range from 0 to length: Write a
program that checks whether the given index is between 0
(inclusive) and the given length (exclusive). If the given index is
out of the [0, given length] range, then
throw IndexOutOfBoundsException.
45. Checking the subrange in the range from 0 to
length: Write a program that checks whether the given subrange
[given start, given end] is within the bounds of the range from [0,
given length]. If the given subrange is not in the [0, given
length] range, then throw IndexOutOfBoundsException.
46. equals() and hashCode(): Explain and exemplify how equals()
and hashCode() methods work in Java.
47. Immutable objects in a nutshell: Explain and exemplify
what is an immutable object in Java.
48. Immutable string: Explain why the String class is immutable.
49. Writing an immutable class: Write a program that represents
an immutable class.
50. Passing/returning mutable objects to/from an
immutable class: Write a program that passes and returns a
mutable object to/from an immutable class.
51. Writing an immutable class via the Builder
pattern: Write a program that represents an implementation of
the Builder pattern in an immutable class.
52. Avoiding bad data in immutable objects: Write a program
that prevents bad data in immutable objects.
53. Cloning objects: Write a program that exemplifies shallow and
deep cloning techniques.
54. Overriding toString(): Explain and exemplify practices for
overriding toString().
55. switch expressions: Provide a brief overview of the switch
expressions in JDK 12.
56. Multiple case labels: Write a snippet of code for exemplifying
the JDK 12 switch with multiple case labels.
57. Statement blocks: Write a snippet of code for exemplifying the
JDK 12 switch with case labels that point to a curly-braced block.