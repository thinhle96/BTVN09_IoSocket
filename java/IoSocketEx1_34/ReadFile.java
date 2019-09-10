package IoSocketEx1_34;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	public static List<Device> convertToObject(String s,Boolean isStandardize, Boolean isTOPICA) throws ParseException{
		listDevice = new ArrayList<Device>();
		Device device;
		Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse("31/10/2018");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse("31/10/2019");
		
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
            
            if(isTOPICA) {
            	if(device.getCode().contains("TOPICA")
            			&& device.getInputDate().compareTo(startDate)>0
            			&& device.getInputDate().compareTo(endDate)<0) {
            		listDevice.add(device);
            	}
            } else {
            	listDevice.add(device);
            }
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
	
	public static String popularWord(String s) {
        StringBuffer sb = new StringBuffer();
        String[] arr = s.split("[\r\n]+");
        for (int i = 0; i < arr.length; i++) {
            String[] deviceAttr = arr[i].split(",");
            sb.append(deviceAttr[2]+" ");
        }

        String allOwner = sb.toString();
        String allOwnerStandardized = standardizeWord(allOwner);
        String[] words = allOwnerStandardized.split("\\s+");
        HashMap<String, Integer> sortingMap = new HashMap<String, Integer>();
        for (String word: words) {
            int value = 0;
            if  (sortingMap.containsKey(word)) {
                value = sortingMap.get(word);
            }
            sortingMap.put(word, value + 1);
        }

        Map.Entry<String,Integer> tempResult = sortingMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .findFirst().get();
        return tempResult.getKey();
    }
}
