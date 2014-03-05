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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import project2.model.Automobile;
import socket.SocketClientConstants;


public class ClientDriver {
	public static void main(String[] args)  {
		
		try {
			DefaultSocketClient client = new DefaultSocketClient("127.0.0.1", SocketClientConstants.AUTO_PORT);
			String file = "./car.properties";
			client.openConnection();
			
			runApp(client);
			client.closeSession();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	Socket serverSocket = null;
	
	public static  void runApp(DefaultSocketClient client) {
		 System.out.println("running app");
		String input;
		BufferedReader inputReader = null;

		inputReader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.println("\n***********interaction console***********");
				System.out.println("choose 1a or 1b: \n" +
						"(1a) add a model\n" +
						"(1b) list model names and set choise\n"+
						"(1c) list models\n");
				System.out.print("$>");
				input = inputReader.readLine();
				 
					
				
				 if(input.equals("1a")){
					CarModelOptionsIO modelIO= new CarModelOptionsIO(client);
					System.out.println("entery your file name: ");
					String file = inputReader.readLine();
					modelIO.loadModelToServer(file);
				 }
				 else if(input.equals("1b")){
					SelectCarOption so = new SelectCarOption(client);
					//so.listModels();
					so.selectOptions();
				 }
				 else if(input.equals("1c")){
						SelectCarOption so = new SelectCarOption(client);
						//so.listModels();
						 ArrayList<Automobile> list = so.getListModels();
						 for(Automobile each: list){
							 System.out.println(each.getModel());
							 
						 }
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


	
	
	
	

	public void endConnection() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}