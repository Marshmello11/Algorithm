import java.util.*;
import java.io.*;
public class Floyd {

    final static int INF = 99999999, V = 4;

    void floydWarshell(int graph[][]){
        int i, j, k;
        for(k = 0; k < V; k++){
            for(i = 0; i < V; i++){
                for(j = 0; j < V; j++){
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }


    public static void main(String[] args){

        int i, j;
        int graph[][] = {{0, 2, 6, 4},
                    {INF, 0, 3, INF},
                    {7, INF, 0, 1},
                    {5, INF, 12, 0}};

        Floyd floyd = new Floyd();

        floyd.floydWarshell(graph);

        for(i = 0; i < V; i++){
            for(j = 0; j < V; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
