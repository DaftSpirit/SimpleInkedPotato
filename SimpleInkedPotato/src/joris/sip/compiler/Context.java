package joris.sip.compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import joris.sip.translator.*;

public class Context {

	private ArrayList<InstrumentPlayable> instruments;
	private ArrayList<InstrumentDef> definitions;
	private Factory factory;

	public Context() {
		this.factory = new Factory();
		this.instruments = new ArrayList<InstrumentPlayable>();
		this.definitions = new ArrayList<InstrumentDef>();
	}

	public Factory getFactory() {
		return this.factory;
	}

	public void addInstrument(InstrumentPlayable i) {
		instruments.add(i);
	}

	public ArrayList<InstrumentPlayable> getInstruments() {
		return this.instruments;
	}
	
	public void addDefinition(InstrumentDef d) {
		definitions.add(d);
	}
	
	public ArrayList<InstrumentDef> getDefinitions() {
		return this.definitions;
	}

	public void writeFile() {
		try {
			File output = new File("music.sc");
			FileWriter fw = new FileWriter(output, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("SynthDef(\\lead, { |out, amp=0.3, freq=440| \n"
					+ "\t var snd; \n"
					+ "\t snd = LFPulse.ar(freq)!2; \n"
					+ "\t snd = snd * EnvGen.ar(Env.linen(0.001, 0.1, 0.03), doneAction:2); \n"
					+ "\t OffsetOut.ar(out, snd*amp); \n" 
					+ "}).add; \n \n");

			bw.write("SynthDef(\\bass, { |freq = 440, gate = 1, amp = 0.5, slideTime = 0.17, ffreq = 1100, width = 0.15,"
					+ " detune = 1.005, preamp = 4| \n"
					+ "\t var sig, \n"
					+ "\t env = Env.adsr(0.01, 0.3, 0.4, 0.1); \n"
					+ "\t freq = Lag.kr(freq, slideTime); \n"
					+ "\t sig = Mix(VarSaw.ar([freq, freq * detune], 0, width, preamp)).distort * amp \n"
					+ "\t * EnvGen.kr(env, gate, doneAction: 2); \n"
					+ "\t sig = LPF.ar(sig, ffreq); \n"
					+ "\t Out.ar(0, sig ! 2) \n"
					+ "}).add; \n \n");

			for(InstrumentDef d : definitions) {
				d.writeNewInstrument(bw);
			}
			
			for (InstrumentPlayable i : instruments) {
				i.writeInstrument(bw);
			}
			
			System.out.println("g fini");

			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
