package myProject;

import java.awt.*;
import java.sql.*;

public class GameTPickMenu extends EasyApp
{
    public static void main(String[] args)
    {  new GameTPickMenu();}

    TextField tCTscore = addTextField("0",350,50,31,30,this);
    TextField tTscore = addTextField("0",382,50,31,30,this);
    TextField tRoundNum = addTextField("0",500,50,31,30,this);
    TextField tBalance = addTextField("0",900,50,62,30,this);
    
    TextField tWeapon1 = addTextField("",370,600,150,30,this);
    TextField tWeapon2 = addTextField("",370,635,150,30,this);
    TextField tZeus = addTextField("",370,670,150,30,this);
    TextField tGrenade1 = addTextField("",370,705,150,30,this);
    TextField tGrenade2 = addTextField("",370,740,150,30,this);
    TextField tGrenade3 = addTextField("",370,775,150,30,this);
    TextField tGrenade4 = addTextField("",370,810,150,30,this);
    TextField tKits = addTextField("",370,845,150,30,this);
    
    Label lGrenadeLabelPickMenu = addLabel("Grenades",70,90,60,30,this);
    Label lPistolsLabelPickMenu = addLabel("Pistols",254,90,60,30,this);
    Label lZeusLabelPickMenu = addLabel("Equipment",476,90,60,30,this);
    Label lSMGLabelPickMenu = addLabel("SMG",742,90,60,30,this);
    Label lRiflesLabelPickMenu = addLabel("Rifles",1008,90,60,30,this);
    Label lHeavyLabelPickMenu = addLabel("Heavy",1274,90,60,30,this);
    
    Label lYourEquipment = addLabel("Your equipment:",370,570,150,30,this);
    
    Button bMolotov = addButton("Molotov",0,120,183,100, this);
    Button bDecoy = addButton("Decoy",0,220,183,100, this);
    Button bFlashbang = addButton("Flashbang",0,320,183,100,this);
    Button bHEGrenade = addButton("HE Grenade",0,420,183,100,this);
    Button bSmoke = addButton("Smoke",0,520,183,100,this);
    Button bIncendiary = addButton("Incendiary Grenade",0,620,183,100,this);

    Button bGlock18 = addButton("Glock-18",183,120,183,50,this);
    Button bDualBerettas= addButton("Dual Berettas",183,170,183,50,this);
    Button bP250 = addButton("P250",183,220,183,50,this);
    Button bCZ75Auto = addButton("CZ75 - Auto",183,270,183,50,this);
    Button bDesertEagle = addButton("Desert Eagle",183,320,183,50,this);
    Button bR8Revolver = addButton("R8 Revolver",183,370,183,50,this);
    Button bTec9 = addButton("Tec-9",183,420,183,50,this);
    Button bUSPS = addButton("USP-S",183,470,183,50,this);
    Button bP2000 = addButton("P2000",183,520,183,50,this);
    Button bFiveSeveN = addButton("Five-SeveN",183,570,183,50,this);

    
    Button bZeusx27 = addButton("Zeus x27",366,120,266,50,this);
    Button bKits = addButton("Kits",366,170,266,50,this);

    Button bMAC10 = addButton("MAC-10",632,120,266,50,this);
    Button bMP5SD = addButton("MP5-SD",632,170,266,50,this);
    Button bMP7 = addButton("MP7",632,220,266,50,this);
    Button bUMP45 = addButton("UMP - 45",632,270,266,50,this);
    Button bP90 = addButton("P90",632,320,266,50,this);
    Button bPPBizon = addButton("PP-Bizon",632,370,266,50,this);
    Button bMP9 = addButton("MP9",632,420,266,50,this);

    Button bGalilAR = addButton("Galil AR",898,120,266,50,this);
    Button bAK47 = addButton("AK-47",898,170,266,50,this);
    Button bSSG08 = addButton("SSG 08",898,220,266,50,this);
    Button bSG553 = addButton("SG 553",898,270,266,50,this);
    Button bAWP = addButton("AWP",898,320,266,50,this);
    Button bG3SG1 = addButton("G3SG1",898,370,266,50,this);
    Button bFAMAS = addButton("FAMAS",898,420,266,50,this);
    Button bM4A4 = addButton("M4A4",898,470,266,50,this);
    Button bM4A1S = addButton("M4A1-S",898,520,266,50,this);
    Button bAUG = addButton("AUG",898,570,266,50,this);
    Button bSCAR20 = addButton("SCAR-20",898,620,266,50,this);

    Button bNova = addButton("Nova",1164,120,266,50,this);
    Button bXM1014 = addButton("XM1014",1164,170,266,50,this);
    Button bSawedOff = addButton("Sawed-Off",1164,220,266,50,this);
    Button bM249 = addButton("M249",1164,270,266,50,this);
    Button bNegev= addButton("Negev",1164,320,266,50,this);
    Button bMAG7= addButton("MAG-7",1164,370,266,50,this);

    Button bQuitbuyMenuPickMenu = addButton("Go Back",850,750,150,100,this);

    Label lCT = addLabel("CT",330,50,20,30,this);
    Label lT = addLabel("T",420,50,10,30,this);
    Label lRoundNum = addLabel("Round: ",455,50,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    int RoundCountbuyMenuPick; 
    int BalancebuyMenuPick; 
    int RoundCTbuyMenuPick;
    int RoundTbuyMenuPick;
    int flashbangCountPick = 0;
    String buyMenuPickWeapon1;
    String buyMenuPickWeapon2;
    String buyMenuPickZeus;
    String buyMenuPickGrenade1;
    String buyMenuPickGrenade2;
    String buyMenuPickGrenade3;
    String buyMenuPickGrenade4;
    String sqlStringLimitGrenadeConditionPickMenu;
    String sqlStringSidePickMenu;
    String buyMenuPickKits;

    public GameTPickMenu(){
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

            ResultSet sqlRoundCountbuyMenuPickMenu =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountbuyMenuPickMenu.next() ){
                String sqlRoundCountstringbuyMenuPickMenu = sqlRoundCountbuyMenuPickMenu.getString(1);
                RoundCountbuyMenuPick = Integer.parseInt (sqlRoundCountstringbuyMenuPickMenu);}

            ResultSet rsBalancebuyMenuPickMenu = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalancebuyMenuPickMenu.next() ){
                String rs1BalancestringbuyMenuPickMenu = rsBalancebuyMenuPickMenu.getString(1);
                BalancebuyMenuPick = Integer.parseInt (rs1BalancestringbuyMenuPickMenu);}

            ResultSet sqlRoundCTbuyMenuPickMenu =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTbuyMenuPickMenu.next() ){
                String sqlRoundCTstringbuyMenuPickMenu = sqlRoundCTbuyMenuPickMenu.getString(1);
                RoundCTbuyMenuPick = Integer.parseInt (sqlRoundCTstringbuyMenuPickMenu);}

            ResultSet sqlRoundTbuyMenuPickMenu =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTbuyMenuPickMenu .next() ){
                String sqlRoundTstringbuyMenuPickMenu = sqlRoundTbuyMenuPickMenu .getString(1);
                RoundTbuyMenuPick = Integer.parseInt (sqlRoundTstringbuyMenuPickMenu);}

            ResultSet sqlWeapon1buyMenuPickMenu =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon1buyMenuPickMenu .next() ){
                buyMenuPickWeapon1 = sqlWeapon1buyMenuPickMenu .getString(1);
            }
            
            ResultSet sqlWeapon2buyMenuPickMenu =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon2buyMenuPickMenu .next() ){
                buyMenuPickWeapon2 = sqlWeapon2buyMenuPickMenu .getString(1);
            }
            
            ResultSet sqlZeusbuyMenuPickMenu =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlZeusbuyMenuPickMenu .next() ){
                buyMenuPickZeus = sqlZeusbuyMenuPickMenu .getString(1);
            }
            
            ResultSet sqlGrenade1buyMenuPickMenu =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1buyMenuPickMenu .next() ){
                buyMenuPickGrenade1 = sqlGrenade1buyMenuPickMenu .getString(1);
            }
            
            ResultSet sqlGrenade2buyMenuPickMenu =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2buyMenuPickMenu .next() ){
                buyMenuPickGrenade2 = sqlGrenade2buyMenuPickMenu .getString(1);
            }
            
            ResultSet sqlGrenade3buyMenuPickMenu =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3buyMenuPickMenu .next() ){
                buyMenuPickGrenade3 = sqlGrenade3buyMenuPickMenu .getString(1);
            }
            
            ResultSet sqlGrenade4buyMenuPickMenu =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4buyMenuPickMenu .next() ){
                buyMenuPickGrenade4 = sqlGrenade4buyMenuPickMenu .getString(1);
            }
            
            ResultSet sqlLimitGrenadeConditionPickMenu =  stmt.executeQuery( "SELECT LimitGrenadeCondition FROM IACompCSGO WHERE idNumCS = 1;" ) ;
            
            while(sqlLimitGrenadeConditionPickMenu.next() ){
                sqlStringLimitGrenadeConditionPickMenu = sqlLimitGrenadeConditionPickMenu.getString(1);}
                
            ResultSet sqlSidePickMenu =  stmt.executeQuery( "SELECT SideChoice FROM IACompCSGO WHERE idNumCS = 1;" ) ;
            
            while(sqlSidePickMenu.next() ){
                sqlStringSidePickMenu = sqlSidePickMenu.getString(1);}
                
            ResultSet kitsPistolsSQL =  stmt.executeQuery( "SELECT kits FROM IACompCSGO WHERE idNumCS =  1;") ;
            while( kitsPistolsSQL.next() ){
                buyMenuPickKits = kitsPistolsSQL.getString(1);}
                
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
        tRoundNum.setText(RoundCountbuyMenuPick +  "");
        tBalance.setText(BalancebuyMenuPick + "$");
        tCTscore.setText(RoundCTbuyMenuPick + "");
        tTscore.setText(RoundTbuyMenuPick + "");
        
        tWeapon1.setText(buyMenuPickWeapon1 + "");
        tWeapon2.setText(buyMenuPickWeapon2 + "");
        tZeus.setText(buyMenuPickZeus + "");
        tGrenade1.setText(buyMenuPickGrenade1 + "");
        tGrenade2.setText(buyMenuPickGrenade2 + "");
        tGrenade3.setText(buyMenuPickGrenade3 + "");
        tGrenade4.setText(buyMenuPickGrenade4 + "");
        tKits.setText(buyMenuPickKits + "");
        
        if((RoundCountbuyMenuPick == 1 || RoundCountbuyMenuPick == 16) && sqlStringSidePickMenu.equals("TSide")){
            
            
            bMP9.setEnabled(false);
            
            bFAMAS.setEnabled(false);
            bM4A4.setEnabled(false);
            bM4A1S.setEnabled(false);
            bAUG.setEnabled(false);
            bSCAR20.setEnabled(false);
            
            bMAG7.setEnabled(false);
            
            bMAC10.setEnabled(false);
            bMP5SD.setEnabled(false);
            bMP7.setEnabled(false);
            bUMP45.setEnabled(false);
            bP90.setEnabled(false);
            bPPBizon.setEnabled(false);
            bMP9.setEnabled(false);
            
            bGalilAR.setEnabled(false);
            bAK47.setEnabled(false);
            bSSG08.setEnabled(false);
            bSG553.setEnabled(false);
            bAWP.setEnabled(false);
            bG3SG1.setEnabled(false);
            
            bNova.setEnabled(false);
            bXM1014.setEnabled(false);
            bSawedOff.setEnabled(false);
            bM249.setEnabled(false);
            bNegev.setEnabled(false);
            
        }
        
        if((RoundCountbuyMenuPick == 1 || RoundCountbuyMenuPick == 16) && sqlStringSidePickMenu.equals("CTSide")){
            
            

            
            bMP9.setEnabled(false);
            
            bFAMAS.setEnabled(false);
            bM4A4.setEnabled(false);
            bM4A1S.setEnabled(false);
            bAUG.setEnabled(false);
            bSCAR20.setEnabled(false);
            
            bMAG7.setEnabled(false);
            
            
            
            bMAC10.setEnabled(false);
            bMP5SD.setEnabled(false);
            bMP7.setEnabled(false);
            bUMP45.setEnabled(false);
            bP90.setEnabled(false);
            bPPBizon.setEnabled(false);
            bMP9.setEnabled(false);
            
            bGalilAR.setEnabled(false);
            bAK47.setEnabled(false);
            bSSG08.setEnabled(false);
            bSG553.setEnabled(false);
            bAWP.setEnabled(false);
            bG3SG1.setEnabled(false);
            
            bNova.setEnabled(false);
            bXM1014.setEnabled(false);
            bSawedOff.setEnabled(false);
            bM249.setEnabled(false);
            bNegev.setEnabled(false);
            
        }
        
        if(buyMenuPickGrenade1 != null && buyMenuPickGrenade2 != null && buyMenuPickGrenade3 != null && buyMenuPickGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

        }
        if(buyMenuPickGrenade1 != null){
            if(buyMenuPickGrenade1.equals("Molotov")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
            if(buyMenuPickGrenade1.equals("Decoy")){
            bDecoy.setEnabled(false);
            }
            if(buyMenuPickGrenade1.equals("Flashbang")){
                if(buyMenuPickGrenade2 != null){
                    if(buyMenuPickGrenade2.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(buyMenuPickGrenade3 != null){
                    if(buyMenuPickGrenade3.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(buyMenuPickGrenade4 != null){
                    if(buyMenuPickGrenade4.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
            }
            if(buyMenuPickGrenade1.equals("HE Grenade")){
            bHEGrenade.setEnabled(false);
            }
            if(buyMenuPickGrenade1.equals("Smoke")){
            bSmoke.setEnabled(false);
            }
            if(buyMenuPickGrenade1.equals("Incendiary Grenade")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
        }
        if(buyMenuPickGrenade2 != null){
            if(buyMenuPickGrenade2.equals("Molotov")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
            if(buyMenuPickGrenade2.equals("Decoy")){
            bDecoy.setEnabled(false);
            }
            if(buyMenuPickGrenade2.equals("Flashbang")){
                if(buyMenuPickGrenade1 != null){
                    if(buyMenuPickGrenade1.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(buyMenuPickGrenade3 != null){
                    if(buyMenuPickGrenade3.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(buyMenuPickGrenade4 != null){
                    if(buyMenuPickGrenade4.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
            }
            if(buyMenuPickGrenade2.equals("HE Grenade")){
            bHEGrenade.setEnabled(false);
            }
            if(buyMenuPickGrenade2.equals("Smoke")){
            bSmoke.setEnabled(false);
            }
            if(buyMenuPickGrenade2.equals("Incendiary Grenade")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
        }
        if(buyMenuPickGrenade3 != null){
            if(buyMenuPickGrenade3.equals("Molotov")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
            if(buyMenuPickGrenade3.equals("Decoy")){
            bDecoy.setEnabled(false);
            }
            if(buyMenuPickGrenade3.equals("Flashbang")){
                if(buyMenuPickGrenade1 != null){
                    if(buyMenuPickGrenade1.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(buyMenuPickGrenade2 != null){
                    if(buyMenuPickGrenade2.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(buyMenuPickGrenade4 != null){
                    if(buyMenuPickGrenade4.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
            }
            if(buyMenuPickGrenade3.equals("HE Grenade")){
            bHEGrenade.setEnabled(false);
            }
            if(buyMenuPickGrenade3.equals("Smoke")){
            bSmoke.setEnabled(false);
            }
            if(buyMenuPickGrenade3.equals("Incendiary Grenade")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
        }
        if(buyMenuPickGrenade4 != null){
            if(buyMenuPickGrenade4.equals("Molotov")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
            if(buyMenuPickGrenade4.equals("Decoy")){
            bDecoy.setEnabled(false);
            }
            if(buyMenuPickGrenade4.equals("Flashbang")){
                if(buyMenuPickGrenade1 != null){
                    if(buyMenuPickGrenade1.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(buyMenuPickGrenade2 != null){
                    if(buyMenuPickGrenade2.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(buyMenuPickGrenade3 != null){
                    if(buyMenuPickGrenade3.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
            }
            if(buyMenuPickGrenade4.equals("HE Grenade")){
            bHEGrenade.setEnabled(false);
            }
            if(buyMenuPickGrenade4.equals("Smoke")){
            bSmoke.setEnabled(false);
            }
            if(buyMenuPickGrenade4.equals("Incendiary Grenade")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
        }
        if(buyMenuPickKits != null){
            if(buyMenuPickKits.equals("Kits")){
                bKits.setEnabled(false);
            }
        }
        if(sqlStringSidePickMenu.equals("TSide")){
            bKits.setVisible(false);
        }
    }
    
    public void actions(Object source,String command){
        
        //grenades
        if(source == bMolotov){
            if(buyMenuPickGrenade1 == null){
                buyMenuPickGrenade1 = "Molotov";
                tGrenade1.setText(buyMenuPickGrenade1);
            }else if(buyMenuPickGrenade2 == null){
                buyMenuPickGrenade2 = "Molotov";
                tGrenade2.setText(buyMenuPickGrenade2);
            }else if(buyMenuPickGrenade3 == null){
                buyMenuPickGrenade3 = "Molotov";
                tGrenade3.setText(buyMenuPickGrenade3);
            }else if(buyMenuPickGrenade4 == null){
                buyMenuPickGrenade4 = "Molotov";
                tGrenade4.setText(buyMenuPickGrenade4);
            }
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            if(buyMenuPickGrenade1 != null && buyMenuPickGrenade2 != null && buyMenuPickGrenade3 != null && buyMenuPickGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

            }
        }
        if(source == bDecoy){
            if(buyMenuPickGrenade1 == null){
                buyMenuPickGrenade1 = "Decoy";
                tGrenade1.setText(buyMenuPickGrenade1);
            }else if(buyMenuPickGrenade2 == null){
                buyMenuPickGrenade2 = "Decoy";
                tGrenade2.setText(buyMenuPickGrenade2);
            }else if(buyMenuPickGrenade3 == null){
                buyMenuPickGrenade3 = "Decoy";
                tGrenade3.setText(buyMenuPickGrenade3);
            }else if(buyMenuPickGrenade4 == null){
                buyMenuPickGrenade4 = "Decoy";
                tGrenade4.setText(buyMenuPickGrenade4);
            }
            bDecoy.setEnabled(false);
            if(buyMenuPickGrenade1 != null && buyMenuPickGrenade2 != null && buyMenuPickGrenade3 != null && buyMenuPickGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

            }
        }
        if(source == bFlashbang){
            if(buyMenuPickGrenade1 == null){
                buyMenuPickGrenade1 = "Flashbang";
                tGrenade1.setText(buyMenuPickGrenade1);
            }else if(buyMenuPickGrenade2 == null){
                buyMenuPickGrenade2 = "Flashbang";
                tGrenade2.setText(buyMenuPickGrenade2);
            }else if(buyMenuPickGrenade3 == null){
                buyMenuPickGrenade3 = "Flashbang";
                tGrenade3.setText(buyMenuPickGrenade3);
            }else if(buyMenuPickGrenade4 == null){
                buyMenuPickGrenade4 = "Flashbang";
                tGrenade4.setText(buyMenuPickGrenade4);
            }
            flashbangCountPick = flashbangCountPick + 1;
            if(flashbangCountPick == 2){
                bFlashbang.setEnabled(false);
            }
            if(buyMenuPickGrenade1 != null && buyMenuPickGrenade2 != null && buyMenuPickGrenade3 != null && buyMenuPickGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

            }
        }
        if(source == bHEGrenade){
            if(buyMenuPickGrenade1 == null){
                buyMenuPickGrenade1 = "HE Grenade"; 
                tGrenade1.setText(buyMenuPickGrenade1);
            }else if(buyMenuPickGrenade2 == null){
                buyMenuPickGrenade2 = "HE Grenade";
                tGrenade2.setText(buyMenuPickGrenade2);
            }else if(buyMenuPickGrenade3 == null){
                buyMenuPickGrenade3 = "HE Grenade";
                tGrenade3.setText(buyMenuPickGrenade3);
            }else if(buyMenuPickGrenade4 == null){
                buyMenuPickGrenade4 = "HE Grenade";
                tGrenade4.setText(buyMenuPickGrenade4);
            }
            bHEGrenade.setEnabled(false);
            if(buyMenuPickGrenade1 != null && buyMenuPickGrenade2 != null && buyMenuPickGrenade3 != null && buyMenuPickGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

            }
        }
        if(source == bSmoke){
            if(buyMenuPickGrenade1 == null){
                buyMenuPickGrenade1 = "Smoke"; 
                tGrenade1.setText(buyMenuPickGrenade1);
            }else if(buyMenuPickGrenade2 == null){
                buyMenuPickGrenade2 = "Smoke";
                tGrenade2.setText(buyMenuPickGrenade2);
            }else if(buyMenuPickGrenade3 == null){
                buyMenuPickGrenade3 = "Smoke";
                tGrenade3.setText(buyMenuPickGrenade3);
            }else if(buyMenuPickGrenade4 == null){
                buyMenuPickGrenade4 = "Smoke";
                tGrenade4.setText(buyMenuPickGrenade4);
            }
            bSmoke.setEnabled(false);
            if(buyMenuPickGrenade1 != null && buyMenuPickGrenade2 != null && buyMenuPickGrenade3 != null && buyMenuPickGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

            }
        }
        if(source == bIncendiary){
            if(buyMenuPickGrenade1 == null){
                buyMenuPickGrenade1 = "Incendiary Grenade"; 
                tGrenade1.setText(buyMenuPickGrenade1);
            }else if(buyMenuPickGrenade2 == null){
                buyMenuPickGrenade2 = "Incendiary Grenade";
                tGrenade2.setText(buyMenuPickGrenade2);
            }else if(buyMenuPickGrenade3 == null){
                buyMenuPickGrenade3 = "Incendiary Grenade";
                tGrenade3.setText(buyMenuPickGrenade3);
            }else if(buyMenuPickGrenade4 == null){
                buyMenuPickGrenade4 = "Incendiary Grenade";
                tGrenade4.setText(buyMenuPickGrenade4);
            }
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            if(buyMenuPickGrenade1 != null && buyMenuPickGrenade2 != null && buyMenuPickGrenade3 != null && buyMenuPickGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

            }
        }
        
        //pistols
        if (source == bGlock18){
            buyMenuPickWeapon1 = "Glock-18";
            tWeapon1.setText(buyMenuPickWeapon1);
        }
        if (source == bDualBerettas){
            buyMenuPickWeapon1 = "Dual Berettas";
            tWeapon1.setText(buyMenuPickWeapon1);
        }
        if (source == bP250){
            buyMenuPickWeapon1 = "P250";
            tWeapon1.setText(buyMenuPickWeapon1);
        }
        if (source == bCZ75Auto){
            buyMenuPickWeapon1 = "CZ75-Auto";
            tWeapon1.setText(buyMenuPickWeapon1);
        }
        if(source == bDesertEagle){
            buyMenuPickWeapon1 = "Desert Eagle";
            tWeapon1.setText(buyMenuPickWeapon1);
        }
        if(source == bR8Revolver){
            buyMenuPickWeapon1 = "R8 Revolver";
            tWeapon1.setText(buyMenuPickWeapon1);
        }
        if(source == bTec9 ){
            buyMenuPickWeapon1 = "Tec-9";
            tWeapon1.setText(buyMenuPickWeapon1);
        }
        if(source == bUSPS){
            buyMenuPickWeapon1 = "USP-S";
            tWeapon1.setText(buyMenuPickWeapon1);
        }
        if(source == bP2000){
            buyMenuPickWeapon1 = "P2000";
            tWeapon1.setText(buyMenuPickWeapon1);
        }
        if(source == bFiveSeveN){
            buyMenuPickWeapon1 = "Five-SeveN";
            tWeapon1.setText(buyMenuPickWeapon1);
        }
        
        
        //zeus
        if(source == bZeusx27){
            buyMenuPickZeus = "Zeus";
            tZeus.setText(buyMenuPickZeus);
        }
        if(source == bKits){
            buyMenuPickKits = "Kits";
            tKits.setText(buyMenuPickKits);
        }
        
        //smgs
        if(source == bMAC10){
            buyMenuPickWeapon2 = "MAC-10";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bMP5SD){
            buyMenuPickWeapon2 = "MP5-SD";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bMP7){
            buyMenuPickWeapon2 = "MP7";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bUMP45){
            buyMenuPickWeapon2 = "UMP-45";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bP90){
            buyMenuPickWeapon2 = "P90";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bPPBizon){
            buyMenuPickWeapon2 = "PP-Bizon";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bMP9){
            buyMenuPickWeapon2 = "MP9";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        
        
        //rifles
        if(source == bGalilAR){
            buyMenuPickWeapon2 = "Galil AR";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bAK47){
            buyMenuPickWeapon2 = "AK-47";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bSSG08){
            buyMenuPickWeapon2 = "SSG 08";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bSG553){
            buyMenuPickWeapon2 = "SG 553";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bAWP){
            buyMenuPickWeapon2 = "AWP";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bG3SG1){
            buyMenuPickWeapon2 = "G3SG1";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bFAMAS){
            buyMenuPickWeapon2 = "FAMAS";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bM4A4){
            buyMenuPickWeapon2 = "M4A4";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bM4A1S){
            buyMenuPickWeapon2 = "M4A1-S";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bAUG){
            buyMenuPickWeapon2 = "AUG";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bSCAR20){
            buyMenuPickWeapon2 = "SCAR-20";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        
        //heavy        
        if(source == bNova){
            buyMenuPickWeapon2 = "Nova";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bXM1014){
            buyMenuPickWeapon2 = "XM1014";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bSawedOff){
            buyMenuPickWeapon2 = "Sawed-Off";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bM249){
            buyMenuPickWeapon2 = "M249";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bNegev){
            buyMenuPickWeapon2 = "Negev";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        if(source == bMAG7){
            buyMenuPickWeapon2 = "MAG-7";
            tWeapon2.setText(buyMenuPickWeapon2);
        }
        
        
        
        
        if (source == bQuitbuyMenuPickMenu){
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
                
                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Weapon1 = ?, Weapon2 = ?, Grenade1 = ?, Grenade2 = ?, Grenade3 =?, Grenade4 =?, Zeus = ?, kits = ? WHERE idNumCS = 1;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1,buyMenuPickWeapon1);
                preparedStatement.setString(2,buyMenuPickWeapon2);
                preparedStatement.setString(3,buyMenuPickGrenade1);
                preparedStatement.setString(4,buyMenuPickGrenade2);
                preparedStatement.setString(5,buyMenuPickGrenade3);
                preparedStatement.setString(6,buyMenuPickGrenade4);
                preparedStatement.setString(7,buyMenuPickZeus);
                preparedStatement.setString(8,buyMenuPickKits);
                

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
            new GameTPickDrop();
            dispose(); 
        }
    }
}
