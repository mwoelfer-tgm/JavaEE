import java.util.concurrent.TimeUnit;


public class PrimeClient extends Thread{
	private long currPrime;
	private long outPrime;
	private long startTime;
	private boolean keepRunning;
	
	
	public PrimeClient(long lastPrime){
		super();
		this.currPrime = lastPrime;
		this.outPrime = lastPrime;
		this.keepRunning = true;
		this.startTime = System.currentTimeMillis();
	}
	
	
	public void stopExecuting() {
		keepRunning = false;
    }
	
	public void run(){
		while(keepRunning){
			this.currPrime++;
			if(isPrime(this.currPrime)) this.outPrime = this.currPrime;
		}
	}
	
	/**
	 * Src: Filip Scopulovic
	 * @return
	 */
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
	
	public long getPrime(){
		return this.outPrime;
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
