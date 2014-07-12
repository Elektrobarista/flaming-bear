
public class Prime {
	
	public void calc(long x) {
		 long limit = x/2;
		 long counter =2;
		 boolean result = false;
		 boolean test = false;
		
		long begin = System.nanoTime();
		while(counter < limit && test == false){
			if((x % counter) == 0){
				 result = false;
				 test = true;				 				 				 
			}
			else{
				 result = true;
			}
			counter ++;
		}
		long end = System.nanoTime();
		System.out.println(result);
		System.out.println("Es wurden " + (end-begin) + " Nanosekunden zur Berechnung benötigt");
	}


	}
