public class Tantibus extends Enemy{
    public Tantibus(int x, int y){
        super ("Tantibus", "Vomiting Fishie", 750000, x, y);
    }

    public String idle(){
        return "Tantibus is resting!";
    }

    public String one(){
        return "Tantibus says \"Can you control your fear? I doubt it!\"";
    }

    public int oneDMG(){
        return -150001;
    }

    public String low(){
        return "Tantibus is preparing to do a backflip!";
    }

    public int lowDMG(){
        return -15000;
    }

    public String high(){
        return "The pool is overflowing!";
    }

    public int highDMG(){
        return -30000;
    }
}