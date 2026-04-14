import sun.java2d.pipe.AAShapePipe;

import java.util.Arrays;
import java.util.Scanner;

class Rectangle{
    public void funNoStatic(){
        System.out.println("这是非静态方法");
    }
    public static void funStatic(){
        Rectangle rectangle=new Rectangle();
        rectangle.funNoStatic();//此时可以调用非静态方法，
                                //因为非静态方法随着对象的创建而创建了
        System.out.println("这是静态方法");
    }

}
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1=new Rectangle();
    }
   /* public static void main1(String[] args) {
     Rectangle rectangle=new Rectangle();
     rectangle.l=2;
     rectangle.w=3;
     rectangle.area=rectangle.Area(2,3);
        System.out.println("面积是： "+rectangle.area);
    }*/
}




/*    public static void main(String[] args) {
     int [][]array=new int[2][];
     array[0]=new int[]{1,2,3};
     array[1]=new int[]{2,3,4,5,6,7};
        System.out.println(Arrays.deepToString(array));*/

