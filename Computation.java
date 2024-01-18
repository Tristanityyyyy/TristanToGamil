package package1;
import java.util.*;
public class Computation{
	static Store s = new Store();
	
	static Queue <Double> totalPrice = new LinkedList();
	
	static double withoutCharge;
	static double vat;
	static double allTotal;
	
	public static void computationNoCancel(){
		for(int i = 0; i <= s.orderedQuantity.size(); i++) {
			for(int b = 0; b <= s.orderedQuantity.size(); b++) {
				double prod = s.orderedQuantity.peek() * s.orderedPrice.peek();
				
				s.quant.offer(s.orderedQuantity.peek());	// ginamit for cancelling products		
				
				//s.minus.offer(s.orderedQuantity.peek());	// gagamitin for inventory
				
				s.orderedQuantity.poll();
				s.orderedPrice.poll();
				totalPrice.offer(prod);
				
			}
		}
		while(!totalPrice.isEmpty()) {
			while (!totalPrice.isEmpty()) {
			    double prod2 = totalPrice.poll();
			    withoutCharge += prod2;
			}
		}
		
		mainComputation();
	}
	static Queue <Double> totalPrice2 = new LinkedList();
	
	static double withoutCharge2;
	static double vat2;
	static double allTotal2;	
	
	public static void computationCancel() {
		while(!s.quant3.isEmpty()) {
			double prod = s.quant3.peek() * s.cancelsPrice2.peek();
			
			//s.minusCanc.offer(s.quant3.peek());
			s.quant3.poll(); // gawin mong peek pagtapos
			//s.quant3.poll();
			
			//s.quant3.poll();// ginamit para sa inventory
			s.cancelsPrice2.poll();
			totalPrice2.offer(prod);
			
		}		
		while (!totalPrice2.isEmpty()) {
			   withoutCharge2 += totalPrice2.poll();
		}
		mainComputation2();
	}

	
	public static void mainComputation2() {
		double quotientVat = withoutCharge2 * 0.12;
		vat2 = quotientVat;
		Math.round(vat2);
		allTotal2 = withoutCharge2 + vat2;
	}

	
	
	public static void mainComputation() {
		double quotientVat = withoutCharge * 0.12;
		vat = quotientVat;
		Math.round(vat);
		allTotal = withoutCharge + vat;
	}
	
	public static void resetPrices() {
		withoutCharge = 0;
		vat = 0;
		allTotal = 0;
	}
	
	public static void resetPrices2() {
		withoutCharge2 = 0;
		vat2 = 0;
		allTotal2 = 0;
	}
	
}