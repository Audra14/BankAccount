package banksystem;


public abstract class Transaction extends Thread{

    private Account account;

    private long id;

    private String log;

    public Transaction(Account newAccount){
        this.account = newAccount;
        this.id = (long)(Math.random() * 10) + 1;
    }
    
    public void close(){
        System.out.println("Transaction closed.");
        System.out.println("Transaction log: " + this.getLog());
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
