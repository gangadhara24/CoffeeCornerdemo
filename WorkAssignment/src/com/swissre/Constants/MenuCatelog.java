/**
 * 
 */
package com.swissre.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.swissre.model.Product;



/**
 * @author gangadhara
 *
 */
public class MenuCatelog {
	
	
	public static Map<String, List<Product>> getProductCatelogMenu() {
		
		Map<String, List<Product>> productCatelogMenuMap = new HashMap<>();
		
		List<Product> coffeeProductList = new ArrayList<>(); 
		List<Product> baconRollProductList = new ArrayList<>(); 
		List<Product> orangeJuiceProductList = new ArrayList<>();
		List<Product> extrasMilkProductList = new ArrayList<>();
		List<Product> extrasFoamedProductList = new ArrayList<>();
		List<Product> extrasSplRoastProductList = new ArrayList<>();
		Product coffeeSmallProduct = new Product();
		coffeeSmallProduct.setPname("Coffee");
		coffeeSmallProduct.setpSize("Small");
		coffeeSmallProduct.setPrice(2.50d);		
		coffeeProductList.add(coffeeSmallProduct);
		
		Product coffeeMediumProduct = new Product();
		coffeeMediumProduct.setPname("Coffee");
		coffeeMediumProduct.setpSize("Medium");
		coffeeMediumProduct.setPrice(3.00d);		
		coffeeProductList.add(coffeeMediumProduct);
		
		
		Product coffeeLargeProduct = new Product();
		coffeeLargeProduct.setPname("Coffee");
		coffeeLargeProduct.setpSize("Large");
		coffeeLargeProduct.setPrice(3.50d);		
		coffeeProductList.add(coffeeLargeProduct);
		
		productCatelogMenuMap.put("Coffee", coffeeProductList);
		
		Product baconRollProduct = new Product();
		baconRollProduct.setPname("Bacon Roll");
		baconRollProduct.setpSize("Normal");
		baconRollProduct.setPrice(4.50d);		
		baconRollProductList.add(baconRollProduct);
		
		productCatelogMenuMap.put("Bacon Roll", baconRollProductList);
		
		Product orangeJuiceProduct = new Product();
		orangeJuiceProduct.setPname("Special Squeezed Orange Juice");
		orangeJuiceProduct.setpSize("0.25l");
		orangeJuiceProduct.setPrice(3.95d);		
		orangeJuiceProductList.add(orangeJuiceProduct);
		
		
		productCatelogMenuMap.put("Special Squeezed Orange Juice", orangeJuiceProductList);
		
		
		//Extra items
		Product extraMilk = new Product();
		extraMilk.setPname("Extra milk");
		extraMilk.setpSize("Normal");
		extraMilk.setPrice(0.30d);		
		extrasMilkProductList.add(extraMilk);
		
		Product extraFoamedMilk = new Product();
		extraFoamedMilk.setPname("Foamed Milk");
		extraFoamedMilk.setpSize("Normal");
		extraFoamedMilk.setPrice(0.50d);		
		extrasFoamedProductList.add(extraFoamedMilk);
		
		Product extraSpRoastCoffee = new Product();
		extraSpRoastCoffee.setPname("Special roast Coffee");
		extraSpRoastCoffee.setpSize("Normal");
		extraSpRoastCoffee.setPrice(0.90d);		
		extrasSplRoastProductList.add(extraSpRoastCoffee);		
		
		productCatelogMenuMap.put("Extra milk", extrasFoamedProductList);
		productCatelogMenuMap.put("Foamed Milk", extrasFoamedProductList);
		productCatelogMenuMap.put("Special roast Coffee", extrasSplRoastProductList);
						
		
		return productCatelogMenuMap;
		
	}
	

}
