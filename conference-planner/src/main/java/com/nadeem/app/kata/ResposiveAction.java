package com.nadeem.app.kata;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public interface ResposiveAction<T> extends Action<T> {
	void onException(Exception exception);
}
