
package homeintrusion;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class ImageComparisionFinal1 {
    
    ArrayList<Double> percentageOfComparisions = new ArrayList<Double>();
    
    public ArrayList<Double> getPercentageOfMatchings(String sourceImagePath){
        percentageOfComparisions.clear();
        try{
        BufferedImage imgA = null;
        BufferedImage imgB = null; 
        File fileA = new File(sourceImagePath);
        imgA = ImageIO.read(fileA);
        String destPath = "db";
        File file = new File(destPath);
        String files[] = file.list();
        int width1 = imgA.getWidth();
        int height1 = imgA.getHeight();
        for(int i=0 ;i<files.length;i++){
            String fileName = "db/"+files[i];
            File fileB = new File(fileName);
            imgB = ImageIO.read(fileB);
            int width2 = imgB.getWidth();
            int height2 = imgB.getHeight();
            long difference = 0;
            for (int y = 0; y < height1; y++){
                for (int x = 0; x < width1; x++){
                    int rgbA = imgA.getRGB(x, y);
                    int rgbB = imgB.getRGB(x, y);
                    int redA = (rgbA >> 16) & 0xff;
                    int greenA = (rgbA >> 8) & 0xff;
                    int blueA = (rgbA) & 0xff;
                    int redB = (rgbB >> 16) & 0xff;
                    int greenB = (rgbB >> 8) & 0xff;
                    int blueB = (rgbB) & 0xff;
                    difference += Math.abs(redA - redB);
                    difference += Math.abs(greenA - greenB);
                    difference += Math.abs(blueA - blueB);
                }
            }
            double total_pixels = width1 * height1 * 3; 
            double avg_different_pixels = difference /total_pixels;
            double percentage = (avg_different_pixels /255) * 100;
            percentageOfComparisions.add(100-percentage);
        }
        }catch(Exception e){
            System.out.println(e);
        }
        return percentageOfComparisions;
    }
    
}
