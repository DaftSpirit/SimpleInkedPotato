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

[0-9]+						{ return getSymbolFactory().newSymbol ("INT", Sym.INT, Integer.parseInt(yytext())); }
[a-zA-Z][a-zA-Z0-9]*		{ return getSymbolFactory().newSymbol ("NAME", Sym.NAME, yytext()); }

[ \t\n\r]		{ }
^#.*			{ }

[^]             { throw new Error("Illegal character <"+yytext()+">"); }