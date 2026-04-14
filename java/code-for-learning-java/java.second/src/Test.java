import java.util.Scanner;

public class Test {
    public static void hanoi(int n, char a, char b, char c) {
        if (n > 0) {
            hanoi(n - 1, a, c, b);
            System.out.println(a + "->" + b);
            hanoi(n - 1, c, b, a);
        }
    }
    public static void main(String[] args) {
        int n=3;
        hanoi(n,'A','B','C');
    }
/*    public static int max(int a,int b){
        return a>b?a:b;
    }
    public static int max(int a,int b,int c){
        return max(a,b)>c?max(a,b):c;
    }
    public static void main(String[] args) {
        int a=12;
        int b=13;
        int c=19;
        System.out.println(max(a,b));
        System.out.println(max(a,b,c));
    }*/
 /*   public static double sum(double a,double b) {
        return a + b;
    }
    public static int sum(int a,int b,int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        int a=5;
        int b=10;
        int c=2;
        double m=1.1;
        double n=10.5;
        System.out.println(sum(a,b,c));
        System.out.println(sum(m,n));
    }*/
 /*   public static int fib(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println(fib(n));
    }*/
}
/*     public static int factoral(int n) {
        if(n==0) {
            return 1;
        }
        else {
            return factoral(n - 1)*n;
        }
    }
    public static void main(String[] args) {
        int sum=0;
        int n=5;
        while(n!=0){
            sum+=factoral(n);
            n--;
        }
        System.out.println(sum);
    }*/

   /* public static int factoral(int n) {
        if(n==0) {
            return 1;
        }
        else {
            return factoral(n - 1)*n;
        }
    }
    public static void main(String[] args) {
        int sum=factoral(5);
        System.out.println(sum);
    }*/


/*    public static int max(int a,int b){
        return a>b?a:b;
    }
    public static int max2(int a,int b,int c){
        return max(a,b)>c?max(a,b):c;
    }
    public static void main(String[] args) {
        int a;
        int b;
        Scanner scanner=new Scanner(System.in);
        a=scanner.nextInt();
        b=scanner.nextInt();
        System.out.println("max is "+max(a,b));
        int c;
        c=scanner.nextInt();
        System.out.println("the max is "+max2(a,b,c));
    }*/

