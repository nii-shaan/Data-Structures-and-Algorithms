package graphs;

import java.util.ArrayList;
import java.util.List;

import linkedlist.SinglyLinkedList;

public class AdjList {
    SinglyLinkedList list[];
    int vertices;

    public AdjList(int vertices) {
        this.vertices = vertices;
        list = new SinglyLinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            list[i] = new SinglyLinkedList();
        }
    }

    public void addEdges(int u, int v) {
        list[u].addNode(v);
        list[v].addNode(u);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to: ");
            SinglyLinkedList.Node current = list[i].head;
            while (current != null) {
                System.out.print(current.data + ", ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public ArrayList<Integer> getAdjacentNode(int i) {
        ArrayList<Integer> adjNodes = new ArrayList<>();
        SinglyLinkedList.Node current = list[i].head;
        while (current != null) {
            adjNodes.add(current.data);
            current = current.next;
        }
        return adjNodes;
    }

    public static void main(String[] args) {
        AdjList adj = new AdjList(5);
        adj.addEdges(0, 1);
        adj.addEdges(0, 2);
        adj.addEdges(1, 3);
        adj.addEdges(1, 4);
        adj.addEdges(2, 3);
        adj.addEdges(3, 4);
        adj.printGraph();
        ArrayList<Integer> res = adj.getAdjacentNode(0);
        System.out.println(res);

    }
}
