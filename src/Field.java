import java.util.Random;
import java.util.Scanner;

public class Field {



    int[][] num;
    boolean[][] right;
    boolean[][] user;
    Integer[] hSum;
    Integer[] vSum;
    int[] uvSum;
    int w;
    int h;

    public Field(int w, int h) {
        this.w = w;
        this.h = h;
        num = new int[w][h];
        right = new boolean[w][h];
        user = new boolean[w][h];
        vSum = new Integer[h];
        hSum = new Integer[w];
        Random rand = new Random();
        for(int i=0; i<w; i++) {
            for(int j=0; j<h; j++) {
                num[i][j] = rand.nextInt((10-1)+1)+1;
                right[i][j] = rand.nextBoolean();
                user[i][j] = true;
            }
        }
        for (int j=0; j<num[0].length;j++) {
            int sum = 0;
            for (int i = 0; i < num.length; i++)
                if (right[i][j]) sum += num[i][j];
            vSum[j]=sum;
        }
        for (int k=0; k<num.length; k++) {
            int sum = 0;
            for (int j = 0; j < num[k].length; j++)
                if (right[k][j]) sum += num[k][j];
            hSum[k]=sum;
        }
    }

    public void turn(int row, int col) {
        user[row][col] ^= true;
    }

    public boolean isWin() {
        int i=0;
        while (i<num.length) {
            int j = 0;
            while (j < num[0].length) {
                if (user[i][j] != right[i][j])
                    return false;
                j++;
            }
            i++;
        }
        return true;
    }
    public Integer getVSum(int j){
        return vSum[j];
    }
    public Integer getHSum(){
        Integer sum=0;

        return sum;
    }
    public void show() {
        System.out.print("       ");
        for (int j=0; j<num[0].length;j++) {
            int sum = 0;
            for (int i = 0; i < num.length; i++)
                if (right[i][j]) sum += num[i][j];
            System.out.print(String.format("%3d", sum));
        }
        System.out.println();

        System.out.print("       ");
        for (int j=0; j<num[0].length;j++) {
            int sum = 0;
            for (int i = 0; i < num.length; i++)
                if (user[i][j]) sum += num[i][j];
            System.out.print(String.format("%3d", sum));
        }
        System.out.println();

        System.out.print("----------------------  ");
        for (int q=0; q<3*num[0].length; q++) System.out.print("-");
        System.out.println();

        for (int k=0; k<num.length; k++) {
            int sum = 0;
            for (int j = 0; j < num[k].length; j++)
                if (right[k][j]) sum += num[k][j];
            System.out.print(String.format("%3d", sum));

           sum = 0;
            for (int j = 0; j < num[k].length; j++)
                if (user[k][j]) sum += num[k][j];
            System.out.print(String.format("%3d", sum) + "|");

            for (int i = 0; i < num[k].length; i++) {
                System.out.print(String.format("%3d", num[k][i]));
            }

            System.out.print("  ");
            for (int i = 0; i < num[k].length; i++) {
                System.out.print(String.format("%3d", user[k][i]?1:0));
            }

            System.out.println();
        }

    }

    public static void main(String[] args) {
        Field f = new Field(2,2);
        while (!f.isWin()){
            f.show();
            Scanner sc = new Scanner(System.in);
            int row, col;
            row = sc.nextInt();
            col = sc.nextInt();
            f.turn(row, col);
        }
        System.out.println("You win");
    }
    public int getWidth(){
        return num[0].length;
    }
    public int getHeight(){
        return num.length;
    }
    public int getNum(int x, int y) {
        return this.num[x-1][y-1];
    }
}
