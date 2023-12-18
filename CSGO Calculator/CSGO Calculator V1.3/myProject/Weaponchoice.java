package myProject;

import java.awt.*;
import java.sql.*;

public class Weaponchoice extends EasyApp
{
    public static void main(String[] args)
    { 
        new Weaponchoice();
        }

    Label lSide = addLabel("You are playing for T-side",60,30,225,60,this);
    Label lSide1 = addLabel("What was your choice before the game for T-side?",60,80,500,30,this);
    Label lSide2 = addLabel("What was your choice before the game for CT-side?",600,80,500,30,this);

    Label lOR = addLabel("OR",200,190,20,17,this);
    Label lOR2 = addLabel("OR",200,290,20,17,this);
    Label lOR3 = addLabel("OR",200,390,20,17,this);

    Label lOR4 = addLabel("OR",750,190,20,17,this);
    Label lOR5 = addLabel("OR",750,290,20,17,this);
    Label lOR6 = addLabel("OR",750,390,20,17,this);
    Label lOR7 = addLabel("OR",750,490,20,17,this);
    Label lOR8 = addLabel("OR",750,590,20,17,this);

    Button bChoiceTCZ75 = addButton("CZ75-Auto",50,150,150,100,this);
    Button bChoiceTTec9 = addButton("Tec-9",220,150,150,100,this);
    Button bChoiceTDesertEagle = addButton("Desert Eagle",50,250,150,100,this);
    Button bChoiceTR8Revolver = addButton("R8 Revolver",220,250,150,100,this);
    Button bChoiceTMP5SD = addButton("MP5-SD",50,350,150,100,this);
    Button bChoiceTMP7 = addButton("MP7",220,350,150,100,this);

    Button bChoiceCTUSPS = addButton("USP-S",600,150,150,100,this);
    Button bChoiceCTP2000 = addButton("P2000",770,150,150,100,this);
    Button bChoiceCTDesertEagle = addButton("Desert Eagle",600,250,150,100,this);
    Button bChoiceCTR8Revolver = addButton("R8 Revolver",770,250,150,100,this);
    Button bChoiceCTCZ75 = addButton("CZ75-Auto",600,350,150,100,this);
    Button bChoiceCTFiveSeveN = addButton("Five-SeveN",770,350,150,100,this);
    Button bChoiceCTMP5SD = addButton("MP5-SD",600,450,150,100,this);
    Button bChoiceCTMP7 = addButton("MP7",770,450,150,100,this);
    Button bChoiceCTM4A4 = addButton("M4A4",600,550,150,100,this);
    Button bChoiceCTM4A1S = addButton("M4A1-S",770,550,150,100,this);
    
    Button bQuitWeaponMenu = addButton("Go Back",150,550,150,100,this);

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,650,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,50,30,this);
    Label lRoundNum = addLabel("Round: ",455,650,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);
    
    int WeaponchoiceConditionCount = 0;
    static boolean eightweaponcondition = false;
    
    
    int RoundCTWeaponchoice;
    int RoundTWeaponchoice;
    int RoundCountWeaponchoice;
    int BalanceWeaponchoice; 
    
    //new 
    
    String TCZ75orTec9string; 
    String TDeagleORr8string;
    String Tmp5SDorMP7string;
    String CTuspsORp2000string;
    String CTDeagleORr8string;
    String CTCZ75or57string;
    String CTmp5SDorMP7string;
    String CTM4a4orM4a1sstring; 
    
    //endnew
    
    public Weaponchoice()   // Constructor - change window appearance
    {
        try //workon
        {
            // Load the database driver
            Class.forName( "com.mysql.jdbc.Driver" ) ;

            // Get a connection to the database
            Connection conn = DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3306/CSGOSchema?user=root&password=administrator" ) ;

            // Print all warnings
            for( SQLWarning warn = conn.getWarnings(); warn != null; warn = warn.getNextWarning() )
            {
                System.out.println( "SQL Warning:" ) ;
                System.out.println( "State  : " + warn.getSQLState()  ) ;
                System.out.println( "Message: " + warn.getMessage()   ) ;
                System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

            // Get a statement from the connection
            Statement stmt = conn.createStatement() ;

            // Execute the query
            
            ResultSet sqlRoundCountWeaponchoice =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later
                
            while( sqlRoundCountWeaponchoice.next() ){
                String sqlRoundCountstringWeaponchoice = sqlRoundCountWeaponchoice.getString(1);
                RoundCountWeaponchoice = Integer.parseInt (sqlRoundCountstringWeaponchoice);}

            ResultSet rsBalanceWeaponchoice = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS = "+RoundCountWeaponchoice+";" ) ; 
            // Loop through the result set

            while( rsBalanceWeaponchoice.next() ){
                String rs1BalancestringWeaponchoice = rsBalanceWeaponchoice.getString(1);
                BalanceWeaponchoice = Integer.parseInt (rs1BalancestringWeaponchoice);}
                
            ResultSet sqlRoundCTWeaponchoice =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS = "+RoundCountWeaponchoice+";" ) ;
            
            while( sqlRoundCTWeaponchoice.next() ){
                String sqlRoundCTstringWeaponchoice = sqlRoundCTWeaponchoice.getString(1);
                RoundCTWeaponchoice = Integer.parseInt (sqlRoundCTstringWeaponchoice);}
            
            ResultSet sqlRoundTWeaponchoice =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS = "+RoundCountWeaponchoice+";" ) ;
            
            while( sqlRoundTWeaponchoice .next() ){
                String sqlRoundTstringWeaponchoice = sqlRoundTWeaponchoice .getString(1);
                RoundTWeaponchoice = Integer.parseInt (sqlRoundTstringWeaponchoice);}
            
            
                
            // Close the result set, statement and the connection
            
            stmt.close() ;
            conn.close() ;
        }
        catch( SQLException se )
        {
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
            {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e )
        {
            System.out.println( e ) ;
        }
        setSize(1000,700);
        setTitle("CS:GO Economy - (c) 2021 Anton Zhukovin, Russia");
        setBackground(new Color(255,255,180));
        tRoundNum.setText(RoundCountWeaponchoice +  "");
        tBalance.setText(BalanceWeaponchoice + "$");
        tCTscore.setText(RoundCTWeaponchoice + "");
        tTscore.setText(RoundTWeaponchoice + "");
        bQuitWeaponMenu.setEnabled(false);
    }
    
    
   

    public void actions(Object source,String command)
    {   
        
        if (source == bChoiceTCZ75){
            bChoiceTTec9.setEnabled(false);
            //new1
            
            TCZ75orTec9string = "TCZ75";
            
            //endnew1
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }
        if(source == bChoiceTTec9){
            bChoiceTCZ75.setEnabled(false);
            //new2
            
            TCZ75orTec9string = "TTec9";
            
            //endnew2
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }
        if (source == bChoiceTDesertEagle){ //Button to choose the Desert Eagle 
            bChoiceTR8Revolver.setEnabled(false); //The button to choose substitute weapon (R8 Revolver) is disabled
            
            
            TDeagleORr8string = "TDeagle"; //Sets the value for String to store the user's selection in MySQL later on. 
            
            
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1; //in order to enable the quit button from this menu, should be equal to 8
        }else if(source == bChoiceTR8Revolver){ //Button to choose R8 Revolver 
            bChoiceTDesertEagle.setEnabled(false); //The button to choose substitute weapon (Desert Eagle ) is disabled
            
            
            TDeagleORr8string = "TR8"; //Sets the value for String to store the user's selection in MySQL later on.
            
            
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1; //in order to enable the quit button from this menu, should be equal to 8
        }
        if (source == bChoiceTMP5SD){
            bChoiceTMP7.setEnabled(false);
            //new4
            
            Tmp5SDorMP7string = "TMP5SD";
            
            //endnew4
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }else if(source == bChoiceTMP7){
            bChoiceTMP5SD.setEnabled(false);
            //new5
            
            Tmp5SDorMP7string = "TMP7";
            
            //endnew5
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }
        if (source == bChoiceCTUSPS){
            bChoiceCTP2000.setEnabled(false);
            //new6
            
            CTuspsORp2000string = "CTUSPS";
            
            //endnew6
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }else if(source == bChoiceCTP2000){
            bChoiceCTUSPS.setEnabled(false);
            //new7
            
            CTuspsORp2000string = "CTP2000";
            
            //endnew7
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }
        if (source == bChoiceCTDesertEagle){
            bChoiceCTR8Revolver.setEnabled(false);
            //new8
            
            CTDeagleORr8string = "CTDeagle";
            
            //endnew8
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }else if(source == bChoiceCTR8Revolver){
            bChoiceCTDesertEagle.setEnabled(false);
            //new9
            
            CTDeagleORr8string = "CTR8";
            
            //endnew9
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }
        if (source == bChoiceCTCZ75){
            bChoiceCTFiveSeveN.setEnabled(false);
            //new10
            
            CTCZ75or57string = "CTCZ75";
            
            //endnew10
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }else if(source == bChoiceCTFiveSeveN){
            bChoiceCTCZ75.setEnabled(false);
            //new11
            
            CTCZ75or57string = "CT57";
            
            //endnew11
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }
        if (source == bChoiceCTMP5SD){
            bChoiceCTMP7.setEnabled(false);
            //new12
            
            CTmp5SDorMP7string = "CTMP5SD";
            
            //endnew12
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }else if(source == bChoiceCTMP7){
            bChoiceCTMP5SD.setEnabled(false);
            //new13
            
            CTmp5SDorMP7string = "CTMP7";
            
            //endnew13
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }
        if (source == bChoiceCTM4A4){
            bChoiceCTM4A1S.setEnabled(false);
            //new14
            
            CTM4a4orM4a1sstring = "CTM4A4";
            
            //endnew14
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }else if(source == bChoiceCTM4A1S){
            bChoiceCTM4A4.setEnabled(false);
            //new15
            
            CTM4a4orM4a1sstring = "CTM4A1S";
            
            //endnew15
            WeaponchoiceConditionCount = WeaponchoiceConditionCount + 1;
        }
        if(WeaponchoiceConditionCount == 8){
            bQuitWeaponMenu.setEnabled(true);
        }
        if (source == bQuitWeaponMenu){
            try
            {
                // Load the database driver
                Class.forName( "com.mysql.jdbc.Driver" ) ;

                // Get a connection to the database
                Connection conn = DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3306/CSGOSchema?user=root&password=administrator" ) ;

                // Print all warnings
                for( SQLWarning warn = conn.getWarnings(); warn != null; warn = warn.getNextWarning() )
                {
                    System.out.println( "SQL Warning:" ) ;
                    System.out.println( "State  : " + warn.getSQLState()  ) ;
                    System.out.println( "Message: " + warn.getMessage()   ) ;
                    System.out.println( "Error  : " + warn.getErrorCode() ) ;
                }

                // Get a statement from the connection
                Statement stmt = conn.createStatement() ;

                // Execute the query
                
                
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET WeaponChoiceCondition = ?, TCZ75orTec9 = ?, TDeagleORr8 = ?, Tmp5SDorMP7 = ?, CTuspsORp2000 = ?,CTDeagleORr8 = ?, CTCZ75or57 = ?, CTmp5SDorMP7 = ?, CTM4a4orM4a1s = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, "True");
                
                //new 16
                preparedStatement.setString(2, TCZ75orTec9string);
                preparedStatement.setString(3, TDeagleORr8string);
                preparedStatement.setString(4, Tmp5SDorMP7string);
                preparedStatement.setString(5, CTuspsORp2000string);
                preparedStatement.setString(6, CTDeagleORr8string);
                preparedStatement.setString(7, CTCZ75or57string);
                preparedStatement.setString(8, CTmp5SDorMP7string);
                preparedStatement.setString(9, CTM4a4orM4a1sstring);
                //endnew 16
                

                preparedStatement.executeUpdate();
                // Loop through the result set

          
                // Close the result set, statement and the connection
                
                stmt.close() ;
                conn.close();
            }
            catch( SQLException se )
            {
                System.out.println( "SQL Exception:" ) ;

                // Loop through the SQL Exceptions
                while( se != null )
                {
                    System.out.println( "State  : " + se.getSQLState()  ) ;
                    System.out.println( "Message: " + se.getMessage()   ) ;
                    System.out.println( "Error  : " + se.getErrorCode() ) ;

                    se = se.getNextException() ;
                }
            }
            catch( Exception e )
            {
                System.out.println( e ) ;
            }
            new BuyMenu();
            dispose();
        }
    }
}
