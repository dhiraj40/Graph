package IntegerNodeGraph;

import java.util.*;

public class Graph {
    int vertexCount;
    ArrayList<Integer> vertices;
    ArrayList<ArrayList<Integer>> adjacencyList;

    public Graph(int V){
        this.vertexCount = V;
        this.adjacencyList = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < vertexCount; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    private boolean getPath(int u,int v,List<Integer> path,Set<Integer> visited){
        visited.add(u);
        if(u==v){
            return true;
        }
        boolean ispath = false;
        for(Integer x:adjacencyList.get(u)){
            if(!visited.contains(x)){
                path.add(x);
                ispath = getPath(x,v,path,visited);
                if(!ispath){
                    path.remove(x);
                }
            }
        }
        return ispath;
    }

    public List<Integer> getPath(int u,int v){
        List<Integer> path = new ArrayList<>();
        path.add(u);
        boolean ispath = getPath(u,v,path,new HashSet<>());
        if(!ispath) return  null;
        return path;
    }

    public void addEdge(int u,int v){
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    public void addDirectedEdge(int source,int destination){
        adjacencyList.get(source).add(destination);
    }

    public void showAdjacency(){
        for (ArrayList<Integer> arrayList:adjacencyList) {
            System.out.print("head");
            for (Integer j:arrayList){
                System.out.print(" -> "+j);
            }
            System.out.println();
        }
    }

}


