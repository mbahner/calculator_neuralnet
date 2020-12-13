package calculator;

import java.util.Arrays;

public class DataPoint {
	
	private final int bitLength;
	
	private final boolean[] num1;
	private final boolean[] num2;
	private final boolean[] sum;
	
	/**
	 * Make a random data point
	 * @param bitCount
	 */
	public DataPoint(int bitCount) {
		assert bitCount >= 2;
		
		this.bitLength = bitCount;
		
		int n1 = (int)(Math.pow(2, bitCount) * Math.random());
		int n2 = (int)((Math.pow(2, bitCount) - n1) * Math.random());
		int s = n1 + n2;
		
		this.num1 = this.toBinary(n1);
		this.num2 = this.toBinary(n2);
		this.sum = this.toBinary(s);
	}
	
	/**
	 * Construct specific dataPoint, mostly used for testing
	 * @param n1
	 * @param n2 these must sum to < 2 ^ bitLength
	 * @param bitLength
	 */
	public DataPoint(int n1, int n2, int bitLength) {
		assert n1 + n2 < Math.pow(2, bitLength);
		assert n1 >= 0;
		assert n2 >= 0;
		
		this.bitLength = bitLength;
		this.num1 = this.toBinary(n1);
		this.num2 = this.toBinary(n2);
		this.sum = this.toBinary(n1 + n2);
	}
	
	/**
	 * get the hamming distance between the predicted and the actual
	 * @param guess
	 * @return
	 */
	public int getHammingDistance(boolean[] guess) {
		assert guess.length == this.bitLength;
		
		int hammingDistance = 0;
		for (int i = 0; i < this.bitLength; i++) {
			if (guess[i] != this.sum[i]) {
				hammingDistance ++;
			}
		}
		return hammingDistance;
	}
	
	
	
	///////////////////////////////////////
	// Begin private and overide methods //
	///////////////////////////////////////
	
	
	private boolean[] toBinary(int num) {
		// convert num to bit string
		final String bitString = Integer.toBinaryString(num);
		
		// set res to all false
		final boolean[] res = new boolean[this.bitLength];
		Arrays.fill(res, false);
		
		// add booleans in res
		for (int arrayIndex = 0; arrayIndex < this.bitLength; arrayIndex++) {
			int stringIndex = bitString.length() - this.bitLength + arrayIndex;
			if (stringIndex >= 0) {
				res[arrayIndex] = bitString.charAt(stringIndex) == '1';
			}
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean equals(Object that) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		return "" + bitsToString(num1) + "\n" + bitsToString(num2) + "\n" + bitsToString(sum);
	}
	
	private String bitsToString(boolean[] bits) {
		String res = "[";
		for (boolean bit: bits) {
			res += bit + ", ";
		}
		res += "]";
		return res;
	}
}
