package demoThread;

import java.util.ArrayList;

public class Prime implements Runnable {
	
	long x;
	boolean isPrime = true;
	Thread[] threads;
	long lower;
	int i;
	
	public Prime(long x){
		this.x = x;
	}
	
	public boolean isPrime(long x, int i){
		this.lower = 2;
		this.threads = new Thread[i];
		for (int j = 0; j < i; j++){//(x/i/2-1)%i; j++){
			this.threads[j] = new Thread(this);
			this.threads[j].start();
		}
		this.i = 0;
		
		//Starten des ersten threads dannach die restlichen threads vom ersten thread straten...
		//////////////////////////////////////////////////////////////////////////////
		
		// Schleife die dafür sorgt das es keine Rückgabe gibt solange noch Threads laufen.
		
		boolean runningThreads = true;
		while(isPrime && runningThreads){
			runningThreads = false;
			for(int k = 0; k < this.threads.length; k ++){
				if (this.threads[k].isAlive() ==  true){
					runningThreads = true;
					break;
				}
			}
		}
			
			
		return this.isPrime;
	}
	
	
	public void calc(long lower, long upper) {
		 long limit = upper;
		 long counter = lower;	
		 
	   	while(counter < limit && isPrime == true){
			if((x % counter) == 0){
				 isPrime = false;			 				 				 
			}
			counter ++;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long threadCount = this.lower;
		lower++;
		System.out.println(threadCount+"Thread");
		for (int k = 0; k < 30; k++){
			System.out.println("Thread"+threadCount+": "+k);
		}
		
		//calc();
	}

}
