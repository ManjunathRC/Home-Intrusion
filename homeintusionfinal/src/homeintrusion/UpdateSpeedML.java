
package homeintrusion;
import java.io.*;
import java.util.*;

public class UpdateSpeedML {    
    String fileName = "";
    ArrayList<String> values = new ArrayList<String>();
    public void updateSpeed(String homeName,String entryName,String value){
        values.clear();
        try{
        if(homeName.equals("home1")){
           fileName = "speed/home1/speed.txt";
        }
        else if(homeName.equals("home2")){
           fileName = "speed/home2/speed.txt";
        }
        else if(homeName.equals("home3")){
           fileName = "speed/home3/speed.txt";
        }
        else if(homeName.equals("home4")){
           fileName = "speed/home4/speed.txt";
        }
        else if(homeName.equals("home5")){
           fileName = "speed/home5/speed.txt";
        }
        FileInputStream fis = new FileInputStream(fileName);
        byte bb[] = new byte[fis.available()];
        fis.read(bb);
        fis.close();
        String oldString = new String(bb);
        StringTokenizer st = new StringTokenizer(oldString," ");
        while(st.hasMoreTokens()){
            values.add(st.nextToken());
        }
        if(entryName.equals("ENTRY1")){
           values.set(0, value);
        }
        else if(entryName.equals("ENTRY2")){
           values.set(1, value); 
        }
        else if(entryName.equals("ENTRY3")){
            values.set(2, value);
        }
        String toUpdate= values.get(0)+" "+values.get(1)+" "+values.get(2);
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(toUpdate.getBytes());
        fos.close();
        
        }catch(Exception e){
            System.out.println(e+" in machine learning file");
        }
    }
    
}
