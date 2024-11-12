// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//want to return x * y, through repeated addition
//recursively compute x + x + ... + x (y times)
def mult(x: Z, y: Z): Z = {
  //what goes here?
  //what should we require?
  //what should we ensure?

  Contract(
    Requires(y>=0),//we need y to be greater than 0 so it is able to stop
    Ensures(Res[Z] == x*y)
  )




  //we want answer to hold our calculation
  var answer: Z = 0

  if (y == 0) {
    answer = 0

    Deduce(
      1 ( answer ==0 ) by Premise,
      2 ( y == 0) by Premise,
      3 ( answer == x*y) by Algebra*(1,2)
    )

    //what do we need to do here?
    //prove post condition
  }

  else {
    //what do we need to do here?
    //prove precondition

    Deduce(
      1 (!y ==0),//need exacly y-1 >=0
      2 (y >=0) by Premise, // from precondition
      3 (y-1 >=0) by Algebra*(1,2)// proves precondition
    )

    var temp: Z = mult(x, y-1)
    answer = x + temp //adds the last one we need

    //show the post condition

    Deduce(
      1 (temp == x * (y-1))by Premise // from post condition of recusive call
      2 ( answer == x+ temp) by Premise,// from assignment statement
      3 ( answer == x+10  + x*(y-1)) by Algebra*(1,2),
      4 ( answer == x*y) by Algebra(3)
    )

    //what do we need to show here?
  }

  //what do we need to do here?

  Deduce(
    1 (answer == x*y) by Premise, // in both sides

  )

  return answer
}

////////////// Test code //////////////

val a: Z = 5
val b: Z = 4



//Step 1: prove the precondition

Deduce(
  1 ( b ==4) by Premise,
  2 (b >= 0 ) by Algebra*(1),
)

var ans: Z = mult(a, b)

//what do we want to assert that ans is?

//must use post condition of the function

Deduce(
  1 (ans == a*b) by Premise,//say the post condition of the function
  2 (a ==5) by Premise,
  3 ( b == 4) by Premise,
  4 (ans ==20 by Algebra*(1,2,3))
)

assert(ans == 20)