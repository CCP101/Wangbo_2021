public class CurrentTime {
    static class time{
        int year = 2011;
        int month = 5;
        int day = 12;
        int spot = 10;
        int fen= 11;
        int second = 0;
        public void show() {
            System.out.println("����ʱ�䣺"+year+"��"+month+"��"+day+"��"+spot+"��"+fen+"��"+second+"��");
        }
    }

    public static void main(String[] args) {
        time time = new time();
        time.fen = 30;
        time.show();
    }
}
