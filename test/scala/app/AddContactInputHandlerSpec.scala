package app

import inputHandlers.AddContactInputHandler
import model.Contact
import services.ContactService
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
  * Created by ahm2320 on 8/13/16.
  */
class AddContactInputHandlerSpec extends Specification with Mockito{

  "Contact input handler" should {
    "create contact for input with full name" in new Fixture {
      val contact  = Contact("aditya","halbe")
      addContactInputHandler.createContactFromInput("aditya halbe") mustEqual Some(contact)
    }
    "create contact for input with only first name" in new Fixture {
      val contact  = Contact("aditya","")
      addContactInputHandler.createContactFromInput("aditya") mustEqual Some(contact)
    }
    "give error for wrong input" in new Fixture {
      addContactInputHandler.createContactFromInput("aditya a a ") mustEqual None
    }
  }

  trait Fixture extends Scope {
    val contactService = mock[ContactService]
    val addContactInputHandler = new AddContactInputHandler(contactService)
  }
}
