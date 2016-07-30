package language;

import java.time.LocalDate;
import java.time.Period;

/**
 * 1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
 * 2. Make all fields final and private.
 * 3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final. 
 * 		A more sophisticated approach is to make the constructor private and construct instances in factory methods.
 * 4. If the instance fields include references to mutable objects, don't allow those objects to be changed:
 * 			Don't provide methods that modify the mutable objects.
 * 			Don't share references to the mutable objects. Never store references to external, mutable objects 
 * 			passed to the constructor; if necessary, create copies, and store references to the copies. 
 * 			Similarly, create copies of your internal mutable objects when necessary to avoid returning the 
 * 			originals in your methods.
 *
 */
final public class ImmutableObject {
	final private int day, month, year;
	
	public ImmutableObject(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	public int getAge() {
		LocalDate birthdate = LocalDate.of(year, month, day);
		LocalDate now = LocalDate.now();
		return Period.between(birthdate, now).getYears();
	}
	
	public static void main(String[] args) {
		ImmutableObject io = new ImmutableObject(1,6,1982);
		System.out.println(io.getAge());
	}
}
