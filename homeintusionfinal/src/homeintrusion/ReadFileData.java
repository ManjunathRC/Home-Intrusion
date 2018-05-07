/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeintrusion;
import java.io.*;

public class ReadFileData {
    String data = "";
  public String fileData(String path){
      try{
      FileInputStream fis = new FileInputStream(path);
      byte bb[] = new byte[fis.available()];
      fis.read(bb);
      fis.close();
      data = new String(bb);
      }catch(Exception e){
          System.out.println(e);
      }
      return data;
  }  
}
