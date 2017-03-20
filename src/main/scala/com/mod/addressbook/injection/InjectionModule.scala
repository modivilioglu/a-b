package com.mod.addressbook.injection

/**
  * Created by mehmetoguzdivilioglu on 20/03/2017.
  */
import com.google.inject._
import com.mod.addressbook.service._
import com.mod.addressbook.dao._
class  InjectionModule extends AbstractModule {
  override def configure: Unit = {
    bind(classOf[AddressBookDao]).toInstance(AddressBookFlatFileDao)
    bind(classOf[AddressBookService]).to(classOf[AddressBookServiceImpl])
  }
}
