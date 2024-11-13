// #Sireum #Logika
//@Logika: --background disabled
//show at the beggining before begiingin loop that envarriant holds. show that it holds after every change.
// prove post condition. total == bound * bound

//deduce:
//contract - prove invariant,
// loop - prove invariant,
// post condition - we can use invariant and loop condition as post condition deduce that post condition holds


import org.sireum._

def doStuff(bound: Z): Z = {
  Contract(
    Requires(bound >= 1),
    Ensures(Res[Z] == //what?)
  )
  var i: Z = 0
  var total: Z = 0

  while (i < bound) {
    Invariant(
      Modifies(total, i),
      i >= 0,
      i <= bound,
      //what else?
    )

    i = i + 1
    total = total + (2*i - 1)
  }

  return total
}

////////////////// Test code /////////////
//preconditions for the function must be meet
//post condition must be meet after call
val x: Z = 5

deduce(
  1 ( x == 5) by premise,
  2 (x-3 >= 1 ) by algebra*()
)

val 
assert(doStuff(1) == ?)

//after calling a function, we can use post condition as a premise
deduce(

)