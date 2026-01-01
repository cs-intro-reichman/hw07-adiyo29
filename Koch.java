/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		/* curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		double stage = 0;
		if (n < 0) return;
		double factor = Math.sqrt(3) / 6.0;
        double xPeak = (x1 + x2) / 2.0 + factor * (y1 - y2);
        double yPeak = (y1 + y2) / 2.0 + factor * (x2 - x1);
		double x_third = x1 + (x2 - x1) / 3.0;
		double y_third = y1 + (y2 - y1) / 3.0;

		double x_two_thirds = x1 + 2.0 * (x2 - x1) / 3.0;
		double y_two_thirds = y1 + 2.0 * (y2 - y1) / 3.0;		

		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(x1, y1, x2, y2);		
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.pause(10);
		StdDraw.line(x_third, y_third, x_two_thirds, y_two_thirds); // white line
		StdDraw.pause(10);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(x_third, y_third, xPeak, yPeak);
		StdDraw.pause(10);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.line(xPeak, yPeak,x_two_thirds, y_two_thirds);
		

		curve(n - 1, x1, y1, x_third, y_third); // left most curve
		curve(n - 1, x_two_thirds, y_two_thirds, x2, y2); // right line of the curve
		curve(n - 1, x_third, y_third, xPeak, yPeak); // left line of the triangle
		curve(n - 1, xPeak, yPeak, x_two_thirds, y_two_thirds); // right line of the triangle
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		double x1 = 0.200, y1 = 0.650; 
        double x2 = 0.800, y2 = 0.650; 
        double x3 = 0.500, y3 = 0.130;

		curve(n, x1, y1, x2, y2); 
        curve(n, x2, y2, x3, y3); 
        curve(n, x3, y3, x1, y1); 
    }

	}



