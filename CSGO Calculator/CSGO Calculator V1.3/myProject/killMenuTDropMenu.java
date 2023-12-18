package myProject;

import java.awt.*;
import java.sql.*;

public class killMenuTDropMenu extends EasyApp
{
    public static void main(String[] args)
    {  new killMenuTDropMenu();}

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,800,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);

    Button bDropWeapon1 = addButton("Secondary weapon",400,100,183,100,this);
    Button bDropWeapon2 = addButton("Primary weapon",400,200,183,100,this);
    Button bDropZeus = addButton("Zeus",400,300,183,100,this);
    Button bDropGrenade1 = addButton("Grenade 1",400,400,183,100,this);
    Button bDropGrenade2 = addButton("Grenade 2",400,500,183,100,this);
    Button bDropGrenade3 = addButton("Grenade 3",400,600,183,100,this);
    Button bDropGrenade4 = addButton("Grenade 4",400,700,183,100,this);
    Button bQuitkillMenuTDropMenu = addButton("Go Back",850,750,150,100,this);

    Label lCT = addLabel("CT",330,50,50,30,this);
    Label lT = addLabel("T",420,50,50,30,this);
    Label lRoundNum = addLabel("Round: ",455,800,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);
    
    Label lDropWeapon1 = addLabel("",337,100,62,30,this);
    Label lDropWeapon2 = addLabel("",337,200,62,30,this);
    Label lDropZeus = addLabel("",337,300,62,30,this);
    Label lDropGrenade1 = addLabel("",337,400,62,30,this);
    Label lDropGrenade2 = addLabel("",337,500,62,30,this);
    Label lDropGrenade3 = addLabel("",337,600,62,30,this);
    Label lDropGrenade4 = addLabel("",337,700,62,30,this);

    int RoundCountkillMenuTDropMenu; 
    int BalancekillMenuTDropMenu; 
    int RoundCTkillMenuTDropMenu;
    int RoundTkillMenuTDropMenu;
    String killMenuTDropMenuWeapon1;
    String killMenuTDropMenuWeapon2;
    String killMenuTDropMenuZeus;
    String killMenuTDropMenuGrenade1;
    String killMenuTDropMenuGrenade2;
    String killMenuTDropMenuGrenade3;
    String killMenuTDropMenuGrenade4;

    public killMenuTDropMenu(){
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

            ResultSet sqlRoundCountkillMenuTDropMenu =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountkillMenuTDropMenu.next() ){
                String sqlRoundCountstringkillMenuTDropMenu = sqlRoundCountkillMenuTDropMenu.getString(1);
                RoundCountkillMenuTDropMenu = Integer.parseInt (sqlRoundCountstringkillMenuTDropMenu);}

            ResultSet rsBalancekillMenuTDropMenu = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalancekillMenuTDropMenu.next() ){
                String rs1BalancestringkillMenuTDropMenu = rsBalancekillMenuTDropMenu.getString(1);
                BalancekillMenuTDropMenu = Integer.parseInt (rs1BalancestringkillMenuTDropMenu);}

            ResultSet sqlRoundCTkillMenuTDropMenu =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTkillMenuTDropMenu.next() ){
                String sqlRoundCTstringkillMenuTDropMenu = sqlRoundCTkillMenuTDropMenu.getString(1);
                RoundCTkillMenuTDropMenu = Integer.parseInt (sqlRoundCTstringkillMenuTDropMenu);}

            ResultSet sqlRoundTkillMenuTDropMenu =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTkillMenuTDropMenu .next() ){
                String sqlRoundTstringkillMenuTDropMenu = sqlRoundTkillMenuTDropMenu .getString(1);
                RoundTkillMenuTDropMenu = Integer.parseInt (sqlRoundTstringkillMenuTDropMenu);}

            ResultSet sqlWeapon1killMenuTDropMenu =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon1killMenuTDropMenu .next() ){
                killMenuTDropMenuWeapon1 = sqlWeapon1killMenuTDropMenu .getString(1);
            }
            
            ResultSet sqlWeapon2killMenuTDropMenu =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon2killMenuTDropMenu .next() ){
                killMenuTDropMenuWeapon2 = sqlWeapon2killMenuTDropMenu .getString(1);
            }
            
            ResultSet sqlZeuskillMenuTDropMenu =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlZeuskillMenuTDropMenu .next() ){
                killMenuTDropMenuZeus = sqlZeuskillMenuTDropMenu .getString(1);
            }
            
            ResultSet sqlGrenade1killMenuTDropMenu =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1killMenuTDropMenu .next() ){
                killMenuTDropMenuGrenade1 = sqlGrenade1killMenuTDropMenu .getString(1);
            }
            
            ResultSet sqlGrenade2killMenuTDropMenu =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2killMenuTDropMenu .next() ){
                killMenuTDropMenuGrenade2 = sqlGrenade2killMenuTDropMenu .getString(1);
            }
            
            ResultSet sqlGrenade3killMenuTDropMenu =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3killMenuTDropMenu .next() ){
                killMenuTDropMenuGrenade3 = sqlGrenade3killMenuTDropMenu .getString(1);
            }
            
            ResultSet sqlGrenade4killMenuTDropMenu =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4killMenuTDropMenu .next() ){
                killMenuTDropMenuGrenade4 = sqlGrenade4killMenuTDropMenu .getString(1);
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
        tRoundNum.setText(RoundCountkillMenuTDropMenu +  "");
        tBalance.setText(BalancekillMenuTDropMenu + "$");
        tCTscore.setText(RoundCTkillMenuTDropMenu + "");
        tTscore.setText(RoundTkillMenuTDropMenu + "");
        
        lDropWeapon1.setText(killMenuTDropMenuWeapon1);
        lDropWeapon2.setText(killMenuTDropMenuWeapon2);
        lDropZeus.setText(killMenuTDropMenuZeus);
        lDropGrenade1.setText(killMenuTDropMenuGrenade1);
        lDropGrenade2.setText(killMenuTDropMenuGrenade2);
        lDropGrenade3.setText(killMenuTDropMenuGrenade3);
        lDropGrenade4.setText(killMenuTDropMenuGrenade4);
        
        if(killMenuTDropMenuWeapon1 == null){
            bDropWeapon1.setVisible(false);
        }
        if(killMenuTDropMenuWeapon2 == null){
            bDropWeapon2.setVisible(false);
        }
        if(killMenuTDropMenuZeus == null){
            bDropZeus.setVisible(false);
        }
        if(killMenuTDropMenuGrenade1 == null){
            bDropGrenade1.setVisible(false);
        }
        if(killMenuTDropMenuGrenade2 == null){
            bDropGrenade2.setVisible(false);
        }
        if(killMenuTDropMenuGrenade3 == null){
            bDropGrenade3.setVisible(false);
        }
        if(killMenuTDropMenuGrenade4 == null){
            bDropGrenade4.setVisible(false);
        }
        
    }
    
    public void actions(Object source,String command){
        if (source == bDropWeapon1){
            bDropWeapon1.setEnabled(false);
            killMenuTDropMenuWeapon1 = null;
        }
        if (source == bDropWeapon2){
            bDropWeapon2.setEnabled(false);
            killMenuTDropMenuWeapon2 = null;
        }
        if (source == bDropZeus){
            bDropZeus.setEnabled(false);
            killMenuTDropMenuZeus = null;
        }
        if (source == bDropGrenade1){
            bDropGrenade1.setEnabled(false);
            killMenuTDropMenuGrenade1 = null;
        }
        if (source == bDropGrenade2){
            bDropGrenade2.setEnabled(false);
            killMenuTDropMenuGrenade2 = null;
        }
        if (source == bDropGrenade3){
            bDropGrenade3.setEnabled(false);
            killMenuTDropMenuGrenade3 = null;
        }
        if (source == bDropGrenade4){
            bDropGrenade4.setEnabled(false);
            killMenuTDropMenuGrenade4 = null;
        }
        if (source == bQuitkillMenuTDropMenu){
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
                
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Weapon1 = ?, Weapon2 = ?, Grenade1 = ?, Grenade2 = ?, Grenade3 =?, Grenade4 =?, Zeus = ? WHERE idNumCS = 1;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1,killMenuTDropMenuWeapon1);
                preparedStatement.setString(2,killMenuTDropMenuWeapon2);
                preparedStatement.setString(3,killMenuTDropMenuGrenade1);
                preparedStatement.setString(4,killMenuTDropMenuGrenade2);
                preparedStatement.setString(5,killMenuTDropMenuGrenade3);
                preparedStatement.setString(6,killMenuTDropMenuGrenade4);
                preparedStatement.setString(7,killMenuTDropMenuZeus);
                

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
            new killMenuTPickDrop();
            dispose(); 
        }
    }
}
