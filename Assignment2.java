import java.util.Scanner;

public class Assignment2{

// Assignment #: 2
//         Name: Robert Hammerschmidt
//    StudentID: 1207364973
//      Lecture: MWF 9:00-9:50am
//  Description: Reads in an unspecified number of integers from standard input,
//  			 performs some calculations that produce the minimum integer, the
//				 sum of all positive integers, the sum of all odd integers, and the
//				 a count of all the positive integers from the set

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int totalIntege = scan.nextInt();

		int min = totalIntege + 1;
		if (totalIntege == 0)
			min = 0;


		int sumOfPos = 0;
		int sumOfOdd = 0;
		int countOfPos = 0;


		while (totalIntege != 0)
		{

			if (min > totalIntege)
			{
				min = totalIntege;
			}


			if (totalIntege > 0)
			{
				sumOfPos += totalIntege;
			}

			if (totalIntege > 0)
			{
				if (totalIntege % 2 != 0)
				{
					sumOfOdd += totalIntege;
				}
			}

			if (totalIntege > 0)
			{
				countOfPos++;
			}

			totalIntege = scan.nextInt();
		}

		System.out.println("The minimum integer is " + min);
		System.out.println("The sum of the positive integers is " + sumOfPos);
		System.out.println("The sum of the odd integers is " + sumOfOdd);
		System.out.println("The count of positive integers in the sequence is " + countOfPos);

	}
}