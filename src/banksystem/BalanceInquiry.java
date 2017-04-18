/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

public class BalanceInquiry extends Transaction{
    
    public BalanceInquiry(Account newAccount){
        super(newAccount);
    }
    
    public void run(){
        System.out.print(this.getAccount().getBalance());
    }
    
}
