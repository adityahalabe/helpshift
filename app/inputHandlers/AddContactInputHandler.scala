package inputHandlers

import model.Contact
import services.ContactService
/**
  * Created by ahm2320 on 8/13/16.
  */
class AddContactInputHandler(contactService: ContactService) {

  def createContactFromInput(input :String): Option[Contact] = {
    input.split(" ") match {
      case Array(str1, str2) => Some(Contact(str1, str2))
      case Array("") => None
      case Array(str1) => Some(Contact(str1, ""))
      case _ => None
    }
  }
  def addContact = {
    val name = scala.io.StdIn.readLine("Enter name (First Name and last name separated by space) : ").trim
    createContactFromInput(name) match {
      case Some(contact) => {
        if(contact.fullName.length > 50){
          println("Name cannot be more than 50 chars")
        }else{
          println(contactService.saveContact(contact))
        }
      }
      case None => println("Invalid Input !")
    }
    Application.readInput
  }
}
