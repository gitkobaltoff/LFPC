package com.company;

import java.util.ArrayList;

public class Graph{

    public int size = 5;
    public char[][] matrix;
    ArrayList<Node> nodes;

    public Graph(){
        nodes = new ArrayList<>();
        matrix = new char[size][size];
    }

    public void addNode(String name){
        nodes.add(new Node(name));
    }

    public void addEdge(int start, int end, char weight){
        matrix[start][end] = weight;
    }
}
