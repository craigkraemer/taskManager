import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

class FinalProject {
    public static void main(String[] args) throws IOException {
    	
    	String str = " ";
    	String userInput;
    	int inputNumber = 0;
		
		File fn = new File("tasksList.txt");
    	ArrayList<String> tasks = new ArrayList<String>();
    	
    	fn.delete();
    	
    	fn.createNewFile();
    
    	while(inputNumber == 0) {
    	
    	userInput = JOptionPane.showInputDialog("1. Add a task.\n2. Remove a task.\n3. Mark a task complete.\n4. List the tasks.\n\nWhat would you like to do?");
    	inputNumber = Integer.parseInt(userInput);
    	
    	if(inputNumber == 1) {
    		int id = 0;
    		str = JOptionPane.showInputDialog("Add a task");
    		tasks.add(str);
    	try {
    		FileWriter fw = new FileWriter(fn);
    		BufferedWriter output = new BufferedWriter(fw);
    		int sz = tasks.size();
    		for (int i = 0; i < sz; i++) {
    			id++;
    			output.write(id + ". " + tasks.get(i).toString() + "\n");
    		}    		
    		output.close();
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "Can not create that file");
    	}
    	inputNumber = 0;
    	
    	} else if(inputNumber == 2) {
    		int id = 0;
    		int rStr = -1;
    		str = JOptionPane.showInputDialog("Remove a task");
    		rStr = Integer.parseInt(str);
    		tasks.remove(rStr - 1);
    	try {
    		FileWriter fw = new FileWriter(fn);
    		BufferedWriter output = new BufferedWriter(fw);
    		int sz = tasks.size();
    		for (int i = 0; i < sz; i++) { 
    			id++;
    			output.write(id + ". " + tasks.get(i).toString() + "\n");
    		}    			
    		output.close();
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "Can not create that file");
    	}
    	inputNumber = 0;
    	
    	}	else if(inputNumber == 3) {
    		int id = 0;
    		int com = -1;
    		int rStr = -1;
    		
    		String complete = null;
    		
    		str = JOptionPane.showInputDialog("Mark a task complete");
    		com = Integer.parseInt(str);
    		rStr = Integer.parseInt(str);
    		
    		complete = tasks.get(com - 1);
    		tasks.remove(rStr - 1);
    		tasks.add(complete + " (COMPLETE)");
    		
    	try {
    		FileWriter fw = new FileWriter(fn);
    		BufferedWriter output = new BufferedWriter(fw);
    		int sz = tasks.size();
    		for (int i = 0; i < sz; i++) {
    			id++;
    			output.write(id + ". " + tasks.get(i).toString() + "\n");
    			
    		}    		
    		output.close();
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "Can not create that file");
    	}
    	inputNumber = 0;
    	
    	} else if(inputNumber == 4) {
    		
    		 try {
    	            FileReader reader = new FileReader("tasksList.txt");
    	            BufferedReader bufferedReader = new BufferedReader(reader);
    	 
    	            String line;
    	 
    	            while ((line = bufferedReader.readLine()) != null) {
    	                System.out.println(line);
    	            }
    	            reader.close();
    	 
    	        } catch (IOException e) {
    	            e.printStackTrace();
    	        }
    		 inputNumber = 0;
    } else {
    	System.exit(0);
    
    }
    	}
    	
}
}