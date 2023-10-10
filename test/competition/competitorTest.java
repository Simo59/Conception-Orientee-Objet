package competition;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import main.competition.Competitor;


public class competitorTest {

	
	private Competitor createCompetitor() {
		return new Competitor("Drift");
	}
	
	@Test
	public void competitorIncreaseNbWinTest() {
		Competitor competitor = createCompetitor();
		int nbWinInitial = competitor.getNbWin();
		competitor.increaseNbWin();
		assertEquals(competitor.getNbWin(), nbWinInitial + 1);
	}

	@Test
	public void competitorIncreaseNbWinByTest() {
		Competitor competitor = createCompetitor();
		int nbWinInitial = competitor.getNbWin();
		int n = 10;
		competitor.increaseNbWinBy(n);
		assertEquals(competitor.getNbWin(), nbWinInitial + n);
	}
	
	@Test
	public void competitorNameTest() {
		assertNotEquals(createCompetitor().getName(), null);
	}
}
