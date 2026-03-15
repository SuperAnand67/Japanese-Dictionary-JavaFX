
package japanese_dictionary.ui;

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
    
    public static final Font JPMedium = Font.loadFont(DictionaryUI.class.getResourceAsStream("/resources/fonts/NotoSansJP-Medium.ttf"),15);
    public static final Font JPBold = Font.loadFont(DictionaryUI.class.getResourceAsStream("/resources/fonts/NotoSansJP-Bold.ttf"),20);
    public static final Font JPRegular = Font.loadFont(DictionaryUI.class.getResourceAsStream("/resources/fonts/NotoSansJP-Regular.ttf"),15);

    private DataBaseManager dataBaseManager;
    
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
        title.setFont(Font.font(JPBold.getName(),24));
        title.setAlignment(Pos.CENTER);
        
        topPane.setCenter(title);
        topPane.setPadding(new Insets(20,0,20,0));
        
        Label kanji = new Label("Kanji : ");
        Label meaning = new Label("Meaning : ");
        Label onyomi = new Label("Onyomi : ");
        Label kunyomi = new Label("Kunyomi : ");
        Label strokes = new Label("No.of Strokes : ");
        
        TextField kanjiN = new TextField();
        TextField meaningN = new TextField();
        TextField onyomiN = new TextField();
        TextField kunyomiN = new TextField();
        TextField strokesN = new TextField();
              
        mainPane.add(kanji, 0, 0);
        mainPane.add(meaning, 0, 1);
        mainPane.add(onyomi, 0, 2);
        mainPane.add(kunyomi, 0, 3);
        mainPane.add(strokes, 0, 4);
        
        mainPane.add(kanjiN,1,0);
        mainPane.add(meaningN,1,1);
        mainPane.add(onyomiN,1,2);
        mainPane.add(kunyomiN,1,3);
        mainPane.add(strokesN,1,4);
        
        GridPane.setHalignment(kanji, HPos.RIGHT);
        GridPane.setHalignment(meaning, HPos.RIGHT);
        GridPane.setHalignment(onyomi, HPos.RIGHT);
        GridPane.setHalignment(kunyomi, HPos.RIGHT);
        GridPane.setHalignment(strokes, HPos.RIGHT);
        
        mainPane.setPadding(new Insets(0,15,0,30));
        
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");
        
        saveButton.setOnAction((event) -> {
       try {
            String kanjiS = kanjiN.getText();
            String meaningS = meaningN.getText();
            String onYS = onyomiN.getText();
            String kunYS = kunyomiN.getText();
            int strokesI = Integer.parseInt(strokesN.getText());
            
            dataBaseManager.addKanji(kanjiS, meaningS, onYS, kunYS, strokesI);
            
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
        
        Scene scene = new Scene(root,400,350);
        
        popupStage.setScene(scene);
        popupStage.showAndWait();
        
    }

}
