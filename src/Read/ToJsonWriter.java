package Read;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.*;

import model.*;

public class ToJsonWriter {
	
	public static void write(ArrayList x) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String json = gson.toJson(x);
		
        System.out.print(json);
        
        try {
        	
        	File f = new File("PruebaUser.txt");
        	
            FileOutputStream fos = new FileOutputStream((f.getAbsolutePath()));    
            
            fos.write( json.getBytes(StandardCharsets.UTF_8) );
            
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
}