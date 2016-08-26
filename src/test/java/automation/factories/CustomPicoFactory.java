package automation.factories;

import automation.utils.TestInit;
import cucumber.runtime.java.picocontainer.PicoFactory;

public class CustomPicoFactory extends PicoFactory {
	public CustomPicoFactory() {
		addClass(TestInit.class);
	}
}
