package bill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ConformanceTests {
	
	Bill bill;
	
	@Before
	public void setUp() throws Exception {
		bill = new Bill();
		
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
	}
	
	/**
	 * Conformance Test
	 * Id: 1 (1.1 - 1.3)
	 */
	@Test
	public void testFirstReadingSWithdrawl() {
		assertTrue(bill.introduceInSenate());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.withdraw()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(bill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 2 (2.1 - 2.3)
	 */
	@Test
	public void testFirstReadingSVoteFailed() {
		bill.introduceInSenate();
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.voteFails()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(bill.getIsCommonsBill());
	}

	/**
	 * Conformance Test
	 * Id: 3 (3.1 - 3.4)
	 */
	@Test
	public void testSecondReadingSVoteWithdraw() {
		bill.introduceInSenate();
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.withdraw()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(bill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 4 (4.1 - 4.4)
	 */
	@Test
	public void testSecondReadingSVoteFailed() {
		bill.introduceInSenate();
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.voteFails()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(bill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 5 (5.1 - 5.5)
	 */
	@Test
	public void testCommitteeSWithdrawn() {
		bill.introduceInSenate();
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.withdraw()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(bill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 6 (6.1 - 6.5)
	 */
	@Test
	public void testCommitteeSVoteFailed() {
		bill.introduceInSenate();
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.voteFails()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(bill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 7 (7.1 - 7.6)
	 */
	@Test
	public void testThirdReadingSWithdrawn() {
		bill.introduceInSenate();
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.thirdReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.withdraw()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(bill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 8 (8.1 - 8.6)
	 */
	@Test
	public void testThirdReadingVoteFailed() {
		bill.introduceInSenate();
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.thirdReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.withdraw()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(bill.getIsCommonsBill());
	}

	/**
	 * Conformance Test
	 * Id: 9 (9.1 - 9.6)
	 */
	@Test
	public void testMoveToHouse() {
		bill.introduceInSenate();
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.thirdReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertFalse(bill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 10 (10.1 - 10.11)
	 */
	@Test
	public void testMoveBecomeActOfParliamentFromHouse() {
		assertTrue(bill.introduceInHouse());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.thirdReadingS);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.awaitingRoyalAssent);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.royalAssent());
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.actOfParliament);
		assertTrue(bill.getIsCommonsBill());
	}


	/**
	 * Conformance Test
	 * Id: 11 (11.1 - 11.3)
	 */
	@Test
	public void firstReadingWithdrawAndModify() {
		assertTrue(bill.introduceInHouse());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.withdraw()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(bill.getIsCommonsBill());
		bill.modify(); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertTrue(bill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 12 (12.1 - 12.3)
	 */
	@Test
	public void firstReadingVoteFail() {
		assertTrue(bill.introduceInHouse());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.voteFails()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(bill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 13 (13.1 - 13.4)
	 */
	@Test
	public void secondReadingWithdraw() {
		assertTrue(bill.introduceInHouse());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.withdraw()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(bill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 14 (14.1 - 14.4)
	 */
	@Test
	public void secondReadingVoteFailed() {
		assertTrue(bill.introduceInHouse());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.voteFails()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(bill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 15 (15.1 - 15.5)
	 */
	@Test
	public void committeeWithdraw() {
		assertTrue(bill.introduceInHouse());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.withdraw()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(bill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 16 (16.1 - 16.5)
	 */
	@Test
	public void committeeVoteFail() {
		assertTrue(bill.introduceInHouse());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.voteFails()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(bill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 17 (17.1 - 17.6)
	 */
	@Test
	public void thirdReadingWithdrawn() {
		assertTrue(bill.introduceInHouse());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.withdraw()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(bill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 18 (18.1 - 18.6)
	 */
	@Test
	public void thirdReadingFailVote() {
		assertTrue(bill.introduceInHouse());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.voteFails()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(bill.getIsCommonsBill());
	}

	/**
	 * Conformance Test
	 * Id: 19 (19.1 - 19.6)
	 */
	@Test
	public void testMoveToSenate() {
		assertTrue(bill.introduceInHouse());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertTrue(bill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 20 (20.1 - 20.11)
	 */
	@Test
	public void testActOfParliamentFromSenate() {
		bill.introduceInSenate();
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.thirdReadingS);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.votePasses()); 
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.awaitingRoyalAssent);
		assertFalse(bill.getIsCommonsBill());
		assertTrue(bill.royalAssent());
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(bill.getCurrentBillState(), Bill.BillState.actOfParliament);
		assertFalse(bill.getIsCommonsBill());
	}
}
