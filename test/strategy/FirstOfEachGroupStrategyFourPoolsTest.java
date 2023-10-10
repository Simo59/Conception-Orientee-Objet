package strategy;

import competition.MasterTest;
import main.strategy.FirstOfEachGroupStrategyFourPools;
import main.strategy.MasterStrategy;


public class FirstOfEachGroupStrategyFourPoolsTest extends MasterTest {

	protected MasterStrategy getMasterStrategy() {
		return new FirstOfEachGroupStrategyFourPools();
	}
}
