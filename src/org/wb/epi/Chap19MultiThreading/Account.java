package org.wb.epi.Chap19MultiThreading;

public class Account {
    private int balance;
    private int id;
    private static int globalId;

    public Account(int balance){
        this.balance = balance;
        this.id = ++globalId;
    }

    public boolean move(Account to, int amount){
        Account lock1 = id < to.id ? this : to;
        Account lock2 = id < to.id ? to : this;

        synchronized (lock1) {
            synchronized (lock2) {
                if(amount > balance){
                    return false;
                }
                to.balance += amount;
                this.balance -= amount;
                System.out.println("success");
                return true;
            }
        }
    }

    public int getBalance(){
        return balance;
    }

    public int getId(){
        return id;
    }
}
