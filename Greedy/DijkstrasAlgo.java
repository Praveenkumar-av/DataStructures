// Dijkstra's algorithm using normal Queue

import java.util.*;

public class DijkstrasAlgo {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{S, 0});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int dest = node[0];
            int weight = node[1];

            for (var neighbor : adj.get(dest)) {
                int newDest = neighbor.get(0);
                int newWeight = neighbor.get(1);

                int totalWeight = weight + newWeight;
                if (totalWeight < dist[newDest]) {
                    dist[newDest] = totalWeight;
                    q.offer(new int[]{newDest, totalWeight});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 3, E = 3, S = 2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {
            {
                add(1);
                add(1);
            }
        };
        ArrayList<Integer> node2 = new ArrayList<Integer>() {
            {
                add(2);
                add(6);
            }
        };
        ArrayList<Integer> node3 = new ArrayList<Integer>() {
            {
                add(2);
                add(3);
            }
        };
        ArrayList<Integer> node4 = new ArrayList<Integer>() {
            {
                add(0);
                add(1);
            }
        };
        ArrayList<Integer> node5 = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
            }
        };
        ArrayList<Integer> node6 = new ArrayList<Integer>() {
            {
                add(0);
                add(6);
            }
        };

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>() {
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };
        //add final values of adj here.
        int[] res = dijkstra(V, adj, S);

        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}