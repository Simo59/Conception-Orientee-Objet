package competition;

import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.Test;

import main.competition.Competition;
import main.competition.Competitor;
import main.competition.NumberOfTwoCompetitorsSizeException;
import main.competition.Tournament;


public class TournamentTest extends CompetitionTest {

	@Override
	protected Competition createCompetition() throws NumberOfTwoCompetitorsSizeException {
		List<Competitor> competitors = createListOfCompetitor(8);
		return new Tournament(competitors);
	}
	

	public void tournamentIncorrectNumberOfCompetitorsTest() { 
		final int NB_COMPETITORS = 10;
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);
		assertThrows(NumberOfTwoCompetitorsSizeException.class, () -> new Tournament(competitors));
	}
	
	@Test
	public void tournamentCorrectTotalOfCompetitorsPointsTest() throws NumberOfTwoCompetitorsSizeException {
		final int NB_COMPETITORS = 8;
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);
		Tournament tournament = new Tournament(competitors);	
		correctNumberOfPointsTest(tournament);
	}

	@Override
	protected int totalOfPointsTest(Competition competition) {
		return competition.getNbPlayers()-1;
	}

}
