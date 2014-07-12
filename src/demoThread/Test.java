package demoThread;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Prime(1000000007));
		Thread t2 = new Thread(new Prime(100000007));
		Thread t3 = new Thread(new Prime(1000000059));
		Thread t4 = new Thread(new Prime(10000000019L));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		//Prime test = new Prime();
		
		//test.calc(10000000019L);
		
		
	}

}
