package com.infoman2.controller;

import com.infoman2.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainController {
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtMiddleName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private TextField txtEmail;
    @FXML
    private RadioButton rbMale;

    private DatabaseConnection connection;

    public void initialize() {
        connection = new DatabaseConnection();
    }

    @FXML
    private void save() throws SQLException {
        String sql = "INSERT INTO students(first_name, middle_name, last_name, email, phone_number, gender) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.connection.prepareStatement(sql);

        stmt.setString(1, txtFirstName.getText());
        stmt.setString(2, txtMiddleName.getText());
        stmt.setString(3, txtLastName.getText());
        stmt.setString(4, txtEmail.getText());
        stmt.setString(5, txtPhoneNumber.getText());

        // Directly connect the selected gender to the statement
        stmt.setString(6, rbMale.isSelected() ? rbMale.getText() : "Female");

        stmt.execute();
    }
}
