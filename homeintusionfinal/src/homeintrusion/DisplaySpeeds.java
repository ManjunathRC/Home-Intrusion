
package homeintrusion;
import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class DisplaySpeeds {
    ArrayList<String> allHomes = new ArrayList<String>();
    ArrayList<String> allEntries = new ArrayList<String>();
    ArrayList<String> allSpeeds = new ArrayList<String>();
    public void displaySpeeds(){
        allHomes.clear();
        allEntries.clear();
        allSpeeds.clear();
        try{        
        allHomes.add("HOME1");
        allHomes.add("HOME1");
        allHomes.add("HOME1");
        allHomes.add("HOME2");
        allHomes.add("HOME2");
        allHomes.add("HOME2");
        allHomes.add("HOME3");
        allHomes.add("HOME3");
        allHomes.add("HOME3");
        allHomes.add("HOME4");
        allHomes.add("HOME4");
        allHomes.add("HOME4");
        allHomes.add("HOME5");
        allHomes.add("HOME5");
        allHomes.add("HOME5");
        
        
        allEntries.add("ENTRY1");
        allEntries.add("ENTRY2");
        allEntries.add("ENTRY3");
        allEntries.add("ENTRY1");
        allEntries.add("ENTRY2");
        allEntries.add("ENTRY3");
        allEntries.add("ENTRY1");
        allEntries.add("ENTRY2");
        allEntries.add("ENTRY3");
        allEntries.add("ENTRY1");
        allEntries.add("ENTRY2");
        allEntries.add("ENTRY3");
        allEntries.add("ENTRY1");
        allEntries.add("ENTRY2");
        allEntries.add("ENTRY3");
        
        
        FileInputStream fisH1 = new FileInputStream("speed/home1/speed.txt");
        byte bbH1[] = new byte[fisH1.available()];
        fisH1.read(bbH1);
        fisH1.close();
        FileInputStream fisH2 = new FileInputStream("speed/home2/speed.txt");
        byte bbH2[] = new byte[fisH2.available()];
        fisH2.read(bbH2);
        fisH2.close();
        FileInputStream fisH3 = new FileInputStream("speed/home3/speed.txt");
        byte bbH3[] = new byte[fisH3.available()];
        fisH3.read(bbH3);
        fisH3.close();
        FileInputStream fisH4 = new FileInputStream("speed/home4/speed.txt");
        byte bbH4[] = new byte[fisH4.available()];
        fisH4.read(bbH4);
        fisH4.close();
        FileInputStream fisH5 = new FileInputStream("speed/home5/speed.txt");
        byte bbH5[] = new byte[fisH5.available()];
        fisH5.read(bbH5);
        fisH5.close();
        
        StringTokenizer stH1 = new StringTokenizer(new String(bbH1)," ");
        while(stH1.hasMoreTokens()){
         allSpeeds.add(stH1.nextToken());   
        }
        StringTokenizer stH2 = new StringTokenizer(new String(bbH2)," ");
        while(stH2.hasMoreTokens()){
         allSpeeds.add(stH2.nextToken());   
        }
        StringTokenizer stH3 = new StringTokenizer(new String(bbH3)," ");
        while(stH3.hasMoreTokens()){
         allSpeeds.add(stH3.nextToken());   
        }
        StringTokenizer stH4 = new StringTokenizer(new String(bbH4)," ");
        while(stH4.hasMoreTokens()){
         allSpeeds.add(stH4.nextToken());   
        }
        StringTokenizer stH5 = new StringTokenizer(new String(bbH5)," ");
        while(stH5.hasMoreTokens()){
         allSpeeds.add(stH5.nextToken());   
        }
        
        Vector<Vector> rowData = new Vector<Vector>();
        rowData.clear();
        Vector<String> row = null;
        JFrame frame = new JFrame();     
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("HOUSE NAME");
        columnNames.addElement("ENTRY NAME");
        columnNames.addElement("SPEED");
        for(int i=0;i<allHomes.size();i++){
             row = new Vector<String>();
             row.add(allHomes.get(i));
             row.add(allEntries.get(i));
             row.add(allSpeeds.get(i));
             rowData.add(row);
        }
        JTable table = new JTable(rowData, columnNames);
             JTableHeader header = table.getTableHeader();
             header.setDefaultRenderer(new KeepSortIconHeaderRenderer(header.getDefaultRenderer()));
             table.getTableHeader().setDefaultRenderer(new HeaderRenderer());

            JScrollPane scrollPane = new JScrollPane(table);

            frame.add(scrollPane, BorderLayout.CENTER); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1300, 1400);
            frame.setTitle("distance display table..");
            frame.setVisible(true);
             frame.setResizable(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
