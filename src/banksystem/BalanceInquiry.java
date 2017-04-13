/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

/**
 *
 * @author ljf5124
 */
public class BalanceInquiry extends Transaction{
    
    public BalanceInquiry(User newUser, Account newAccount){
        super(newUser, newAccount);
    }
    
    public void run(){
        System.out.print(this.getAccount().getBalance());
    }
    
}
