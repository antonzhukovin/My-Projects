package myProject;

import java.awt.*;
import java.sql.*;

public class ResultRound extends EasyApp
{
    public static void main(String[] args)
    {  new ResultRound();}

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,800,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Button bCountinue = addButton("Continue",850,550,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,50,30,this);
    Label lRoundNum = addLabel("Round: ",455,800,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    Label lDropWeapon1 = addLabel("",337,100,200,30,this);
    Label lDropWeapon2 = addLabel("",337,200,200,30,this);
    Label lDropZeus = addLabel("",337,300,200,30,this);
    Label lDropGrenade1 = addLabel("",337,400,200,30,this);
    Label lDropGrenade2 = addLabel("",337,500,200,30,this);
    Label lDropGrenade3 = addLabel("",337,600,200,30,this);
    Label lDropGrenade4 = addLabel("",337,700,200,30,this);
    Label lRoundWin = addLabel("",700,120,700,200,this);
    Label lEndGame = addLabel("",500,220,400,200,this); //alias
    Label lGameOver = addLabel("",500,320,400,200,this);

    int RoundCountresultRound; 
    int BalanceresultRound; 
    int RoundCTresultRound;
    int RoundTresultRound;
    String resultRoundWeapon1;
    String resultRoundWeapon2;
    String resultRoundZeus;
    String resultRoundGrenade1;
    String resultRoundGrenade2;
    String resultRoundGrenade3;
    String resultRoundGrenade4;
    String sqlSidestring;
    String sqlCTuspsORp2000string;

    String sqlHowDidYouWinTheRoundString; 

    public ResultRound(){
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

            ResultSet sqlRoundCountresultRound =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountresultRound.next() ){
                String sqlRoundCountstringresultRound = sqlRoundCountresultRound.getString(1);
                RoundCountresultRound = Integer.parseInt (sqlRoundCountstringresultRound);}

            ResultSet rsBalanceresultRound = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalanceresultRound.next() ){
                String rs1BalancestringresultRound = rsBalanceresultRound.getString(1);
                BalanceresultRound = Integer.parseInt (rs1BalancestringresultRound);}

            ResultSet sqlRoundCTresultRound =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTresultRound.next() ){
                String sqlRoundCTstringresultRound = sqlRoundCTresultRound.getString(1);
                RoundCTresultRound = Integer.parseInt (sqlRoundCTstringresultRound);}

            ResultSet sqlRoundTresultRound =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTresultRound .next() ){
                String sqlRoundTstringresultRound = sqlRoundTresultRound .getString(1);
                RoundTresultRound = Integer.parseInt (sqlRoundTstringresultRound);}

            ResultSet sqlWeapon1resultRound =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon1resultRound .next() ){
                resultRoundWeapon1 = sqlWeapon1resultRound .getString(1);
            }

            ResultSet sqlWeapon2resultRound =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon2resultRound .next() ){
                resultRoundWeapon2 = sqlWeapon2resultRound .getString(1);
            }

            ResultSet sqlZeusresultRound =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlZeusresultRound .next() ){
                resultRoundZeus = sqlZeusresultRound .getString(1);
            }

            ResultSet sqlGrenade1resultRound =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1resultRound .next() ){
                resultRoundGrenade1 = sqlGrenade1resultRound .getString(1);
            }

            ResultSet sqlGrenade2resultRound =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2resultRound .next() ){
                resultRoundGrenade2 = sqlGrenade2resultRound .getString(1);
            }

            ResultSet sqlGrenade3resultRound =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3resultRound .next() ){
                resultRoundGrenade3 = sqlGrenade3resultRound .getString(1);
            }

            ResultSet sqlGrenade4resultRound =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4resultRound .next() ){
                resultRoundGrenade4 = sqlGrenade4resultRound .getString(1);
            }

            ResultSet sqlHowDidYouWinTheRound =  stmt.executeQuery( "SELECT howDidYouWinTheRound FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlHowDidYouWinTheRound.next() ){
                sqlHowDidYouWinTheRoundString = sqlHowDidYouWinTheRound.getString(1);
            }

            ResultSet sqlSide =  stmt.executeQuery( "SELECT SideChoice FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlSide.next() ){
                sqlSidestring = sqlSide.getString(1);}

            ResultSet sqlCTuspsORp2000 =  stmt.executeQuery( "SELECT CTuspsORp2000 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while(sqlCTuspsORp2000.next() ){
                sqlCTuspsORp2000string = sqlCTuspsORp2000.getString(1);}

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
        tRoundNum.setText(RoundCountresultRound +  "");
        tBalance.setText(BalanceresultRound + "$");
        tCTscore.setText(RoundCTresultRound + "");
        tTscore.setText(RoundTresultRound + "");

        lDropWeapon1.setText(resultRoundWeapon1);
        lDropWeapon2.setText(resultRoundWeapon2);
        lDropZeus.setText(resultRoundZeus);
        lDropGrenade1.setText(resultRoundGrenade1);
        lDropGrenade2.setText(resultRoundGrenade2);
        lDropGrenade3.setText(resultRoundGrenade3);
        lDropGrenade4.setText(resultRoundGrenade4);
        lRoundWin.setText(sqlHowDidYouWinTheRoundString);

    }

    public void actions(Object source,String command){
        if(RoundCTresultRound == 16){ //alias
            if(sqlSidestring.equals("CTSide")){
                lEndGame.setText("You have won the game!");
                lGameOver.setText("The game is over");
            }else if(sqlSidestring.equals("TSide")){
                lEndGame.setText("You have lost the game");
                lGameOver.setText("The game is over");
            }
        }
        if(RoundTresultRound == 16){ //alias
            if(sqlSidestring.equals("TSide")){
                lEndGame.setText("You have won the game!");
                lGameOver.setText("The game is over");
            }else if(sqlSidestring.equals("CTSide")){
                lEndGame.setText("You have lost the game");
                lGameOver.setText("The game is over");
            }
        }
        if(RoundTresultRound == 15 && RoundCTresultRound == 15){ //alias
            lEndGame.setText("It's a draw!");
            lGameOver.setText("The game is over");
        }

        if(RoundCountresultRound == 16){ //if it is the 16th round, the sides should be changed
            if(sqlSidestring.equals("TSide")){ //if the player is playing for T side, it should change to CT
                sqlSidestring = "CTSide";
            }else if(sqlSidestring.equals("CTSide")){ //if the player is playing for CT side, it should change to T
                sqlSidestring = "TSide";
            }
            RoundCTresultRound = RoundTresultRound; //the score is connected to the team, not to the side, so the team should keep it score when changing side
            RoundTresultRound = RoundCTresultRound; //the score is connected to the team, not to the side, so the team should keep it score when changing side
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

                int balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = 800 WHERE idNumCS = 1;"); //the balance should reset to original value
                int roundTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundT = "+RoundTresultRound+" WHERE idNumCS = 1;"); //the score is connected to the team, not to the side, so the team should keep it score when changing side
                int roundCTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCT = "+RoundCTresultRound+" WHERE idNumCS = 1;"); //the score is connected to the team, not to the side, so the team should keep it score when changing side

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Weapon1 = ?, Weapon2 = ?, Grenade1 = ?, Grenade2 = ?, Grenade3 =?, Grenade4 =?, Zeus = ?, Armor = ?, SideChoice = ? WHERE idNumCS = 1;"; //everything should be set to default when changing side
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1,null);
                preparedStatement.setString(2,null);
                preparedStatement.setString(3,null);
                preparedStatement.setString(4,null);
                preparedStatement.setString(5,null);
                preparedStatement.setString(6,null);
                preparedStatement.setString(7,null);
                preparedStatement.setString(8,null);
                preparedStatement.setString(9,sqlSidestring);

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
            if(sqlSidestring.equals("TSide")){
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

                    String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Weapon1 = ? WHERE idNumCS = 1;";
                    PreparedStatement preparedStatement = conn.prepareStatement(query);

                    preparedStatement.setString(1,"Glock-18");

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

            }
            if(sqlSidestring.equals("CTSide")){
                if(sqlCTuspsORp2000string.equals("CTUSPS")){
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

                        String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Weapon1 = ? WHERE idNumCS = 1;";
                        PreparedStatement preparedStatement = conn.prepareStatement(query);

                        preparedStatement.setString(1,"USP-S");

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
                }else if(sqlCTuspsORp2000string.equals("CTP2000")){
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

                        String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Weapon1 = ? WHERE idNumCS = 1;";
                        PreparedStatement preparedStatement = conn.prepareStatement(query);

                        preparedStatement.setString(1,"P2000");

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
                }

            }
        }

        if (source == bCountinue){
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

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET MainGameCondition = ?, HMKCondition = ?, BombPlant = ?, buttonBombPlant = ?, buttonSuicideReward = ?, buttonGrenadeUse = ?, buttonTeamKill = ?, buttonSurvive = ? WHERE idNumCS = 1;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1,"BuyMenu");
                preparedStatement.setString(2,"False");
                preparedStatement.setString(3,"False");
                preparedStatement.setString(4,"False");
                preparedStatement.setString(5,"False");
                preparedStatement.setString(6,"False");
                preparedStatement.setString(7,"False");
                preparedStatement.setString(8,"False");

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
            new MainGameT();
            dispose(); 
            if(RoundCTresultRound == 16 || RoundCTresultRound == 16 || RoundCountresultRound == 30){
                dispose();
            }
        }
    }
}
