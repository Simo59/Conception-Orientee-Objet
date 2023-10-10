package match;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.competition.Competitor;
import main.match.Match;

public class MatchMockTest extends MatchTest {

	@Override
	protected Match createMatch() {
		return new MatchMock(2);
	}
	
	@Test
	public void matchPlayingTest() {
		Match match = createMatch();
		
		Competitor p1 = new Competitor("Drift");
		Competitor p2 = new Competitor("Lynx");
		match.addPlayer(p1);
		match.addPlayer(p2);
		
		assertEquals(match.playMatch(), p1);
	}
	
	class MatchMock extends Match {

		public MatchMock(int nbPlayers) {
			super(nbPlayers);
		}

		@Override
		public Competitor playMatch() {
			Competitor winnerCompetitor = getPlayers().get(0);
			winnerCompetitor.increaseNbWin();
			return lastWinner = winnerCompetitor;
		}
		
	}

}
