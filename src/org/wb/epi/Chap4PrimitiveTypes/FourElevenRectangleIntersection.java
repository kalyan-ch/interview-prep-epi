package org.wb.epi.Chap4PrimitiveTypes;

public class FourElevenRectangleIntersection {


    //find if two rectangles with sides parallel to x and y axes have a non common intersection

    public static class Rectangle{
        int x, y, width, height;
        public Rectangle(int x, int y, int width, int height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public int getXPlusWidth(){
            return this.x + this.width;
        }

        public int getYPlusHeight(){
            return this.y + this.height;
        }

        @Override
        public String toString() {
            return "Rectangle: x = "+this.x+" y = "+this.y+" width = "+this.width+" height = "+this.height;
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(2, 3, 3, 4);
        Rectangle rectangle2 = new Rectangle(4, 2, 3, 4);
        Rectangle commonRect = getCommonRectangle(rectangle1, rectangle2);

        System.out.println(commonRect);
    }

    private static Rectangle getCommonRectangle(Rectangle r1, Rectangle r2) {
        if(!isIntersect(r1, r2)){
            return new Rectangle(0, 0, -1, -1);
        }
        return new Rectangle(
                Math.max(r1.x, r2.x), Math.max(r1.y, r2.y),
                Math.min(r1.getXPlusWidth(), r2.getXPlusWidth()) - Math.max(r1.x, r2.x),
                Math.min(r1.getYPlusHeight(), r2.getYPlusHeight()) - Math.max(r1.y, r2.y)
        );
    }

    private static boolean isIntersect(Rectangle r1, Rectangle r2) {
        return r1.x <= r2.x + r2.width
                && r2.x <= r1.width + r1.x
                && r1.y <= r2.y + r2.height
                && r2.y <= r1.y + r1.height;
    }

}

