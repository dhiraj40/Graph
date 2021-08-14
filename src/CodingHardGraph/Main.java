package CodingHardGraph;

import java.util.*;

/*
Sample Input 1
6
1 2
3 1
1 4
4 5
4 6
-1 2 2 -2 5 8
2
2 5
2 3
1 5
5 3
4 1
6 5
4 4

Sample Input 2
10
10 2
2 5
3 5
5 6
5 7
7 1
6 4
7 9
4 8
1 -2 3 -4 5 -6 7 -8 9 -10
2
10 9
8 6
*/
class  Main
{
    static  List<List<Integer>> adjacency = new ArrayList<>();
    static  int[] happyness;

    static boolean getPath(int u,int v,List<Integer> path,Set<Integer> visited){
        visited.add(u);
        if(u==v){
            return true;
        }
        boolean ispath = false;
        for(Integer x:adjacency.get(u)){
            if(!visited.contains(x)){
                path.add(x);
                boolean t_ispath = getPath(x,v,path,visited);
                if(!t_ispath){
                    path.remove(x);
                }
                ispath = ispath||t_ispath;
            }
        }
        System.out.println(u+"->"+v+" : "+ispath);
        return ispath;
    }


    public static int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int n = nums.length;
        int tsum = 0;

        for(int i=0;i<n;i++){
            tsum += nums[i];
            tsum = Math.max(nums[i],tsum);
            if(tsum > maxsum){
                maxsum= tsum;
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        for(int i=0;i<=n;i++) adjacency.add(new ArrayList<>());

        for(int i=0;i<n-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjacency.get(a).add(b);
            adjacency.get(b).add(a);
        }
        System.out.println(adjacency);
        happyness = new int[n];
        for(int i=0;i<n;i++) happyness[i] = sc.nextInt();

        int q = sc.nextInt();
        int[] answer = new int[q];
        for(int i=0;i<q;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            List<Integer> path = new ArrayList<>();

            path.add(u);

            getPath(u,v,path,new HashSet<>());
            System.out.println(path);

            int[] array = new int[path.size()];

            int j=0;
            for(int p:path) array[j++] = happyness[p-1];

            answer[i] = maxSubArray(array);
        }

        for(int i:answer) System.out.println(i);

    }
}
