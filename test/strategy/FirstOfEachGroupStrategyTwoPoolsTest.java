package strategy;

import main.strategy.FirstOfEachGroupStrategyTwoPools;
import main.strategy.MasterStrategy;
import competition.MasterTest;

public class FirstOfEachGroupStrategyTwoPoolsTest extends MasterTest {

	protected MasterStrategy getMasterStrategy() {
		return new FirstOfEachGroupStrategyTwoPools();
	}
}
