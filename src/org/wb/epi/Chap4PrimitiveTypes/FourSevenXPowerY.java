package org.wb.epi.Chap4PrimitiveTypes;

public class FourSevenXPowerY {

    //find x power y
    public static void main(String[] args) {
        System.out.println(xPowY(4.0, 3));
        System.out.println(xPowY(2.0, 12));
        System.out.println(xPowY(2.0, 13));
        System.out.println(xPowY(3.0, 5));
    }

    private static double xPowY(double x, int y) {
        double result = 1.0;
        if(y < 0){
            x = 1/x;
            y = -y;
        }

        while(y > 0){
            if((y&1) != 0){
                result *= x;
            }
            x *= x;
            y >>>= 1;
        }

        return result;
    }
}
