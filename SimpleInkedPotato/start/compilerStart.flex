%%
   
%package joris.sip.compiler
%class Lexer
%public
%line
%column
%cup

%%

"|"							{ return getSymbolFactory().newSymbol ("TERM", Sym.TERM); }
"end"						{ return getSymbolFactory().newSymbol ("END", Sym.END); }
"new"						{ return getSymbolFactory().newSymbol ("NEW", Sym.NEW); }
"("							{ return getSymbolFactory().newSymbol ("LBRACKET", Sym.LBRACKET); }
")"							{ return getSymbolFactory().newSymbol ("RBRACKET", Sym.RBRACKET); }
"triangle"					{ return getSymbolFactory().newSymbol ("TRIANGLE", Sym.TRIANGLE, yytext()); }
"saw"						{ return getSymbolFactory().newSymbol ("SAW", Sym.SAW, yytext()); }
"pulse"						{ return getSymbolFactory().newSymbol ("PULSE", Sym.PULSE, yytext()); }

[0-9]+						{ return getSymbolFactory().newSymbol ("INT", Sym.INT, Integer.parseInt(yytext())); }
[0-9]* \. [0-9]+			{ return getSymbolFactory().newSymbol ("DOUBLE", Sym.DOUBLE, Double.parseDouble(yytext())); }
[a-zA-Z][a-zA-Z0-9]*		{ return getSymbolFactory().newSymbol ("NAME", Sym.NAME, yytext()); }

[ \t\n\r]		{ }
^#.*			{ }

[^]             { throw new Error("Illegal character <"+yytext()+">"); }