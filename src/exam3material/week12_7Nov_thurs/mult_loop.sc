// #Sireum #Logika
//@Logika: --manual --background disabled


///multiplication by repeating patterns

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//finding x*y by doing x + x + x + ... + x (y times)
def mult(x: Z, y: Z): Z = {
  //What can we use as the function contract?

  var total: Z = 0
  var i: Z = 0
  //must prove loop invariant//////////////////////////
  Deduce( total == 0)

  while (i != y) {
    //what should the loop invariant be?
    Invariant(
      Modifies(total, i),// since these change                                  0 1 2 3
      //invariant                                                                      //x
      total == i * x                                                                  //i
      //what should the loop invariant be? a relationship between total and i. ___________________total  == 1 + x

    )

    //assume loop invariant holds here (premise)

    total = total + x
    Deduce(
      1 (total == Old(total) + x) by Premise,
      2 (Old(total) == i*x) by Premise, //from loop invatient
      3 ()
    )

    i = i + 1

    //Step 2: need to prove that invariant still holds
    //total = x to prove that invariant still holds
  }

    //must prove  that total == x*y from precondition
    //we proved the invariant both outside the loop and inside it too
  return total
}

//////////// test code /////////

val a: Z = 5
val b: Z = 4

//Step 1: prove the precondition

var ans: Z = mult(a, b)

//what do we want to assert that it is?