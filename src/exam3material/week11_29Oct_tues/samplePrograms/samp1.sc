// #Sireum #Logika
//@Logika: --manual --background disabled

import org.sireum._

//get user input number, add one to it, print it out

//what does "var" mean?
var x: Z = Z.prompt("Enter a number: ") // we are giving this thing, var can chageg val cant

x = x + 1

println("One more is ", x)