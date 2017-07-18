/**
  * Created by Deepika on 17-07-2017.
  */

// <<<<<----- TASK ----->>>>>>

//Create a Scala application to find the GCD of two numbers

// <<<<<----- SOLUTION STARTS----->>>>>>

//-------Points considered while calculating GCD of two numbers--------
//1. Numbers whose GCD is to be calculated must be Integers.
//2. "How is GCD of two Integers calculated?", is shown as below:
     //GCD(0,0) = 0            //if both numbers are zero, then GCD is zero
     //GCD(a,0) = a            //if first number is non-zero, and other is zero then
                               //GCD is first number itself
     //GCD(a,b) = GCD(b,a%b)   //if both numbers are non-zero, then GCD function is 
                               //called recursively, until above two conditions are met

// <<<<<----- SOLUTION 1----->>>>>>

import scala.util.Try            //As Try block is used, so its import is required
object gcdApp extends App{      //gcdApp object (Singleton Class) is created which will 
                                //inherit main method from App trait
    
    if (Try {
      args(0).toInt   //converts command line arguments received as strings to integers
      args(1).toInt
    }.isSuccess) {    //One of the try methods (other is "isFailure") -> here it's used 
                      //to check whether arguments provided at commmand line
                      //can further be converted to integers or not, if yes, then if 
                      //block executes

      var aa = args(0).toInt       //Since arguments received/created inside Try block 
                                   //have local scope so I've created variables here in 
                                   //order to use them throughout the program
      var bb = args(1).toInt

      gcd(aa,bb)                   //call to gcd function is made

      def gcd(aaa: Int, bbb: Int): Unit = {       //definition of gcd function starts
        if (aaa == 0 && bbb == 0) {
          println(s"GCD of $aa and $bb is 0")
        }

        else if (aaa != 0 && bbb == 0) {
          println(s"GCD of $aa and $bb is $aaa")
        }
        else {
          var ccc = aaa % bbb
          gcd(bbb, ccc)
        }
      }
    }
    else {          //if user provides arguments which can't be converted to integers, 
                    //then this block executes
      println("!!!!!...........Please enter valid integers...........!!!!!")
    }
  }

// <<<<<----- SOLUTION 2----->>>>>> 
//only difference here is, object gcdApp is not extending App trait, here main method 
//is defined explicitly

/*import scala.util.Try
object gcdApp {
  def main(args: Array[String]) {
    if (Try {
      args(0).toInt
      args(1).toInt
    }.isSuccess) {

      var aa = a.toInt
      var bb = b.toInt

      gcd(aa,bb)

      def gcd(aaa: Int, bbb: Int): Unit = {
        if (aaa == 0 && bbb == 0) {
          println(s"GCD of $aa and $bb is 0")
        }

        else if (aaa != 0 && bbb == 0) {
          println(s"GCD of $aa and $bb is $aaa")
        }
        else {
          var ccc = aaa % bbb
          gcd(bbb, ccc)
        }
      }
    }
    else {
      println("!!!!!...........Please enter valid integers...........!!!!!")
    }
  }
}
*/

