package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

	static ArrayList<String> commands = new ArrayList<String>();
	static ArrayList<Integer>arguments = new ArrayList<Integer>();
	public static String commandsString = "";
	public static void Reader(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner reader = new Scanner(file);
		try {
			if (file.isFile() && file.getName().endsWith(".hysq")) {
				//Actual File Reader is right here
				while (reader.hasNextLine()) {
					commands.add(reader.nextLine());
				}
				commandsString = commands.toString();
				commandsString = commandsString.replace("[", " ");
				commandsString = commandsString.replace("]", " ");
				commandsString = commandsString.trim();
				//String[] commandsFinalp1 = commandsString.split(",");
				String[] commandsFinalp1 = commandsString.toString().split(":");
				String commandsFinalp2 = "";
				String argumentsFinal = "";
				for (int i = 0 ; i < commandsFinalp1.length ; i++) {
					commandsFinalp1[i] = commandsFinalp1[i].replace(",", " ");
					commandsFinalp1[i] = commandsFinalp1[i].trim();
					commands.clear();
				}
				for (int i = 0 ; i < commandsFinalp1.length ; i += 2) {
					commands.add(commandsFinalp1[i]);
				}
				commandsFinalp2 = commands.toString();
				commandsFinalp2 = commandsFinalp2.replace("[", " ");
				commandsFinalp2 = commandsFinalp2.replace("]", " ");
				commandsFinalp2 = commandsFinalp2.replace(",", "");
				commandsFinalp2 = commandsFinalp2.trim();
				Main.command = commandsFinalp2;
				for (int i = 1 ; i < commandsFinalp1.length ; i += 2) {
					arguments.add(Integer.parseInt(commandsFinalp1[i]));
				}
				argumentsFinal = arguments.toString();
				argumentsFinal = argumentsFinal.replace("[", " ");
				argumentsFinal = argumentsFinal.replace("]", " ");
				argumentsFinal = argumentsFinal.replace(",", "");
				argumentsFinal = argumentsFinal.trim();
				Main.argument = argumentsFinal;
			} else {
				System.out.println("File not a Hypersquit source file");
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
	}
}
