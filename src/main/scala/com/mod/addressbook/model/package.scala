package com.mod.addressbook
import org.joda.time._
import org.joda.time.format._
/**
  * Created by mehmetoguzdivilioglu on 20/03/2017.
  */
package object model {

  implicit def fromStringToName(name: String): Name = {
    val args = name.split(" ")
    Name(args(0), args(1))
  }

  implicit def fromStringToGender(gender: String): Gender = gender.toLowerCase.trim match {
    case "male" => Male
    case "female" => Female
  }

  implicit def fromStringToDate(date: String): DateTime = {
    val formatter: DateTimeFormatter = DateTimeFormat.forPattern("DD/MM/YYYY");
    formatter.parseDateTime(date.trim);

  }

  implicit def lineToPerson(line: String): Person = {
    val args = line.split(",")
    Person(args(0), args(1), args(2))
  }



  implicit class OlderThan(person1: Person) {
    def |-?|(person2: Person): Int = {
      val days: Days = Days.daysBetween(person1.birthday, person2.birthday);
      days.getDays
    }
  }

}
