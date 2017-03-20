package com.mod.addressbook.dao

/**
  * Created by mehmetoguzdivilioglu on 20/03/2017.
  */

import scala.io.Source
import com.mod.addressbook.model._

object AddressBookFlatFileDao extends AddressBookDao {
  val lines = Source.fromResource("address-book").getLines.toList
  implicit val config = FormatConfig(" ", "DD/MM/YYYY", ",", "male", "female")
  implicit val maxPerson: Ordering[Person] = new Ordering[Person] {
    override def compare(p1: Person, p2: Person): Int = (p2 |-?| p1)
  }

  def extract(line: String): Person = line

  val personList: List[Person] = lines.map(extract)

  def countByGender(gender: Gender): Int = personList.count(person => person.gender == gender)

  def getByName(firstName: String): Option[Person] = {
    personList.filter(person => person.name.firstName == firstName) match {
      case Nil => None
      case firstPerson :: rest => Some(firstPerson)
    }
  }

  def getOldest: Person = personList.max
}
