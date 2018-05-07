
package homeintrusion;
import java.util.*;
import java.io.*;
public class SetGetWeights {
    ArrayList<Integer> weights = new ArrayList<Integer>();
    public ArrayList<Integer> setWeights(ArrayList<String> items){
        weights.clear();
        for(int i=0;i<items.size();i++){
            weights.add(i+1);
        }
        Collections.shuffle(weights);
        return weights;
    }   
}
