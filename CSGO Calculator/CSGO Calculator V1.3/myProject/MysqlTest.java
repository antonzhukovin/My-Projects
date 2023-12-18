package myProject;

/******************************************************************************/
/*                                                                            */
/*                                                       FILE: MysqlTest.java */
/*                                                                            */
/*  A simple JDBC example for BlueJ and MySQL                                 */
/*  =========================================                                 */
/*                                                                            */
/*  V1.00   24-FEB-2008   Te          https://www.heimetli.ch/                */
/*                                                                            */
/*  ------------------------------------------------------------------------- */
/*                                                                            */
/*  This example was coded and tested with JDK1.6.0_01-b06 on Windows         */
/*  and MySQL 5.0.45 running on a linux machine                               */
/*                                                                            */
/*  To run this example, you need a database with the following properties:   */
/*  => user "zhaw"                                                            */
/*  => password "password"                                                    */
/*  => a database called "demo"                                               */
/*  => and a table called "Cust" having at least one column                   */
/*                                                                            */
/******************************************************************************/

import java.sql.* ;

/**
 * This class is used to show how to access a MySQL database from code running in BlueJ
 *
 * Preparation: download Connector/J from <a href="http://dev.mysql.com/downloads/connector/j/5.1.html>dev.mysql.com</a>.
 * You can download it without registration if you look for and click the "no thanks" links ...
 * 
 * You don't need the complete .ZIP, unpack just the .jar and put it into a
 * directory where ist is easy to find.
 * 
 * Then start BlueJ and choose "Tools"/"Preferences". Select the "Libraries"-Tab
 * and press the "Add"-Button. Navigate to the .jar, select it and click "Open".
 * The library will appear in the table "User libraries".
 * You will probably get a warning, that the library will not be loaded until
 * the next compile. This is not a problem, therefore you can acknowledge the
 * warning.
 * 
 * If necessary, customize the JDBC URL in the call to getConnection. It is documented on
 * <a href="http://dev.mysql.com/doc/refman/5.0/en/connector-j-reference-configuration-properties.html">
 * this page</a>
 */
class MysqlTest
{
/**
 * Connect to MySQL and read the table "Cust", then print the contents of the first column.
 */
 public void test()
 {
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
       Statement stmt = conn.createStatement() ;

       // Execute the query
       ResultSet rs = stmt.executeQuery( "SELECT Balance, RoundCount FROM IACompCSGO" ) ;
       
        ResultSet rs1 = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE RoundCount = 0;" ) ;
       // Loop through the result set
       
       
        
       while( rs1.next() ){
          System.out.println( rs1.getString(1) );}
          
       // Close the result set, statement and the connection
       rs.close() ;
       rs1.close() ;
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
 }
}

