import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ShopTest
{
    @Test
    public void constructorTest(){
        Shop poundland = new Shop(100);
        assertEquals(100, poundland.getPrice(), "The price of items should be 100\n");
        assertEquals(0,   poundland.getNoOfItemsSold(), "The number of items sold should be zero\n");
        
        Shop fiverr = new Shop(500);
        assertEquals(500, fiverr.getPrice(), "The price of items should be 500\n");
        assertEquals(0,   fiverr.getNoOfItemsSold(), "The number of items sold should be zero\n");
        
    }
    
    @Test
    public void sellTest(){
        Shop poundland = new Shop(100);
        poundland.sell(4);
        assertEquals(100, poundland.getPrice(), "The price of items should be 100\n");
        assertEquals(4,   poundland.getNoOfItemsSold(), "The number of items sold should be four\n");
        poundland.sell(6);
        assertEquals(100, poundland.getPrice());
        assertEquals(10,   poundland.getNoOfItemsSold(), "The number of items sold should now be ten\n");
    }
    
    @Test
    public void totalTest(){
        Shop poundland = new Shop(100);
        poundland.sell(4);
        assertEquals(400, poundland.getTotalIncome(), "The total income after selling 4 items should be 400\n");
        poundland.sell(6);
        assertEquals(1000, poundland.getTotalIncome(), "The total income after selling 10 items should be 1000\n");
    }
    
    @Test
    public void fullyRestockFromEmpty(){
        Shop s1 = new Shop(100);
        assertEquals(10, s1.getCurrentLevel());
        s1.sell(6);
        assertEquals(4, s1.getCurrentLevel());
        s1.sell(4);
        Supplier Supp = new Supplier();
        Supp.resupply(s1);
        assertEquals(10, s1.getCurrentLevel());
    }
    
    @Test
    public void requestOverStock(){
        Shop s1 = new Shop(100);
        assertEquals(10, s1.getCurrentLevel());
        s1.setStockLevel(30);
        //should be unchanged
        assertEquals(10, s1.getCurrentLevel());
    }
    
    @Test
    public void changeStockMax(){
        Shop s1 = new Shop(100);
        assertEquals(10, s1.getCurrentLevel());
        s1.setStockMax(50);
        //max stock level should now be 50
        assertEquals(50, s1.getStockMax());
        //current stock level should be unchanged
        assertEquals(10, s1.getCurrentLevel());
        s1.setStockLevel(40);
        assertEquals(50, s1.getCurrentLevel());
    }
    
    @Test
    public void setMaxLevelTooLow(){
        Shop s1 = new Shop(100);
        //10 in stock
        assertEquals(10, s1.getCurrentLevel());
        //attempt to set max level below what's in stock 
        s1.setStockMax(5);
        //levels should be unchanged
        assertEquals(10, s1.getStockMax());
        assertEquals(10, s1.getCurrentLevel());
            }
}
