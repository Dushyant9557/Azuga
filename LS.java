import java.util.*;
import java.io.*;

class LS{
	public static void main(String args[]){
		File f = new File(System.getProperty("user.dir"));	
		String newArr [] = f.list();
		for(String i: newArr){
			System.out.print(i+"\t");			
		}
}
}
