import java.text.MessageFormat;
import java.util.Scanner;

public class seasonJudge {
    static class season {
        String spring = "spring";
        String summer = "summer";
        String autumn = "autumn";
        String winter = "winter";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        season season = new season();
        int judge = (input.nextInt()-1)/4;
        switch (judge){
            case 0:
                System.out.println(season.spring);
                break;
            case 1:
                System.out.println(season.summer);
                break;
            case 2:
                System.out.println(season.autumn);
                break;
            case 3:
                System.out.println(season.winter);
                break;
            default:
                System.out.println("³ö´í");
        }
    }
}
