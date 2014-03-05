package client;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Properties;

import project2.model.Automobile;


public class Client {
	public static void main(String[] args)  {
		
		try {
			Client client = new Client();
			client.establishConnection("127.0.0.1", 5445);
			String file = "./car2.properties";
			client.runApp(file);
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	Socket serverSocket = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	Boolean connected = true;
	public  void runApp(String file) {
		String input;
		BufferedReader inputReader = null;

		inputReader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.println("\n***********interaction console***********");
				System.out.println("choose 1a or 1b: \n" +
						"(1a) add a model\n" +
						"(1b) list models and set choice\n" );
				System.out.print("$>");
				input = inputReader.readLine();
				 
					
				
				 if(input.equals("1a")){
					//CarModelOptionsIO modelIO= new CarModelOptionsIO(this);
						//modelIO.loadModelToServer(file);
				 }
				 else if(input.equals("1b")){
					//SelectCarOption so = new SelectCarOption(this);
					//so.listModels();
					//so.selectOptions();
				 }
				 else{
					 System.out.println("invalid, try again");
						continue;
				 }
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public void establishConnection(String serverIP, Integer port) {
		try {
			serverSocket = new Socket(serverIP, port);
			oos = new ObjectOutputStream(serverSocket.getOutputStream());
			ois = new ObjectInputStream(serverSocket.getInputStream());
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + serverIP);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: "
					+ serverIP);
			System.exit(1);
		}
		connected = true;
	}

	
	void sendCMD(String hellomsg) {
		try {
			oos.writeObject(hellomsg);
			oos.flush();
		} catch (Exception e) {
			System.err.println("error !!! sending cmd "+hellomsg);
			e.printStackTrace();
		}
	}
	
	

	public void endConnection() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}