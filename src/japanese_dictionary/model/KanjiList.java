package japanese_dictionary.model;

/**
 *
 * @author superanand67
 */
public class KanjiList {
    
    private String kanji;
    private String onyomi;
    private String kunyomi;
    private String meaning;
    private int strokes;

    public KanjiList(String kanji, String onyomi, String kunyomi, String meaning, int strokes) {
        this.kanji = kanji;
        this.onyomi = onyomi;
        this.kunyomi = kunyomi;
        this.meaning = meaning;
        this.strokes = strokes;
    }
    
    public KanjiList(String kanji, String meaning) {
        this.kanji = kanji;
        this.meaning = meaning;
    }
    
    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getOnyomi() {
        return onyomi;
    }

    public void setOnyomi(String onyomi) {
        this.onyomi = onyomi;
    }

    public String getKunyomi() {
        return kunyomi;
    }

    public void setKunyomi(String kunyomi) {
        this.kunyomi = kunyomi;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public int getStrokes() {
        return strokes;
    }

    public void setStrokes(int strokes) {
        this.strokes = strokes;
    }
    
    
}
