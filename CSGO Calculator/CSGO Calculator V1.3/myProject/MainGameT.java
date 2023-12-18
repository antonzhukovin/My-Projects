package myProject;
import java.awt.*;
import java.sql.*;

public class MainGameT extends EasyApp //checked, alrught
{
    public static void main(String[] args)
    {  new MainGameT();}

    Label lSide = addLabel("",60,30,225,60,this);

    Button bBuy = addButton("Buy",100,250,266,100,this);
    Button bGame = addButton("Game",366,250,266,100,this);
    Button bResult = addButton("Result",632,250,266,100,this);

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,400,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,50,30,this);
    Label lRoundNum = addLabel("Round: ",455,400,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

   
    int RoundCountMGT;
    int BalanceMGT;
    int RoundCTMGT;
    int RoundTMGT;

    String MainGameTCondition;
    String sqlStringSideChoice;

    public MainGameT()   // Constructor - change window appearance
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

            ResultSet sqlRoundCountMainGameT =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountMainGameT.next() ){
                String sqlRoundCountstringMainGameT = sqlRoundCountMainGameT.getString(1);
                RoundCountMGT = Integer.parseInt (sqlRoundCountstringMainGameT);}

            ResultSet rsBalanceMainGameT = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS = 1;" ) ; 
            // Loop through the result set

            while( rsBalanceMainGameT.next() ){
                String rs1BalancestringMainGameT = rsBalanceMainGameT.getString(1);
                BalanceMGT = Integer.parseInt (rs1BalancestringMainGameT);}

            ResultSet sqlRoundCTMainGameT =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS = 1" ) ;

            while( sqlRoundCTMainGameT.next() ){
                String sqlRoundCTstringMainGameT = sqlRoundCTMainGameT.getString(1);
                RoundCTMGT = Integer.parseInt (sqlRoundCTstringMainGameT);}

            ResultSet sqlRoundTMainGameT =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS = 1" ) ;

            while( sqlRoundTMainGameT .next() ){
                String sqlRoundTstringMainGameT = sqlRoundTMainGameT .getString(1);
                RoundTMGT = Integer.parseInt (sqlRoundTstringMainGameT);}

            ResultSet sqlMainGameTCondition =  stmt.executeQuery( "SELECT MainGameCondition FROM IACompCSGO WHERE idNumCS = 1" ) ;

            while( sqlMainGameTCondition .next() ){
                MainGameTCondition = sqlMainGameTCondition.getString(1);
            }
            
            ResultSet sqlSideChoice =  stmt.executeQuery( "SELECT SideChoice FROM IACompCSGO WHERE idNumCS = 1" ) ;

            while( sqlSideChoice .next() ){
                sqlStringSideChoice = sqlSideChoice.getString(1);
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
        setSize(1000,500);
        setTitle("CS:GO Economy - (c) 2021 Anton Zhukovin, Russia");
        setBackground(new Color(255,255,180));
        bBuy.setFont(new Font("Arial",1,16));     
        bGame.setFont(new Font("Arial",1,16));
        bResult.setFont(new Font("Arial",1,16));
        tRoundNum.setText(RoundCountMGT + "");
        tBalance.setText(BalanceMGT + "$");
        tCTscore.setText(RoundCTMGT + "");
        tTscore.setText(RoundTMGT + "");
        
        if(sqlStringSideChoice.equals("TSide")){
            lSide.setText("You are playing for the T side");
        } else if(sqlStringSideChoice.equals("CTSide")){
            lSide.setText("You are playing for the CT side");
        }

        if(MainGameTCondition.equals("BuyMenu")){
            bBuy.setEnabled(true);
            bGame.setEnabled(false);
            bResult.setEnabled(false);
        }
        if(MainGameTCondition.equals("Game")){
            bGame.setEnabled(true);
            bBuy.setEnabled(false);
            bResult.setEnabled(false);
        }
        if(MainGameTCondition.equals("Result")){
            bResult.setEnabled(true);
            bBuy.setEnabled(false);
            bGame.setEnabled(false);
        }
    }

    public void actions(Object source,String command)
    {   
        if (source == bBuy)
        {   new BuyMenu();
            bBuy.setEnabled(false);
            dispose();}
        if (source == bGame){
            new GameT();
            bGame.setEnabled(false);
            dispose();
        }
        if (source == bResult){
            new ResultMenu();
            bResult.setEnabled(false);
            dispose();
        }
    }

}