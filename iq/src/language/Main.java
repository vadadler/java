package language;

public class Main {
   public static void main(String[] args) {
      Exceptions exceptions = new Exceptions();

      // Error.
      //exceptions.recursivePrint(1);
      //exceptions.circularDependency();

      // Exception.
      // exceptions.checkedException();

      // RuntimeException.
      exceptions.runtimeException();
   }
}
