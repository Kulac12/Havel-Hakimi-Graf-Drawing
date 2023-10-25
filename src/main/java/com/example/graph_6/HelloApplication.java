package com.example.graph_6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Scanner;

public class HelloApplication extends Application {

    private int[][] adjacencyMatrix = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Grafı Çiz");
        button.setOnAction(e -> drawGraph());

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Graph Drawer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawGraph() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Derece dizisini virgülle ayırarak giriniz (örneğin, 4,4,3,3,2): ");
        String input = scanner.nextLine();

        String[] degreeSequenceStr = input.split(",");
        int[] degreeSequence = new int[degreeSequenceStr.length];
        int eleman_sayisi=degreeSequenceStr.length;
        int toplam_derece = 0;
        int tek_sayisi=0;
        //int k;


        for (int i = 0; i < degreeSequenceStr.length; i++) {
            degreeSequence[i] = Integer.parseInt(degreeSequenceStr[i]);
            toplam_derece =degreeSequence[i]+toplam_derece;
            if(degreeSequence[i]%2==1){
                tek_sayisi++;
            }
        }
        if(eleman_sayisi > degreeSequence[0] ){

            if(toplam_derece%2==0){
                if(tek_sayisi%2==0){
                    System.out.println("Grafik belirtir.");
                    adjacencyMatrix = GenerateGraph.generateGraph(degreeSequence);
                    scanner.close();
                    drawGraphOnCanvas();
                }else{
                    System.out.println("Grafik Belirtmez_3");
                }
            }else{
                System.out.println("Grafik Belirtmez._1");
            }
        }else {
                    System.out.println("Grafik belirtmez_0");
        }


       // adjacencyMatrix = GenerateGraph.generateGraph(degreeSequence);

       // scanner.close();

        //drawGraphOnCanvas();
    }

    private void drawGraphOnCanvas() {
        if (adjacencyMatrix == null) {
            System.out.println("Önce grafı oluşturmalısınız.");
            return;
        }

        Stage graphStage = new Stage();
        graphStage.setTitle("Graf");

        int numVertices = adjacencyMatrix.length;
        double width = 400;
        double height = 400;

        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        double centerX = width / 2;
        double centerY = height / 2;
        double radius = Math.min(centerX, centerY) - 10;

        gc.setFill(javafx.scene.paint.Color.BLACK);

        for (int i = 0; i < numVertices; i++) {
            double angle = 2 * Math.PI * i / numVertices;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            gc.fillOval(x - 5, y - 5, 10, 10);
            gc.fillText(".", x - 2, y + 2);

            for (int j = i + 1; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    double x1 = centerX + radius * Math.cos(2 * Math.PI * i / numVertices);
                    double y1 = centerY + radius * Math.sin(2 * Math.PI * i / numVertices);
                    double x2 = centerX + radius * Math.cos(2 * Math.PI * j / numVertices);
                    double y2 = centerY + radius * Math.sin(2 * Math.PI * j / numVertices);
                    gc.strokeLine(x1, y1, x2, y2);
                }
            }
        }

        StackPane graphLayout = new StackPane();
        graphLayout.getChildren().add(canvas);

        Scene graphScene = new Scene(graphLayout, width, height);
        graphStage.setScene(graphScene);
        graphStage.show();
    }
}
