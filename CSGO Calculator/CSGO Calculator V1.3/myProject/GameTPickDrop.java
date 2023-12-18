package myProject;

import java.awt.*;
import java.sql.*;

public class GameTPickDrop extends EasyApp
{
    public static void main(String[] args)
    {  new GameTPickDrop();}

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,650,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Button bDropChoice = addButton("Did you drop a weapon?",100,300,798,100,this);
    Button bPickChoice = addButton("Did you pick a weapon?",100,400,798,100,this);
    Button bQuitBuyMenu = addButton("Go Back",850,600,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,50,30,this);
    Label lRoundNum = addLabel("Round: ",455,650,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    int RoundCountbuyMenuPickDrop; 
    int BalancebuyMenuPickDrop; 
    int RoundCTbuyMenuPickDrop;
    int RoundTbuyMenuPickDrop; 

    public GameTPickDrop(){
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

            ResultSet sqlRoundCountbuyMenuPickDrop =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountbuyMenuPickDrop.next() ){
                String sqlRoundCountstringbuyMenuPickDrop = sqlRoundCountbuyMenuPickDrop.getString(1);
                RoundCountbuyMenuPickDrop = Integer.parseInt (sqlRoundCountstringbuyMenuPickDrop);}

            ResultSet rsBalancebuyMenuPickDrop = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalancebuyMenuPickDrop.next() ){
                String rs1BalancestringbuyMenuPickDrop = rsBalancebuyMenuPickDrop.getString(1);
                BalancebuyMenuPickDrop = Integer.parseInt (rs1BalancestringbuyMenuPickDrop);}

            ResultSet sqlRoundCTbuyMenuPickDrop =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTbuyMenuPickDrop.next() ){
                String sqlRoundCTstringbuyMenuPickDrop = sqlRoundCTbuyMenuPickDrop.getString(1);
                RoundCTbuyMenuPickDrop = Integer.parseInt (sqlRoundCTstringbuyMenuPickDrop);}

            ResultSet sqlRoundTbuyMenuPickDrop =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTbuyMenuPickDrop .next() ){
                String sqlRoundTstringbuyMenuPickDrop = sqlRoundTbuyMenuPickDrop .getString(1);
                RoundTbuyMenuPickDrop = Integer.parseInt (sqlRoundTstringbuyMenuPickDrop);}

                
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
        tRoundNum.setText(RoundCountbuyMenuPickDrop +  "");
        tBalance.setText(BalancebuyMenuPickDrop + "$");
        tCTscore.setText(RoundCTbuyMenuPickDrop + "");
        tTscore.setText(RoundTbuyMenuPickDrop + "");
    }
    
    public void actions(Object source,String command){
        if (source == bQuitBuyMenu)
        {
            new GameT();
            dispose(); 
        }
        if (source == bDropChoice)
        {
            new GameTDropMenu();
            dispose(); 
        }
        if (source == bPickChoice)
        {
            new GameTPickMenu();
            dispose(); 
        }
    }
}
