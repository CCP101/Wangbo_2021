package NumGene;

public class NumRandom {
    public int generateRandom(int bitnum){
        return (int) Math.round((Math.random()+1) * Math.pow(10,bitnum-1));
    }
}
