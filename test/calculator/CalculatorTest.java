package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	// Testing strategy
    // cover every subdomain of every partition of every method at least once.
    //
	// 
	
	@Test
    public void testAssertionsEnabled() {
        assertThrows(AssertionError.class, () -> { assert false; },
                "make sure assertions are enabled with VM argument '-ea'");
    }
	
	@Test
	public void testAdd() {
		Calculator calc = new Calculator(4, 3);
		boolean[] num1 = {true, false, true, false};
		boolean[] num2 = {false, true, true, true}; 
		System.out.println(calc);
		
		boolean[] added = calc.add(num1, num2);
		for (boolean a: added) {
			System.out.println(a);
		}
		System.out.println(added.length);
	}
	
	@Test
	public void testReduceSquare() {
		boolean[] input = {false, false, false, false, 
							false, false, true, false, 
							false, false, false, false, 
							false, false, false, false};
		boolean[] expected = {false, true, false, false};
		assertArrayEquals(expected, Calculator.reduceResult(4, input));
	}
	
	@Test
	public void testReduceTallRectangle() {
		boolean[] input = {false, false, 
							false, false, 
							false, false, 
							false, true};
		boolean[] expected = {false, false, false, true};
		assertArrayEquals(expected, Calculator.reduceResult(4, input));
	}
	
	@Test
	public void testReduceWideRectangle() {
		boolean[] input = {false, false, false, false, 
							false, false, true, false};
		boolean[] expected = {false, true};
		assertArrayEquals(expected, Calculator.reduceResult(2, input));
	}
}
