import java.util.Date;
import java.util.concurrent.TimeUnit;


public class PrimeClient extends Thread{
	private long currPrime;
	private long outPrime;
	private long startTime;
	private boolean keepRunning;
	private Date outDate;
	private long timeFound;
	
	public PrimeClient(long lastPrime){
		super();
		this.currPrime = lastPrime;
		this.outPrime = lastPrime;
		this.keepRunning = true;
		this.startTime = System.currentTimeMillis();
		this.outDate  = new Date();
		this.timeFound = System.currentTimeMillis();
	}
	
	/**
	 * Gets called when the program is being stopped
	 */
	public void stopExecuting() {
		keepRunning = false;
    }
	
	/**
	 * Gets called with .start()
	 * 
	 * Loops while thread is running and keeps finding prime numbers
	 */
	public void run(){
		// as long as thread wasnt stopped
		while(keepRunning){
			// increment current number
			this.currPrime++;
			// if the current number is a prime number, set the prime which is to be put out, the date and the time it was found
			if(isPrime(this.currPrime)){
				this.outPrime = this.currPrime;
				this.outDate = new Date();
				this.timeFound = System.currentTimeMillis();
			}
		}
	}
	
	/**
	 * Calculates the time its currently taking for the thread to search for the new prime number
	 * 
	 * Filip Scopulovic helped me with the formatting
	 * @return A formatted String how long it's currently taking for calculating a prime number
	 */
	public String getSearchTime(){
		long time = System.currentTimeMillis() - this.timeFound;
		if(TimeUnit.MILLISECONDS.toSeconds(time) > 1){
			if(TimeUnit.MILLISECONDS.toSeconds(time) < 180){
				return TimeUnit.MILLISECONDS.toSeconds(time) + " sekunden";
			} else if (TimeUnit.MILLISECONDS.toMinutes(time) < 90){
				return TimeUnit.MILLISECONDS.toMinutes(time) + " minuten";
			} else {
				return TimeUnit.MILLISECONDS.toHours(time) + " stunden";
			}
		} else{
			return time + " millisekunden";
		}
	}
	
	/**
	 * Calculates the time how long the servlet is already running
	 * 
	 * Filip Scopulovic helped me with the formatting
	 * @return a formatted string how long the servlet has already been running
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
	
	/**
	 * 
	 * @return the Date at which the last prime number was found
	 */
	public Date getDate(){
		return this.outDate;
	}
	
	/**
	 * 
	 * @return the current found prime number
	 */
	public long getPrime(){
		return this.outPrime;
	}
	 
	/**
	 * Checks if a number is prime
	 * 
	 * Copied from stackoverflow to achieve best possible performance
	 * @param n the number to checked
	 * @return True or false depending whether it's a prime number or not
	 */
	private boolean isPrime(long n) 
	{
	    //check if n is a multiple of 2
	    if ((n % 2) == 0) return false;
	    //if not, then just check the odds
	    for (long i = 3; (i * i) <= n; i += 2) 
	    {
	        if ((n % i) == 0)
	            return false;
	    }
	    return true;
	}
}
