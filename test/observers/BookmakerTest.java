package observers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.competition.Competition;
import main.competition.Competitor;
import main.observers.Bookmaker;
import main.observers.Journalist;

public class BookmakerTest extends journalistTest {

	@Override
	protected Journalist createJournalist() {
		return new Bookmaker("Winamax");
	}

	@Override
	protected Journalist createJournalist(PrintStream out) {
		return new Bookmaker(out);
	}

	@Override
	public void journalistTest(Journalist bookmakers, Competition competition) {
		competition.addObserver(bookmakers);

		competition.play();

		Map<Competitor,Integer> cotes = ((Bookmaker) bookmakers).getCotes();
		assertNotNull(cotes);
		assertEquals(cotes.size(), competition.getNbPlayers());
		
		for (Competitor competitor : cotes.keySet()) {
			assertNotNull(competitor);
			Integer cote = cotes.get(competitor);
			assertNotNull(cote);
			assertTrue(cote.intValue() >= 0);
		}
	}
	
}
