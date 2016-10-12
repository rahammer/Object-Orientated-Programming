// Assignment #: Arizona State University CSE205 #11
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Description: This is a utility class that provide a static method that
//				 takes an infix string, checked and determine if parentheses
//				 are matching, if matching, returns a postfix string.

import java.util.Stack;

public class InfixToPostfixConverter
{
	//**********************************************************************
	//The precedence method determines the precedence between two operators.
  	//If the first operator is of higher or equal precedence than the second
  	//operator, it returns the value true, otherwise it returns false.
    //***********************************************************************
   public static boolean precedence(char first, char second)
   {
		if((first == '/' || first == '*') && (second == '+' || second == '-'))
	   		return true;
		else
			return false;
   }

	//*************************************************************************
	//The static convertToPostfix method will convert the infixString
	//into the corresponding postfix string. Check the algorithm on
	//assignment #11's description page. Mark each case clearly inside the code
    //*************************************************************************
   public static String convertToPostfix(String infixString)
   {
      //initialize the resulting postfix string
      String postfixString = "";

      //initialize the stack
      Stack<Character> stack1 = new Stack<Character>();

      char topStack = ' ';

     //Obtain the character at index i in the string
      for (int i=0; i < infixString.length(); i++)
      {
         char currentChar = infixString.charAt(i);

      	//Case A:
		if(Character.isLetter(currentChar))
		{
			postfixString += currentChar;
		}

      	//Case B:
      	if(currentChar == '(')
      	{
			stack1.push(currentChar);
		}

      	//Case C:
      	if(stack1.empty() && (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/'))
      	{
			stack1.push(currentChar);
		}
      	//Case D:  topStack, currentChar
      	if(!stack1.empty())
			topStack = stack1.peek();
      	if(!stack1.empty() && (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/'))
      	{
			if((!stack1.empty()) && (stack1.peek() == '('))
			{
				stack1.push(currentChar);
			}
      		if(!stack1.empty() && precedence(topStack, currentChar))
      		{
      			while(!stack1.empty() && precedence(stack1.peek(), currentChar))
      			{
					postfixString += stack1.pop();
				}
				stack1.push(currentChar);
			}
			else
			{
				stack1.push(currentChar);
			}
		}
      	//Case E:
      	if(currentChar == ')' && !stack1.empty())
      	{
			while(!stack1.empty() && stack1.peek() != '(')
			{
				postfixString += stack1.pop();
				if(!stack1.empty() && stack1.peek() == '(')
				{
					stack1.pop();
				}
			}
		}

      } //end of for loop


    	//Case F:
    	if(!stack1.empty())
    		topStack = stack1.peek();
    	if(topStack == '(')
    		return "No matching close parenthesis error";
    	if(!stack1.empty())
    	{
			for(int i = 0; i < stack1.size(); i++)
			{
				postfixString += stack1.pop();
			}
		}

    	return ("The Postfix Expression is: " + postfixString);

   }//end of convertToPostfix method

}//end of the InfixToPostfixConverter class