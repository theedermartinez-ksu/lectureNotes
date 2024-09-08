// #Sireum #Logika
//@Logika: --manual --background type

import org.sireum._

//Prove AND is commutative:
//p ∧ q ⊢ q ∧ p


@pure def and4(p: B, q: B): Unit = {
  Deduce(
    //@formatter: off

    (p & q) |- (q & p)
      Proof(
      1(p & q) by Premise,
      2( p ) AndE1(1),
      3( q ) AndE1(1),
      3(q & P) by AndI(3,2) //came from line 3 and then 2
      //PROOF GOES HERE


    )
    //@formatter:on
  )
}