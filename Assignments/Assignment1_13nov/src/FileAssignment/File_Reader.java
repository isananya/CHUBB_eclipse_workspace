package FileAssignment;

import java.io.*;

public class File_Reader {
    public static void main(String[] args) {
    	String fname = "src/FileAssignment/file.txt";
        int cnt = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase("india")) {
                        cnt++;
                    }
                }
            }
            System.out.println("Count = " + cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
