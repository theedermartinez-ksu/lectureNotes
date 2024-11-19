// #Sireum #Logika
//@Logika: --background disabled
import org.sireum._

//"Unit" is like a void return type
def makeFirstZero(seq: ZS): Unit = {
  //how would we write the function contract?
  //what do we want to require of seq?
  //how can we describe how seq will change?

  seq(0) = 0
}

///// Test code ///////////

var nums: ZS = ZS(1,2,3)
makeFirstZero(nums)

//we want to claim that nums is what it was, but with the first
//element as a 0

//---> what should we assert?