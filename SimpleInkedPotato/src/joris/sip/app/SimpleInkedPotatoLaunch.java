package joris.sip.app;

import java.io.FileReader;

import java_cup.runtime.ComplexSymbolFactory;
import joris.sip.compiler.Context;
import joris.sip.compiler.Lexer;
import joris.sip.compiler.Parser;

public class SimpleInkedPotatoLaunch {

	static public void main(String argv[]) {  
		System.out.println("Lancement... Simple Inked Potato\n");
	    try {
	    	String name;
	    	if (argv.length == 1) {
	    		name = argv[0];
	    	} else {
	    		name = "test.sip";
	    	}
	    	ComplexSymbolFactory csf = new ComplexSymbolFactory ();
	    	Lexer l = new Lexer(new FileReader(name));
	    	l.setSymbolFactory(csf);
	    	Parser p = new Parser(l, csf);
	    	p.setContext(new Context());
	    	p.parse();      
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
 	}
}
