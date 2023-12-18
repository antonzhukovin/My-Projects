package myProject;

import java.awt.*;
import java.sql.*;

public class BuyMenu extends EasyApp
{
    public static void main(String[] args)
    {  new BuyMenu();}

    Label lSide = addLabel("",60,30,225,60,this);

    Button bPrimaryWeapons = addButton("Weapons",100,100,798,200,this);
    Button bWeaponDrop = addButton("Weapon Drop/Pick",100,300,798,100,this);
    Button bWeaponChoice = addButton("Weapon Choice",100,400,798,100,this);
    Button bQuitBuyMenu = addButton("Go Back",850,600,150,100,this);

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",505,510,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,50,30,this);
    Label lRoundNum = addLabel("Round: ",455,510,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);
    
    int RoundCTBuyMenu;
    int RoundTBuyMenu;
    int RoundCountBuyMenu;
    int BalanceBuyMenu;
    String buyMenuWeapon1PistolsSQLstring; 
    String sqlStringWeaponChoiceCondition;
    String sqlSideChoiceString; 
    String sqlPistolsConditionString; 
    String sqlWeaponPickDropString;
    
    
    public BuyMenu()   // Constructor - change window appearance
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
            
            ResultSet sqlRoundCountBuyMenu =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later
                
            while( sqlRoundCountBuyMenu.next() ){
                String sqlRoundCountstringBuyMenu = sqlRoundCountBuyMenu.getString(1);
                RoundCountBuyMenu = Integer.parseInt (sqlRoundCountstringBuyMenu);}

            ResultSet rsBalanceBuyMenu = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalanceBuyMenu.next() ){
                String rs1BalancestringBuyMenu = rsBalanceBuyMenu.getString(1);
                BalanceBuyMenu = Integer.parseInt (rs1BalancestringBuyMenu);}
                
            ResultSet sqlRoundCTBuyMenu =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;
            
            while( sqlRoundCTBuyMenu.next() ){
                String sqlRoundCTstringBuyMenu = sqlRoundCTBuyMenu.getString(1);
                RoundCTBuyMenu = Integer.parseInt (sqlRoundCTstringBuyMenu);}
            
            ResultSet sqlRoundTBuyMenu =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;
            
            while( sqlRoundTBuyMenu.next() ){
                String sqlRoundTstringBuyMenu = sqlRoundTBuyMenu .getString(1);
                RoundTBuyMenu = Integer.parseInt (sqlRoundTstringBuyMenu);}
            
            ResultSet sqlWeaponChoiceCondition =  stmt.executeQuery( "SELECT WeaponChoiceCondition FROM IACompCSGO WHERE idNumCS = 1;" ) ;
            
            while( sqlWeaponChoiceCondition.next() ){
                sqlStringWeaponChoiceCondition = sqlWeaponChoiceCondition.getString(1);}
                
            ResultSet sqlSideChoice =  stmt.executeQuery( "SELECT SideChoice FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlSideChoice .next() ){
                sqlSideChoiceString = sqlSideChoice.getString(1);
            }
            
            //finish
            ResultSet sqlPistolCondtion =  stmt.executeQuery( "SELECT PistolsCondition FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlPistolCondtion .next() ){
                sqlPistolsConditionString = sqlPistolCondtion.getString(1);
            }
            //finish
            
            ResultSet sqlWeapon1 =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;
            while( sqlWeapon1.next() ){
                String buyMenuWeapon1PistolsSQLstring = sqlWeapon1.getString(1);}
                
            
                
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

        tRoundNum.setText(RoundCountBuyMenu + "");
        tBalance.setText(BalanceBuyMenu + "$");
        tCTscore.setText(RoundCTBuyMenu + "");
        tTscore.setText(RoundTBuyMenu + "");
        
        if(sqlSideChoiceString.equals("CTSide")){
            lSide.setText("You are playing for the CT side");
        }else if (sqlSideChoiceString.equals("TSide")){
            lSide.setText("You are playing for the T side");
        }
        if(sqlStringWeaponChoiceCondition.equals("False")){
            bPrimaryWeapons.setEnabled(false);
            bWeaponDrop.setEnabled(false);
            bWeaponChoice.setEnabled(true);
        }else if (sqlStringWeaponChoiceCondition.equals("True")){
            bWeaponChoice.setEnabled(false);
        }
        if(sqlPistolsConditionString.equals("False")){
            bQuitBuyMenu.setEnabled(false);
            bWeaponDrop.setEnabled(false);
        }else if(sqlPistolsConditionString.equals("True")){
            bQuitBuyMenu.setEnabled(true);
            bWeaponDrop.setEnabled(true);
        }
        
        
        
    }

    public void actions(Object source,String command)
    {   
        if (source == bWeaponChoice)
          {   new Weaponchoice();
              dispose();
        }
        if (source == bWeaponDrop)
          {   new buyMenuPickDrop();
              dispose();
        }
        if (source == bPrimaryWeapons)
          {   
              dispose();
              new Pistols();
        }
        if (source == bQuitBuyMenu)
        {
            new MainGameT();
            dispose(); 
        }
    }

}
