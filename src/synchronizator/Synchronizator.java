package synchronizator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Synchronizator {	
	public static void main(String[] args ) {
	File directory = new File("C:\\files");
	File[] list = directory.listFiles();
	
	try {
		printContents(list);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	
	public static void printNames(File[] list) {
		System.out.println("Files: ");
		for(int i=0;i<list.length;i++) {
			if(list[i].isFile()) {
				System.out.println(list[i].getName());
			}
		}
	}
	
	public static void printContents(File[] list) throws IOException {
		for(int i=0; i<list.length;i++) {
			String fileName = list[i].getPath();
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String line = null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
				
			System.out.println("===============");
		}
	}
	
	
	}
	
	











