package lambdabasics;

public class FunctionalInterfaceImpl implements FunctionalInterface {

	@Override
	public int function(int n) {
		return (n * n + 2 * n + 1);
	}

}
