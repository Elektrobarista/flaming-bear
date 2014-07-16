package demoThread;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Thread t1 = new Thread(new Prime(1000000007));
		Thread t2 = new Thread(new Prime(100000007));
		Thread t3 = new Thread(new Prime(1000000059));
		Thread t4 = new Thread(new Prime(10000000019L));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		Prime test = new Prime();
		
		//test.calc(10000000019L);
		*/
		//ArrayList<Thread> t = null;
		//t.add(new Thread());
		Prime test = new Prime(13);
		long begin = System.nanoTime();
		System.out.println(test.isPrime(10007,7));
		long end = System.nanoTime();
		System.out.println(end-begin);
		
		
	}

}
