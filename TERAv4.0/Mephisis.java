public class Mephisis extends Enemy{
    public Mephisis(int x, int y){
        super ("Mephisis", "Toxic Turtl", 500000, x, y);
    }

    public String idle(){
        return "Mephisis is recharging!";
    }

    public String one(){
        return "Mephisis creates a chelonian armor!";
    }

    public int oneDMG(){
        return -150001;
    }

    public String low(){
        return "Mephisis says \"It's kamaras all the way down\"";
    }

    public int lowDMG(){
        return -15000;
    }

    public String high(){
        return "Mephisis says\"The air is too fresh in here!\"";
    }

    public int highDMG(){
        return -30000;
    }
}