package org.wb.epi.Chap19MultiThreading;

public class NineteenFiveDeadlock {
    public static void main(String[] args) {
        Account a1 = new Account(1000);
        Account a2 = new Account(700);

        transfer(a1, a2, 200);
        transfer(a2, a1, 50);


        System.out.println(a2.getId()+" "+a2.getBalance());
        System.out.println(a1.getId()+" "+a1.getBalance());
    }

    public static void transfer(final Account from, final Account to, final int amount){
        Thread transfer = new Thread( () -> from.move(to, amount));
        transfer.start();
    }
}
