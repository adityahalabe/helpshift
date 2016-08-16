package inputHandlers

import services.ContactService

/**
  * Created by ahm2320 on 8/13/16.
  */
class SearchContactInputHandler(contactService: ContactService) {
  def searchContact = {
    val input = scala.io.StdIn.readLine("Enter name (First Name and last name separated by space) : ").trim
    val searchedContacts = contactService.searchContact(input)
    if(searchedContacts.size == 0){
      println("No contact found matching input !")
    }else{
      println("Matching contacts Found  : ")
      for(contact <- searchedContacts){
        println(contact.firstName + " " + contact.lastName)
      }
    }
    Application.readInput
  }

}
