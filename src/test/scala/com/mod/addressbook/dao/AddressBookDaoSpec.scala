package com.mod.addressbook.dao

/**
  * Created by mehmetoguzdivilioglu on 20/03/2017.
  */
import com.mod.addressbook.injection._
import com.mod.addressbook.model._
import com.google.inject._
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}
class AddressBookDaoSpec extends FlatSpec with BeforeAndAfter with Matchers {
  val injector = Guice.createInjector(new InjectionModule)
  val dao = injector.getInstance(classOf[AddressBookDao])

  implicit val config = FormatConfig(" ", "DD/MM/YYYY", ",", "male", "female")

  "Dao" should "give the correct number of Males" in {
    dao.countByGender(Male) should be(3)
  }
  "Dao" should "give the correct number of Females" in {
    dao.countByGender(Female) should be(2)
  }
  "Dao" should "give the oldest person" in {
    val expectedName: Name = "Gemma Lane"
    dao.getOldest.name shouldEqual expectedName
  }
  "Dao" should "get the person by name" in {
    val expectedName: Name = "Gemma Lane"
    dao.getByName("Gemma") match {
      case None => fail()
      case Some(person) => person.name shouldEqual expectedName
    }
  }
}
