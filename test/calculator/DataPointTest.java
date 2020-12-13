package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataPointTest {
	// Testing strategy
    // cover every subdomain of every partition of every method at least once.
    //
    // Test getHammingDistance:
    //     distance = 0
	//     distance = len(string)
	//     0 < distance < len(string)
	//     input array is not correct length
	//     
	// Test equals:
	//
	// 
	// Test hashCode:
	//
	// 
	//
	//
	//
	
	@Test
    public void testAssertionsEnabled() {
        assertThrows(AssertionError.class, () -> { assert false; },
                "make sure assertions are enabled with VM argument '-ea'");
    }
	
    /////////////////////////////
    // Test getHammingDistance //
    /////////////////////////////
	
	// covered cases:
	//     distance = 0
	@Test
	public void testHammingSuccess() {
		DataPoint point = new DataPoint(8, 7, 4);
		boolean[] zeroHam = {true, true, true, true};
		int result = point.getHammingDistance(zeroHam);
		assertEquals(0, result, "expected hamming distance to be 0");
	}
	
}
