package japanese_dictionary.ui;

import japanese_dictionary.db.DataBaseManager;
import japanese_dictionary.model.KanjiList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

/**
 *
 * @author superanand67
 **/
public class DictionaryUI{
    
    public static final Font JPMedium = Font.loadFont(DictionaryUI.class.getResourceAsStream("/resources/fonts/NotoSansJP-Medium.ttf"),15);
    public static final Font JPBold = Font.loadFont(DictionaryUI.class.getResourceAsStream("/resources/fonts/NotoSansJP-Bold.ttf"),20);
    
    public BorderPane BuildUI() {
        
        DataBaseManager dbManager = new DataBaseManager();
        
        //String font1 = "Noto Sans CJK JP";
                
        BorderPane root = new BorderPane();
        HBox search = new HBox(10);
        VBox kanji = new VBox(15);
        GridPane details = new GridPane();
        GridPane list = new GridPane(10,15);
        VBox welcome = new VBox(70);
        HBox BMK = new HBox(15);
        
        details.setHgap(10);
        details.setVgap(15);
        
        root.setCenter(welcome);
        root.setTop(search);
        root.setPadding(new Insets(15));
        root.setBottom(BMK);
        
        Button searchbtn = new Button("Search 🔎");
        Button bookmarked = new Button("☆");
        Button bookmarks = new Button("Bookmarks ★");
        Button home = new Button("🏠 Home");
        Button showAll = new Button("Show All");
        
        BMK.getChildren().addAll(showAll,bookmarks);
        BMK.setAlignment(Pos.CENTER);
        //★
                        
        Label ListKanji = new Label("男");
        ListKanji.setFont(Font.font(JPBold.getName(),50));
        Label ListMean = new Label("Male");
        ListMean.setFont(Font.font(JPMedium.getName(),20));
        
        list.setAlignment(Pos.CENTER);
        
        Label wel = new Label("Search for a Kanji to Begin !");
        wel.setFont(Font.font(JPBold.getName(),25));
        welcome.setAlignment(Pos.CENTER);
        
        welcome.getChildren().addAll(wel,BMK);
                
        TextField s = new TextField();
             
        details.setAlignment(Pos.BOTTOM_LEFT);
        
        search.getChildren().addAll(s,searchbtn);
        
        Label k = new Label("木");
        k.setFont(new Font(100));
        
        // Headers
        Label mean = new Label("Tree / Wood");
        mean.setFont(Font.font(JPMedium.getName(), 18));
        
        Label on = new Label("Onyomi: ");
        on.setFont(Font.font(JPBold.getName(),15));
        
        Label kun = new Label("Kunyomi: ");
        kun.setFont(Font.font(JPBold.getName(),15));
        
        Label st = new Label("Strokes: ");
        st.setFont(Font.font(JPBold.getName(),15));
        
        //Meanings Column result
        Label onm = new Label("Text");
        onm.setFont(Font.font(JPMedium.getName(),15));
        
        Label kunm = new Label("Text");
        kunm.setFont(Font.font(JPMedium.getName(),15));
        
        Label sto = new Label("Text");
        sto.setFont(Font.font(JPMedium.getName(),15));
                
        ListView<String> wordList = new ListView<>();
                
        wordList.setStyle("-fx-font-size:18px;");
        
        searchbtn.setDefaultButton(true);
        
        searchbtn.setOnAction(event -> { searchKanjiBar(s, wordList, dbManager, root, wel); });
        
        bookmarked.setOnAction((event) -> { bookmarkedKanji(k, bookmarked, dbManager); });
        
        bookmarks.setOnAction((event) -> { bookmarksList(dbManager, wordList, root, wel); });
        
        home.setOnAction((event) -> { homeButton(s, wel, root, welcome); });
        
        showAll.setOnAction((event) -> { showAllButton(dbManager, wordList, root, wel); });
        
        wordList.getSelectionModel().selectedItemProperty().addListener((observe,oldval,newval) -> {
                            if (newval != null) {
                                String kanjiS = newval.split(":")[0].trim();
                                
                                KanjiList detail = dbManager.getKanji(kanjiS);
                                                                  
                                k.setText(detail.getKanji());
                                onm.setText(detail.getOnyomi());
                                kunm.setText(detail.getKunyomi());
                                mean.setText(detail.getMeaning());
                                sto.setText(String.valueOf(detail.getStrokes()));
                                
                                if(dbManager.bmkBtn(kanjiS)) {
                                    bookmarked.setText("★");
                                }
                                else {
                                    bookmarked.setText("☆");
                                }
                                
                                root.setCenter(kanji);                               
                            }
                        });
        
        details.add(on,3,0);
        details.add(onm,4,0);
        details.add(kun,3,1);
        details.add(kunm,4,1);
        details.add(st,3,2);
        details.add(sto,4,2);
        details.add(bookmarked,33,1);
        details.add(home,15,6);
        
        HBox.setHgrow(s, Priority.ALWAYS);
        
        kanji.getChildren().addAll(k,mean,details);
        kanji.setAlignment(Pos.TOP_CENTER);
        
        return root;    
    }

    private static void showAllButton(DataBaseManager dbManager, ListView<String> wordList, BorderPane root, Label wel) {
        List<KanjiList> AllKanji = dbManager.showAll();
        
        wordList.getItems().clear();
        
        for (KanjiList K : AllKanji) {
            wordList.getItems().add(K.getKanji() + " : " + K.getMeaning());
        }
        
        if(wordList.getItems().isEmpty()) {
            System.out.println("No Kanji Found !!!");
            root.setCenter(wel);
            wel.setText("No Kanji Found !!!");
        }
        else {
            root.setCenter(wordList);
        }
    }

    private static void homeButton(TextField s, Label wel, BorderPane root, VBox welcome) {
        s.clear();
        wel.setText("Search for a Kanji to Begin !");
        root.setCenter(welcome);
    }

    private static void bookmarksList(DataBaseManager dbManager, ListView<String> wordList, BorderPane root, Label wel) {
        List<KanjiList> BmkLst = dbManager.bookmarks();
        
        wordList.getItems().clear();
        
        for(KanjiList words : BmkLst) {
            
            wordList.getItems().add(words.getKanji() + " : " + words.getMeaning());
        }
        
        if(wordList.getItems().isEmpty()) {
            System.out.println("No BookMarks Found !!!");
            root.setCenter(wel);
            wel.setText("No BookMarks Found !!!");
        }
        else {
            root.setCenter(wordList);
        }
    }

    private static void bookmarkedKanji(Label k, Button bookmarked, DataBaseManager dbManager) {
        String kan = k.getText();
        
        if("☆".equals(bookmarked.getText())) {
            bookmarked.setText("★");
            
            System.out.println("Bookmarked : " + kan);
            
            dbManager.bookmarked(1, kan);
        }
        else {
            bookmarked.setText("☆");
            
            System.out.println("UnBookmarked : " + kan);
            
            dbManager.bookmarked(0, kan);
        }
    }

    private static void searchKanjiBar(TextField s, ListView<String> wordList, DataBaseManager dbManager, BorderPane root, Label wel) {
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
            }
        }
        else {
            System.out.println("Please Enter a word to search!");
            root.setCenter(wel);
            wel.setText("Please Enter a word to search!");
        }
    }    
}
