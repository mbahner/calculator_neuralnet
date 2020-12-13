package calculator;

import java.lang.UnsupportedOperationException;
import java.util.List;

public class Calculator {
	
	private final List<boolean[][]> matrixLayers;
	
	/**
	 * Constructor to make a random calculator
	 * @param bitStringLength
	 * @param layerDepth
	 */
	public Calculator(int bitStringLength, int layerDepth) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Constructor to breed a new calculator
	 * @param calc1 parent calculator
	 * @param calc2 parent calculator
	 * @param mutationPercentage probablility of a local mutation
	 */
	public Calculator(Calculator calc1, Calculator calc2, Double mutationPercentage) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Calculate the sum of two binary strings
	 * @param num1 bit string of first number
	 * @param num2 bit string of second number
	 * @return binary string that is the two bit strings added
	 */
	public boolean[] add(boolean[] num1, boolean[] num2) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int hashCode() {
		throw new UnsupportedOperationException();
	}
	
}
