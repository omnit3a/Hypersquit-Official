package src;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	
	//Memory
	public static int[] compMemory = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	//Registers
	public static int registerA = 0;
	public static int registerB = 0;
	public static int registerC = 0;
	public static int registerE = 0;
	
	//Status Flags
	public static int programCounter = 1;
	
	public static ArrayList<String> commands = new ArrayList<String>();
	public static ArrayList<Integer> arguments = new ArrayList<Integer>();

	public static void Tokenizer(String command, String argument){
		StringTokenizer st = new StringTokenizer(command);
		StringTokenizer in = new StringTokenizer(argument);
		while (st.hasMoreTokens()) {
			switch (st.nextToken()) {
			
			case "RASEPC":
				registerE = programCounter;
				System.out.println("PROGRAM COUNTER: "+programCounter);
				continue;
			case "RAISEA":
				registerA = Integer.parseInt(in.nextToken());
				programCounter++;
				System.out.println("RAISEA: #"+registerA);
				continue;
			case "RAISEB":
				registerB = Integer.parseInt(in.nextToken());
				programCounter++;
				System.out.println("RAISEB: #"+registerB);
				continue;
			case "RAISEE":
				registerE = Integer.parseInt(in.nextToken());
				programCounter++;
				System.out.println("RAISEE: #"+registerE);
				continue;
			case "STOREA":
				compMemory[Integer.parseInt(in.nextToken())] = registerA;
				programCounter++;
				System.out.println("STOREA");
				continue;
			case "STOREB":
				compMemory[Integer.parseInt(in.nextToken())] = registerB;
				programCounter++;
				System.out.println("STOREB");
				continue;
			case "STOREC":
				compMemory[Integer.parseInt(in.nextToken())] = registerC;
				programCounter++;
				System.out.println("STOREC");
				continue;
			case "STOREE":
				compMemory[Integer.parseInt(in.nextToken())] = registerE;
				programCounter++;
				System.out.println("STOREE");
				continue;
			case "INCREM":
				compMemory[Integer.parseInt(in.nextToken())]++;
				programCounter++;
				System.out.println("INCREM");
				continue;
			case "DECREM":
				compMemory[Integer.parseInt(in.nextToken())]--;
				programCounter++;
				System.out.println("DECREM");
				continue;
			case "ADDTNA":
				registerC = compMemory[Integer.parseInt(in.nextToken())] + registerA;
				programCounter++;
				System.out.println("ADDTNA: STORED IN C");
				continue;
			case "ADDTNB":
				registerC = compMemory[Integer.parseInt(in.nextToken())] + registerB;
				programCounter++;
				System.out.println("ADDTNB: STORED IN C");
				continue;
			case "SUBTNA":
				if (registerA >= 1) {
					registerC = compMemory[Integer.parseInt(in.nextToken())] - registerA;
					programCounter++;
					System.out.println("SUBTNB: STORED IN C");
					continue;
				} else {
					System.out.println("COULD NOT SUBTNA");
					continue;
				}
			case "SUBTNB":
				if (registerB >= 1) {
					registerC = compMemory[Integer.parseInt(in.nextToken())] - registerB;
					programCounter++;
					System.out.println("SUBTNB: STORED IN C");
					continue;
				} else {
					System.out.println("COULD NOT SUBTNB");
					continue;
				}
			case "BRNCHA":
				if (registerA == Integer.parseInt(in.nextToken())) {
					programCounter++;
					continue;
				} else {
					programCounter++;
					st.nextToken();
					in.nextToken();
					continue;
				}
			case "BRNCHB":
				if (registerB == Integer.parseInt(in.nextToken())) {
					programCounter++;
					continue;
				} else {
					programCounter++;
					st.nextToken();
					in.nextToken();
					continue;
				}
			case "BRNCHC":
				if (registerC == Integer.parseInt(in.nextToken())) {
					programCounter++;
					continue;
				} else {
					st.nextToken();
					in.nextToken();
					continue;
				}
			case "BRNCHE":
				if (registerE == Integer.parseInt(in.nextToken())) {
					programCounter++;
					continue;
				} else {
					st.nextToken();
					in.nextToken();
					continue;
				}
			case "BRCHNA":
				if (registerA != compMemory[Integer.parseInt(in.nextToken())]) {
					programCounter++;
					continue;
				} else {
					st.nextToken();
					in.nextToken();
					continue;
				}
			case "BRCHNB":
				if (registerB != compMemory[Integer.parseInt(in.nextToken())]) {
					programCounter++;
					continue;
				} else {
					st.nextToken();
					in.nextToken();
					continue;
				}
			case "BRCHNC":
				if (registerC != compMemory[Integer.parseInt(in.nextToken())]) {
					programCounter++;
					continue;
				} else {
					st.nextToken();
					in.nextToken();
					continue;
				}
			case "BRCHNE":
				if (registerE != compMemory[Integer.parseInt(in.nextToken())]) {
					programCounter++;
					continue;
				} else {
					st.nextToken();
					in.nextToken();
					continue;
				}
			case "STARTA":
				if (registerA == Integer.parseInt(in.nextToken())) {
					st = new StringTokenizer(command);
					in = new StringTokenizer(argument);
					programCounter++;
					continue;
				} else {
					continue;
				}
			case "STARTB":
				if (registerB == Integer.parseInt(in.nextToken())) {
					st = new StringTokenizer(command);
					in = new StringTokenizer(argument);
					programCounter++;
					continue;
				} else {
					continue;
				}
			case "STARTC":
				if (registerC == Integer.parseInt(in.nextToken())) {
					st = new StringTokenizer(command);
					in = new StringTokenizer(argument);
					programCounter++;
					continue;
				} else {
					continue;
				}
			case "STARTE":
				if (registerE == Integer.parseInt(in.nextToken())) {
					st = new StringTokenizer(command);
					in = new StringTokenizer(argument);
					programCounter++;
					continue;
				} else {
					continue;
				}
			case "EXITPR":
				int exitCode = Integer.parseInt(in.nextToken());
				System.out.println("EXITCODE: "+exitCode);
				System.exit(exitCode);
			
			case "LOADRA":
				registerA = compMemory[Integer.parseInt(in.nextToken())];
				programCounter++;
				continue;
			case "LOADRB":
				registerB = compMemory[Integer.parseInt(in.nextToken())];
				programCounter++;
				continue;
			case "LOADRE":
				registerE = compMemory[Integer.parseInt(in.nextToken())];
				programCounter++;
				continue;
			case "NOOPER":
				programCounter++;
				continue;
			case "GSTART":
				st = new StringTokenizer(command);
				in = new StringTokenizer(argument);
				programCounter++;
				continue;
			case "OUTPUT":
				System.out.println(compMemory[Integer.parseInt(in.nextToken())]);
				programCounter++;
				continue;
			case "OUTPPC":
				System.out.println(programCounter);
				programCounter++;
				continue;
			}
			
			
			continue;
		}
	}
	
	public static void main(String[] args){
		Tokenizer("RAISEE STOREE BRCHNB LOADRB BRNCHB RAISEB STOREB DECREM OUTPUT RAISEA STOREA BRCHNA GSTART EXITPR",
				  "1 6 6 0 0 5 0 0 0 5 1 0 0 255");
	}
	

}
