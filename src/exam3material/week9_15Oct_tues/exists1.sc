// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._
import org.sireum.justification._
import org.sireum.justification.natded.pred._
import org.sireum.justification.natded.prop._

// ∀ x (Human(x) → Mortal(x)), ∃ x (Human(x)) ⊢ ∃ x (Mortal(x))
// there is a human so they are mortal, there is a human PROVE  there is a mortal
@pure def exists1[T](Human: T=>B @pure, Mortal: T=>B @pure): Unit = {
  Deduce(
    //@formatter: off

    (
      ∀((x: T) => (Human(x) __>: Mortal(x)))),
      ∃((x: T) => Human(x))
    )
    |-
    (
      ∃((x: T) => Mortal(x))
    )
    Proof(
      1 ( (∀((x: T) => (Human(x) __>: Mortal(x)))) ) by Premise,
      2 ( ∃((x: T) => Human(x)) ) by Premise, // we do not have anything we have but we have exists so we use exists elimination, introducing an alias in these statemetns
      3 Let ((bob: T) => Subproof(
        4 Assume (Human(bob))//start with an assume just like or elim
        5 ( Human (bob) __>: Mortal(bob)) by AllE[T](1),
        6 (Mortal(bob)) by ImplyE(5,4) by ImplyE(5,4),
        7 ∃((x: T) => Mortal(x)) by ExistsI[T](6))
        //the conclusion is our goal
      )),
      8

    )
    //@formatter:on
  )
}