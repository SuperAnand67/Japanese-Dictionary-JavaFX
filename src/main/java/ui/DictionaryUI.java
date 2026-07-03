package ui;

import japanese_dictionary.db.DataBaseManager;
import japanese_dictionary.model.KanjiList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.application.Application;
import atlantafx.base.theme.*;
import japanese_dictionary.JapaneseDictionary;
import java.util.prefs.Preferences;

/**
 *
 * @author superanand67
 *
 */
public class DictionaryUI {

    public static final Font JP_MEDIUM = Font.loadFont(DictionaryUI.class.
            getResourceAsStream("/fonts/NotoSansJP-Medium.ttf"), 15);

    public static final Font JP_BOLD = Font.loadFont(DictionaryUI.class.
            getResourceAsStream("/fonts/NotoSansJP-Bold.ttf"), 20);

    public static final Font JP_REGULAR = Font.loadFont(DictionaryUI.class.
            getResourceAsStream("/fonts/NotoSansJP-Regular.ttf"), 15);

    private final Preferences prefs = Preferences.userNodeForPackage(JapaneseDictionary.class);

    private Theme currentTheme = new CupertinoLight();

    public BorderPane BuildUI() {

        DataBaseManager dbManager = new DataBaseManager();

        setCurrentTheme(pref_theme());

        Application.setUserAgentStylesheet(getCurrentTheme().getUserAgentStylesheet());

        BorderPane root = new BorderPane();
        HBox searchBar = new HBox(10);
        VBox kanji = new VBox(15);
        GridPane details = new GridPane();
        GridPane list = new GridPane(10, 15);
        VBox welcome = new VBox(70);
        HBox bookmarksMenu = new HBox(15);

        details.setHgap(10);
        details.setVgap(15);

        searchBar.setPadding(new Insets(5, 5, 15, 5));

        root.setCenter(welcome);
        root.setTop(searchBar);
        root.setPadding(new Insets(15));
        root.setBottom(bookmarksMenu);

        Button searchButton = new Button("Search 🔎");
        Button isBookmarked = new Button(" ☆ ");
        Button bookmarksButton = new Button("Bookmarks ★");
        Button home = new Button(" 🏠 ");
        Button showAll = new Button("Show All");
        Button addKanji = new Button("➕ Add Kanji");
        Button delkanji = new Button(" ❌ ");
        Button theme_switch = new Button("☀️");

        Tooltip homeTip = new Tooltip("Return to Home Screen");
        Tooltip delTip = new Tooltip("Delete from Dictionary");
        Tooltip bookmarkTip = new Tooltip("Bookmark this Kanji");

        home.setTooltip(homeTip);
        delkanji.setTooltip(delTip);
        isBookmarked.setTooltip(bookmarkTip);

        homeTip.setShowDelay(Duration.ZERO);
        delTip.setShowDelay(Duration.ZERO);
        bookmarkTip.setShowDelay(Duration.ZERO);

        homeShow(false, home);

        bookmarksMenu.getChildren().addAll(addKanji, showAll, bookmarksButton, theme_switch);
        bookmarksMenu.setAlignment(Pos.CENTER);

        Label kanjiList = new Label("男");
        kanjiList.setFont(Font.font(JP_BOLD.getName(), 50));
        Label meaningList = new Label("Male");
        meaningList.setFont(Font.font(JP_MEDIUM.getName(), 20));

        list.setAlignment(Pos.CENTER);

        Label homeScreen = new Label("Search for a Kanji to Begin !");
        homeScreen.setFont(Font.font(JP_BOLD.getName(), 25));
        welcome.setAlignment(Pos.CENTER);

        welcome.getChildren().addAll(homeScreen, bookmarksMenu);

        TextField s = new TextField();

        details.setAlignment(Pos.BOTTOM_LEFT);

        searchBar.getChildren().addAll(home, s, searchButton);

        Label k = new Label("");
        k.setFont(new Font(100));

        // Headers
        Label meaningLabel = new Label("Tree / Wood");
        set_font(meaningLabel, JP_MEDIUM, 18);

        Label onyomiLabel = new Label("Onyomi: ");
        set_font(onyomiLabel, JP_BOLD, 15);

        Label kunyomiLabel = new Label("Kunyomi: ");
        set_font(kunyomiLabel, JP_BOLD, 15);

        Label strokesLabel = new Label("Strokes: ");
        set_font(strokesLabel, JP_BOLD, 15);

        //Meanings Column result
        Label onyomi = new Label("Text");
        set_font(onyomi, JP_MEDIUM, 15);

        Label kunyomi = new Label("Text");
        set_font(kunyomi, JP_MEDIUM, 15);

        Label strokes = new Label("Text");
        set_font(strokes, JP_MEDIUM, 15);

        ListView<KanjiList> wordList = new ListView<>();

        wordList.setStyle("-fx-font-size:18px;");

        searchButton.setDefaultButton(true);

        searchButton.setOnAction(event -> {
            searchKanjiBar(s, wordList, dbManager, root, homeScreen);
            homeShow(true, home);
        });

        isBookmarked.setOnAction((event) -> {
            bookmarkedKanji(k, isBookmarked, dbManager);
        });

        bookmarksButton.setOnAction((event) -> {
            bookmarksList(dbManager, wordList, root, homeScreen);
            homeShow(true, home);
        });

        home.setOnAction((event) -> {
            homeScreen.setText("Search for a Kanji to Begin !");
            homeButton(s, homeScreen, root, welcome);
            homeShow(false, home);
        });

        showAll.setOnAction((event) -> {
            showAllButton(dbManager, wordList, root, homeScreen);
            homeShow(true, home);
        });

        addKanji.setOnAction((event) -> {
            PopupUI addKanjiNew = new PopupUI(dbManager);
            addKanjiNew.showPopup();

        });

        delkanji.setOnAction((event) -> {
            String kanjiDel = k.getText();
            dbManager.deleteKanji(kanjiDel);
            homeButton(s, homeScreen, root, welcome);

        });

        theme_switch.setOnAction((event) -> {
            setCurrentTheme(theme_switcher(getCurrentTheme(), theme_switch));
            Application.setUserAgentStylesheet(getCurrentTheme().getUserAgentStylesheet());
        });

        wordList.getSelectionModel().selectedItemProperty().
                addListener((observe, oldval, newval) -> {
                    listenerListView(newval, dbManager, k, onyomi, kunyomi, meaningLabel, strokes, isBookmarked, root, kanji);
                });

        wordList.setCellFactory((param) -> CellFactory());

        details.add(onyomiLabel, 3, 0);
        details.add(onyomi, 4, 0);
        details.add(kunyomiLabel, 3, 1);
        details.add(kunyomi, 4, 1);
        details.add(strokesLabel, 3, 2);
        details.add(strokes, 4, 2);
        details.add(isBookmarked, 5, 4);
        details.add(delkanji, 20, 4);

        HBox.setHgrow(s, Priority.ALWAYS);

        kanji.getChildren().addAll(k, meaningLabel, details);
        kanji.setAlignment(Pos.TOP_CENTER);

        return root;
    }

    private void listenerListView(KanjiList newval, DataBaseManager dbManager, Label k, Label onm, Label kunm, Label mean, Label sto, Button bookmarked, BorderPane root, VBox kanji) {
        if (newval != null) {
            String kanjiS = newval.getKanji();

            KanjiList detail = dbManager.getKanji(kanjiS);

            k.setText(detail.getKanji());
            onm.setText(detail.getOnyomi());
            kunm.setText(detail.getKunyomi());
            mean.setText(detail.getMeaning());
            sto.setText(String.valueOf(detail.getStrokes()));

            if (dbManager.bmkBtn(kanjiS)) {
                bookmarked.setText(" ★ ");
            }
            else {
                bookmarked.setText(" ☆ ");
            }

            root.setCenter(kanji);
        }
    }

    private ListCell<KanjiList> CellFactory() {
        return new ListCell<KanjiList>() {
            private final HBox rowLayout = new HBox(10);

            private final Label kanjiL = new Label();

            private final Label meaningL = new Label();

            {
                kanjiL.setFont(Font.font(JP_BOLD.getName(), 22));

                meaningL.setFont(Font.font(JP_MEDIUM.getName(), 16));

                rowLayout.setAlignment(Pos.CENTER_LEFT);

                rowLayout.getChildren().addAll(kanjiL, meaningL);
            }

            @Override
            protected void updateItem(KanjiList obj, boolean empty) {
                super.updateItem(obj, empty);

                if (empty || obj == null) {
                    setText(null);
                    setGraphic(null);
                }
                else {
                    kanjiL.setText(obj.getKanji());
                    meaningL.setText(" : " + obj.getMeaning());

                    setText(null);
                    setGraphic(rowLayout);
                }
            }

        };
    }

    private static void homeShow(boolean bool, Button home) {
        home.setVisible(bool);
        home.setManaged(bool);
    }

    private static void showAllButton(DataBaseManager dbManager,
            ListView<KanjiList> wordList, BorderPane root, Label wel) {

        List<KanjiList> AllKanji = dbManager.showAll();

        wordList.getItems().clear();

        wordList.getItems().addAll(AllKanji);

        if (wordList.getItems().isEmpty()) {
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

    private static void bookmarksList(DataBaseManager dbManager,
            ListView<KanjiList> wordList, BorderPane root, Label wel) {

        List<KanjiList> BmkLst = dbManager.bookmarks();

        wordList.getItems().clear();

        wordList.getItems().addAll(BmkLst);

        if (wordList.getItems().isEmpty()) {
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

        if (" ☆ ".equals(bookmarked.getText())) {
            bookmarked.setText(" ★ ");

            System.out.println("Bookmarked : " + kan);

            dbManager.bookmarked(1, kan);
        }
        else {
            bookmarked.setText(" ☆ ");

            System.out.println("UnBookmarked : " + kan);

            dbManager.bookmarked(0, kan);
        }
    }

    private static void searchKanjiBar(TextField s, ListView<KanjiList> wordList,
            DataBaseManager dbManager, BorderPane root, Label wel) {

        String word = s.getText();

        if (!word.isEmpty()) {
            System.out.println("User is Searching : " + word);

            wordList.getItems().clear();

            List<KanjiList> searchResults = dbManager.searchDB(word);

            wordList.getItems().addAll(searchResults);

            if (wordList.getItems().isEmpty()) {
                System.out.println("Not in our Dictionary !!!!");
                root.setCenter(wel);
                wel.setText("Not in our Dictionary !!!!");
            }

            else {
                root.setCenter(wordList);
            }
        }
        else {
            System.out.println("Please Enter a word to search!");
            root.setCenter(wel);
            wel.setText("Please Enter a word to search!");
        }
    }

    private Theme theme_switcher(Theme theme, Button theme_switch) {
        if (theme.isDarkMode()) {
            theme_switch.setText("☀️");
            prefs.putBoolean("darkMode", false);
            return new CupertinoLight();
        }

        theme_switch.setText("🌙");
        prefs.putBoolean("darkMode", true);
        return new Dracula();
    }

    /**
     * @return the currentTheme
     */
    private Theme getCurrentTheme() {
        return currentTheme;
    }

    /**
     * @param currentTheme the currentTheme to set
     */
    private void setCurrentTheme(Theme currentTheme) {
        this.currentTheme = currentTheme;
    }

    private Theme pref_theme() {
        if (prefs.getBoolean("darkMode", false)) {
            return new Dracula();
        }
        return new CupertinoLight();
    }
    
    private static void set_font(Label label, Font font, int size){
        label.setFont(Font.font(font.getName(), size));
    }
}
