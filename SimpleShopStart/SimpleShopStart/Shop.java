public class Shop
{
    private int price, noOfItemsSold, currentStockLevel, stockMax;
    private Supplier main;
    
    
    public Shop(int price)
    {
        if (price >= 0){
            this.price = price;
            noOfItemsSold = 0;
            currentStockLevel = 10; 
            stockMax = 10;
            this.main = main;
        }
    }
    
    public int getPrice(){
        return price;
    }
    
    public int getNoOfItemsSold(){
        return noOfItemsSold;
    }
    
    public void sell(int amount){
        if (currentStockLevel >= amount ){
            noOfItemsSold += amount;
            currentStockLevel -= amount;
            }
        }
    
    public int getTotalIncome(){
        return price * noOfItemsSold;
    }
    
    public String toString(){
        String msg =  "This shop sells items that cost " + price + "p and has sold ";
        msg+= noOfItemsSold + " items. It's register holds " + getTotalIncome() + "p.";
        return msg;
    }
    
    public int getCurrentLevel(){
        return currentStockLevel;
    }
    
    public void setStockLevel(int setAmount){
        if (currentStockLevel + setAmount <= stockMax){
            currentStockLevel += setAmount;
        }
    }
    
    public void setStockMax(int newStockMax){
        if (newStockMax >= currentStockLevel){
            stockMax = newStockMax;
    }
    }

    
    public int getStockMax(){
        return stockMax;
    }
    }

