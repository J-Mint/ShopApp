
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private int amountSpent, budget;
    private Shop currentShop;
    private boolean unlimitedBudget;
    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        // initialise instance variables
        amountSpent = 0;
        unlimitedBudget = true;
        Shop currentShop = null;

    }

    public int getAmountSpent(){
        return amountSpent;
    }

    public Shop getCurrentShop(){
        return currentShop;
    }

    public boolean hasUnlimitedBudget(){
        return unlimitedBudget;
    }

    public void enter(Shop currentShop){
        if (this.currentShop == null){
            this.currentShop = currentShop;
        }
    }

    public void exit(){
        currentShop = null;
    }

    private boolean inShop(){
        if (currentShop != null){
            return true;
        } else {
            return false;
        }
    }

    private boolean hasEnough(int buyAmount){
        if ((buyAmount * currentShop.getPrice()) <= getBudget()) {
            return true;
        } else if (hasUnlimitedBudget() == true){
            return true;
        }else {
            return false;
        }
    }

    public void buy(int buyAmount){
        if (inShop() && hasEnough(buyAmount)){
            currentShop.sell(buyAmount);
            amountSpent += buyAmount * currentShop.getPrice();
            if (hasUnlimitedBudget() == false){ 
                budget -= amountSpent;
            }
        }
    }

    public void setBudget(int budgetAmount){
        unlimitedBudget = false;
        budget = budgetAmount;
    }

    public int getBudget(){
        if (hasUnlimitedBudget()){
            //a number to represent an unlimited budget.
            return -999999999;
        } else {
            return budget;
        }
    }

}
