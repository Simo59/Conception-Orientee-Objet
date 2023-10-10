package competition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.Test;

import main.competition.Competition;
import main.competition.Competitor;
import main.competition.NumberOfTwoCompetitorsSizeException;
import main.competition.Master;
import main.strategy.MasterStrategy;

public abstract class MasterTest extends CompetitionTest {
	
	protected abstract MasterStrategy getMasterStrategy();
	
	protected Master createMaster(List<Competitor> competitors) throws NumberOfTwoCompetitorsSizeException {
		return new Master(competitors, getMasterStrategy());
	}
	
	@Override
	protected Competition createCompetition() throws NumberOfTwoCompetitorsSizeException {
		final int NB_COMPETITORS = getMasterStrategy().getNbOfCompetitors();
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);
		return createMaster(competitors);
	}
	
	@Test
	public void masterGetFinalPhaseWinnerTest() throws NumberOfTwoCompetitorsSizeException {
		Master master = (Master) createCompetition();
		assertNull(master.getFinalPhaseWinner());
		master.play();
		assertNotNull(master.getFinalPhaseWinner());
	}
	

	public void masterIncorrectNumberOfCompetitorsTest() { 
		final int NB_COMPETITORS = getMasterStrategy().getNbOfCompetitors()+2;
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);
		assertThrows(NumberOfTwoCompetitorsSizeException.class, () -> createMaster(competitors));
		
	}

	@Test
	public void masterCorrectTotalOfCompetitorsPointsTest() throws NumberOfTwoCompetitorsSizeException {
		correctNumberOfPointsTest(createCompetition());
	}

	@Override
	protected int totalOfPointsTest(Competition competition) {
		Master master = (Master) competition;
		MasterStrategy masterStrategy = master.getMasterStrategy();
		assertEquals(masterStrategy.getClass(), getMasterStrategy().getClass());
		return (masterStrategy.getNbOfCompetitors()/masterStrategy.getNbOfPools())*(masterStrategy.getNbOfCompetitors()-masterStrategy.getNbOfPools())+masterStrategy.getNbOfPools()*masterStrategy.getNbOfQualifiquations()+masterStrategy.getNbOfRetrivials()-1;
	}
	
}
