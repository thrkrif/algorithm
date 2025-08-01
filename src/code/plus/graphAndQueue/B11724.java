package code.plus.graphAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11724 {
    /*
     * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
     * -> BFS로 탐색하면서 방문하지 않은 정점에서 시작할 때마다 카운트 증가
     */
    /*
     * 시간 제한 3초, 메모리 512MB, 1 <= N <= 1000, M = N×(N-1)/2) -> 크게 잡아 10^6 이라고 하자.
     * 10^6이면 O(NlogN) 까지 가능함.
     */

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // N, M을 받을거임
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 그래프 초기화 O(N)
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++){ // N이 1부터 시작한다.
            graph[i] = new ArrayList<>();
        }

        // u, v가 주어지는데 u != v, 같은 간선은 한 번만 주어진다 -> 중복으로 입력 없음.
        // 간선 입력 O(M)
        for (int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());

            // 무방향 그래프이므로 양방향 연결
            graph[u].add(v);
            graph[v].add(u);
        }

        // 연결 요소 개수 세기
        int count = 0;
        for (int i = 1; i <= N; i++){
            if (!visited[i]){
                bfs(i); // BFS로 연결된 모든 정점 방문
                count++;
            }
        }

        System.out.println(count);
    }
    // bfs 알고리즘은 큐만 사용하면 되고, 재귀 함수를 이용할 필요가 없다.(DFS에서는 재귀 함수 이용해야함.)
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int current = queue.poll();

            // 현재 노드와 연결된 모든 노드 확인
            for (int next : graph[current]){
                if (!visited[next]){ // 방문 처리
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
