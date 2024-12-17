package fr.lille.alom;

import java.util.Map;
import java.util.TreeSet;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main( String[] args )
	  {
	     long startTime = System.nanoTime();
	    Helloworld h1 = new Helloworld(startTime,"A");
	    Helloworld h2 = new Helloworld(startTime,"B");
	    h1.start();
	    h2.start();
	     while(h1.isAlive() && h2.isAlive()) {
	       try {
	    	//On attend 100ms
	        Thread.sleep(100);
	        //On arrête h1 et h2 
	        h1.finish();
	        h2.finish();
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    }
	    Map result = h1.getLogs();
	    result.putAll(h2.getLogs());
	    
	     for(long l : new TreeSet<Long> (result.keySet())) {
	      System.out.println("["+l+"] "+result.get(l));
	    }
	    System.out.println("End of execution");
	  }
}
