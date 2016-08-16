

package scala.services

import dataHandlers.ContactDataMapper
import model.Contact
import services.ContactService
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
  * Created by ahm2320 on 8/13/16.
  */
class ContactServiceSpec extends Specification with Mockito {

  "Contact Service" should {

    "Save contact if already not exists" in new Fixture {
      val contact = Contact("demo","contact")
      contactDataMapper.isContactExits(contact) returns (false)
      contactDataMapper.saveContact(contact) returns (true)

      contactService.saveContact(contact) mustEqual "Contact added successfully"
    }

    "Show error if contact already exists" in new Fixture {
      val contact = Contact("demo","contact")
      contactDataMapper.isContactExits(contact) returns (true)
      contactService.saveContact(contact) mustEqual "Contact already exists"
    }

    "Show error if problem in saving contact" in new Fixture {
      val contact = Contact("demo","contact")
      contactDataMapper.isContactExits(contact) returns (false)
      contactDataMapper.saveContact(contact) returns (false)

      contactService.saveContact(contact) mustEqual "Problem saving contact"
    }

    "search contact and rank exact match higher" in new Fixture {
      val outputBeforeRank = List(Contact("aditya","Halabe"),Contact("adi",""))
      contactDataMapper.searchContacts("adi") returns(outputBeforeRank)
      val outputAfterRank = List(Contact("adi",""),Contact("aditya","Halabe"))
      contactService.searchContact("adi") mustEqual(outputAfterRank)
    }
  }

  trait Fixture extends Scope {
    val contactDataMapper = mock[ContactDataMapper]
    val contactService = new ContactService(contactDataMapper)

  }
}

