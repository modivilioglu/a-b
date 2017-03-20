package com.mod.addressbook.service

/**
  * Created by mehmetoguzdivilioglu on 20/03/2017.
  */

import com.mod.addressbook.model._
import com.mod.addressbook.dao.AddressBookDao
import com.google.inject._

class AddressBookServiceImpl @Inject()(val dao: AddressBookDao) extends AddressBookService {
  def getDayDifferenceByName(name1: Name, name2: Name): Option[Int] = {
    val difference = for {
      person1 <- dao.getByName(name1.firstName)
      person2 <- dao.getByName(name2.firstName)
    } yield person1 |-?| person2
    difference
  }

  def getOldest = dao.getOldest

  def getCountByGender(gender: Gender) = dao.countByGender(gender)
}
