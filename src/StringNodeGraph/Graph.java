package StringNodeGraph;
import java.util.*;

public class Graph {
    int vertexCount;
    String[] vertices;
    Map<String,ArrayList<String>> adjacencyList;
    public Graph(int V){
        this.vertexCount = V;
        this.adjacencyList = new HashMap<>();
    }

    public void addUndirectedEdge(String u,String v){
        if(!adjacencyList.containsKey(u)){
            adjacencyList.put(u,new ArrayList<>());
        }
        adjacencyList.get(u).add(v);
        if(!adjacencyList.containsKey(v)){
            adjacencyList.put(v,new ArrayList<>());
        }
        adjacencyList.get(v).add(u);

        if(vertexCount < adjacencyList.size()){
            this.vertexCount = adjacencyList.size();
        }
    }

    public void addDirectedEdge(String source,String destination){
        if(!adjacencyList.containsKey(source)){
            adjacencyList.put(source,new ArrayList<>());
        }
        adjacencyList.get(source).add(destination);
        if(!adjacencyList.containsKey(destination)){
            adjacencyList.put(destination, new ArrayList<>());
        }

        if(vertexCount < adjacencyList.size()){
            this.vertexCount = adjacencyList.size();
        }
    }

    public void printAdjacency(){
        for (String vertex:adjacencyList.keySet()){
            System.out.print(vertex);
            for (String adjacentVertex:adjacencyList.get(vertex)){
                System.out.print(" -> "+adjacentVertex);
            }
            System.out.println();
        }
    }

}
