package bill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SneakTests {

	Bill bill;

	@Before
	public void setUp() throws Exception {
		bill = new Bill();

		assertEquals(bill.getCurrentBillState(), Bill.BillState.inPreparation);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
	}

	/**
	 * Putting the bill into the house of commons.
	 */
	public void pathToCommons() {
		assertTrue(bill.introduceInHouse());
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.firstReading);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
	}

	/**
	 * From the first reading to second reading in the house of commons.
	 */
	public void pathFirstReadingToSecond() {
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.secondReading);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
	}

	/**
	 * From the second reading to committee consideration in the house.
	 */
	public void pathSecondReadingToCommittee() {
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.committeeConsideration);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
	}

	/**
	 * From committee consideration to third reading in the house.
	 */
	public void pathCommitteeToThirdReading() {
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inHouseOfCommons);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.thirdReading);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
	}

	/**
	 * Putting the bill in the withdrawn state.
	 */
	public void pathWithdrawn() {
		assertTrue(bill.withdraw());
		assertEquals(bill.getCurrentBillState(), Bill.BillState.withdrawn);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
	}

	/**
	 * From third reading to awaiting royal assent.
	 */
	public void pathThirdReadingToAwaitingRoyal() {
		bill.setIsCommonsBill(false);
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentBillState(), Bill.BillState.awaitingRoyalAssent);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
	}

	/**
	 * From awaiting royal assent to act of parliament.
	 */
	public void pathAwaitingRoyalToActOfParliament() {
		assertTrue(bill.royalAssent());
		assertEquals(bill.getCurrentBillState(), Bill.BillState.actOfParliament);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.Null);
	}

	/**
	 * Putting the bill into the house of commons.
	 */
	public void pathToSenate() {
		assertTrue(bill.introduceInSenate());
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.firstReadingS);
	}

	/**
	 * From the first reading in the senate to the second reading.
	 */
	public void pathFirstSenateToSecond() {
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.secondReadingS);
	}

	/**
	 * From the second reading in the senate to committee consideration.
	 */
	public void pathSecondSenateToCommittee() {
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.committeeConsiderationS);
	}

	/**
	 * From the committee in the senate to the third reading.
	 */
	public void pathCommitteeSenateToThird() {
		assertTrue(bill.votePasses());
		assertEquals(bill.getCurrentBillState(), Bill.BillState.inSenate);
		assertEquals(bill.getCurrentHouseBillState(), Bill.BillStateInHouseOfCommons.Null);
		assertEquals(bill.getCurrentSenateBillState(), Bill.BillStateInSenate.thirdReadingS);
	}

	/**
	 * Sneak Test ID: 21 (21.1-21.2)
	 */
	@Test
	public void testInPreparationModify() {
		assertFalse(bill.modify());
	}

	/**
	 * Sneak Test ID: 22 (22.1-22.2)
	 */
	@Test
	public void testInPreparationWithdraw() {
		assertFalse(bill.withdraw());
	}

	/**
	 * Sneak Test ID: 23 (23.1-23.2)
	 */
	@Test
	public void testInPreparationVoteFails() {
		assertFalse(bill.voteFails());
	}

	/**
	 * Sneak Test ID: 24 (24.1-24.2)
	 */
	@Test
	public void testInPreparationVotePasses() {
		assertFalse(bill.votePasses());
	}

	/**
	 * Sneak Test ID: 25 (25.1-25.2)
	 */
	@Test
	public void testInPreparationRoyalAssent() {
		assertFalse(bill.royalAssent());
	}

	/**
	 * Sneak Test ID: 26 (26.1-26.3)
	 */
	@Test
	public void testFirstReadingModify() {
		pathToCommons();
		assertFalse(bill.modify());
	}

	/**
	 * Sneak Test ID: 27 (27.1-27.3)
	 */
	@Test
	public void testFirstReadingRoyalAssent() {
		pathToCommons();
		assertFalse(bill.royalAssent());
	}

	/**
	 * Sneak Test ID: 28 (28.1-28.3)
	 */
	@Test
	public void testFirstReadingIntroduceInHouse() {
		pathToCommons();
		assertFalse(bill.introduceInHouse());
	}

	/**
	 * Sneak Test ID: 29 (29.1-29.3)
	 */
	@Test
	public void testFirstReadingIntroduceInSenate() {
		pathToCommons();
		assertFalse(bill.introduceInSenate());
	}

	/**
	 * Sneak Test ID: 30 (30.1-30.4)
	 */
	@Test
	public void testSecondReadingModify() {
		pathToCommons();
		pathFirstReadingToSecond();
		assertFalse(bill.modify());
	}

	/**
	 * Sneak Test ID: 31 (31.1-31.4)
	 */
	@Test
	public void testSecondReadingRoyalAssent() {
		pathToCommons();
		pathFirstReadingToSecond();
		assertFalse(bill.royalAssent());
	}

	/**
	 * Sneak Test ID: 32 (32.1-32.4)
	 */
	@Test
	public void testSecondReadingIntroduceInHouse() {
		pathToCommons();
		pathFirstReadingToSecond();
		assertFalse(bill.introduceInHouse());
	}

	/**
	 * Sneak Test ID: 33 (33.1-33.4)
	 */
	@Test
	public void testSecondReadingIntroduceInSenate() {
		pathToCommons();
		pathFirstReadingToSecond();
		assertFalse(bill.introduceInSenate());
	}

	/**
	 * Sneak Test ID: 34 (35.1-35.5)
	 */
	@Test
	public void testCommitteeConsiderationModify() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		assertFalse(bill.modify());
	}

	/**
	 * Sneak Test ID: 35 (35.1-35.5)
	 */
	@Test
	public void testCommitteeConsiderationRoyalAssent() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		assertFalse(bill.royalAssent());
	}

	/**
	 * Sneak Test ID: 36 (36.1-36.5)
	 */
	@Test
	public void testCommitteeConsiderationIntroduceInHouse() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		assertFalse(bill.introduceInHouse());
	}

	/**
	 * Sneak Test ID: 37 (37.1-37.5)
	 */
	@Test
	public void testCommitteeConsiderationIntroduceInSenate() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		assertFalse(bill.introduceInSenate());
	}

	/**
	 * Sneak Test ID: 38 (38.1-38.6)
	 */
	@Test
	public void testThirdReadingModify() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		assertFalse(bill.modify());
	}

	/**
	 * Sneak Test ID: 39 (39.1-39.6)
	 */
	@Test
	public void testThirdReadingRoyalAssent() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		assertFalse(bill.royalAssent());
	}

	/**
	 * Sneak Test ID: 40 (40.1-40.6)
	 */
	@Test
	public void testThirdReadingIntroduceInHouse() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		assertFalse(bill.introduceInHouse());
	}

	/**
	 * Sneak Test ID: 41 (41.1-41.6)
	 */
	@Test
	public void testThirdReadingIntroduceInSenate() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		assertFalse(bill.introduceInSenate());
	}

	/**
	 * Sneak Test ID: 42 (42.1-42.7)
	 */
	@Test
	public void testWithdrawnVotePasses() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathWithdrawn();
		assertFalse(bill.votePasses());
	}

	/**
	 * Sneak Test ID: 43 (43.1-43.7)
	 */
	@Test
	public void testWithdrawnVoteFails() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathWithdrawn();
		assertFalse(bill.voteFails());
	}

	/**
	 * Sneak Test ID: 44 (44.1-44.7)
	 */
	@Test
	public void testWithdrawnRoyalAssent() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathWithdrawn();
		assertFalse(bill.royalAssent());
	}

	/**
	 * Sneak Test ID: 45 (45.1-45.7)
	 */
	@Test
	public void testWithdrawnIntroduceInHouse() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathWithdrawn();
		assertFalse(bill.introduceInHouse());
	}

	/**
	 * Sneak Test ID: 46 (46.1-46.7)
	 */
	@Test
	public void testWithdrawnIntroduceInSenate() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathWithdrawn();
		assertFalse(bill.introduceInSenate());
	}

	/**
	 * Sneak Test ID: 47 (47.1-47.7)
	 */
	@Test
	public void testWithdrawnWithdraw() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathWithdrawn();
		assertFalse(bill.withdraw());
	}

	/**
	 * Sneak Test ID: 48 (48.1-48.7)
	 */
	@Test
	public void testAwaitingRoyalAssentModify() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		assertFalse(bill.modify());
	}

	/**
	 * Sneak Test ID: 49 (49.1-49.7)
	 */
	@Test
	public void testAwaitingRoyalAssentWithdraw() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		assertFalse(bill.withdraw());
	}

	/**
	 * Sneak Test ID: 50 (50.1-50.7)
	 */
	@Test
	public void testAwaitingRoyalAssentVoteFails() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		assertFalse(bill.voteFails());
	}

	/**
	 * Sneak Test ID: 51 (51.1-51.7)
	 */
	@Test
	public void testAwaitingRoyalAssentVotePasses() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		assertFalse(bill.votePasses());
	}

	/**
	 * Sneak Test ID: 52 (52.1-52.7)
	 */
	@Test
	public void testAwaitingRoyalAssentIntroduceInHouse() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		assertFalse(bill.introduceInHouse());
	}

	/**
	 * Sneak Test ID: 53 (53.1-53.7)
	 */
	@Test
	public void testAwaitingRoyalAssentIntroduceInSenate() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		assertFalse(bill.introduceInSenate());
	}

	/**
	 * Sneak Test ID: 54 (54.1-54.8)
	 */
	@Test
	public void testActOfParliamentModify() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		pathAwaitingRoyalToActOfParliament();
		assertFalse(bill.modify());
	}

	/**
	 * Sneak Test ID: 55 (55.1-55.8)
	 */
	@Test
	public void testActOfParliamentWithdraw() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		pathAwaitingRoyalToActOfParliament();
		assertFalse(bill.withdraw());
	}

	/**
	 * Sneak Test ID: 56 (56.1-56.8)
	 */
	@Test
	public void testActOfParliamentVoteFails() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		pathAwaitingRoyalToActOfParliament();
		assertFalse(bill.voteFails());
	}

	/**
	 * Sneak Test ID: 57 (57.1-57.8)
	 */
	@Test
	public void testActOfParliamentVotePasses() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		pathAwaitingRoyalToActOfParliament();
		assertFalse(bill.votePasses());
	}

	/**
	 * Sneak Test ID: 58 (58.1-58.8)
	 */
	@Test
	public void testActOfParliamentIntroduceInHouse() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		pathAwaitingRoyalToActOfParliament();
		assertFalse(bill.introduceInHouse());
	}

	/**
	 * Sneak Test ID: 59 (59.1-59.8)
	 */
	@Test
	public void testActOfParliamentIntroduceInSenate() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		pathAwaitingRoyalToActOfParliament();
		assertFalse(bill.introduceInSenate());
	}

	/**
	 * Sneak Test ID: 60 (60.1-60.8)
	 */
	@Test
	public void testActOfParliamentRoyalAssent() {
		pathToCommons();
		pathFirstReadingToSecond();
		pathSecondReadingToCommittee();
		pathCommitteeToThirdReading();
		pathThirdReadingToAwaitingRoyal();
		pathAwaitingRoyalToActOfParliament();
		assertFalse(bill.royalAssent());
	}

	/**
	 * Sneak Test ID: 61 (61.1-61.3)
	 */
	@Test
	public void testFirstReadingSModify() {
		pathToSenate();
		assertFalse(bill.modify());
	}

	/**
	 * Sneak Test ID: 62 (62.1-62.3)
	 */
	@Test
	public void testFirstReadingSRoyalAssent() {
		pathToSenate();
		assertFalse(bill.royalAssent());
	}

	/**
	 * Sneak Test ID: 63 (63.1-63.3)
	 */
	@Test
	public void testFirstReadingSIntroduceInHouse() {
		pathToSenate();
		assertFalse(bill.introduceInHouse());
	}

	/**
	 * Sneak Test ID: 64 (64.1-64.3)
	 */
	@Test
	public void testFirstReadingSIntroduceInSenate() {
		pathToSenate();
		assertFalse(bill.introduceInSenate());
	}

	/**
	 * Sneak Test ID: 65 (65.1-65.4)
	 */
	@Test
	public void testSecondReadingSModify() {
		pathToSenate();
		pathFirstSenateToSecond();
		assertFalse(bill.modify());
	}

	/**
	 * Sneak Test ID: 66 (66.1-66.4)
	 */
	@Test
	public void testSecondReadingSRoyalAssent() {
		pathToSenate();
		pathFirstSenateToSecond();
		assertFalse(bill.royalAssent());
	}

	/**
	 * Sneak Test ID: 67 (67.1-67.4)
	 */
	@Test
	public void testSecondReadingSIntroduceInHouse() {
		pathToSenate();
		pathFirstSenateToSecond();
		assertFalse(bill.introduceInHouse());
	}

	/**
	 * Sneak Test ID: 68 (68.1-68.4)
	 */
	@Test
	public void testSecondReadingSIntroduceInSenate() {
		pathToSenate();
		pathFirstSenateToSecond();
		assertFalse(bill.introduceInSenate());
	}

	/**
	 * Sneak Test ID: 69 (69.1-69.5)
	 */
	@Test
	public void testCommitteeConsiderationSModify() {
		pathToSenate();
		pathFirstSenateToSecond();
		pathSecondSenateToCommittee();
		assertFalse(bill.modify());
	}

	/**
	 * Sneak Test ID: 70 (70.1-70.5)
	 */
	@Test
	public void testCommitteeConsiderationSRoyalAssent() {
		pathToSenate();
		pathFirstSenateToSecond();
		pathSecondSenateToCommittee();
		assertFalse(bill.royalAssent());
	}

	/**
	 * Sneak Test ID: 71 (71.1-71.5)
	 */
	@Test
	public void testCommitteeConsiderationSIntroduceInHouse() {
		pathToSenate();
		pathFirstSenateToSecond();
		pathSecondSenateToCommittee();
		assertFalse(bill.introduceInHouse());
	}

	/**
	 * Sneak Test ID: 72 (72.1-72.5)
	 */
	@Test
	public void testCommitteeConsiderationSIntroduceInSenate() {
		pathToSenate();
		pathFirstSenateToSecond();
		pathSecondSenateToCommittee();
		assertFalse(bill.introduceInSenate());
	}

	/**
	 * Sneak Test ID: 73 (73.1-73.6)
	 */
	@Test
	public void testThirdReadingSModify() {
		pathToSenate();
		pathFirstSenateToSecond();
		pathSecondSenateToCommittee();
		pathCommitteeSenateToThird();
		assertFalse(bill.modify());
	}

	/**
	 * Sneak Test ID: 74 (74.1-74.6)
	 */
	@Test
	public void testThirdReadingSRoyalAssent() {
		pathToSenate();
		pathFirstSenateToSecond();
		pathSecondSenateToCommittee();
		pathCommitteeSenateToThird();
		assertFalse(bill.royalAssent());
	}

	/**
	 * Sneak Test ID: 75 (75.1-75.6)
	 */
	@Test
	public void testThirdReadingSIntroduceInHouse() {
		pathToSenate();
		pathFirstSenateToSecond();
		pathSecondSenateToCommittee();
		pathCommitteeSenateToThird();
		assertFalse(bill.introduceInHouse());
	}

	/**
	 * Sneak Test ID: 76 (76.1-76.6)
	 */
	@Test
	public void testThirdReadingSIntroduceInSenate() {
		pathToSenate();
		pathFirstSenateToSecond();
		pathSecondSenateToCommittee();
		pathCommitteeSenateToThird();
		assertFalse(bill.introduceInSenate());
	}

}
