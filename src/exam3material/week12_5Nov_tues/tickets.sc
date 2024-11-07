// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.prop._

//adult tickets: $50
//kid tickets: $30
def getTicketCosts(adult: Z, kid: Z): Z = {
  //function contract
  Contract(
    Requires(adult >= 0, kid >= 0),//restriction on the parameters
    Ensures(
      //what should we promise?//what is returned
      //we can use res[Z]
      Res[Z] == adult *50 + kid *30,
      Res[Z] >= 0
    )
  )

  //Step 2: list preconditions as premises


  //get the total ticket cost
  val overall: Z = adult*50 + kid*30

  //Step 3: prove we have satisfied the postconditions
  //before returning from the fucntion
  // we can be sure if that was in the precondition, we can say
  // any precondition as premises

  Deduce(
    1 ( overall == adult *50 + kid*30) by Premise,
    2 (adult >= 0) by Premise,
    3 (kid >= 0) by Premise,
    4 (overall >= 0) by Algebra*(1,2,3)
  )

  return overall
}

////////////// Test code /////////////////

val k: Z = 3
val a: Z = 2

// Step 1 - prove the precondition before calling the function

Deduce(
  1 (k ==3 ) by Premise,
  2 ( a == 2) by Premise,
  3 (a >=0) by Algebra*(2),
  4 (k >= 0) by Algebra*(1)
)

val cost: Z = getTicketCosts(a, k)

Deduce(
  1 ( cost == a*50 + k*30) by Premise, // use postcondition from function
  2 (a == 2) by Premise,
  3 (k ==3) by Premise,
  4 (cost ==190) by Algebra*(1,2,3)
)
//step 4: use postconditions to prove your asserts


//what *should* cost be?
assert(cost == 190) //cost is 190