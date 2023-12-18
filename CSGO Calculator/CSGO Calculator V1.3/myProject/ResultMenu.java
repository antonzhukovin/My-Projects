package myProject;

import java.awt.*;
import java.sql.*;

public class ResultMenu extends EasyApp
{
    public static void main(String[] args)
    { 
        new ResultMenu();
    }

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,650,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Button bSurvive = addButton("Did you survive?",0,120,220,100, this);
    Button bRoundWin = addButton("Did you win the round?",0,220,220,100, this);

    Button bBombPlant = addButton("Did your team plant the bomb?",300,120,220,100, this);

    Button bTeamElimination = addButton("Win by team elimination",600,120,220,100, this);
    Button bBombDetonation = addButton("Win by bomb detonation",600,220,220,100, this);
    Button bBombDefusal = addButton("Win by bomb defusal",600,320,220,100, this);
    Button bTimeWin = addButton("Win by time",600,420,220,100, this);

    Button bLoseElimination = addButton("Lose by team elimination",850,120,220,100, this);
    Button bLoseBombDetonation = addButton("Lose by bomb detonation",850,220,220,100, this);
    Button bLoseBombDefusal = addButton("Lose by bomb defusal",850,320,220,100, this);
    Button bLoseTime = addButton("Lose by time",850,420,220,100, this);

    Button bContinueResultMenu = addButton("Continue",850,550,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,50,30,this);
    Label lRoundNum = addLabel("Round: ",455,650,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    int intRSBalanceResultMenu;
    int intSQLRoundCTResultMenu;
    int intSQLRoundTResultMenu;
    int intSQLRoundNumberResultMenu;
    int intSQLloseBonusCount;
    
    int intTempLoseBonusForThisRound;

    String sqlSidestring; 

    String yourBombPlantString;
    String roundWinStringCondition;

    String teamBombPlantString;
    String surviveString; 

    String winAfterPistolRoundString;
    
    String sqlStringCTuspsORp2000; 

    public ResultMenu()   // Constructor - change window appearance
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
                intSQLRoundNumberResultMenu = Integer.parseInt (sqlRoundCountstring);}

            ResultSet rsBalance = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS = 1;" ) ; 
            // Loop through the result set

            while( rsBalance.next() ){
                String rs1Balancestring = rsBalance.getString(1);
                intRSBalanceResultMenu = Integer.parseInt (rs1Balancestring);}

            ResultSet sqlRoundCT =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlRoundCT.next() ){
                String sqlRoundCTstring = sqlRoundCT.getString(1);
                intSQLRoundCTResultMenu = Integer.parseInt (sqlRoundCTstring);}

            ResultSet sqlRoundT =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundT.next() ){
                String sqlRoundTstring = sqlRoundT.getString(1);
                intSQLRoundTResultMenu = Integer.parseInt (sqlRoundTstring);}

            ResultSet sqlSide =  stmt.executeQuery( "SELECT SideChoice FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlSide.next() ){
                sqlSidestring = sqlSide.getString(1);}

            ResultSet sqlYourBombPlant =  stmt.executeQuery( "SELECT BombPlant FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while(sqlYourBombPlant.next() ){
                yourBombPlantString = sqlYourBombPlant.getString(1);}

            ResultSet sqlloseBonusCount =  stmt.executeQuery( "SELECT loseBonusCount FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while(sqlloseBonusCount.next() ){
                String loseBonusCountString = sqlloseBonusCount.getString(1);
                intSQLloseBonusCount = Integer.parseInt(loseBonusCountString);
                intTempLoseBonusForThisRound = intSQLloseBonusCount; }

            ResultSet sqlwinAfterPistolRound =  stmt.executeQuery( "SELECT winAfterPistolRound FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while(sqlwinAfterPistolRound.next() ){
                winAfterPistolRoundString = sqlwinAfterPistolRound.getString(1);
            }
            
            ResultSet sqlCTuspsORp2000 =  stmt.executeQuery( "SELECT CTuspsORp2000 FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlCTuspsORp2000.next() ){ //alias
                sqlStringCTuspsORp2000 = sqlCTuspsORp2000.getString(1);}

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
        tRoundNum.setText(intSQLRoundNumberResultMenu +  "");
        tBalance.setText(intRSBalanceResultMenu + "$");
        tCTscore.setText(intSQLRoundCTResultMenu + "");
        tTscore.setText(intSQLRoundTResultMenu+ "");

        bRoundWin.setEnabled(false);

        bBombPlant.setVisible(false);

        bTeamElimination.setVisible(false);
        bBombDetonation.setVisible(false);
        bBombDefusal.setVisible(false);
        bTimeWin.setVisible(false);

        bLoseElimination.setVisible(false);
        bLoseBombDetonation.setVisible(false);
        bLoseBombDefusal.setVisible(false);
        bLoseTime.setVisible(false);

        bContinueResultMenu.setVisible(false);

        if(yourBombPlantString.equals("True")){
            teamBombPlantString = "True";
        }

    }
    public void actions(Object source,String command){
        if(source == bSurvive){
            boolean SurviveBoolean = false;
            while(SurviveBoolean == false){
                String SurviveStringQuestion = inputString("Did you survive? Y/N");
                if(SurviveStringQuestion.equals("Y")){
                    surviveString = "True";
                    SurviveBoolean = true;
                }else if(SurviveStringQuestion.equals("N")){
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

                        String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Weapon2 = ?, Grenade1 = ?, Grenade2 = ?, Grenade3 =?, Grenade4 =?, Zeus = ?, buttonSurvive = ?, Armor = ? WHERE idNumCS = 1;";
                        PreparedStatement preparedStatement = conn.prepareStatement(query);

                        preparedStatement.setString(1,null);
                        preparedStatement.setString(2,null);
                        preparedStatement.setString(3,null);
                        preparedStatement.setString(4,null);
                        preparedStatement.setString(5,null);
                        preparedStatement.setString(6,null);
                        preparedStatement.setString(7,"True");
                        preparedStatement.setString(8,null);

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
                        if(sqlStringCTuspsORp2000.equals("CTUSPS")){
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
                    }
                    if(sqlStringCTuspsORp2000.equals("CTP2000")){
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
                    surviveString = "False";
                    SurviveBoolean = true;
                }else{
                    SurviveBoolean = false;
                }

            }
            bRoundWin.setEnabled(true);
            bSurvive.setEnabled(false);
        }
        if(source == bRoundWin){
            boolean RoundWin = false;
            while(RoundWin == false){
                String RoundWinStringQuestion = inputString("Did you win the round? Y/N");
                if(RoundWinStringQuestion.equals("Y")){
                    if(sqlSidestring.equals("TSide")){
                        if(yourBombPlantString.equals("False")){
                            bBombPlant.setVisible(true);
                        }
                            bTeamElimination.setVisible(true);
                            bBombDetonation.setVisible(true);
                        

                    }
                    if(sqlSidestring.equals("CTSide")){
                        bTeamElimination.setVisible(true);
                        bBombDefusal.setVisible(true);
                        bTimeWin.setVisible(true);
                    }
                    if(winAfterPistolRoundString.equals("False")){
                        winAfterPistolRoundString = "True";
                        intSQLloseBonusCount = intSQLloseBonusCount - 2;
                        if(intSQLloseBonusCount < 0){
                            intSQLloseBonusCount = 0;
                        }
                    }
                    if(winAfterPistolRoundString.equals("True")){
                        intSQLloseBonusCount = intSQLloseBonusCount - 1;
                        if(intSQLloseBonusCount < 0){
                            intSQLloseBonusCount = 0;
                        }
                    }

                    roundWinStringCondition = "Y";
                    RoundWin = true;
                    bRoundWin.setEnabled(false);
                }else if(RoundWinStringQuestion.equals("N")){
                    if(sqlSidestring.equals("TSide")){
                        if(yourBombPlantString.equals("False")){
                            bBombPlant.setVisible(true);
                        }
                        if(yourBombPlantString.equals("True")){
                            if(surviveString.equals("False")){
                            bLoseElimination.setVisible(true);
                            }
                            bLoseBombDefusal.setVisible(true);
                        }
                    }
                    if(sqlSidestring.equals("CTSide")){
                        if(surviveString.equals("False")){
                            bLoseElimination.setVisible(true);
                            }
                        bLoseBombDetonation.setVisible(true);
                    }
                    intSQLloseBonusCount = intSQLloseBonusCount + 1;
                    if(intSQLloseBonusCount > 4){
                        intSQLloseBonusCount = 4;
                    }
                    roundWinStringCondition = "N";
                    RoundWin = true;
                    bRoundWin.setEnabled(false);
                }else{
                    RoundWin = false;
                }
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

                int loseBonusUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET loseBonusCount = "+intSQLloseBonusCount+" WHERE idNumCS = 1;");

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET winAfterPistolRound = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, winAfterPistolRoundString);

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
        if(source == bBombPlant){
            boolean BombPlantBoolean1 = false;
            while(BombPlantBoolean1 == false){
                String BombPlant1StringQuestion = inputString("Did your team plant the bomb? Y/N");
                if(BombPlant1StringQuestion.equals("Y")){
                    teamBombPlantString = "True"; //alias
                    if(roundWinStringCondition == "Y"){
                        bTeamElimination.setVisible(true);
                        bBombDetonation.setVisible(true);
                    }
                    if(roundWinStringCondition == "N"){
                        bLoseBombDefusal.setVisible(true);
                    }
                    BombPlantBoolean1 = true;
                }else if(BombPlant1StringQuestion.equals("N")){
                    teamBombPlantString = "False";
                    if(roundWinStringCondition == "Y"){
                        bTeamElimination.setVisible(true);
                    }
                    if(roundWinStringCondition == "N"){
                        if(surviveString.equals("False")){
                            bLoseElimination.setVisible(true);
                        }
                        bLoseBombDefusal.setVisible(true);
                        bLoseTime.setVisible(true);
                    }
                    BombPlantBoolean1 = true;
                }else{
                    BombPlantBoolean1 = false;
                }
            }
            bBombPlant.setEnabled(false);
        }
        if(source == bBombDetonation){
            intRSBalanceResultMenu = intRSBalanceResultMenu + 3500;
            if (intRSBalanceResultMenu > 16000){
                intRSBalanceResultMenu = 16000;
            }
            tBalance.setText(intRSBalanceResultMenu + "$");
            intSQLRoundTResultMenu = intSQLRoundTResultMenu + 1;
            intSQLRoundNumberResultMenu = intSQLRoundNumberResultMenu + 1; //use
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

                int balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalanceResultMenu+" WHERE idNumCS = 1;");
                int roundTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundT = "+intSQLRoundTResultMenu+" WHERE idNumCS = 1;");
                int roundCountUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCount = "+intSQLRoundNumberResultMenu+" WHERE idNumCS = 1;"); //use
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET howDidYouWinTheRound = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                
                preparedStatement.setString(1, "Win by bomb detonation");

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

            bSurvive.setVisible(false);

            bRoundWin.setVisible(false);

            bBombPlant.setVisible(false);

            bTeamElimination.setVisible(false);
            bBombDetonation.setVisible(false);
            bBombDefusal.setVisible(false);
            bTimeWin.setVisible(false);

            bLoseElimination.setVisible(false);
            bLoseBombDetonation.setVisible(false);
            bLoseBombDefusal.setVisible(false);
            bLoseTime.setVisible(false);

            bContinueResultMenu.setVisible(true);
        }
        if(source == bTeamElimination){
            intRSBalanceResultMenu = intRSBalanceResultMenu + 3250;
            if (intRSBalanceResultMenu > 16000){
                intRSBalanceResultMenu = 16000;
            }
            tBalance.setText(intRSBalanceResultMenu + "$");
            if(sqlSidestring.equals("TSide")){
                intSQLRoundTResultMenu = intSQLRoundTResultMenu + 1;
            }
            if(sqlSidestring.equals("CTSide")){
                intSQLRoundCTResultMenu = intSQLRoundCTResultMenu + 1;
            }
            intSQLRoundNumberResultMenu = intSQLRoundNumberResultMenu + 1;
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

                int balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalanceResultMenu+" WHERE idNumCS = 1;");
                int roundTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundT = "+intSQLRoundTResultMenu+" WHERE idNumCS = 1;");
                int roundCTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCT = "+intSQLRoundCTResultMenu+" WHERE idNumCS = 1;");
                int roundCountUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCount = "+intSQLRoundNumberResultMenu+" WHERE idNumCS = 1;"); //use
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET howDidYouWinTheRound = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, "Win by team elimination");

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

            bSurvive.setVisible(false);

            bRoundWin.setVisible(false);

            bBombPlant.setVisible(false);

            bTeamElimination.setVisible(false);
            bBombDetonation.setVisible(false);
            bBombDefusal.setVisible(false);
            bTimeWin.setVisible(false);

            bLoseElimination.setVisible(false);
            bLoseBombDetonation.setVisible(false);
            bLoseBombDefusal.setVisible(false);
            bLoseTime.setVisible(false);

            bContinueResultMenu.setVisible(true);
        }
        if(source == bBombDefusal){
            boolean BombDefusalBoolean1 = false;
            while(BombDefusalBoolean1 == false){
                String BombDefusal1StringQuestion = inputString("Did you defuse the bomb yourself? Y/N");
                if(BombDefusal1StringQuestion.equals("Y")){
                    intRSBalanceResultMenu = intRSBalanceResultMenu + 300;
                    BombDefusalBoolean1 = true;
                }else if(BombDefusal1StringQuestion.equals("N")){
                    BombDefusalBoolean1 = true;
                }else{
                    BombDefusalBoolean1 = false;
                }
            }
            intRSBalanceResultMenu = intRSBalanceResultMenu + 3500;
            if (intRSBalanceResultMenu > 16000){
                intRSBalanceResultMenu = 16000;
            }
            intSQLRoundCTResultMenu = intSQLRoundCTResultMenu + 1;
            intSQLRoundNumberResultMenu = intSQLRoundNumberResultMenu + 1;
            tBalance.setText(intRSBalanceResultMenu + "$");
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

                
                int balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalanceResultMenu+" WHERE idNumCS = 1;");
                int roundCTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCT = "+intSQLRoundCTResultMenu+" WHERE idNumCS = 1;");
                int roundCountUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCount = "+intSQLRoundNumberResultMenu+" WHERE idNumCS = 1;"); //use
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET howDidYouWinTheRound = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                
                preparedStatement.setString(1, "Win by bomb defusal");

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

            bSurvive.setVisible(false);

            bRoundWin.setVisible(false);

            bBombPlant.setVisible(false);

            bTeamElimination.setVisible(false);
            bBombDetonation.setVisible(false);
            bBombDefusal.setVisible(false);
            bTimeWin.setVisible(false);

            bLoseElimination.setVisible(false);
            bLoseBombDetonation.setVisible(false);
            bLoseBombDefusal.setVisible(false);
            bLoseTime.setVisible(false);

            bContinueResultMenu.setVisible(true);
        }
        if(source == bTimeWin){
            intRSBalanceResultMenu = intRSBalanceResultMenu + 3250;
            if (intRSBalanceResultMenu > 16000){
                intRSBalanceResultMenu = 16000;
            }
            intSQLRoundCTResultMenu = intSQLRoundCTResultMenu + 1;
            intSQLRoundNumberResultMenu = intSQLRoundNumberResultMenu + 1;
            tBalance.setText(intRSBalanceResultMenu + "$");
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

                int balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalanceResultMenu+" WHERE idNumCS = 1;");
                int roundCTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCT = "+intSQLRoundCTResultMenu+" WHERE idNumCS = 1;");
                int roundCountUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCount = "+intSQLRoundNumberResultMenu+" WHERE idNumCS = 1;"); //use
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET howDidYouWinTheRound = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                
                preparedStatement.setString(1, "Win by time");

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

            bSurvive.setVisible(false);

            bRoundWin.setVisible(false);

            bBombPlant.setVisible(false);

            bTeamElimination.setVisible(false);
            bBombDetonation.setVisible(false);
            bBombDefusal.setVisible(false);
            bTimeWin.setVisible(false);

            bLoseElimination.setVisible(false);
            bLoseBombDetonation.setVisible(false);
            bLoseBombDefusal.setVisible(false);
            bLoseTime.setVisible(false);

            bContinueResultMenu.setVisible(true);
        }
        if(source == bLoseElimination){
            if(intTempLoseBonusForThisRound == 0){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 1400;
            }else if(intTempLoseBonusForThisRound == 1){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 1900;
            }else if(intTempLoseBonusForThisRound == 2){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 2400;
            }else if(intTempLoseBonusForThisRound == 3){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 2900;
            }else if(intTempLoseBonusForThisRound == 4){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 3400;
            }
            if(teamBombPlantString.equals("True")){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 800;
            }
            if (intRSBalanceResultMenu > 16000){
                intRSBalanceResultMenu = 16000;
            }
            tBalance.setText(intRSBalanceResultMenu + "$");
            if(sqlSidestring.equals("TSide")){
                intSQLRoundCTResultMenu = intSQLRoundCTResultMenu + 1;
            }
            if(sqlSidestring.equals("CTSide")){
                intSQLRoundTResultMenu = intSQLRoundTResultMenu + 1;
            }
            intSQLRoundNumberResultMenu = intSQLRoundNumberResultMenu + 1;
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

                int balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalanceResultMenu+" WHERE idNumCS = 1;");
                int roundTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundT = "+intSQLRoundTResultMenu+" WHERE idNumCS = 1;");
                int roundCTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCT = "+intSQLRoundCTResultMenu+" WHERE idNumCS = 1;");
                int roundCountUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCount = "+intSQLRoundNumberResultMenu+" WHERE idNumCS = 1;"); //use
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET howDidYouWinTheRound = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, "Lose by team elimination");

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

            bSurvive.setVisible(false);

            bRoundWin.setVisible(false);

            bBombPlant.setVisible(false);

            bTeamElimination.setVisible(false);
            bBombDetonation.setVisible(false);
            bBombDefusal.setVisible(false);
            bTimeWin.setVisible(false);

            bLoseElimination.setVisible(false);
            bLoseBombDetonation.setVisible(false);
            bLoseBombDefusal.setVisible(false);
            bLoseTime.setVisible(false);

            bContinueResultMenu.setVisible(true);
        }
        if(source == bLoseBombDetonation){ 
            if(intTempLoseBonusForThisRound == 0){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 1400;
            }else if(intTempLoseBonusForThisRound == 1){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 1900;
            }else if(intTempLoseBonusForThisRound == 2){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 2400;
            }else if(intTempLoseBonusForThisRound == 3){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 2900;
            }else if(intTempLoseBonusForThisRound == 4){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 3400;
            }
            if (intRSBalanceResultMenu > 16000){
                intRSBalanceResultMenu = 16000;
            }
            tBalance.setText(intRSBalanceResultMenu + "$");
                intSQLRoundTResultMenu = intSQLRoundTResultMenu + 1;
            intSQLRoundNumberResultMenu = intSQLRoundNumberResultMenu + 1;
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

                int balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalanceResultMenu+" WHERE idNumCS = 1;");
                int roundTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundT = "+intSQLRoundTResultMenu+" WHERE idNumCS = 1;");
                int roundCountUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCount = "+intSQLRoundNumberResultMenu+" WHERE idNumCS = 1;"); //use
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET howDidYouWinTheRound = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, "Lose by bomb detonation");

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

            bSurvive.setVisible(false);

            bRoundWin.setVisible(false);

            bBombPlant.setVisible(false);

            bTeamElimination.setVisible(false);
            bBombDetonation.setVisible(false);
            bBombDefusal.setVisible(false);
            bTimeWin.setVisible(false);

            bLoseElimination.setVisible(false);
            bLoseBombDetonation.setVisible(false);
            bLoseBombDefusal.setVisible(false);
            bLoseTime.setVisible(false);

            bContinueResultMenu.setVisible(true);
        }
        if(source == bLoseBombDefusal){
            if(intTempLoseBonusForThisRound == 0){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 1400;
            }else if(intTempLoseBonusForThisRound == 1){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 1900;
            }else if(intTempLoseBonusForThisRound == 2){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 2400;
            }else if(intTempLoseBonusForThisRound == 3){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 2900;
            }else if(intTempLoseBonusForThisRound == 4){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 3400;
            }
            if (intRSBalanceResultMenu > 16000){
                intRSBalanceResultMenu = 16000;
            }
            tBalance.setText(intRSBalanceResultMenu + "$");
                intSQLRoundCTResultMenu = intSQLRoundCTResultMenu + 1;
            intSQLRoundNumberResultMenu = intSQLRoundNumberResultMenu + 1;
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

                int balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalanceResultMenu+" WHERE idNumCS = 1;");
                int roundCTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCT = "+intSQLRoundCTResultMenu+" WHERE idNumCS = 1;");
                int roundCountUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCount = "+intSQLRoundNumberResultMenu+" WHERE idNumCS = 1;"); //use
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET howDidYouWinTheRound = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, "Lose by bomb defusal");

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

            bSurvive.setVisible(false);

            bRoundWin.setVisible(false);

            bBombPlant.setVisible(false);

            bTeamElimination.setVisible(false);
            bBombDetonation.setVisible(false);
            bBombDefusal.setVisible(false);
            bTimeWin.setVisible(false);

            bLoseElimination.setVisible(false);
            bLoseBombDetonation.setVisible(false);
            bLoseBombDefusal.setVisible(false);
            bLoseTime.setVisible(false);

            bContinueResultMenu.setVisible(true);
        }
        if(source == bLoseTime){
            //finishC
            if(surviveString.equals("False")){
            if(intTempLoseBonusForThisRound == 0){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 1400;
            }else if(intTempLoseBonusForThisRound == 1){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 1900;
            }else if(intTempLoseBonusForThisRound == 2){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 2400;
            }else if(intTempLoseBonusForThisRound == 3){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 2900;
            }else if(intTempLoseBonusForThisRound == 4){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 3400;
            }
            if (intRSBalanceResultMenu > 16000){
                intRSBalanceResultMenu = 16000;
            }
            }else if(surviveString.equals("True")){
                intRSBalanceResultMenu = intRSBalanceResultMenu + 0;
            }
            tBalance.setText(intRSBalanceResultMenu + "$");
            intSQLRoundCTResultMenu = intSQLRoundCTResultMenu + 1;
            intSQLRoundNumberResultMenu = intSQLRoundNumberResultMenu + 1;
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

                int balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalanceResultMenu+" WHERE idNumCS = 1;");
                int roundCTUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCT = "+intSQLRoundCTResultMenu+" WHERE idNumCS = 1;");
                int roundCountUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET RoundCount = "+intSQLRoundNumberResultMenu+" WHERE idNumCS = 1;"); //use
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET howDidYouWinTheRound = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, "Lose by time");

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

            bSurvive.setVisible(false);

            bRoundWin.setVisible(false);

            bBombPlant.setVisible(false);

            bTeamElimination.setVisible(false);
            bBombDetonation.setVisible(false);
            bBombDefusal.setVisible(false);
            bTimeWin.setVisible(false);

            bLoseElimination.setVisible(false);
            bLoseBombDetonation.setVisible(false);
            bLoseBombDefusal.setVisible(false);
            bLoseTime.setVisible(false);

            bContinueResultMenu.setVisible(true);
        }
        //finish the rest of types of losing 
        if(source == bContinueResultMenu){
            new ResultRound();
            dispose();
        }
    }
}

