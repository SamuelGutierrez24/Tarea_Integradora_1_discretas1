package Read;

import com.google.gson.Gson;

import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ToJsonWriter {

    public void ToJson(ArrayList<User> users ){
        Gson gson = new Gson();

       
        String json = gson.toJson(users);
        try {
            FileOutputStream fos = new FileOutputStream(new File("Users.txt"));
            fos.write( json.getBytes(StandardCharsets.UTF_8) );
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
