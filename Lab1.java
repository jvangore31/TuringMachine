import java.util.Scanner;
import java.io.*;

/** Functions as a driver/Test enviornment for a Turing Machine    
    @author     Jacob Vangore
    @id         jbvangore
    @course     CSIS 252: Programming II
    @assignment Turing Machine
    @related    Tape, Instruction, TuringMachine
*/
public class Lab1
{

  public static void main(String[] args) throws FileNotFoundException
  {
      //main variables
      TuringMachine myMachine;
      Tape myTape;
      Instruction[] instructionSet;
      int lines = 0;
      //the input file with the tape and the instructions
      Scanner inFile = new Scanner(new FileReader("sample2.txt")); //!!!!!!!INSERT NAME OF FILE HERE (SCROLL DOWN, THERE'S MORE!)!!!!!!!!!
      //the output file where the final tape will go
      PrintWriter writer = new PrintWriter("OutputFile.txt");
      
      
      //variables to make a tape object
      String tapeLine = inFile.nextLine();
      String[] tapeArray = tapeLine.split("");
      int[] tapeInput = new int[tapeArray.length];
      //fills up the tape array
      for (int i = 0; i < tapeArray.length; i++)
      {
        tapeInput[i] = Integer.parseInt(tapeArray[i]);
      }
       //tape object initialized
       myTape = new Tape(tapeInput);
        
       //go through the rest of the file create sets of instructions and store them in an array. 
       String instructionLine;
       String[] instructionArray;
       int[] instructionInput;
      
       //counts how many lines of instructions there are
       while(inFile.hasNextLine())
       {
         lines++;
         inFile.nextLine();
       }
       //closes the in file
       inFile.close();
       
       //sets the size of the set of instructions 
       instructionSet = new Instruction[lines];
       
       //Creates a new scanner to read the instructions and store them 
       Scanner reOpen = new Scanner(new FileReader("sample2.txt")); //!!!!!!!INSERT NAME OF FILE HERE (SCROLL DOWN, THERE'S MORE!)!!!!!!!!!
      
       //skips past the line of tape in the file
       reOpen.nextLine();
      
       //variables to fill up the array of instructions
       Instruction newInstruction;
       String line;
       Scanner IntLine;
       int state;
       int input;
       int newState;
       int output;
       int direction; 
       
       //Prints the original tape line
       System.out.println("Original: " + myTape.toString());
       writer.println("Original: " + myTape.toString());
       //loop to go through all of the lines of instructions
       for(int i= 0; i < instructionSet.length ; i++)
       {
         //stores the line of instruction as a string
         line = reOpen.nextLine();
         //prints out all of the instructions
         System.out.println(line);
         writer.println(line);
         //loads that line into a scanner
         IntLine = new Scanner(line);
         
          //reads all the integers of that string
          //and stores them in the appropriate space
          state = IntLine.nextInt();
          input = IntLine.nextInt();
          newState = IntLine.nextInt();
          output = IntLine.nextInt();
          direction = IntLine.nextInt();
          
          //creates a new instruction with the variables above
          newInstruction = new Instruction(state,input,newState,output,direction);
          //places that instruction in the set of instructions         
          instructionSet[i] = newInstruction;
        
        }           
         //initializes the turing machine
         myMachine = new TuringMachine(myTape, instructionSet);
         //runs the turing machine
         myMachine.run();
         //prints the tape after it runs through the turing machine
         System.out.println("Altered: " + myMachine.getFinalOutput());
         //prints to the output file
         writer.println("Altered: " + myMachine.getFinalOutput());
         writer.close();
       }
   }
