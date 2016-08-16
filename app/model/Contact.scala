package model

/**
  * Created by ahm2320 on 8/13/16.
  */
case class Contact(firstName : String, lastName : String){
  def fullName = (firstName + " " + lastName).trim
}