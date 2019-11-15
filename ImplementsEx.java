package threadex;

public class ImplementsEx implements Runnable {

	@Override
	public void run() {
		System.out.println("In run method for Thread invoked with instance of Runnable\n");
	}

}
