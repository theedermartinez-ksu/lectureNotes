// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._

val x: Z = Z.prompt("Enter first number: ")
val y: Z = Z.prompt("Enter second number: ")

//how do we assume x is bigger than y?
//we assume

assume(x>=y)

deduce(
  (x>=y) by Premise
)

val max: Z = x

deduce(
  1(x>=y) by Premise,
  2 (max ==x) by Premise,
  3 (max >= x ) by Algebra* (2),
  4 (max >=2) by Algebra*(1,2),
  5 (max >= x ^  max >=2) by AndI(3,4),
  6 (max ==x | max ==y) by OrI(2)
)

//what can we put in a proof block here?


//how do we assert max is the biggest between our two inputs?

assert(max >=x ^ max >=y)
assert(max ==x, max == y)
