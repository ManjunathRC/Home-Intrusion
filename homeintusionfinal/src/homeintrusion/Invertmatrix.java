/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeintrusion;

import java.util.*;
import java.io.*;

public class Invertmatrix {

    
    public static void main(String[] args) {
       try{
       //String str = "one two three four one two three four";
       String str = "one two three four one two three four";
      
       //aa = aa.replaceAll("\r\n", " ");
//       FileInputStream fis = new FileInputStream("testforinvertmatrix.txt");
//       byte bb[] = new byte[fis.available()];
//       fis.read(bb);
//       fis.close();
//       str = new String(bb);
      
       //String originalString = new String(bb);
       //str = originalString;
       str = str.replaceAll("\r\n", " ");
       
       System.out.println(str);
       System.out.println("*************************************");
       System.out.println(str);
       ArrayList<String> wholeData = new ArrayList<String>();
       wholeData.clear();
       
       StringTokenizer st = new StringTokenizer(str," ");
       while(st.hasMoreTokens()){
           wholeData.add(st.nextToken());
       }
       ArrayList<String> unique = new ArrayList<String>();
       unique.clear();
       unique = (ArrayList<String>)wholeData.clone();
       Set set = new HashSet(unique);
       unique.clear();
       unique.addAll(set);
       
       ArrayList<Integer> allWeights = new ArrayList<Integer>();
       allWeights.clear();
       allWeights = new SetGetWeights().setWeights(unique);
       
       for(int i=0;i<allWeights.size();i++){
           System.out.println(unique.get(i)+"   "+allWeights.get(i));
       }
        System.out.println("---------------------------------");
       ArrayList<Integer> allReps = new ArrayList<Integer>();
       allReps.clear();
       for(int i=0;i<wholeData.size();i++){
           String data = wholeData.get(i);
           int index = unique.indexOf(data);
           int value = allWeights.get(index);
           allReps.add(value);
       }
       for(int i=0;i<allReps.size();i++){
           System.out.print(allReps.get(i));
           System.out.print("\t");
       }
       System.out.println();
       for(int i=0;i<wholeData.size();i++){
           System.out.print(wholeData.get(i));
           System.out.print("\t");
       }
       System.out.println();
       System.out.println("---------------------------------");
       
       ArrayList<String> invertMatrix = new ArrayList<String>();
       invertMatrix.clear();
       
       ArrayList<String> neighbourItems = new ArrayList<String>();
       neighbourItems.clear();
       int count = 0;
       String invertString = "";
       for(int i=0;i<unique.size();i++){
           String outerItem = unique.get(i);
           for(int j=0;j<wholeData.size()-1;j++){
              String innerItem = wholeData.get(j);
              if(innerItem.equals(outerItem)){
                  neighbourItems.add(wholeData.get(j+1));
              }
           }
           ArrayList<String> neighbourUniqueItems = new ArrayList<String>();
           neighbourUniqueItems.clear();
           neighbourUniqueItems = (ArrayList<String>)neighbourItems.clone();
           Set set1 = new HashSet(neighbourUniqueItems);
           neighbourUniqueItems.clear();
           neighbourUniqueItems.addAll(set1);
           
           for(int k=0;k<neighbourUniqueItems.size();k++){
               String nUnique = neighbourUniqueItems.get(k);
               int frequency = Collections.frequency(neighbourItems,nUnique);
               for(int l=0;l<frequency;l++){
                   int index = unique.indexOf(nUnique);
                   int value = allWeights.get(index);
                   ++count;
                   invertString = invertString +outerItem+"["+value+","+count+"]"+"  ";
               }
               invertMatrix.add(invertString);
           neighbourItems.clear();
           neighbourUniqueItems.clear();
           count = 0;
           invertString = "";
           }
       }
       //System.out.println("---------------------------------");
       for(int i=0;i<invertMatrix.size();i++){
           System.out.println(invertMatrix.get(i));
       }
       //System.out.println(invertMatrix);
       }catch(Exception e){
           System.out.println(e);
       }
    }
    
}
