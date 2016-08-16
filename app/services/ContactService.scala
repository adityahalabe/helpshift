package services

/**
  * Created by ahm2320 on 8/13/16.
  */
import dataHandlers.ContactDataMapper
import model.Contact

class ContactService(contactDataMapper: ContactDataMapper) {

  def saveContact(contact : Contact) : String =  {
    if(contactDataMapper.isContactExits(contact)){
       "Contact already exists"
    }else{
      if (contactDataMapper.saveContact(contact))
        "Contact added successfully"
      else
        "Problem saving contact"
    }
  }

  def searchContact(input : String) : List[Contact] = {

    val contacts = contactDataMapper.searchContacts(input)

    contacts.sortWith(  (x : Contact,y : Contact) => x.fullName.equals(input))
  }

}