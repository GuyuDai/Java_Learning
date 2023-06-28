//import java.util.Scanner;
/*
最大公约数与最小公倍数
class Main{
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("first number = ");
        int num1 = scan.nextInt();
        System.out.print("second number = ");
        int num2 = scan.nextInt();
        int klein = (num1 < num2)? num1 : num2;
        int gross = (num1 > num2)? num1 : num2;
        for(int mal = gross; true; mal++){
            if ((mal%num1 == 0) && (mal%num2 == 0)){
                System.out.println(mal);
                break;
            }
        }
        for(int teil = klein; teil > 0; teil--){
            if((num1%teil == 0) && (num2%teil == 0)){
                System.out.println(teil);
                break;
            }
        }
    }
}
*/

/*
九九乘法表
class Main{
    public static void main(String[] args){
        int x = 1;
        int y = 1;
        while(x <= 9){
            int yy = y;
            while(yy <= x){
                int n = x*yy;
                System.out.print(x+"*"+yy+"="+n+" ");
                yy++;
            }
            System.out.println();
            x++;
        }
    }
}
*/


/*
质数
class Main{
    public static void main(String[] args){
        for(int i = 2; i <= 100; i++){
            int counter = 0;
            for(int n = 2; n<= Math.sqrt(i); n++){
                if(i%n == 0){
                    counter += 1;
                    break;
                }
            }
            if(counter == 0){
                System.out.println(i);
            }
        }
    }
}

class Main{
    public static void main(String[] args){
        here:for(int i = 2; i <= 100; i++){
            for(int n = 2; n <= Math.sqrt(i); n++){
                if(i%n == 0){
                    continue here;
                }
            }
            System.out.println(i);
        }
    }
}
*/
