package searchEngine;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;


    public class Graphics9 extends JFrame implements ActionListener,MouseListener{
    private JPanel myPanel;
    private JPanel myPanel1;
    private JPanel myPanel2;
    private JPanel myPanel3;
    private JPanel myPanel4;
    //files
	private FileHandler fileH;
	private JFileChooser filec;
	private File chosenFile;
	//text fields
    private JTextField searchBox;
    //Buttons
	private JButton search;
	private JButton addFile;
	private JButton removeFile;
	//Labels
	private JLabel location;
	private JLabel searchText;
	//list arrays combos
	private JComboBox<String> combo;
	private JComboBox<String> combo2;
	private ArrayList<String> allFiles;
	private  String[] array;
	//Random
	private int value;
	private String txt = "txt";
	private String extention;
	private String url;
	private String name;
	private int index;
	
	public Graphics9(String title)
	  {
		   super("Search Engine");
		   
		   JFrame frame = new JFrame();
		   
		   //Lists
		   fileH = new FileHandler();
		   allFiles = fileH.getAllFiles();
		   array = allFiles.toArray(new String[allFiles.size()]);
		   
		   //panels
		   myPanel1 = new JPanel();
		   myPanel2 = new JPanel();
		   myPanel3 = new JPanel();
		   myPanel4 = new JPanel();

		   //Objects
		   //Buttons
		   search = new JButton("SEARCH");
		   addFile = new JButton("Add File");
		   removeFile = new JButton("Remove File");
		   //text fields
		   searchBox = new JTextField("",15);
		   //Labels
		   searchText = new JLabel("Enter search here: ");
		   location = new JLabel("Where would you like the search location to be:");
		   //combo
		   combo = new JComboBox<String>(array);
		   combo2 = new JComboBox<String>(array);
		   combo2.removeItem("All");
		   
		   //file chooser
		   filec = new JFileChooser();
		   filec.setCurrentDirectory(new java.io.File("michaels-project"));
		   filec.setDialogTitle("Select file to be added");
		   filec.setFileSelectionMode(JFileChooser.FILES_ONLY);
		   
		   
		   //Sizes
		   frame.setSize(500,500);
		   frame.setLayout(new GridLayout(4, 0));
		   frame.setResizable(false);
		
		   
		   // add the panel to the screen  - uses the add() method of JFrame to do this. 
		   frame.add(myPanel1);
		   frame.add(myPanel2);
		   frame.add(myPanel3);
		   frame.add(myPanel4);

		   
		   //Adding stuff to your panel
		   myPanel1.add(searchText);
		   myPanel1.add(searchBox);
		   myPanel1.add(search);
		   myPanel2.add(location);
		   myPanel2.add(combo);
		   myPanel3.add(addFile);
		   myPanel4.add(combo2);
		   myPanel4.add(removeFile);
		   
		   //ACTION LISTENERS
		   search.addActionListener(this);
		   addFile.addActionListener(this);
		   removeFile.addActionListener(this);
		   searchBox.addActionListener(this);
		   combo.addActionListener(this);
		   combo2.addActionListener(this);
		   
		   //Tips 
		   searchBox.setToolTipText("Enter Search");
		   

		   frame.setVisible(true);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == addFile) {	
			addFile();
		}	
		if (e.getSource() == removeFile) {
			removeFile();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	
	public void addFile() {
		value = filec.showOpenDialog(null);	
		if (value == JFileChooser.APPROVE_OPTION) {
			chosenFile = filec.getSelectedFile();
			url = chosenFile.toString();
			name = chosenFile.getName();
			String[] ext = name.split("\\.");
			extention = ext[1];
			if (txt.equals(extention)) {
				fileH.addFile(name);
				combo.addItem(name);
				combo2.addItem(name);
				fileH.addFileDetails(name,url);
				System.out.println(fileH.fileDetails.get(name));	
			}
			else {
				JOptionPane.showMessageDialog(this,"You need to select a text file!!(Ends in .txt)");
				System.out.println("file selected unsuccesfully");
			}
		}	
		
	}
	
	public void removeFile() {
		   combo2.addItem("");
		   System.out.println(combo2.getSelectedItem());
		   myPanel4.revalidate();
		   myPanel4.repaint();

	}
	
	
}