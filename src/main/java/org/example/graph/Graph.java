package org.example.graph;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
  private int V;

  private final LinkedList<Integer>[] adjList;

  public Graph(int v) {
    this.V = v;
    adjList = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  void addEdge(int v, int w) {
    adjList[v].add(w);
  }

  void BFS(int s) {
    boolean[] visited = new boolean[V];
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(s);

      visited[s] = true;
      while (!queue.isEmpty()) {
        int v = queue.poll();
        System.out.print(v + " ");
        adjList[v].forEach(
            edge -> {
              if (!visited[edge]) {
                visited[edge] = true;
                queue.add(edge);
              }
            });
      }

  }

  void DFS(int s) {
    boolean[] visited = new boolean[V];
    Stack<Integer> stack = new Stack<>();
    stack.push(s);
    visited[s] = true;
    while (!stack.isEmpty()) {
      int v = stack.pop();
      System.out.print(v + " ");
      adjList[v].forEach(
          edge -> {
            if (!visited[edge]) {
              visited[edge] = true;
              stack.add(edge);
            }
          });
    }
  }

  public static void main(String[] args) {
    Graph graph = new Graph(5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.BFS(0);
    System.out.println();
    graph.DFS(0);
  }
}
