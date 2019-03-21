package com.company;
import java.lang.reflect.*;
import org.apache.xmlrpc.WebServer;

public class Main implements Routes{
    private static double budget;
    private static boolean debit;
    private static boolean created;
    public static void main(String argv[]){
        budget = 0;
        created = false;
        debit = false;
        try {
            System.out.println("starting the serv");
            int port = 8090;
            WebServer serv= new WebServer(port);
            serv.addHandler("BankingServer",new Main());
            serv.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public double getBudget(){
        return budget;
    }

    public void setDebit(boolean a) {
        debit=a;
    }

    public boolean withdrawMoney(double c) {
        if(debit) {
           budget-=c;
        } else {
            if(budget>=c) {
               budget -= c;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean depositMoney(double c) {
        budget+=c;
        return true;
    }
}
