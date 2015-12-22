package joris.sip.translator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Instrument {
	
	protected String name;
	protected ArrayList<Integer> notes;
	protected ArrayList<Integer> durations;
	protected int repetition;
	
	public Instrument(String name, ArrayList<Integer> notes, ArrayList<Integer> durations, int rep) {
		this.name = name;
		this.notes = notes;
		this.durations = durations;
		this.repetition = rep;
	}
	
	public void writeInstrument(BufferedWriter bw) throws IOException {
		bw.write("Pseq([Pbind(\\instrument, \\" + this.name + ", "
				+ "\\midinote, Pseq([");
		for(int i = 0; i < notes.size(); ++i) {
			if(i == notes.size() - 1) {
				bw.write(notes.get(i).toString());
				continue;
			}
			bw.write(notes.get(i).toString() + ", ");
		}
		bw.write("], 1), "
				+ "\\dur, Pseq([");
		for(int j = 0; j < durations.size(); ++j) {
			if(j == durations.size() - 1){
				bw.write(durations.get(j).toString());
				continue;
			}
			bw.write(durations.get(j).toString() + ", ");
		}
		bw.write("], 1), "
				+ "\\amp, 0.5 "
				+ ")]," + repetition + ").play(quant: 1); \n\n");
	}
	
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
