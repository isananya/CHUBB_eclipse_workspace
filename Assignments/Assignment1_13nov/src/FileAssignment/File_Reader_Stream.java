package FileAssignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class File_Reader_Stream {
	public static void main(String[] args) {
    	String fname = "src/FileAssignment/file.txt";
		try {
			long cnt = Files.lines(Paths.get(fname)).flatMap(line -> java.util.Arrays.stream(line.split("\\s+")))
					.filter(word -> word.equalsIgnoreCase("india")).count();

			System.out.println("Count = " + cnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
