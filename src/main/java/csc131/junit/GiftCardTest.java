package csc131.junit;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.reflect.Executable;
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

		amount 		 = 50.00;
		issuingStore = 1337;
		balance 	 = 100.00;
		test = "";
		card = new GiftCard(issuingStore, balance);
		test += "Remaining Balance: ";	
		test += String.format("%6.2f", Math.abs(balance-amount));
		assertEquals("deduct(amount)", test, card.deduct(amount));
	}
	
	@Test
	public void deduct_RemainingBalance2() {
		double 		balance;
		GiftCard 	card;
		int 		issuingStore;
		double 		amount;
		String 		test;

		amount 		 = 200.00;
		issuingStore = 1337;
		balance 	 = 100.00;
		test = "";
		card = new GiftCard(issuingStore, balance);
		test += "Amount Due: " + String.format("%6.2f", Math.abs(balance-amount));
		assertEquals("deduct(amount)", test, card.deduct(amount));
	}
	
	@Test
	public void deduct_RemainingBalance3() {
		double 		balance;
		GiftCard 	card;
		int 		issuingStore;
		double 		amount;
		String 		test;

		amount 		 = -10.00;
		issuingStore = 1337;
		balance 	 = 100.00;
		test = "";
		card = new GiftCard(issuingStore, balance);
		test += "Invalid Transaction";
		assertEquals("deduct(amount)", test, card.deduct(amount));
	}
	
	@Test
	public void validStoreID() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_Low() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000, -100.00);});
	}
}
