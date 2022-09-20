package btk20FileOperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("C:\\Users\\kamil\\git\\JavaCamp2022-EnginDemirog-\\btk21_Generics\\deneme.txt");
		try {
			if(file.createNewFile()) {
				System.out.println("File has created successfully");
			}
			else {
				System.out.println("There is already a file that has named " + file.getName());
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		getFileInfo(file);
		
		Map<String,String>myMap=new HashMap<>();
		readFile(myMap,file);
		/* for(java.util.Map.Entry<String, String> entry: myMap.entrySet()) {
		      System.out.print(entry);
		      System.out.print(", ");
		    }

		    // iterating through keys
		    System.out.print("\nKeys: ");
		    for(String key: myMap.keySet()) {
		      System.out.print(key);
		      System.out.print(", ");
		    }

		    // iterating through values
		    System.out.print("\nValues: ");
		    for(String value: myMap.values()) {
		      System.out.print(value);
		      System.out.print(", ");
		    }
		    System.out.println("\n");
		    Iterator<Map.Entry<String, String>> itr = myMap.entrySet().iterator();
	          
	        while(itr.hasNext())
	        {
	             Map.Entry<String, String> entry = itr.next();
	             System.out.println("Key = " + entry.getKey() + 
	                                 ", Value = " + entry.getValue());
	        }*/
	        myMap.forEach((k,v) -> System.out.println("Key = "
	                + k + ", Value = " + v));
	        
	        System.out.println(myMap.size());
	         writeFile(file);
	      //  myMap.clear();
	        readFile(myMap,file);
	        myMap.forEach((k,v) -> System.out.println("Key = "
	                + k + ", Value = " + v));
	}
	 
	public static void getFileInfo(File file) {
		if(file.exists()) {
			System.out.println("File exist");
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
			System.out.println(file.canRead());
			System.out.println(file.canWrite());
			System.out.println(file.length()+" byte");//byte
			
		}
		else System.out.println("There is no such a file");
	}
	public static void writeFile(File file) {
		Map <String,String>tmp=new HashMap<>();
		BufferedWriter bwr=null;
		System.out.println("Lutfen kayýt etmek istediginiz key ve value degerlerini sýrasýyla girin");
		Scanner sc=new Scanner(System.in);
		System.out.println("Key: "); String key=sc.next();
		System.out.println("Value: ");String value=sc.next();
		tmp.put(key,value);
		
		try {
			bwr=new BufferedWriter(new FileWriter(file,true));
			for(Map.Entry<String,String>t:tmp.entrySet()) {
				bwr.write(t.getKey()+":"+t.getValue());
				  bwr.newLine();
			}
			bwr.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			  
            try {
  
                // always close the writer
                bwr.close();
            }
            catch (Exception e) {
            }
        }
		
	}
	public static  void readFile(Map<String,String>fileMap ,File file) {
		BufferedReader brd=null;
		try {
			brd=new BufferedReader(new FileReader(file));
			String line=null;
			String lastLine=null;
			while((line=brd.readLine())!=null) {
				// split the line by :
				lastLine=null;
                String[] parts = line.split(":");
               
  
                // first part is name, second is number
                String number = parts[0].trim();
                String name = parts[1].trim();
  
                // put name, number in HashMap if they are
                // not empty
                if (!name.equals("") && !number.equals(""))
                    fileMap.put(number, name);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 finally {
			  
	            // Always close the BufferedReader
	            if (brd != null) {
	                try {
	                    brd.close();
	                }
	                catch (Exception e) {
	                };
	            }
	        }
		
	}

}
