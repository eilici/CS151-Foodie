package foodie;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//utility class to append users to file.
public class FileViewer {
	
	private File f;
	private Scanner s;
	String fileString;
	
	FileViewer (File f) throws IOException{
		this.f = f;
		
		//make String of file
		s = new Scanner(f);
		fileString = s.useDelimiter("\\A").next();
		s.close();
	}
	

	public File getFile() {
		return f;
	}

	public void setFile(File f) {
		this.f = f;
	}

	public String getFileString() {
		return fileString;
	}

	public void setFileString(String fileString) {
		this.fileString = fileString;
	}
	
	

}
