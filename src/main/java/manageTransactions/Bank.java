package manageTransactions;

public class Bank implements moneyMovement{
    private double balance;
    private boolean overDraw;

    public Bank(){
        updateBalance(0);
        overDraw = false;
    }

    public Bank(double amount, boolean flag){
        updateBalance(amount);
        setOverDraw(flag);
    }

    public double getBalance() {
        return this.balance;
    }

    private void updateBalance(double amount){
        this.balance = amount;
    }

    public boolean isOverDraw() {
        return this.overDraw;
    }

    public void setOverDraw(boolean flag){
        this.overDraw = flag;
    }

    public void resetOverDraw(){
        setOverDraw(false);
    }

    public void deposit(double amount) {
        updateBalance(getBalance()+amount);
    }

    public void withDraw(double amount) {
        double newBalance = getBalance()-amount;
        setOverDraw(!(newBalance > 0));
        updateBalance(!isOverDraw()? newBalance:getBalance());
    }
}
