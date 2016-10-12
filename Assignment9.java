// Assignment #: ASU CSE205 Assignment #9
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9AM-9:50AM
//  Description: this program reads in a sequence of numbers from standard
//  input until 0 is read and stores the numbers in an array, it then
//  compute the minimum number, the count of odd numbers (includes both postive and negative),
//  the number of -1 inside the array, and compute the sum of numbers at even indexes
//  (i.e. 0, 2, 4, ...), using recursion.

import java.util.Scanner;
import java.io.IOException;
public class Assignment9
{
/******************************************************************************
  ***Complete the main() method. See above program description for details.
******************************************************************************/
  public static void main (String[] args) throws IOException
  {
		Scanner scan = new Scanner(System.in);
	  	int sIndex = 0;
	  	int eIndex = 0;
	  	int intege = 0;
	  	try
	  	{
	  		intege = scan.nextInt();
		}
		catch(Exception exception)
		{
			System.out.println("IOException Found");
		}

	  	int[] allNumbers = new int[100];
	  	while(intege != 0)
	  	{
			allNumbers[eIndex] = intege;
			eIndex += 1;
			intege = scan.nextInt();
		}
		System.out.println("The minimum number is " + findMin(allNumbers, sIndex, eIndex));
		System.out.println("The total number of odd integers is " + countOdd(allNumbers,sIndex, eIndex));
		System.out.println("The total number of -1 is " + countNegativeOne(allNumbers, eIndex));
		System.out.println("The sum of numbers at even indexes is " + computeSumAtEvenIndexes(allNumbers, eIndex));
  }

/*************************************************************************************
***(1)Complete the method. The method finds the minimum number in the partial array
***range from startIndex to endIndex
*************************************************************************************/
public static int findMin(int[ ] numbers, int startIndex, int endIndex)
{
	if(startIndex == endIndex)
		return numbers[startIndex];
	else
	{
		int midIndex = (startIndex + endIndex)/2;
		int leftMin = findMin(numbers, startIndex, midIndex);
		int rightMin = findMin(numbers, midIndex+1, endIndex);
		if (leftMin < rightMin)
			return leftMin;
		else
			return rightMin;
	}
}

/**************************************************************************************
***(2)Complete the method. The method counts the number of odd integers in the partial
***array range from startIndex to endIndex
*************************************************************************************/
public static int countOdd(int[ ] numbers, int startIndex, int endIndex)
{
	int sumOfOdd = 0;
	if(startIndex == endIndex)
	{
		if(numbers[endIndex] % 2 != 0)
			return 1;
		else
			return 0;
	}
	else
	{
		int midIndex = (startIndex + endIndex)/2;
		int leftOdd = countOdd(numbers, startIndex, midIndex);
		int rightOdd = countOdd(numbers, midIndex+1, endIndex);
		sumOfOdd = leftOdd + rightOdd;
		return sumOfOdd;
	}
}
/*************************************************************************************
***(3)Complete the method. The method counts the number of -1 inside an array with
***   "count" numbers, index ranges from 0 to count-1
*************************************************************************************/
public static int countNegativeOne(int[ ] numbers, int count)
{
	if (count == 1)
	{
		if (numbers[count-1] == -1)
			return 1;
		else
			return 0;
	}
	else
	{
		if (numbers[count-1] == -1)
			return countNegativeOne(numbers, count-1) + 1;
		else
			return countNegativeOne(numbers, count-1);
	}
}

/**************************************************************************************
***(4)Complete the method. The method computes the sum of numbers at index 0, 2, 4, ...
***  inside a partial array with "count" numbers inside, index ranges from 0 to count-1
***************************************************************************************/
public static int computeSumAtEvenIndexes(int[ ] numbers, int count)
{
	if (count == 1)
		return numbers[count-1];
	else
	{
		if(count % 2 == 0)
		{
			return computeSumAtEvenIndexes(numbers, count-1);
		}
		else
		{
			return computeSumAtEvenIndexes(numbers, count-1) + numbers[count-1];
		}
	}
}
}// end of class Assignment9