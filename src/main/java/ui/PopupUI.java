package ui;

import japanese_dictionary.db.DataBaseManager;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author superanand67
 */
public class PopupUI {
    
    public static final Font JP_MEDIUM = Font.loadFont(
            DictionaryUI.class.getResourceAsStream("/fonts/NotoSansJP-Medium.ttf"),15);
    public static final Font JP_BOLD = Font.loadFont(
            DictionaryUI.class.getResourceAsStream("/fonts/NotoSansJP-Bold.ttf"),20);
    public static final Font JP_REGULAR = Font.loadFont(
            DictionaryUI.class.getResourceAsStream("/fonts/NotoSansJP-Regular.ttf"),15);

    private final DataBaseManager dataBaseManager;
    
    public PopupUI(DataBaseManager dbManager) {
        this.dataBaseManager = dbManager;
    }
    
    public void showPopup() {
        
        Stage popupStage = new Stage();
        
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Add New Kanji");
        
        VBox root = new VBox(20);
        //root.setAlignment(Pos.CENTER);
        
        BorderPane topPane = new BorderPane();
        GridPane mainPane = new GridPane(10,10);
        HBox bottomPane = new HBox(15);
                
        Label title = new Label("Add New Kanji");
        title.setFont(Font.font(JP_BOLD.getName(),24));
        title.setAlignment(Pos.CENTER);
        
        topPane.setCenter(title);
        topPane.setPadding(new Insets(20,0,20,0));
        
        Label kanjiLabel = new Label("Kanji : ");
        Label meaningLabel = new Label("Meaning : ");
        Label onyomiLabel = new Label("Onyomi : ");
        Label kunyomiLabel = new Label("Kunyomi : ");
        Label strokesLabel = new Label("No.of Strokes : ");
        
        TextField kanji = new TextField();
        TextField meaning = new TextField();
        TextField onyomi = new TextField();
        TextField kunyomi = new TextField();
        TextField strokes = new TextField();
              
        mainPane.add(kanjiLabel, 0, 0);
        mainPane.add(meaningLabel, 0, 1);
        mainPane.add(onyomiLabel, 0, 2);
        mainPane.add(kunyomiLabel, 0, 3);
        mainPane.add(strokesLabel, 0, 4);
        
        mainPane.add(kanji,1,0);
        mainPane.add(meaning,1,1);
        mainPane.add(onyomi,1,2);
        mainPane.add(kunyomi,1,3);
        mainPane.add(strokes,1,4);
        
        GridPane.setHalignment(kanjiLabel, HPos.RIGHT);
        GridPane.setHalignment(meaningLabel, HPos.RIGHT);
        GridPane.setHalignment(onyomiLabel, HPos.RIGHT);
        GridPane.setHalignment(kunyomiLabel, HPos.RIGHT);
        GridPane.setHalignment(strokesLabel, HPos.RIGHT);
        
        mainPane.setPadding(new Insets(0,15,0,30));
        
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");
        
        saveButton.setOnAction((event) -> {
        try {
            String kanjiStr = kanji.getText();
            String meaningStr = meaning.getText();
            String onyomiStr = onyomi.getText();
            String kunyomiStr = kunyomi.getText();
            int noOfStrokes = Integer.parseInt(strokes.getText());
            
            dataBaseManager.addKanji(kanjiStr, meaningStr, onyomiStr, kunyomiStr, noOfStrokes);
            
            popupStage.close();
            
          }
          catch(NumberFormatException e) {
                System.out.println("Please Enter a Valid No. of Strokes !");
                title.setText("Enter Valid No. of Strokes !");
          }
        
        });
        
        cancelButton.setOnAction((event) -> {
            popupStage.close();
        });
        
        bottomPane.setAlignment(Pos.CENTER);
        
        bottomPane.getChildren().addAll(saveButton,cancelButton);
        
        root.getChildren().addAll(topPane,mainPane,bottomPane);
        
        Scene scene = new Scene(root,450,400);
        
        popupStage.setScene(scene);
        popupStage.showAndWait();
        
    }

}
