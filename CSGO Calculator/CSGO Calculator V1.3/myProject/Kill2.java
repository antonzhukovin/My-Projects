package myProject;

import java.awt.*;
import java.sql.*;

public class Kill2 extends EasyApp
{
    public static void main(String[] args)
    {  new Kill2();}

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,50,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);
    
    Button bKill2Weapon1 = addButton("Secondary weapon",400,90,183,50,this);
    Button bKill2Weapon2 = addButton("Primary weapon",400,140,183,50,this);
    Button bKill2Zeus = addButton("Zeus",400,190,183,50,this);
    Button bKill2Grenade1 = addButton("Grenade 1",400,240,183,50,this);
    Button bKill2Grenade2 = addButton("Grenade 2",400,290,183,50,this);
    Button bKill2Grenade3 = addButton("Grenade 3",400,340,183,50,this);
    Button bKill2Grenade4 = addButton("Grenade 4",400,390,183,50,this);
    Button bKill2Knife = addButton("Knife",400,440,183,50,this);

    Button bQuitkillMenuKill2Menu = addButton("Go Back",830,550,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,10,30,this);
    Label lRoundNum = addLabel("Round: ",455,50,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    Label lKill2Weapon1 = addLabel("",337,100,62,30,this);
    Label lKill2Weapon2 = addLabel("",337,200,62,30,this);
    Label lKill2Zeus = addLabel("",337,300,62,30,this);
    Label lKill2Grenade1 = addLabel("",337,400,62,30,this);
    Label lKill2Grenade2 = addLabel("",337,500,62,30,this);
    Label lKill2Grenade3 = addLabel("",337,600,62,30,this);
    Label lKill2Grenade4 = addLabel("",337,700,62,30,this);

    int RoundCountkillMenuKill2; 
    int BalancekillMenuKill2; 
    int RoundCTkillMenuKill2;
    int RoundTkillMenuKill2;
    String killMenuKill2Weapon1;
    String killMenuKill2Weapon2;
    String killMenuKill2Zeus;
    String killMenuKill2Grenade1;
    String killMenuKill2Grenade2;
    String killMenuKill2Grenade3;
    String killMenuKill2Grenade4;

    public Kill2(){
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

            ResultSet sqlRoundCountkillMenuKill2Menu =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountkillMenuKill2Menu.next() ){
                String sqlRoundCountstringkillMenuKill2Menu = sqlRoundCountkillMenuKill2Menu.getString(1);
                RoundCountkillMenuKill2 = Integer.parseInt (sqlRoundCountstringkillMenuKill2Menu);}

            ResultSet rsBalancekillMenuKill2Menu = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalancekillMenuKill2Menu.next() ){
                String rs1BalancestringkillMenuKill2Menu = rsBalancekillMenuKill2Menu.getString(1);
                BalancekillMenuKill2 = Integer.parseInt (rs1BalancestringkillMenuKill2Menu);}

            ResultSet sqlRoundCTkillMenuKill2Menu =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTkillMenuKill2Menu.next() ){
                String sqlRoundCTstringkillMenuKill2Menu = sqlRoundCTkillMenuKill2Menu.getString(1);
                RoundCTkillMenuKill2 = Integer.parseInt (sqlRoundCTstringkillMenuKill2Menu);}

            ResultSet sqlRoundTkillMenuKill2Menu =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTkillMenuKill2Menu .next() ){
                String sqlRoundTstringkillMenuKill2Menu = sqlRoundTkillMenuKill2Menu .getString(1);
                RoundTkillMenuKill2 = Integer.parseInt (sqlRoundTstringkillMenuKill2Menu);}

            ResultSet sqlWeapon1killMenuKill2Menu =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon1killMenuKill2Menu .next() ){
                killMenuKill2Weapon1 = sqlWeapon1killMenuKill2Menu .getString(1);
            }

            ResultSet sqlWeapon2killMenuKill2Menu =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon2killMenuKill2Menu .next() ){
                killMenuKill2Weapon2 = sqlWeapon2killMenuKill2Menu .getString(1);
            }

            ResultSet sqlZeuskillMenuKill2Menu =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlZeuskillMenuKill2Menu .next() ){
                killMenuKill2Zeus = sqlZeuskillMenuKill2Menu .getString(1);
            }

            ResultSet sqlGrenade1killMenuKill2Menu =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1killMenuKill2Menu .next() ){
                killMenuKill2Grenade1 = sqlGrenade1killMenuKill2Menu .getString(1);
            }

            ResultSet sqlGrenade2killMenuKill2Menu =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2killMenuKill2Menu .next() ){
                killMenuKill2Grenade2 = sqlGrenade2killMenuKill2Menu .getString(1);
            }

            ResultSet sqlGrenade3killMenuKill2Menu =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3killMenuKill2Menu .next() ){
                killMenuKill2Grenade3 = sqlGrenade3killMenuKill2Menu .getString(1);
            }

            ResultSet sqlGrenade4killMenuKill2Menu =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4killMenuKill2Menu .next() ){
                killMenuKill2Grenade4 = sqlGrenade4killMenuKill2Menu .getString(1);
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
        tRoundNum.setText(RoundCountkillMenuKill2 +  "");
        tBalance.setText(BalancekillMenuKill2 + "$");
        tCTscore.setText(RoundCTkillMenuKill2 + "");
        tTscore.setText(RoundTkillMenuKill2 + "");

        lKill2Weapon1.setText(killMenuKill2Weapon1);
        lKill2Weapon2.setText(killMenuKill2Weapon2);
        lKill2Zeus.setText(killMenuKill2Zeus);
        lKill2Grenade1.setText(killMenuKill2Grenade1);
        lKill2Grenade2.setText(killMenuKill2Grenade2);
        lKill2Grenade3.setText(killMenuKill2Grenade3);
        lKill2Grenade4.setText(killMenuKill2Grenade4);
        
        bQuitkillMenuKill2Menu.setEnabled(false);

        if(killMenuKill2Weapon1 == null){
            bKill2Weapon1.setEnabled(false);
        }
        if(killMenuKill2Weapon2 == null){
            bKill2Weapon2.setEnabled(false);
        }
        if(killMenuKill2Zeus == null){
            bKill2Zeus.setEnabled(false);
        }
        if(killMenuKill2Grenade1 == null){
            bKill2Grenade1.setEnabled(false);
        }
        if(killMenuKill2Grenade2 == null){
            bKill2Grenade2.setEnabled(false);
        }
        if(killMenuKill2Grenade3 == null){
            bKill2Grenade3.setEnabled(false);
        }
        if(killMenuKill2Grenade4 == null){
            bKill2Grenade4.setEnabled(false);
        }

    }

    public void actions(Object source,String command){
        if (source == bKill2Weapon1){

            if(killMenuKill2Weapon1.equals("Glock-18")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon1.equals("Dual Berettas")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon1.equals("P250")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon1.equals("CZ75-Auto")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 100;
            }
            if(killMenuKill2Weapon1.equals("Desert Eagle")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon1.equals("R8 Revolver")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon1.equals("Tec-9")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon1.equals("USP-S")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon1.equals("P2000")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon1.equals("Five-SeveN")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            
            if(BalancekillMenuKill2 > 16000){
                BalancekillMenuKill2 = 16000;
            }
            
            tBalance.setText(BalancekillMenuKill2 + "$");
            bKill2Weapon1.setEnabled(false);
            bKill2Weapon2.setEnabled(false);
            bKill2Zeus.setEnabled(false);
            bKill2Grenade1.setEnabled(false);
            bKill2Grenade2.setEnabled(false);
            bKill2Grenade3.setEnabled(false);
            bKill2Grenade4.setEnabled(false);
            bKill2Knife.setEnabled(false);
            bQuitkillMenuKill2Menu.setEnabled(true);
        }
        if (source == bKill2Weapon2){
            
            if(killMenuKill2Weapon2.equals("MAC-10")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 600;
            }
            if(killMenuKill2Weapon2.equals("MP5-SD")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 600;
            }
            if(killMenuKill2Weapon2.equals("MP7")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 600;
            }
            if(killMenuKill2Weapon2.equals("UMP-45")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 600;
            }
            if(killMenuKill2Weapon2.equals("P90")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("PP-Bizon")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 600;
            }
            if(killMenuKill2Weapon2.equals("MP9")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 600;
            }
            
            if(killMenuKill2Weapon2.equals("Galil AR")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("AK-47")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("SSG 08")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("SG 553")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("AWP")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 100;
            }
            if(killMenuKill2Weapon2.equals("G3SG1")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("FAMAS")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("M4A4")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("M4A1-S")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("AUG")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("SCAR-20")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            
            if(killMenuKill2Weapon2.equals("Nova")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 900;
            }
            if(killMenuKill2Weapon2.equals("XM1014")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 900;
            }
            if(killMenuKill2Weapon2.equals("Sawed-Off")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 900;
            }
            if(killMenuKill2Weapon2.equals("M249")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("Negev")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            }
            if(killMenuKill2Weapon2.equals("MAG-7")){
                BalancekillMenuKill2 = BalancekillMenuKill2 + 900;
            }
            if(BalancekillMenuKill2 > 16000){
                BalancekillMenuKill2 = 16000;
            }
            tBalance.setText(BalancekillMenuKill2 + "$");
            bKill2Weapon1.setEnabled(false);
            bKill2Weapon2.setEnabled(false);
            bKill2Zeus.setEnabled(false);
            bKill2Grenade1.setEnabled(false);
            bKill2Grenade2.setEnabled(false);
            bKill2Grenade3.setEnabled(false);
            bKill2Grenade4.setEnabled(false);
            bKill2Knife.setEnabled(false);
            bQuitkillMenuKill2Menu.setEnabled(true);
        }
        if (source == bKill2Zeus){
            bKill2Weapon1.setEnabled(false);
            bKill2Weapon2.setEnabled(false);
            bKill2Zeus.setEnabled(false);
            bKill2Grenade1.setEnabled(false);
            bKill2Grenade2.setEnabled(false);
            bKill2Grenade3.setEnabled(false);
            bKill2Grenade4.setEnabled(false);
            bKill2Knife.setEnabled(false);
            bQuitkillMenuKill2Menu.setEnabled(true);
            killMenuKill2Zeus = null;
        }
        if (source == bKill2Grenade1){
            BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            if(BalancekillMenuKill2 > 16000){
                BalancekillMenuKill2 = 16000;
            }
            tBalance.setText(BalancekillMenuKill2 + "$");
            bKill2Weapon1.setEnabled(false);
            bKill2Weapon2.setEnabled(false);
            bKill2Zeus.setEnabled(false);
            bKill2Grenade1.setEnabled(false);
            bKill2Grenade2.setEnabled(false);
            bKill2Grenade3.setEnabled(false);
            bKill2Grenade4.setEnabled(false);
            bKill2Knife.setEnabled(false);
            bQuitkillMenuKill2Menu.setEnabled(true);
            killMenuKill2Grenade1 = null;
        }
        if (source == bKill2Grenade2){
            BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            if(BalancekillMenuKill2 > 16000){
                BalancekillMenuKill2 = 16000;
            }
            tBalance.setText(BalancekillMenuKill2 + "$");
            bKill2Weapon1.setEnabled(false);
            bKill2Weapon2.setEnabled(false);
            bKill2Zeus.setEnabled(false);
            bKill2Grenade1.setEnabled(false);
            bKill2Grenade2.setEnabled(false);
            bKill2Grenade3.setEnabled(false);
            bKill2Grenade4.setEnabled(false);
            bKill2Knife.setEnabled(false);
            bQuitkillMenuKill2Menu.setEnabled(true);
            killMenuKill2Grenade2 = null;
        }
        if (source == bKill2Grenade3){
            BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            if(BalancekillMenuKill2 > 16000){
                BalancekillMenuKill2 = 16000;
            }
            tBalance.setText(BalancekillMenuKill2 + "$");
            bKill2Weapon1.setEnabled(false);
            bKill2Weapon2.setEnabled(false);
            bKill2Zeus.setEnabled(false);
            bKill2Grenade1.setEnabled(false);
            bKill2Grenade2.setEnabled(false);
            bKill2Grenade3.setEnabled(false);
            bKill2Grenade4.setEnabled(false);
            bKill2Knife.setEnabled(false);
            bQuitkillMenuKill2Menu.setEnabled(true);
            killMenuKill2Grenade3 = null;
        }
        if (source == bKill2Grenade4){
            BalancekillMenuKill2 = BalancekillMenuKill2 + 300;
            if(BalancekillMenuKill2 > 16000){
                BalancekillMenuKill2 = 16000;
            }
            tBalance.setText(BalancekillMenuKill2 + "$");
            bKill2Weapon1.setEnabled(false);
            bKill2Weapon2.setEnabled(false);
            bKill2Zeus.setEnabled(false);
            bKill2Grenade1.setEnabled(false);
            bKill2Grenade2.setEnabled(false);
            bKill2Grenade3.setEnabled(false);
            bKill2Grenade4.setEnabled(false);
            bKill2Knife.setEnabled(false);
            bQuitkillMenuKill2Menu.setEnabled(true);
            killMenuKill2Grenade4 = null;
        }
        if (source == bKill2Knife){
            BalancekillMenuKill2 = BalancekillMenuKill2 + 1500;
            if(BalancekillMenuKill2 > 16000){
                BalancekillMenuKill2 = 16000;
            }
            tBalance.setText(BalancekillMenuKill2 + "$");
            bKill2Weapon1.setEnabled(false);
            bKill2Weapon2.setEnabled(false);
            bKill2Zeus.setEnabled(false);
            bKill2Grenade1.setEnabled(false);
            bKill2Grenade2.setEnabled(false);
            bKill2Grenade3.setEnabled(false);
            bKill2Grenade4.setEnabled(false);
            bKill2Knife.setEnabled(false);
            bQuitkillMenuKill2Menu.setEnabled(true);
        }
        if (source == bQuitkillMenuKill2Menu){
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

                int Kill1balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+BalancekillMenuKill2+" WHERE idNumCS = 1;");

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Grenade1 = ?, Grenade2 = ?, Grenade3 =?, Grenade4 =?, Zeus = ? WHERE idNumCS = 1;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1,killMenuKill2Grenade1);
                preparedStatement.setString(2,killMenuKill2Grenade2);
                preparedStatement.setString(3,killMenuKill2Grenade3);
                preparedStatement.setString(4,killMenuKill2Grenade4);
                preparedStatement.setString(5,killMenuKill2Zeus);

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
