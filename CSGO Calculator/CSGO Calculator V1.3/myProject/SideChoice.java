package myProject;

import java.awt.*;
import java.sql.*;

public class SideChoice extends EasyApp //checked, alright
{
    public static void main(String[] args)
    {  
        new SideChoice();}

    Label lSideChoice = addLabel("Choose a side",150,30,500,60,this);

    Button bT = addButton("T",150,100,100,50,this);
    Button bCT = addButton("CT",250,100,100,50,this);
    String sideChoice; 

    public SideChoice()   // Constructor - change window appearance
    {
        setSize(500,250);
        setTitle("CS:GO Economy - (c) 2021 Anton Zhukovin, Russia");
        lSideChoice.setFont(new Font("Arial",1,36));
        lSideChoice.setBackground(new Color(255,255,180));
        lSideChoice.setForeground(Color.blue);
        setBackground(new Color(255,255,180));
        bT.setFont(new Font("Arial",1,16));     
        bCT.setFont(new Font("Arial",1,16));     

    }

    public void actions(Object source,String command)
    {

        if (source == bT) //Allows the player to choose the T side
        {   
            String sideChoice = "TSide"; //String gains the value that will be stored in MySQL
            try
            {
                // Load the database driver
                Class.forName( "com.mysql.jdbc.Driver" ) ;

                // Get a connection to the database [Used Heimetli code with my connection name]
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

                // Execute the query

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET SideChoice = ? WHERE idNumCS = 1"; //changes the value of Side in MySQL
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, sideChoice); //changes to the value equal to the string sideChoice

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
        if (source == bCT) //To choose the CT Side
        {  
            String sideChoice = "CTSide"; //String gets the value of the chosen side to upload it to MySQL
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

                // Execute the query

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET SideChoice = ? WHERE idNumCS = 1";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, sideChoice);

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
            new MainGameT(); //Opens a Main Menu when the side is chosen
            dispose();} //closes this menu

    }
}