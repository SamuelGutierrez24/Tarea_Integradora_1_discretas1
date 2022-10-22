package Read;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import model.*;

import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToJsonReader {

    
    public static ArrayList<User> read() {
    	
    	String json = "";
        
        try {
        	
        	File f = new File("BaseDatos.txt");
        	
            BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()));

            String linea;
            
            while ((linea = br.readLine()) != null) {
            	
                json += linea;
                
            }

            br.close();
            
        } catch (FileNotFoundException ex) {
        	
            Logger.getLogger(ToJsonReader.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException ex) {
            Logger.getLogger(ToJsonReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        Gson gson = new Gson();
         
        java.lang.reflect.Type userArrayListType = new TypeToken<ArrayList<User>>() {}.getType();
        
        ArrayList<User> userArrayList = null;
        
        String y = "" ;
        
        if(json != null) {
        
        	userArrayList = gson.fromJson(json, userArrayListType);
           
        }

        return userArrayList;
		
		
	}

}