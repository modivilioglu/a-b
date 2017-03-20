package com.mod.addressbook.model

/**
  * Created by mehmetoguzdivilioglu on 20/03/2017.
  */
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}
class ModelSpec extends FlatSpec with BeforeAndAfter with Matchers {
  implicit val config = FormatConfig(" ", "DD/MM/YYYY", ",", "male", "female")
  "Implicits" should "create Name from StringFormat" in {
    "James Brown".firstName should be ("James")
  }
  "Implicits" should "create Person from StringFormat" in {
    "James Brown,Male,01/01/1900".gender should be (Male)
  }
  "Implicits" should "create Person from StringFormat and give the right name" in {
    "James Brown,Male,01/01/1900".name should be (Name("James", "Brown"))
  }
  "Implicits" should "create Date from StringFormat" in {
    "05/01/1900".getDayOfMonth should be (5)
  }
  "|-?| Operator" should "give the correct result" in {
    val person1: Person = "James Brown, Male, 05/01/1900"
    val person2: Person = "Jane Strong, Female, 06/01/1900"
    (person1 |-?| person2) should be (1)
  }
  "Different formats for textual input" should "be supported" in {
    implicit val config = FormatConfig(",", "DD/MM/YY", "#", "male", "female")
    "05/03/77".getDayOfMonth should be (5)
    "James,Brown#Male#01/01/55".gender should be (Male)
    "James,Brown#Male#01/01/55".name.firstName should be ("James")
  }
}
