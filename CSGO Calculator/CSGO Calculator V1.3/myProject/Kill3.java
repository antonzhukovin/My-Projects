package myProject;

import java.awt.*;
import java.sql.*;

public class Kill3 extends EasyApp
{
    public static void main(String[] args)
    {  new Kill3();}

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,50,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);
    
    Button bKill3Weapon1 = addButton("Secondary weapon",400,90,183,50,this);
    Button bKill3Weapon2 = addButton("Primary weapon",400,140,183,50,this);
    Button bKill3Zeus = addButton("Zeus",400,190,183,50,this);
    Button bKill3Grenade1 = addButton("Grenade 1",400,240,183,50,this);
    Button bKill3Grenade2 = addButton("Grenade 2",400,290,183,50,this);
    Button bKill3Grenade3 = addButton("Grenade 3",400,340,183,50,this);
    Button bKill3Grenade4 = addButton("Grenade 4",400,390,183,50,this);
    Button bKill3Knife = addButton("Knife",400,440,183,50,this);

    Button bQuitkillMenuKill3Menu = addButton("Go Back",830,550,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,10,30,this);
    Label lRoundNum = addLabel("Round: ",455,50,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    Label lKill3Weapon1 = addLabel("",337,100,62,30,this);
    Label lKill3Weapon2 = addLabel("",337,200,62,30,this);
    Label lKill3Zeus = addLabel("",337,300,62,30,this);
    Label lKill3Grenade1 = addLabel("",337,400,62,30,this);
    Label lKill3Grenade2 = addLabel("",337,500,62,30,this);
    Label lKill3Grenade3 = addLabel("",337,600,62,30,this);
    Label lKill3Grenade4 = addLabel("",337,700,62,30,this);

    int RoundCountkillMenuKill3; 
    int BalancekillMenuKill3; 
    int RoundCTkillMenuKill3;
    int RoundTkillMenuKill3;
    String killMenuKill3Weapon1;
    String killMenuKill3Weapon2;
    String killMenuKill3Zeus;
    String killMenuKill3Grenade1;
    String killMenuKill3Grenade2;
    String killMenuKill3Grenade3;
    String killMenuKill3Grenade4;

    public Kill3(){
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

            ResultSet sqlRoundCountkillMenuKill3Menu =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountkillMenuKill3Menu.next() ){
                String sqlRoundCountstringkillMenuKill3Menu = sqlRoundCountkillMenuKill3Menu.getString(1);
                RoundCountkillMenuKill3 = Integer.parseInt (sqlRoundCountstringkillMenuKill3Menu);}

            ResultSet rsBalancekillMenuKill3Menu = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalancekillMenuKill3Menu.next() ){
                String rs1BalancestringkillMenuKill3Menu = rsBalancekillMenuKill3Menu.getString(1);
                BalancekillMenuKill3 = Integer.parseInt (rs1BalancestringkillMenuKill3Menu);}

            ResultSet sqlRoundCTkillMenuKill3Menu =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTkillMenuKill3Menu.next() ){
                String sqlRoundCTstringkillMenuKill3Menu = sqlRoundCTkillMenuKill3Menu.getString(1);
                RoundCTkillMenuKill3 = Integer.parseInt (sqlRoundCTstringkillMenuKill3Menu);}

            ResultSet sqlRoundTkillMenuKill3Menu =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTkillMenuKill3Menu .next() ){
                String sqlRoundTstringkillMenuKill3Menu = sqlRoundTkillMenuKill3Menu .getString(1);
                RoundTkillMenuKill3 = Integer.parseInt (sqlRoundTstringkillMenuKill3Menu);}

            ResultSet sqlWeapon1killMenuKill3Menu =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon1killMenuKill3Menu .next() ){
                killMenuKill3Weapon1 = sqlWeapon1killMenuKill3Menu .getString(1);
            }

            ResultSet sqlWeapon2killMenuKill3Menu =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon2killMenuKill3Menu .next() ){
                killMenuKill3Weapon2 = sqlWeapon2killMenuKill3Menu .getString(1);
            }

            ResultSet sqlZeuskillMenuKill3Menu =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlZeuskillMenuKill3Menu .next() ){
                killMenuKill3Zeus = sqlZeuskillMenuKill3Menu .getString(1);
            }

            ResultSet sqlGrenade1killMenuKill3Menu =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1killMenuKill3Menu .next() ){
                killMenuKill3Grenade1 = sqlGrenade1killMenuKill3Menu .getString(1);
            }

            ResultSet sqlGrenade2killMenuKill3Menu =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2killMenuKill3Menu .next() ){
                killMenuKill3Grenade2 = sqlGrenade2killMenuKill3Menu .getString(1);
            }

            ResultSet sqlGrenade3killMenuKill3Menu =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3killMenuKill3Menu .next() ){
                killMenuKill3Grenade3 = sqlGrenade3killMenuKill3Menu .getString(1);
            }

            ResultSet sqlGrenade4killMenuKill3Menu =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4killMenuKill3Menu .next() ){
                killMenuKill3Grenade4 = sqlGrenade4killMenuKill3Menu .getString(1);
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
        tRoundNum.setText(RoundCountkillMenuKill3 +  "");
        tBalance.setText(BalancekillMenuKill3 + "$");
        tCTscore.setText(RoundCTkillMenuKill3 + "");
        tTscore.setText(RoundTkillMenuKill3 + "");

        lKill3Weapon1.setText(killMenuKill3Weapon1);
        lKill3Weapon2.setText(killMenuKill3Weapon2);
        lKill3Zeus.setText(killMenuKill3Zeus);
        lKill3Grenade1.setText(killMenuKill3Grenade1);
        lKill3Grenade2.setText(killMenuKill3Grenade2);
        lKill3Grenade3.setText(killMenuKill3Grenade3);
        lKill3Grenade4.setText(killMenuKill3Grenade4);
        
        bQuitkillMenuKill3Menu.setEnabled(false);

        if(killMenuKill3Weapon1 == null){
            bKill3Weapon1.setEnabled(false);
        }
        if(killMenuKill3Weapon2 == null){
            bKill3Weapon2.setEnabled(false);
        }
        if(killMenuKill3Zeus == null){
            bKill3Zeus.setEnabled(false);
        }
        if(killMenuKill3Grenade1 == null){
            bKill3Grenade1.setEnabled(false);
        }
        if(killMenuKill3Grenade2 == null){
            bKill3Grenade2.setEnabled(false);
        }
        if(killMenuKill3Grenade3 == null){
            bKill3Grenade3.setEnabled(false);
        }
        if(killMenuKill3Grenade4 == null){
            bKill3Grenade4.setEnabled(false);
        }

    }

    public void actions(Object source,String command){
        if (source == bKill3Weapon1){

            if(killMenuKill3Weapon1.equals("Glock-18")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon1.equals("Dual Berettas")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon1.equals("P250")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon1.equals("CZ75-Auto")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 100;
            }
            if(killMenuKill3Weapon1.equals("Desert Eagle")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon1.equals("R8 Revolver")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon1.equals("Tec-9")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon1.equals("USP-S")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon1.equals("P2000")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon1.equals("Five-SeveN")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            
            if(BalancekillMenuKill3 > 16000){
                BalancekillMenuKill3 = 16000;
            }
            tBalance.setText(BalancekillMenuKill3 + "$");
            bKill3Weapon1.setEnabled(false);
            bKill3Weapon2.setEnabled(false);
            bKill3Zeus.setEnabled(false);
            bKill3Grenade1.setEnabled(false);
            bKill3Grenade2.setEnabled(false);
            bKill3Grenade3.setEnabled(false);
            bKill3Grenade4.setEnabled(false);
            bKill3Knife.setEnabled(false);
            bQuitkillMenuKill3Menu.setEnabled(true);
        }
        if (source == bKill3Weapon2){
            
            if(killMenuKill3Weapon2.equals("MAC-10")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 600;
            }
            if(killMenuKill3Weapon2.equals("MP5-SD")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 600;
            }
            if(killMenuKill3Weapon2.equals("MP7")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 600;
            }
            if(killMenuKill3Weapon2.equals("UMP-45")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 600;
            }
            if(killMenuKill3Weapon2.equals("P90")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("PP-Bizon")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 600;
            }
            if(killMenuKill3Weapon2.equals("MP9")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 600;
            }
            
            if(killMenuKill3Weapon2.equals("Galil AR")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("AK-47")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("SSG 08")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("SG 553")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("AWP")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 100;
            }
            if(killMenuKill3Weapon2.equals("G3SG1")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("FAMAS")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("M4A4")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("M4A1-S")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("AUG")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("SCAR-20")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            
            if(killMenuKill3Weapon2.equals("Nova")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 900;
            }
            if(killMenuKill3Weapon2.equals("XM1014")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 900;
            }
            if(killMenuKill3Weapon2.equals("Sawed-Off")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 900;
            }
            if(killMenuKill3Weapon2.equals("M249")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("Negev")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            }
            if(killMenuKill3Weapon2.equals("MAG-7")){
                BalancekillMenuKill3 = BalancekillMenuKill3 + 900;
            }
            if(BalancekillMenuKill3 > 16000){
                BalancekillMenuKill3 = 16000;
            }
            tBalance.setText(BalancekillMenuKill3 + "$");
            bKill3Weapon1.setEnabled(false);
            bKill3Weapon2.setEnabled(false);
            bKill3Zeus.setEnabled(false);
            bKill3Grenade1.setEnabled(false);
            bKill3Grenade2.setEnabled(false);
            bKill3Grenade3.setEnabled(false);
            bKill3Grenade4.setEnabled(false);
            bKill3Knife.setEnabled(false);
            bQuitkillMenuKill3Menu.setEnabled(true);
        }
        if (source == bKill3Zeus){
            bKill3Weapon1.setEnabled(false);
            bKill3Weapon2.setEnabled(false);
            bKill3Zeus.setEnabled(false);
            bKill3Grenade1.setEnabled(false);
            bKill3Grenade2.setEnabled(false);
            bKill3Grenade3.setEnabled(false);
            bKill3Grenade4.setEnabled(false);
            bKill3Knife.setEnabled(false);
            bQuitkillMenuKill3Menu.setEnabled(true);
            killMenuKill3Zeus = null;
        }
        if (source == bKill3Grenade1){
            BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            if(BalancekillMenuKill3 > 16000){
                BalancekillMenuKill3 = 16000;
            }
            tBalance.setText(BalancekillMenuKill3 + "$");
            bKill3Weapon1.setEnabled(false);
            bKill3Weapon2.setEnabled(false);
            bKill3Zeus.setEnabled(false);
            bKill3Grenade1.setEnabled(false);
            bKill3Grenade2.setEnabled(false);
            bKill3Grenade3.setEnabled(false);
            bKill3Grenade4.setEnabled(false);
            bKill3Knife.setEnabled(false);
            bQuitkillMenuKill3Menu.setEnabled(true);
            killMenuKill3Grenade1 = null;
        }
        if (source == bKill3Grenade2){
            BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            if(BalancekillMenuKill3 > 16000){
                BalancekillMenuKill3 = 16000;
            }
            tBalance.setText(BalancekillMenuKill3 + "$");
            bKill3Weapon1.setEnabled(false);
            bKill3Weapon2.setEnabled(false);
            bKill3Zeus.setEnabled(false);
            bKill3Grenade1.setEnabled(false);
            bKill3Grenade2.setEnabled(false);
            bKill3Grenade3.setEnabled(false);
            bKill3Grenade4.setEnabled(false);
            bKill3Knife.setEnabled(false);
            bQuitkillMenuKill3Menu.setEnabled(true);
            killMenuKill3Grenade2 = null;
        }
        if (source == bKill3Grenade3){
            BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            if(BalancekillMenuKill3 > 16000){
                BalancekillMenuKill3 = 16000;
            }
            tBalance.setText(BalancekillMenuKill3 + "$");
            bKill3Weapon1.setEnabled(false);
            bKill3Weapon2.setEnabled(false);
            bKill3Zeus.setEnabled(false);
            bKill3Grenade1.setEnabled(false);
            bKill3Grenade2.setEnabled(false);
            bKill3Grenade3.setEnabled(false);
            bKill3Grenade4.setEnabled(false);
            bKill3Knife.setEnabled(false);
            bQuitkillMenuKill3Menu.setEnabled(true);
            killMenuKill3Grenade3 = null;
        }
        if (source == bKill3Grenade4){
            BalancekillMenuKill3 = BalancekillMenuKill3 + 300;
            if(BalancekillMenuKill3 > 16000){
                BalancekillMenuKill3 = 16000;
            }
            tBalance.setText(BalancekillMenuKill3 + "$");
            bKill3Weapon1.setEnabled(false);
            bKill3Weapon2.setEnabled(false);
            bKill3Zeus.setEnabled(false);
            bKill3Grenade1.setEnabled(false);
            bKill3Grenade2.setEnabled(false);
            bKill3Grenade3.setEnabled(false);
            bKill3Grenade4.setEnabled(false);
            bKill3Knife.setEnabled(false);
            bQuitkillMenuKill3Menu.setEnabled(true);
            killMenuKill3Grenade4 = null;
        }
        if (source == bKill3Knife){
            BalancekillMenuKill3 = BalancekillMenuKill3 + 1500;
            if(BalancekillMenuKill3 > 16000){
                BalancekillMenuKill3 = 16000;
            }
            tBalance.setText(BalancekillMenuKill3 + "$");
            bKill3Weapon1.setEnabled(false);
            bKill3Weapon2.setEnabled(false);
            bKill3Zeus.setEnabled(false);
            bKill3Grenade1.setEnabled(false);
            bKill3Grenade2.setEnabled(false);
            bKill3Grenade3.setEnabled(false);
            bKill3Grenade4.setEnabled(false);
            bKill3Knife.setEnabled(false);
            bQuitkillMenuKill3Menu.setEnabled(true);
        }
        if (source == bQuitkillMenuKill3Menu){
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

                int Kill1balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+BalancekillMenuKill3+" WHERE idNumCS = 1;");

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Grenade1 = ?, Grenade2 = ?, Grenade3 =?, Grenade4 =?, Zeus = ? WHERE idNumCS = 1;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1,killMenuKill3Grenade1);
                preparedStatement.setString(2,killMenuKill3Grenade2);
                preparedStatement.setString(3,killMenuKill3Grenade3);
                preparedStatement.setString(4,killMenuKill3Grenade4);
                preparedStatement.setString(5,killMenuKill3Zeus);

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
