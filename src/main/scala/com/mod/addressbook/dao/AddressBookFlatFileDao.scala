package com.mod.addressbook.dao

/**
  * Created by mehmetoguzdivilioglu on 20/03/2017.
  */
import com.mod.addressbook.model._
object AddressBookFlatFileDao extends AddressBookDao {
  def countByGender(gender: Gender): Int = ???
  def getByName(firstName: String): Option[Person] = ???
  def getOldest: Person = ???
}
