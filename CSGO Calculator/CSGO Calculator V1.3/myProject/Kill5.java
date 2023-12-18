package myProject;

import java.awt.*;
import java.sql.*;

public class Kill5 extends EasyApp
{
    public static void main(String[] args)
    {  new Kill5();}

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,50,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);
    
    Button bKill5Weapon1 = addButton("Secondary weapon",400,90,183,50,this);
    Button bKill5Weapon2 = addButton("Primary weapon",400,140,183,50,this);
    Button bKill5Zeus = addButton("Zeus",400,190,183,50,this);
    Button bKill5Grenade1 = addButton("Grenade 1",400,240,183,50,this);
    Button bKill5Grenade2 = addButton("Grenade 2",400,290,183,50,this);
    Button bKill5Grenade3 = addButton("Grenade 3",400,340,183,50,this);
    Button bKill5Grenade4 = addButton("Grenade 4",400,390,183,50,this);
    Button bKill5Knife = addButton("Knife",400,440,183,50,this);

    Button bQuitkillMenuKill5Menu = addButton("Go Back",830,550,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,10,30,this);
    Label lRoundNum = addLabel("Round: ",455,50,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    Label lKill5Weapon1 = addLabel("",337,100,62,30,this);
    Label lKill5Weapon2 = addLabel("",337,200,62,30,this);
    Label lKill5Zeus = addLabel("",337,300,62,30,this);
    Label lKill5Grenade1 = addLabel("",337,400,62,30,this);
    Label lKill5Grenade2 = addLabel("",337,500,62,30,this);
    Label lKill5Grenade3 = addLabel("",337,600,62,30,this);
    Label lKill5Grenade4 = addLabel("",337,700,62,30,this);

    int RoundCountkillMenuKill5; 
    int BalancekillMenuKill5; 
    int RoundCTkillMenuKill5;
    int RoundTkillMenuKill5;
    String killMenuKill5Weapon1;
    String killMenuKill5Weapon2;
    String killMenuKill5Zeus;
    String killMenuKill5Grenade1;
    String killMenuKill5Grenade2;
    String killMenuKill5Grenade3;
    String killMenuKill5Grenade4;

    public Kill5(){
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

            ResultSet sqlRoundCountkillMenuKill5Menu =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountkillMenuKill5Menu.next() ){
                String sqlRoundCountstringkillMenuKill5Menu = sqlRoundCountkillMenuKill5Menu.getString(1);
                RoundCountkillMenuKill5 = Integer.parseInt (sqlRoundCountstringkillMenuKill5Menu);}

            ResultSet rsBalancekillMenuKill5Menu = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalancekillMenuKill5Menu.next() ){
                String rs1BalancestringkillMenuKill5Menu = rsBalancekillMenuKill5Menu.getString(1);
                BalancekillMenuKill5 = Integer.parseInt (rs1BalancestringkillMenuKill5Menu);}

            ResultSet sqlRoundCTkillMenuKill5Menu =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTkillMenuKill5Menu.next() ){
                String sqlRoundCTstringkillMenuKill5Menu = sqlRoundCTkillMenuKill5Menu.getString(1);
                RoundCTkillMenuKill5 = Integer.parseInt (sqlRoundCTstringkillMenuKill5Menu);}

            ResultSet sqlRoundTkillMenuKill5Menu =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTkillMenuKill5Menu .next() ){
                String sqlRoundTstringkillMenuKill5Menu = sqlRoundTkillMenuKill5Menu .getString(1);
                RoundTkillMenuKill5 = Integer.parseInt (sqlRoundTstringkillMenuKill5Menu);}

            ResultSet sqlWeapon1killMenuKill5Menu =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon1killMenuKill5Menu .next() ){
                killMenuKill5Weapon1 = sqlWeapon1killMenuKill5Menu .getString(1);
            }

            ResultSet sqlWeapon2killMenuKill5Menu =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon2killMenuKill5Menu .next() ){
                killMenuKill5Weapon2 = sqlWeapon2killMenuKill5Menu .getString(1);
            }

            ResultSet sqlZeuskillMenuKill5Menu =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlZeuskillMenuKill5Menu .next() ){
                killMenuKill5Zeus = sqlZeuskillMenuKill5Menu .getString(1);
            }

            ResultSet sqlGrenade1killMenuKill5Menu =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1killMenuKill5Menu .next() ){
                killMenuKill5Grenade1 = sqlGrenade1killMenuKill5Menu .getString(1);
            }

            ResultSet sqlGrenade2killMenuKill5Menu =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2killMenuKill5Menu .next() ){
                killMenuKill5Grenade2 = sqlGrenade2killMenuKill5Menu .getString(1);
            }

            ResultSet sqlGrenade3killMenuKill5Menu =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3killMenuKill5Menu .next() ){
                killMenuKill5Grenade3 = sqlGrenade3killMenuKill5Menu .getString(1);
            }

            ResultSet sqlGrenade4killMenuKill5Menu =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4killMenuKill5Menu .next() ){
                killMenuKill5Grenade4 = sqlGrenade4killMenuKill5Menu .getString(1);
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
        tRoundNum.setText(RoundCountkillMenuKill5 +  "");
        tBalance.setText(BalancekillMenuKill5 + "$");
        tCTscore.setText(RoundCTkillMenuKill5 + "");
        tTscore.setText(RoundTkillMenuKill5 + "");

        lKill5Weapon1.setText(killMenuKill5Weapon1);
        lKill5Weapon2.setText(killMenuKill5Weapon2);
        lKill5Zeus.setText(killMenuKill5Zeus);
        lKill5Grenade1.setText(killMenuKill5Grenade1);
        lKill5Grenade2.setText(killMenuKill5Grenade2);
        lKill5Grenade3.setText(killMenuKill5Grenade3);
        lKill5Grenade4.setText(killMenuKill5Grenade4);
        
        bQuitkillMenuKill5Menu.setEnabled(false);

        if(killMenuKill5Weapon1 == null){
            bKill5Weapon1.setEnabled(false);
        }
        if(killMenuKill5Weapon2 == null){
            bKill5Weapon2.setEnabled(false);
        }
        if(killMenuKill5Zeus == null){
            bKill5Zeus.setEnabled(false);
        }
        if(killMenuKill5Grenade1 == null){
            bKill5Grenade1.setEnabled(false);
        }
        if(killMenuKill5Grenade2 == null){
            bKill5Grenade2.setEnabled(false);
        }
        if(killMenuKill5Grenade3 == null){
            bKill5Grenade3.setEnabled(false);
        }
        if(killMenuKill5Grenade4 == null){
            bKill5Grenade4.setEnabled(false);
        }

    }

    public void actions(Object source,String command){
        if (source == bKill5Weapon1){

            if(killMenuKill5Weapon1.equals("Glock-18")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon1.equals("Dual Berettas")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon1.equals("P250")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon1.equals("CZ75-Auto")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 100;
            }
            if(killMenuKill5Weapon1.equals("Desert Eagle")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon1.equals("R8 Revolver")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon1.equals("Tec-9")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon1.equals("USP-S")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon1.equals("P2000")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon1.equals("Five-SeveN")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            
            if(BalancekillMenuKill5 > 16000){
                BalancekillMenuKill5 = 16000;
            }

            tBalance.setText(BalancekillMenuKill5 + "$");
            bKill5Weapon1.setEnabled(false);
            bKill5Weapon2.setEnabled(false);
            bKill5Zeus.setEnabled(false);
            bKill5Grenade1.setEnabled(false);
            bKill5Grenade2.setEnabled(false);
            bKill5Grenade3.setEnabled(false);
            bKill5Grenade4.setEnabled(false);
            bKill5Knife.setEnabled(false);
            bQuitkillMenuKill5Menu.setEnabled(true);
        }
        if (source == bKill5Weapon2){
            
            if(killMenuKill5Weapon2.equals("MAC-10")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 600;
            }
            if(killMenuKill5Weapon2.equals("MP5-SD")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 600;
            }
            if(killMenuKill5Weapon2.equals("MP7")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 600;
            }
            if(killMenuKill5Weapon2.equals("UMP-45")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 600;
            }
            if(killMenuKill5Weapon2.equals("P90")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("PP-Bizon")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 600;
            }
            if(killMenuKill5Weapon2.equals("MP9")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 600;
            }
            
            if(killMenuKill5Weapon2.equals("Galil AR")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("AK-47")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("SSG 08")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("SG 553")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("AWP")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 100;
            }
            if(killMenuKill5Weapon2.equals("G3SG1")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("FAMAS")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("M4A4")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("M4A1-S")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("AUG")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("SCAR-20")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            
            if(killMenuKill5Weapon2.equals("Nova")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 900;
            }
            if(killMenuKill5Weapon2.equals("XM1014")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 900;
            }
            if(killMenuKill5Weapon2.equals("Sawed-Off")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 900;
            }
            if(killMenuKill5Weapon2.equals("M249")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("Negev")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            }
            if(killMenuKill5Weapon2.equals("MAG-7")){
                BalancekillMenuKill5 = BalancekillMenuKill5 + 900;
            }
            if(BalancekillMenuKill5 > 16000){
                BalancekillMenuKill5 = 16000;
            }
            tBalance.setText(BalancekillMenuKill5 + "$");
            bKill5Weapon1.setEnabled(false);
            bKill5Weapon2.setEnabled(false);
            bKill5Zeus.setEnabled(false);
            bKill5Grenade1.setEnabled(false);
            bKill5Grenade2.setEnabled(false);
            bKill5Grenade3.setEnabled(false);
            bKill5Grenade4.setEnabled(false);
            bKill5Knife.setEnabled(false);
            bQuitkillMenuKill5Menu.setEnabled(true);
        }
        if (source == bKill5Zeus){
            bKill5Weapon1.setEnabled(false);
            bKill5Weapon2.setEnabled(false);
            bKill5Zeus.setEnabled(false);
            bKill5Grenade1.setEnabled(false);
            bKill5Grenade2.setEnabled(false);
            bKill5Grenade3.setEnabled(false);
            bKill5Grenade4.setEnabled(false);
            bKill5Knife.setEnabled(false);
            bQuitkillMenuKill5Menu.setEnabled(true);
            killMenuKill5Zeus = null;
        }
        if (source == bKill5Grenade1){
            BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            if(BalancekillMenuKill5 > 16000){
                BalancekillMenuKill5 = 16000;
            }
            tBalance.setText(BalancekillMenuKill5 + "$");
            bKill5Weapon1.setEnabled(false);
            bKill5Weapon2.setEnabled(false);
            bKill5Zeus.setEnabled(false);
            bKill5Grenade1.setEnabled(false);
            bKill5Grenade2.setEnabled(false);
            bKill5Grenade3.setEnabled(false);
            bKill5Grenade4.setEnabled(false);
            bKill5Knife.setEnabled(false);
            bQuitkillMenuKill5Menu.setEnabled(true);
            killMenuKill5Grenade1 = null;
        }
        if (source == bKill5Grenade2){
            BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            if(BalancekillMenuKill5 > 16000){
                BalancekillMenuKill5 = 16000;
            }
            tBalance.setText(BalancekillMenuKill5 + "$");
            bKill5Weapon1.setEnabled(false);
            bKill5Weapon2.setEnabled(false);
            bKill5Zeus.setEnabled(false);
            bKill5Grenade1.setEnabled(false);
            bKill5Grenade2.setEnabled(false);
            bKill5Grenade3.setEnabled(false);
            bKill5Grenade4.setEnabled(false);
            bKill5Knife.setEnabled(false);
            bQuitkillMenuKill5Menu.setEnabled(true);
            killMenuKill5Grenade2 = null;
        }
        if (source == bKill5Grenade3){
            BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            if(BalancekillMenuKill5 > 16000){
                BalancekillMenuKill5 = 16000;
            }
            tBalance.setText(BalancekillMenuKill5 + "$");
            bKill5Weapon1.setEnabled(false);
            bKill5Weapon2.setEnabled(false);
            bKill5Zeus.setEnabled(false);
            bKill5Grenade1.setEnabled(false);
            bKill5Grenade2.setEnabled(false);
            bKill5Grenade3.setEnabled(false);
            bKill5Grenade4.setEnabled(false);
            bKill5Knife.setEnabled(false);
            bQuitkillMenuKill5Menu.setEnabled(true);
            killMenuKill5Grenade3 = null;
        }
        if (source == bKill5Grenade4){
            BalancekillMenuKill5 = BalancekillMenuKill5 + 300;
            if(BalancekillMenuKill5 > 16000){
                BalancekillMenuKill5 = 16000;
            }
            tBalance.setText(BalancekillMenuKill5 + "$");
            bKill5Weapon1.setEnabled(false);
            bKill5Weapon2.setEnabled(false);
            bKill5Zeus.setEnabled(false);
            bKill5Grenade1.setEnabled(false);
            bKill5Grenade2.setEnabled(false);
            bKill5Grenade3.setEnabled(false);
            bKill5Grenade4.setEnabled(false);
            bKill5Knife.setEnabled(false);
            bQuitkillMenuKill5Menu.setEnabled(true);
            killMenuKill5Grenade4 = null;
        }
        if (source == bKill5Knife){
            BalancekillMenuKill5 = BalancekillMenuKill5 + 1500;
            if(BalancekillMenuKill5 > 16000){
                BalancekillMenuKill5 = 16000;
            }
            tBalance.setText(BalancekillMenuKill5 + "$");
            bKill5Weapon1.setEnabled(false);
            bKill5Weapon2.setEnabled(false);
            bKill5Zeus.setEnabled(false);
            bKill5Grenade1.setEnabled(false);
            bKill5Grenade2.setEnabled(false);
            bKill5Grenade3.setEnabled(false);
            bKill5Grenade4.setEnabled(false);
            bKill5Knife.setEnabled(false);
            bQuitkillMenuKill5Menu.setEnabled(true);
        }
        if (source == bQuitkillMenuKill5Menu){
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

                int Kill1balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+BalancekillMenuKill5+" WHERE idNumCS = 1;");

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Grenade1 = ?, Grenade2 = ?, Grenade3 =?, Grenade4 =?, Zeus = ? WHERE idNumCS = 1;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1,killMenuKill5Grenade1);
                preparedStatement.setString(2,killMenuKill5Grenade2);
                preparedStatement.setString(3,killMenuKill5Grenade3);
                preparedStatement.setString(4,killMenuKill5Grenade4);
                preparedStatement.setString(5,killMenuKill5Zeus);

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
