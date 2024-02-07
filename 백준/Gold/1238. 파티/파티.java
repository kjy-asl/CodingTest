import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int e, cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int MAX = Integer.MIN_VALUE;
    static int[] dist;
    static int N, M, X;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();

        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(), e = sc.nextInt(), cost = sc.nextInt();
            list[a].add(new Node(e, cost));
        }

        for (int i = 1; i < N + 1; i++) {
            int distance = 0;
            visited = new boolean[N + 1];
            dist = new int[N + 1];
            for ( int j = 0 ; j < N+1 ; j++ ) {
                dist[j] = Integer.MAX_VALUE;
            }
            distance += dfs(i, X);
            visited = new boolean[N + 1];
            dist = new int[N + 1];
            for ( int j = 0 ; j < N+1 ; j++ ) {
                dist[j] = Integer.MAX_VALUE;
            }
            distance += dfs(X, i);
            if (MAX < distance) MAX = distance;
        }
        System.out.println(MAX);
    }

    public static int dfs(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (int i = 0; i < list[now.e].size(); i++) {
                Node next = list[now.e].get(i);
                if (dist[next.e] > now.cost + next.cost) {
                    dist[next.e] = now.cost + next.cost;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }
        return dist[end];
    }

}
