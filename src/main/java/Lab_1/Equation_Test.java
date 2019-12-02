package Lab_1;

import org.junit.Assert;
import org.junit.Test;

public class Equation_Test {
    @Test
    public void shouldReturnSameResult(){
        Quadratic_Equation equation = new Quadratic_Equation();
        String result = equation.solution(1, 2, 1);
        Assert.assertEquals("x1, x2 = -1.0", result);
    }

    @Test
    public void shouldReturnLinearEquation() {
        Quadratic_Equation equation = new Quadratic_Equation();
        String result = equation.solution(0, 1, -4);
        Assert.assertEquals("You have the linear equation: x = 4.0", result);
    }

    @Test
    public void shouldReturnError() {
        Quadratic_Equation equation = new Quadratic_Equation();
        String result = equation.solution(2, 3, 4);
        Assert.assertEquals("Error. Discriminant < 0", result);
    }

    @Test
    public void shouldReturnDoubleResultDifferentRules (){
        Quadratic_Equation equation = new Quadratic_Equation();
        String result = equation.solution(1, 5, 6);
        Assert.assertEquals("x1 = -2.0 x2 = -3.0", result);
    }
}
