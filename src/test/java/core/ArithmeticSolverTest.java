package core;

import junit.framework.TestCase;

public class ArithmeticSolverTest extends TestCase{
	public void testAdd() {
		ArithmeticSolver solver = new ArithmeticSolver();
		assertEquals(4, solver.add(2,2));
	}
	
	public void testSubtract() {
		ArithmeticSolver solver = new ArithmeticSolver();
		assertEquals(2, solver.substract(4,2));
	}
	
	public void testMultiply() {
		ArithmeticSolver solver = new ArithmeticSolver();
		assertEquals(16, solver.mutiply(8,2));
	}


}