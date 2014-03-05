package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import project2.model.Automobile;

public class CarModelOptionsIO {
	/*Socket serverSocket = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	Boolean connected = true;
*/
	DefaultSocketClient client = null;
	public CarModelOptionsIO(DefaultSocketClient client){
		this.client = client;
	}
	public Automobile getModel(String model){
		client.sendCMD("get-"+model);
		try {
			client.writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Automobile fromServer;
		try {
			System.out.println("Wating for relay...");
			fromServer = (Automobile)client.reader.readObject();
			return fromServer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean loadModelToServer(String file) {
		

		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(file));
			System.out.println("!11"+properties.getProperty("Make"));
			client.sendCMD("1a");
			client.writer.writeObject(properties);
			client.writer.flush();
		}catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return false;
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to sent to server");
			return false;
		}
		 
		Automobile fromServer;
		try {
			System.out.println("Wating for relay...");
			fromServer = (Automobile)client.reader.readObject();
			System.out.println("Server added: " + fromServer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	

	
}
