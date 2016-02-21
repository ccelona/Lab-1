//Lab Group 011-04 (Akparanta, Celona, Hennen, Troy)

import java.util.Scanner;
public class Finance {
	public static void main(String[] args) {
		//getting inputs
		double[] vars = getInputs(); //This can be changed to a predefined array if needed
		
		//times and interest rates
		double timeRet = vars[2];
		double timeWork = vars[0];
		double rret = vars[3];
		if (rret > 1) { //make sure interest rate is a rate not a percentage
			rret /= 100;
		}
		double rwork = vars[1];
		if (rwork > 1) { //formatting interest rate again
			rwork /= 100;
		}
		//Calculations
		double mIncome = vars[4] - vars[5]; //required monthly retirement income
		double totSave = mIncome*((1-(1/Math.pow(1+rret/12,timeRet*12))))/(rret/12);
		double mSave = totSave*((rwork/12)/((Math.pow(1+rwork/12,timeWork*12))-1));
		
		//Rounding answer to the nearest cent
		mSave *= 100;
		mSave = Math.round(mSave);
		mSave /= 100;
		
		//Printing
		System.out.println("You need to save: " + "$" + mSave + " each month.");
	}
	/*
	 * Helper methods for inputs
	 */
	public static double getArg() { //Getting inputs for main function
		Scanner input = new Scanner(System.in);
		double var = input.nextDouble(); // convert to short
		//input.close();
		return var; //return the short
	}
	public static double[] getInputs() { //Getting all inputs as array
		double[] vals = new double[6];
		System.out.println("Enter the number of years you will work: ");
		vals[0] = getArg();
		System.out.println("Enter the interest rate during this time: ");
		vals[1] = getArg();
		System.out.println("Enter the number of years you will be retired: ");
		vals[2] = getArg();
		System.out.println("Enter the interest rate during this time: ");
		vals[3] = getArg();
		System.out.println("Enter your required montly income during retirement: ");
		vals[4] = getArg();
		System.out.println("Enter your monthly Social Security income during retirement: ");
		vals[5] = getArg();
		return vals;
	}
}