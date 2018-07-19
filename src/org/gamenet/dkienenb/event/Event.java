package org.gamenet.dkienenb.event;

public class Event {

	private boolean canceled = false;

	public boolean isCanceled() {
		return canceled;
	}

	public void cancel() {
		canceled = true;
	}

}
