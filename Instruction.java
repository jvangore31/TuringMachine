/** stores an instruction, includes the state, input, new state, output and direction    
    @author     Jacob Vangore
    @id         jbvangore
    @course     CSIS 252: Programming II
    @assignment Turing Machine
    @related    n/a
*/

public class Instruction
{
  // MEMBER DATA, INSTANCE VARIABLES
  /*The state*/
  int State;
  /*The input*/
  int Input;
  /*The new state*/
  int New_State;
  /*The output*/
  int Output;
  /*The direction*/
  int Direction;
 
 // MEMBER BEHAVIOR, METHODS
 
  /** Constructor
        @param newState the state
        @param newInput the input
        @param newNewState the new state
        @param newOutput the output
        @param newDirection the direction
        
  */
 public Instruction(int newState, int newInput, int newNewState, int newOutput, int newDirection)
 {
    State = newState;
    Input = newInput;
    New_State = newNewState;
    Output = newOutput;
    Direction = newDirection;   
 }
  
 /** return state for this instruction
        @return int
 */
  public int getState()
  {
    return State;
  }
 /** return input for this instruction
        @return int
 */ 
  public int getInput()
  {
   return Input;
  }
 /** return new state for this instruction
        @return int
 */
  public int getNew_State()
  {
   return New_State;
  }
/** return output for this instruction
        @return int
 */
  public int getOutput()
  {
   return Output;
  }
/** return output for this instruction
        @return int
 */ 
  public int getDirection()
  {
    return Direction;
  }
}