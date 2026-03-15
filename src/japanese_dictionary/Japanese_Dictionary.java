package japanese_dictionary;

/**
 *
 * @author superanand67
 */

import javafx.application.Application;
import javafx.scene.Scene;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import japanese_dictionary.ui.DictionaryUI;
import javafx.scene.image.Image;

public class Japanese_Dictionary extends Application {
       
        @Override
        public void start(Stage primaryStage) throws Exception {
            
            DictionaryUI myUI = new DictionaryUI();
            
            Scene sc = new Scene(myUI.BuildUI(),600,500);
            
            primaryStage.setTitle("Japanese Dictionary");
            primaryStage.setScene(sc);
            
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/app-icon.png")));
            
            primaryStage.show();
            
        }
    
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
