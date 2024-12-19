package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OtherLabsController {
    @FXML
    private CheckBox ChBSklad;

    @FXML
    private CheckBox ChBPogod;

    @FXML
    private CheckBox ChBGnuch;

    @FXML
    private CheckBox ChBDruz;

    @FXML
    private Label IbITrueAnswer;

    @FXML
    private Label IbITrueAnswers;

    @FXML
    private Label IbITrueAnswerss;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private RadioButton radioLay;

    @FXML
    private RadioButton radioCode;

    @FXML
    private RadioButton radioHier;

    @FXML
    private RadioButton radioProp;

    @FXML
    private Label lblRadio;

    private ToggleGroup radiotoggleGroup;


    @FXML
    public void initialize() {
        // Ініціалізація ChoiceBox
        choiceBox.getItems().addAll("опис графічного інтерфейсу", "всю логіку програми", "за обробку подій");

        // Ініціалізація ComboBox
        comboBox.getItems().addAll("BorderPane", "AnchorPane", "VBox", "HBox");

        radiotoggleGroup = new ToggleGroup();

        // Прив'язуємо кожну кнопку до групи
        radioProp.setToggleGroup(radiotoggleGroup);
        radioLay.setToggleGroup(radiotoggleGroup);
        radioHier.setToggleGroup(radiotoggleGroup);
        radioCode.setToggleGroup(radiotoggleGroup);

        // Встановлюємо початковий текст на лейблі
        lblRadio.setText("Оберіть один із варіантів.");

        // Встановлення початкових значень
        IbITrueAnswer.setText("");

    }

    @FXML
    void checkBoxAnswer(ActionEvent event) {
        String answer = "Ваша відповідь:";

        if (ChBPogod.isSelected())
            answer += "\nпогодженість";
        if (ChBGnuch.isSelected())
            answer += "\nгнучкість";
        if (ChBDruz.isSelected())
            answer += "\nдружність";
        if (ChBSklad.isSelected())
            answer += "\nскладність";

        IbITrueAnswer.setText(answer); // Встановлюємо текст на Label
    }

    @FXML
    private void handleChoiceBoxAction() {
        String selected = choiceBox.getValue();
        if (selected != null) {
            IbITrueAnswers.setText("Ви обрали: " + selected);
        } else {
            IbITrueAnswers.setText("Будь ласка, оберіть значення у ChoiceBox.");
        }
    }

    @FXML
    private void handleComboBoxAction() {
        String selected = comboBox.getValue();
        if (selected != null) {
            IbITrueAnswerss.setText("Відповідь: " + selected);
        } else {
            IbITrueAnswerss.setText("Будь ласка, оберіть значення у ComboBox.");
        }
    }

    @FXML
    void RadioAnswer(ActionEvent event) {
        // Перевіряємо, яка кнопка була вибрана
        if (radiotoggleGroup.getSelectedToggle().equals(radioCode))
            lblRadio.setText("Відповідь: Code");
        else if (radiotoggleGroup.getSelectedToggle().equals(radioHier))
            lblRadio.setText("Відповідь: Hierarchy");
        else if (radiotoggleGroup.getSelectedToggle().equals(radioLay))
            lblRadio.setText("Відповідь: Layout");
        else if (radiotoggleGroup.getSelectedToggle().equals(radioProp))
            lblRadio.setText("Відповідь: Properties");
    }
}
