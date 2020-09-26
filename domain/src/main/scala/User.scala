package domain


// case class Name(value: String) extends AnyVal

object User {
  opaque type Id = Int
  opaque type Name = String
  object Id {
      def apply(i: Int): Id = i
  }
  object Name {
      def apply(n: String): Name = n
  }
}

case class User(id: User.Id, name: User.Name)