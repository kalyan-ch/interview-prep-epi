package org.wb.epi.Chap24HonourClass;

public class TwentyFour01GCD {
    public static void main(String[] args) {
        System.out.println(computeGCD(25, 635));
    }

    // non-negative integers
    private static int computeGCD(int x, int y){

        boolean xEven = (x&1) == 0;
        boolean yEven = (y&1) == 0;

        if(x > y)
            return computeGCD(y, x);
        else if(x == 0)
            return y;
        else if( xEven && yEven )
            return (computeGCD(x >>> 1, y >>> 1) << 1);
        else if( xEven && !yEven)
            return computeGCD(x >>> 1, y );
        else if( !xEven && yEven)
            return computeGCD(x, y >>> 1);
        else
            return computeGCD(x, y-x);
    }
}
