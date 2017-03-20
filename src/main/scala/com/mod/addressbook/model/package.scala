package com.mod.addressbook
import org.joda.time._
/**
  * Created by mehmetoguzdivilioglu on 20/03/2017.
  */
package object model {

  implicit def fromStringToName(name: String): Name = ???

  implicit def fromStringToGender(gender: String): Gender = ???

  implicit def fromStringToDate(date: String): DateTime = ???

  implicit def lineToPerson(line: String): Person = ???


  implicit class OlderThan(person1: Person) {
    def |-?|(person2: Person): Int = ???
  }

}
