package IntegerNodeGraph;

import IntegerNodeGraph.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    Graph graph;
    public BFS(Graph graph){
        this.graph = graph;
    }

    public void printBFS(){
        System.out.println("BFS Traversal : ");
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.vertexCount];
        visited[0] = true;
        queue.add(0);
        while (!queue.isEmpty()){
            int s = queue.poll();
            System.out.print(s+" ");
            for(Integer node:graph.adjacencyList.get(s)){
                if(!visited[node]){
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }
}
