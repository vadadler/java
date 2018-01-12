package language;

/**
 * Shallow copy: only fields of primitive data type are copied while the objects references are not copied.
 * Deep copy: involves the copy of primitive data type as well as object references.
 */

public class CloneObject {
   public static void main(String[] args) {
      Person person = new Person();
      person.age = 25;
      person.name = new Name("John", "Carter");

      System.out.println("Shallow clone");
      Person anotherPerson = person.shallowClone(person);

      System.out.println(person.toString());
      System.out.println(anotherPerson.toString());

      person.age = 30;
      person.name.lastName = "Morton";
      person.name.firstName = "Jake";

      System.out.println();
      System.out.println();
      System.out.println("Shallow clone: name, age changed");

      System.out.println(person.toString());
      System.out.println(anotherPerson.toString());

      System.out.println();
      System.out.println();
      System.out.println("Deep clone");
      Person person2 = new Person();
      person2.age = 25;
      person2.name = new Name("John", "Carter");

      Person anotherPerson2 = person2.deepClone(person2);

      System.out.println(person2.toString());
      System.out.println(anotherPerson2.toString());

      person2.age = 30;
      person2.name.lastName = "Morton";
      person2.name.firstName = "Jake";

      System.out.println();
      System.out.println();
      System.out.println("Deep clone: name, age changed");

      System.out.println(person2.toString());
      System.out.println(anotherPerson2.toString());

   }
}

class Person {
   public int age;
   public Name name;

   public Person() {}

   public Person shallowClone(Person p) {
      Person person = new Person();
      person.age = p.age;
      person.name = p.name;

      return person;
   }

   public Person deepClone(Person p) {
      Person person = new Person();
      person.age = p.age;
      person.name = new Name(p.name.firstName, p.name.lastName);

      return person;
   }

   @Override
   public String toString() {
      return(getClass().getName() + '@' + Integer.toHexString(hashCode()) + ": " + this.age + " " + this.name.toString());
   }
}

class Name {
   String firstName;
   String lastName;

   public Name(String fName, String lName) {
      this.firstName = fName;
      this.lastName = lName;
   }

   @Override
   public String toString() {
      return(getClass().getName() + '@' + Integer.toHexString(hashCode()) + ": " + this.firstName + " " + this.lastName);
   }
}
