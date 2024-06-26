package test;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.swissre.model.Product;
import com.swissre.util.MenuCatelog;




public class MenuCatelogTest {
	
	MenuCatelog obj = new MenuCatelog();  
    
    @Test  
    public void testProductcatLogKeySize() { 
    	 Map<String, List<Product>> productCatelogMenu = MenuCatelog.getProductCatelogMenu();
    	 Set keySet = productCatelogMenu.keySet();
        assertEquals("KeySetSize", 6,keySet.size());  
    }  
    
      
    @Test  
    public void testProductcatLogValueSize() {  
   	 Map<String, List<Product>> productCatelogMenu = MenuCatelog.getProductCatelogMenu();
   	Collection<List<Product>> productList =	productCatelogMenu.values();
         
        assertEquals("Product of list size",6, productCatelogMenu.values().size());  
    }  
      
   
}  


