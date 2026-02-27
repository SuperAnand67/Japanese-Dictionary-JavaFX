package japanese_dictionary.ui;

import japanese_dictionary.db.DataBaseManager;
import japanese_dictionary.model.KanjiList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author superanand67
 **/
public class DictionaryUI{
    
    public BorderPane BuildUI() {
        
        DataBaseManager dbManager = new DataBaseManager();
        
        String font1 = "Noto Sans CJK JP";
        
        BorderPane root = new BorderPane();
        HBox search = new HBox(10);
        VBox kanji = new VBox(15);
        GridPane details = new GridPane();
        GridPane list = new GridPane(10,15);
        HBox welcome = new HBox();
        
        details.setHgap(10);
        details.setVgap(15);
        
        root.setCenter(welcome);
        root.setTop(search);
        root.setPadding(new Insets(15));
        
        Button searchbtn = new Button("Search 🔎");
                
        Label ListKanji = new Label("男");
        ListKanji.setFont(Font.font(font1,FontWeight.BOLD,50));
        Label ListMean = new Label("Male");
        ListMean.setFont(Font.font(font1,FontWeight.MEDIUM,20));
        
        list.setAlignment(Pos.CENTER);
        
        Label wel = new Label("Search for a Kanji to Begin !");
        wel.setFont(Font.font(font1,FontWeight.BOLD,25));
        welcome.setAlignment(Pos.CENTER);
        
        welcome.getChildren().add(wel);
                
        TextField s = new TextField();
             
        details.setAlignment(Pos.BOTTOM_LEFT);
        
        search.getChildren().addAll(s,searchbtn);
        
        Label k = new Label("木");
        k.setFont(new Font(100));
        
        // Headers
        Label mean = new Label("Tree / Wood");
        mean.setFont(Font.font(font1, FontWeight.MEDIUM, 18));
        
        Label on = new Label("Onyomi: ");
        on.setFont(Font.font(font1,FontWeight.BOLD,15));
        
        Label kun = new Label("Kunyomi: ");
        kun.setFont(Font.font(font1,FontWeight.BOLD,15));
        
        Label st = new Label("Strokes: ");
        st.setFont(Font.font(font1,FontWeight.BOLD,15));
        
        //Meanings Column result
        Label onm = new Label("Text");
        onm.setFont(Font.font(font1,FontWeight.MEDIUM,13));
        
        Label kunm = new Label("Text");
        kunm.setFont(Font.font(font1,FontWeight.MEDIUM,13));
        
        Label sto = new Label("Text");
        sto.setFont(Font.font(font1,FontWeight.MEDIUM,13));
        
        ListView<String> wordList = new ListView<>();
        
        wordList.setStyle("-fx-font-size:18px;");
        
        searchbtn.setDefaultButton(true);
        
        searchbtn.setOnAction(event -> {
            
            String word = s.getText();
                       
            if(!word.isEmpty()) {
                System.out.println("User is Searching : " + word);
                
                   wordList.getItems().clear();
                    
                    List<KanjiList> searchResults = dbManager.searchDB(word);
                    
                    for(KanjiList words : searchResults) {
                                              
                        wordList.getItems().add(words.getKanji() + " : " + words.getMeaning());
                    }
                    
                    if(wordList.getItems().isEmpty()) {
                        System.out.println("Not in our Dictionary !!!!");
                        root.setCenter(wel);
                        wel.setText("Not in our Dictionary !!!!");
                    }
                    
                    else{
                        root.setCenter(wordList);
                        
                        wordList.getSelectionModel().selectedItemProperty().addListener((observe,oldval,newval) -> {
                            if (newval != null) {
                                String kanjiS = newval.split(":")[0].trim();
                                
                                KanjiList detail = dbManager.getKanji(kanjiS);
                                                                  
                                k.setText(detail.getKanji());
                                onm.setText(detail.getOnyomi());
                                kunm.setText(detail.getKunyomi());
                                mean.setText(detail.getMeaning());
                                sto.setText(String.valueOf(detail.getStrokes()));

                                root.setCenter(kanji);                               
                            }
                        });
                    }                                   
            }
            else {
                System.out.println("Please Enter a word to search!");
                root.setCenter(wel);
                wel.setText("Please Enter a word to search!");
            } 
        });

        details.add(on,3,0);
        details.add(onm,4,0);
        details.add(kun,3,1);
        details.add(kunm,4,1);
        details.add(st,3,2);
        details.add(sto,4,2);
        
        HBox.setHgrow(s, Priority.ALWAYS);
        
        kanji.getChildren().addAll(k,mean,details);
        kanji.setAlignment(Pos.TOP_CENTER);
        
        return root;    
    }
    
    
}
