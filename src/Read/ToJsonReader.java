package Read;

import com.google.gson.Gson;
import model.User;
import java.io.*;
import java.util.ArrayList;

public class ToJsonReader {

    private ArrayList<User> users;

    public ArrayList<User> read(String path) {
        try {
            File file = new File(path);
            //System.out.println("Existe: "+file.exists());
            FileInputStream fis = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String json = "|";
            String line;
            if((line=reader.readLine())!=null){
                json= line;
            }
            fis.close();
            //System.out.println(json);

            Gson gson = new Gson();
            User[] usersFromJson = gson.fromJson(json, User[].class);

            for(User p : usersFromJson){
                users.add(p);
                System.out.println(p.getName()+" "+p.getAge());
                
            }
            reader.close();
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

}