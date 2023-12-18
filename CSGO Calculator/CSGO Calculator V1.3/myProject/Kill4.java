package myProject;

import java.awt.*;
import java.sql.*;

public class Kill4 extends EasyApp
{
    public static void main(String[] args)
    {  new Kill4();}

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,50,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    
    Button bKill4Weapon1 = addButton("Secondary weapon",400,90,183,50,this);
    Button bKill4Weapon2 = addButton("Primary weapon",400,140,183,50,this);
    Button bKill4Zeus = addButton("Zeus",400,190,183,50,this);
    Button bKill4Grenade1 = addButton("Grenade 1",400,240,183,50,this);
    Button bKill4Grenade2 = addButton("Grenade 2",400,290,183,50,this);
    Button bKill4Grenade3 = addButton("Grenade 3",400,340,183,50,this);
    Button bKill4Grenade4 = addButton("Grenade 4",400,390,183,50,this);
    Button bKill4Knife = addButton("Knife",400,440,183,50,this);

    Button bQuitkillMenuKill4Menu = addButton("Go Back",830,550,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,10,30,this);
    Label lRoundNum = addLabel("Round: ",455,50,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    Label lKill4Weapon1 = addLabel("",337,100,62,30,this);
    Label lKill4Weapon2 = addLabel("",337,200,62,30,this);
    Label lKill4Zeus = addLabel("",337,300,62,30,this);
    Label lKill4Grenade1 = addLabel("",337,400,62,30,this);
    Label lKill4Grenade2 = addLabel("",337,500,62,30,this);
    Label lKill4Grenade3 = addLabel("",337,600,62,30,this);
    Label lKill4Grenade4 = addLabel("",337,700,62,30,this);

    int RoundCountkillMenuKill4; 
    int BalancekillMenuKill4; 
    int RoundCTkillMenuKill4;
    int RoundTkillMenuKill4;
    String killMenuKill4Weapon1;
    String killMenuKill4Weapon2;
    String killMenuKill4Zeus;
    String killMenuKill4Grenade1;
    String killMenuKill4Grenade2;
    String killMenuKill4Grenade3;
    String killMenuKill4Grenade4;

    public Kill4(){
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

            ResultSet sqlRoundCountkillMenuKill4Menu =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountkillMenuKill4Menu.next() ){
                String sqlRoundCountstringkillMenuKill4Menu = sqlRoundCountkillMenuKill4Menu.getString(1);
                RoundCountkillMenuKill4 = Integer.parseInt (sqlRoundCountstringkillMenuKill4Menu);}

            ResultSet rsBalancekillMenuKill4Menu = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalancekillMenuKill4Menu.next() ){
                String rs1BalancestringkillMenuKill4Menu = rsBalancekillMenuKill4Menu.getString(1);
                BalancekillMenuKill4 = Integer.parseInt (rs1BalancestringkillMenuKill4Menu);}

            ResultSet sqlRoundCTkillMenuKill4Menu =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTkillMenuKill4Menu.next() ){
                String sqlRoundCTstringkillMenuKill4Menu = sqlRoundCTkillMenuKill4Menu.getString(1);
                RoundCTkillMenuKill4 = Integer.parseInt (sqlRoundCTstringkillMenuKill4Menu);}

            ResultSet sqlRoundTkillMenuKill4Menu =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTkillMenuKill4Menu .next() ){
                String sqlRoundTstringkillMenuKill4Menu = sqlRoundTkillMenuKill4Menu .getString(1);
                RoundTkillMenuKill4 = Integer.parseInt (sqlRoundTstringkillMenuKill4Menu);}

            ResultSet sqlWeapon1killMenuKill4Menu =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon1killMenuKill4Menu .next() ){
                killMenuKill4Weapon1 = sqlWeapon1killMenuKill4Menu .getString(1);
            }

            ResultSet sqlWeapon2killMenuKill4Menu =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon2killMenuKill4Menu .next() ){
                killMenuKill4Weapon2 = sqlWeapon2killMenuKill4Menu .getString(1);
            }

            ResultSet sqlZeuskillMenuKill4Menu =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlZeuskillMenuKill4Menu .next() ){
                killMenuKill4Zeus = sqlZeuskillMenuKill4Menu .getString(1);
            }

            ResultSet sqlGrenade1killMenuKill4Menu =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1killMenuKill4Menu .next() ){
                killMenuKill4Grenade1 = sqlGrenade1killMenuKill4Menu .getString(1);
            }

            ResultSet sqlGrenade2killMenuKill4Menu =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2killMenuKill4Menu .next() ){
                killMenuKill4Grenade2 = sqlGrenade2killMenuKill4Menu .getString(1);
            }

            ResultSet sqlGrenade3killMenuKill4Menu =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3killMenuKill4Menu .next() ){
                killMenuKill4Grenade3 = sqlGrenade3killMenuKill4Menu .getString(1);
            }

            ResultSet sqlGrenade4killMenuKill4Menu =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4killMenuKill4Menu .next() ){
                killMenuKill4Grenade4 = sqlGrenade4killMenuKill4Menu .getString(1);
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
        tRoundNum.setText(RoundCountkillMenuKill4 +  "");
        tBalance.setText(BalancekillMenuKill4 + "$");
        tCTscore.setText(RoundCTkillMenuKill4 + "");
        tTscore.setText(RoundTkillMenuKill4 + "");

        lKill4Weapon1.setText(killMenuKill4Weapon1);
        lKill4Weapon2.setText(killMenuKill4Weapon2);
        lKill4Zeus.setText(killMenuKill4Zeus);
        lKill4Grenade1.setText(killMenuKill4Grenade1);
        lKill4Grenade2.setText(killMenuKill4Grenade2);
        lKill4Grenade3.setText(killMenuKill4Grenade3);
        lKill4Grenade4.setText(killMenuKill4Grenade4);
        
        bQuitkillMenuKill4Menu.setEnabled(false);

        if(killMenuKill4Weapon1 == null){
            bKill4Weapon1.setEnabled(false);
        }
        if(killMenuKill4Weapon2 == null){
            bKill4Weapon2.setEnabled(false);
        }
        if(killMenuKill4Zeus == null){
            bKill4Zeus.setEnabled(false);
        }
        if(killMenuKill4Grenade1 == null){
            bKill4Grenade1.setEnabled(false);
        }
        if(killMenuKill4Grenade2 == null){
            bKill4Grenade2.setEnabled(false);
        }
        if(killMenuKill4Grenade3 == null){
            bKill4Grenade3.setEnabled(false);
        }
        if(killMenuKill4Grenade4 == null){
            bKill4Grenade4.setEnabled(false);
        }

    }

    public void actions(Object source,String command){
        if (source == bKill4Weapon1){

            if(killMenuKill4Weapon1.equals("Glock-18")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon1.equals("Dual Berettas")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon1.equals("P250")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon1.equals("CZ75-Auto")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 100;
            }
            if(killMenuKill4Weapon1.equals("Desert Eagle")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon1.equals("R8 Revolver")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon1.equals("Tec-9")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon1.equals("USP-S")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon1.equals("P2000")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon1.equals("Five-SeveN")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            
            if(BalancekillMenuKill4 > 16000){
                BalancekillMenuKill4 = 16000;
            }
            
            tBalance.setText(BalancekillMenuKill4 + "$");

            bKill4Weapon1.setEnabled(false);
            bKill4Weapon2.setEnabled(false);
            bKill4Zeus.setEnabled(false);
            bKill4Grenade1.setEnabled(false);
            bKill4Grenade2.setEnabled(false);
            bKill4Grenade3.setEnabled(false);
            bKill4Grenade4.setEnabled(false);
            bKill4Knife.setEnabled(false);
            bQuitkillMenuKill4Menu.setEnabled(true);
        }
        if (source == bKill4Weapon2){
            
            if(killMenuKill4Weapon2.equals("MAC-10")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 600;
            }
            if(killMenuKill4Weapon2.equals("MP5-SD")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 600;
            }
            if(killMenuKill4Weapon2.equals("MP7")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 600;
            }
            if(killMenuKill4Weapon2.equals("UMP-45")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 600;
            }
            if(killMenuKill4Weapon2.equals("P90")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("PP-Bizon")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 600;
            }
            if(killMenuKill4Weapon2.equals("MP9")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 600;
            }
            
            if(killMenuKill4Weapon2.equals("Galil AR")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("AK-47")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("SSG 08")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("SG 553")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("AWP")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 100;
            }
            if(killMenuKill4Weapon2.equals("G3SG1")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("FAMAS")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("M4A4")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("M4A1-S")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("AUG")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("SCAR-20")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            
            if(killMenuKill4Weapon2.equals("Nova")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 900;
            }
            if(killMenuKill4Weapon2.equals("XM1014")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 900;
            }
            if(killMenuKill4Weapon2.equals("Sawed-Off")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 900;
            }
            if(killMenuKill4Weapon2.equals("M249")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("Negev")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            }
            if(killMenuKill4Weapon2.equals("MAG-7")){
                BalancekillMenuKill4 = BalancekillMenuKill4 + 900;
            }
            if(BalancekillMenuKill4 > 16000){
                BalancekillMenuKill4 = 16000;
            }
            tBalance.setText(BalancekillMenuKill4 + "$");
            bKill4Weapon1.setEnabled(false);
            bKill4Weapon2.setEnabled(false);
            bKill4Zeus.setEnabled(false);
            bKill4Grenade1.setEnabled(false);
            bKill4Grenade2.setEnabled(false);
            bKill4Grenade3.setEnabled(false);
            bKill4Grenade4.setEnabled(false);
            bKill4Knife.setEnabled(false);
            bQuitkillMenuKill4Menu.setEnabled(true);
        }
        if (source == bKill4Zeus){
            bKill4Weapon1.setEnabled(false);
            bKill4Weapon2.setEnabled(false);
            bKill4Zeus.setEnabled(false);
            bKill4Grenade1.setEnabled(false);
            bKill4Grenade2.setEnabled(false);
            bKill4Grenade3.setEnabled(false);
            bKill4Grenade4.setEnabled(false);
            bKill4Knife.setEnabled(false);
            bQuitkillMenuKill4Menu.setEnabled(true);
            killMenuKill4Zeus = null;
        }
        if (source == bKill4Grenade1){
            BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            if(BalancekillMenuKill4 > 16000){
                BalancekillMenuKill4 = 16000;
            }
            tBalance.setText(BalancekillMenuKill4 + "$");
            bKill4Weapon1.setEnabled(false);
            bKill4Weapon2.setEnabled(false);
            bKill4Zeus.setEnabled(false);
            bKill4Grenade1.setEnabled(false);
            bKill4Grenade2.setEnabled(false);
            bKill4Grenade3.setEnabled(false);
            bKill4Grenade4.setEnabled(false);
            bKill4Knife.setEnabled(false);
            bQuitkillMenuKill4Menu.setEnabled(true);
            killMenuKill4Grenade1 = null;
        }
        if (source == bKill4Grenade2){
            BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            if(BalancekillMenuKill4 > 16000){
                BalancekillMenuKill4 = 16000;
            }
            tBalance.setText(BalancekillMenuKill4 + "$");
            bKill4Weapon1.setEnabled(false);
            bKill4Weapon2.setEnabled(false);
            bKill4Zeus.setEnabled(false);
            bKill4Grenade1.setEnabled(false);
            bKill4Grenade2.setEnabled(false);
            bKill4Grenade3.setEnabled(false);
            bKill4Grenade4.setEnabled(false);
            bKill4Knife.setEnabled(false);
            bQuitkillMenuKill4Menu.setEnabled(true);
            killMenuKill4Grenade2 = null;
        }
        if (source == bKill4Grenade3){
            BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            if(BalancekillMenuKill4 > 16000){
                BalancekillMenuKill4 = 16000;
            }
            tBalance.setText(BalancekillMenuKill4 + "$");
            bKill4Weapon1.setEnabled(false);
            bKill4Weapon2.setEnabled(false);
            bKill4Zeus.setEnabled(false);
            bKill4Grenade1.setEnabled(false);
            bKill4Grenade2.setEnabled(false);
            bKill4Grenade3.setEnabled(false);
            bKill4Grenade4.setEnabled(false);
            bKill4Knife.setEnabled(false);
            bQuitkillMenuKill4Menu.setEnabled(true);
            killMenuKill4Grenade3 = null;
        }
        if (source == bKill4Grenade4){
            BalancekillMenuKill4 = BalancekillMenuKill4 + 300;
            if(BalancekillMenuKill4 > 16000){
                BalancekillMenuKill4 = 16000;
            }
            tBalance.setText(BalancekillMenuKill4 + "$");
            bKill4Weapon1.setEnabled(false);
            bKill4Weapon2.setEnabled(false);
            bKill4Zeus.setEnabled(false);
            bKill4Grenade1.setEnabled(false);
            bKill4Grenade2.setEnabled(false);
            bKill4Grenade3.setEnabled(false);
            bKill4Grenade4.setEnabled(false);
            bKill4Knife.setEnabled(false);
            bQuitkillMenuKill4Menu.setEnabled(true);
            killMenuKill4Grenade4 = null;
        }
        if (source == bKill4Knife){
            BalancekillMenuKill4 = BalancekillMenuKill4 + 1500;
            if(BalancekillMenuKill4 > 16000){
                BalancekillMenuKill4 = 16000;
            }
            tBalance.setText(BalancekillMenuKill4 + "$");
            bKill4Weapon1.setEnabled(false);
            bKill4Weapon2.setEnabled(false);
            bKill4Zeus.setEnabled(false);
            bKill4Grenade1.setEnabled(false);
            bKill4Grenade2.setEnabled(false);
            bKill4Grenade3.setEnabled(false);
            bKill4Grenade4.setEnabled(false);
            bKill4Knife.setEnabled(false);
            bQuitkillMenuKill4Menu.setEnabled(true);
        }
        if (source == bQuitkillMenuKill4Menu){
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

                int Kill1balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+BalancekillMenuKill4+" WHERE idNumCS = 1;");

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Grenade1 = ?, Grenade2 = ?, Grenade3 =?, Grenade4 =?, Zeus = ? WHERE idNumCS = 1;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1,killMenuKill4Grenade1);
                preparedStatement.setString(2,killMenuKill4Grenade2);
                preparedStatement.setString(3,killMenuKill4Grenade3);
                preparedStatement.setString(4,killMenuKill4Grenade4);
                preparedStatement.setString(5,killMenuKill4Zeus);

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
