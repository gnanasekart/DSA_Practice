package Recursion;

import org.testng.annotations.Test;

public class PascalTriangle {
    /*
           1
         1 + 1
       1 + 2 + 1
     1 + 3 + 3 + 1
    1  4   6   4   1


     */
    @Test
    public void example1() {
        System.out.println(pascal(3, 2));
    }

	@Test
	public void example2() {
		printTriangle(5);
	}

    /*
    1. Identify the simplest/smallest possible input(base case)
    column (1) => 1
    row = column => 1

    2. Build test data to visualize (4,3) ==> (3,3) + (3,2)

    3. Break harder cases into simpler cases

    4. Generalize the pattern
        row,column => pascal(row-1, column)+pascal(row-1, column-1)

    5. Finally, write the code to combine the pattern.
     */
    private int pascal(int row, int column) {
        if (column > row) throw new RuntimeException("invalid input");
        if (column == 1 || column == row) return 1;
        return pascal(row - 1, column) + pascal(row - 1, column - 1);
    }

    private void printTriangle(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(pascal(i, j) + " ");
            }
            System.out.println();
        }
    }
}
