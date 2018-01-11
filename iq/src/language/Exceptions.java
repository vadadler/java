package language;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Throwable is the parent class of Java Exceptions Hierarchy and it has two child objects – Error and Exception.
 * Exceptions are further divided into checked (at compile  time) exceptions and runtime exception.
 *
 * Errors (unchecked): Errors are exceptional scenarios that are out of scope of application and it’s not possible to anticipate
 *         and recover from them, for example hardware failure, JVM crash or out of memory error. That’s why we have
 *         a separate hierarchy of errors and we should not try to handle these situations. Some of the common Errors
 *         are OutOfMemoryError and StackOverflowError.
 * Checked Exceptions: Checked Exceptions are exceptional scenarios that we can anticipate in a program and try to
 *         recover from it, for example FileNotFoundException. We should catch this exception and provide useful
 *         message to user and log it properly for debugging purpose. Exception is the parent class of all Checked
 *         Exceptions and if we are throwing a checked exception, we must catch it in the same method or we have to
 *         propagate it to the caller using throws keyword.
 * Runtime Exception (unchecked): Runtime Exceptions are cause by bad programming, for example trying to retrieve an element
 *         from the Array. We should check the length of array first before trying to retrieve the element otherwise it might
 *         throw ArrayIndexOutOfBoundException at runtime. RuntimeException is the parent class of all runtime exceptions.
 *         If we are throwing any runtime exception in a method, it’s not required to specify them in the method
 *         signature throws clause. Runtime exceptions can be avoided with better programming.
 */

public class Exceptions {
   // StackOverlowError begin.
   /**
    * Cause StackOverlowError.
    * StackOverflowError: The Java Virtual Machine implementation has run out of stack space for a thread, typically
    * because the thread is doing an unbounded number of recursive invocations as a result of a fault in the executing program.
    */
   public void recursivePrint(int i) {
      System.out.println(i);
      recursivePrint(++i);
   }

   public void circularDependency() {
      A a = new A();
      System.out.println(a.toString());
   }

   class A {
      private int aValue;
      private B bInstance = null;

      public A() {
         aValue = 1;
         bInstance = new B();
      }

      @Override
      public String toString() {
         return "A.toSting()";
      }
   }

   class B {
      private int bValue;
      private A aInstance = null;

      public B() {
         bValue = 1;
         aInstance = new A();
      }

      @Override
      public String toString() {
         return "B.toString()";
      }
   }

   // StackOverlowError end.

   public void checkedException () {
      FileReader file = null;

      try {
         file = new FileReader("./junk.txt");
         BufferedReader fileInput = new BufferedReader(file);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }

   }

   public void runtimeException () {
      int i = 10;
      int j = 0;

      System.out.println(i/j);
   }
}