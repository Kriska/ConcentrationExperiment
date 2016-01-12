package application;

import java.io.BufferedReader;
import java.io.File;
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
		BufferedReader in = null;
		try {			        
	        Process p = Runtime.getRuntime().exec("tail -"+nLines+" "+file);
			in = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("UTF-16")));
			String line= new String("");
			str = new String("");
			while ((line = in.readLine()) != null) {
			    str += line + " \n";
			}
		    } 
		    catch (UnsupportedEncodingException e) 
		    {
				System.out.println(e.getMessage());
		    } 
		    catch (Exception e)
		    {
				System.out.println(e.getMessage());
		    } finally
		    {

                try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
}
