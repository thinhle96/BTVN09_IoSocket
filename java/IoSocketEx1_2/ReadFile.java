package IoSocketEx1_2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReadFile {
	
	public static String readLine(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
 
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
 
        return contentBuilder.toString();
        
    }
	
	public static List<Device> listDevice;
	
	public static List<Device> convertToObject(String s,Boolean isStandardize) throws ParseException{
		listDevice = new ArrayList<Device>();
		Device device;
		String[] arr = s.split("[\r\n]");
		for (int i=0 ; i < arr.length; i++) {
			String[] deviceAttr = arr[i].split(",");
			device = new Device();
			device.setCode(deviceAttr[0]);
			device.setName(deviceAttr[1]);
			if (isStandardize) {
				device.setOwner(standardizeWord(deviceAttr[2]));
			} else {
				device.setOwner(deviceAttr[2]);
			}
			
			device.setInputDate(deviceAttr[3]);
            device.setWarrantyYear(deviceAttr[4]);
            listDevice.add(device);
		}
		return listDevice;
	}
	public static String standardizeWord(String s) {
		StringBuffer sb = new StringBuffer();
		String str = s.replaceAll("\\s+", " ");
		String[] arr =str.toLowerCase().trim().split(" ");
		for (int i=0; i <arr.length; i++) {
			String strArr = arr[i].substring(0,1).toUpperCase() + arr[i].substring(1);
			sb.append(strArr + " ");
			
		}
		String standardizeWord =sb.toString().trim();
		return standardizeWord;
		
	}
}
