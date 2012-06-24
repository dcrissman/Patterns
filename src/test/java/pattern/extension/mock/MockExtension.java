package pattern.extension.mock;

import pattern.extension.AbstractExtension;
import pattern.extension.SimpleExtensionable;

public class MockExtension extends AbstractExtension<SimpleExtensionable<MockExtension>>{
	
	@Override
	public Object getKey() {
		return MockExtension.class;
	}
	
	public MockExtension(SimpleExtensionable<MockExtension> target) {
		super(target);
	}

}
