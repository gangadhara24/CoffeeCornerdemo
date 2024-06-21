package com.swissre;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import com.swissre.model.Product;
import com.swissre.util.MenuCatelog;


/**
 * @author gangadhara
 *
 */
public class CoffeCornerMain   
{  
	public static int orderedBeveragesCount = 0;
    public static void main(String args[])   
        {  
            String id = null;  
            String productName = null;  
            String size = null;  
            int quantity = 0;  
            double price = 0.0;  
            double totalPrice = 0.0;  
            double overAllPrice = 0.0;  
            double cgst, sgst, subtotal=0.0, discount=0.0;  
            char choice = '\0'; 
            int count = 0;
            Map<String, List<Product>> productCatelogMenu = MenuCatelog.getProductCatelogMenu();
            
            System.out.println("\t\t\t\t--------------------Invoice-----------------");  
            System.out.println("\t\t\t\t\t "+"  "+"Charlene's Coffee Corner");  
            System.out.println("\t\t\t\t\t3/98  Switzerland");  
            System.out.println("\t\t\t\t\t"  +"    " +"Near to Swissre Office");  
            System.out.println("GSTIN: 03AWBPP8756K592"+"\t\t\t\t\t\t\tContact: (+1) 1234567890");  
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
            Date date = new Date();    
            Calendar calendar = Calendar.getInstance();  
            String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };  
            System.out.println("Date: "+formatter.format(date)+"  "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]+"\t\t\t\t\t\t (+1) 1234567890");  
            Scanner scan = new Scanner(System.in);  
            System.out.print("Enter Customer Name: ");  
            String customername=scan.nextLine();  
            List<Product> product = new ArrayList<Product>();  
            
            StringBuffer sb = new StringBuffer();
            
            StringBuffer productNames = new StringBuffer();
            
            productCatelogMenu.keySet().stream().forEach(name-> productNames.append(name).append("/"));
            
            boolean isValid = false;
            boolean isBeverage = true;
            boolean isSnack = false;
            int orderedBeveragesCount = 0;
            double totalDiscount = 0;
            boolean isBeverageSnackOrdered = false;
            do   
                {  
            	    isValid = false;
            	    isBeverage = true;
            	    isSnack= false;
            	    
                    System.out.println("Enter the product from available items: "+ productNames);  
                    System.out.print("Product Name: ");  
                    productName = scan.nextLine();
                    
                    productName = productName.trim();
                    sb = new StringBuffer();
                    
                    if(productName!= null && !"".equals(productName)) {
                    	  List<Product> selectedProductList = productCatelogMenu.get(productName);
                    	  if(selectedProductList!= null && !selectedProductList.isEmpty()) {
                    		  isValid = true; 
                    		  for (Product product2 : selectedProductList) {
                    			  if("Snack".equals(product2.getpType())) {
                    				  isBeverage = false;
                    				  isSnack = true;
                    			  }
                    			  sb.append(product2.getpSize()).append("/");
							  }
                    	  }
                    }
                  
                   if(isValid) {
                	   
                	System.out.println("Enter size from available sizes : "+ sb); 
                	System.out.print("Size: ");  
                    size = scan.nextLine();  
                    
                    String psize = size.trim();                    		
                    
                   try {
					if(productCatelogMenu.containsKey(productName)) {
						   List<Product> prodList = productCatelogMenu.get(productName);
						   Optional<Product> findFirst = prodList.stream().filter(p-> p.getpSize().equalsIgnoreCase(psize)).findFirst();
						   Product product2 = findFirst.get();
						   price = product2.getPrice();
					   }
					} catch (Exception e) {
						isValid = false;
					}
                    
                   if(isValid) {
                	   
                	System.out.print("Quantity: ");  
                    try {
						quantity = scan.nextInt();
					} catch (Exception e) {
						isValid = false;
					}  
                    
                   if(isValid) {
                    
                    totalPrice = price * quantity;  
                    overAllPrice = overAllPrice + totalPrice;  
                    for (int i = 0; i < quantity; i++) {
                    	if(isBeverage) {
                    		orderedBeveragesCount++;
                    		if(orderedBeveragesCount%5 == 0) {
                    			overAllPrice = overAllPrice - price;
                    			totalDiscount+=price;
                    		}
                    	}
                    	if(orderedBeveragesCount>0&&isSnack) {
                    		isBeverageSnackOrdered = true;
                    	}                    	
					}
                    product.add( new Product(psize,productName, quantity, price, totalPrice) );  
                    
                    if(isBeverageSnackOrdered) {
                    	for (Product product2 : product) {
                    		if(count == 0 && (product2.getPname().equalsIgnoreCase("Extra milk") || product2.getPname().equalsIgnoreCase("Foamed Milk") || product2.getPname().equalsIgnoreCase("Special roast Coffee"))) {
	                    		overAllPrice = overAllPrice - product2.getPrice();
	                    		totalDiscount += product2.getPrice();
	                    		count++;
	                    		System.out.println("total discount"+ totalDiscount);
                    		}
						}
                    }
                    
                    System.out.print("Want to add more items? (y or n): ");  
                    choice = scan.next().charAt(0);  
                    scan.nextLine();  
                    
                   }
                   
                   }
                    
                   }
                }   
            while (choice == 'y' || choice == 'Y');  
            
            if(!isValid) {
            	System.out.println("Invalid option entered, please recheck!");
            	System.exit(0);
            }
            Product.displayFormat();  
            for (Product p : product)   
            {  
                p.display();  
            }  
            
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (CHF.) " +df.format(overAllPrice) );  
           // discount = overAllPrice*2/100; 
            discount+=totalDiscount;
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Discount (CHF.) " +df.format(discount));  
            subtotal = overAllPrice-discount;   
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Subtotal (CHF.) "+df.format(subtotal));  
            sgst=overAllPrice*12/100;  
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t    SGST (CHF.) (%) "+df.format(sgst));  
            cgst=overAllPrice*12/100;  
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t     CGST (CHF.) (%) "+df.format(cgst));  
            double invoiceTotal = subtotal+cgst+sgst;
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total (CHF.) " +df.format(invoiceTotal));  
            System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");  
            System.out.println("\t\t\t\t                     Visit Again");  
            scan.close();  
        }     
}  
