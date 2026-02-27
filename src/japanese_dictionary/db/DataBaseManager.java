package japanese_dictionary.db;

import japanese_dictionary.model.KanjiList;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author superanand67
 */
public class DataBaseManager {
    //String url = "jdbc:sqlite:/opt/japanesedictionary/lib/app/kanjiDict.db";
    String url = "jdbc:sqlite:kanjiDict.db";
    Connection con;

    public DataBaseManager() {
        try {
           con = DriverManager.getConnection(url);
            System.out.println("Successfully Connected to Database !!!!");
        }
        catch (SQLException e) {
            System.out.println("Error Connecting DataBase !!!");
            e.printStackTrace();
        } 
    }
    
    public List<KanjiList> searchDB(String searchTerm){
        //KanjiList res = null;
        
        List<KanjiList> resultList = new ArrayList<>();
        
        String sqlQuery = "SELECT * FROM kanji_list WHERE kanji = ? OR meaning LIKE ?;";
        
        try {
            PreparedStatement pst = con.prepareStatement(sqlQuery);
                    
            pst.setString(1, searchTerm);
            pst.setString(2, "%" + searchTerm + "%");

            ResultSet rs1 = pst.executeQuery();
            
            while(rs1.next()) {
                 //String k1 = rs1.getString("kanji");
                 //String m1 = rs1.getString("meaning");
                 
                 KanjiList wordlist;
                 wordlist = new KanjiList(rs1.getString("kanji"),
                                          rs1.getString("onyomi"),
                                         rs1.getString("kunyomi"),
                                         rs1.getString("meaning"),
                                         rs1.getInt("strokes"));
                 
                 resultList.add(wordlist);
                 
                }                 
            }
        catch (SQLException e) {
                    System.out.println("Error Connecting DataBase !!!");
                    e.printStackTrace();
         }

         return resultList;
    }
        
    public KanjiList getKanji(String kanjiS){
        
        KanjiList resultWord = null;
        
        String SqlQuery2 = "SELECT * FROM kanji_list WHERE kanji = ?;";
                                
         try {
            PreparedStatement pst2 = con.prepareStatement(SqlQuery2);
            pst2.setString(1, kanjiS);

            ResultSet rs = pst2.executeQuery();
            
            resultWord = new KanjiList(rs.getString("kanji"),
                                          rs.getString("onyomi"),
                                         rs.getString("kunyomi"),
                                         rs.getString("meaning"),
                                         rs.getInt("strokes"));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
         
        return resultWord;
}
    
}
