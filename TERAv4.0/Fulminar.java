public class Fulminar extends Enemy{
    public Fulminar(int x, int y){
        super ("Fulminar", "Evil Robo", 1000000, x, y);
    }

    public String idle(){
        return "Fulminar is recharging!";
    }

    public String one(){
        return "Fulminar says \"Let's cut you down to size!\"";
    }

    public int oneDMG(){
        return -1000000;
    }

    public String low(){
        return "Fulminar says \"These might sting a bit!\"";
    }

    public int lowDMG(){
        return -20000;
    }

    public String high(){
        return "Fulminar says\"I bring you the gift of annihilation!\"";
    }

    public int highDMG(){
        return -40000;
    }
}