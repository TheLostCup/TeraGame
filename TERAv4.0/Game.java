import java.util.*;
public class Game{
    static Scanner scan = new Scanner(System.in);
    static SkyCruiserMap schm = new SkyCruiserMap();
    static BathysmalRiseMap brhm = new BathysmalRiseMap();
    static MP3 mapmusic = new MP3("Map.mp3");
    int map;
    public static void main(String[] args){
        System.out.println("\f");
        titleScreen();
        Character player = newCharacter();
        System.out.print("\f");
        System.out.println(player.toString());
        System.out.println("Pick a map to play: \n1.Sky Cruiser Endeavor \n2.Bathysmal Rise");
        int map = scan.nextInt();
        String play = "yes";
        if(map == 1){
            NamedThing[][] map1 = schm.getLayout();
            mapmusic.play();
            while (((Darkan)map1[9][4]).getHealth() > 0 && player.getHealth() > 0){
                if (mapmusic.getPlayer() == null)
                    mapmusic.play();
                player = explore(player, map1);
            }
            endScreen();
        }
        else{
            NamedThing[][][] map2 = brhm.getLayout();
            mapmusic.play();
            while (((Fulminar)map2[9][4][0]).getHealth() > 0 && player.getHealth() > 0){
                if (mapmusic.getPlayer() == null)
                    mapmusic.play();
                player = explore(player, map2);
            }
        }
        endScreen();
    }

    public static void titleScreen(){
        MP3 title = new MP3("Godspeed.mp3");
        title.play();
        System.out.println("         ,.-~·-.,__,.-::^·- .,'                   ,.-:~:'*:~-.              .:'/*/'`:,·:~·:.,                          ,.-:~:-." +            
            "\n     /:::::::::::::::::::::::::/';          .·´::::::::::::::;           /::/:/:::/:::;::::::/`':.,'                   /':::::::::'`,          " +
            "\n   /;:· :;:::::::_ ;:  .,/::;i'         /:::;:-·~^*^~-:;:/           /·*'`·´Ż'`^·-~·:-'::;:::'`;                  /;:-·~·-:;':::',         "+
            "\n  /´          ŻŻ           ';::/        ,.-/:´     .,       ;/          '\\                      '`;::'             ,'´          '`:;::`,     "+  
            "\n,:                          ,:/        /::';      ,'::`:~.-:´;          '`;        , .,        'i:'/              /               `;::\\      "+
            "\n';_,..-.,_     _    _,.·´            /;:- ´        `'··;:'/' _          i       i':/:::';       ;/'            ,'                  '`,::;    "+
            "\n         ,·´'    '`·;'iŻ             /     ;:'`:.., __,.·'::/:::';         i       i/:·'´       ,:''            i'      ,';´'`;         '\\:: "+
            "\n         i         'i:i'             ;'      ';:::::::::::::::/;;::/       '; '    ,:,     ~;'´:::'`:,         ,'      ,;'/´:`';         ';::"+
            "\n         ';        ';:i'             Ĥ         '`·-·:;::·-·'´   ';:/      'i     i:/\\       `;::::/:'`;     ';        ;/:;::;:';         ',:::"+
            "\n          i        i:/'             '\\                         /'         ;     ;/    \\       '`:/::::/'    'i       '´        `'         'i::'"+
            "\n           ;      i/                 `·,                  ,·'  '          ';   ,'       \\         '`;/'     Ĥ       '/`' *^~-·'´`\\         ';'/'"+
            "\n            \\   '/'                       '`~·- . , . -·'´                 `'*´          '`~·-·^'´          '`., .·´              `·.,_,.·´  "+
            "\n              Ż                                                                                                                      ");
        System.out.println();
        System.out.println("                        (                                                                                                 " + 
            "\n                        )\\ )    )          (                                                (                              " +
            "\n                       (()/( ( /( (        )\\   (      (   (         (   (     (            )\\ )   (     )   )        (    "+
            "\n                        /(_)))\\()))\\ )   (((_)  )(    ))\\  )\\  (    ))\\  )(    )\\    (     (()/(  ))\\ ( /(  /((   (   )(   "+
            "\n                       (_)) ((_)\\(()/(   )\\___ (()\\  /((_)((_) )\\  /((_)(()\\  ((_)   )\\ )   ((_))/((_))(_))(_))\\  )\\ (()\\  "+
            "\n                       / __|| |(_))(_)) ((/ __| ((_)(_))(  (_)((_)(_))   ((_) | __| _(_/(   _| |(_)) ((_)_ _)((_)((_) ((_) "+
            "\n                       \\__ \\| / /| || |  | (__ | '_|| || | | |(_-</ -_) | '_| | _| | ' \\))/ _` |/ -_)/ _` |\\ V // _ \\| '_| "+
            "\n                       |___/|_\\_\\ \\_, |   \\___||_|   \\_,_| |_|/__/\\___| |_|   |___||_||_| \\__,_|\\___|\\__,_| \\_/ \\___/|_|   "+
            "\n                                  |__/                                                                                     ");
        System.out.println();
        System.out.println("Press any key to continue.");
        String cont = scan.next();
        System.out.print("\f");
        title.close();
    }

    public static Character newCharacter(){
        MP3 charcreation = new MP3("Charcre.mp3");
        charcreation.play();
        System.out.println("Welcome to TERA: Sky Cruiser Endeavor. You will soon embark on an adventure aboard a Skyship to oust the evil fire demon known as Darkan!\n");
        System.out.print("First, you need to pick a class to play. Your options are as follows:" + "\n1. Lancer - A mitigation tank able to block attacks and deal moderate damage."
            + "\n2. Priest - A defensive healer able to heal and deal low damage." + "\n3. Sorcerer - A high burst damage DPS class able to quickly take out bosses."
            + "\nEnter the number of the class you want to play: ");
        int num = scan.nextInt();
        if (num == 1){
            System.out.print("\nWhat would you like to name your Lancer?: ");
            Character player = new Lancer(scan.next());
            charcreation.close();
            return player;
        }
        else if (num == 2){
            System.out.print("\nWhat would you like to name your Priest?: ");
            Character player = new Priest(scan.next());
            charcreation.close();
            return player;
        }
        else {
            System.out.print("\nWhat would you like to name your Sorcerer?: ");
            Character player = new Sorcerer(scan.next());
            charcreation.close();
            return player;
        }
    }

    public static void endScreen(){
        System.out.print("\f");
        MP3 end = new MP3("End.mp3");
        end.play();
        System.out.println("Congratulations! You have bested Darkan! You are the champion of Sky Cruiser Endeavor!\n\nCredits:" +
            "\nCreated by Audrie Chan and Kevin Tobias\nMP3 class made with help of Zachary Goode\nOriginal TERA MMORPG used as inspiration created by Blue Hole Studios"
            + "\n\tMusic:\n\t\tTitle Screen: TERA - Godspeed\n\t\tCharacter Creation: TERA - Character Select Screen\n\t\tMap Exploration: "
            + "TERA - Ship of Destiny\n\t\tPerimos Boss Fight: TERA - Blood and Triumph\n\t\tDarkan Boss Fight: TERA - Yana's Theme"
            + "\n\t\tEnd Credits: TERA - Edge of Dream\n\nRestart the game and reset the JVM to play again.");
    }

    public static Character explore(Character p, NamedThing[][] m){
        System.out.println("Where would you like to go?");
        if (p.getY() != 9)
            System.out.println("Up");
        if (p.getY() != 0)
            System.out.println("Down");
        if (p.getX() != 0)
            System.out.println("Left");
        if (p.getX() != 4)
            System.out.println("Right");
        String direction;
        System.out.print("Enter direction here: ");
        direction = scan.next();
        while (direction.equalsIgnoreCase("up") && direction.equalsIgnoreCase("down") && direction.equalsIgnoreCase("left") && direction.equalsIgnoreCase("right") == false){
            System.out.print("Enter direction here: ");
            direction = scan.next();
        }

        if (direction.equalsIgnoreCase("up"))
            p.setY(p.getY() + 1);
        if (direction.equalsIgnoreCase("down"))
            p.setY(p.getY() - 1);
        if (direction.equalsIgnoreCase("left"))
            p.setX(p.getX() - 1);
        if (direction.equalsIgnoreCase("right"))
            p.setX(p.getX() + 1);    
        System.out.print("\f");
        if (m[p.getY()][p.getX()] instanceof Enemy && ((Enemy)m[p.getY()][p.getX()]).getHealth() > 0){
            BattleSkyCruiser b = new BattleSkyCruiser((Enemy)m[p.getY()][p.getX()], p);
            mapmusic.close();
            mapmusic.nullPlayer();
            if (p instanceof Priest)
                b.fightPriest();
            else if (p instanceof Lancer)
                b.fightLancer();
            else
                b.fightSorcerer();   
        }
        else if (m[p.getY()][p.getX()] instanceof GearFragment){
            int num = ((Material)m[p.getY()][p.getX()]).harvest();
            System.out.println("You found Gear Fragment x" + num + ": " + m[p.getY()][p.getX()].getDescrip());
            p.addGF(num);
        }
        else if (m[p.getY()][p.getX()] instanceof PerimosHeart){
            int num = ((Material)m[p.getY()][p.getX()]).harvest();
            System.out.println("You found Perimos x" + num + ": " + m[p.getY()][p.getX()].getDescrip());
            p.addPH(num);
        }
        else if (m[p.getY()][p.getX()] instanceof TantibusScale){
            int num = ((Material)m[p.getY()][p.getX()]).harvest();
            System.out.println("You found Darkan Scale x" + num + ": " + m[p.getY()][p.getX()].getDescrip());
            p.addDS(num);
        }
        else if (m[p.getY()][p.getX()] instanceof DarkanFeather){
            int num = ((Material)m[p.getY()][p.getX()]).harvest();
            System.out.println("You found Darkan Feather x" + num + ": " + m[p.getY()][p.getX()].getDescrip());
            p.addDF(num);
        }
        else if (m[p.getY()][p.getX()] instanceof CrackedTile){
            int num = ((Material)m[p.getY()][p.getX()]).harvest();
            System.out.println("You found Cracked Tile x" + num + ": " + m[p.getY()][p.getX()].getDescrip());
            p.addCT(num);
        }
        else if (m[p.getY()][p.getX()] instanceof CraftForge){
            CraftForge.craft(p);
        }
        else if (m[p.getY()][p.getX()] instanceof EnchantForge){
            EnchantForge.enchant(p);
        }
        else if (m[p.getY()][p.getX()] instanceof AwakenedForge){
            AwakenedForge.awaken(p);
        }
        else
            System.out.println("There is nothing of importance in the area. Move along.\n");
        return p;
    }
    public static Character explore(Character p, NamedThing[][][] m){
        System.out.println("Where would you like to go?");
        if (p.getY() != 9)
            System.out.println("Up");
        if (p.getY() != 0)
            System.out.println("Down");
        if (p.getX() != 0)
            System.out.println("Left");
        if (p.getX() != 4)
            System.out.println("Right");
        String direction;
        System.out.print("Enter direction here: ");
        direction = scan.next();
        while (direction.equalsIgnoreCase("up") && direction.equalsIgnoreCase("down") && direction.equalsIgnoreCase("left") && direction.equalsIgnoreCase("right") == false){
            System.out.print("Enter direction here: ");
            direction = scan.next();
        }

        if (direction.equalsIgnoreCase("up"))
            p.setY(p.getY() + 1);
        if (direction.equalsIgnoreCase("down"))
            p.setY(p.getY() - 1);
        if (direction.equalsIgnoreCase("left"))
            p.setX(p.getX() - 1);
        if (direction.equalsIgnoreCase("right"))
            p.setX(p.getX() + 1);    
        System.out.print("\f");
        if (m[p.getY()][p.getX()][0] instanceof Enemy && ((Enemy)m[p.getY()][p.getX()][0]).getHealth() > 0){
            BattleSkyCruiser b = new BattleSkyCruiser((Enemy)m[p.getY()][p.getX()][0], p);
            mapmusic.close();
            mapmusic.nullPlayer();
            if (p instanceof Priest)
                b.fightPriest();
            else if (p instanceof Lancer)
                b.fightLancer();
            else
                b.fightSorcerer();   
        }
        else if (m[p.getY()][p.getX()][0] instanceof GearFragment){
            int num = ((Material)m[p.getY()][p.getX()][0]).harvest();
            System.out.println("You found Gear Fragment x" + num + ": " + m[p.getY()][p.getX()][0].getDescrip());
            p.addGF(num);
        }
        else if (m[p.getY()][p.getX()][0] instanceof PerimosHeart){
            int num = ((Material)m[p.getY()][p.getX()][0]).harvest();
            System.out.println("You found Perimos x" + num + ": " + m[p.getY()][p.getX()][0].getDescrip());
            p.addPH(num);
        }
        else if (m[p.getY()][p.getX()][0] instanceof TantibusScale){
            int num = ((Material)m[p.getY()][p.getX()][0]).harvest();
            System.out.println("You found Darkan Scale x" + num + ": " + m[p.getY()][p.getX()][0].getDescrip());
            p.addDS(num);
        }
        else if (m[p.getY()][p.getX()][0] instanceof DarkanFeather){
            int num = ((Material)m[p.getY()][p.getX()][0]).harvest();
            System.out.println("You found Darkan Feather x" + num + ": " + m[p.getY()][p.getX()][0].getDescrip());
            p.addDF(num);
        }
        else if (m[p.getY()][p.getX()][0] instanceof CrackedTile){
            int num = ((Material)m[p.getY()][p.getX()][0]).harvest();
            System.out.println("You found Cracked Tile x" + num + ": " + m[p.getY()][p.getX()][0].getDescrip());
            p.addCT(num);
        }
        else if (m[p.getY()][p.getX()][0] instanceof CraftForge){
            CraftForge.craft(p);
        }
        else if (m[p.getY()][p.getX()][0] instanceof EnchantForge){
            EnchantForge.enchant(p);
        }
        else if (m[p.getY()][p.getX()][0] instanceof AwakenedForge){
            AwakenedForge.awaken(p);
        }
        else
            System.out.println("There is nothing of importance in the area. Move along.\n");
        return p;
    }

    public static void weaponAnalysis(Weapon w, Character p){
        int pweplvl = p.getWeapon().getEnchant();
        System.out.println("You found a " + w.getName() + " (" + w.getDescrip() + ")!");
        if (pweplvl < w.getEnchant()){
            System.out.println("This weapon is better than your weapon. Let's replace it.");
            p.setWeapon(w);
        }
        else
            System.out.println("This weapon is worse than your weapon. Let's destroy it.");
    }
}