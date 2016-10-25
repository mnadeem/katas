package com.nadeem.app.kata;

import java.util.List;
/**
 * 
 * @author Nadeem Mohammad
 *
 */
public interface RenderingStrategy {
	void render(List<Location> locations);
	void render(String string);
}
