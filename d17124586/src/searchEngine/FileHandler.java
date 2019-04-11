package searchEngine;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class FileHandler {
	// File class variables
	private String nameFile;
	boolean fileExists;
	private String url;
	private int index;
	ArrayList<String> allFiles;
	HashMap<String,String> fileDetails;
	
	// Constructor for file class
	public FileHandler(String nameFile) {
		
		this.nameFile = nameFile;
	}
	
	
	/*public FileHandler(String url,String nameFile) {
		fileDetails = new HashMap<String,String>();
		this.nameFile = nameFile;
		this.url = url;
		allFiles = new ArrayList<String>();
	
	}*/
	
	public FileHandler() {
		fileDetails = new HashMap<String,String>();
		allFiles = new ArrayList<String>();
		allFiles.add("All");
		allFiles.add("roles.txt");
		allFiles.add("random.txt");
		
	}


	//method for reading files
	public void readFile() {
		
		File files = new File(this.nameFile);
		try {
			Scanner fileRead = new Scanner(files);
			while(fileRead.hasNextLine()) {
				String line = fileRead.nextLine();
				System.out.println(line);
			}
			fileRead.close();

		}
		catch(Exception e) {
			System.out.println("The file may have not been found");
		}
	}
	
	//Method for checking if a word is in a file	
	public  boolean wordIsIn() {
		boolean exists = false;
		File files = new File(this.nameFile);
		try {
			Scanner fileRead = new Scanner(files);
			while(fileRead.hasNextLine()) {
				String line = fileRead.nextLine();
				if(url.equals(line)) {
					exists = true;
					return exists;
					
				}
				fileRead.close();
			}

		}
		catch(Exception e) {
			System.out.println("The file may have not been found");

		}
		
		return exists;
	}
	
	public ArrayList<String> getAllFiles() {
	       return allFiles;
	   }
	
	public void addFile(String name) {
		allFiles.add(name);	
	}
	
	public void addFileDetails(String name, String url) {
		fileDetails.put(name, url);
	}
	
	public void removeFile(String name) {
		for(int i=0; i < allFiles.size(); i++) {
			if (name.equals(allFiles.get(i))) {
				index = i;
			}
		}
		allFiles.remove(index);
	}


}
