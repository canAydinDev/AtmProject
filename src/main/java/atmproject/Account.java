package atmproject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int accountNumber;
    private int pinNumber;

    private double checkingBalance;
    private double savingBalance;

    DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
    Scanner input=new Scanner(System.in);

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    //para cekme
    private double calculateCheckingBalanceAfterWithdraw(double amount){
        checkingBalance-=amount;
        return checkingBalance;
    }

    //para yatirma
    private double calculateCheckingBalanceAfterDeposit(double amount){
        checkingBalance+=amount;
        return checkingBalance;
    }

    //yatirim hesabindan para cekme
    private double calculateSavingBalanceAfterWithdraw(double amount){
        savingBalance-=amount;
        return savingBalance;
    }

    //yatirim hesabina para yatirma
    private double calculateSavingBalanceAfterDeposit(double amount){
        savingBalance+=amount;
        return savingBalance;
    }

    //Musteri ile para cekmek icin etkilesime gecelim
    public void getCheckingWithdraw(){
        displayCurrentAmount("Checking",checkingBalance);
        System.out.println("Cekmek istediginiz miktari giriniz:");
        double amount=input.nextDouble();

        if (amount<=0){
            System.out.println("Sifir veya eksi rakamlar gecersizdir!");
            getCheckingWithdraw();//recursive method
        } else if (amount<=checkingBalance) {
            calculateCheckingBalanceAfterWithdraw(amount);
            displayCurrentAmount("Checking",checkingBalance);
        }else {
            System.out.println("Yetersiz bakiye!");
        }
    }
    //para yatirma
    public void getCheckingDeposit(){
        displayCurrentAmount("Checking",checkingBalance);
        System.out.println("Yatirmak istediginiz miktari giriniz:");
        double amount= input.nextDouble();

        if (amount<=0) {
            System.out.println("Sifir veya eksi rakamlar gecersizdir!");
            getCheckingDeposit();
        }else {
            calculateCheckingBalanceAfterDeposit(amount);
            System.out.println();
            displayCurrentAmount("Checking",checkingBalance);
        }
    }

    //son bakiyeyi goster
    public void displayCurrentAmount(String balanceName,double balance){
        System.out.println(balanceName+" hesabinizda bulunan bakiye: "+moneyFormat.format(balance));
    }

    public void getSavingWithdraw(){
        displayCurrentAmount("Saving",savingBalance);
        System.out.println("Cekmek istediginiz miktari giriniz:");
        double amount=input.nextDouble();

        if (amount<=0){
            System.out.println("Sifir veya eksi rakamlar gecersizdir!");
            getSavingBalance();//recursive method
        } else if (amount<=savingBalance) {
            calculateSavingBalanceAfterWithdraw(amount);
            displayCurrentAmount("Saving",savingBalance);
        }else {
            System.out.println("Yetersiz bakiye!");
        }
    }

    public void getSavingDeposit(){
        displayCurrentAmount("Saving",savingBalance);
        System.out.println("Yatirmak istediginiz miktari giriniz:");
        double amount= input.nextDouble();

        if (amount<=0) {
            System.out.println("Sifir veya eksi rakamlar gecersizdir!");
            getSavingDeposit();
        }else {
            calculateSavingBalanceAfterDeposit(amount);
            System.out.println();
            displayCurrentAmount("Saving",savingBalance);
        }
    }
}
