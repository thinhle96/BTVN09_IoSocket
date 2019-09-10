package IoSocketEx1_1;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;

public class Main {
	
	private static String inputPath = "E:\\Java\\input1.txt";
	private static String outputPath = "E:\\Java\\output1.txt";

	public static void main(String[] args) throws ParseException {
		
		String n = ReadFile.readLine(inputPath);
		
		List<Device> devices = (ArrayList<Device>) ReadFile.convertToObject(n, false);
		
		Collections.sort(devices, new Comparator<Device>()
		{
			@Override
			public int compare(Device o1, Device o2)
			{
				if (o1.getWarrantyYear() == o2.getWarrantyYear())
				{
					return 0;
				}
				if (o1.getWarrantyYear() > o2.getWarrantyYear())
				{
					return 1;
				}
				return -1;
			}
		});
		WriteFile.writeFile(outputPath, devices);
		
		
		
	}
}

