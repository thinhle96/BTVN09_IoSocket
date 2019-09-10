package IoSocketEx1_34;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;

public class Main {
	
	private static String inputPath = "E:\\Java\\input1.txt";
	private static String outputPath = "E:\\Java\\output1.txt";
	
	public static void main(String[] args) throws ParseException, IOException {
		
		String n = ReadFile.readLine(inputPath);
		
		List<Device> devices = (ArrayList<Device>) ReadFile.convertToObject(n, true, true);
		
		String pWord = ReadFile.popularWord(n);
		
		WriteFile.writeFile(outputPath, devices);
		
		FileOutputStream outputStream = new FileOutputStream(outputPath, true);
	    byte[] strToBytes = pWord.getBytes();
	    outputStream.write(strToBytes);
	  
	    outputStream.close();
	
		
	}
}

