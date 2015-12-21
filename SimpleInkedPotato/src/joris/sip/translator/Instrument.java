package joris.sip.translator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Instrument {
	
	protected String name;
	protected ArrayList<Integer> notes;
	protected ArrayList<Integer> durations;
	protected int repetition;
	
	public abstract void writeInstrument(BufferedWriter bw) throws IOException;
	
	public String getInstrument() {
		return name;
	}
	public void setInstrument(String name) {
		this.name = name;
	}
	
	public ArrayList<Integer> getNotes() {
		return notes;
	}
	
	public void setNotes(ArrayList<Integer> notes) {
		this.notes = notes;
	}

	public ArrayList<Integer> getDurations() {
		return durations;
	}

	public void setDurations(ArrayList<Integer> durations) {
		this.durations = durations;
	}

	public int getRepetition() {
		return repetition;
	}

	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}
}
