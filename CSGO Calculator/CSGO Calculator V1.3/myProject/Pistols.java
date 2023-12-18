package myProject;

import java.awt.*;
import java.sql.* ;

public class Pistols extends EasyApp
{
    public static void main(String[] args)
    {  new Pistols();
    }

    Label lSide = addLabel("",60,30,225,60,this);//Adds the label, which states the player's side. Changes later, when the side is imported from MySQL. 
    Label lGrenadeLabel = addLabel("Grenades",70,90,60,30,this); //Adds the label above the buttons for Grenades
    Label lPistolsLabel = addLabel("Pistols",254,90,60,30,this); //Adds the label above the buttons for Pistols
    Label lGearLabel = addLabel("Gear",476,90,60,30,this); //Adds the label above the buttons for Gear
    Label lSMGLabel = addLabel("SMG",742,90,60,30,this); //Adds the label above the buttons for SMG
    Label lRiflesLabel = addLabel("Rifles",1008,90,60,30,this); //Adds the label above the buttons for Rifles
    Label lHeavyLabel = addLabel("Heavy",1274,90,60,30,this); //Adds the label above the buttons for Heavy 
    
    TextField tWeapon1 = addTextField("",70,820,100,30,this); //Adds the text field, where player's current weapon is displayed. Imported from MySQL
    TextField tWeapon2 = addTextField("",170,820,100,30,this); //Adds the text field, where player's current weapon is displayed. Imported from MySQL
    TextField tZeus = addTextField("",270,820,100,30,this); //Adds the text field, where player's current weapon is displayed. Imported from MySQL
    TextField tGrenade1 = addTextField("",370,820,100,30,this); //Adds the text field, where player's current weapon is displayed. Imported from MySQL
    TextField tGrenade2 = addTextField("",470,820,100,30,this); //Adds the text field, where player's current weapon is displayed. Imported from MySQL
    TextField tGrenade3 = addTextField("",570,820,100,30,this); //Adds the text field, where player's current weapon is displayed. Imported from MySQL
    TextField tGrenade4 = addTextField("",670,820,100,30,this); //Adds the text field, where player's current weapon is displayed. Imported from MySQL
    TextField tKits = addTextField("",770,820,100,30,this); //Adds the text field, where player's current weapon is displayed. Imported from MySQL
    TextField tArmor = addTextField("",870,820,100,30,this); //Adds the text field, where player's current weapon is displayed. Imported from MySQL

    Button bMolotov = addButton("Molotov\n400$",0,120,183,100, this); //Adds the button, which allows to buy Molotov
    Button bDecoy = addButton("Decoy\n50$",0,220,183,100, this); //Adds the button, which allows to buy Decoy
    Button bFlashbang = addButton("Flashbang\n200$",0,320,183,100,this); //Adds the button, which allows to buy Flashbang
    Button bHEGrenade = addButton("HE Grenade\n300$",0,420,183,100,this); //Adds the button, which allows to buy HE Grendade
    Button bSmoke = addButton("Smoke\n600$",0,520,183,100,this); //Adds the button, which allows to buy Smoke

    Button bIncendiary = addButton("Incendiary\n600$",0,120,183,100, this); //Adds the button, which allows to buy Incendiary 

    Button bGlock18 = addButton("Glock-18\n200$",183,120,183,100,this); //Adds the button, which allows to buy Glock-18
    Button bDualBerettas= addButton("Dual Berettas\n300$",183,220,183,100,this); //Adds the button, which allows to buy Dual Berettas
    Button bP250 = addButton("P250\n300$",183,320,183,100,this); //Adds the button, which allows to buy P250
    Button bCZ75Auto = addButton("CZ75 - Auto\n500$",183,420,183,100,this); //Adds the button, which allows to buy CZ75 - Auto
    Button bDesertEagle = addButton("Desert Eagle\n700$",183,520,183,100,this); //Adds the button, which allows to buy Desert Eagle
    Button bR8Revolver = addButton("R8 Revolver\n600$",183,620,183,100,this); //Adds the button, which allows to buy R8 Revolver
    Button bTec9 = addButton("Tec-9\n500$",183,720,183,100,this); //Adds the button, which allows to buy Tec-9

    Button bUSPS = addButton("USP-S\n200$",183,120,183,100,this); //Adds the button, which allows to buy USP-S
    Button bP2000 = addButton("P2000\n200$",183,120,183,100,this); //Adds the button, which allows to buy P2000
    Button bFiveSeven = addButton("Five-SeveN\n500$",183,420,183,100,this); //CT WEAPON CHOICE TO DO

    Button bKevlarVest = addButton("Kevlar Vest\n650$",366,120,266,100,this);
    Button bKevlarVestHelmet = addButton("Kevlar Vest + Helmet\n1000$",366,220,266,100,this);
    Button bZeusx27 = addButton("Zeus x27\n200$",366,320,266,100,this);
    Button bHelmet = addButton("Helmet (when armor is full)\n350$",366,420,266,100,this);
    Button bKits = addButton("Defuse Kits\n400$",366,520,266,100,this); //finish

    Button bMAC10 = addButton("MAC-10\n1050$",632,120,266,100,this);
    Button bMP5SD = addButton("MP5-SD\n1500$",632,220,266,100,this);
    Button bMP7 = addButton("MP7\n1500$",632,320,266,100,this);
    Button bUMP45 = addButton("UMP - 45\n1200$",632,420,266,100,this);
    Button bP90 = addButton("P90\n2350$",632,520,266,100,this);
    Button bPPBizon = addButton("PP-Bizon\n1400$",632,620,266,100,this);

    Button bMP9 = addButton("MP9\n1250$",632,120,266,100,this); //CT TO DO

    Button bGalilAR = addButton("Galil AR\n1800$",898,120,266,100,this);
    Button bAK47 = addButton("AK-47\n2700$",898,220,266,100,this);
    Button bSSG08 = addButton("SSG 08\n1700$",898,320,266,100,this);
    Button bSG553 = addButton("SG 553\n3000$",898,420,266,100,this);
    Button bAWP = addButton("AWP\n4750$",898,520,266,100,this);
    Button bG3SG1 = addButton("G3SG1\n5000$",898,620,266,100,this);

    Button bM4A4 = addButton("M4A4\n3100$",898,220,266,100,this); //CT WEAPON CHOICE TO DO
    Button bM4A1S = addButton("M4A1-S\n2900$",898,220,266,100,this); //CT WEAPON CHOICE TO DO
    Button bAUG = addButton("AUG\n3300$",898,420,266,100,this);
    Button bFAMAS = addButton("FAMAS\n2050$",898,120,266,100,this); //CT WEAPON CHOICE TO DO
    Button bSCAR20 = addButton("SCAR-20\n5000$",898,620,266,100,this); //CT WEAPON CHOICE TO DO

    Button bNova = addButton("Nova\n1050$",1164,120,266,100,this);
    Button bXM1014 = addButton("XM1014\n2000$",1164,220,266,100,this);
    Button bSawedOff = addButton("Sawed-Off\n1100$",1164,320,266,100,this);
    Button bM249 = addButton("M249\n5200$",1164,420,266,100,this);
    Button bNegev= addButton("Negev\n1700$",1164,520,266,100,this);

    Button bQuitPistolsMenu = addButton("Go Back",1250,700,150,100,this);

    TextField tCTscore = addTextField("0",350,50,31,30,this); //Shows how many rounds has the CT side won
    TextField tTscore = addTextField("0",382,50,31,30,this); //Shows how many rounds has the T side won
    TextField tRoundNum = addTextField("0",960,900,31,30,this); //Shows how many rounds were played
    TextField tBalance = addTextField("0",900,50,62,30,this); //Shows the balance of the player

    Label lCT = addLabel("CT",330,50,50,30,this); //Defines that the text field is showing how many rounds has the CT side won
    Label lT = addLabel("T",420,50,50,30,this); //Defines that the text field is showing how many rounds has the T side won
    Label lRoundNum = addLabel("Round: ",900,900,50,30,this); //Defines that the text field is showing how many rounds were played
    Label lBalance = addLabel("Balance: ",848,50,62,30,this); //Defines that the text field is showing the balance of the player

    int grenadeCountPistols = 0;
    int flashbangCountPistols = 0;

    boolean playerHasFullArmor = false;
    boolean playerHasFullArmorAndHelmet = false;

    int intRSBalance;
    int intSQLRoundCT;
    int intSQLRoundT;
    int intSQLRoundNumber;

    String Weapon1PistolsSQL;
    String Weapon2PistolsSQL;
    String ArmorPistolsSQL;
    String ZeusPistolsSQL;
    String Grenade1PistolsSQL;
    String Grenade2PistolsSQL;
    String Grenade3PistolsSQL;
    String Grenade4PistolsSQL;
    String kitsStringPistolsSQL;

    String sqlStringTCZ75orTec9;
    String sqlStringTDeagleORr8; 
    String sqlStringTmp5SDorMP7;
    String sqlStringCTuspsORp2000;
    String sqlStringCTDeagleORr8; 
    String sqlStringsqlCTCZ75or57;
    String sqlStringCTmp5SDorMP7; 
    String sqlStringCTM4a4orM4a1s;

    String sqlStringMolotovBuyCondition;
    String sqlStringDecoyBuyCondition;
    String sqlStringFlashBuyCondition;
    String sqlStringSmokeBuyCondition; 
    String sqlStringHEBuyCondition;
    String sqlStringIncendiaryBuyCondition;
    String sqlStringLimitGrenadeCondition; 

    String sqlStringSide;

    String sqlStringPistolNullCondition;
    //mySQL

    public Pistols()   // Constructor - change window appearance
    {
        //MySQL

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
                intSQLRoundNumber = Integer.parseInt (sqlRoundCountstring);}

            ResultSet rsBalance = stmt.executeQuery( "SELECT Balance FROM IACompCSGO WHERE idNumCS = 1;" ) ; 
            // Loop through the result set

            while( rsBalance.next() ){
                String rs1Balancestring = rsBalance.getString(1);
                intRSBalance = Integer.parseInt (rs1Balancestring);}

            ResultSet sqlRoundCT =  stmt.executeQuery( "SELECT RoundCT FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlRoundCT.next() ){
                String sqlRoundCTstring = sqlRoundCT.getString(1);
                intSQLRoundCT = Integer.parseInt (sqlRoundCTstring);}

            ResultSet sqlRoundT =  stmt.executeQuery( "SELECT RoundT FROM IACompCSGO WHERE idNumCS =  1;" ) ;

            while( sqlRoundT.next() ){
                String sqlRoundTstring = sqlRoundT.getString(1);
                intSQLRoundT = Integer.parseInt (sqlRoundTstring);}

            ResultSet sqlWeapon1 =  stmt.executeQuery( "SELECT Weapon1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;
            while( sqlWeapon1.next() ){
                Weapon1PistolsSQL = sqlWeapon1.getString(1);}

            ResultSet sqlWeapon2 =  stmt.executeQuery( "SELECT Weapon2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;
            while( sqlWeapon2.next() ){
                Weapon2PistolsSQL = sqlWeapon2.getString(1);}

            ResultSet sqlArmor =  stmt.executeQuery( "SELECT Armor FROM IACompCSGO WHERE idNumCS =  1;" ) ;
            while( sqlArmor.next() ){
                ArmorPistolsSQL = sqlArmor.getString(1);}

            ResultSet sqlZeus =  stmt.executeQuery( "SELECT Zeus FROM IACompCSGO WHERE idNumCS =  1;") ;
            while( sqlZeus.next() ){
                ZeusPistolsSQL = sqlZeus.getString(1);}    
                
            ResultSet kitsPistolsSQL =  stmt.executeQuery( "SELECT kits FROM IACompCSGO WHERE idNumCS =  1;") ;
            while( kitsPistolsSQL.next() ){
                kitsStringPistolsSQL = kitsPistolsSQL.getString(1);}

            ResultSet sqlGrenade1 =  stmt.executeQuery( "SELECT Grenade1 FROM IACompCSGO WHERE idNumCS =  1;" ) ;
            while( sqlGrenade1.next() ){
                Grenade1PistolsSQL = sqlGrenade1.getString(1);}

            ResultSet sqlGrenade2 =  stmt.executeQuery( "SELECT Grenade2 FROM IACompCSGO WHERE idNumCS =  1;" ) ;
            while( sqlGrenade2.next() ){
                Grenade2PistolsSQL = sqlGrenade2.getString(1);}

            ResultSet sqlGrenade3 =  stmt.executeQuery( "SELECT Grenade3 FROM IACompCSGO WHERE idNumCS =  1;") ;
            while( sqlGrenade3.next() ){
                Grenade3PistolsSQL = sqlGrenade3.getString(1);}

            ResultSet sqlGrenade4 =  stmt.executeQuery( "SELECT Grenade4 FROM IACompCSGO WHERE idNumCS =  1;" ) ;
            while( sqlGrenade4.next() ){
                Grenade4PistolsSQL = sqlGrenade4.getString(1);}

            ResultSet sqlTCZ75orTec9 =  stmt.executeQuery( "SELECT TCZ75orTec9 FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlTCZ75orTec9.next() ){
                sqlStringTCZ75orTec9 = sqlTCZ75orTec9.getString(1);}

            ResultSet sqlTDeagleORr8 =  stmt.executeQuery( "SELECT TDeagleORr8 FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlTDeagleORr8.next() ){
                sqlStringTDeagleORr8 = sqlTDeagleORr8.getString(1);}

            ResultSet sqlTmp5SDorMP7 =  stmt.executeQuery( "SELECT Tmp5SDorMP7 FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlTmp5SDorMP7.next() ){
                sqlStringTmp5SDorMP7 = sqlTmp5SDorMP7.getString(1);}

            ResultSet sqlCTuspsORp2000 =  stmt.executeQuery( "SELECT CTuspsORp2000 FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlCTuspsORp2000.next() ){ 
                sqlStringCTuspsORp2000 = sqlCTuspsORp2000.getString(1);}

            ResultSet sqlCTDeagleORr8 =  stmt.executeQuery( "SELECT CTDeagleORr8 FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlCTDeagleORr8.next() ){
                sqlStringCTDeagleORr8 = sqlCTDeagleORr8.getString(1);}

            ResultSet sqlCTCZ75or57 =  stmt.executeQuery( "SELECT CTCZ75or57 FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlCTCZ75or57.next() ){
                sqlStringsqlCTCZ75or57 = sqlCTCZ75or57.getString(1);}

            ResultSet sqlCTmp5SDorMP7 =  stmt.executeQuery( "SELECT CTmp5SDorMP7 FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlCTmp5SDorMP7.next() ){
                sqlStringCTmp5SDorMP7 = sqlCTmp5SDorMP7.getString(1);}

            ResultSet sqlCTM4a4orM4a1s =  stmt.executeQuery( "SELECT CTM4a4orM4a1s FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlCTM4a4orM4a1s.next() ){
                sqlStringCTM4a4orM4a1s = sqlCTM4a4orM4a1s.getString(1);}

            ResultSet sqlMolotovBuyCondition =  stmt.executeQuery( "SELECT MolotovBuyCondition FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlMolotovBuyCondition.next() ){
                sqlStringMolotovBuyCondition = sqlMolotovBuyCondition.getString(1);}

            ResultSet sqlDecoyBuyCondition =  stmt.executeQuery( "SELECT DecoyBuyCondition FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlDecoyBuyCondition.next() ){
                sqlStringDecoyBuyCondition = sqlDecoyBuyCondition.getString(1);}

            ResultSet sqlFlashBuyCondition =  stmt.executeQuery( "SELECT FlashBuyCondition FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlFlashBuyCondition.next() ){
                sqlStringFlashBuyCondition = sqlFlashBuyCondition.getString(1);}

            ResultSet sqlSmokeBuyCondition =  stmt.executeQuery( "SELECT SmokeBuyCondition FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlSmokeBuyCondition.next() ){
                sqlStringSmokeBuyCondition = sqlSmokeBuyCondition.getString(1);}

            ResultSet sqlHEBuyCondition =  stmt.executeQuery( "SELECT HEBuyCondition FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlHEBuyCondition.next() ){
                sqlStringHEBuyCondition = sqlHEBuyCondition.getString(1);}
                
            ResultSet sqlIncendiaryBuyCondition =  stmt.executeQuery( "SELECT incendiaryBuyCondition FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlIncendiaryBuyCondition.next() ){
                sqlStringIncendiaryBuyCondition = sqlIncendiaryBuyCondition.getString(1);}

            ResultSet sqlLimitGrenadeCondition =  stmt.executeQuery( "SELECT LimitGrenadeCondition FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlLimitGrenadeCondition.next() ){
                sqlStringLimitGrenadeCondition = sqlLimitGrenadeCondition.getString(1);}

            ResultSet sqlPistolNullCondition = stmt.executeQuery( "SELECT PistolNullCondition FROM IACompCSGO WHERE idNumCS = 1;" ) ;

            while( sqlPistolNullCondition.next() ){
                sqlStringPistolNullCondition = sqlPistolNullCondition.getString(1);}

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

        if((intSQLRoundNumber == 1 && Weapon1PistolsSQL == null && sqlStringPistolNullCondition.equals("False") && sqlStringSide.equals("TSide")  ) || (intSQLRoundNumber == 16 && Weapon1PistolsSQL == null && sqlStringPistolNullCondition.equals("False") && sqlStringSide.equals("TSide")) ){
            Weapon1PistolsSQL = "Glock-18";
            bGlock18.setEnabled(false);
        }
        
        if((intSQLRoundNumber == 1 && Weapon1PistolsSQL == null && sqlStringPistolNullCondition.equals("False") && sqlStringSide.equals("CTSide") && sqlStringCTuspsORp2000.equals("CTUSPS")) || (intSQLRoundNumber == 16 && Weapon1PistolsSQL == null && sqlStringPistolNullCondition.equals("False") && sqlStringSide.equals("CTSide") && sqlStringCTuspsORp2000.equals("CTUSPS")) ){
            Weapon1PistolsSQL = "USP-S";
            bUSPS.setEnabled(false);
        }
        
        if((intSQLRoundNumber == 1 && Weapon1PistolsSQL == null && sqlStringPistolNullCondition.equals("False") && sqlStringSide.equals("CTSide") && sqlStringCTuspsORp2000.equals("P2000")) || (intSQLRoundNumber == 16 && Weapon1PistolsSQL == null && sqlStringPistolNullCondition.equals("False") && sqlStringSide.equals("CTSide") && sqlStringCTuspsORp2000.equals("P2000")) ){
            Weapon1PistolsSQL = "P2000";
            bP2000.setEnabled(false);
        }
        
        tWeapon1.setText(Weapon1PistolsSQL + ""); 
        tWeapon2.setText(Weapon2PistolsSQL + "");
        tZeus.setText(ZeusPistolsSQL + "");
        tGrenade1.setText(Grenade1PistolsSQL + "");
        tGrenade2.setText(Grenade2PistolsSQL + "");
        tGrenade3.setText(Grenade3PistolsSQL + "");
        tGrenade4.setText(Grenade4PistolsSQL + "");
        tKits.setText(kitsStringPistolsSQL + "");
        tArmor.setText(ArmorPistolsSQL + "");
        

        setSize(1920,1080);
        setTitle("CS:GO Economy - (c) 2021 Anton Zhukovin, Russia");
        setBackground(new Color(255,255,180));

        tRoundNum.setText(intSQLRoundNumber  + ""); //shows the number of rounds played
        tBalance.setText(intRSBalance + "$"); //shows the balance of the player
        tCTscore.setText(intSQLRoundCT + ""); //shows the number of rounds that the CT side have won
        tTscore.setText(intSQLRoundT + ""); //shows the number of rounds that the T side have won
        
        if(sqlStringSide.equals("TSide")){
            lSide.setText("You are playing for T side");
        }
        if(sqlStringSide.equals("CTSide")){
            lSide.setText("You are playing for CT side");
        }
        
        

        if(Grenade1PistolsSQL != null && Grenade2PistolsSQL != null && Grenade3PistolsSQL != null && Grenade4PistolsSQL != null){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);
        }

        
        bHelmet.setEnabled(false);
        if(sqlStringSide.equals("TSide")){ //To remove the weapons, that are not available and taking the same slot, when the player is playing for T Side
            bGlock18.setVisible(true); //To make the purchase of Glock-18 available, as it is weapon exclusive for T Side
            bMolotov.setVisible(true); //To make the purchase of Molotov available, as it is weapon exclusive for T Side
            bTec9.setVisible(true); //To make the purchase of Tec-9 available, as it is weapon exclusive for T Side
            bMAC10.setVisible(true); //To make the purchase of MAC-10 available, as it is weapon exclusive for T Side
            bGalilAR.setVisible(true); //To make the purchase of Galil AR available, as it is weapon exclusive for T Side
            bAK47.setVisible(true); //To make the purchase of AK-47 available, as it is weapon exclusive for T Side
            bG3SG1.setVisible(true); //To make the purchase of G3SG1 available, as it is weapon exclusive for T Side
            bSG553.setVisible(true); //To make the purchase of SG553 available, as it is weapon exclusive for T Side
            bKits.setVisible(false); //To make the purchase of Kits not available, as it is equipment exclusive for CT Side
            bMP9.setVisible(false); //To make the purchase of MP9 not available, as it is equipment exclusive for CT Side
            bFiveSeven.setVisible(false); //To make the purchase of Five-SeveN not available, as it is equipment exclusive for CT Side
            bFAMAS.setVisible(false); //To make the purchase of FAMAS not available, as it is weapon exclusive for CT Side
            bSCAR20.setVisible(false); //To make the purchase of SCAR-20 not available, as it is weapon exclusive for CT Side
            bAUG.setVisible(false); //To make the purchase of AUG not available, as it is weapon exclusive for CT Side
            bIncendiary.setVisible(false); //To make the purchase of Incendiary not available, as it is weapon exclusive for CT Side
            if(sqlStringTCZ75orTec9.equals("TCZ75")){ //If statement for weapons chosen in Weaponchoice menu. One - to disable, another - enable
                bTec9.setEnabled(false);
            }else if(sqlStringTCZ75orTec9.equals("TTec9")){
                bCZ75Auto.setEnabled(false);
            }
            if(sqlStringTDeagleORr8.equals("TDeagle")){ //If statement for weapons chosen in Weaponchoice menu. One - to disable, another - enable
                bR8Revolver.setEnabled(false);
            }else if(sqlStringTDeagleORr8.equals("TR8")){
                bDesertEagle.setEnabled(false);
            }
            if(sqlStringTmp5SDorMP7.equals("TMP5SD")){ //If statement for weapons chosen in Weaponchoice menu. One - to disable, another - enable
                bMP7.setEnabled(false);
            }else if(sqlStringTmp5SDorMP7.equals("TMP7")){
                bMP5SD.setEnabled(false);
            }
        }
        if(sqlStringSide.equals("CTSide")){ //To remove the weapons, that are not available and taking the same slot, when the player is playing for T Side
            bGlock18.setVisible(false); //To make the purchase of Glock-18 not available, as it is weapon exclusive for T Side
            bMolotov.setVisible(false); //To make the purchase of Molotov not available, as it is weapon exclusive for T Side
            bTec9.setVisible(false); //To make the purchase of Tec-9 not available, as it is weapon exclusive for T Side
            bMAC10.setVisible(false);
            bGalilAR.setVisible(false);
            bAK47.setVisible(false);
            bG3SG1.setVisible(false);
            bKits.setVisible(true);
            bMP9.setVisible(true);
            bFiveSeven.setVisible(true);
            bFAMAS.setVisible(true);
            bSCAR20.setVisible(true);
            bAUG.setVisible(true);
            bSG553.setVisible(false);
            bIncendiary.setVisible(true);
            if(sqlStringCTuspsORp2000.equals("CTUSPS")){
                bUSPS.setVisible(true);
                bP2000.setVisible(false);
            } else if(sqlStringCTuspsORp2000.equals("CTP2000")){
                bP2000.setVisible(true);
                bUSPS.setVisible(false);
            }
            if(sqlStringCTDeagleORr8.equals("CTDeagle")){
                bR8Revolver.setEnabled(false);
                bDesertEagle.setEnabled(true);
            }else if(sqlStringCTDeagleORr8.equals("CTR8")){
                bDesertEagle.setEnabled(false);
                bR8Revolver.setEnabled(true);
            }
            if(sqlStringsqlCTCZ75or57.equals("CTCZ75")){
                bCZ75Auto.setVisible(true);
                bFiveSeven.setVisible(false);
            }else if(sqlStringsqlCTCZ75or57.equals("CT57")){
                 bFiveSeven.setVisible(true);
                 bCZ75Auto.setVisible(false);
            }
            if(sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP7.setEnabled(false);
                bMP5SD.setEnabled(true);
            }else if(sqlStringCTmp5SDorMP7.equals("CTMP7")){
                bMP7.setEnabled(true);
                bMP5SD.setEnabled(false);
            }
            if(sqlStringCTM4a4orM4a1s.equals("CTM4A4")){
                bM4A4.setVisible(true);
                bM4A1S.setVisible(false);
            }else if(sqlStringCTM4a4orM4a1s.equals("CTM4A1S")){
                bM4A4.setVisible(false);
                bM4A1S.setVisible(true);
            }       
            
        }
        if(intRSBalance < 5200){
            bM249.setEnabled(false);
        }
        if(intRSBalance < 5000){
            bG3SG1.setEnabled(false);
            bSCAR20.setEnabled(false);
        }
        if(intRSBalance < 4750){
            bAWP.setEnabled(false);
        }
        if(intRSBalance < 3300){
            bAUG.setEnabled(false);
        }
        if(intRSBalance < 3100){
            bM4A4.setEnabled(false);
        }
        if(intRSBalance < 3000){
            bSG553.setEnabled(false);
        }
        if(intRSBalance < 2900){
            bM4A1S.setEnabled(false);
        }
        if(intRSBalance < 2700){
            bAK47.setEnabled(false);
        }
        if(intRSBalance < 2350){
            bP90.setEnabled(false);
        }
        if(intRSBalance < 2050){
            bFAMAS.setEnabled(false);
        }
        if(intRSBalance < 2000){
            bXM1014.setEnabled(false);
        }
        if(intRSBalance < 1800){
            bGalilAR.setEnabled(false);
        }
        if(intRSBalance < 1700){
            bSSG08.setEnabled(false);
            bNegev.setEnabled(false);
        }
        if(intRSBalance < 1500){
            bMP5SD.setEnabled(false);
            bMP7.setEnabled(false);
        }
        if(intRSBalance < 1400){
            bPPBizon.setEnabled(false);
        }
        if(intRSBalance < 1250){
            bMP9.setEnabled(false);
        }
        if(intRSBalance < 1200){
            bUMP45.setEnabled(false);
        }
        if(intRSBalance < 1100){
            bSawedOff.setEnabled(false);
        }
        if(intRSBalance < 1050){
            bMAC10.setEnabled(false);
            bNova.setEnabled(false);
        }
        if(intRSBalance < 1000){
            bKevlarVestHelmet.setEnabled(false);
        }
        if(intRSBalance < 700){
            bDesertEagle.setEnabled(false);
        }
        if(intRSBalance < 650){
            bKevlarVest.setEnabled(false);
        }
        if(intRSBalance < 600){
            bR8Revolver.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);
        }
        if(intRSBalance < 500){
            bCZ75Auto.setEnabled(false);
            bTec9.setEnabled(false);
            bFiveSeven.setEnabled(false);
        }
        if(intRSBalance < 400){
            bMolotov.setEnabled(false);
            bKits.setEnabled(false);
        }
        if(intRSBalance < 350){
            bHelmet.setEnabled(false);
        }
        if(intRSBalance < 300){
            bDualBerettas.setEnabled(false);
            bP250.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
        }
        if(intRSBalance < 200){
            bGlock18.setEnabled(false);
            bZeusx27.setEnabled(false);
            bFlashbang.setEnabled(false);
            bP2000.setEnabled(false);
            bUSPS.setEnabled(false);
        }
        if(intRSBalance < 50){
            bDecoy.setEnabled(false);
        }

        if(sqlStringMolotovBuyCondition.equals("True")){ 
            bMolotov.setEnabled(false);
        }
        if(sqlStringDecoyBuyCondition.equals("True")){
            bDecoy.setEnabled(false);
        }
        if(sqlStringFlashBuyCondition.equals("True")){
            bFlashbang.setEnabled(false);
        }
        if(sqlStringSmokeBuyCondition.equals("True")){
            bSmoke.setEnabled(false);
        }
        if(sqlStringHEBuyCondition.equals("True")){
            bHEGrenade.setEnabled(false);
        }
        if(sqlStringIncendiaryBuyCondition.equals("True")){
            bIncendiary.setEnabled(false);
        }
        if(sqlStringLimitGrenadeCondition.equals("True")){
            bMolotov.setEnabled(false);
            bDecoy.setEnabled(false);
            bFlashbang.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);
            bHEGrenade.setEnabled(false);
        }

        if(ArmorPistolsSQL != null){ //finish later
            if(ArmorPistolsSQL.equals("Kevlar Vest")){
                bKevlarVest.setEnabled(false);
                bKevlarVestHelmet.setEnabled(false);
                if(intRSBalance > 350){
                    bHelmet.setEnabled(true); 
                }else{
                    bHelmet.setEnabled(false);
                }
            }
            if(ArmorPistolsSQL.equals("Kevlar Vest + Helmet")){
                bKevlarVest.setEnabled(false);
                bKevlarVestHelmet.setEnabled(false);
                bHelmet.setEnabled(false); 
            }
            if(ArmorPistolsSQL.equals(null)){
                bHelmet.setEnabled(false);
            }
        }

        if(ZeusPistolsSQL != null){ //ALLIAS02 DONE FOR KITS
            if(ZeusPistolsSQL.equals("Zeus")){
                bZeusx27.setEnabled(false);
            }
        }
        if(kitsStringPistolsSQL != null){ //ALLIAS02 DONE FOR KITS
            if(kitsStringPistolsSQL.equals("Kits")){
                bKits.setEnabled(false);
            }
        }
        if(Weapon1PistolsSQL != null){ //doNE for CT
            if(Weapon1PistolsSQL.equals("Glock-18")){
                bGlock18.setEnabled(false);
            }
            if(Weapon1PistolsSQL.equals("Dual Berettas")){
                bDualBerettas.setEnabled(false);
            }
            if(Weapon1PistolsSQL.equals("P250")){
                bP250.setEnabled(false);
            }
            if(Weapon1PistolsSQL.equals("CZ75-Auto")){
                bCZ75Auto.setEnabled(false);
            }
            if(Weapon1PistolsSQL.equals("Desert Eagle")){
                bDesertEagle.setEnabled(false);
            }
            if(Weapon1PistolsSQL.equals("R8 Revolver")){
                bR8Revolver.setEnabled(false);
            }
            if(Weapon1PistolsSQL.equals("Tec-9")){
                bTec9.setEnabled(false);
            }
            if(Weapon1PistolsSQL.equals("Five-SeveN")){
                bFiveSeven.setEnabled(false);
            }
            if(Weapon1PistolsSQL.equals("USP-S")){
                bUSPS.setEnabled(false);
            }
            if(Weapon1PistolsSQL.equals("P2000")){
                bP2000.setEnabled(false);
            }
        }
        if(Weapon2PistolsSQL != null){ 
            if(Weapon2PistolsSQL.equals("MAC-10")){
                bMAC10.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("MP5-SD")){
                bMP5SD.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("MP7")){
                bMP7.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("UMP-45")){
                bUMP45.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("P90")){
                bP90.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("PP-Bizon")){
                bPPBizon.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("Galil AR")){
                bGalilAR.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("AK-47")){
                bAK47.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("SSG 08")){
                bSSG08.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("SG 553")){
                bSG553.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("AWP")){
                bAWP.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("G3SG1")){
                bG3SG1.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("Nova")){
                bNova.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("XM1014")){
                bXM1014.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("Sawed-Off")){
                bSawedOff.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("M249")){
                bM249.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("Negev")){
                bNegev.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("MP9")){
                bMP9.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("M4A4")){
                bM4A4.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("M4A1-S")){
                bM4A1S.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("AUG")){
                bAUG.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("FAMAS")){
                bFAMAS.setEnabled(false);
            }
            if(Weapon2PistolsSQL.equals("SCAR-20")){
                bSCAR20.setEnabled(false);
            }
        }
    }

    public void actions(Object source,String command){
        //DONE ???
        if(source == bMAC10){ //done
            intRSBalance = intRSBalance - 1050; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "MAC-10";
            bMAC10.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
        }
        if(source == bMP5SD){ //The user decides to buy MP5-SD
            intRSBalance = intRSBalance - 1500; //Makes a calculation: (Balance - the price of the weapon (here: MP5-SD = 1500)) = remaining balance
            tBalance.setText(intRSBalance + "$"); //updates the balance textfield in order to show the player's current balance after the purchase
            Weapon2PistolsSQL = "MP5-SD"; //sets the player's weapon equal to MP5-SD. When quitting the menu, updating it in MySQL
            bMP5SD.setEnabled(false); //disables the button of the weapon (MP5-SD), as it was already purchased 
            if(intRSBalance >= 5200){ //allows the purchase of the weapon, if there is enough balance left
                bM249.setEnabled(true);
            }
            if(sqlStringSide.equals("TSide")){ //allows the purchase of the weapon, if there is enough balance left. Only for T-Side exclusive weapons
            if(intRSBalance >= 5000){ //allows the purchase of the weapon, if there is enough balance left
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){ //allows the purchase of the weapon, if there is enough balance left
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){ //allows the purchase of the weapon, if there is enough balance left
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){ //allows the purchase of the weapon, if there is enough balance left
                bMAC10.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){ //allows the purchase of the weapon, if there is enough balance left. Only for CT-Side exclusive weapons
                if(intRSBalance >= 5000){ //allows the purchase of the weapon, if there is enough balance left
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){ //allows the purchase of the weapon, if there is enough balance left
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){ //allows the purchase of the weapon, if there is enough balance left
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){ //allows the purchase of the weapon, if there is enough balance left
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){ //allows the purchase of the weapon, if there is enough balance left
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){ //allows the purchase of the weapon, if there is enough balance left
            bMP9.setEnabled(true);
            }
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
        }
        if(source == bMP7){ //done
            intRSBalance = intRSBalance - 1500; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "MP7";
            bMP7.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
                 if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){
                if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
        }
        if(source == bUMP45){ //done
            intRSBalance = intRSBalance - 1200; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "UMP-45";
            bUMP45.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
                 if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){
                if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            
            
        }
        if(source == bP90){ //done
            intRSBalance = intRSBalance - 2350; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "P90";
            bP90.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
                 if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){
                if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
        }
        if(source == bPPBizon){ //done
            intRSBalance = intRSBalance - 1400; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "PP-Bizon";
            bPPBizon.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
                 if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){
                if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
        }

        //Rifles

        if(source == bGalilAR){ //done
            intRSBalance = intRSBalance - 1800; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "Galil AR";
            bGalilAR.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            
            
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
        }
        if(source == bAK47){ //done
            intRSBalance = intRSBalance - 2700; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "AK-47";
            bAK47.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
                bNova.setEnabled(true);
            }
        }
        if(source == bSSG08){ //done
            intRSBalance = intRSBalance - 1700; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "SSG 08";
            bSSG08.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
                 if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){
                if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
        }
        if(source == bSG553){ //done
            intRSBalance = intRSBalance - 3000; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "SG 553";
            bSG553.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
                bNova.setEnabled(true);
            }
        }
        if(source == bAWP){
            intRSBalance = intRSBalance - 4750; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "AWP";
            bAWP.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
                 if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){
                if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
        }
        if(source == bG3SG1){ //done
            intRSBalance = intRSBalance - 5000; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "G3SG1";
            bG3SG1.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
                bNova.setEnabled(true);
            }
        }

        //Heavy

        if(source == bNova){ //done
            intRSBalance = intRSBalance - 1050; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "Nova";
            bNova.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
                 if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){
                if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
        }
        if(source == bXM1014){ //done
            intRSBalance = intRSBalance - 2000; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "XM1014";
            bXM1014.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
                 if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){
                if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            

            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
        }
        if(source == bSawedOff){ //done
            intRSBalance = intRSBalance - 1100; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "Sawed-Off";
            bXM1014.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
                 if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){
                if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
        }
        if(source == bM249){ //done
            intRSBalance = intRSBalance - 5200; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "M249";
            bM249.setEnabled(false);
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
                 if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){
                if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
        }
        if(source == bNegev){ //done
            intRSBalance = intRSBalance - 1700; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "Negev";
            bNegev.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
             if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
                 if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 5000){
                bG3SG1.setEnabled(true);
            }
            if(intRSBalance >= 2700){
                bAK47.setEnabled(true);
            }
            if(intRSBalance >= 1800){
                bGalilAR.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bMAC10.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringTmp5SDorMP7.equals("TMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(sqlStringSide.equals("CTSide")){
                if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 3000){
                bSG553.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
        }
        
        //WEAPONS FOR CT
        
        if(source == bMP9){ //DONE
            intRSBalance = intRSBalance - 1250; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "MP9";
            bMP9.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
        }
        if(source == bAUG){ //DONE
            intRSBalance = intRSBalance - 3300; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "AUG";
            bAUG.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            
                if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
        }
        if(source == bM4A4){ //DONE
            intRSBalance = intRSBalance - 3100; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "M4A4";
            bM4A4.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
        }
        if(source == bM4A1S){ //DONE
            intRSBalance = intRSBalance - 2900; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "M4A1-S";
            bM4A1S.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
        }
        if(source == bFAMAS){ //DONE
            intRSBalance = intRSBalance - 2050; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "FAMAS";
            bFAMAS.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            if(intRSBalance >= 5000){
            bSCAR20.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
        }
        if(source == bSCAR20){ //DONE
            intRSBalance = intRSBalance - 5000; 
            tBalance.setText(intRSBalance + "$");
            Weapon2PistolsSQL = "SCAR-20";
            bSCAR20.setEnabled(false);
            if(intRSBalance >= 5200){
                bM249.setEnabled(true);
            }
            if(intRSBalance >= 4750){
                bAWP.setEnabled(true);
            }
            if(intRSBalance >= 2350){
                bP90.setEnabled(true);
            }
            if(intRSBalance >= 2000){
                bXM1014.setEnabled(true);
            }
            if(intRSBalance >= 1700){
                bSSG08.setEnabled(true);
                bNegev.setEnabled(true);
            }
            if(intRSBalance >= 1400){
                bPPBizon.setEnabled(true);
            }
            if(intRSBalance >= 1200){
                bUMP45.setEnabled(true);
            }
            if(intRSBalance >= 1100){
                bSawedOff.setEnabled(true);
            }
            if(intRSBalance >= 1050){
                bNova.setEnabled(true);
            }
            if(intRSBalance >= 3300){
            bAUG.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP5SD")){
                bMP5SD.setEnabled(true);
            }
            if(intRSBalance >= 1500 && sqlStringCTmp5SDorMP7.equals("CTMP7")){ 
                bMP7.setEnabled(true);
            }
            if(intRSBalance >= 1250){
            bMP9.setEnabled(true);
            }
            if(intRSBalance >= 3100){
            bM4A4.setEnabled(true);
            }
            if(intRSBalance >= 2050){
            bFAMAS.setEnabled(true);
            }
            if(intRSBalance >= 2900){
            bM4A1S.setEnabled(true);
            }
        }

        //Grenades

        if(source == bMolotov){
            intRSBalance = intRSBalance - 400;
            tBalance.setText(intRSBalance + "$");
            if(Grenade1PistolsSQL == null){
                Grenade1PistolsSQL = "Molotov"; 
            }else if(Grenade2PistolsSQL == null){
                Grenade2PistolsSQL = "Molotov";
            }else if(Grenade3PistolsSQL == null){
                Grenade3PistolsSQL = "Molotov";
            }else if(Grenade4PistolsSQL == null){
                Grenade4PistolsSQL = "Molotov";
            }
            bMolotov.setEnabled(false);
            grenadeCountPistols = grenadeCountPistols + 1;
            sqlStringMolotovBuyCondition = "True";
            if(grenadeCountPistols == 4){
                bDecoy.setEnabled(false);
                bFlashbang.setEnabled(false);
                bHEGrenade.setEnabled(false);
                bSmoke.setEnabled(false);
                sqlStringLimitGrenadeCondition = "True";
            }
        }
        if(source == bIncendiary){
            intRSBalance = intRSBalance - 600;
            tBalance.setText(intRSBalance + "$");
            if(Grenade1PistolsSQL == null){
                Grenade1PistolsSQL = "Incendiary"; 
            }else if(Grenade2PistolsSQL == null){
                Grenade2PistolsSQL = "Incendiary";
            }else if(Grenade3PistolsSQL == null){
                Grenade3PistolsSQL = "Incendiary";
            }else if(Grenade4PistolsSQL == null){
                Grenade4PistolsSQL = "Incendiary";
            }
            bIncendiary.setEnabled(false);
            grenadeCountPistols = grenadeCountPistols + 1;
            sqlStringIncendiaryBuyCondition = "True";
            if(grenadeCountPistols == 4){
                bDecoy.setEnabled(false);
                bFlashbang.setEnabled(false);
                bHEGrenade.setEnabled(false);
                bSmoke.setEnabled(false);
                sqlStringLimitGrenadeCondition = "True";
            }
        }
        if(source == bDecoy){
            intRSBalance = intRSBalance - 50;
            tBalance.setText(intRSBalance + "$");
            if(Grenade1PistolsSQL == null){
                Grenade1PistolsSQL = "Decoy"; 
            }else if(Grenade2PistolsSQL == null){
                Grenade2PistolsSQL = "Decoy";
            }else if(Grenade3PistolsSQL == null){
                Grenade3PistolsSQL = "Decoy";
            }else if(Grenade4PistolsSQL == null){
                Grenade4PistolsSQL = "Decoy";
            }
            bDecoy.setEnabled(false);
            grenadeCountPistols = grenadeCountPistols + 1;
            sqlStringDecoyBuyCondition = "True";
            if(grenadeCountPistols == 4){
                bMolotov.setEnabled(false);
                bFlashbang.setEnabled(false);
                bHEGrenade.setEnabled(false);
                bSmoke.setEnabled(false);
                bIncendiary.setEnabled(false);
                sqlStringLimitGrenadeCondition = "True";
            }
        }
        if(source == bFlashbang){
            intRSBalance = intRSBalance - 200;
            tBalance.setText(intRSBalance + "$");
            if(Grenade1PistolsSQL == null){
                Grenade1PistolsSQL = "Flashbang"; 
            }else if(Grenade2PistolsSQL == null){
                Grenade2PistolsSQL = "Flashbang";
            }else if(Grenade3PistolsSQL == null){
                Grenade3PistolsSQL = "Flashbang";
            }else if(Grenade4PistolsSQL == null){
                Grenade4PistolsSQL = "Flashbang";
            }
            grenadeCountPistols = grenadeCountPistols + 1;
            flashbangCountPistols = flashbangCountPistols + 1;
            if(flashbangCountPistols == 2){
                bFlashbang.setEnabled(false);
                sqlStringFlashBuyCondition = "True";
            }
            if(grenadeCountPistols == 4){
                bMolotov.setEnabled(false);
                bFlashbang.setEnabled(false);
                bHEGrenade.setEnabled(false);
                bSmoke.setEnabled(false);
                bDecoy.setEnabled(false);
                bIncendiary.setEnabled(false);
                sqlStringLimitGrenadeCondition = "True";
            }
        }
        if(source == bHEGrenade){
            intRSBalance = intRSBalance - 300;
            tBalance.setText(intRSBalance + "$");
            if(Grenade1PistolsSQL == null){
                Grenade1PistolsSQL = "HE Grenade"; 
            }else if(Grenade2PistolsSQL == null){
                Grenade2PistolsSQL = "HE Grenade";
            }else if(Grenade3PistolsSQL == null){
                Grenade3PistolsSQL = "HE Grenade";
            }else if(Grenade4PistolsSQL == null){
                Grenade4PistolsSQL = "HE Grenade";
            }
            bHEGrenade.setEnabled(false);
            grenadeCountPistols = grenadeCountPistols + 1;
            sqlStringHEBuyCondition = "True";
            if(grenadeCountPistols == 4){
                bMolotov.setEnabled(false);
                bFlashbang.setEnabled(false);
                bSmoke.setEnabled(false);
                bDecoy.setEnabled(false);
                bIncendiary.setEnabled(false);
                sqlStringLimitGrenadeCondition = "True";
            }
        }
        if(source == bSmoke){
            intRSBalance = intRSBalance - 300;
            tBalance.setText(intRSBalance + "$");
            if(Grenade1PistolsSQL == null){
                Grenade1PistolsSQL = "Smoke"; 
            }else if(Grenade2PistolsSQL == null){
                Grenade2PistolsSQL = "Smoke";
            }else if(Grenade3PistolsSQL == null){
                Grenade3PistolsSQL = "Smoke";
            }else if(Grenade4PistolsSQL == null){
                Grenade4PistolsSQL = "Smoke";
            }
            bSmoke.setEnabled(false);
            grenadeCountPistols = grenadeCountPistols + 1;
            sqlStringSmokeBuyCondition = "True";
            if(grenadeCountPistols == 4){
                bMolotov.setEnabled(false);
                bFlashbang.setEnabled(false);
                bHEGrenade.setEnabled(false);
                bDecoy.setEnabled(false);
                bIncendiary.setEnabled(false);
                sqlStringLimitGrenadeCondition = "True";
            }
        }

        //Pistols

        if(source == bDualBerettas){ //done
            intRSBalance = intRSBalance - 300;
            tBalance.setText(intRSBalance + "$");
            Weapon1PistolsSQL = "Dual Berettas";
            bDualBerettas.setEnabled(false);
            if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 200){
                bGlock18.setEnabled(true);
            }
            if(sqlStringTDeagleORr8.equals("TDeagle") && intRSBalance >= 700 ){
                bDesertEagle.setEnabled(true);
            }
            if(sqlStringTCZ75orTec9.equals("TCZ75") && intRSBalance >= 500){
                bCZ75Auto.setEnabled(true);
            }
            if(sqlStringTCZ75orTec9.equals("TTec9") && intRSBalance >= 500){
                bTec9.setEnabled(true);
            }
            if(sqlStringTDeagleORr8.equals("TR8") && intRSBalance >= 600){
                bR8Revolver.setEnabled(true);
            }
        }
        if(sqlStringSide.equals("CTSide")){
            if(sqlStringCTuspsORp2000.equals("CTUSPS") && intRSBalance >= 200){
                bUSPS.setEnabled(true);
            }
            if(sqlStringCTuspsORp2000.equals("CTP2000") && intRSBalance >= 200){
                bP2000.setEnabled(true);
            }
             if(sqlStringCTDeagleORr8.equals("CTDeagle") && intRSBalance >= 700 ){
                bDesertEagle.setEnabled(true);
            }
            if(sqlStringCTDeagleORr8.equals("CTR8") && intRSBalance >= 600){
                bR8Revolver.setEnabled(true);
            }
            if(sqlStringsqlCTCZ75or57.equals("CTCZ75") && intRSBalance >= 500){
                bCZ75Auto.setEnabled(true);
            }
            if(sqlStringsqlCTCZ75or57.equals("CT57") && intRSBalance >= 500){
                bFiveSeven.setEnabled(true);

            }
        }
        if(intRSBalance >= 300){
                bP250.setEnabled(true);
            }
        }
            
    

        if (source == bGlock18){ //done
            intRSBalance = intRSBalance - 200;
            tBalance.setText(intRSBalance + "$");
            Weapon1PistolsSQL = "Glock-18";
            bGlock18.setEnabled(false);
            if(intRSBalance >= 300){
                bP250.setEnabled(true);
                bDualBerettas.setEnabled(true);
            }
            if(sqlStringTDeagleORr8.equals("TDeagle") && intRSBalance >= 700 ){
                bDesertEagle.setEnabled(true);
            }
            if(sqlStringTCZ75orTec9.equals("TCZ75") == true && intRSBalance >= 500){
                bCZ75Auto.setEnabled(true);
            }
            if(sqlStringTCZ75orTec9.equals("TTec9") == true && intRSBalance >= 500){
                bTec9.setEnabled(true);
            }
            if(sqlStringTDeagleORr8.equals("TR8") && intRSBalance >= 600){
                bR8Revolver.setEnabled(true);
            }
        }

        if(source == bP250){ //done
            intRSBalance = intRSBalance - 300;
            tBalance.setText(intRSBalance + "$");
            Weapon1PistolsSQL = "P250";
            bP250.setEnabled(false);
            if(intRSBalance >= 300){
                bDualBerettas.setEnabled(true);
            }
            if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 200){
                bGlock18.setEnabled(true);
            }
            if(sqlStringTCZ75orTec9.equals("TCZ75") && intRSBalance >= 500){
                bCZ75Auto.setEnabled(true);
            }
            if(sqlStringTCZ75orTec9.equals("TTec9") && intRSBalance >= 500){
                bTec9.setEnabled(true);
            }
            if(sqlStringTDeagleORr8.equals("TDeagle") && intRSBalance >= 700 ){
                bDesertEagle.setEnabled(true);
            }
            if(sqlStringTDeagleORr8.equals("TR8") && intRSBalance >= 600){
                bR8Revolver.setEnabled(true);
            }
        }
        if(sqlStringSide.equals("CTSide")){
            if(sqlStringCTuspsORp2000.equals("CTUSPS") && intRSBalance >= 200){
                bUSPS.setEnabled(true);
            }
            if(sqlStringCTuspsORp2000.equals("CTP2000") && intRSBalance >= 200){
                bP2000.setEnabled(true);
            }
             if(sqlStringCTDeagleORr8.equals("CTDeagle") && intRSBalance >= 700 ){
                bDesertEagle.setEnabled(true);
            }
            if(sqlStringCTDeagleORr8.equals("CTR8") && intRSBalance >= 600){
                bR8Revolver.setEnabled(true);
            }
            if(sqlStringsqlCTCZ75or57.equals("CTCZ75") && intRSBalance >= 500){
                bCZ75Auto.setEnabled(true);
            }
            if(sqlStringsqlCTCZ75or57.equals("CT57") && intRSBalance >= 500){
                bFiveSeven.setEnabled(true);
            }
        }
    }

        if(source == bCZ75Auto){ //done
            intRSBalance = intRSBalance - 500;
            tBalance.setText(intRSBalance + "$");
            Weapon1PistolsSQL = "CZ75-Auto";
            bCZ75Auto.setEnabled(false);
            if(intRSBalance >= 300){
                bP250.setEnabled(true);
                bDualBerettas.setEnabled(true);
            }
            
            if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 200){
                bGlock18.setEnabled(true);
            }
            if(sqlStringTDeagleORr8.equals("TDeagle") && intRSBalance >= 700 ){
                bDesertEagle.setEnabled(true);
            }
            if(sqlStringTDeagleORr8.equals("TR8") && intRSBalance >= 600){
                bR8Revolver.setEnabled(true);
            }
            }
            
              if(sqlStringSide.equals("CTSide")){
            if(sqlStringCTuspsORp2000.equals("CTUSPS") && intRSBalance >= 200){
                bUSPS.setEnabled(true);
            }
            if(sqlStringCTuspsORp2000.equals("CTP2000") && intRSBalance >= 200){
                bP2000.setEnabled(true);
            }
             if(sqlStringCTDeagleORr8.equals("CTDeagle") && intRSBalance >= 700 ){
                bDesertEagle.setEnabled(true);
            }
            if(sqlStringCTDeagleORr8.equals("CTR8") && intRSBalance >= 600){
                bR8Revolver.setEnabled(true);
            }
        }

        }

        if(source == bDesertEagle){ //done
            intRSBalance = intRSBalance - 700;
            tBalance.setText(intRSBalance + "$");
            Weapon1PistolsSQL = "Desert Eagle";
            bDesertEagle.setEnabled(false);
            
            if(intRSBalance >= 300){
                bP250.setEnabled(true);
                bDualBerettas.setEnabled(true);
            }
            if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 200){
                bGlock18.setEnabled(true);
            }
            if(sqlStringTCZ75orTec9.equals("TCZ75") && intRSBalance >= 500){
                bCZ75Auto.setEnabled(true);
            }
            if(sqlStringTCZ75orTec9.equals("TTec9") && intRSBalance >= 500){
                bTec9.setEnabled(true);
            }
        }
        if(sqlStringSide.equals("CTSide")){
            if(sqlStringCTuspsORp2000.equals("CTUSPS") && intRSBalance >= 200){
                bUSPS.setEnabled(true);
            }
            if(sqlStringCTuspsORp2000.equals("CTP2000") && intRSBalance >= 200){
                bP2000.setEnabled(true);
            }
            if(sqlStringsqlCTCZ75or57.equals("CTCZ75") && intRSBalance >= 500){
                bCZ75Auto.setEnabled(true);
            }
            if(sqlStringsqlCTCZ75or57.equals("CT57") && intRSBalance >= 500){
                bFiveSeven.setEnabled(true);
            }
        }
        }

        if(source == bR8Revolver){ //done
            intRSBalance = intRSBalance - 600;
            tBalance.setText(intRSBalance + "$");
            Weapon1PistolsSQL = "R8 Revolver";
            bR8Revolver.setEnabled(false);
            if(intRSBalance >= 300){
                bDualBerettas.setEnabled(true);
                bP250.setEnabled(true);
            }
            if(sqlStringSide.equals("TSide")){
            if(intRSBalance >= 200){
                bGlock18.setEnabled(true);
            }
            if(sqlStringTCZ75orTec9.equals("TCZ75") && intRSBalance >= 500){
                bCZ75Auto.setEnabled(true);
            }
            if(sqlStringTCZ75orTec9.equals("TTec9") && intRSBalance >= 500){
                bTec9.setEnabled(true);
            }
        }
        if(sqlStringSide.equals("CTSide")){
            if(intRSBalance >= 200){
                bUSPS.setEnabled(true);
            }
            if(sqlStringsqlCTCZ75or57.equals("CTCZ75") && intRSBalance >= 500){
                bCZ75Auto.setEnabled(true);
            }
            if(sqlStringsqlCTCZ75or57.equals("CT57") && intRSBalance >= 500){
                bFiveSeven.setEnabled(true);
            }
        }

        }

        if(source == bTec9){ //done
            intRSBalance = intRSBalance - 500;
            tBalance.setText(intRSBalance + "$");
            Weapon1PistolsSQL = "Tec-9";
            bTec9.setEnabled(false);
            if(intRSBalance >= 300){
                bDualBerettas.setEnabled(true);
                bP250.setEnabled(true);
            }
            
            if(intRSBalance >= 200){
                bGlock18.setEnabled(true);
            }
            if(sqlStringTDeagleORr8.equals("TDeagle") && intRSBalance >= 700 ){
                bDesertEagle.setEnabled(true);
            }
            if(sqlStringTDeagleORr8.equals("TR8") && intRSBalance >= 600){
                bR8Revolver.setEnabled(true);
            }


        }
        
        if(source == bFiveSeven){ //done
            intRSBalance = intRSBalance - 500;
            tBalance.setText(intRSBalance + "$");
            Weapon1PistolsSQL = "Five-SeveN";
            bFiveSeven.setEnabled(false);
            if(intRSBalance >= 300){
                bP250.setEnabled(true);
                bDualBerettas.setEnabled(true);
            }
            
            
            if(sqlStringCTuspsORp2000.equals("CTUSPS") && intRSBalance >= 200){
                bUSPS.setEnabled(true);
            }
            if(sqlStringCTuspsORp2000.equals("CTP2000") && intRSBalance >= 200){
                bP2000.setEnabled(true);
            }
             if(sqlStringCTDeagleORr8.equals("CTDeagle") && intRSBalance >= 700 ){
                bDesertEagle.setEnabled(true);
            }
            if(sqlStringCTDeagleORr8.equals("CTR8") && intRSBalance >= 600){
                bR8Revolver.setEnabled(true);
            }
        

        }
        
        if(source == bUSPS){ //DONE
            intRSBalance = intRSBalance - 200;
            tBalance.setText(intRSBalance + "$");
            Weapon1PistolsSQL = "USP-S";
            bUSPS.setEnabled(false);
            if(intRSBalance >= 300){
                bP250.setEnabled(true);
                bDualBerettas.setEnabled(true);
            }
            
            if(sqlStringsqlCTCZ75or57.equals("CTCZ75") && intRSBalance >= 500){
                bCZ75Auto.setEnabled(true);
            }
            if(sqlStringsqlCTCZ75or57.equals("CT57") && intRSBalance >= 500){
                bFiveSeven.setEnabled(true);
            }
            
             if(sqlStringCTDeagleORr8.equals("CTDeagle") && intRSBalance >= 700 ){
                bDesertEagle.setEnabled(true);
            }
            if(sqlStringCTDeagleORr8.equals("CTR8") && intRSBalance >= 600){
                bR8Revolver.setEnabled(true);
            }
        

        }
        
        if(source == bP2000){ //DONE
            intRSBalance = intRSBalance - 200;
            tBalance.setText(intRSBalance + "$");
            Weapon1PistolsSQL = "P2000";
            bP2000.setEnabled(false);
            if(intRSBalance >= 300){
                bP250.setEnabled(true);
                bDualBerettas.setEnabled(true);
            }
            
            if(sqlStringsqlCTCZ75or57.equals("CTCZ75") && intRSBalance >= 500){
                bCZ75Auto.setEnabled(true);
            }
            if(sqlStringsqlCTCZ75or57.equals("CT57") && intRSBalance >= 500){
                bFiveSeven.setEnabled(true);
            }
            
             if(sqlStringCTDeagleORr8.equals("CTDeagle") && intRSBalance >= 700 ){
                bDesertEagle.setEnabled(true);
            }
            if(sqlStringCTDeagleORr8.equals("CTR8") && intRSBalance >= 600){
                bR8Revolver.setEnabled(true);
            }
        

        }

        //Equipment

        if(source == bKevlarVest){
            intRSBalance = intRSBalance - 650;
            tBalance.setText(intRSBalance + "$");
            ArmorPistolsSQL = "Kevlar Vest";
            bKevlarVest.setEnabled(false);
            bKevlarVestHelmet.setEnabled(false);
            playerHasFullArmor = true;
            bHelmet.setEnabled(true);
        }
        if(source == bKevlarVestHelmet){
            intRSBalance = intRSBalance - 1000;
            tBalance.setText(intRSBalance + "$");
            ArmorPistolsSQL = "Kevlar Vest + Helmet";
            playerHasFullArmorAndHelmet = true;
            bKevlarVestHelmet.setEnabled(false);
            bKevlarVest.setEnabled(false);
            bHelmet.setEnabled(false);
        }
        if(source == bHelmet){
            intRSBalance = intRSBalance - 350;
            tBalance.setText(intRSBalance + "$");
            ArmorPistolsSQL = "Kevlar Vest + Helmet";
            bHelmet.setEnabled(false);
        }
        if(source == bZeusx27){
            intRSBalance = intRSBalance - 200;
            tBalance.setText(intRSBalance + "$");
            ZeusPistolsSQL = "Zeus";
            bZeusx27.setEnabled(false);
        }
        if(source == bKits){
            intRSBalance = intRSBalance - 400;
            tBalance.setText(intRSBalance + "$");
            kitsStringPistolsSQL = "Kits";
            bKits.setEnabled(false);
        }
        if (source == bQuitPistolsMenu){
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
                int balanceUpdate = stmt1.executeUpdate("UPDATE `CSGOSchema`.`IACompCSGO` SET Balance = "+intRSBalance+" WHERE idNumCS = 1;");

                String query = "UPDATE `CSGOSchema`.`IACompCSGO` SET Weapon1 = ?, Weapon2 = ?, Armor = ?, Grenade1 = ?, Grenade2 = ?, Grenade3 =?, Grenade4 =?, Zeus = ?, MainGameCondition = ?, PistolsCondition = ?, MolotovBuyCondition = ?, DecoyBuyCondition = ?, FlashBuyCondition = ?, SmokeBuyCondition = ?, HEBuyCondition = ?, LimitGrenadeCondition = ?, PistolNullCondition = ?, kits = ?  WHERE idNumCS = 1;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, Weapon1PistolsSQL);
                preparedStatement.setString(2, Weapon2PistolsSQL);
                preparedStatement.setString(3, ArmorPistolsSQL);
                preparedStatement.setString(4, Grenade1PistolsSQL);
                preparedStatement.setString(5, Grenade2PistolsSQL);
                preparedStatement.setString(6, Grenade3PistolsSQL);
                preparedStatement.setString(7, Grenade4PistolsSQL);
                preparedStatement.setString(8, ZeusPistolsSQL);
                preparedStatement.setString(9, "Game");
                preparedStatement.setString(10, "True"); 
                preparedStatement.setString(11, sqlStringMolotovBuyCondition);
                preparedStatement.setString(12, sqlStringDecoyBuyCondition);
                preparedStatement.setString(13, sqlStringFlashBuyCondition);
                preparedStatement.setString(14, sqlStringSmokeBuyCondition);
                preparedStatement.setString(15, sqlStringHEBuyCondition);
                preparedStatement.setString(16, sqlStringLimitGrenadeCondition); 
                preparedStatement.setString(17, "True");
                preparedStatement.setString(18, kitsStringPistolsSQL);

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

            new BuyMenu();
            dispose();
        }
        //Balance Condition for the buttons [done]
        tWeapon1.setText(Weapon1PistolsSQL + ""); //updates the text field, with currently purchased weapon
        tWeapon2.setText(Weapon2PistolsSQL + ""); //updates the text field, with currently purchased weapon
        tZeus.setText(ZeusPistolsSQL + ""); //updates the text field, with currently purchased weapon
        tGrenade1.setText(Grenade1PistolsSQL + ""); //updates the text field, with currently purchased weapon
        tGrenade2.setText(Grenade2PistolsSQL + ""); //updates the text field, with currently purchased weapon
        tGrenade3.setText(Grenade3PistolsSQL + ""); //updates the text field, with currently purchased weapon
        tGrenade4.setText(Grenade4PistolsSQL + ""); //updates the text field, with currently purchased weapon
        tKits.setText(kitsStringPistolsSQL + ""); //updates the text field, with currently purchased weapon
        tArmor.setText(ArmorPistolsSQL + ""); //updates the text field, with currently purchased weapon
        if(intRSBalance < 5200){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bM249.setEnabled(false);
        }
        if(intRSBalance < 5000){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bG3SG1.setEnabled(false);
            bSCAR20.setEnabled(false);
        }
        if(intRSBalance < 4750){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bAWP.setEnabled(false);
        }
        if(intRSBalance < 3300){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bAUG.setEnabled(false);
        }
        if(intRSBalance < 3100){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bM4A4.setEnabled(false);
        }
        if(intRSBalance < 3000){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bSG553.setEnabled(false);
        }
        if(intRSBalance < 2900){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bM4A1S.setEnabled(false);
        }
        if(intRSBalance < 2700){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bAK47.setEnabled(false);
        }
        if(intRSBalance < 2350){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bP90.setEnabled(false);
        }
        if(intRSBalance < 2050){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bFAMAS.setEnabled(false);
        }
        if(intRSBalance < 2000){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bXM1014.setEnabled(false);
        }
        if(intRSBalance < 1800){ //disables the opportunity to buy a weapon, if there is not enough balance 
            bGalilAR.setEnabled(false);
        }
        if(intRSBalance < 1700){
            bSSG08.setEnabled(false);
            bNegev.setEnabled(false);
        }
        if(intRSBalance < 1500){
            bMP5SD.setEnabled(false);
            bMP7.setEnabled(false);
        }
        if(intRSBalance < 1400){
            bPPBizon.setEnabled(false);
        }
        if(intRSBalance < 1250){
            bMP9.setEnabled(false);
        }
        if(intRSBalance < 1200){
            bUMP45.setEnabled(false);
        }
        if(intRSBalance < 1100){
            bSawedOff.setEnabled(false);
        }
        if(intRSBalance < 1050){
            bMAC10.setEnabled(false);
            bNova.setEnabled(false);
        }
        if(intRSBalance < 1000){
            bKevlarVestHelmet.setEnabled(false);
        }
        if(intRSBalance < 700){
            bDesertEagle.setEnabled(false);
        }
        if(intRSBalance < 650){
            bKevlarVest.setEnabled(false);
        }
        if(intRSBalance < 600){
            bR8Revolver.setEnabled(false);
            bSmoke.setEnabled(false);
            bIncendiary.setEnabled(false);
        }
        if(intRSBalance < 500){
            bCZ75Auto.setEnabled(false);
            bTec9.setEnabled(false);
            bFiveSeven.setEnabled(false);
        }
        if(intRSBalance < 400){
            bMolotov.setEnabled(false);
            bKits.setEnabled(false);
        }
        if(intRSBalance < 350){
            bHelmet.setEnabled(false);
        }
        if(intRSBalance < 300){
            bDualBerettas.setEnabled(false);
            bP250.setEnabled(false);
            bHEGrenade.setEnabled(false);
            bSmoke.setEnabled(false);
        }
        if(intRSBalance < 200){
            bGlock18.setEnabled(false);
            bZeusx27.setEnabled(false);
            bFlashbang.setEnabled(false);
            bP2000.setEnabled(false);
            bUSPS.setEnabled(false);
        }
        if(intRSBalance < 50){
            bDecoy.setEnabled(false);
        }
    }
}
