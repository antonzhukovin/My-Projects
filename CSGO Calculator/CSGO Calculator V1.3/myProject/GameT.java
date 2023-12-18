package myProject;

import java.awt.*;
import java.sql.*;

public class GameT extends EasyApp
{
    public static void main(String[] args)
    { 
        new GameT();
    }

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,650,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Button bHowManyKills = addButton("How many kills?",0,120,220,100, this);
    Button bKillMenu = addButton("Kill Menu",0,220,220,100, this);
    Button bBombPlant = addButton("Did you plant the bomb?",0,320,220,100, this);
    Button bDropPick = addButton("Did you pick/drop the weapon?",0,420,220,100,this);
    Button bGrenadeUse = addButton("Did you use grenades?",0,520,220,100,this);
    Button bSuicideReward = addButton("Did you get a suicide reward?",0,620,220,100,this);
    Button bTeamKill = addButton("Did you make a team kill?",0,720,220,100,this);

    Button bGrenade1 = addButton("Grenade 1",400,120,220,100, this);
    Button bGrenade2 = addButton("Grenade 2",400,220,220,100, this);
    Button bGrenade3 = addButton("Grenade 3",400,320,220,100, this);
    Button bGrenade4 = addButton("Grenade 4",400,420,220,100, this);

    Button bFinishGrenadeUse = addButton("Finish with grenades",640,220,220,100, this);

    Button bQuitbuyMenuGameTMenu = addButton("Go Back",850,750,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,50,30,this);
    Label lRoundNum = addLabel("Round: ",455,650,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    Label lGrenade1 = addLabel("",250,120,100,30,this);
    Label lGrenade2 = addLabel("",250,220,100,30,this);
    Label lGrenade3 = addLabel("",250,320,100,30,this);
    Label lGrenade4 = addLabel("",250,420,100,30,this);

    int intRSBalanceGameT;
    int intSQLRoundCTGameT;
    int intSQLRoundTGameT;
    int intSQLRoundNumberGameT;

    String sqlHMKconditionString;
    String BombPlantString;
    String GameTGrenade1;
    String GameTGrenade2;
    String GameTGrenade3;
    String GameTGrenade4;

    String buttonBombPlantString;
    String buttonSuicideRewardString;
    String buttonGrenadeUseString;
    String buttonTeamKillString;

    String GameTMenuWeapon1;
    String GameTMenuWeapon2;

    int killNumber;

    boolean BombPlantButtonBoolean = false;
    boolean SuicideRewardButtonBoolean = false;
    boolean TeamKillButtonBoolean = false;
    boolean GrenadeUseButtonBoolean = false; 

    String BombPlantButtonString = "False";
    String SuicideRewardButtonString = "False";
    String TeamKillButtonString = "False";
    String GrenadeUseButtonString = "False";
    
    String sqlStringSide;

    public GameT()   // Constructor - change window appearance
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

            ResultSet sqlHMKcondition =  stmt.executeQuery( "SELECT HMKcondition FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlHMKcondition.next() ){
                sqlHMKconditionString = sqlHMKcondition.getString(1);}

            ResultSet sqlGrenade1GameT =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1GameT .next() ){
                GameTGrenade1 = sqlGrenade1GameT .getString(1);
            }

            ResultSet sqlGrenade2GameT =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2GameT .next() ){
                GameTGrenade2 = sqlGrenade2GameT .getString(1);
            }

            ResultSet sqlGrenade3GameT =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3GameT .next() ){
                GameTGrenade3 = sqlGrenade3GameT .getString(1);
            }

            ResultSet sqlGrenade4GameT =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4GameT .next() ){
                GameTGrenade4 = sqlGrenade4GameT .getString(1);
            }    

            ResultSet sqlbuttonBombPlant =  stmt.executeQuery( "SELECT buttonBombPlant FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlbuttonBombPlant.next() ){
                buttonBombPlantString = sqlbuttonBombPlant.getString(1);
            }

            ResultSet sqlbuttonSuicideReward =  stmt.executeQuery( "SELECT buttonSuicideReward FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlbuttonSuicideReward.next() ){
                buttonSuicideRewardString = sqlbuttonSuicideReward.getString(1);
            }    

            ResultSet sqlbuttonGrenadeUse =  stmt.executeQuery( "SELECT buttonGrenadeUse FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlbuttonGrenadeUse.next() ){
                buttonGrenadeUseString = sqlbuttonGrenadeUse.getString(1);
            }

            ResultSet sqlbuttonTeamKill =  stmt.executeQuery( "SELECT buttonTeamKill FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while(sqlbuttonTeamKill.next() ){
                buttonTeamKillString = sqlbuttonTeamKill.getString(1);
            }

            ResultSet sqlGameTMenuWeapon1 =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGameTMenuWeapon1 .next() ){
                GameTMenuWeapon1 = sqlGameTMenuWeapon1.getString(1);
            }

            ResultSet sqlGameTMenuWeapon2 =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGameTMenuWeapon2 .next() ){
                GameTMenuWeapon2 = sqlGameTMenuWeapon2.getString(1);
            }
            
            ResultSet sqlSide = stmt.executeQuery( "SELECT SideChoice FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while(sqlSide.next() ){
                sqlStringSide = sqlSide.getString(1);}

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

        bGrenade1.setVisible(false);
        bGrenade2.setVisible(false);
        bGrenade3.setVisible(false);
        bGrenade4.setVisible(false);
        bFinishGrenadeUse.setVisible(false);
        if(sqlStringSide.equals("CTSide")){
            bBombPlant.setVisible(false);
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

                        String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET buttonBombPlant = ? WHERE idNumCS = 1";
                        PreparedStatement preparedStatement = conn.prepareStatement(query);

                        preparedStatement.setString(1, "True");

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
            BombPlantButtonBoolean = true;
            BombPlantButtonString = "True";
            tBalance.setText(intRSBalanceGameT + "$");
            bBombPlant.setEnabled(false);
        }
        
        if(buttonBombPlantString.equals("True")){
            bBombPlant.setEnabled(false);
        }
        if(buttonSuicideRewardString.equals("True")){
            bSuicideReward.setEnabled(false);
        }
        if(buttonGrenadeUseString.equals("True")){
            bGrenadeUse.setEnabled(false);
        }
        if(buttonTeamKillString.equals("True")){
            bTeamKill.setEnabled(false);
        }

        if(sqlHMKconditionString.equals("False")){
            bBombPlant.setEnabled(false);
            bKillMenu.setEnabled(false);
            bDropPick.setEnabled(false);
            bGrenadeUse.setEnabled(false);
            bSuicideReward.setEnabled(false);
            bQuitbuyMenuGameTMenu.setEnabled(false);
            bTeamKill.setEnabled(false);
        }else if(sqlHMKconditionString.equals("True")){
            bHowManyKills.setEnabled(false);
            bKillMenu.setEnabled(false);
            bQuitbuyMenuGameTMenu.setEnabled(false);
        }
        if(buttonTeamKillString.equals("True") && buttonSuicideRewardString.equals("True") && buttonBombPlantString.equals("True") && buttonGrenadeUseString.equals("True")){
            bQuitbuyMenuGameTMenu.setEnabled(true);
        }

    }

    public void actions(Object source,String command){
        if(source == bHowManyKills){ //the button to enter the number of kills done in the round
            boolean howManyKillsCondition = false; //the condition for the loop
            while(howManyKillsCondition == false){ //run the loop until the condition is met
                int killNumberHowManyKills = inputInt("How many kills have you done? 0-5"); //calls an input field 
                if(killNumberHowManyKills == 0){
                    howManyKillsCondition = true;
                    bHowManyKills.setEnabled(false); 
                    bBombPlant.setEnabled(true);
                    bDropPick.setEnabled(true);
                    bGrenadeUse.setEnabled(true);
                    bSuicideReward.setEnabled(true);
                    bTeamKill.setEnabled(true);
                    killNumber = 0;
                    sqlHMKconditionString = "True";
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

                int killNumberUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET KillNumber = "+killNumber+" WHERE idNumCS = 1;");

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET HMKcondition = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, sqlHMKconditionString);

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
                else if(killNumberHowManyKills == 1){
                    howManyKillsCondition = true;
                    bHowManyKills.setEnabled(false);
                    bKillMenu.setEnabled(true);
                    killNumber = 1;
                }
                else if(killNumberHowManyKills == 2){
                    howManyKillsCondition = true;
                    bHowManyKills.setEnabled(false);
                    bKillMenu.setEnabled(true);
                    killNumber = 2;
                }
                else if(killNumberHowManyKills == 3){
                    howManyKillsCondition = true;
                    bHowManyKills.setEnabled(false);
                    bKillMenu.setEnabled(true);
                    killNumber = 3;
                }
                else if(killNumberHowManyKills == 4){
                    howManyKillsCondition = true;
                    bHowManyKills.setEnabled(false);
                    bKillMenu.setEnabled(true);
                    killNumber = 4;
                }
                else if(killNumberHowManyKills == 5){
                    howManyKillsCondition = true;
                    bHowManyKills.setEnabled(false);
                    bKillMenu.setEnabled(true);
                    killNumber = 5;
                }else{
                    howManyKillsCondition = false;
                }

            }
        }
        if(source == bKillMenu){
            sqlHMKconditionString = "True";
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

                int killNumberUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET KillNumber = "+killNumber+" WHERE idNumCS = 1;");

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET HMKcondition = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, sqlHMKconditionString);

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
        if(source == bBombPlant) {
            boolean BombPlantBoolean = false;
            while(BombPlantBoolean == false){
                String bombPlantQuestion = inputString("Did you plant the bomb? Y/N");
                if(bombPlantQuestion.equals("Y")){
                    intRSBalanceGameT = intRSBalanceGameT + 300;
                    if (intRSBalanceGameT > 16000){
                        intRSBalanceGameT = 16000;
                    }
                    BombPlantString = "True";
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

                        int balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalanceGameT+" WHERE idNumCS = 1;");

                        String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET BombPlant = ?, buttonBombPlant = ? WHERE idNumCS = 1";
                        PreparedStatement preparedStatement = conn.prepareStatement(query);

                        preparedStatement.setString(1, BombPlantString);
                        preparedStatement.setString(2, "True");

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
                    BombPlantBoolean = true;
                }else if(bombPlantQuestion.equals("N")){
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

                        String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET buttonBombPlant = ? WHERE idNumCS = 1";
                        PreparedStatement preparedStatement = conn.prepareStatement(query);

                        preparedStatement.setString(1, "True");

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
                    BombPlantBoolean = true;
                }else{
                    BombPlantBoolean = false;
                } 
            }
            BombPlantButtonBoolean = true;
            BombPlantButtonString = "True";
            tBalance.setText(intRSBalanceGameT + "$");
            bBombPlant.setEnabled(false);
        }
    
        if(source == bGrenade1){
            GameTGrenade1 = null;
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

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Grenade1 = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, GameTGrenade1);

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
            bGrenade1.setEnabled(false);
        }
        if(source == bGrenade2){
            GameTGrenade2 = null;
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

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Grenade2 = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, GameTGrenade2);

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
            bGrenade2.setEnabled(false);
        }
        if(source == bGrenade3){
            GameTGrenade3 = null;
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

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Grenade3 = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, GameTGrenade3);

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
            bGrenade3.setEnabled(false);
        }
        if(source == bGrenade4){
            GameTGrenade4 = null;
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

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Grenade4 = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, GameTGrenade4);

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
            bGrenade4.setEnabled(false);
        }

        if(source == bSuicideReward){
            boolean suicideReward = false;
            while(suicideReward == false){
                String suicideRewardString = inputString("Did you get a suicide reward? Y/N");
                if(suicideRewardString.equals("Y")){
                    boolean whichSuicideReward = false;
                    while(whichSuicideReward == false){
                        int WhichSuicideReward = inputInt("Which suicide reward did you get? 100/300/600/900");
                        if(WhichSuicideReward == 100){
                            intRSBalanceGameT = intRSBalanceGameT + 100;
                            whichSuicideReward = true;
                        }else if(WhichSuicideReward == 300){
                            intRSBalanceGameT = intRSBalanceGameT + 300;
                            whichSuicideReward = true;
                        }else if(WhichSuicideReward == 600){
                            intRSBalanceGameT = intRSBalanceGameT + 600;
                            whichSuicideReward = true;
                        }else if(WhichSuicideReward == 900){
                            intRSBalanceGameT = intRSBalanceGameT + 900;
                            whichSuicideReward = true;
                        }else{
                            whichSuicideReward = false;
                        }
                    }
                    suicideReward = true;
                }else if(suicideRewardString.equals("N")){
                    suicideReward = true;
                }else{
                    suicideReward = false;
                }
            }
            tBalance.setText(intRSBalanceGameT + "$");
            bSuicideReward.setEnabled(false);
            SuicideRewardButtonBoolean = true;
            SuicideRewardButtonString = "True";

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

                int balance1Update = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalanceGameT+" WHERE idNumCS = 1;");

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET buttonSuicideReward = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, "True");

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
        if(source == bTeamKill){
            boolean bTeamKillBoolean = false;
            while(bTeamKillBoolean == false){
                String bTeamKillString = inputString("Did you make a team kill? Y/N");
                if(bTeamKillString.equals("Y")){
                    boolean bTeamKillString1 = false;
                    while(bTeamKillString1 == false){
                        int bTeamKillString1INT = inputInt("How many teamkills did you make? 1-4");
                        if(bTeamKillString1INT == 1){
                            intRSBalanceGameT = intRSBalanceGameT - 300;
                            bTeamKillString1 = true;
                        }else if(bTeamKillString1INT == 2){
                            intRSBalanceGameT = intRSBalanceGameT - 600;
                            bTeamKillString1 = true;
                        }else if(bTeamKillString1INT == 3){
                            intRSBalanceGameT = intRSBalanceGameT - 900;
                            bTeamKillString1 = true;
                        }else if(bTeamKillString1INT == 4){
                            intRSBalanceGameT = intRSBalanceGameT - 1200;
                            bTeamKillString1 = true;
                        }else{
                            bTeamKillString1 = false;
                        }
                    }
                    bTeamKillBoolean = true;
                }else if(bTeamKillString.equals("N")){
                    bTeamKillBoolean = true;
                }else{
                    bTeamKillBoolean = false;
                }
            }
            tBalance.setText(intRSBalanceGameT + "$");
            bTeamKill.setEnabled(false);
            TeamKillButtonBoolean = true;
            TeamKillButtonString = "True";
            if(intRSBalanceGameT < 0){
                intRSBalanceGameT = 0;
            }
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

                int balance1Update = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalanceGameT+" WHERE idNumCS = 1;");

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET buttonTeamKill = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, "True");

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
        if(source == bGrenadeUse){
            boolean GrenadeUseBoolean = false;
            while(GrenadeUseBoolean == false){
                String GrenadeUseQuestion = inputString("Did you use grenades? Y/N");
                if(GrenadeUseQuestion.equals("Y")){
                    if(GameTGrenade1 != null){
                        bGrenade1.setVisible(true);
                        lGrenade1.setText(GameTGrenade1);
                    }
                    if(GameTGrenade2 != null){
                        bGrenade2.setVisible(true);
                        lGrenade2.setText(GameTGrenade2);
                    }
                    if(GameTGrenade3 != null){
                        bGrenade3.setVisible(true);
                        lGrenade3.setText(GameTGrenade3);
                    }
                    if(GameTGrenade4 != null){
                        bGrenade4.setVisible(true);
                        lGrenade4.setText(GameTGrenade4);
                    }
                    bFinishGrenadeUse.setVisible(true);

                    GrenadeUseBoolean = true;

                    bBombPlant.setEnabled(false);
                    bDropPick.setEnabled(false);
                    bGrenadeUse.setEnabled(false);
                    bSuicideReward.setEnabled(false);
                    bTeamKill.setEnabled(false);
                    
                    GrenadeUseButtonString = "True";

                }else if(GrenadeUseQuestion.equals("N")){
                    bDropPick.setEnabled(true);
                    
                    bGrenadeUse.setEnabled(false);

                    GrenadeUseButtonBoolean = true;

                    GrenadeUseButtonString = "True";

                    if(BombPlantButtonString.equals("False") && buttonBombPlantString.equals("False")){
                        bBombPlant.setEnabled(true);
                    }
                    if(buttonSuicideRewardString.equals("False")){
                        bSuicideReward.setEnabled(true);
                    }
                    if(buttonTeamKillString.equals("False")){
                        bTeamKill.setEnabled(true);
                    }
                    GrenadeUseBoolean = true;
                }else{
                    GrenadeUseBoolean = false;
                }
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

                        String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET buttonGrenadeUse = ? WHERE idNumCS = 1";
                        PreparedStatement preparedStatement = conn.prepareStatement(query);

                        preparedStatement.setString(1, "True");

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
        if(source == bFinishGrenadeUse){
            bGrenade1.setVisible(false);
            bGrenade2.setVisible(false);
            bGrenade3.setVisible(false);
            bGrenade4.setVisible(false);
            bFinishGrenadeUse.setVisible(false);
            lGrenade1.setText("");
            lGrenade2.setText("");
            lGrenade3.setText("");
            lGrenade4.setText("");

            bDropPick.setEnabled(true);

            GrenadeUseButtonBoolean = true;

            GrenadeUseButtonString = "True";

            if(BombPlantButtonString.equals("False") && buttonBombPlantString.equals("False")){
                bBombPlant.setEnabled(true);
            }
            if(buttonSuicideRewardString.equals("False")){
                bSuicideReward.setEnabled(true);
            }
            if(buttonTeamKillString.equals("False")){
                bTeamKill.setEnabled(true);
            }
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

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET buttonGrenadeUse = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, "True");

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
        if(source == bDropPick){
            new GameTPickDrop();
            dispose();
        }
        if(TeamKillButtonString.equals("True") && SuicideRewardButtonString.equals("True") && BombPlantButtonString.equals("True") && GrenadeUseButtonString.equals("True")){ //alias
            bQuitbuyMenuGameTMenu.setEnabled(true);
        }
        if(source == bQuitbuyMenuGameTMenu){
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

                
                
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET MainGameCondition = ?  WHERE idNumCS = 1;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                
                preparedStatement.setString(1, "Result");
                

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
        }
    }
}

