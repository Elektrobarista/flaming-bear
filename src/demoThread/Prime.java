package demoThread;

import java.util.ArrayList;

public class Prime implements Runnable {
	
	long x;
	boolean isPrime = true;
	Thread[] threads;
	long lower;
	long upper;
	int i;
	int j;

	
	public Prime(long x){
		this.x = x;
	}
	
	public boolean isPrime(long x, int i){
		this.lower = 2;
		this.threads = new Thread[i];
		this.x = x;
		this.j = i;
		for (int j = 0; j < i; j++){//(x/i/2-1)%i; j++){
			this.threads[j] = new Thread(this);
			//this.threads[j].start();
		}
		this.i = 0;
		this.threads[0].start();
		
		
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
	
	synchronized long[] border(int i){
		long[] lowup = new long[2];
		long lower = this.lower;
		long upper = lower + x/2/j;
		
		if(i < x/2-1%j){
			upper++;
			this.upper++;
		}
		this.lower = upper+1;
		this.upper = this.lower+x/2/j;
		lowup[0] = lower;
		lowup[1] = upper;
		return lowup;
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
		int count = this.i;
		this.i++;
		System.out.println("Thread "+(i-1)+" startet.");
		long[] lowup = this.border(this.i-1);
		if (this.i < this.threads.length && isPrime == true) {
			this.threads[i].start();
		}
		this.calc(lowup[0], lowup[1]);
	}

}
