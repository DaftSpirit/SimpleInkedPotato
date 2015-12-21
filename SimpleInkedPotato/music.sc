SynthDef(\lead, { |out, amp=0.3, freq=440| 
	 var snd; 
	 snd = LFPulse.ar(freq)!2; 
	 snd = snd * EnvGen.ar(Env.linen(0.001, 0.1, 0.03), doneAction:2); 
	 OffsetOut.ar(out, snd*amp); 
}).add; 
 
SynthDef(\bass, { |freq = 440, gate = 1, amp = 0.5, slideTime = 0.17, ffreq = 1100, width = 0.15, detune = 1.005, preamp = 4| 
	 var sig, 
	 env = Env.adsr(0.01, 0.3, 0.4, 0.1); 
	 freq = Lag.kr(freq, slideTime); 
	 sig = Mix(VarSaw.ar([freq, freq * detune], 0, width, preamp)).distort * amp 
	 * EnvGen.kr(env, gate, doneAction: 2); 
	 sig = LPF.ar(sig, ffreq); 
	 Out.ar(0, sig ! 2) 
}).add; 
 
Pseq([Pbind(\instrument, \lead, \midinote, Pseq([46, 52], 1), \dur, Pseq([1, 2], 1), \amp, 0.5 )],3).play(quant: 1); 

