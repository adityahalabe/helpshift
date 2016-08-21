package dataHandlers

import model.Contact
import org.apache.commons.collections4.trie.PatriciaTrie
import scala.collection.JavaConverters._

/**
  * Created by ahm2320 on 8/13/16.
  */
class ContactDataMapper {

  val trie = new PatriciaTrie[String]()

  def isContactExits(contact: Contact) = trie.containsKey(contact.fullName)

  def saveContact(contact: Contact) : Boolean = {
    trie.put(contact.fullName,contact.fullName)
    true
  }
  def searchContacts(input:String) = trie.prefixMap(input).values().asScala.toList
}
