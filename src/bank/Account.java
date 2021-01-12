package bank;

public class Account {
    private String accountName;
    private double balance;
    private String accountPwd;
    private String accountId;

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setAccountPwd(String accountPwd) {
        this.accountPwd = accountPwd;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getAccountName() {
        return accountName;
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountPwd() {
        return accountPwd;
    }
    public String getAccountId() {
        return accountId;
    }
}
