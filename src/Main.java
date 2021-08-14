import java.util.*;
class  Main
{
    static  List<List<Integer>> adjacency = new ArrayList<>();

    static  void getPath(int u,int v,ArrayList<Integer> path,HashSet<Integer> visited){
        visited.add(u);
        path.add(u);
        if(u==v) return;
        for(Integer x:adjacency.get(u)){
            if(!visited.contains(x)) getPath(x,v,path,visited);
        }

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

        int q = sc.nextInt();
        int[] answer = new int[q];
        for(int i=0;i<q;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            ArrayList<Integer> path = new ArrayList<>();
            getPath(u,v,path,new HashSet<>());
            System.out.println(path);
            int[] array = new int[path.size()];
            answer[i] = maxSubArray(array);
        }

        for(int i:answer) System.out.println(i);

    }
}