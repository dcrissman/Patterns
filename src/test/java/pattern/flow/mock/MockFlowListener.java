package pattern.flow.mock;

import pattern.dummy.Fruit;
import pattern.flow.FlowChangeEvent;
import pattern.flow.FlowListener;

public class MockFlowListener implements FlowListener<Fruit>{

	private FlowChangeEvent<Fruit> event;
	
	public FlowChangeEvent<Fruit> getEvent() {
		return event;
	}

	@Override
	public void onFlowChange(FlowChangeEvent<Fruit> event) {
		this.event = event;
	}

}
