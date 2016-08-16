package dataHandlers

import model.Contact

import scala.collection.mutable.ListBuffer

/**
  * Created by ahm2320 on 8/13/16.
  */
class ContactDataMapper {

  var contacts = new ListBuffer[Contact]

  def isContactExits(contact: Contact) = {
    if(contacts.contains(contact))
      true
    else
      false
  }

  def saveContact(contact: Contact) : Boolean = {
    contacts += contact
    true
  }

  def searchContacts(input:String) = {
    contacts.toList.par.filter(_.fullName.toLowerCase.contains(input.toLowerCase)).toList
  }
}
