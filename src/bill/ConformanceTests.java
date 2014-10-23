package bill;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConformanceTests {
	
	/**
	 * Conformance Test
	 * Id: 1 (1.1 - 1.3)
	 */
	@Test
	public void testFirstReadingSWithdrawl() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertTrue(testBill.introduceInSenate());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.withdraw()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 2 (2.1 - 2.3)
	 */
	@Test
	public void testFirstReadingSVoteFailed() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.voteFails()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}

	/**
	 * Conformance Test
	 * Id: 3 (3.1 - 3.4)
	 */
	@Test
	public void testSecondReadingSVoteWithdraw() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.withdraw()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 4 (4.1 - 4.4)
	 */
	@Test
	public void testSecondReadingSVoteFailed() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.voteFails()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 5 (5.1 - 5.5)
	 */
	@Test
	public void testCommitteeSWithdrawn() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.withdraw()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 6 (6.1 - 6.5)
	 */
	@Test
	public void testCommitteeSVoteFailed() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.voteFails()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 7 (7.1 - 7.6)
	 */
	@Test
	public void testThirdReadingSWithdrawn() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.thirdReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.withdraw()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 8 (8.1 - 8.6)
	 */
	@Test
	public void testThirdReadingVoteFailed() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.thirdReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.withdraw()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}

	/**
	 * Conformance Test
	 * Id: 9 (9.1 - 9.6)
	 */
	@Test
	public void testMoveToHouse() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.thirdReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertFalse(testBill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 10 (10.1 - 10.11)
	 */
	@Test
	public void testMoveBecomeActOfParliamentFromHouse() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertTrue(testBill.introduceInHouse());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.thirdReadingS);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.awaitingRoyalAssent);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.royalAssent());
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.actOfParliament);
		assertTrue(testBill.getIsCommonsBill());
	}


	/**
	 * Conformance Test
	 * Id: 11 (11.1 - 11.3)
	 */
	@Test
	public void firstReadingWithdrawAndModify() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertTrue(testBill.introduceInHouse());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.withdraw()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
		testBill.modify(); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 12 (12.1 - 12.3)
	 */
	@Test
	public void firstReadingVoteFail() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertTrue(testBill.introduceInHouse());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.voteFails()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 13 (13.1 - 13.4)
	 */
	@Test
	public void secondReadingWithdraw() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertTrue(testBill.introduceInHouse());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.withdraw()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 14 (14.1 - 14.4)
	 */
	@Test
	public void secondReadingVoteFailed() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertTrue(testBill.introduceInHouse());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.voteFails()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 15 (15.1 - 15.5)
	 */
	@Test
	public void committeeWithdraw() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertTrue(testBill.introduceInHouse());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.withdraw()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 16 (16.1 - 16.5)
	 */
	@Test
	public void committeeVoteFail() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertTrue(testBill.introduceInHouse());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.voteFails()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 17 (17.1 - 17.6)
	 */
	@Test
	public void thirdReadingWithdrawn() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertTrue(testBill.introduceInHouse());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.withdraw()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 18 (18.1 - 18.6)
	 */
	@Test
	public void thirdReadingFailVote() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertTrue(testBill.introduceInHouse());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.voteFails()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}

	/**
	 * Conformance Test
	 * Id: 19 (19.1 - 19.6)
	 */
	@Test
	public void testMoveToSenate() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertTrue(testBill.introduceInHouse());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 20 (20.1 - 20.11)
	 */
	@Test
	public void testActOfParliamentFromSenate() {
		Bill testBill = new Bill();
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.thirdReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses());
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.votePasses()); 
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.awaitingRoyalAssent);
		assertFalse(testBill.getIsCommonsBill());
		assertTrue(testBill.royalAssent());
		assertEquals(testBill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), Bill.BillState.actOfParliament);
		assertFalse(testBill.getIsCommonsBill());
	}
}
