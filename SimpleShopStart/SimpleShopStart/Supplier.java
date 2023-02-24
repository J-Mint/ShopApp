
/**
 * Write a description of class Supplier here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Supplier
{
    // instance variables - replace the example below with your own
    private Shop currentShop;  
    
    /**
     * Constructor for objects of class Supplier
     */
    public Supplier()
    {
        // initialise instance variables
        currentShop = null;
    }
    
    public void resupply(Shop enterShopName){
        currentShop = enterShopName;
        int currentLevel = currentShop.getCurrentLevel();
        int maxLevel = currentShop.getStockMax();
        if (currentLevel == 0 || currentLevel < maxLevel){
            int resupplyAmount = maxLevel - currentLevel;
            currentShop.setStockLevel(resupplyAmount);
        }
    }
    }

