package Game;

public class LevelParam {
    public final static Level[] levels = new Level[6];
    static {
        levels[0]=new Level(1, 2, 10, 30,1, false);
        levels[1]=new Level(2, 3, 9, 30,2,false);
        levels[2]=new Level(3, 4, 8, 30,5, false);
        levels[3]=new Level(4, 5, 7, 30,8, true);
        levels[4]=new Level(5, 6, 6, 30,10, true);
        levels[5]=new Level(6, 7, 5, 30,15, true);
    }
}
