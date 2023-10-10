package match;

import main.match.Match;
import main.match.RandomMatch;

public class MatchRandomTest extends MatchTest {

	@Override
	protected Match createMatch() {
		return new RandomMatch();
	}

}
