package fr.lille.alom;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Helloworld extends Thread {

   private static final int NB_BOUCLE = 100;
   private Random random = new Random();
   private Map logs = new HashMap ();
   private Long startTime;
   private String name;
   //Permet d'arrêter le thread
   private boolean running = true;

   public Helloworld(Long startTime, String name) {
     this.startTime=startTime;
     this.name = name;
  }

   public Map getLogs() {
     return this.logs;
    }

   /*public void run() {
     for(int i=0;i<NB_BOUCLE;i++) {
       this.logs.put((System.nanoTime()-startTime),"Thread ["+name+"] count : ["+i+"]");
       if(random.nextInt(100) < 10) {
         this.logs.put((System.nanoTime()-startTime),"Thread ["+name+"] yield");
        yield();
      }
    }
  }*/
   
   public void run() {
	   //Boucle infinie
	   while(this.running) {
	     for(int i=0;i<NB_BOUCLE;i++) {
	       this.logs.put((System.nanoTime()-startTime),"Thread ["+name+"] count : ["+i+"]");
	       if(random.nextInt(100) < 10) {
	         this.logs.put((System.nanoTime()-startTime),"Thread ["+name+"] yield");
	        yield();
	      }
	    }
	   }
	  }
   
   // fonction pour arrêter proprement le thread
   public void finish() {
	   this.running = false;
   }
   
}