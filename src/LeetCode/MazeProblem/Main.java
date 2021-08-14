package LeetCode.MazeProblem;

import java.io.*;
import java.util.*;
class Solution {
    boolean[][] visited;
    int[] entrance;
    int m;
    int n;
    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;

        visited = new boolean[m][n];

        this.entrance = entrance;
        int minstep = travel(maze,entrance[0],entrance[1]);
        if(minstep==10000 || minstep==0) return -1;
        return minstep;
    }

    public int travel(char[][] maze,int i,int j){
        if(i==0 || i==maze.length-1 || j==0 || j==maze[0].length-1){
            if(entrance[0]!=i || entrance[1]!=j) return 0;
        }

        visited[i][j] = true;
        int minstep = 10000;
        if(i>0 && maze[i-1][j]=='.' && !visited[i-1][j]){
            minstep = Math.min(minstep,1+travel(maze,i-1,j));
            System.out.println(minstep+" "+"i = "+i+" j ="+j);
        }
        if(i<m-1 && maze[i+1][j]=='.' && !visited[i+1][j]){
            minstep = Math.min(minstep,1+travel(maze,i+1,j));
            System.out.println(minstep+" "+"i = "+i+" j ="+j);
        }
        if(j>0 && maze[i][j-1]=='.'&& !visited[i][j-1]){
            minstep = Math.min(minstep,1+travel(maze,i,j-1));
            System.out.println(minstep+" "+"i = "+i+" j ="+j);
        }
        if(j<n-1 && maze[i][j+1]=='.' && !visited[i][j+1]){
            minstep = Math.min(minstep,1+travel(maze,i,j+1));
            System.out.println(minstep+" "+"i = "+i+" j ="+j);
        }
        visited[i][j] = false;
        return minstep;
    }
}

public class Main {
    public static void main(String[] args)
    {
        char[][]  maze = {{'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}
        };
        int[] entrance = {1,2};
        Solution s = new Solution();
        System.out.println(s.nearestExit(maze,entrance));
    }
}