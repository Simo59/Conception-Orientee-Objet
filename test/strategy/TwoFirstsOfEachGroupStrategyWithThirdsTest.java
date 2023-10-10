package strategy;

import main.strategy.MasterStrategy;
import main.strategy.TwoFirstsOfEachGroupStrategyWithThirds;
import competition.MasterTest;

public class TwoFirstsOfEachGroupStrategyWithThirdsTest extends MasterTest {

	@Override
	protected MasterStrategy getMasterStrategy() {
		return new TwoFirstsOfEachGroupStrategyWithThirds();
	}

}
