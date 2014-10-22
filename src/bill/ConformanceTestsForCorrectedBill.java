package bill;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConformanceTestsForCorrectedBill {
	
	/**
	 * Conformance Test
	 * Id: 1 (1.1 - 1.3)
	 */
	@Test
	public void testFirstReadingSWithdrawl() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.withdraw(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 2 (2.1 - 2.3)
	 */
	@Test
	public void testFirstReadingSVoteFailed() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.voteFails(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}

	/**
	 * Conformance Test
	 * Id: 3 (3.1 - 3.4)
	 */
	@Test
	public void testSecondReadingSVoteWithdraw() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.withdraw(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 4 (4.1 - 4.4)
	 */
	@Test
	public void testSecondReadingSVoteFailed() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.voteFails(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 5 (5.1 - 5.5)
	 */
	@Test
	public void testCommitteeSWithdrawn() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.withdraw(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 6 (6.1 - 6.5)
	 */
	@Test
	public void testCommitteeSVoteFailed() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.voteFails(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 7 (7.1 - 7.6)
	 */
	@Test
	public void testThirdReadingSWithdrawn() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.thirdReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.withdraw(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 8 (8.1 - 8.6)
	 */
	@Test
	public void testThirdReadingVoteFailed() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.thirdReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.withdraw(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertFalse(testBill.getIsCommonsBill());
	}

	/**
	 * Conformance Test
	 * Id: 9 (9.1 - 9.6)
	 */
	@Test
	public void testMoveToHouse() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.thirdReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertFalse(testBill.getIsCommonsBill());
	}
	

	/**
	 * Conformance Test
	 * Id: 10 (10.1 - 10.11)
	 */
	@Test
	public void testMoveBecomeActOfParliamentFromHouse() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInHouse();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.thirdReadingS);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.awaitingRoyalAssent);
		assertTrue(testBill.getIsCommonsBill());
		testBill.royalAssent();
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.actOfParliament);
		assertTrue(testBill.getIsCommonsBill());
	}


	/**
	 * Conformance Test
	 * Id: 11 (11.1 - 11.3)
	 */
	@Test
	public void firstReadingWithdrawAndModify() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInHouse();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.withdraw(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
		testBill.modify(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 12 (12.1 - 12.3)
	 */
	@Test
	public void firstReadingVoteFail() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInHouse();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.voteFails(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 13 (13.1 - 13.4)
	 */
	@Test
	public void secondReadingWithdraw() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInHouse();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.withdraw(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 14 (14.1 - 14.4)
	 */
	@Test
	public void secondReadingVoteFailed() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInHouse();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.voteFails(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 15 (15.1 - 15.5)
	 */
	@Test
	public void committeeWithdraw() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInHouse();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.withdraw(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 16 (16.1 - 16.5)
	 */
	@Test
	public void committeeVoteFail() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInHouse();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.voteFails(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	
	/**
	 * Conformance Test
	 * Id: 17 (17.1 - 17.6)
	 */
	@Test
	public void thirdReadingWithdrawn() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInHouse();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.withdraw(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 18 (18.1 - 18.6)
	 */
	@Test
	public void thirdReadingFailVote() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInHouse();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.voteFails(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.withdrawn);
		assertTrue(testBill.getIsCommonsBill());
	}

	/**
	 * Conformance Test
	 * Id: 19 (19.1 - 19.6)
	 */
	@Test
	public void testMoveToSenate() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInHouse();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertTrue(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertTrue(testBill.getIsCommonsBill());
	}
	
	/**
	 * Conformance Test
	 * Id: 20 (20.1 - 20.11)
	 */
	@Test
	public void testActOfParliamentFromSenate() {
		CorrectedBill testBill = new CorrectedBill();
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inPreparation);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		testBill.introduceInSenate();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.firstReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.secondReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.committeeConsiderationS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.thirdReadingS);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inSenate);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.firstReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses();
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.secondReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.inHouseOfCommons);
		assertFalse(testBill.getIsCommonsBill());
		testBill.votePasses(); 
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.awaitingRoyalAssent);
		assertFalse(testBill.getIsCommonsBill());
		testBill.royalAssent();
		assertEquals(testBill.getCurrentHouseBillState(), CorrectedBill.BillStateInHouseOfCommons.Null);
		assertEquals(testBill.getCurrentSenateBillState(), CorrectedBill.BillStateInSenate.Null);
		assertEquals(testBill.getCurrentBillState(), CorrectedBill.BillState.actOfParliament);
		assertFalse(testBill.getIsCommonsBill());
	}
}
