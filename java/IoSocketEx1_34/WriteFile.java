package IoSocketEx1_34;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class WriteFile {
	
	public static <E> void writeFile(String path, List<E> devices)
	{
		File file = new File(path);
		writeFile(file, devices);
	}
	
	private static OutputStream out = null;
	public static <E> void writeFile(File file, List<E> devices)
	{
		if (!file.exists())
		{
			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		if (out == null)
		{
			try
			{
				out = new FileOutputStream(file, true);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		int index = 0;
		for (E e : devices)
		{
			String s = "";
			if (e.getClass() == Device.class)
			{
				Device device = (Device) e;
				if (index == 0)
				{
					s = device.getCode();
				}
				else
				{
					s = "\n" + device.getCode();
				}
				
				s += ", " + device.getName();
				s += ", " + device.getOwner();
				s += ", " + device.getInputDate();
				s += ", " + device.getWarrantyYear();
				
				try
				{
					out.write(s.getBytes());
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
				index = 1;
			}
			else
			{
				try
				{
					s = (String) e;
					out.write(s.getBytes());
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
				index = 1;
			}
			
		}
		try
		{
			String breakPoint = "\n###\n";
			out.write(breakPoint.getBytes());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	protected static void outString(File dest, String data, String encoding, boolean append) throws IOException {
		append = true;
		FileOutputStream out = null;
		  
		}

	}