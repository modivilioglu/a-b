package com.mod.addressbook.service

/**
  * Created by mehmetoguzdivilioglu on 20/03/2017.
  */
import com.mod.addressbook.model._
class AddressBookServiceImpl extends AddressBookService {
  def getDayDifferenceByName(name1: Name, name2: Name): Option[Int] = ???
  def getOldest: Person = ???
  def getCountByGender(gender: Gender) = ???
}
