package fr.lille.alom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {	
    	
        ConcurrentLinkedQueue<Socket> socketQueue = new ConcurrentLinkedQueue<>(); // Création de la liste pour stocker les sockets clients
        ServerSocket serverSocket = new ServerSocket(3000);
        boolean serverActif = true;
        
        Thread connexion = new Thread(() ->{   	
        	
        	while(serverActif) {
        		
        		try {
        			
        			Socket client = serverSocket.accept();
        			System.out.println("Connexion d'un socket client");
        			socketQueue.add(client);
        			
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        		
        	}
        	
        });
        
        connexion.start();
        
        while (serverActif) {
        	
        	if(!socketQueue.isEmpty()) {
        		
        		new Thread(() ->{
        			
        			Socket client = socketQueue.poll();
        			if(client != null) {
        				
        				RequestAnalyzer requestAnalyzer = new RequestAnalyzer(); 
                        
        				try {
        					
							Request request = new Request(client);
							requestAnalyzer.handleRequest(request);
							
							client.close();
							
						} catch (IOException e) {// TODO Auto-generated catch block
							e.printStackTrace();
						}
        				
        			}
        			
        		}).start();
        		
        	}
        	
        }
        
    }
}
