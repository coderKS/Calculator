package src;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CalculatorTest {
	@Test
	public void when_calculating_empty_string_should_return_0(){
		Calculator calculator = new Calculator();
		Double result = calculator.calculate("");
		assertEquals(new Double(0), result);
	}

	@Test
	public void when_calculating_one_should_return_1(){
		
	}
}
