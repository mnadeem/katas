package com.nadeem.app.kata;

import java.util.Collection;

/**
 * @author Nadeem Mohammad
 *
 */
public interface BoardRenderer {

	void render(final Collection<Square> values);
	void render(final String message);
}
