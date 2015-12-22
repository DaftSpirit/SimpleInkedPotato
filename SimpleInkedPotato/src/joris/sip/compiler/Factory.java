package joris.sip.compiler;

import java.util.ArrayList;

import joris.sip.translator.*;

public class Factory {
	
	private ArrayList<Integer> notes = new ArrayList<Integer>();
	private ArrayList<Integer> durations = new ArrayList<Integer>();
	
	public void addNote(int i) {		
		this.notes.add(i);
	}
	
	public void addDur(int i) {
		this.durations.add(i);
	}
	
	public void clearNotes() {
		this.notes.clear();
	}
	
	public void clearDurations() {
		this.durations.clear();
	}
	
	public ArrayList<Integer> getScore() {
		return this.notes;
	}
	
	public ArrayList<Integer> getDurations() {
		return this.durations;
	}
	
	public int createInt(Object o) {
		return ((Integer) o).intValue();
	}
	
	public String createString(Object o) {
		return ((String)o);
	}
	
	public Instrument createInstrument(String name, ArrayList<Integer> notes, ArrayList<Integer> dur, int rep) {
		Instrument res = new Instrument(name, notes, dur, rep);
		return res;
	}

}
