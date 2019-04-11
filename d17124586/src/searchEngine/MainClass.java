package searchEngine;

public class MainClass {
	
	public static void main(String[] args) {
		
 		String tempname ="roles.txt";
		
		printfiles(tempname);
		Graphics9 gui1 = new Graphics9("MainGUI");
	
	}
	
	public static String printfiles(String names) {
		FileHandler readers = new FileHandler(names);
		
		readers.readFile();
		return "";
	}	
}