package joris.sip.translator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BassSynth extends Instrument {

	public BassSynth(String name, ArrayList<Integer> notes,
			ArrayList<Integer> durations, int repetition) {
		this.name = name;
		this.notes = notes;
		this.durations = durations;
		this.repetition = repetition;
	}

	@Override
	public void writeInstrument(BufferedWriter bw) throws IOException {
		bw.write("Pseq([Pbind(\\instrument, \\bass, "
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

}
