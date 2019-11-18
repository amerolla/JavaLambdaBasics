package threadex;

public class ThreadExamples {
	
	
	public static void main(String[] args) {
		ThreadExamples threadExamples = new ThreadExamples();		
		
		// 1. Create thread using Thread subclass
		ExtendsEx extendsEx = new ExtendsEx();
		extendsEx.start();
	    
		// 2. Create thread by passing an instance of Runnable
		ImplementsEx implementsEx = new ImplementsEx();
		new Thread(implementsEx).start();
		
		// 3. Create thread by passing an anonymous inner class
		new Thread(
				new Runnable() {
					public void run() {
						System.out.println("In run method for Thread invoked with anonymous inner class\n");
					}
				}
			).start();
		
		// 4-1. Create thread by passing a lambda expression - example 1
		new Thread(
				() -> System.out.println("In run method for Thread invoked as lambda - ex 1\n")
			).start();
		
		// 4-2. Create thread by passing a lambda - example 2
		new Thread(() -> {
			System.out.println("In run method for Thread invoked as lambda - ex 2");
			for (int i = 0; i < 5; i++) {
				System.out.println("    iteration: " + i);
			}
		}).start();
	}
}
