import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
// Edge Class to store graph edge
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}

//Class Represent the graph objects
class Graphs {
    // list of list represnet adjList
    List<List<Integer>> adjList = null;

    //Graph constructor
    Graphs(List<Edge> edges , int nodes){
        adjList = new ArrayList<>();

        for(int i=0; i<nodes; i++){
            adjList.add(new ArrayList<>());
        }

        //add edge in undirected graph
        for (Edge edge : edges) {
            int src = edge.source;
            int des = edge.dest;
            
            adjList.get(src).add(des);
            adjList.get(des).add(src);
        }
    }
}

public class GraphsAlgorithm {
    // Perform BFS on the graph starting from vertex `v`
    public static void BFS(Graphs graph, int v, boolean[] discovered)
    {
        // create a queue for doing BFS
        Queue<Integer> q = new ArrayDeque<>();
 
        // mark the source vertex as discovered
        discovered[v] = true;
 
        // enqueue source vertex
        q.add(v);
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node and print it
            v = q.poll();
            System.out.print(v + " ");
 
            // do for every edge (v, u)
            for (int u: graph.adjList.get(v))
            {
                if (!discovered[u])
                {
                    // mark it as discovered and enqueue it
                    discovered[u] = true;
                    q.add(u);
                }
            }
        }
    }

     // Perform iterative DFS on graph starting from vertex `v`
     public static void iterativeDFS(Graphs graph, int v, boolean[] discovered)
     {
         // create a stack used to do iterative DFS
         Stack<Integer> stack = new Stack<>();
  
         // push the source node into the stack
         stack.push(v);
  
         // loop till stack is empty
         while (!stack.empty())
         {
             // Pop a vertex from the stack
             v = stack.pop();
  
             // if the vertex is already discovered yet, ignore it
             if (discovered[v]) {
                 continue;
             }
  
             // we will reach here if the popped vertex `v` is not discovered yet;
             // print `v` and process its undiscovered adjacent nodes into the stack
             discovered[v] = true;
             System.out.print(v + " ");
  
             // do for every edge (v, u)
             List<Integer> adjList = graph.adjList.get(v);
             for (int i = adjList.size() - 1; i >= 0; i--)
             {
                 int u = adjList.get(i);
                 if (!discovered[u]) {
                     stack.push(u);
                 }
             }
         }
     }
    public static void main(String[] args) {
         // List of graph edges as per the above diagram
    //      List<Edge> edges = Arrays.asList(
    //         new Edge(1, 2), new Edge(1, 3), new Edge(1, 4), new Edge(2, 5),
    //         new Edge(2, 6), new Edge(5, 9), new Edge(5, 10), new Edge(4, 7),
    //         new Edge(4, 8), new Edge(7, 11), new Edge(7, 12)
    //         // vertex 0, 13, and 14 are single nodes
    // );

       // List of graph edges as per the above diagram
       List<Edge> edges = Arrays.asList(
        // Notice that node 0 is unconnected
        new Edge(1, 2), new Edge(1, 7), new Edge(1, 8), new Edge(2, 3),
        new Edge(2, 6), new Edge(3, 4), new Edge(3, 5), new Edge(8, 9),
        new Edge(8, 12), new Edge(9, 10), new Edge(9, 11)
        // (6, 9) introduces a cycle
);

    // total number of nodes in the graph (labelled from 0 to 12)
    int n = 13;

    // build a graph from the given edges
    Graphs graph = new Graphs(edges, n);
    
    //to keep tracked of wheather a vertex is discovered or not 
    boolean[] discovered = new boolean[n];

    // Perform BFS traversal from all undiscovered nodes to
    // cover all connected components of a graph
    // for (int i = 0; i < n; i++) {
        
    //     if(discovered[i] == false){
    //         BFS(graph, i, discovered);
    //     }

    // }

     // Do iterative DFS traversal from all undiscovered nodes to
        // cover all connected components of a graph
        for (int i = 0; i < n; i++)
        {
            if (!discovered[i]) {
                iterativeDFS(graph, i, discovered);
            }
        }

    

    }
}