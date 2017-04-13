package banksystem;


public abstract class Transaction extends Thread{

    private User user;

    private Account account;

    private long id;

    private String log;

    public Transaction(User newUser, Account newAccount){
        this.user = newUser;
        this.account = newAccount;
        this.id = (long)(Math.random() * 10) + 1;
    }
    
    public void close(){
        System.out.println("Transaction closed.");
        System.out.println("Transaction log: " + this.getLog());
    }

    public User getUser(){
        return this.user;
    }

    public Account getAccount(){
        return this.account;
    }

    public long getId(){
        return this.id;
    }

    public void setLog(String newLog){
        this.log = newLog;
    }

    public String getLog(){
        return this.log;
    }
}
