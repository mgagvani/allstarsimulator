// Name: Manav Gagvani
// Period: 2nd
// Date: May 11th, 2021

import java.util.*;
import java.util.Scanner;
import java.io.*;

public class DataReader {

   public static void main(String[] args) throws Exception {
      List<List<String>> records = getData("players.csv");
      System.out.println(records);
   }

    public static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values; 
    }
    public static List<List<String>> getData(String path) {
    List<List<String>> records = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(path));) {
        while (scanner.hasNextLine()) {
            records.add(getRecordFromLine(scanner.nextLine()));
        }
     }
     return records;
   }
    // public DataReader(String path) {
    //     getData(path);
    // }
}