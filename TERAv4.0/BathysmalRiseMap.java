public class BathysmalRiseMap{
    private String name;
    private String description;
    private NamedThing[][][] layout = new NamedThing[10][5][3];
    public BathysmalRiseMap(){
        name = "Bathysmal Rise";
        description = "An underwater dungeon with hundreds of deadly enemies that like to vomit, spit," + 
            " and jump on you!";
        layout[2][0][0] = new Mephisis(4, 0);
        layout[2][1][0] = new Mephisis(4, 1);
        layout[2][2][0] = new Mephisis(4, 2);
        layout[2][3][0] = new Mephisis(4, 3);
        layout[2][4][0] = new Mephisis(4, 4);
        layout[5][0][0] = new Tantibus(5, 0);
        layout[5][1][0] = new Tantibus(5, 1);
        layout[5][2][0] = new Tantibus(5, 2);
        layout[5][3][0] = new Tantibus(5, 3);
        layout[5][4][0] = new Tantibus(5, 4);
        layout[9][4][0] = new Fulminar(9, 4);
        layout[8][0][0] = new TantibusScale();
        layout[6][3][0] = new TantibusScale();
        layout[6][0][0] = new TantibusScale();
        layout[7][2][0] = new TantibusScale();
    }

    public NamedThing[][][] getLayout(){
        return layout;
    }

}