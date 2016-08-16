/** stores a tape, instruction set, a current instruction and a state. Does all the operations 
of a turing machine.    
    @author     Jacob Vangore
    @id         jbvangore
    @course     CSIS 252: Programming II
    @assignment Turing Machine
    @related    Tape, Instruction
*/
public class TuringMachine
{
// MEMBER DATA, INSTANCE VARIABLES
  /*The tape*/
  Tape myTape;
  /*The set of instructions*/
  Instruction[] instructionSet;
  /*The current instruction*/
  Instruction currentInstruction;
  /*The current state*/
  int myState;
  
   // MEMBER BEHAVIOR, METHODS
 
  /** Constructor
        @param inTape to create the tape 
        @param inSet to create a set of instructions 
  */
  public TuringMachine(Tape inTape, Instruction[] inSet)
  {
    myTape = inTape;
    instructionSet = inSet;
    myState = 0; 
    //initializes current instruction
    findInstruction(); 
  }
  
  /* changes the value of "currentInstruction" to find one that matches the current state
  and the value in the tape */ 
  public void findInstruction()
  {
    for(int i = 0; i < instructionSet.length; i++)
    {
      if((myState == instructionSet[i].getState()) && (myTape.read() == instructionSet[i].getInput()))
      {
          currentInstruction = instructionSet[i];
      }
    
  
    }
  }
   /* changes the value of "myState," 
      writes in the tape as necessary,
      changes the index of the tape, 
      and finds a new instructions. */ 
  public void performInstruction()
  {
    myState = currentInstruction.getNew_State();
    myTape.write(currentInstruction.getOutput());
    myTape.changeIndex(currentInstruction.getDirection());
    findInstruction();
  }
  
   /* alters the tape as a whole and essentially runs the turing machine as it is supposed 
   to properly function. 
   */ 
  public void run()
  { 
     while(myState >= 0)
     {
       performInstruction(); 
     }
  }
 /* return value of "myState" for this turingMachine
        @return int
 */
  public int getState()
  {
    return myState;
  }
 /** return String labelled representation for the altered version of the tape
     @return String */
  public String getFinalOutput()
  {
    String outTape;
    outTape = myTape.toString();
    return outTape;
  }
  
 
   
}