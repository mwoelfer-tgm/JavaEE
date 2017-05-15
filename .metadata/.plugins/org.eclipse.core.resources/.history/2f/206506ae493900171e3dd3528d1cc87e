import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeClient extends Thread{
	private long lastPrime;
	private long startTime;
	private long runTime;
	
	public PrimeClient(long lastPrime){
		super();
		this.lastPrime = lastPrime;
	}
	
	public long nextPrime(){
		do{
			this.lastPrime++;
		} while(!isPrime(this.lastPrime));
		return this.lastPrime;
	}
	
	public void run(){
		this.startTime = System.currentTimeMillis();
	}

	public String getTime(){
		long time = System.currentTimeMillis() - this.startTime;
		if(TimeUnit.MILLISECONDS.toSeconds(time) < 180){
			return TimeUnit.MILLISECONDS.toSeconds(time) + " sekunden";
		} else if (TimeUnit.MILLISECONDS.toMinutes(time) < 90){
			return TimeUnit.MILLISECONDS.toMinutes(time) + " minuten";
		} else {
			return TimeUnit.MILLISECONDS.toHours(time) + " stunden";
		}
	}
	  
	private boolean isPrime(long n) {
	    // fast even test.
	    if(n > 2 && (n & 1) == 0)
	       return false;
	    // only odd factors need to be tested up to n^0.5
	    for(int i = 3; i * i <= n; i += 2)
	        if (n % i == 0) 
	            return false;
	    return true;
	}
}
