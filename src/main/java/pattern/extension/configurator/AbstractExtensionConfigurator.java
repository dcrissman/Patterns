package pattern.extension.configurator;

import pattern.configurator.Configurator;
import pattern.extension.AbstractExtension;
import pattern.extension.Extension;
import pattern.extension.Extensionable;

/**
 * Base {@link Configurator} for {@link Extensionable} classes.
 * 
 * @author Dennis Crissman
 *
 */
public abstract class AbstractExtensionConfigurator implements Configurator<Extensionable<?>> {

	/**
	 * Ensures that the {@link Extensionable} and {@link Extension} both know about eachother.
	 * @param extensionable - {@link Extensionable}
	 * @param extension - {@link Extension}
	 */
	public <X extends Extensionable<E>, E extends AbstractExtension<X>> void configure(X extensionable, E extension) {
		extension.setTarget(extensionable);
		extensionable.addExtension(extension.getKey(), extension);
	}

}
