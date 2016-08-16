
package dataHandlers

import model.Contact
import org.specs2.mutable.Specification

/**
  * Created by ahm2320 on 8/13/16.
  */
class ContactDataMapperSpec extends Specification {

  "Contact Data mapper" should {
    val dataMapper = new ContactDataMapper
    val contact = Contact("aditya","halbe")
    "save contact" in {
      dataMapper.saveContact(contact) mustEqual true
    }

    "Avoid duplicate contact from saving" in {
      dataMapper.isContactExits(contact) mustEqual(true)
    }

    "search contact in list" in {
      dataMapper.searchContacts("adi") mustEqual(List(contact))
    }

  }
}

