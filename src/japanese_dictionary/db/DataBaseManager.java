package japanese_dictionary.db;

import japanese_dictionary.model.KanjiList;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author superanand67
 */
public class DataBaseManager {
    
    // For all Operating Systems
    private String Homeuser = System.getProperty("user.home");
    private String url;
    private File appFolder = new File(Homeuser,".japanesedictionary");
    private File dbFile = new File(appFolder,"kanjiDict.db"); 
    
    // For linux only use
    //String url = "jdbc:sqlite:/opt/japanesedictionary/lib/app/kanjiDict.db";
    
    // for local and testing use
    String urlT = "jdbc:sqlite:kanjiDict.db";
    private Connection con;

    public DataBaseManager() {
        
        try {
           
//           if (!appFolder.exists()) {
//            appFolder.mkdirs();
//            } 
//            
//           if (!dbFile.exists()) {
//                System.out.println("Installing Database .....");
//            
//                InputStream in = getClass().getResourceAsStream("/japanese_dictionary/kanjiDict.db");
//            
//                Files.copy(in, dbFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
//            
//                in.close();
//            } 
           
           url = "jdbc:sqlite:" + dbFile.getAbsolutePath();
           
           con = DriverManager.getConnection(urlT);
            System.out.println("Successfully Connected to Database !!!!");
        }
        catch (Exception e) {
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
            
            if(rs.next()) {
                resultWord = new KanjiList(rs.getString("kanji"),
                                              rs.getString("onyomi"),
                                             rs.getString("kunyomi"),
                                             rs.getString("meaning"),
                                             rs.getInt("strokes"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
         
        return resultWord;
    }

    public void bookmarked(int bm,String kanji){
        String sqlQuery3 = "UPDATE kanji_list SET is_bookmarked = ? WHERE kanji = ?;";
        
        try {
            PreparedStatement pst3 = con.prepareStatement(sqlQuery3);
            
            pst3.setString(1, String.valueOf(bm));
            pst3.setString(2, kanji);
            
            pst3.executeUpdate();
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        }
    
    public List<KanjiList> bookmarks() {
        
        List<KanjiList> bmkList = new ArrayList<>();
        
        String sqlQuery4 = "SELECT * FROM kanji_list WHERE is_bookmarked = 1;";
        
        try {
            PreparedStatement pst4 = con.prepareStatement(sqlQuery4);
            
            ResultSet bmks = pst4.executeQuery();
            
            while(bmks.next()) {
                KanjiList BookmarksList;
                
                BookmarksList = new KanjiList(bmks.getString("kanji"),
                                               bmks.getString("onyomi"),
                                              bmks.getString("kunyomi"),
                                              bmks.getString("meaning"),
                                              bmks.getInt("strokes"));
                               
                bmkList.add(BookmarksList);
            }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return bmkList;
    }
    
    public boolean BmkBtn(String k) {
        
        String sqlQuery5 = "SELECT * FROM kanji_list WHERE kanji = ?;";
        
        try {
            PreparedStatement pst5 = con.prepareStatement(sqlQuery5);
            
            pst5.setString(1, k);
            
            ResultSet Btn = pst5.executeQuery();
            
            return Btn.getInt("is_bookmarked") == 1;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
            
        }
        
    }
    
}
