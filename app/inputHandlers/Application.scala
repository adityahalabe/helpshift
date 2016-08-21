package inputHandlers

import config.Dependencies._
import utilities.ApplicationConstants._

import scala.annotation.tailrec

/**
  * Created by ahm2320 on 8/13/16.
  */
object Application {

  def main (args: Array[String]) {
    readInput match {
      case _ => return
    }
  }
  @tailrec
  def readInput : Boolean = {
    val choice = scala.io.StdIn.readLine("1) Add contact 2) Search 3) Exit \n").trim
    choice match {
      case CHOICE_ADD_CONTACT => addContactHandler.addContact
      case CHOICE_SEARCH_CONTACT => searchContactHandler.searchContact
      case CHOICE_EXIT => {
        println("Happy Searching")
        false
      }
      case _ => {
        println("Please enter valid input ")
        readInput
      }
    }
  }
}
