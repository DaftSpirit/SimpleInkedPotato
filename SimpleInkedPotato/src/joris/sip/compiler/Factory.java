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
	
	public double createDouble(Object o) {
		return ((Double) o).doubleValue();
	}
	
	public String createString(Object o) {
		return ((String)o);
	}
	
	public InstrumentPlayable createInstrument(String name, ArrayList<Integer> notes, ArrayList<Integer> dur, int rep) {
		InstrumentPlayable res = new InstrumentPlayable(name, notes, dur, rep);
		return res;
	}
	
	public InstrumentDef createDefinition(String name, String shape, double phase) {
		InstrumentDef res = new InstrumentDef(name, shape, phase);
		return res;
	}

}
