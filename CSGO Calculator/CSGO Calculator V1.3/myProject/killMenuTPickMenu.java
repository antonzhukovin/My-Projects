package myProject;

import java.awt.*;
import java.sql.*;

public class killMenuTPickMenu extends EasyApp
{
    public static void main(String[] args)
    {  new killMenuTPickMenu();}

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
    Label lZeusLabelPickMenu = addLabel("Zeus",476,90,60,30,this);
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

    Button bQuitkillMenuTPickMenu = addButton("Go Back",850,750,150,100,this);

    Label lCT = addLabel("CT",330,50,20,30,this);
    Label lT = addLabel("T",420,50,10,30,this);
    Label lRoundNum = addLabel("Round: ",455,50,50,30,this);
    Label lBalance = addLabel("Balance: ",848,50,62,30,this);

    int RoundCountkillMenuTPickMenu; 
    int BalancekillMenuTPickMenu; 
    int RoundCTkillMenuTPickMenu;
    int RoundTkillMenuTPickMenu;
    int flashbangCountPick = 0;
    String killMenuTPickMenuWeapon1;
    String killMenuTPickMenuWeapon2;
    String killMenuTPickMenuZeus;
    String killMenuTPickMenuGrenade1;
    String killMenuTPickMenuGrenade2;
    String killMenuTPickMenuGrenade3;
    String killMenuTPickMenuGrenade4;
    String killMenuTPickMenuKits;
    String sqlStringLimitGrenadeConditionPickMenu;
    String sqlStringSidePickMenu;

    public killMenuTPickMenu(){
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

            ResultSet sqlRoundCountkillMenuTPickMenu =  stmt.executeQuery( "SELECT RoundCount FROM IACompCSGO WHERE idNumCS = 1;" ) ; //change later

            while( sqlRoundCountkillMenuTPickMenu.next() ){
                String sqlRoundCountstringkillMenuTPickMenu = sqlRoundCountkillMenuTPickMenu.getString(1);
                RoundCountkillMenuTPickMenu = Integer.parseInt (sqlRoundCountstringkillMenuTPickMenu);}

            ResultSet rsBalancekillMenuTPickMenu = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS =  1;" ) ; 
            // Loop through the result set

            while( rsBalancekillMenuTPickMenu.next() ){
                String rs1BalancestringkillMenuTPickMenu = rsBalancekillMenuTPickMenu.getString(1);
                BalancekillMenuTPickMenu = Integer.parseInt (rs1BalancestringkillMenuTPickMenu);}

            ResultSet sqlRoundCTkillMenuTPickMenu =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundCTkillMenuTPickMenu.next() ){
                String sqlRoundCTstringkillMenuTPickMenu = sqlRoundCTkillMenuTPickMenu.getString(1);
                RoundCTkillMenuTPickMenu = Integer.parseInt (sqlRoundCTstringkillMenuTPickMenu);}

            ResultSet sqlRoundTkillMenuTPickMenu =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundTkillMenuTPickMenu .next() ){
                String sqlRoundTstringkillMenuTPickMenu = sqlRoundTkillMenuTPickMenu .getString(1);
                RoundTkillMenuTPickMenu = Integer.parseInt (sqlRoundTstringkillMenuTPickMenu);}

            ResultSet sqlWeapon1killMenuTPickMenu =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon1killMenuTPickMenu .next() ){
                killMenuTPickMenuWeapon1 = sqlWeapon1killMenuTPickMenu .getString(1);
            }
            
            ResultSet sqlWeapon2killMenuTPickMenu =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlWeapon2killMenuTPickMenu .next() ){
                killMenuTPickMenuWeapon2 = sqlWeapon2killMenuTPickMenu .getString(1);
            }
            
            ResultSet sqlZeuskillMenuTPickMenu =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlZeuskillMenuTPickMenu .next() ){
                killMenuTPickMenuZeus = sqlZeuskillMenuTPickMenu .getString(1);
            }
            
            ResultSet sqlGrenade1killMenuTPickMenu =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade1killMenuTPickMenu .next() ){
                killMenuTPickMenuGrenade1 = sqlGrenade1killMenuTPickMenu .getString(1);
            }
            
            ResultSet sqlGrenade2killMenuTPickMenu =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade2killMenuTPickMenu .next() ){
                killMenuTPickMenuGrenade2 = sqlGrenade2killMenuTPickMenu .getString(1);
            }
            
            ResultSet sqlGrenade3killMenuTPickMenu =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade3killMenuTPickMenu .next() ){
                killMenuTPickMenuGrenade3 = sqlGrenade3killMenuTPickMenu .getString(1);
            }
            
            ResultSet sqlGrenade4killMenuTPickMenu =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlGrenade4killMenuTPickMenu .next() ){
                killMenuTPickMenuGrenade4 = sqlGrenade4killMenuTPickMenu .getString(1);
            }
            
            ResultSet sqlLimitGrenadeConditionPickMenu =  stmt.executeQuery( "SELECT LimitGrenadeCondition FROM IACompCSGO WHERE idNumCS = 1;" ) ;
            
            while(sqlLimitGrenadeConditionPickMenu.next() ){
                sqlStringLimitGrenadeConditionPickMenu = sqlLimitGrenadeConditionPickMenu.getString(1);}
                
            ResultSet sqlSidePickMenu =  stmt.executeQuery( "SELECT SideChoice FROM IACompCSGO WHERE idNumCS = 1;" ) ;
            
            while(sqlSidePickMenu.next() ){
                sqlStringSidePickMenu = sqlSidePickMenu.getString(1);}
                
            ResultSet kitsPistolsSQL =  stmt.executeQuery( "SELECT kits FROM IACompCSGO WHERE idNumCS =  1;") ;
            while( kitsPistolsSQL.next() ){
                killMenuTPickMenuKits = kitsPistolsSQL.getString(1);}
                
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
        tRoundNum.setText(RoundCountkillMenuTPickMenu +  "");
        tBalance.setText(BalancekillMenuTPickMenu + "$");
        tCTscore.setText(RoundCTkillMenuTPickMenu + "");
        tTscore.setText(RoundTkillMenuTPickMenu + "");
        
        tWeapon1.setText(killMenuTPickMenuWeapon1 + "");
        tWeapon2.setText(killMenuTPickMenuWeapon2 + "");
        tZeus.setText(killMenuTPickMenuZeus + "");
        tGrenade1.setText(killMenuTPickMenuGrenade1 + "");
        tGrenade2.setText(killMenuTPickMenuGrenade2 + "");
        tGrenade3.setText(killMenuTPickMenuGrenade3 + "");
        tGrenade4.setText(killMenuTPickMenuGrenade4 + "");
        tKits.setText(killMenuTPickMenuKits + "");
        
        if((RoundCountkillMenuTPickMenu == 1 || RoundCountkillMenuTPickMenu == 16) && sqlStringSidePickMenu.equals("TSide")){
            
            
            
            
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
        
        if((RoundCountkillMenuTPickMenu == 1 || RoundCountkillMenuTPickMenu == 16) && sqlStringSidePickMenu.equals("CTSide")){
            
            
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
        
        if(killMenuTPickMenuGrenade1 != null && killMenuTPickMenuGrenade2 != null && killMenuTPickMenuGrenade3 != null && killMenuTPickMenuGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

        }
        if(killMenuTPickMenuGrenade1 != null){
            if(killMenuTPickMenuGrenade1.equals("Molotov")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade1.equals("Decoy")){
            bDecoy.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade1.equals("Flashbang")){
                if(killMenuTPickMenuGrenade2 != null){
                    if(killMenuTPickMenuGrenade2.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(killMenuTPickMenuGrenade3 != null){
                    if(killMenuTPickMenuGrenade3.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(killMenuTPickMenuGrenade4 != null){
                    if(killMenuTPickMenuGrenade4.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
            }
            if(killMenuTPickMenuGrenade1.equals("HE Grenade")){
            bHEGrenade.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade1.equals("Smoke")){
            bSmoke.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade1.equals("Incendiary Grenade")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
        }
        if(killMenuTPickMenuGrenade2 != null){
            if(killMenuTPickMenuGrenade2.equals("Molotov")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade2.equals("Decoy")){
            bDecoy.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade2.equals("Flashbang")){
                if(killMenuTPickMenuGrenade1 != null){
                    if(killMenuTPickMenuGrenade1.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(killMenuTPickMenuGrenade3 != null){
                    if(killMenuTPickMenuGrenade3.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(killMenuTPickMenuGrenade4 != null){
                    if(killMenuTPickMenuGrenade4.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
            }
            if(killMenuTPickMenuGrenade2.equals("HE Grenade")){
            bHEGrenade.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade2.equals("Smoke")){
            bSmoke.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade2.equals("Incendiary Grenade")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
        }
        if(killMenuTPickMenuGrenade3 != null){
            if(killMenuTPickMenuGrenade3.equals("Molotov")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade3.equals("Decoy")){
            bDecoy.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade3.equals("Flashbang")){
                if(killMenuTPickMenuGrenade1 != null){
                    if(killMenuTPickMenuGrenade1.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(killMenuTPickMenuGrenade2 != null){
                    if(killMenuTPickMenuGrenade2.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(killMenuTPickMenuGrenade4 != null){
                    if(killMenuTPickMenuGrenade4.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
            }
            if(killMenuTPickMenuGrenade3.equals("HE Grenade")){
            bHEGrenade.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade3.equals("Smoke")){
            bSmoke.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade3.equals("Incendiary Grenade")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
        }
        if(killMenuTPickMenuGrenade4 != null){
            if(killMenuTPickMenuGrenade4.equals("Molotov")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade4.equals("Decoy")){
            bDecoy.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade4.equals("Flashbang")){
                if(killMenuTPickMenuGrenade1 != null){
                    if(killMenuTPickMenuGrenade1.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(killMenuTPickMenuGrenade2 != null){
                    if(killMenuTPickMenuGrenade2.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
                if(killMenuTPickMenuGrenade3 != null){
                    if(killMenuTPickMenuGrenade3.equals("Flashbang")){
                    bFlashbang.setEnabled(false);
                    }
                }
            }
            if(killMenuTPickMenuGrenade4.equals("HE Grenade")){
            bHEGrenade.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade4.equals("Smoke")){
            bSmoke.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade4.equals("Incendiary Grenade")){
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            }
        }
        if(killMenuTPickMenuKits != null){
            if(killMenuTPickMenuKits.equals("Kits")){
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
            if(killMenuTPickMenuGrenade1 == null){
                killMenuTPickMenuGrenade1 = "Molotov";
                tGrenade1.setText(killMenuTPickMenuGrenade1);
            }else if(killMenuTPickMenuGrenade2 == null){
                killMenuTPickMenuGrenade2 = "Molotov";
                tGrenade2.setText(killMenuTPickMenuGrenade2);
            }else if(killMenuTPickMenuGrenade3 == null){
                killMenuTPickMenuGrenade3 = "Molotov";
                tGrenade3.setText(killMenuTPickMenuGrenade3);
            }else if(killMenuTPickMenuGrenade4 == null){
                killMenuTPickMenuGrenade4 = "Molotov";
                tGrenade4.setText(killMenuTPickMenuGrenade4);
            }
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            if(killMenuTPickMenuGrenade1 != null && killMenuTPickMenuGrenade2 != null && killMenuTPickMenuGrenade3 != null && killMenuTPickMenuGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

            }
        }
        if(source == bDecoy){
            if(killMenuTPickMenuGrenade1 == null){
                killMenuTPickMenuGrenade1 = "Decoy";
                tGrenade1.setText(killMenuTPickMenuGrenade1);
            }else if(killMenuTPickMenuGrenade2 == null){
                killMenuTPickMenuGrenade2 = "Decoy";
                tGrenade2.setText(killMenuTPickMenuGrenade2);
            }else if(killMenuTPickMenuGrenade3 == null){
                killMenuTPickMenuGrenade3 = "Decoy";
                tGrenade3.setText(killMenuTPickMenuGrenade3);
            }else if(killMenuTPickMenuGrenade4 == null){
                killMenuTPickMenuGrenade4 = "Decoy";
                tGrenade4.setText(killMenuTPickMenuGrenade4);
            }
            bDecoy.setEnabled(false);
            if(killMenuTPickMenuGrenade1 != null && killMenuTPickMenuGrenade2 != null && killMenuTPickMenuGrenade3 != null && killMenuTPickMenuGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

            }
        }
        if(source == bFlashbang){
            if(killMenuTPickMenuGrenade1 == null){
                killMenuTPickMenuGrenade1 = "Flashbang";
                tGrenade1.setText(killMenuTPickMenuGrenade1);
            }else if(killMenuTPickMenuGrenade2 == null){
                killMenuTPickMenuGrenade2 = "Flashbang";
                tGrenade2.setText(killMenuTPickMenuGrenade2);
            }else if(killMenuTPickMenuGrenade3 == null){
                killMenuTPickMenuGrenade3 = "Flashbang";
                tGrenade3.setText(killMenuTPickMenuGrenade3);
            }else if(killMenuTPickMenuGrenade4 == null){
                killMenuTPickMenuGrenade4 = "Flashbang";
                tGrenade4.setText(killMenuTPickMenuGrenade4);
            }
            flashbangCountPick = flashbangCountPick + 1;
            if(flashbangCountPick == 2){
                bFlashbang.setEnabled(false);
            }
            if(killMenuTPickMenuGrenade1 != null && killMenuTPickMenuGrenade2 != null && killMenuTPickMenuGrenade3 != null && killMenuTPickMenuGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

            }
        }
        if(source == bHEGrenade){
            if(killMenuTPickMenuGrenade1 == null){
                killMenuTPickMenuGrenade1 = "HE Grenade"; 
                tGrenade1.setText(killMenuTPickMenuGrenade1);
            }else if(killMenuTPickMenuGrenade2 == null){
                killMenuTPickMenuGrenade2 = "HE Grenade";
                tGrenade2.setText(killMenuTPickMenuGrenade2);
            }else if(killMenuTPickMenuGrenade3 == null){
                killMenuTPickMenuGrenade3 = "HE Grenade";
                tGrenade3.setText(killMenuTPickMenuGrenade3);
            }else if(killMenuTPickMenuGrenade4 == null){
                killMenuTPickMenuGrenade4 = "HE Grenade";
                tGrenade4.setText(killMenuTPickMenuGrenade4);
            }
            bHEGrenade.setEnabled(false);
            if(killMenuTPickMenuGrenade1 != null && killMenuTPickMenuGrenade2 != null && killMenuTPickMenuGrenade3 != null && killMenuTPickMenuGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

            }
        }
        if(source == bSmoke){
            if(killMenuTPickMenuGrenade1 == null){
                killMenuTPickMenuGrenade1 = "Smoke"; 
                tGrenade1.setText(killMenuTPickMenuGrenade1);
            }else if(killMenuTPickMenuGrenade2 == null){
                killMenuTPickMenuGrenade2 = "Smoke";
                tGrenade2.setText(killMenuTPickMenuGrenade2);
            }else if(killMenuTPickMenuGrenade3 == null){
                killMenuTPickMenuGrenade3 = "Smoke";
                tGrenade3.setText(killMenuTPickMenuGrenade3);
            }else if(killMenuTPickMenuGrenade4 == null){
                killMenuTPickMenuGrenade4 = "Smoke";
                tGrenade4.setText(killMenuTPickMenuGrenade4);
            }
            bSmoke.setEnabled(false);
            if(killMenuTPickMenuGrenade1 != null && killMenuTPickMenuGrenade2 != null && killMenuTPickMenuGrenade3 != null && killMenuTPickMenuGrenade4 != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);

            }
        }
        if(source == bIncendiary){
            if(killMenuTPickMenuGrenade1 == null){
                killMenuTPickMenuGrenade1 = "Incendiary Grenade"; 
                tGrenade1.setText(killMenuTPickMenuGrenade1);
            }else if(killMenuTPickMenuGrenade2 == null){
                killMenuTPickMenuGrenade2 = "Incendiary Grenade";
                tGrenade2.setText(killMenuTPickMenuGrenade2);
            }else if(killMenuTPickMenuGrenade3 == null){
                killMenuTPickMenuGrenade3 = "Incendiary Grenade";
                tGrenade3.setText(killMenuTPickMenuGrenade3);
            }else if(killMenuTPickMenuGrenade4 == null){
                killMenuTPickMenuGrenade4 = "Incendiary Grenade";
                tGrenade4.setText(killMenuTPickMenuGrenade4);
            }
            bMolotov.setEnabled(false);
            bIncendiary.setEnabled(false);
            if(killMenuTPickMenuGrenade1 != null && killMenuTPickMenuGrenade2 != null && killMenuTPickMenuGrenade3 != null && killMenuTPickMenuGrenade4 != null){
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
            killMenuTPickMenuWeapon1 = "Glock-18";
            tWeapon1.setText(killMenuTPickMenuWeapon1);
        }
        if (source == bDualBerettas){
            killMenuTPickMenuWeapon1 = "Dual Berettas";
            tWeapon1.setText(killMenuTPickMenuWeapon1);
        }
        if (source == bP250){
            killMenuTPickMenuWeapon1 = "P250";
            tWeapon1.setText(killMenuTPickMenuWeapon1);
        }
        if (source == bCZ75Auto){
            killMenuTPickMenuWeapon1 = "CZ75-Auto";
            tWeapon1.setText(killMenuTPickMenuWeapon1);
        }
        if(source == bDesertEagle){
            killMenuTPickMenuWeapon1 = "Desert Eagle";
            tWeapon1.setText(killMenuTPickMenuWeapon1);
        }
        if(source == bR8Revolver){
            killMenuTPickMenuWeapon1 = "R8 Revolver";
            tWeapon1.setText(killMenuTPickMenuWeapon1);
        }
        if(source == bTec9 ){
            killMenuTPickMenuWeapon1 = "Tec-9";
            tWeapon1.setText(killMenuTPickMenuWeapon1);
        }
        if(source == bUSPS){
            killMenuTPickMenuWeapon1 = "USP-S";
            tWeapon1.setText(killMenuTPickMenuWeapon1);
        }
        if(source == bP2000){
            killMenuTPickMenuWeapon1 = "P2000";
            tWeapon1.setText(killMenuTPickMenuWeapon1);
        }
        if(source == bFiveSeveN){
            killMenuTPickMenuWeapon1 = "Five-SeveN";
            tWeapon1.setText(killMenuTPickMenuWeapon1);
        }
        
        
        //zeus
        if(source == bZeusx27){
            killMenuTPickMenuZeus = "Zeus";
            tZeus.setText(killMenuTPickMenuZeus);
        }
        if(source == bKits){
            killMenuTPickMenuKits = "Kits";
            tKits.setText(killMenuTPickMenuKits);
        }
        
        //smgs
        if(source == bMAC10){
            killMenuTPickMenuWeapon2 = "MAC-10";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bMP5SD){
            killMenuTPickMenuWeapon2 = "MP5-SD";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bMP7){
            killMenuTPickMenuWeapon2 = "MP7";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bUMP45){
            killMenuTPickMenuWeapon2 = "UMP-45";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bP90){
            killMenuTPickMenuWeapon2 = "P90";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bPPBizon){
            killMenuTPickMenuWeapon2 = "PP-Bizon";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bMP9){
            killMenuTPickMenuWeapon2 = "MP9";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        
        
        //rifles
        if(source == bGalilAR){
            killMenuTPickMenuWeapon2 = "Galil AR";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bAK47){
            killMenuTPickMenuWeapon2 = "AK-47";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bSSG08){
            killMenuTPickMenuWeapon2 = "SSG 08";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bSG553){
            killMenuTPickMenuWeapon2 = "SG 553";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bAWP){
            killMenuTPickMenuWeapon2 = "AWP";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bG3SG1){
            killMenuTPickMenuWeapon2 = "G3SG1";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bFAMAS){
            killMenuTPickMenuWeapon2 = "FAMAS";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bM4A4){
            killMenuTPickMenuWeapon2 = "M4A4";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bM4A1S){
            killMenuTPickMenuWeapon2 = "M4A1-S";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bAUG){
            killMenuTPickMenuWeapon2 = "AUG";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bSCAR20){
            killMenuTPickMenuWeapon2 = "SCAR-20";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        
        //heavy        
        if(source == bNova){
            killMenuTPickMenuWeapon2 = "Nova";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bXM1014){
            killMenuTPickMenuWeapon2 = "XM1014";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bSawedOff){
            killMenuTPickMenuWeapon2 = "Sawed-Off";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bM249){
            killMenuTPickMenuWeapon2 = "M249";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bNegev){
            killMenuTPickMenuWeapon2 = "Negev";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        if(source == bMAG7){
            killMenuTPickMenuWeapon2 = "MAG-7";
            tWeapon2.setText(killMenuTPickMenuWeapon2);
        }
        
        
        
        
        if (source == bQuitkillMenuTPickMenu){
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

                preparedStatement.setString(1,killMenuTPickMenuWeapon1);
                preparedStatement.setString(2,killMenuTPickMenuWeapon2);
                preparedStatement.setString(3,killMenuTPickMenuGrenade1);
                preparedStatement.setString(4,killMenuTPickMenuGrenade2);
                preparedStatement.setString(5,killMenuTPickMenuGrenade3);
                preparedStatement.setString(6,killMenuTPickMenuGrenade4);
                preparedStatement.setString(7,killMenuTPickMenuZeus);
                preparedStatement.setString(8,killMenuTPickMenuKits); 
                

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
