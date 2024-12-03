// #Sireum #Logika
//@Logika: --background disabled
import org.sireum._

//create a sequence of literals
var seq: ZS = ZS(5,10,15) // sequence

//create an empty sequence
var empty: ZS = ZS()

//indexing a sequence
var first: Z = seq(0) //first will be 5
seq(2) = 100    //seq is (5,10,100)
assert(seq == ZS(5,10,100)) // check values match

//getting the size of a sequence
var len: Z = seq.size   //len will be 3
assert(len == 3)