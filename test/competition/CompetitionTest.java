package competition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import main.competition.Competition;
import main.competition.Competitor;
import main.competition.NumberOfTwoCompetitorsSizeException;

public abstract class CompetitionTest {

	protected abstract Competition createCompetition() throws NumberOfTwoCompetitorsSizeException;
	protected abstract int totalOfPointsTest(Competition competition);
	
	protected List<Competitor> createListOfCompetitor(final int NB_COMPETITORS) {
		List<Competitor> competitors = new ArrayList<Competitor>();
		for (int i = 1; i <= NB_COMPETITORS; i++) {
			competitors.add(new Competitor("" + i));
		}
		return competitors;
	}
	
	@Test
	public void competitionIsUsedCorrectlyTest() throws NumberOfTwoCompetitorsSizeException {
		Competition competition = createCompetition();
		competition.play();

		Map<Competitor, Integer> ranks = competition.ranking();
		assertNotNull(ranks);
		assertEquals(ranks.size(), competition.getNbPlayers());

		int previousValue = Integer.MAX_VALUE;
		for (Competitor competitor : ranks.keySet()) {
			Integer integer = ranks.get(competitor);
			assertNotNull(integer);
			if (integer.intValue() > previousValue) fail("Ranks are not sorted");
			previousValue = integer.intValue();
		}
	}
	
	public void correctNumberOfPointsTest(Competition competition) {
		int total = 0;
		competition.play();
		
		Map<Competitor, Integer> ranks = competition.ranking();
		assertNotNull(ranks);
		for (Competitor competitor : ranks.keySet()) {
			total += ranks.get(competitor);
		}
		assertEquals(totalOfPointsTest(competition), total);
	}

}


