package client;
import java.net.*;
import java.io.*;

import socket.SocketClientConstants;
import socket.SocketClientInterface;
public class 
    DefaultSocketClient 
    implements SocketClientInterface,
                              SocketClientConstants {

    ObjectInputStream reader;
    ObjectOutputStream writer;
    private Socket sock;
    private String strHost;
    private int iPort;

    public DefaultSocketClient(String strHost, int iPort) {       
            setPort (iPort);
            setHost (strHost);
    }//constructor

   
    public boolean openConnection(){
    	
    	   try {
    		   if (DEBUG) System.out.println
    	        ("opening connection->"+strHost+":"+iPort);
    	     sock = new Socket(strHost, iPort); 
    	     writer = new  ObjectOutputStream(sock.getOutputStream());
    	     
    	     reader = new ObjectInputStream(sock.getInputStream());
    	     if (DEBUG) System.err.println("getting reader writer");
    	     
    	     if (DEBUG) System.out.println("socket created"+sock);
    	   }
    	   catch(IOException socketError){
    	     if (DEBUG) System.err.println
    	        ("Unable to connect to " + strHost+iPort);
    	     System.exit(0);
    	     return false;
    	   }
    	  
    	  catch (Exception e){
    	     if (DEBUG) System.err.println
    	       ("Unable to obtain stream to/from " + strHost);
    	     return false;
    	  }
    	   if (DEBUG) System.out.println
	        ("socket success");
	     
    	  return true;
    	}
    public void handleSession(){
    	  String strInput = "";
    	  if (DEBUG) System.out.println ("Handling session with "
    	            + strHost + ":" + iPort);
    	  try {
    	    while ( (strInput = reader.readLine()) != null)
    	    handleInput (strInput);
    	  }
    	  catch (IOException e){
    	  if (DEBUG) System.out.println ("Handling session with "
    	        + strHost + ":" + iPort);
    	  }
    	}       

    	public void sendCMD(Object out){
    	  try {
    		writer.writeObject(out);
  			writer.flush();
    	  }
    	  catch (IOException e){
    	    if (DEBUG) System.out.println 
    	               ("Error writing to " + strHost);
    	  }
    	}
        public void handleInput(String strInput){
            System.out.println(strInput);
    }       

    public void closeSession(){
       try {
          writer = null;
          reader = null;
          sock.close();
          System.err.println("sock closed");
       }
       catch (IOException e){
         if (DEBUG) System.err.println
          ("Error closing socket to " + strHost);
       }       
    }

    public void setHost(String strHost){
            this.strHost = strHost;
    }

    public void setPort(int iPort){
            this.iPort = iPort;
    }
    
    

    	}// class DefaultSocketClient

