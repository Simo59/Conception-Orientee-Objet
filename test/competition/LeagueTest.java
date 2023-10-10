package competition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import main.competition.Competition;
import main.competition.Competitor;
import main.competition.NumberOfTwoCompetitorsSizeException;
import main.competition.League;


public class LeagueTest extends CompetitionTest {

	@Override
	protected Competition createCompetition() {
		List<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(new Competitor("Blastoff"));
		competitors.add(new Competitor("Drift"));
		return new League(competitors);
	}

	@Override
	protected int totalOfPointsTest(Competition competition) {
		return competition.getNbPlayers()*(competition.getNbPlayers()-1);
	}
	
	@Test
	public void leaguePointsAreLimitedTest() throws NumberOfTwoCompetitorsSizeException {
		
		final int NB_COMPETITORS = 10;
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);
		Competition competition = new League(competitors);
		competition.play();
		
		Map<Competitor, Integer> ranks = competition.ranking();
		assertNotNull(ranks);
		int total = 0;
		for (Competitor competitor : ranks.keySet()) { 
			Integer integer = ranks.get(competitor);
			assertNotNull(integer);
			assertEquals(competitor.getNbWin(), integer.intValue());
			assertTrue(integer.intValue() <= 2*NB_COMPETITORS);
			total += integer.intValue();
		}
		assertEquals(total, NB_COMPETITORS*(NB_COMPETITORS-1));
	}
	
	@Test
	public void goodNumberOfPointsLeagueTest() throws NumberOfTwoCompetitorsSizeException {
		for (int nbPlayer = 2; nbPlayer < 32; nbPlayer++) {
			goodNumberOfPointsLeagueTest(nbPlayer);
		}
	}
	
	public void goodNumberOfPointsLeagueTest(final int NB_COMPETITORS) throws NumberOfTwoCompetitorsSizeException {
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);
		Competition competition = new League(competitors);
		correctNumberOfPointsTest(competition);
	}

}
