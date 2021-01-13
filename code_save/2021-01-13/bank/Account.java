package bank;

import java.math.BigDecimal;

public class Account {
    private String accountName;
    private BigDecimal balance; //金融类使用BigDecimal java不对IEEE754做优化
    private String accountPwd;
    private String accountId;

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public void setBalance(BigDecimal balance) {
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
    public BigDecimal getBalance() {
        return balance;
    }
    public String getAccountPwd() {
        return accountPwd;
    }
    public String getAccountId() {
        return accountId;
    }
}
