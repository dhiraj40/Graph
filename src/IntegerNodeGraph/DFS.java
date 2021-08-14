package IntegerNodeGraph;

import IntegerNodeGraph.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DFS {
    Graph graph;
    public DFS(Graph graph){
        this.graph = graph;
    }

    public  void printDFS(){
        System.out.println("DFS Traversal");
        boolean[] visited = new boolean[graph.vertexCount];
        printDFSNode(0,visited);
    }

    private void printDFSNode(int u, boolean visited[]){
        visited[u] = true;
        System.out.print(u+" ");
        for(Integer v:graph.adjacencyList.get(u)){
            if(!visited[v]){
                printDFSNode(v,visited);
            }
        }
    }

}
