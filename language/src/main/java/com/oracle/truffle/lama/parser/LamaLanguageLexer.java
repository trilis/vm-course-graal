// Generated from language/src/main/java/com/oracle/truffle/lama/parser/LamaLanguage.g4 by ANTLR 4.9.2
package com.oracle.truffle.lama.parser;

// DO NOT MODIFY - generated from LamaLanguage.g4 using "generate_parser.sh"

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LamaLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, WS=54, COMMENT=55, LINE_COMMENT=56, UIDENT=57, LIDENT=58, DECIMAL=59, 
		STRING=60, CHAR=61;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "T__50", "T__51", "T__52", "WS", "COMMENT", "LINE_COMMENT", 
			"UIDENT", "LIDENT", "DECIMAL", "STRING", "CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "','", "';'", "'='", "'fun'", "'('", "')'", "'{'", "'}'", 
			"':='", "':'", "'!!'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", 
			"'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'['", "']'", "'.'", "'true'", 
			"'false'", "'while'", "'do'", "'od'", "'if'", "'then'", "'fi'", "'for'", 
			"'skip'", "'case'", "'of'", "'->'", "'|'", "'esac'", "'eta'", "'elif'", 
			"'else'", "'_'", "'@'", "'#'", "'box'", "'val'", "'str'", "'array'", 
			"'sexp'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", 
			"UIDENT", "LIDENT", "DECIMAL", "STRING", "CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LamaLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LamaLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u016b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3"+
		"\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3"+
		".\3.\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\67\6\67\u0128\n\67\r\67\16\67\u0129\3\67\3\67\38\38"+
		"\38\38\78\u0132\n8\f8\168\u0135\138\38\38\38\38\38\39\39\39\39\79\u0140"+
		"\n9\f9\169\u0143\139\39\39\3:\3:\7:\u0149\n:\f:\16:\u014c\13:\3;\3;\7"+
		";\u0150\n;\f;\16;\u0153\13;\3<\6<\u0156\n<\r<\16<\u0157\3=\3=\3=\3=\7"+
		"=\u015e\n=\f=\16=\u0161\13=\3=\3=\3>\3>\3>\5>\u0168\n>\3>\3>\3\u0133\2"+
		"?\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o"+
		"9q:s;u<w=y>{?\3\2\13\5\2\13\f\16\17\"\"\4\2\f\f\17\17\3\2C\\\6\2\62;C"+
		"\\aac|\3\2c|\3\2\62;\3\2$$\3\2))\4\2\13\f))\2\u0173\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2"+
		"e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3"+
		"\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\3}\3\2\2"+
		"\2\5\u0081\3\2\2\2\7\u0083\3\2\2\2\t\u0085\3\2\2\2\13\u0087\3\2\2\2\r"+
		"\u008b\3\2\2\2\17\u008d\3\2\2\2\21\u008f\3\2\2\2\23\u0091\3\2\2\2\25\u0093"+
		"\3\2\2\2\27\u0096\3\2\2\2\31\u0098\3\2\2\2\33\u009b\3\2\2\2\35\u009e\3"+
		"\2\2\2\37\u00a1\3\2\2\2!\u00a4\3\2\2\2#\u00a6\3\2\2\2%\u00a8\3\2\2\2\'"+
		"\u00ab\3\2\2\2)\u00ae\3\2\2\2+\u00b0\3\2\2\2-\u00b2\3\2\2\2/\u00b4\3\2"+
		"\2\2\61\u00b6\3\2\2\2\63\u00b8\3\2\2\2\65\u00ba\3\2\2\2\67\u00bc\3\2\2"+
		"\29\u00be\3\2\2\2;\u00c3\3\2\2\2=\u00c9\3\2\2\2?\u00cf\3\2\2\2A\u00d2"+
		"\3\2\2\2C\u00d5\3\2\2\2E\u00d8\3\2\2\2G\u00dd\3\2\2\2I\u00e0\3\2\2\2K"+
		"\u00e4\3\2\2\2M\u00e9\3\2\2\2O\u00ee\3\2\2\2Q\u00f1\3\2\2\2S\u00f4\3\2"+
		"\2\2U\u00f6\3\2\2\2W\u00fb\3\2\2\2Y\u00ff\3\2\2\2[\u0104\3\2\2\2]\u0109"+
		"\3\2\2\2_\u010b\3\2\2\2a\u010d\3\2\2\2c\u010f\3\2\2\2e\u0113\3\2\2\2g"+
		"\u0117\3\2\2\2i\u011b\3\2\2\2k\u0121\3\2\2\2m\u0127\3\2\2\2o\u012d\3\2"+
		"\2\2q\u013b\3\2\2\2s\u0146\3\2\2\2u\u014d\3\2\2\2w\u0155\3\2\2\2y\u0159"+
		"\3\2\2\2{\u0164\3\2\2\2}~\7x\2\2~\177\7c\2\2\177\u0080\7t\2\2\u0080\4"+
		"\3\2\2\2\u0081\u0082\7.\2\2\u0082\6\3\2\2\2\u0083\u0084\7=\2\2\u0084\b"+
		"\3\2\2\2\u0085\u0086\7?\2\2\u0086\n\3\2\2\2\u0087\u0088\7h\2\2\u0088\u0089"+
		"\7w\2\2\u0089\u008a\7p\2\2\u008a\f\3\2\2\2\u008b\u008c\7*\2\2\u008c\16"+
		"\3\2\2\2\u008d\u008e\7+\2\2\u008e\20\3\2\2\2\u008f\u0090\7}\2\2\u0090"+
		"\22\3\2\2\2\u0091\u0092\7\177\2\2\u0092\24\3\2\2\2\u0093\u0094\7<\2\2"+
		"\u0094\u0095\7?\2\2\u0095\26\3\2\2\2\u0096\u0097\7<\2\2\u0097\30\3\2\2"+
		"\2\u0098\u0099\7#\2\2\u0099\u009a\7#\2\2\u009a\32\3\2\2\2\u009b\u009c"+
		"\7(\2\2\u009c\u009d\7(\2\2\u009d\34\3\2\2\2\u009e\u009f\7?\2\2\u009f\u00a0"+
		"\7?\2\2\u00a0\36\3\2\2\2\u00a1\u00a2\7#\2\2\u00a2\u00a3\7?\2\2\u00a3 "+
		"\3\2\2\2\u00a4\u00a5\7@\2\2\u00a5\"\3\2\2\2\u00a6\u00a7\7>\2\2\u00a7$"+
		"\3\2\2\2\u00a8\u00a9\7@\2\2\u00a9\u00aa\7?\2\2\u00aa&\3\2\2\2\u00ab\u00ac"+
		"\7>\2\2\u00ac\u00ad\7?\2\2\u00ad(\3\2\2\2\u00ae\u00af\7-\2\2\u00af*\3"+
		"\2\2\2\u00b0\u00b1\7/\2\2\u00b1,\3\2\2\2\u00b2\u00b3\7,\2\2\u00b3.\3\2"+
		"\2\2\u00b4\u00b5\7\61\2\2\u00b5\60\3\2\2\2\u00b6\u00b7\7\'\2\2\u00b7\62"+
		"\3\2\2\2\u00b8\u00b9\7]\2\2\u00b9\64\3\2\2\2\u00ba\u00bb\7_\2\2\u00bb"+
		"\66\3\2\2\2\u00bc\u00bd\7\60\2\2\u00bd8\3\2\2\2\u00be\u00bf\7v\2\2\u00bf"+
		"\u00c0\7t\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c2\7g\2\2\u00c2:\3\2\2\2\u00c3"+
		"\u00c4\7h\2\2\u00c4\u00c5\7c\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7u\2\2"+
		"\u00c7\u00c8\7g\2\2\u00c8<\3\2\2\2\u00c9\u00ca\7y\2\2\u00ca\u00cb\7j\2"+
		"\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7n\2\2\u00cd\u00ce\7g\2\2\u00ce>\3\2"+
		"\2\2\u00cf\u00d0\7f\2\2\u00d0\u00d1\7q\2\2\u00d1@\3\2\2\2\u00d2\u00d3"+
		"\7q\2\2\u00d3\u00d4\7f\2\2\u00d4B\3\2\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7"+
		"\7h\2\2\u00d7D\3\2\2\2\u00d8\u00d9\7v\2\2\u00d9\u00da\7j\2\2\u00da\u00db"+
		"\7g\2\2\u00db\u00dc\7p\2\2\u00dcF\3\2\2\2\u00dd\u00de\7h\2\2\u00de\u00df"+
		"\7k\2\2\u00dfH\3\2\2\2\u00e0\u00e1\7h\2\2\u00e1\u00e2\7q\2\2\u00e2\u00e3"+
		"\7t\2\2\u00e3J\3\2\2\2\u00e4\u00e5\7u\2\2\u00e5\u00e6\7m\2\2\u00e6\u00e7"+
		"\7k\2\2\u00e7\u00e8\7r\2\2\u00e8L\3\2\2\2\u00e9\u00ea\7e\2\2\u00ea\u00eb"+
		"\7c\2\2\u00eb\u00ec\7u\2\2\u00ec\u00ed\7g\2\2\u00edN\3\2\2\2\u00ee\u00ef"+
		"\7q\2\2\u00ef\u00f0\7h\2\2\u00f0P\3\2\2\2\u00f1\u00f2\7/\2\2\u00f2\u00f3"+
		"\7@\2\2\u00f3R\3\2\2\2\u00f4\u00f5\7~\2\2\u00f5T\3\2\2\2\u00f6\u00f7\7"+
		"g\2\2\u00f7\u00f8\7u\2\2\u00f8\u00f9\7c\2\2\u00f9\u00fa\7e\2\2\u00faV"+
		"\3\2\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7c\2\2\u00fe"+
		"X\3\2\2\2\u00ff\u0100\7g\2\2\u0100\u0101\7n\2\2\u0101\u0102\7k\2\2\u0102"+
		"\u0103\7h\2\2\u0103Z\3\2\2\2\u0104\u0105\7g\2\2\u0105\u0106\7n\2\2\u0106"+
		"\u0107\7u\2\2\u0107\u0108\7g\2\2\u0108\\\3\2\2\2\u0109\u010a\7a\2\2\u010a"+
		"^\3\2\2\2\u010b\u010c\7B\2\2\u010c`\3\2\2\2\u010d\u010e\7%\2\2\u010eb"+
		"\3\2\2\2\u010f\u0110\7d\2\2\u0110\u0111\7q\2\2\u0111\u0112\7z\2\2\u0112"+
		"d\3\2\2\2\u0113\u0114\7x\2\2\u0114\u0115\7c\2\2\u0115\u0116\7n\2\2\u0116"+
		"f\3\2\2\2\u0117\u0118\7u\2\2\u0118\u0119\7v\2\2\u0119\u011a\7t\2\2\u011a"+
		"h\3\2\2\2\u011b\u011c\7c\2\2\u011c\u011d\7t\2\2\u011d\u011e\7t\2\2\u011e"+
		"\u011f\7c\2\2\u011f\u0120\7{\2\2\u0120j\3\2\2\2\u0121\u0122\7u\2\2\u0122"+
		"\u0123\7g\2\2\u0123\u0124\7z\2\2\u0124\u0125\7r\2\2\u0125l\3\2\2\2\u0126"+
		"\u0128\t\2\2\2\u0127\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u0127\3\2"+
		"\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\b\67\2\2\u012c"+
		"n\3\2\2\2\u012d\u012e\7*\2\2\u012e\u012f\7,\2\2\u012f\u0133\3\2\2\2\u0130"+
		"\u0132\13\2\2\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0134\3"+
		"\2\2\2\u0133\u0131\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136"+
		"\u0137\7,\2\2\u0137\u0138\7+\2\2\u0138\u0139\3\2\2\2\u0139\u013a\b8\2"+
		"\2\u013ap\3\2\2\2\u013b\u013c\7/\2\2\u013c\u013d\7/\2\2\u013d\u0141\3"+
		"\2\2\2\u013e\u0140\n\3\2\2\u013f\u013e\3\2\2\2\u0140\u0143\3\2\2\2\u0141"+
		"\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0144\3\2\2\2\u0143\u0141\3\2"+
		"\2\2\u0144\u0145\b9\2\2\u0145r\3\2\2\2\u0146\u014a\t\4\2\2\u0147\u0149"+
		"\t\5\2\2\u0148\u0147\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014bt\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u0151\t\6\2\2"+
		"\u014e\u0150\t\5\2\2\u014f\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f"+
		"\3\2\2\2\u0151\u0152\3\2\2\2\u0152v\3\2\2\2\u0153\u0151\3\2\2\2\u0154"+
		"\u0156\t\7\2\2\u0155\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0155\3\2"+
		"\2\2\u0157\u0158\3\2\2\2\u0158x\3\2\2\2\u0159\u015f\7$\2\2\u015a\u015e"+
		"\n\b\2\2\u015b\u015c\7$\2\2\u015c\u015e\7$\2\2\u015d\u015a\3\2\2\2\u015d"+
		"\u015b\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2"+
		"\2\2\u0160\u0162\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0163\7$\2\2\u0163"+
		"z\3\2\2\2\u0164\u0167\7)\2\2\u0165\u0168\n\t\2\2\u0166\u0168\t\n\2\2\u0167"+
		"\u0165\3\2\2\2\u0167\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\7)"+
		"\2\2\u016a|\3\2\2\2\f\2\u0129\u0133\u0141\u014a\u0151\u0157\u015d\u015f"+
		"\u0167\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}