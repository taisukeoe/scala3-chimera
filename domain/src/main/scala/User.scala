package domain


// case class Name(value: String) extends AnyVal

opaque type Name = String

case class User(name: Name)