package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> vn = new ArrayList<>();

        vn.add("S");
        vn.add("A");
        vn.add("B");
        vn.add("C");
        vn.add("End");

        Graph FA = new Graph();

        FA.addNode(vn.get(0));
        FA.addNode(vn.get(1));
        FA.addNode(vn.get(2));
        FA.addNode(vn.get(3));
        FA.addNode(vn.get(4));

        FA.addEdge(vn.indexOf("S"), vn.indexOf("A"), 'd');
        FA.addEdge(vn.indexOf("A"), vn.indexOf("End"), 'd');
        FA.addEdge(vn.indexOf("A"), vn.indexOf("B"), 'a');
        FA.addEdge(vn.indexOf("B"), vn.indexOf("C"), 'b');
        FA.addEdge(vn.indexOf("C"), vn.indexOf("A"), 'c');
        FA.addEdge(vn.indexOf("C"), vn.indexOf("S"), 'a');

        for (int i = 0; i < vn.size(); i++) {
            for (int j = 0; j < vn.size(); j++) {
                System.out.print(FA.matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Enter the word:");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        int j = 0;
        int n = 0;
        int k = 0;

        for (int i = 0; i < word.length(); i++){
            System.out.println(word.charAt(i));

            for (int m = 0; m < vn.size(); m++){
                if (word.charAt(i) == FA.matrix[n][m]){
                    System.out.println("Node " + FA.nodes.get(j).name + " -> " + word.charAt(i) + " +");
                    n = m;
                    j = m;
                    k++;
                    break;
                }
            }
        }

        if (k == word.length()){
            System.out.println("Accepted");
        } else {
            System.out.println("Not accepted");
        }

    }

}