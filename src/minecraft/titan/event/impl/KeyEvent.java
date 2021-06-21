package titan.event.impl;

import titan.event.Event;
import titan.event.EventCancellable;

public class KeyEvent extends Event {
	
	private final int key;
	
	public KeyEvent(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}
}
