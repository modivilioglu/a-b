package com.mod.addressbook
import org.joda.time._
import org.joda.time.format._
/**
  * Created by mehmetoguzdivilioglu on 20/03/2017.
  */
package object model {

  implicit def fromStringToName(name: String)(implicit config: FormatConfig): Name = {
    val args = name.split(config.nameDelimeter)
    Name(args(0), args(1))
  }

  implicit def fromStringToGender(gender: String)(implicit config: FormatConfig): Gender = gender.toLowerCase.trim match {
    case config.textForMale => Male
    case config.textForFemale => Female
  }

  implicit def fromStringToDate(date: String)(implicit config: FormatConfig): DateTime = {
    val formatter: DateTimeFormatter = DateTimeFormat.forPattern(config.dateFormatter);
    formatter.parseDateTime(date.trim);

  }

  implicit def lineToPerson(line: String)(implicit config: FormatConfig): Person = {
    val args = line.split(config.personDelimeter)
    Person(args(0), args(1), args(2))
  }

  implicit class OlderThan(person1: Person) {
    def |-?|(person2: Person): Int = {
      val days: Days = Days.daysBetween(person1.birthday, person2.birthday);
      days.getDays
    }
  }

}
