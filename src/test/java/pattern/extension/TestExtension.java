package pattern.extension;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import pattern.extension.mock.MockExtension;

public class TestExtension {
	
	@Test
	public void testTarget(){
		SimpleExtensionable<MockExtension> extensionable = new SimpleExtensionable<MockExtension>();
		MockExtension extension = new MockExtension(extensionable);
		
		assertSame(extensionable, extension.getTarget());
	}
	
}
