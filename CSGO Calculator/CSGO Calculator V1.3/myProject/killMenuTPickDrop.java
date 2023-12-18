package myProject;

import java.awt.*;
import java.sql.*;

public class killMenuTPickDrop extends EasyApp
{
    public static void main(String[] args)
    {  new killMenuTPickDrop();}

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,650,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Button bDropChoice = addButton("Did you drop a weapon?",100,300,798,100,this);
    Button bPickChoice = addButton("Did you pick a weapon?",100,400,798,100,this);
    Button bQuitKillMenuTPickDrop = addButton("Go Back",850,600,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,50,30,this);
    Label lRoundNum = addLabel("Round: ",455,650,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    int RoundCountkillMenuTPickDrop; 
    int BalancekillMenuTPickDrop; 
    int RoundCTkillMenuTPickDrop;
    int RoundTkillMenuTPickDrop; 

    public killMenuTPickDrop(){
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

            ResultSet sqlRoundCountkillMenuTPickDrop =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountkillMenuTPickDrop.next() ){
                String sqlRoundCountstringkillMenuTPickDrop = sqlRoundCountkillMenuTPickDrop.getString(1);
                RoundCountkillMenuTPickDrop = Integer.parseInt (sqlRoundCountstringkillMenuTPickDrop);}

            ResultSet rsBalancekillMenuTPickDrop = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalancekillMenuTPickDrop.next() ){
                String rs1BalancestringkillMenuTPickDrop = rsBalancekillMenuTPickDrop.getString(1);
                BalancekillMenuTPickDrop = Integer.parseInt (rs1BalancestringkillMenuTPickDrop);}

            ResultSet sqlRoundCTkillMenuTPickDrop =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTkillMenuTPickDrop.next() ){
                String sqlRoundCTstringkillMenuTPickDrop = sqlRoundCTkillMenuTPickDrop.getString(1);
                RoundCTkillMenuTPickDrop = Integer.parseInt (sqlRoundCTstringkillMenuTPickDrop);}

            ResultSet sqlRoundTkillMenuTPickDrop =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTkillMenuTPickDrop .next() ){
                String sqlRoundTstringkillMenuTPickDrop = sqlRoundTkillMenuTPickDrop .getString(1);
                RoundTkillMenuTPickDrop = Integer.parseInt (sqlRoundTstringkillMenuTPickDrop);}

                
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
        tRoundNum.setText(RoundCountkillMenuTPickDrop +  "");
        tBalance.setText(BalancekillMenuTPickDrop + "$");
        tCTscore.setText(RoundCTkillMenuTPickDrop + "");
        tTscore.setText(RoundTkillMenuTPickDrop + "");
    }
    
    public void actions(Object source,String command){
        if (source == bQuitKillMenuTPickDrop )
        {
            new killMenuT();
            dispose(); 
        }
        if (source == bDropChoice)
        {
            new killMenuTDropMenu();
            dispose(); 
        }
        if (source == bPickChoice)
        {
            new killMenuTPickMenu();
            dispose(); 
        }
    }
}
