public class score {
    public static class student{
        String name;
        int ScoreChinese;
        int ScoreMath;
        int ScoreEnglish;
    }
    public static void main(String[] args) {
        student stu1 = new student();
        stu1.name = "�Ű׳�";stu1.ScoreChinese = 85;stu1.ScoreMath = 75;stu1.ScoreEnglish = 60;
        student stu2 = new student();
        stu2.name = "��˼˼";stu2.ScoreChinese = 65;stu2.ScoreMath = 58;stu2.ScoreEnglish = 20;
        student stu3 = new student();
        stu3.name = "�Ű׳�";stu3.ScoreChinese = 88;stu3.ScoreMath = 60;stu3.ScoreEnglish = 0;
        System.out.println("����\t\t����\t\t��ѧ\t\tӢ��");
        System.out.println(stu1.name+"\t\t"+stu1.ScoreChinese+"\t\t\t"+stu1.ScoreMath+"\t\t\t"+stu1.ScoreEnglish);
        System.out.println(stu2.name+"\t\t"+stu2.ScoreChinese+"\t\t\t"+stu2.ScoreMath+"\t\t\t"+stu2.ScoreEnglish);
        System.out.println(stu3.name+"\t\t"+stu3.ScoreChinese+"\t\t\t"+stu3.ScoreMath+"\t\t\t"+stu3.ScoreEnglish);
    }
}
