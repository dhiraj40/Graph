package CodingHardGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Solution
{
    List<List<Integer>> adjacency = new ArrayList<>();
    boolean[] visited;
    long answer = 0;
    int getAnswer(int curr,int depth){
        int no_of_people = 1;
        visited[curr] = true;

        for(int i:adjacency.get(curr)){
            if(!visited[i]){
                no_of_people += getAnswer(i,depth+1);
            }
        }

        int no_car = no_of_people/5;
        answer += (1+((long) no_car *depth));
        no_of_people = no_of_people%5;
        if(no_of_people<0) no_of_people = no_of_people + 5;
        System.out.println(curr+" people = "+no_of_people+" ans = "+answer);
        return no_of_people;
    }

    /*
    * m = sum/n
    * m = (sumx+sumF)/n
    * sumF = (m*n) - sumX
    *
    * */
    public long solution(int[] A,int[] B){
        int n = A.length;
        visited = new boolean[n+1];
        for(int i=0;i<=n;i++) adjacency.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            adjacency.get(A[i]).add(B[i]);
            adjacency.get(B[i]).add(A[i]);
        }
        System.out.println(adjacency);

        getAnswer(0,0);
        return answer-1;
    }
}

public class MinimumFuel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];
        for(int i=0;i<n;i++){
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        System.out.println(solution.solution(A,B));
    }
}
