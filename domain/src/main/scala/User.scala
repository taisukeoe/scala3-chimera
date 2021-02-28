package domain

object User {
  // case class Id(val value: Int) extends AnyVal
  // case class Name(val value: String) extends AnyVal

  opaque type Id = Int
  opaque type Name = String
  object Id {
      def apply(i: Int): Id = i
  }
  extension (id: Id)
    def value: Int = id
  
  object Name {
      def apply(n: String): Name = n
  }
  extension (name: Name)
    def value: String = name
}

case class User(id: User.Id, name: User.Name)