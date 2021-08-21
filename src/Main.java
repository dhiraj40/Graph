import java.util.*;
class  Main
{
    static int[] ans;
    public static void main(String[] args) {

        int[] A = {3,2,4,3};
        int f = 2;
        int m = 3;
        ans = new int[f];
        int n = A.length + f;
        int sumT = m*n;
        int sumX = 0;
        for(int i:A) sumX += i;

        int sumF = sumT - sumX;

        //boolean isSum =

    }

}