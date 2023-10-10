package match;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.competition.Competitor;
import main.match.Match;

public abstract class MatchTest {

	protected abstract Match createMatch();
	
	@Test
	public void testMatchIsUsed() {
		Match match = createMatch();
		
		Competitor p1 = new Competitor("Drift");
		Competitor p2 = new Competitor("Lynx");
		match.addPlayer(p1);
		match.addPlayer(p2);

		Competitor winner = match.playMatch();
		assertNotNull(winner);
		assertEquals(winner.getNbWin(), 1);
		assertTrue(winner.equals(p1) ^ winner.equals(p2));
	}
	
	@Test
	public void matchPlayingTest() {
		Match match = createMatch();
		
		List<Competitor> players = new ArrayList<Competitor>();
		for (int idx = 1; idx <= match.getNbPlayers(); idx++) {
			players.add(new Competitor("" + idx));
		}
		
		assertTrue(match.addAllPlayers(players));
		assertEquals(match.getPlayers().size(), match.getNbPlayers());
		assertFalse(match.addPlayer(new Competitor("0")));
		assertEquals(match.getPlayers().size(), match.getNbPlayers());
		assertTrue(match.removePlayer(players.get(0)));
		assertEquals(match.getPlayers().size(), match.getNbPlayers()-1);
		match.clearPlayers();
		assertEquals(match.getPlayers().size(), 0);
	}
}
