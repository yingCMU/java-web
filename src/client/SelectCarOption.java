package client;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import project2.model.Automobile;
import exceptions.MissingChoiceException;
import exceptions.MissingModelException;
import exceptions.MissingOptionException;
import exceptions.MissingSetException;

public class SelectCarOption {
	
	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	DefaultSocketClient client = null;
	public SelectCarOption(DefaultSocketClient client){
		this.client = client;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void selectOptions(){
		if(listModels()){
		System.out.println("please select one:");
		String model=null;
		try {
			model = stdIn.readLine();
			client.sendCMD(model);
			Object fromServer= client.reader.readObject();
			Automobile auto=(Automobile)fromServer;
			auto.print();
			auto.SetChoice();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.exit(1);
			e.printStackTrace();
		}
		 catch(ClassCastException e){
			 System.err.println("model not found->"+model);
				
		 }
		}
	}
	@SuppressWarnings("unchecked")
	public boolean listModels(){
		

		
			client.sendCMD("1b");
		
		ArrayList<String> fromServer;
		try {
			System.out.println("Wating for relay...");
			fromServer = (ArrayList<String>)client.reader.readObject();
			for(String each:fromServer)
			System.out.println("Server has: "+each );
		}catch (EOFException e) {
			System.err.println("empty list");
			//e.printStackTrace();
			return false;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public ArrayList<Automobile> getListModels(){
		

		
		client.sendCMD("1ist");
	
	ArrayList<Automobile> fromServer;
	try {
		System.out.println("Wating for relay...");
		fromServer = (ArrayList<Automobile>)client.reader.readObject();
		return fromServer;
	}catch (EOFException e) {
		System.err.println("empty list");
		//e.printStackTrace();
		return null;
	} 
	catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}
	
	
	
		
}
