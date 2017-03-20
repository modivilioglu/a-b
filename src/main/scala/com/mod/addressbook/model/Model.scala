package com.mod.addressbook.model

/**
  * Created by mehmetoguzdivilioglu on 19/03/2017.
  */
import org.joda.time.DateTime
sealed trait Gender
case object Male extends Gender
case object Female extends Gender
case class Name(firstName: String, lastName: String) //extends Name
case class Person (name: Name, gender: Gender, birthday: DateTime)
