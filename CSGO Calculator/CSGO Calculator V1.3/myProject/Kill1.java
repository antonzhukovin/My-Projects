package myProject;

import java.awt.*;
import java.sql.*;

public class Kill1 extends EasyApp
{
    public static void main(String[] args)
    {  new Kill1();}

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,50,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Button bKill1Weapon1 = addButton("Secondary weapon",400,90,183,50,this);
    Button bKill1Weapon2 = addButton("Primary weapon",400,140,183,50,this);
    Button bKill1Zeus = addButton("Zeus",400,190,183,50,this);
    Button bKill1Grenade1 = addButton("Grenade 1",400,240,183,50,this);
    Button bKill1Grenade2 = addButton("Grenade 2",400,290,183,50,this);
    Button bKill1Grenade3 = addButton("Grenade 3",400,340,183,50,this);
    Button bKill1Grenade4 = addButton("Grenade 4",400,390,183,50,this);
    Button bKill1Knife = addButton("Knife",400,440,183,50,this);

    Button bQuitkillMenuKill1Menu = addButton("Go Back",830,550,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,10,30,this);
    Label lRoundNum = addLabel("Round: ",455,50,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    Label lKill1Weapon1 = addLabel("",337,100,62,30,this);
    Label lKill1Weapon2 = addLabel("",337,200,62,30,this);
    Label lKill1Zeus = addLabel("",337,300,62,30,this);
    Label lKill1Grenade1 = addLabel("",337,400,62,30,this);
    Label lKill1Grenade2 = addLabel("",337,500,62,30,this);
    Label lKill1Grenade3 = addLabel("",337,600,62,30,this);
    Label lKill1Grenade4 = addLabel("",337,700,62,30,this);

    int RoundCountkillMenuKill1; 
    int BalancekillMenuKill1; 
    int RoundCTkillMenuKill1;
    int RoundTkillMenuKill1;
    String killMenuKill1Weapon1;
    String killMenuKill1Weapon2;
    String killMenuKill1Zeus;
    String killMenuKill1Grenade1;
    String killMenuKill1Grenade2;
    String killMenuKill1Grenade3;
    String killMenuKill1Grenade4;

    public Kill1(){
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

            ResultSet sqlRoundCountkillMenuKill1Menu =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountkillMenuKill1Menu.next() ){
                String sqlRoundCountstringkillMenuKill1Menu = sqlRoundCountkillMenuKill1Menu.getString(1);
                RoundCountkillMenuKill1 = Integer.parseInt (sqlRoundCountstringkillMenuKill1Menu);}

            ResultSet rsBalancekillMenuKill1Menu = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalancekillMenuKill1Menu.next() ){
                String rs1BalancestringkillMenuKill1Menu = rsBalancekillMenuKill1Menu.getString(1);
                BalancekillMenuKill1 = Integer.parseInt (rs1BalancestringkillMenuKill1Menu);}

            ResultSet sqlRoundCTkillMenuKill1Menu =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTkillMenuKill1Menu.next() ){
                String sqlRoundCTstringkillMenuKill1Menu = sqlRoundCTkillMenuKill1Menu.getString(1);
                RoundCTkillMenuKill1 = Integer.parseInt (sqlRoundCTstringkillMenuKill1Menu);}

            ResultSet sqlRoundTkillMenuKill1Menu =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTkillMenuKill1Menu .next() ){
                String sqlRoundTstringkillMenuKill1Menu = sqlRoundTkillMenuKill1Menu .getString(1);
                RoundTkillMenuKill1 = Integer.parseInt (sqlRoundTstringkillMenuKill1Menu);}

            ResultSet sqlWeapon1killMenuKill1Menu =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon1killMenuKill1Menu .next() ){
                killMenuKill1Weapon1 = sqlWeapon1killMenuKill1Menu .getString(1);
            }

            ResultSet sqlWeapon2killMenuKill1Menu =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon2killMenuKill1Menu .next() ){
                killMenuKill1Weapon2 = sqlWeapon2killMenuKill1Menu .getString(1);
            }

            ResultSet sqlZeuskillMenuKill1Menu =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlZeuskillMenuKill1Menu .next() ){
                killMenuKill1Zeus = sqlZeuskillMenuKill1Menu .getString(1);
            }

            ResultSet sqlGrenade1killMenuKill1Menu =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1killMenuKill1Menu .next() ){
                killMenuKill1Grenade1 = sqlGrenade1killMenuKill1Menu .getString(1);
            }

            ResultSet sqlGrenade2killMenuKill1Menu =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2killMenuKill1Menu .next() ){
                killMenuKill1Grenade2 = sqlGrenade2killMenuKill1Menu .getString(1);
            }

            ResultSet sqlGrenade3killMenuKill1Menu =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3killMenuKill1Menu .next() ){
                killMenuKill1Grenade3 = sqlGrenade3killMenuKill1Menu .getString(1);
            }

            ResultSet sqlGrenade4killMenuKill1Menu =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4killMenuKill1Menu .next() ){
                killMenuKill1Grenade4 = sqlGrenade4killMenuKill1Menu .getString(1);
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
        tRoundNum.setText(RoundCountkillMenuKill1 +  "");
        tBalance.setText(BalancekillMenuKill1 + "$");
        tCTscore.setText(RoundCTkillMenuKill1 + "");
        tTscore.setText(RoundTkillMenuKill1 + "");

        lKill1Weapon1.setText(killMenuKill1Weapon1);
        lKill1Weapon2.setText(killMenuKill1Weapon2);
        lKill1Zeus.setText(killMenuKill1Zeus);
        lKill1Grenade1.setText(killMenuKill1Grenade1);
        lKill1Grenade2.setText(killMenuKill1Grenade2);
        lKill1Grenade3.setText(killMenuKill1Grenade3);
        lKill1Grenade4.setText(killMenuKill1Grenade4);
        
        bQuitkillMenuKill1Menu.setEnabled(false);

        if(killMenuKill1Weapon1 == null){
            bKill1Weapon1.setEnabled(false);
        }
        if(killMenuKill1Weapon2 == null){
            bKill1Weapon2.setEnabled(false);
        }
        if(killMenuKill1Zeus == null){
            bKill1Zeus.setEnabled(false);
        }
        if(killMenuKill1Grenade1 == null){
            bKill1Grenade1.setEnabled(false);
        }
        if(killMenuKill1Grenade2 == null){
            bKill1Grenade2.setEnabled(false);
        }
        if(killMenuKill1Grenade3 == null){
            bKill1Grenade3.setEnabled(false);
        }
        if(killMenuKill1Grenade4 == null){
            bKill1Grenade4.setEnabled(false);
        }

    }

    public void actions(Object source,String command){
        if (source == bKill1Weapon1){

            if(killMenuKill1Weapon1.equals("Glock-18")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon1.equals("Dual Berettas")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon1.equals("P250")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon1.equals("CZ75-Auto")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 100;
            }
            if(killMenuKill1Weapon1.equals("Desert Eagle")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon1.equals("R8 Revolver")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon1.equals("Tec-9")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon1.equals("USP-S")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon1.equals("P2000")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon1.equals("Five-SeveN")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            
            if(BalancekillMenuKill1 > 16000){
                BalancekillMenuKill1 = 16000;
            }
            
            tBalance.setText(BalancekillMenuKill1 + "$");
            bKill1Weapon1.setEnabled(false);
            bKill1Weapon2.setEnabled(false);
            bKill1Zeus.setEnabled(false);
            bKill1Grenade1.setEnabled(false);
            bKill1Grenade2.setEnabled(false);
            bKill1Grenade3.setEnabled(false);
            bKill1Grenade4.setEnabled(false);
            bQuitkillMenuKill1Menu.setEnabled(true);
            bKill1Knife.setEnabled(false);
        }
        if (source == bKill1Weapon2){
            
            if(killMenuKill1Weapon2.equals("MAC-10")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 600;
            }
            if(killMenuKill1Weapon2.equals("MP5-SD")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 600;
            }
            if(killMenuKill1Weapon2.equals("MP7")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 600;
            }
            if(killMenuKill1Weapon2.equals("UMP-45")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 600;
            }
            if(killMenuKill1Weapon2.equals("P90")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("PP-Bizon")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 600;
            }
            if(killMenuKill1Weapon2.equals("MP9")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 600;
            }
            
            if(killMenuKill1Weapon2.equals("Galil AR")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("AK-47")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("SSG 08")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("SG 553")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("AWP")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 100;
            }
            if(killMenuKill1Weapon2.equals("G3SG1")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("FAMAS")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("M4A4")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("M4A1-S")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("AUG")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("SCAR-20")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            
            if(killMenuKill1Weapon2.equals("Nova")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 900;
            }
            if(killMenuKill1Weapon2.equals("XM1014")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 900;
            }
            if(killMenuKill1Weapon2.equals("Sawed-Off")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 900;
            }
            if(killMenuKill1Weapon2.equals("M249")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("Negev")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            }
            if(killMenuKill1Weapon2.equals("MAG-7")){
                BalancekillMenuKill1 = BalancekillMenuKill1 + 900;
            }
            if(BalancekillMenuKill1 > 16000){
                BalancekillMenuKill1 = 16000;
            }
            tBalance.setText(BalancekillMenuKill1 + "$");
            bKill1Weapon1.setEnabled(false);
            bKill1Weapon2.setEnabled(false);
            bKill1Zeus.setEnabled(false);
            bKill1Grenade1.setEnabled(false);
            bKill1Grenade2.setEnabled(false);
            bKill1Grenade3.setEnabled(false);
            bKill1Grenade4.setEnabled(false);
            bKill1Knife.setEnabled(false);
            bQuitkillMenuKill1Menu.setEnabled(true);
        }
        if (source == bKill1Zeus){
            bKill1Weapon1.setEnabled(false);
            bKill1Weapon2.setEnabled(false);
            bKill1Zeus.setEnabled(false);
            bKill1Grenade1.setEnabled(false);
            bKill1Grenade2.setEnabled(false);
            bKill1Grenade3.setEnabled(false);
            bKill1Grenade4.setEnabled(false);
            bKill1Knife.setEnabled(false);
            bQuitkillMenuKill1Menu.setEnabled(true);
            killMenuKill1Zeus = null;
        }
        if (source == bKill1Grenade1){
            BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            if(BalancekillMenuKill1 > 16000){
                BalancekillMenuKill1 = 16000;
            }
            tBalance.setText(BalancekillMenuKill1 + "$");
            bKill1Weapon1.setEnabled(false);
            bKill1Weapon2.setEnabled(false);
            bKill1Zeus.setEnabled(false);
            bKill1Grenade1.setEnabled(false);
            bKill1Grenade2.setEnabled(false);
            bKill1Grenade3.setEnabled(false);
            bKill1Grenade4.setEnabled(false);
            bKill1Knife.setEnabled(false);
            bQuitkillMenuKill1Menu.setEnabled(true);
            killMenuKill1Grenade1 = null;
        }
        if (source == bKill1Grenade2){
            BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            if(BalancekillMenuKill1 > 16000){
                BalancekillMenuKill1 = 16000;
            }
            tBalance.setText(BalancekillMenuKill1 + "$");
            bKill1Weapon1.setEnabled(false);
            bKill1Weapon2.setEnabled(false);
            bKill1Zeus.setEnabled(false);
            bKill1Grenade1.setEnabled(false);
            bKill1Grenade2.setEnabled(false);
            bKill1Grenade3.setEnabled(false);
            bKill1Grenade4.setEnabled(false);
            bKill1Knife.setEnabled(false);
            bQuitkillMenuKill1Menu.setEnabled(true);
            killMenuKill1Grenade2 = null;
        }
        if (source == bKill1Grenade3){
            BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            if(BalancekillMenuKill1 > 16000){
                BalancekillMenuKill1 = 16000;
            }
            tBalance.setText(BalancekillMenuKill1 + "$");
            bKill1Weapon1.setEnabled(false);
            bKill1Weapon2.setEnabled(false);
            bKill1Zeus.setEnabled(false);
            bKill1Grenade1.setEnabled(false);
            bKill1Grenade2.setEnabled(false);
            bKill1Grenade3.setEnabled(false);
            bKill1Grenade4.setEnabled(false);
            bKill1Knife.setEnabled(false);
            bQuitkillMenuKill1Menu.setEnabled(true);
            killMenuKill1Grenade3 = null;
        }
        if (source == bKill1Grenade4){
            BalancekillMenuKill1 = BalancekillMenuKill1 + 300;
            if(BalancekillMenuKill1 > 16000){
                BalancekillMenuKill1 = 16000;
            }
            tBalance.setText(BalancekillMenuKill1 + "$");
            bKill1Weapon1.setEnabled(false);
            bKill1Weapon2.setEnabled(false);
            bKill1Zeus.setEnabled(false);
            bKill1Grenade1.setEnabled(false);
            bKill1Grenade2.setEnabled(false);
            bKill1Grenade3.setEnabled(false);
            bKill1Grenade4.setEnabled(false);
            bKill1Knife.setEnabled(false);
            bQuitkillMenuKill1Menu.setEnabled(true);
            killMenuKill1Grenade4 = null;
        }
        if (source == bKill1Knife){
            BalancekillMenuKill1 = BalancekillMenuKill1 + 1500;
            if(BalancekillMenuKill1 > 16000){
                BalancekillMenuKill1 = 16000;
            }
            tBalance.setText(BalancekillMenuKill1 + "$");
            bKill1Weapon1.setEnabled(false);
            bKill1Weapon2.setEnabled(false);
            bKill1Zeus.setEnabled(false);
            bKill1Grenade1.setEnabled(false);
            bKill1Grenade2.setEnabled(false);
            bKill1Grenade3.setEnabled(false);
            bKill1Grenade4.setEnabled(false);
            bKill1Knife.setEnabled(false);
            bQuitkillMenuKill1Menu.setEnabled(true);
        }
        if (source == bQuitkillMenuKill1Menu){
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

                int Kill1balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+BalancekillMenuKill1+" WHERE idNumCS = 1;");

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Grenade1 = ?, Grenade2 = ?, Grenade3 =?, Grenade4 =?, Zeus = ? WHERE idNumCS = 1;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1,killMenuKill1Grenade1);
                preparedStatement.setString(2,killMenuKill1Grenade2);
                preparedStatement.setString(3,killMenuKill1Grenade3);
                preparedStatement.setString(4,killMenuKill1Grenade4);
                preparedStatement.setString(5,killMenuKill1Zeus);

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
            new killMenuT();
            dispose();
        }
    }
}
