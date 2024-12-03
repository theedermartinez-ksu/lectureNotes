// #Sireum #Logika
//@Logika: --background disabled
import org.sireum._

//set all elements to 10
def all10(nums: ZS): Unit = { // interger sequence
  Contract(
    //nothing because it
    Modifies(nums),
    Ensures(
      ∀(0 until nums.size) (k=> nums(k)==10 )
    )

  )

  var i: Z = 0
  while (i < nums.size) {
    invariant(
      Modifies(i,nums),
      i>=0,
      i<= nums.size, // needs to be true at the end of each iteration, it is not at the end :( so it is not i< nums.size
      // we set one element to 10, we wnat to describe which elements we set to 10
      ∀(0 until i) (k=> nums(k)==10 ),
      // it does not hurt to put in and show that the other elemetns have not changed
      //∀(i until nums.size) (k=> nums(k)==In(nums)(k) ),
    )
    nums(i) = 10
    i = i + 1;
  }
}

///////////////////////////

var test: ZS = ZS(4,1,3,8,10,2)

all10(test)

//what do we want to assert?

Assert(test()== ZS(10,10,10,10,10,10))