package Employee;

public class Employee {
    private int id;
    private int age;
    private String name;
    private double salary;
    private String sfzID;
    private int numEmployee;
    private int sumSalary;

    public Employee(int id, int age, String name) throws AgeLow, AgeHigh, NameIllegal {
        this.id = id;
        this.age = age;
        this.name = name;
        if (age<18){
            throw new AgeLow("年龄低异常");
        }else if(age>60){
            throw new AgeHigh("年龄高异常");
        }else if (name==null||name.equals("")){
            throw new NameIllegal("姓名异常");
        }
    }

    public Employee(double salary, String sfzID) throws SalaryLow {
        this.salary = salary;
        this.sfzID = sfzID;
        if (salary<600){
            throw new SalaryLow("工资低异常");
        }
        this.numEmployee++;
        this.sumSalary+=salary;
    }

    public void addSalary(double addSalary) throws SalaryHigh {
        if (this.salary+addSalary>sumSalary){
            throw new SalaryHigh("工资高异常");
        }else{
            this.salary+=addSalary;
        }
    }

    public void minusSalary(double minusSalary) throws SalaryLow{
        if (this.salary-minusSalary<600){
            throw new SalaryLow("工资低异常");
        }else{
            this.salary-=minusSalary;
        }
    }

    public void showTotalPeople() throws ZeroPeople{
        if (this.numEmployee==0){
            throw new ZeroPeople("0人异常");
        }else{
            System.out.println(this.numEmployee);
        }
    }

    public void showTotalSalary() throws ZeroSalary{
        if (this.sumSalary==0){
            throw new ZeroSalary("0元异常");
        }else{
            System.out.println(this.sumSalary);
        }
    }

    private boolean isIDNumber(){
        if (sfzID == null || "".equals(sfzID)) {
            return false;
        }
        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        boolean matches = sfzID.matches(regularExpression);
        if (matches) {
            if (sfzID.length() == 18) {
                try {
                    char[] charArray = sfzID.toCharArray();
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        return false;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return matches;
    }
}
