package config

import dataHandlers.ContactDataMapper
import inputHandlers.{SearchContactInputHandler, AddContactInputHandler}
import services.ContactService

/**
  * Created by ahm2320 on 8/13/16.
  */
object Dependencies {

  val contactDataMapper = new ContactDataMapper
  val contactService = new ContactService(contactDataMapper)
  val addContactHandler = new AddContactInputHandler(contactService)
  val searchContactHandler = new SearchContactInputHandler(contactService)

}
