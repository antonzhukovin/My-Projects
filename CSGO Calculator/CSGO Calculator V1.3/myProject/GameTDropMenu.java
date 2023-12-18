package myProject;

import java.awt.*;
import java.sql.*;

public class GameTDropMenu extends EasyApp
{
    public static void main(String[] args)
    {  new GameTDropMenu();}

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,800,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Button bDropWeapon1 = addButton("Secondary weapon",400,100,183,100,this);
    Button bDropWeapon2 = addButton("Primary weapon",400,200,183,100,this);
    Button bDropZeus = addButton("Zeus",400,300,183,100,this);
    Button bDropGrenade1 = addButton("Grenade 1",400,400,183,100,this);
    Button bDropGrenade2 = addButton("Grenade 2",400,500,183,100,this);
    Button bDropGrenade3 = addButton("Grenade 3",400,600,183,100,this);
    Button bDropGrenade4 = addButton("Grenade 4",400,700,183,100,this);
    Button bQuitBuyMenuDropMenu = addButton("Go Back",850,750,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,50,30,this);
    Label lRoundNum = addLabel("Round: ",455,800,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);
    
    Label lDropWeapon1 = addLabel("",337,100,62,30,this);
    Label lDropWeapon2 = addLabel("",337,200,62,30,this);
    Label lDropZeus = addLabel("",337,300,62,30,this);
    Label lDropGrenade1 = addLabel("",337,400,62,30,this);
    Label lDropGrenade2 = addLabel("",337,500,62,30,this);
    Label lDropGrenade3 = addLabel("",337,600,62,30,this);
    Label lDropGrenade4 = addLabel("",337,700,62,30,this);

    int RoundCountbuyMenuDrop; 
    int BalancebuyMenuDrop; 
    int RoundCTbuyMenuDrop;
    int RoundTbuyMenuDrop;
    String buyMenuDropWeapon1;
    String buyMenuDropWeapon2;
    String buyMenuDropZeus;
    String buyMenuDropGrenade1;
    String buyMenuDropGrenade2;
    String buyMenuDropGrenade3;
    String buyMenuDropGrenade4;

    public GameTDropMenu(){
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

            ResultSet sqlRoundCountBuyMenuDropMenu =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountBuyMenuDropMenu.next() ){
                String sqlRoundCountstringBuyMenuDropMenu = sqlRoundCountBuyMenuDropMenu.getString(1);
                RoundCountbuyMenuDrop = Integer.parseInt (sqlRoundCountstringBuyMenuDropMenu);}

            ResultSet rsBalanceBuyMenuDropMenu = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalanceBuyMenuDropMenu.next() ){
                String rs1BalancestringBuyMenuDropMenu = rsBalanceBuyMenuDropMenu.getString(1);
                BalancebuyMenuDrop = Integer.parseInt (rs1BalancestringBuyMenuDropMenu);}

            ResultSet sqlRoundCTBuyMenuDropMenu =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTBuyMenuDropMenu.next() ){
                String sqlRoundCTstringBuyMenuDropMenu = sqlRoundCTBuyMenuDropMenu.getString(1);
                RoundCTbuyMenuDrop = Integer.parseInt (sqlRoundCTstringBuyMenuDropMenu);}

            ResultSet sqlRoundTBuyMenuDropMenu =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTBuyMenuDropMenu .next() ){
                String sqlRoundTstringBuyMenuDropMenu = sqlRoundTBuyMenuDropMenu .getString(1);
                RoundTbuyMenuDrop = Integer.parseInt (sqlRoundTstringBuyMenuDropMenu);}

            ResultSet sqlWeapon1BuyMenuDropMenu =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon1BuyMenuDropMenu .next() ){
                buyMenuDropWeapon1 = sqlWeapon1BuyMenuDropMenu .getString(1);
            }
            
            ResultSet sqlWeapon2BuyMenuDropMenu =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon2BuyMenuDropMenu .next() ){
                buyMenuDropWeapon2 = sqlWeapon2BuyMenuDropMenu .getString(1);
            }
            
            ResultSet sqlZeusBuyMenuDropMenu =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlZeusBuyMenuDropMenu .next() ){
                buyMenuDropZeus = sqlZeusBuyMenuDropMenu .getString(1);
            }
            
            ResultSet sqlGrenade1BuyMenuDropMenu =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1BuyMenuDropMenu .next() ){
                buyMenuDropGrenade1 = sqlGrenade1BuyMenuDropMenu .getString(1);
            }
            
            ResultSet sqlGrenade2BuyMenuDropMenu =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2BuyMenuDropMenu .next() ){
                buyMenuDropGrenade2 = sqlGrenade2BuyMenuDropMenu .getString(1);
            }
            
            ResultSet sqlGrenade3BuyMenuDropMenu =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3BuyMenuDropMenu .next() ){
                buyMenuDropGrenade3 = sqlGrenade3BuyMenuDropMenu .getString(1);
            }
            
            ResultSet sqlGrenade4BuyMenuDropMenu =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4BuyMenuDropMenu .next() ){
                buyMenuDropGrenade4 = sqlGrenade4BuyMenuDropMenu .getString(1);
            }

                
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
        setSize(1000,1000);
        setTitle("CS:GO Economy - (c) 2021 Anton Zhukovin, Russia");
        setBackground(new Color(255,255,180));
        tRoundNum.setText(RoundCountbuyMenuDrop +  "");
        tBalance.setText(BalancebuyMenuDrop + "$");
        tCTscore.setText(RoundCTbuyMenuDrop + "");
        tTscore.setText(RoundTbuyMenuDrop + "");
        
        lDropWeapon1.setText(buyMenuDropWeapon1);
        lDropWeapon2.setText(buyMenuDropWeapon2);
        lDropZeus.setText(buyMenuDropZeus);
        lDropGrenade1.setText(buyMenuDropGrenade1);
        lDropGrenade2.setText(buyMenuDropGrenade2);
        lDropGrenade3.setText(buyMenuDropGrenade3);
        lDropGrenade4.setText(buyMenuDropGrenade4);
        
        if(buyMenuDropWeapon1 == null){
            bDropWeapon1.setVisible(false);
        }
        if(buyMenuDropWeapon2 == null){
            bDropWeapon2.setVisible(false);
        }
        if(buyMenuDropZeus == null){
            bDropZeus.setVisible(false);
        }
        if(buyMenuDropGrenade1 == null){
            bDropGrenade1.setVisible(false);
        }
        if(buyMenuDropGrenade2 == null){
            bDropGrenade2.setVisible(false);
        }
        if(buyMenuDropGrenade3 == null){
            bDropGrenade3.setVisible(false);
        }
        if(buyMenuDropGrenade4 == null){
            bDropGrenade4.setVisible(false);
        }
        
    }
    
    public void actions(Object source,String command){
        if (source == bDropWeapon1){
            bDropWeapon1.setEnabled(false);
            buyMenuDropWeapon1 = null;
        }
        if (source == bDropWeapon2){
            bDropWeapon2.setEnabled(false);
            buyMenuDropWeapon2 = null;
        }
        if (source == bDropZeus){
            bDropZeus.setEnabled(false);
            buyMenuDropZeus = null;
        }
        if (source == bDropGrenade1){
            bDropGrenade1.setEnabled(false);
            buyMenuDropGrenade1 = null;
        }
        if (source == bDropGrenade2){
            bDropGrenade2.setEnabled(false);
            buyMenuDropGrenade2 = null;
        }
        if (source == bDropGrenade3){
            bDropGrenade3.setEnabled(false);
            buyMenuDropGrenade3 = null;
        }
        if (source == bDropGrenade4){
            bDropGrenade4.setEnabled(false);
            buyMenuDropGrenade4 = null;
        }
        if (source == bQuitBuyMenuDropMenu){
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
                Statement stmt1 = conn.createStatement() ;
                Statement stmt2 = conn.createStatement() ;

                // Execute the query
                
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Weapon1 = ?, Weapon2 = ?, Grenade1 = ?, Grenade2 = ?, Grenade3 =?, Grenade4 =?, Zeus = ? WHERE idNumCS = 1;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1,buyMenuDropWeapon1);
                preparedStatement.setString(2,buyMenuDropWeapon2);
                preparedStatement.setString(3,buyMenuDropGrenade1);
                preparedStatement.setString(4,buyMenuDropGrenade2);
                preparedStatement.setString(5,buyMenuDropGrenade3);
                preparedStatement.setString(6,buyMenuDropGrenade4);
                preparedStatement.setString(7,buyMenuDropZeus);
                

                preparedStatement.executeUpdate();
                // Loop through the result set

          
                // Close the result set, statement and the connection
                
                stmt1.close() ;
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
            new GameTPickDrop();
            dispose(); 
        }
    }
}
