package package1;

import java.util.*;

public class Store{
	static Scanner scn = new Scanner(System.in);
	
	static Queue <Double> resultQuant = new LinkedList();
	static Queue <String> resultName = new LinkedList();
	static Queue <Double>resultPrice = new LinkedList();
	
	static LinkedHashMap <String,String> prodHash = new LinkedHashMap<>();
	static ArrayList <Integer> quantity = new ArrayList();
	static ArrayList <Double>price = new ArrayList();

	static Queue <String> orderedProd = new LinkedList();
	static Queue <Double> orderedQuantity = new LinkedList();
	static Queue <Double>orderedPrice = new LinkedList();
	static Computation c = new Computation();
	
	
	static void products() {
		prodHash.put("00001","Dozen of eggs     ");
		prodHash.put("00002","50 kg Rice        ");
		prodHash.put("00003","50 kg BrownRice   ");
		prodHash.put("00004","Cooking Oil       ");
		prodHash.put("00005","Vinegar / Suka    ");
		prodHash.put("00006","Bottled Water     ");
		prodHash.put("00007","Pack of Coffee    ");
		prodHash.put("00008", "Milk Shake       ");
		prodHash.put("00009", "Ice Cream        ");
		prodHash.put("00010", "Pack of Sugar    ");
		prodHash.put("00011", "Soda Drink       ");
		prodHash.put("00012", "Corned Beef      ");
		prodHash.put("00013", "All purpose Cream");
		
	}
	
	static String prodId;
	static double qt;
	
	
	static double cash;

	
	static Queue <String> cancProd = new LinkedList();
	public static void displayPayment() {
		Scanner scn = new Scanner(System.in);
		System.out.println("\t \t \t------------------------------------------------------------------------------------------------------------------");
		
	  	System.out.println("\t \t \t \t \t \t \t \t \t \tTAXABLE TOTAL    : " + c.withoutCharge);
	  	System.out.println("\t \t \t \t \t \t \t \t \t \tVat(12%)         : " + c.vat + "\n");
	  	System.out.println("\t \t \t \t \t \t \t \t \t \tTOTAL            : " + c.allTotal);

		System.out.println("\t \t \t------------------------------------------------------------------------------------------------------------------\n");
		System.out.println("\t \t \t \t" + "==================================");
	    System.out.println("\t \t \t \t" + "| 1. Pay                         |");
	    System.out.println("\t \t \t \t" + "| 2. Cancel the products         |");
	    System.out.println("\t \t \t \t" + "| 3. Exit                        |");
	    System.out.println("\t \t \t \t" + "| 4. Menu                        |");
	    System.out.println("\t \t \t \t" + "==================================");
	    System.out.print("\t \t \t \t" + "Enter your choice: ");
	    int choice = scn.nextInt();
	  
		System.out.println("\t \t \t------------------------------------------------------------------------------------------------------------------\n");

	    switch(choice) {
	    
	    case 1:
	    	while(!cancProd.isEmpty()) {
		  		cancProd.poll();
		  	}
			System.out.print("\t \t \t \t \t \t \t \t \t \t \t AMOUNT  : ");
			cash = scn.nextDouble();
			double change = cash - c.allTotal;
			Math.round(change);
		  	System.out.println("\t \t \t \t \t \t \t \t \t \t \t CASH    : " + cash);
		  	System.out.println("\t \t \t \t \t \t \t \t \t \t \t CHANGE  : " + change);
		  	//Admin.cashOn.offer(c.pricewCharge);
		  	c.resetPrices();
		  	
		  	Products.run();
		  	break;
	    case 2:
	    	c.resetPrices();
	    	cancelProduct();
	    	break;
	    case 3:
	    	System.out.println(" ");
	    	break;
	    case 4:
	    	Products.run();
	    	break;
	    case 5:
	    	System.out.println(" ");
	    	break;
	    	//Admin.display();
	    default:
	    	displayPayment();
	    }
	    	
	    
	}
	
	
	
	public static void buyProd(){
	
		try {
			
			Collections.addAll(quantity, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100);
			Collections.addAll(price,230.00, 2000.00, 2500.00, 130.00, 250.00, 25.00, 180.00 , 100.00, 300.00, 270.00, 85.00, 70.00, 150.00);
			products();		
			System.out.println("\t \t \t==================================================================================================================");
			System.out.println("\t \t \t \t" + "Code \t " + "Product \t \t \t \t \t \t \t" + "Quantity \t \t" + "Price \n");
			
			// allProd();
			int incre = 0;
			for(Map.Entry <String , String> e : prodHash.entrySet()) {
				for (int i = 0; i < 1; i++) {
					
					System.out.print("\t \t \t \t" + e.getKey());
					System.out.print("\t" + e.getValue());
					System.out.print("\t \t \t \t \t \t" + quantity.get(incre));
					System.out.println(" \t \t"  + price.get(incre));
					incre++;
				}
			}
			
			System.out.println("\t \t \t==================================================================================================================");
			
			boolean a = true;
			
			while(a) {
				System.out.println("\t \t \t \t" + "PLEASE TYPE [X] WHEN YOU ARE DONE.");
				System.out.print("\t \t \t \t" + "Enter product id: \t \t");
				prodId = scn.next();
				
				if(prodId.equalsIgnoreCase("X") ) {
					if(prodId.isEmpty()) {
						displayPayment();
					}
					break;
				}
				
				System.out.print("\t \t \t \t" + "Enter product quantity: \t");
				qt = scn.nextDouble();

				System.out.println();
				if(!prodId.equalsIgnoreCase("X") || qt == 0) {
						resultName.offer(prodHash.get(prodId));
						resultQuant.offer(qt);
				}
			}
			System.out.println("");
			System.out.println("\t \t \t==================================================================================================================");
			System.out.println("\t \t \t \t|Product| \t \t \t \t \t|Quantity|         |Price|");
			System.out.println("\t \t \t==================================================================================================================");
			
			if(resultName.isEmpty()) {
				Products.main(null);
			}
			else if(!resultName.isEmpty()) {
				while(!resultName.isEmpty()){
					System.out.print("\t \t \t \t" + resultName.peek());
					System.out.print("\t \t \t \t" + resultQuant.peek());
					
					orderedProd.offer(resultName.poll());
					orderedQuantity.offer(resultQuant.poll()); //SAVEDDDD NAAA QT
	
					int incre2 = 0;
		
					for(Map.Entry <String , String> e : prodHash.entrySet()) {
						if(e.getValue().equals(orderedProd.peek())) { // keme.peek
							System.out.println("\t \t   "+ price.get(incre2));
							orderedPrice.offer(price.get(incre2)); ////SAVEDDDD NAAAA PRICESSS
							incre2++;
							cancProd.offer(orderedProd.poll());
						}
						else {
							incre2++;
						}
					}	 
				}
			}						
			c.computationNoCancel();
			displayPayment();
		}
			catch(InputMismatchException e) {
				System.out.println("\t \t \t \tPlease try again");
				Products.run();
			}
	}
	
	
	

	static Queue <Double> quant = new LinkedList();
	static Queue <String> cancProd2 = new LinkedList();
	static Queue <Double> quant2 = new LinkedList(); 
	static Queue <String> cancProd3 = new LinkedList();

	static Queue <Double> orderedPrice2 = new LinkedList();

	static Queue <String> cancels = new LinkedList();
	static Queue <Double> cancelsPrice = new LinkedList();
	static Queue <String> cancels2 = new LinkedList(); 
	
	static Queue <Double> cancelsPrice2 = new LinkedList();
	static Queue <Double> quant3 = new LinkedList(); 
	
	public static void cancelProduct() {
		String prodIdCanc;
		while(true) {
			System.out.println("\t \t \t \t" + "PLEASE TYPE [X] WHEN YOU ARE DONE.");
			System.out.print("\t \t \t \t" + "Enter product id: \t \t");
			prodIdCanc = scn.next();
			
			if(prodIdCanc.equalsIgnoreCase("x")) {
				break;
			}
			else {
				cancels.offer(prodIdCanc);
			}
			
		}
				for(Map.Entry <String , String> e : prodHash.entrySet()) {
					if(e.getKey().equals(cancels.peek())) { // keme.peek
						
						cancProd.poll();  // Key
						
						orderedQuantity.poll();
						orderedPrice.poll();
																						//nagbabawas
						cancels.poll();
					}
					else {
						orderedPrice2.offer(orderedPrice.poll());
						cancProd2.offer(cancProd.poll());                     //inilipat
						quant.offer(orderedQuantity.poll());
					}
				}	 
				
				
		
		System.out.println("\t \t \t==================================================================================================================");
		System.out.println("\t \t \t \t|Product| \t \t \t \t \t|Quantity|         |Price|");
		System.out.println("\t \t \t==================================================================================================================");
		
	
		int incre5 = 0;
		for(Map.Entry <String , String> e : prodHash.entrySet()) {
			if(e.getValue().equals(cancProd2.peek())) {
				
				System.out.print("\t \t \t \t" + cancProd2.peek());
				System.out.print(" \t \t \t \t" + quant.peek() + "\t");
				System.out.println("         "+ price.get(incre5));
				
				cancelsPrice2.offer(price.get(incre5));
				quant3.offer(quant.poll());
				cancProd2.poll();
				incre5++;
			}
			else {
				incre5++;
			}
		}	
		
		
		
		
		
		if (cancProd2.isEmpty() || quant.isEmpty() || quant3.isEmpty() || price.isEmpty()) {
		    System.out.println("No canceled products to display or some data is missing.");
		    Products.run();
		} else {

		    c.computationCancel();
		    displayPaymentCancelled();
		}

	}
	
	public static void displayPaymentCancelled() {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("\t \t \t------------------------------------------------------------------------------------------------------------------");
		
	  	System.out.println("\t \t \t \t \t \t \t \t \t \tTAXABLE TOTAL    : " + c.withoutCharge2);
	  	System.out.println("\t \t \t \t \t \t \t \t \t \tVat(12%)         : " + c.vat2 + "\n");
	  	System.out.println("\t \t \t \t \t \t \t \t \t \tTOTAL            : " + c.allTotal2);

		System.out.println("\t \t \t------------------------------------------------------------------------------------------------------------------\n");
		System.out.println("\t \t \t \t" + "==================================");
	    System.out.println("\t \t \t \t" + "| 1. Pay                         |");
	    System.out.println("\t \t \t \t" + "| 2. Cancel the products         |");
	    System.out.println("\t \t \t \t" + "| 3. Exit                        |");
	    System.out.println("\t \t \t \t" + "| 4. Menu                        |");
	    System.out.println("\t \t \t \t" + "==================================");
	    System.out.print("\t \t \t \t" + "Enter your choice: ");
	    int choice = scn.nextInt();
	  
		System.out.println("\t \t \t------------------------------------------------------------------------------------------------------------------\n");

	    switch(choice) {
	    
	    case 1:
	    	
			System.out.print("\t \t \t \t \t \t \t \t \t \t \t AMOUNT  : ");
			cash = scn.nextDouble();
			double change = cash - c.allTotal2;
			Math.round(change);
		  	System.out.println("\t \t \t \t \t \t \t \t \t \t \t CASH    : " + cash);
		  	System.out.println("\t \t \t \t \t \t \t \t \t \t \t CHANGE  : " + change);
		  	//Admin.cashOn.offer(c.pricewCharge);
		  	while(!cancProd2.isEmpty()) {
		  		cancProd2.poll();
		  	}
		  	c.resetPrices2();
		  	Products.run();
		  	break;
	    case 2:
	    	c.resetPrices2();
	    	cancelProduct();
	    	break;
	    case 3:
	    	System.out.println(" ");
	    	break;
	    case 4:
	    	Products.run();
	    	break;
	    case 5:
	    	System.out.println(" ");
	    	break;
	    	//Admin.display();
	    }
	    	
	    
	}
	
	
}
