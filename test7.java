package com.example.a7;
//Import javafx packages
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
public class A7 extends Application
{
    private TextField display = new TextField();
    private double firstOperand = 0;  //A text field to display the numbers and results of calculations
    private String operator = "";
    private boolean startNewNumber = true;
    @Override
    public void start(Stage primaryStage)
    {
        // Basic UI setup
        primaryStage.setTitle("Jin's Calculator"); //Name the calculator
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        // Text field for display
        display.setEditable(false);
        display.setAlignment(Pos.BASELINE_RIGHT);
        display.setMinSize(200, 50);
        root.add(display, 0, 0, 4, 1);
        // Buttons for the digits and operations
        String[] buttonTexts = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "AC", "=", "+"
        };
        for (int i = 0; i < buttonTexts.length; i++)
        {
            Button btn = new Button(buttonTexts[i]);
            btn.setMinSize(50, 50);
            btn.setOnAction(e -> onButtonClicked(btn.getText()));
            int colIndex = i % 4;
            int rowIndex = (i / 4) + 1;
            root.add(btn, colIndex, rowIndex);
        }
        // Set scene and stage
        Scene scene = new Scene(root, 300, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void onButtonClicked(String value)
    {
        if ("0123456789".contains(value))  //Actions performed by entering numbers
        {
            if (startNewNumber)
            {
                display.setText("");
                startNewNumber = false;
            }
            display.setText(display.getText() + value);
            //The numbers entered in the calculator should be retained in the display field
        }
        else if ("+-*/".contains(value)) //Actions performed by entering operators "+-*/"
        {
            firstOperand = Double.parseDouble(display.getText());
            operator = value;
            startNewNumber = true;
        }
        else if ("=".equals(value))  //Actions performed by entering operators "="
        {
            double secondOperand = Double.parseDouble(display.getText());
            double result = calculate(firstOperand, secondOperand, operator);
            display.setText(String.valueOf(result));
            startNewNumber = true;
            //A calculation is performed and the result replaces the number
        }
        else if ("AC".equals(value)) //Actions performed by entering AC
        {
            display.setText("");
            firstOperand = 0;
            operator = "";
            startNewNumber = true;
        }
    }
    private double calculate(double firstOperand, double secondOperand, String operator)
    {
        switch (operator)  //The process of implementing calculations after having two numbers
        {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand == 0)
                {
                    throw new ArithmeticException("Cannot divide by zero");
                    //avoid the fault of division by zero
                }
                return firstOperand / secondOperand;
        }
        return 0;
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}