package com.mod.addressbook.service

/**
  * Created by mehmetoguzdivilioglu on 19/03/2017.
  */
import com.mod.addressbook.injection._
import com.google.inject._
import com.mod.addressbook.model._
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}
class AddressBookServiceSpec extends FlatSpec with BeforeAndAfter with Matchers {
  // Acceptance criteria:
  // How many males are in the address book?
  // Who is the oldest person in the address book?
  // How many days older is Bill than Paul?

  val injector = Guice.createInjector(new InjectionModule)
  val service = injector.getInstance(classOf[AddressBookService])
  "Service" should "give the correct number of Males" in {
    service.getCountByGender(Male) should be(3)
  }
  "Service" should "give the correct number of Females" in {
    service.getCountByGender(Female) should be(2)
  }
  "Service" should "give the oldest person" in {
    service.getOldest.name shouldEqual Name("Gemma", "Lane")
  }

  "Service" should "give the the day difference correctly" in {
    service.getDayDifferenceByName(Name("Bill", "McKnight"), Name("Paul", "Robinson")) match {
      case None => fail()
      case Some(diff) => diff should be (2921)
    }
  }
}

