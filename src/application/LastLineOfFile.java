package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class LastLineOfFile {   
	String str; 
	public String getStr() {
		return str;
	}
	LastLineOfFile(File file, int nLines) {
		try {			        
	        Process p = Runtime.getRuntime().exec("tail -"+nLines+" "+file);
	        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream(), "Unicode"));
			String line= new String("");
			str = new String("");
			while ((line = in.readLine()) != null) {
			    str += line + '\n';
				
			}
			        
	                in.close();
		    } 
		    catch (UnsupportedEncodingException e) 
		    {
				System.out.println(e.getMessage());
		    } 
		    catch (IOException e) 
		    {
				System.out.println(e.getMessage());
		    }
		    catch (Exception e)
		    {
				System.out.println(e.getMessage());
		    }
		}
}
