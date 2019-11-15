package innerclasses;

public class OuterClass {
	
	// Nested classes are divided into two categories: static and non-static. 
	// Nested classes that are declared static are simply called static nested classes. 
	// Non-static nested classes are called inner classes.
	//
	// This is to illustrate non-static nested classes
	// There are three types
	// - inner classes
	// - method local inner classes
	// - anonymous inner classes
	
	private int ID;
	public void setID(int ID) {
		this.ID = ID;
	}
	
	// inner class - simply a class defined within a class
	// - can create instance of this class (if private, only within the outer class)
	// and use its members	
	private class InnerClass  {
		public void printID() {
			System.out.println("In InnerClassID: OuterClass.ID " + ID);
		}		
	};
	
	private void invokeInner() {
		InnerClass innerClass = new InnerClass();
		innerClass.printID();
	}
	
	// a method-local inner class is defined in some method and can only be 
	// used within that method	
	private void invokeLocal() {
		class LocalInner {
			int id;
			void printLocalInner() {
				System.out.println("In LocalInner: id = " + id);
			}
		}
		LocalInner localInner = new LocalInner();
		localInner.id = 10;
		localInner.printLocalInner();
	}

	// An anonymous inner class implements an interface
	// - here we have an interface definition
	public interface AnonInner {
		public void printIntValue();
	}
	
	// - and this is the method which creates an implementation of the interface  
	// and returns an anonymous instance of that implementation. 
	public AnonInner anonInner() {
		return new AnonInner() {
			private int i = 11;
			public void printIntValue() {
				System.out.println("In anonInner: intValue = " + i);
			}
		};
	}
	
	public AnonInner anonInner2(int input) {
		return new AnonInner() {
			public void printIntValue() {
				System.out.println("In anonInner2: intValue = " + input);
			}
		};
	}
	
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		outerClass.setID(25);
		outerClass.invokeInner();
		outerClass.invokeLocal();
		AnonInner aI = outerClass.anonInner();
		aI.printIntValue();
		AnonInner aI2 = outerClass.anonInner2(71);
		aI2.printIntValue();
	}

}
