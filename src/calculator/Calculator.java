package calculator;

import java.lang.UnsupportedOperationException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Calculator {
	
	private final List<boolean[][]> matrixLayers;
	
	/**
	 * Constructor to make a random calculator
	 * @param bitStringLength
	 * @param layerDepth
	 */
	public Calculator(int bitStringLength, int layerDepth) {
		this.matrixLayers = new ArrayList<>();
		for (int level = 0; level < layerDepth; level++) {
			
			// the dimenstion of this layer
			int size = (int)(bitStringLength * Math.pow(2, level + 1) + .01);
			
			// add two squares
			this.matrixLayers.add(this.generateNbyN(size));
			this.matrixLayers.add(this.generateNbyN(size));
		}
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
		boolean[] calculated = this.combine(num1, num2);
		
		// loop through layers
		for (int layer = 0; layer < matrixLayers.size() / 2; layer++) {
			calculated = this.combine(this.multiply(calculated, layer * 2), this.multiply(calculated, layer * 2 + 1));
		}
		
		// reduce result into a smaller array
		return Calculator.reduceResult(num1.length, calculated);
	}
	
	public static boolean[] reduceResult(int desiredLen, boolean[] bits) {
		boolean[] res = new boolean[desiredLen];
		Arrays.fill(res, false);
		int skip = bits.length / desiredLen;
		for (int i = 0; i < desiredLen; i++) {
			for (int j = 0; j < skip; j++) {
				if (bits[i * skip + j]) {
					res[i] = true;
					break;
				}
			}
		}
		return res;
	}
	
	@Override
	public String toString() {
		String res = "";
		for (boolean[][] matrix: this.matrixLayers) {
			res += this.matrixToString(matrix) + "---\n";
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		throw new UnsupportedOperationException();
	}
	
	private String matrixToString(boolean[][] matrix) {
		String res = "";
		for (boolean[] row: matrix) {
			for (boolean cell: row) {
				res += "" + (cell ? "1": "0") + " ";
			}
			res += "\n";
		}
		return res;
	}
	
	// multiply
	private boolean[] multiply(boolean[] num, int matrixNum) {
		assert num.length == this.matrixLayers.get(matrixNum).length;
		
		boolean[] res = new boolean[num.length];
		for (int i = 0; i < num.length; i++) {
			int lineSum = 0;
			for (int j = 0; j < num.length; j++) {
				if (num[j] && this.matrixLayers.get(matrixNum)[i][j]) {
					lineSum++;
				}
			}
			res[i] = lineSum == 2;
		}
		return res;
	}
	
	// turns 2 lists into one
	private boolean[] combine(boolean[] l1, boolean[] l2) {
		boolean[] res = new boolean[l1.length * 2];
		for (int i = 0; i < l1.length; i++) {
			res[i] = l1[i];
			res[i + l1.length] = l2[i];
		}
		return res;
	}
	
	// random n x n matrix with 2 trues per row and col
	private boolean[][] generateNbyN(int n) {
		//build list of indecies
		List<Integer> shuffleList = new ArrayList<>();
		for (int j = 0; j < n; j++) {
			shuffleList.add(j);
			shuffleList.add(j);
		}
		
		// shuffle list until it is valid :)
		Collections.shuffle(shuffleList);
		while (true) {
			for (int j = 0; j < shuffleList.size() / 2; j++) {
				if (shuffleList.get(2 * j) == shuffleList.get(2 * j + 1)) {
					Collections.shuffle(shuffleList);
					continue;
				}
			}
			break;
		}
		
		// construct res from shuffleList
		boolean[][] res = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(res[i], false);
			res[i][shuffleList.get(i * 2)] = true;
			res[i][shuffleList.get(i * 2 + 1)] = true;
		}
		
		return res;
	}
	
}
