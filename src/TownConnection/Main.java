package TownConnection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Connection> connections = new ArrayList<>();
        int n = 5;
        int[] costs = {2,3,4,5,6};
        String[][] cons = {{"A","B"}, {"B","C"}, {"C","D"},{"D","E"},{"B","E"}};
        for(int i=0;i<n;i++){
            connections.add(new Connection(cons[i][0],cons[i][1],costs[i]));
        }
        Solution solution = new Solution();
        //List<Connection> answer = solution.minimumCostLink(connections);
        System.out.println(solution.minimumCostLink(connections));
    }
}
