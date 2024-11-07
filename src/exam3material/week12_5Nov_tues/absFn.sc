// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

def absVal(numOrig: Z) : Z = {
  //what do we need here?
  Contracts(
    Ensures(
      Res[Z] >=0
      Res[Z] == numOrig |
    )
  )

  var num: Z = numOrig

  //update num to be the absolute value of the input
  if (num < 0) {
    num = num * -1


    Deduce(
      1 ( num == Old(num) * -1) by Premise,
      2 ( Old(num) < 0) by Premise,

      //need nu >=0
      //num == numOrig or num == -1 * numOrig
    )
  } else {
    //do nothing -- num is already its own absolute value

    Deduce()


    //need nu >=0
    //num == numOrig or num == -1 * numOrig
  }
  sumarize
  deduce(
    1 (num >=0) by premise,
    2 ()
  )
  //these were our old asserts
  //assert(num >= 0)
  //assert(num == numOrig | num == -1 * numOrig)
  //what do we return?

  //prove num is >= to 0
  // the thing im returnig is the og paramenter or -1*og parameter

  //in order to prove it, we need to show that after both if,
  //it holds true

  return num
  //put the assets as post conditions
}

//we need a deduce with the post conditon without asserting
deduce(

)
////////////////// Test code //////////////

val x: Z = -4

//use function to get absolute value of x
//what *should* the absolute value be?
