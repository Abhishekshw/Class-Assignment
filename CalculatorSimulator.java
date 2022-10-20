package Exeption;

class CountryNotValidException extends Exception {
	CountryNotValidException(String str) {
		super(str);
	}
}

class EmployeeNameInvalidException extends Exception {
	EmployeeNameInvalidException(String str) {
		super(str);
	}
}

class TaxNotEligibleException extends Exception {
	TaxNotEligibleException(String str) {
		super(str);
	}
}

class TaxCalculator {// class with calculatetax method

	double calculateTax(String empName, double empSal, boolean isIndian) throws Exception {
		double TaxAmount = 0;

		if (isIndian == false) {// checking indian or not
			throw new CountryNotValidException("The Emplooye Should be an indian citizen for calculating tax");
		} else if (empName == null) {// checking empNAME IS empty or not
			throw new EmployeeNameInvalidException("the employee name cannot be empty");
		}
		// calculating tax
		if (empSal >= 100000 && isIndian == true) {
			TaxAmount = empSal * 8 / 100;
		} else if (empSal < 100000 && empSal >= 50000 && isIndian == true) {
			TaxAmount = empSal * 6 / 100;
		} else if (empSal < 50000 && empSal >= 30000 && isIndian == true) {
			TaxAmount = empSal * 5 / 100;
		} else if (empSal < 30000 && empSal >= 10000 && isIndian == true) {
			TaxAmount = empSal * 4 / 100;
		} else {
			throw new TaxNotEligibleException("the employee does not need to pay tax");
		}
		return TaxAmount;
	}

}

public class CalculatorSimulator {// class with main method
	public static void main(String[] args) throws Exception {
		TaxCalculator T = new TaxCalculator();// object of tax class
		try {
			System.out.println("the amount of tax is " + T.calculateTax("Ron", 34000, false));// passing values
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("the amount of tax is " + T.calculateTax("Tim", 1000, true));// passing values
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("the amount of tax is " + T.calculateTax("jack", 55000, true));// passing values
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
