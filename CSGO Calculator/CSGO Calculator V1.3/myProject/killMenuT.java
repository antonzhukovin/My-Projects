package myProject;

import java.awt.*;
import java.sql.*;

public class killMenuT extends EasyApp
{
    public static void main(String[] args)
    { 
        new killMenuT();
    }

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,650,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Button bDropPick = addButton("Did you pick/drop the weapon?",0,420,220,100,this);

    Button bKill1 = addButton("Kill №1",366,120,220,100,this);
    Button bKill2 = addButton("Kill №2",366,220,220,100,this);
    Button bKill3 = addButton("Kill №3",366,320,220,100,this);
    Button bKill4 = addButton("Kill №4",366,420,220,100,this);
    Button bKill5 = addButton("Kill №5",366,520,220,100,this);

    Button bQuitKillTMenu = addButton("Go Back",850,750,150,100,this);
    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,50,30,this);
    Label lRoundNum = addLabel("Round: ",455,650,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    int intRSBalanceGameT;
    int intSQLRoundCTGameT;
    int intSQLRoundTGameT;
    int intSQLRoundNumberGameT;
    int intSQLKillMenuKillNumber;

    String killMenuWeapon1; 
    String killMenuWeapon2;
    String killMenuZeus;
    String killMenuGrenade1;
    String killMenuGrenade2;
    String killMenuGrenade3;
    String killMenuGrenade4;

    int killNumber;
    int intSQLKillMenuKillEntryNumber;

    public killMenuT()   // Constructor - change window appearance
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

            ResultSet sqlRoundCount =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCount.next() ){
                String sqlRoundCountstring = sqlRoundCount.getString(1);
                intSQLRoundNumberGameT = Integer.parseInt (sqlRoundCountstring);}

            ResultSet rsBalance = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS = 1;" ) ; 
            // Loop through the result set

            while( rsBalance.next() ){
                String rs1Balancestring = rsBalance.getString(1);
                intRSBalanceGameT = Integer.parseInt (rs1Balancestring);}

            ResultSet sqlRoundCT =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlRoundCT.next() ){
                String sqlRoundCTstring = sqlRoundCT.getString(1);
                intSQLRoundCTGameT = Integer.parseInt (sqlRoundCTstring);}

            ResultSet sqlRoundT =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundT.next() ){
                String sqlRoundTstring = sqlRoundT.getString(1);
                intSQLRoundTGameT = Integer.parseInt (sqlRoundTstring);}

            ResultSet sqlWeapon1KillMenu =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon1KillMenu .next() ){
                killMenuWeapon1 = sqlWeapon1KillMenu .getString(1);
            }

            ResultSet sqlWeapon2KillMenu =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon2KillMenu .next() ){
                killMenuWeapon2 = sqlWeapon2KillMenu .getString(1);
            }

            ResultSet sqlZeusKillMenu =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlZeusKillMenu .next() ){
                killMenuZeus = sqlZeusKillMenu .getString(1);
            }

            ResultSet sqlGrenade1KillMenu =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1KillMenu .next() ){
                killMenuGrenade1 = sqlGrenade1KillMenu .getString(1);
            }

            ResultSet sqlGrenade2KillMenu =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2KillMenu .next() ){
                killMenuGrenade2 = sqlGrenade2KillMenu .getString(1);
            }

            ResultSet sqlGrenade3KillMenu =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3KillMenu .next() ){
                killMenuGrenade3 = sqlGrenade3KillMenu .getString(1);
            }

            ResultSet sqlGrenade4KillMenu =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4KillMenu .next() ){
                killMenuGrenade4 = sqlGrenade4KillMenu .getString(1);
            }

            ResultSet sqlKillNumber =  stmt.executeQuery( "SELECT KillNumber FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while(sqlKillNumber .next() ){
                String killMenuKillNumber = sqlKillNumber.getString(1);
                intSQLKillMenuKillNumber = Integer.parseInt (killMenuKillNumber);
            }
            
            ResultSet sqlKillEntryNumber =  stmt.executeQuery( "SELECT KillEntryNumber FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while(sqlKillEntryNumber.next() ){
                String killMenuKillEntryNumber = sqlKillEntryNumber.getString(1);
                intSQLKillMenuKillEntryNumber = Integer.parseInt (killMenuKillEntryNumber);
            }

            //finish it 
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

        setSize(1920,1080);
        setTitle("CS:GO Economy - (c) 2021 Anton Zhukovin, Russia");
        setBackground(new Color(255,255,180));
        tRoundNum.setText(intSQLRoundNumberGameT +  "");
        tBalance.setText(intRSBalanceGameT + "$");
        tCTscore.setText(intSQLRoundCTGameT + "");
        tTscore.setText(intSQLRoundTGameT+ "");

        bKill1.setVisible(false);
        bKill2.setVisible(false);
        bKill3.setVisible(false);
        bKill4.setVisible(false);
        bKill5.setVisible(false);
        
        bKill1.setEnabled(false);
        bKill2.setEnabled(false);
        bKill3.setEnabled(false);
        bKill4.setEnabled(false);
        bKill5.setEnabled(false);

        bQuitKillTMenu.setEnabled(false);
        
        if(intSQLKillMenuKillNumber >= 1 && intSQLKillMenuKillEntryNumber == 0){
            intSQLKillMenuKillEntryNumber = 1;
        }

        if(intSQLKillMenuKillNumber == 1){
            bKill1.setVisible(true);
        }
        else if(intSQLKillMenuKillNumber == 2){
            bKill1.setVisible(true);
            bKill2.setVisible(true);
        }
        else if(intSQLKillMenuKillNumber == 3){
            bKill1.setVisible(true);
            bKill2.setVisible(true);
            bKill3.setVisible(true);
        }
        else if(intSQLKillMenuKillNumber == 4){
            bKill1.setVisible(true);
            bKill2.setVisible(true);
            bKill3.setVisible(true);
            bKill4.setVisible(true);
        }
        else if(intSQLKillMenuKillNumber == 5){
            bKill1.setVisible(true);
            bKill2.setVisible(true);
            bKill3.setVisible(true);
            bKill4.setVisible(true);
            bKill5.setVisible(true);
        }
        
        if(intSQLKillMenuKillEntryNumber > intSQLKillMenuKillNumber){
            bQuitKillTMenu.setEnabled(true);
        }
        
        
        if(intSQLKillMenuKillEntryNumber == 1){
            bKill1.setEnabled(true);
        }else if(intSQLKillMenuKillEntryNumber == 2){
            bKill2.setEnabled(true);
        }else if(intSQLKillMenuKillEntryNumber == 3){
            bKill3.setEnabled(true);
        }else if(intSQLKillMenuKillEntryNumber == 4){
            bKill4.setEnabled(true);
        }else if(intSQLKillMenuKillEntryNumber == 5){
            bKill5.setEnabled(true);
        }

    }

    public void actions(Object source,String command){
        if(source == bKill1){
            intSQLKillMenuKillEntryNumber = 2;
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

                int Kill1KillEntryNumberUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET KillEntryNumber = "+intSQLKillMenuKillEntryNumber+" WHERE idNumCS = 1;");

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
            new Kill1();
            dispose();
        }
        if(source == bKill2){
            intSQLKillMenuKillEntryNumber = 3;
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

                int Kill2KillEntryNumberUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET KillEntryNumber = "+intSQLKillMenuKillEntryNumber+" WHERE idNumCS = 1;");

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
            new Kill2(); //change to Kill2
            dispose();
        }
        if(source == bKill3){
            intSQLKillMenuKillEntryNumber = 4;
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

                int Kill3KillEntryNumberUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET KillEntryNumber = "+intSQLKillMenuKillEntryNumber+" WHERE idNumCS = 1;");

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
            new Kill3(); //change to Kill3
            dispose();
        }
        if(source == bKill4){
            intSQLKillMenuKillEntryNumber = 5;
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

                int Kill4KillEntryNumberUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET KillEntryNumber = "+intSQLKillMenuKillEntryNumber+" WHERE idNumCS = 1;");

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
            new Kill4(); //change to Kill4
            dispose();
        }
        if(source == bKill5){
            intSQLKillMenuKillEntryNumber = 6;
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

                int Kill5KillEntryNumberUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET KillEntryNumber = "+intSQLKillMenuKillEntryNumber+" WHERE idNumCS = 1;");

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
            new Kill5(); //change to Kill5
            dispose();
        }
        if(source == bDropPick){
            new killMenuTPickDrop();
            dispose();
        }
        if(source == bQuitKillTMenu){
            new GameT();
            dispose();
        }
        
    }
}
