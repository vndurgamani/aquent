package com.aquent.corelogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class FileInputHandler {

	public static void main(String[] args) throws IOException, InvalidDataException {

		FileInputHandler obj = new FileInputHandler();
		//TreeMap<String, Date> mapout = obj.getFile("args[0]");// args[0]
		TreeMap<String, Date> mapout;
		
		if(0==args.length){
			String fileInput = args[0];
			String fileOutput = args[1];
			mapout = obj.getFile(fileInput);
			File fout = new File(fileOutput);
			FileOutputStream fos = new FileOutputStream(fout);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			//Displaying on Command Line
			System.out.println("Order" + "\t" + " Time ");
			for(Map.Entry<String, Date> entry:mapout.entrySet()){    
		        String key=entry.getKey();  
		        Date value=entry.getValue(); 
		        System.out.println(key+ "\t" + value);           
		    }
			
			//Storing in a TextFile
			out.write("Order" + "\t" + " Time ");
			out.newLine();
			for (Map.Entry<String, Date> entry : mapout.entrySet()) {
				out.write(entry.getKey() + "\t" + entry.getValue());
				out.newLine();
				out.newLine();
			}
			out.close();
		}
		
	}

	private TreeMap<String, Date> getFile(String fileName) throws IOException, InvalidDataException {
		
		Map<String, Date> map = new TreeMap<String, Date>();
		
		FileInputStream fis = new FileInputStream(fileName);
		BufferedReader in = new BufferedReader(new InputStreamReader(fis));
		
		String aLine;
		while ((aLine = in.readLine()) != null) {
			while ((aLine = in.readLine()) != null) {
				// get the lines you want, here I don't want something starting
				// with - or empty
				if (!aLine.trim().startsWith("-") && aLine.trim().length() > 0) {

					String[] stringArray = aLine.split("\\s+");		
					if(stringArray.length==2){
						String key = null;
						Long value = -1l;
						if(stringArray[0]!=null && !stringArray[0].trim().equals("")){
							try {
								key = stringArray[0];
								value = Long.parseLong(stringArray[1]);
								map.put(key, new Date(value));
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
						}
						else{
								throw new InvalidDataException("Invalid Data - Order or Time is missing.");
						}
					}
					else{
						throw new InvalidDataException("Invalid Data - Order or Time is missing.");
					}
				}
			}
		}
		in.close();

		return (TreeMap<String, Date>) map;
	}
}
