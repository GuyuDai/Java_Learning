import java.util.Scanner;

class YangHui{
    public static void main(String[] args){
        int[] start = new int[]{1};
        Scanner scan = new Scanner(System.in);
        System.out.print("line = ");
        int line = scan.nextInt();
        scan.close();
        if(line == 1){
            for(int x = 0; x < start.length; x ++){
                System.out.print(start[x] + " ");
            }
            System.out.println();
            //System.out.println(start);  //this can only output the address
        }else{
            for(int x = 0; x < start.length; x ++){
                System.out.print(start[x] + " ");
            }
            System.out.println();
            //System.out.println(start);  //also
            for(int i = 2; i <= line; i++){
                int[] then = new int[i];
                for(int j = 0; j < i; j++){
                    if(j == 0){
                        then[j] = start[0];
                    }else if(j == (i-1)){
                        then[j] = start[start.length - 1];
                    }else{
                        then[j] = start[j-1] + start[j];
                    }
                }
            for(int x = 0; x < then.length; x ++){
                System.out.print(then[x] + " ");
            }
            System.out.println();
            //System.out.println(then);  //also
            start = then;
            }
        }
    }
}

//the following are another mythord with the using of double-array to output a YangHui triangle:
class YangHui2{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("line = ");
        int line = scan.nextInt();
        scan.close();
        int[][] dreiecke = new int[line][];
        for(int i = 0; i < line; i++){
            dreiecke[i] = new int[i+1];
            for(int j = 0; j <= i; j ++){
                if(i == 0 || j == 0 || j == i){
                    dreiecke[i][j] = 1;
                }else{
                    dreiecke[i][j] = dreiecke[i-1][j-1] + dreiecke[i-1][j];
                }
            }
        }

        for(int i = 0; i < dreiecke.length; i++){
            for(int j = 0; j < dreiecke[i].length; j++){
                System.out.print(dreiecke[i][j] + " ");
            }
            System.out.println();
        }
    }
}
