package code.plus.dfs;
/*
 * BFS 알고리즘을 풀기 전에 공부해보자.
 */
public class Study {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1); // 간선을 만들어주는거임.
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2); /* 주어진 노드를 시작 노드로 BFS 탐색 */
    }


}
