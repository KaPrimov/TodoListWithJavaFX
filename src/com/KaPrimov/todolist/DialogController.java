package com.KaPrimov.todolist;

import com.KaPrimov.todolist.datamodel.TodoData;
import com.KaPrimov.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadline = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription, details, deadline);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }

    public TodoItem editItem(TodoItem item) {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadline = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription, details, deadline);
        TodoData.getInstance().replaceTodo(item, newItem);
        System.out.println(item.getShortDescription());
        System.out.println(newItem.getShortDescription());
        return newItem;
    }
}
