package japanese_dictionary;

/**
 *
 * @author superanand67
 */

import javafx.application.Application;
import javafx.scene.Scene;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import ui.DictionaryUI;
import javafx.scene.image.Image;

public class JapaneseDictionary extends Application {
       
        @Override
        public void start(Stage primaryStage) throws Exception {
                        
            DictionaryUI myUI = new DictionaryUI();
            
            Scene scene = new Scene(myUI.BuildUI(),600,500);
            
            primaryStage.setTitle("Japanese Dictionary");
            primaryStage.setScene(scene);
            
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/app-icon.png")));
            
            primaryStage.show();
            
        }
    
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
