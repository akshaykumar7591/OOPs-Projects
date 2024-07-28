import java.sql.SQLOutput;
import  java.util.*;
 class  ATM{
     float Balance;
     int PIN =5674;

     public void checkPin(){
         System.out.println("Enter your pin: ");
         Scanner sc=new Scanner(System.in);
         int enterpin=sc.nextInt();
         if(enterpin==PIN){
             menu();
         }
         else{
             System.out.println("Enter a valid pin ");
             menu();
         }
     }
     public void menu(){
         System.out.println("Enter your choice : ");
         System.out.println("1. Check A/C Balance ");
         System.out.println("2. Withdraw Money");
         System.out.println("3. Deposite Money");
         System.out.println("4. EXIT");
         Scanner sc=new Scanner(System.in);

         int opt=sc.nextInt();

         if(opt==1){
                  checkBalance();
         } else if (opt==2) {
                withdrawMoney();
         } else if (opt==3) {
               deposite();
         } else if (opt==4) {
             return ;
         } else{
             System.out.println("Enter a valid choice ");
         }
     }
     public  void checkBalance(){
         System.out.println("Balance : "+Balance);
         menu();
     }
     public void withdrawMoney(){
         System.out.println("Enter Amount to Withdraw");
         Scanner sc=new Scanner(System.in);
         float amount=sc.nextFloat();

         if(amount>Balance){
             System.out.println("Insufficient Balance ");
         }
         else{
             Balance=Balance-amount;
             System.out.println("Money Withdraw Successful");
         }
         menu();

     }
     public void  deposite(){
         System.out.println("Enter the Amount : ");
         Scanner sc=new Scanner(System.in);
         float amount=sc.nextFloat();
         Balance+=amount;

         System.out.println("Money Deposite Successfully ");
        menu();
     }
}
public class ATM_Machine {
    public static void main(String[] args) {
 ATM abj=new ATM();
 abj.checkPin();
    }
}
