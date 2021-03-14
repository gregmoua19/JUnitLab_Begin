package csc131.junit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GiftCardTest {

	@Test
	public void getIssuingStore() {
		double 		balance;
		GiftCard 	card;
		int 		issuingStore;
		
		issuingStore = 1337;
		balance 	 = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()",
					 issuingStore, card.getIssuingStore());
		
	}
	
	@Test
	public void getBalance() {
		double		balance;
		GiftCard	card;
		int 		issuingStore;
		
		issuingStore = 1337;
		balance = 500.00;
		card = new GiftCard(issuingStore, balance);
		double tolerance = .001;
		assertEquals("getBalance()", balance, card.getBalance(), .001);
	}
	
	@Test
	public void deduct_RemainingBalance() {
		double 		balance;
		GiftCard 	card;
		int 		issuingStore;
		double 		amount;
		String 		test;

		
		amount 		 = 200.00;
		issuingStore = 1337;
		balance 	 = 100.00;
		card = new GiftCard(issuingStore, balance);
		if (amount < 0.0){
			test = "";
		}else {
			if (amount > balance) {
				test = "Amount Due: ";
			} else {
				test = "Remaining Balance: ";
			}
			
			test += String.format("%6.2f", Math.abs(balance-amount));
		}
		
		assertEquals("deduct(amount)", test, card.deduct(amount));
	}

}
