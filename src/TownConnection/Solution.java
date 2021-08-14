package TownConnection;

import java.util.*;

public class Solution {

    HashMap<String,ArrayList<Connection>> createAdjacencyList(List<Connection> connections){
        HashMap<String, ArrayList<Connection>> adjacencyList = new HashMap<>();
        for(Connection con:connections){
            if(!adjacencyList.containsKey(con.firstTown)) adjacencyList.put(con.firstTown,new ArrayList<>());
            if(!adjacencyList.containsKey(con.secondTown)) adjacencyList.put(con.secondTown,new ArrayList<>());
            adjacencyList.get(con.firstTown).add(con);
            adjacencyList.get(con.secondTown).add(new Connection(con.secondTown,con.firstTown,con.cost));
        }

        for(String con:adjacencyList.keySet()){
            adjacencyList.get(con).sort((o1, o2) -> o2.cost - o1.cost);
        }

        return adjacencyList;
    }

    public List<Connection> minimumCostLink(List<Connection> connections){
        List<Connection> answer = new ArrayList<>();
        HashMap<String, ArrayList<Connection>> adjacencyList = createAdjacencyList(connections);
        HashSet<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        String curr = connections.get(0).firstTown;
        stack.push(curr);
        while (stack.empty()){
            curr = stack.pop();
            if(visited.contains(curr)) continue;
            visited.add(curr);
            Connection nextEdge=null;
            for(Connection con:adjacencyList.get(curr)){
                if(!visited.contains(con.secondTown)){
                    stack.push(con.secondTown);
                    nextEdge = con;
                }
            }
            if(nextEdge!=null) answer.add(nextEdge);
        }
        return answer;
    }
}
