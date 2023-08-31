package com.example.server;

import javafx.beans.binding.StringExpression;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ServerController implements Initializable {
    @FXML
    private VBox vBox;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private Button button;
    private Socket socket;
    private ServerSocket serverSocket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;
    //private JDBC connectJDBC = new JDBC();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        textArea.setEditable(false);
        button.setDefaultButton(true);

       // connectJDBC.showHistoryMessageFromSQL(textArea);

        try {
            serverSocket = new ServerSocket(4444);
            socket = serverSocket.accept();
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        new Thread(() ->{
            String message;
            try {
                while ((message = bufferedReader.readLine()) != null) {
                    appendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    @FXML
    protected void actionSendButton() {
        String message = textField.getText();
        sendMessage(message);
        appendMessage(message);
    }
    public void sendMessage(String message) {
        printWriter.println("Server: " + message);
        //connectJDBC.addMessageToSQL("Server",message);
        textField.clear();
    }
    public void appendMessage(String message) {
        textArea.appendText(message + "\n");
    }
}
