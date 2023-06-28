import java.util.Scanner;

class Huixing{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("line = ");
        int line = scan.nextInt();
        scan.close();
        int[][] huixing = new int[line][line];  //选择用二维数组接收
        int i = 0;  //初始化 行 的位置
        int j = 0;  //初始化 列 的位置
        int times = 1;  //初始化 第几圈
        if(line == 1){
            huixing[0][0] = 1;  //只有一层无法进入循环
        }else{
            for(int num = 1; num <= line*line && times <= (line/2); num++){
                //为避免在奇数时，于下for循环和此处for循环之间死循环，添加times的判断
                if(i == times-1 && j < line-times){  //向右
                    huixing[i][j] = num;
                    j++;
                }else if(i < line-times && j == line-times){  //向下
                    huixing[i][j] = num;
                    i++;
                }else if(i == line- times && j > times-1){  //向左
                    huixing[i][j] = num;
                    j--;
                }else{  //向上
                    for(; i > times-1; i--){  //因为当 i 减小时，会满足 向下 的条件，所以重建一个for循环将 向上 的数据输出完
                        huixing[i][j] = num;
                        num++;
                    }
                    num -= 1;  //因为跳出该for循环时，num++了最后一次（未被输出），所以减回来
                    i = times;  //重新初始化 行
                    j = times;  //重新初始化 列
                    times++;  //圈数++
                }

                if(line%2 == 1){  //奇数时，中心位置无法赋值
                    huixing[line/2][line/2] = line*line;
                }
            }    
        }
        for(int x = 0; x < huixing.length; x++){
            for(int y = 0; y < huixing[x].length; y++){
                System.out.print(huixing[x][y] + " ");
            }
            System.out.println();
        }
    }
}
