package observers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

import main.competition.Competition;
import main.competition.Competitor;
import main.competition.NumberOfTwoCompetitorsSizeException;
import main.competition.League;
import main.competition.Master;
import main.competition.Tournament;
import main.match.Match;
import main.observers.Journalist;
import main.strategy.FirstOfEachGroupStrategyTwoPools;

public class journalistTest {
	
	private List<Competitor> createListOfCompetitor() {
		return Arrays.asList(new Competitor("Blastoff"), new Competitor("Drift"),
				 new Competitor("Lynx"), new Competitor("Catalyst"),
				 new Competitor("Raven"), new Competitor("Midas"),
				 new Competitor("Lille"), new Competitor("Lyon"));
	}
	
	protected Journalist createJournalist() {
		return new Journalist("Karim");
	}
	
	protected Journalist createJournalist(PrintStream out) {
		return new Journalist(out);
	}

	public ByteArrayInputStream journalistTest(Competition competition) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		assertNotNull(out);
		
		Journalist journalist = createJournalist(out);
		
		journalistTest(journalist, competition);
		
		ByteArrayInputStream in = new ByteArrayInputStream((baos.toByteArray()));
		assertNotNull(in);
		assertNotEquals(in.read(), -1);
		in.reset();
		return in;
	}
	
	public void journalistTest(Journalist journalist, Competition competition) {
		competition.addObserver(journalist);
		competition.play();
	}
	

	@Test
	public void journalistMasterTest() throws NumberOfTwoCompetitorsSizeException {
		List<Competitor> competitors = createListOfCompetitor();

		Competition competition = new Master(competitors, new FirstOfEachGroupStrategyTwoPools());
			
		journalistTest(competition);
		journalistTest(createJournalist(), competition);
	}
	
	@Test
	public void journalistTournamentTest() throws NumberOfTwoCompetitorsSizeException {
		List<Competitor> competitors = createListOfCompetitor();
		Competition competition = new Tournament(competitors);
		journalistTest(competition);
		journalistTest(createJournalist(), competition);
	}
	
	@Test
	public void journalistLeagueTest() {
		List<Competitor> competitors = createListOfCompetitor();
		Competition competition = new League(competitors);
		journalistTest(competition);
		journalistTest(createJournalist(), competition);
	}
	
	@Test
	public void journalistFunctionsTest() {
		List<Competitor> competitors = createListOfCompetitor();
		
		Competition competition = new League(competitors);
		assertEquals(0, competition.countObservers());
		
		Journalist journalist = createJournalist();
		
		competition.addObserver(journalist);
		assertEquals(1, competition.countObservers());
		
		competition.addObserver(createJournalist());
		assertEquals(2, competition.countObservers());
		
		competition.deleteObserver(journalist);
		assertEquals(1, competition.countObservers());
		
		competition.addObserver(journalist);
		assertEquals(2, competition.countObservers());
		
		competition.deleteObservers();
		assertEquals(0, competition.countObservers());
	}
	

	class LeagueMock extends League {

		public LeagueMock(List<Competitor> competitors) {
			super(competitors, new MatchMock());
		}
		
		@Override
		protected void play(List<Competitor> cps) {
			for (Competitor c1 : cps) {
				for (Competitor c2 : cps) {
					for (Competitor c3 : cps) {
						if (c1 != c2 && c1 != c3 && c2 != c3) {
							playMatch(c1, c2, c3);
						}
					}
				}
			}
		}

		protected void playMatch(Competitor c1, Competitor c2, Competitor c3) {
			getMatch().clearPlayers();
			getMatch().addPlayer(c1);
			getMatch().addPlayer(c2);
			getMatch().addPlayer(c3);
			Competitor winnerCompetitor = getMatch().playMatch();
			addPointToTheWinner(winnerCompetitor);
			//setChanged();
			notifyObservers(getMatch());
			System.out.printf("%s vs %s and %s --> %s wins!\n", c1.getName(), c2.getName(), c3.getName(), winnerCompetitor.getName());
		}
		
	}
	
	class MatchMock extends Match {

		public MatchMock() {
			super(3);
		}

		@Override
		public Competitor playMatch() {
			Competitor winnerCompetitor = getPlayers().get(0);
			winnerCompetitor.increaseNbWin();
			return lastWinner = winnerCompetitor;
		}
		
	}
	
}
