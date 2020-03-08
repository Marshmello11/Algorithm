// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPath {

    static final int V = 8, INF = 999999999;
    int minDistance(int dist[], Boolean sptSet[]){
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }


    void dijkstra(int graph[][], int src){
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = INF;
            sptSet[i] = false;
        }

        dist[src] = 0;
        int count;
        for (count = 0; count < V; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            Set<Integer> p = new HashSet<Integer>();
            int v;
            for ( v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0  && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                    if(p.add(u)){
                        System.out.print(u+" ");
                    }
                }
        }

        System.out.print(count-1);
        System.out.println();
        System.out.print("distance: " + dist[7]);
    }

    public static void main(String[] args){
        int graph[][]={{0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 8, 0, 0},
                {0, 0, 0, 2, 0, 0, 2, 0},
                {0, 0, 0, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 3},
                {0, 0, 0, 0, 0, 2, 0, 0}
        };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}

