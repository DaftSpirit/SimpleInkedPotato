package joris.sip.translator;

import java.io.BufferedWriter;
import java.io.IOException;

public class InstrumentDef {

	private String name;
	private double phase;
	private String shape;
	
	public InstrumentDef(String name, String shape, double phase) {
		this.phase = phase;
		this.name = name;
		this.shape = shape;
	}

	public void writeNewInstrument(BufferedWriter bw)
			throws IOException {
		bw.write("SynthDef(\\" + this.name + ", { |out, amp=0.3, freq=440| \n"
				+ "\t var snd; \n");
		
		switch(this.shape) {
		case "triangle":
			bw.write("\t snd = LFTri(freq, 0, " + this.phase + "); \n");
			bw.write("\t snd = snd * EnvGen.ar(Env.linen(0.001, 0.1, 0.03), doneAction:2); \n"
					+ "\t OffsetOut.ar(out, snd*amp); \n"
					+ "}).add; \n \n");
			break;
		case "saw":
			bw.write("\t snd = LFSaw(freq, 0, " + this.phase + "); \n");
			bw.write("\t snd = snd * EnvGen.ar(Env.linen(0.001, 0.1, 0.03), doneAction:2); \n"
					+ "\t OffsetOut.ar(out, snd*amp); \n"
					+ "}).add; \n \n");
			break;
		case "pulse":
			bw.write("\t snd = LFPulse(freq, 0, " + this.phase + "); \n");
			bw.write("\t snd = snd * EnvGen.ar(Env.linen(0.001, 0.1, 0.03), doneAction:2); \n"
					+ "\t OffsetOut.ar(out, snd*amp); \n"
					+ "}).add; \n \n");
			break;
		case "parabol":
			bw.write("\t snd = LFPar(freq, 0, " + this.phase + "); \n");
			bw.write("\t snd = snd * EnvGen.ar(Env.linen(0.001, 0.1, 0.03), doneAction:2); \n"
					+ "\t OffsetOut.ar(out, snd*amp); \n"
					+ "}).add; \n \n");
			break;
		default:
			bw.write("\t snd = SinOsc.ar(freq, 0, 0); \n"
					+ "\t OffsetOut.ar(out, snd*amp); \n"
					+ "}).add; \n \n");
			break;
		}
	}

	public String getName() {
		return this.name;
	}

	public String getShape() {
		return shape;
	}
	
}
