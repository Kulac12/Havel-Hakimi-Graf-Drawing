package com.example.graph_6;

import java.util.*;

class GenerateGraph {
    // Verilen derece dizisine göre bir graf matrisi oluşturur.
    static int[][] generateGraph(int[] degreeSequence) {
        // Derece dizisi tüm elemanları '2' ise çevre grafiği oluştur
        if (areAllDegreesTwo(degreeSequence)) {
            return generateCycleGraph(degreeSequence.length);
        }

        int n = degreeSequence.length;
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (degreeSequence[i] > 0 && degreeSequence[j] > 0) {
                    degreeSequence[i]--;
                    degreeSequence[j]--;
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }

        return graph;
    }

    // Derece dizisi tüm elemanları '2' ise true döner
    static boolean areAllDegreesTwo(int[] degreeSequence) {
        for (int degree : degreeSequence) {
            if (degree != 2) {
                return false;
            }
        }
        return true;
    }

    // Çevre grafiği oluşturan fonksiyon
    static int[][] generateCycleGraph(int numVertices) {
        if (numVertices < 3) {
            System.out.println("Çevre grafiği en az 3 düğüm içermelidir.");
            return null;
        }

        int[][] cycleGraph = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            int nextVertex = (i + 1) % numVertices; // Dönüşümlü olarak bir sonraki düğüme bağlanır.
            cycleGraph[i][nextVertex] = 1;
            cycleGraph[nextVertex][i] = 1;
        }

        return cycleGraph;
    }

    // Bir matrisi ekrana basar
    static void printMatrix(int[][] matrix) {
        int n = matrix.length;

        System.out.print("\n" + setw(3) + "     ");

        for (int i = 0; i < n; i++)
            System.out.print(setw(3) + "(" + i + ")");
        System.out.print("\n\n");

        for (int i = 0; i < n; i++) {
            System.out.print(setw(4) + "(" + i + ")");

            for (int j = 0; j < n; j++)
                System.out.print(setw(5) + matrix[i][j]);
            System.out.print("\n");
        }
    }

    // Bir matristeki bağlantıları ekrana basar
    static void printConnections(int[][] matrix) {
        int n = matrix.length;

        System.out.println("Bağlantılar:");
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    System.out.println("(" + i + ") --- (" + j + ")");
                }
            }
        }
    }

    static String setw(int n) {
        String space = "";
        while (n-- > 0)
            space += " ";
        return space;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Derece dizisini virgülle ayırarak giriniz (örneğin, 4,4,3,3,2): ");
        String input = scanner.nextLine();

        String[] degreeSequenceStr = input.split(",");
        int[] degreeSequence = new int[degreeSequenceStr.length];

        for (int i = 0; i < degreeSequenceStr.length; i++) {
            degreeSequence[i] = Integer.parseInt(degreeSequenceStr[i]);
        }

        int[][] adjacencyMatrix = generateGraph(degreeSequence);
        if (adjacencyMatrix != null) {
            printMatrix(adjacencyMatrix);
            printConnections(adjacencyMatrix);
        }

        scanner.close();
    }
}
