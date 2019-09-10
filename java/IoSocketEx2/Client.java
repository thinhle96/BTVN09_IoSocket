package IoSocketEx2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	public final static String SERVER_IP = "10.0.50.4";
    public final static int SERVER_PORT = 9669;
 
    public static void main(String[] args) throws IOException, InterruptedException {
    	
    	Scanner sc = new Scanner(System.in);
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
            System.out.println("Connected: " + socket);
            
            boolean run = true;
			String phoneNumber = "";
			String key = "";
			String name = "";
			ArrayList<TLV> tlvs; 
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            while (run) {
            	boolean validateInput = false;
            	while(!validateInput) {
            		System.out.println("Choose action:");
					System.out.println("1: Authen");
					System.out.println("2: Insert");
					System.out.println("3: Commit");
					System.out.println("4: Select");
					System.out.println("0: Exit");
					System.out.print("Choose: ");
					
					int choose = sc.nextInt();
					try {
						if (choose >= 0 && choose <=4 ) {
							validateInput = true;
						}
					} catch (Exception e) {
					}
					if(!validateInput) {
						System.out.println("Your choice is invalid. Please choose again!");
					}
            	}
            	switch (1) {
            		case 1:
            			System.out.println("Init...");
            			System.out.println("Enter phone number: ");
            			int phone = sc.nextInt();
            			System.out.println("Enter key: ");
            			key = sc.nextLine();
            		case 2:
            			
            	
         
            	}
            }
            
            
            
            
           
        } catch (IOException ie) {
            System.out.println("Can't connect to server");
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

}
