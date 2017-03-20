## Synopsis

This is a Scala Project, aiming to create an address-book service, currently reading from a flat file. The project aims

- Reading information from addressbook
- Answer questions based on the data in the addressbook

## Data
Data is currently a flatfile, embedded in the resource directory inside the project

## Development Approach

The following approached has been followed during the development:

A. Test cases on the service class have been generated according to the "acceptance criteria", which is mentioned on the spec.
B. New test cases have been implemented on the other classes, all failing in the first place.
C. After each implementation, the test cases are run to make sure that all pass, and a commit has been made after that.
D. When all test cases have passed, final refactorings have been made.

## Dependency Injection

For dependency injection, guice library is selected which is also used in Play Framework. The Injection is used to decouple the FlatFileDao from the Service layer, as later we might want to switch / add from reading from the FlatFile, to reading from a database or some other stream, so implementation is highly likely to change.

## Technical Spec

Implicit conversions and classes are implemented to
- give extra behaviour to the existing class without modifying the code
- provide a neater way to parse textual data

The result of the conversion is a neat way to create Person classes
which is very suitable especially to produce data in tests such as:
```
"James Brown,Male,01/01/1900".gender
```
It also kind of enables producing automated tests with simple text data.

The implicit class OlderThan enables to give extra behaviour to Person class
without modifying the code of Person. (same aim with the adaptor GOF pattern)
This way we can add a new operator |-?| for person, which measures the daily difference
between 2 individual's birthdays.
We can do something like this:
```
  "|-?| Operator" should "give the correct result" in {
    val person1: Person = "James Brown, Male, 05/01/1900"
    val person2: Person = "Jane Strong, Female, 06/01/1900"
    (person1 |-?| person2) should be (1)
  }
  ```
## How to Run
```
> git clone https://github.com/modivilioglu/address-book.git
> cd address-book
> sbt test
```
## Further Enhancements
Enabling new Dao classes are easy via Dependency injection. Also further approach maybe adding more robustness via usage of Either for error handling, taking a different approach on both cases. Xor in cats library is highly recommended on its right bias behaviour as well as its flatmap function.

As mentioned, the implicit "James Brown,Male,01/01/1900".gender behaviour enables parsing the text data easily, but also makes it possible to read a lot of data from text, creating Person classes, for test cases. An automated test can read from human/machine generated text file.
