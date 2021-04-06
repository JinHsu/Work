package cn.sharit.数据结构.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>图：顶点(vertex)、边(edge)、路径、无向图、有向图、带权图</p>
 * <p>图的两种表示方式：二维数组表示（邻接矩阵）；链表表示（邻接表）</p>
 */
public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertexes = {"A", "B", "C", "D", "E"};

        // 添加顶点
        for (String vertex : vertexes) {
            graph.addVertex(vertex);
        }

        // 添加边 AB AC BC BD BE
        graph.addEdge(0, 1, 1); // AB
        graph.addEdge(0, 2, 1); // AC
        graph.addEdge(1, 2, 1); // BC
        graph.addEdge(1, 3, 1); // BD
        graph.addEdge(1, 4, 1); // BE

        graph.show();

        System.out.println("dfs");
        graph.dfs();

        System.out.println("bfs");
        graph.bfs();
    }

    private List<String> vertexes; // 存放图的顶点
    private int[][] edges; // 图的边，邻接矩阵
    private int numOfEdges; // 边的数量

    /**
     * @param n 顶点的个数
     */
    public Graph(int n) {
        this.vertexes = new ArrayList<>(n);
        this.edges = new int[n][n];
    }

    // 添加一个顶点
    public void addVertex(String vertex) {
        vertexes.add(vertex);
    }

    // 添加一条边
    public void addEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    // 节点的数量
    public int numOfVertex() {
        return vertexes.size();
    }

    // 边的数量
    public int numOfEdges() {
        return numOfEdges;
    }

    // 根据下标获取顶点的数据
    public String getValueByIndex(int index) {
        return vertexes.get(index);
    }

    // 根据下标获取边的权重
    public int getWeightOfEdge(int v1, int v2) {
        return edges[v1][v2];
    }

    // 打印图的矩阵
    public void show() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    // 获取第1个邻接顶点的下标
    public int getFirstNeighbour(int i) {
        for (int j = 0; j < vertexes.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 获取顶点(v1,v2)下一个邻接顶点的下标
    public int getNextNeighbour(int v1, int v2) {
        for (int i = v2 + 1; i < vertexes.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    // 深度优先遍历（DFS）
    public void dfs() {
        boolean[] visited = new boolean[vertexes.size()]; // 记录顶点是否被访问过
        for (int i = 0; i < vertexes.size(); i++) {
            if (!visited[i]) {
                dfs(visited, i);
            }
        }
        System.out.println();
    }

    private void dfs(boolean[] visited, int i) {
        System.out.print(getValueByIndex(i) + "\t");
        visited[i] = true;

        int w = getFirstNeighbour(i);

        while (w != -1) {
            if (!visited[w]) {
                dfs(visited, w);
            }
            w = getNextNeighbour(i, w);
        }

    }

    // 广度优先遍历（BFS）
    public void bfs() {
        boolean[] visited = new boolean[vertexes.size()]; // 记录顶点是否被访问过
        for (int i = 0; i < vertexes.size(); i++) {
            if (!visited[i]) {
                bfs(visited, i);
            }
        }
        System.out.println();
    }

    private void bfs(boolean[] visited, int i) {
        int h; // 队列头顶点下标
        int w; // 邻接节点下标

        LinkedList<Integer> queue = new LinkedList<>();

        System.out.print(getValueByIndex(i) + "\t");
        visited[i] = true;

        queue.addLast(i);

        while (!queue.isEmpty()) {
            h = queue.removeFirst();
            w = getFirstNeighbour(h);
            while (w != -1) {
                if (!visited[w]) {
                    System.out.print(getValueByIndex(w) + "\t");
                    visited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbour(h, w);
            }
        }

    }
}
