package demoThread;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Prime());
		
		t1.start();

		Prime test = new Prime();
		
		test.calc(10000000019L);
		
		
	}

}
