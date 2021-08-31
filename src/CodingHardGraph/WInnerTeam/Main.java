package CodingHardGraph.WInnerTeam;

import java.util.*;
public class Main
{
    static int winTeamPower(List<Integer> kidsStr, List<List<Integer>> teamPair) {
        for(List<Integer> pair:teamPair){
            int t1 = pair.get(0);
            int t2 = pair.get(1);
            //System.out.print(pair+" "+kidsStr.get(t1-1)+" + "+kidsStr.get(t2-1)+" = ");

            int sum = kidsStr.get(t1-1) + kidsStr.get(t2-1);
            kidsStr.set(t1-1,sum);
            kidsStr.set(t2-1,sum);
            //System.out.println(sum);
        }

        int max_sum = 0;
        for(int i:kidsStr){
            if(i>max_sum) max_sum = i;
        }

        return max_sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> kidsStr = new ArrayList<>();

        int n = scan.nextInt();

        for(int i=0;i<n;i++){
            int temp = scan.nextInt();
            kidsStr.add(temp);
        }
        int teamPair_row = scan.nextInt();
        int teamPair_col = scan.nextInt();

        List<List<Integer>> teamPair = new ArrayList<>();
        for(int idx=0;idx<teamPair_row;idx++){

            List<Integer> temp_list = new ArrayList<>();

            for(int jdx=0;jdx < teamPair_col;jdx++){

                int temp = scan.nextInt();
                temp_list.add(temp);
            }
            teamPair.add(temp_list);
        }

        int result = winTeamPower(kidsStr,teamPair);
        System.out.println(result);
    }


}
