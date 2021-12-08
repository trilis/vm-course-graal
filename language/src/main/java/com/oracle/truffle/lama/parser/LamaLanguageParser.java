// Generated from language/src/main/java/com/oracle/truffle/lama/parser/LamaLanguage.g4 by ANTLR 4.9.2
package com.oracle.truffle.lama.parser;

// DO NOT MODIFY - generated from LamaLanguage.g4 using "generate_parser.sh"

import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.lama.LamaLanguage;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import com.oracle.truffle.lama.nodes.expression.LamaLongLiteralNode;
import com.oracle.truffle.lama.nodes.expression.LamaSkipNode;
import static com.oracle.truffle.lama.parser.LamaLanguageParser.LamaSyntaxCategory.*;
import com.oracle.truffle.lama.nodes.LamaRootNode;
import com.oracle.truffle.lama.nodes.patterns.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LamaLanguageParser extends Parser {
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
	public static final int
		RULE_lama = 0, RULE_scope_expression = 1, RULE_possible_expression = 2, 
		RULE_definition = 3, RULE_variable_definition = 4, RULE_variable_definition_item = 5, 
		RULE_function_definition = 6, RULE_lambda_definition = 7, RULE_function_args = 8, 
		RULE_expression = 9, RULE_binary_expression = 10, RULE_binary_expression_col = 11, 
		RULE_binary_expression_or = 12, RULE_binary_expression_and = 13, RULE_binary_expression_cmp = 14, 
		RULE_binary_expression_add = 15, RULE_binary_expression_mul = 16, RULE_postfix_expression = 17, 
		RULE_call_suffix = 18, RULE_primary = 19, RULE_else_part = 20, RULE_pattern = 21, 
		RULE_simple_pattern = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"lama", "scope_expression", "possible_expression", "definition", "variable_definition", 
			"variable_definition_item", "function_definition", "lambda_definition", 
			"function_args", "expression", "binary_expression", "binary_expression_col", 
			"binary_expression_or", "binary_expression_and", "binary_expression_cmp", 
			"binary_expression_add", "binary_expression_mul", "postfix_expression", 
			"call_suffix", "primary", "else_part", "pattern", "simple_pattern"
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

	@Override
	public String getGrammarFileName() { return "LamaLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private LamaNodeFactory factory;
	private Source source;

	private static final class BailoutErrorListener extends BaseErrorListener {
	    private final Source source;
	    BailoutErrorListener(Source source) {
	        this.source = source;
	    }
	    @Override
	    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
	        throwParseError(source, line, charPositionInLine, (Token) offendingSymbol, msg);
	    }
	}

	public void SemErr(Token token, String message) {
	    assert token != null;
	    throwParseError(source, token.getLine(), token.getCharPositionInLine(), token, message);
	}

	private static void throwParseError(Source source, int line, int charPositionInLine, Token token, String message) {
	    int col = charPositionInLine + 1;
	    String location = "-- line " + line + " col " + col + ": ";
	    int length = token == null ? 1 : Math.max(token.getStopIndex() - token.getStartIndex(), 0);
	    throw new LamaParseError(source, line, col, length, String.format("Error(s) parsing script:%n" + location + message));
	}

	public static LamaRootNode parseLama(LamaLanguage language, Source source) {
	    LamaLanguageLexer lexer = new LamaLanguageLexer(CharStreams.fromString(source.getCharacters().toString()));
	    LamaLanguageParser parser = new LamaLanguageParser(new CommonTokenStream(lexer));
	    lexer.removeErrorListeners();
	    parser.removeErrorListeners();
	    BailoutErrorListener listener = new BailoutErrorListener(source);
	    lexer.addErrorListener(listener);
	    parser.addErrorListener(listener);
	    parser.factory = new LamaNodeFactory();
	    parser.source = source;
	    return parser.lama().result;
	}

	public enum LamaSyntaxCategory {
	    VAL, VOID, REF, ERROR
	}

	public void checkCategory(LamaSyntaxCategory expected, LamaSyntaxCategory actual, Token token) {
	  if (expected != actual && !(expected == VOID && actual == VAL)) {
	    SemErr(token, "expected " + expected + ", got " + actual);
	  }
	}

	public static final class SuffixResult {
	  public SuffixResult(List<LamaExpressionNode> nodes, Token end) {
	    this.nodes = nodes;
	    this.end = end;
	  }

	  public List<LamaExpressionNode> nodes;
	  public Token end;
	}


	public LamaLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class LamaContext extends ParserRuleContext {
		public LamaRootNode result;
		public Scope_expressionContext e;
		public TerminalNode EOF() { return getToken(LamaLanguageParser.EOF, 0); }
		public Scope_expressionContext scope_expression() {
			return getRuleContext(Scope_expressionContext.class,0);
		}
		public LamaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lama; }
	}

	public final LamaContext lama() throws RecognitionException {
		LamaContext _localctx = new LamaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lama);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 factory.initialize(); 
			setState(47);
			((LamaContext)_localctx).e = scope_expression(VOID, true);
			setState(48);
			match(EOF);
			 ((LamaContext)_localctx).result = factory.finishAll(((LamaContext)_localctx).e.result); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scope_expressionContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public boolean shouldExit;
		public LamaExpressionNode result;
		public DefinitionContext d;
		public Possible_expressionContext e;
		public Possible_expressionContext possible_expression() {
			return getRuleContext(Possible_expressionContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public Scope_expressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Scope_expressionContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat, boolean shouldExit) {
			super(parent, invokingState);
			this.cat = cat;
			this.shouldExit = shouldExit;
		}
		@Override public int getRuleIndex() { return RULE_scope_expression; }
	}

	public final Scope_expressionContext scope_expression(LamaSyntaxCategory cat,boolean shouldExit) throws RecognitionException {
		Scope_expressionContext _localctx = new Scope_expressionContext(_ctx, getState(), cat, shouldExit);
		enterRule(_localctx, 2, RULE_scope_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 factory.startBlock();
			  List<LamaExpressionNode> body = new ArrayList<>(); 
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(52);
					((Scope_expressionContext)_localctx).d = definition();
					 body.addAll(((Scope_expressionContext)_localctx).d.result); 
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(60);
			((Scope_expressionContext)_localctx).e = possible_expression(cat);
			 if (((Scope_expressionContext)_localctx).e.result != null) {
			  body.add(((Scope_expressionContext)_localctx).e.result);
			}
			((Scope_expressionContext)_localctx).result =  factory.finishBlock(body,  _localctx.start.getStartIndex(), (((Scope_expressionContext)_localctx).e!=null?(((Scope_expressionContext)_localctx).e.stop):null).getStopIndex() - _localctx.start.getStartIndex() + 1, shouldExit);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Possible_expressionContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public ExpressionContext e;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Possible_expressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Possible_expressionContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_possible_expression; }
	}

	public final Possible_expressionContext possible_expression(LamaSyntaxCategory cat) throws RecognitionException {
		Possible_expressionContext _localctx = new Possible_expressionContext(_ctx, getState(), cat);
		enterRule(_localctx, 4, RULE_possible_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(63);
				((Possible_expressionContext)_localctx).e = expression(cat);
				 ((Possible_expressionContext)_localctx).result =  ((Possible_expressionContext)_localctx).e.result; 
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public List<LamaExpressionNode> result;
		public Variable_definitionContext vd;
		public Function_definitionContext fd;
		public Variable_definitionContext variable_definition() {
			return getRuleContext(Variable_definitionContext.class,0);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_definition);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				((DefinitionContext)_localctx).vd = variable_definition();
				 ((DefinitionContext)_localctx).result =  ((DefinitionContext)_localctx).vd.result; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				((DefinitionContext)_localctx).fd = function_definition();
				 ((DefinitionContext)_localctx).result =  new ArrayList<>(); _localctx.result.add(((DefinitionContext)_localctx).fd.result); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_definitionContext extends ParserRuleContext {
		public List<LamaExpressionNode> result;
		public Variable_definition_itemContext v1;
		public Variable_definition_itemContext v2;
		public List<Variable_definition_itemContext> variable_definition_item() {
			return getRuleContexts(Variable_definition_itemContext.class);
		}
		public Variable_definition_itemContext variable_definition_item(int i) {
			return getRuleContext(Variable_definition_itemContext.class,i);
		}
		public Variable_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definition; }
	}

	public final Variable_definitionContext variable_definition() throws RecognitionException {
		Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variable_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Variable_definitionContext)_localctx).result =  new ArrayList<>(); 
			setState(77);
			match(T__0);
			setState(78);
			((Variable_definitionContext)_localctx).v1 = variable_definition_item();
			 if (((Variable_definitionContext)_localctx).v1.result != null) { _localctx.result.add(((Variable_definitionContext)_localctx).v1.result); } 
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(80);
				match(T__1);
				setState(81);
				((Variable_definitionContext)_localctx).v2 = variable_definition_item();
				 if (((Variable_definitionContext)_localctx).v2.result != null) { _localctx.result.add(((Variable_definitionContext)_localctx).v2.result); } 
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_definition_itemContext extends ParserRuleContext {
		public LamaExpressionNode result;
		public Token v;
		public Binary_expressionContext e;
		public TerminalNode LIDENT() { return getToken(LamaLanguageParser.LIDENT, 0); }
		public Binary_expressionContext binary_expression() {
			return getRuleContext(Binary_expressionContext.class,0);
		}
		public Variable_definition_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definition_item; }
	}

	public final Variable_definition_itemContext variable_definition_item() throws RecognitionException {
		Variable_definition_itemContext _localctx = new Variable_definition_itemContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variable_definition_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			((Variable_definition_itemContext)_localctx).v = match(LIDENT);
			 factory.registerVariable(((Variable_definition_itemContext)_localctx).v.getText()); 
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(93);
				match(T__3);
				setState(94);
				((Variable_definition_itemContext)_localctx).e = binary_expression(VAL);
				 ((Variable_definition_itemContext)_localctx).result =  factory.createAssignment(factory.createStringLiteral(((Variable_definition_itemContext)_localctx).v, false), ((Variable_definition_itemContext)_localctx).e.result); 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_definitionContext extends ParserRuleContext {
		public LamaExpressionNode result;
		public Token name;
		public Token br;
		public Function_argsContext args;
		public Scope_expressionContext body;
		public TerminalNode LIDENT() { return getToken(LamaLanguageParser.LIDENT, 0); }
		public Function_argsContext function_args() {
			return getRuleContext(Function_argsContext.class,0);
		}
		public Scope_expressionContext scope_expression() {
			return getRuleContext(Scope_expressionContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__4);
			setState(100);
			((Function_definitionContext)_localctx).name = match(LIDENT);
			setState(101);
			((Function_definitionContext)_localctx).br = match(T__5);
			 factory.startBlock(); 
			setState(103);
			((Function_definitionContext)_localctx).args = function_args();
			setState(104);
			match(T__6);
			setState(105);
			match(T__7);
			setState(106);
			((Function_definitionContext)_localctx).body = scope_expression(VOID, true);
			setState(107);
			match(T__8);
			 ((Function_definitionContext)_localctx).result =  factory.createFunction(((Function_definitionContext)_localctx).name.getText(), ((Function_definitionContext)_localctx).args.result, ((Function_definitionContext)_localctx).body.result, ((Function_definitionContext)_localctx).br); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lambda_definitionContext extends ParserRuleContext {
		public LamaExpressionNode result;
		public Token br;
		public Function_argsContext args;
		public Scope_expressionContext body;
		public Function_argsContext function_args() {
			return getRuleContext(Function_argsContext.class,0);
		}
		public Scope_expressionContext scope_expression() {
			return getRuleContext(Scope_expressionContext.class,0);
		}
		public Lambda_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_definition; }
	}

	public final Lambda_definitionContext lambda_definition() throws RecognitionException {
		Lambda_definitionContext _localctx = new Lambda_definitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lambda_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			((Lambda_definitionContext)_localctx).br = match(T__5);
			 factory.startBlock(); 
			setState(112);
			((Lambda_definitionContext)_localctx).args = function_args();
			setState(113);
			match(T__6);
			setState(114);
			match(T__7);
			setState(115);
			((Lambda_definitionContext)_localctx).body = scope_expression(VOID, true);
			setState(116);
			match(T__8);
			 ((Lambda_definitionContext)_localctx).result =  factory.createLambda(((Lambda_definitionContext)_localctx).args.result, ((Lambda_definitionContext)_localctx).body.result, ((Lambda_definitionContext)_localctx).br); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_argsContext extends ParserRuleContext {
		public List<LamaPatternNode> result;
		public PatternContext p;
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public Function_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_args; }
	}

	public final Function_argsContext function_args() throws RecognitionException {
		Function_argsContext _localctx = new Function_argsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Function_argsContext)_localctx).result =  new ArrayList<>(); 
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__20) | (1L << T__24) | (1L << T__27) | (1L << T__28) | (1L << T__45) | (1L << T__47) | (1L << UIDENT) | (1L << LIDENT) | (1L << DECIMAL) | (1L << STRING) | (1L << CHAR))) != 0)) {
				{
				setState(120);
				((Function_argsContext)_localctx).p = pattern();
				 _localctx.result.add(((Function_argsContext)_localctx).p.result); 
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(122);
					match(T__1);
					setState(123);
					((Function_argsContext)_localctx).p = pattern();
					 _localctx.result.add(((Function_argsContext)_localctx).p.result); 
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public Binary_expressionContext e;
		public Binary_expressionContext f;
		public List<Binary_expressionContext> binary_expression() {
			return getRuleContexts(Binary_expressionContext.class);
		}
		public Binary_expressionContext binary_expression(int i) {
			return getRuleContext(Binary_expressionContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression(LamaSyntaxCategory cat) throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState(), cat);
		enterRule(_localctx, 18, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 List<LamaExpressionNode> body = new ArrayList<>();
			  int end = 0; 
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(134);
					((ExpressionContext)_localctx).e = binary_expression(VOID);
					 body.add(((ExpressionContext)_localctx).e.result);
					                      end = (((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.stop):null).getStopIndex(); 
					setState(136);
					match(T__2);
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(143);
			((ExpressionContext)_localctx).f = binary_expression(cat);
			 body.add(((ExpressionContext)_localctx).f.result);
			                      end = (((ExpressionContext)_localctx).f!=null?(((ExpressionContext)_localctx).f.stop):null).getStopIndex(); 
			 ((ExpressionContext)_localctx).result =  factory.finishBlock(body, _localctx.start.getStartIndex(), end - _localctx.start.getStartIndex() + 1, false); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_expressionContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public Binary_expression_colContext e;
		public Binary_expression_colContext e1;
		public List<Binary_expression_colContext> binary_expression_col() {
			return getRuleContexts(Binary_expression_colContext.class);
		}
		public Binary_expression_colContext binary_expression_col(int i) {
			return getRuleContext(Binary_expression_colContext.class,i);
		}
		public Binary_expressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Binary_expressionContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_binary_expression; }
	}

	public final Binary_expressionContext binary_expression(LamaSyntaxCategory cat) throws RecognitionException {
		Binary_expressionContext _localctx = new Binary_expressionContext(_ctx, getState(), cat);
		enterRule(_localctx, 20, RULE_binary_expression);
		try {
			int _alt;
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 List<LamaExpressionNode> refs = new ArrayList<>(); 
				setState(152); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(148);
						((Binary_expressionContext)_localctx).e = binary_expression_col(REF);
						setState(149);
						match(T__9);
						 refs.add(((Binary_expressionContext)_localctx).e.result); 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(154); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(156);
				((Binary_expressionContext)_localctx).e1 = binary_expression_col(VAL);

				  ((Binary_expressionContext)_localctx).result =  factory.createAssignments(refs, ((Binary_expressionContext)_localctx).e1.result);
				  checkCategory(cat, VAL, (((Binary_expressionContext)_localctx).e1!=null?(((Binary_expressionContext)_localctx).e1.start):null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				((Binary_expressionContext)_localctx).e = binary_expression_col(cat);
				 ((Binary_expressionContext)_localctx).result =  ((Binary_expressionContext)_localctx).e.result; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_expression_colContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public Binary_expression_orContext e1;
		public Binary_expression_orContext base;
		public Binary_expression_orContext e;
		public List<Binary_expression_orContext> binary_expression_or() {
			return getRuleContexts(Binary_expression_orContext.class);
		}
		public Binary_expression_orContext binary_expression_or(int i) {
			return getRuleContext(Binary_expression_orContext.class,i);
		}
		public Binary_expression_colContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Binary_expression_colContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_binary_expression_col; }
	}

	public final Binary_expression_colContext binary_expression_col(LamaSyntaxCategory cat) throws RecognitionException {
		Binary_expression_colContext _localctx = new Binary_expression_colContext(_ctx, getState(), cat);
		enterRule(_localctx, 22, RULE_binary_expression_col);
		try {
			int _alt;
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 List<LamaExpressionNode> args = new ArrayList<>(); 
				setState(169); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(165);
						((Binary_expression_colContext)_localctx).e1 = binary_expression_or(VAL);
						setState(166);
						match(T__10);
						args.add(((Binary_expression_colContext)_localctx).e1.result); 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(171); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(173);
				((Binary_expression_colContext)_localctx).base = binary_expression_or(VAL);
				 ((Binary_expression_colContext)_localctx).result =  factory.createList(((Binary_expression_colContext)_localctx).base.result, args);
				  checkCategory(cat, VAL, (((Binary_expression_colContext)_localctx).base!=null?(((Binary_expression_colContext)_localctx).base.start):null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				((Binary_expression_colContext)_localctx).e = binary_expression_or(cat);
				 ((Binary_expression_colContext)_localctx).result =  ((Binary_expression_colContext)_localctx).e.result; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_expression_orContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public Binary_expression_andContext e1;
		public Token op;
		public Binary_expression_andContext e2;
		public Binary_expression_andContext e;
		public List<Binary_expression_andContext> binary_expression_and() {
			return getRuleContexts(Binary_expression_andContext.class);
		}
		public Binary_expression_andContext binary_expression_and(int i) {
			return getRuleContext(Binary_expression_andContext.class,i);
		}
		public Binary_expression_orContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Binary_expression_orContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_binary_expression_or; }
	}

	public final Binary_expression_orContext binary_expression_or(LamaSyntaxCategory cat) throws RecognitionException {
		Binary_expression_orContext _localctx = new Binary_expression_orContext(_ctx, getState(), cat);
		enterRule(_localctx, 24, RULE_binary_expression_or);
		try {
			int _alt;
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				((Binary_expression_orContext)_localctx).e1 = binary_expression_and(VAL);
				 ((Binary_expression_orContext)_localctx).result =  ((Binary_expression_orContext)_localctx).e1.result; checkCategory(cat, VAL, (((Binary_expression_orContext)_localctx).e1!=null?(((Binary_expression_orContext)_localctx).e1.start):null)); 
				setState(187); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(183);
						((Binary_expression_orContext)_localctx).op = match(T__11);
						setState(184);
						((Binary_expression_orContext)_localctx).e2 = binary_expression_and(VAL);
						 ((Binary_expression_orContext)_localctx).result =  factory.createBinary(((Binary_expression_orContext)_localctx).op, _localctx.result, ((Binary_expression_orContext)_localctx).e2.result); 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(189); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				((Binary_expression_orContext)_localctx).e = binary_expression_and(cat);
				 ((Binary_expression_orContext)_localctx).result =  ((Binary_expression_orContext)_localctx).e.result; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_expression_andContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public Binary_expression_cmpContext e1;
		public Token op;
		public Binary_expression_cmpContext e2;
		public Binary_expression_cmpContext e;
		public List<Binary_expression_cmpContext> binary_expression_cmp() {
			return getRuleContexts(Binary_expression_cmpContext.class);
		}
		public Binary_expression_cmpContext binary_expression_cmp(int i) {
			return getRuleContext(Binary_expression_cmpContext.class,i);
		}
		public Binary_expression_andContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Binary_expression_andContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_binary_expression_and; }
	}

	public final Binary_expression_andContext binary_expression_and(LamaSyntaxCategory cat) throws RecognitionException {
		Binary_expression_andContext _localctx = new Binary_expression_andContext(_ctx, getState(), cat);
		enterRule(_localctx, 26, RULE_binary_expression_and);
		try {
			int _alt;
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				((Binary_expression_andContext)_localctx).e1 = binary_expression_cmp(VAL);
				((Binary_expression_andContext)_localctx).result =  ((Binary_expression_andContext)_localctx).e1.result; checkCategory(cat, VAL, (((Binary_expression_andContext)_localctx).e1!=null?(((Binary_expression_andContext)_localctx).e1.start):null)); 
				setState(202); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(198);
						((Binary_expression_andContext)_localctx).op = match(T__12);
						setState(199);
						((Binary_expression_andContext)_localctx).e2 = binary_expression_cmp(VAL);
						 ((Binary_expression_andContext)_localctx).result =  factory.createBinary(((Binary_expression_andContext)_localctx).op, _localctx.result, ((Binary_expression_andContext)_localctx).e2.result); 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(204); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				((Binary_expression_andContext)_localctx).e = binary_expression_cmp(cat);
				 ((Binary_expression_andContext)_localctx).result =  ((Binary_expression_andContext)_localctx).e.result; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_expression_cmpContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public Binary_expression_addContext e1;
		public Token op;
		public Binary_expression_addContext e2;
		public Binary_expression_addContext e;
		public List<Binary_expression_addContext> binary_expression_add() {
			return getRuleContexts(Binary_expression_addContext.class);
		}
		public Binary_expression_addContext binary_expression_add(int i) {
			return getRuleContext(Binary_expression_addContext.class,i);
		}
		public Binary_expression_cmpContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Binary_expression_cmpContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_binary_expression_cmp; }
	}

	public final Binary_expression_cmpContext binary_expression_cmp(LamaSyntaxCategory cat) throws RecognitionException {
		Binary_expression_cmpContext _localctx = new Binary_expression_cmpContext(_ctx, getState(), cat);
		enterRule(_localctx, 28, RULE_binary_expression_cmp);
		int _la;
		try {
			int _alt;
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				((Binary_expression_cmpContext)_localctx).e1 = binary_expression_add(VAL);
				((Binary_expression_cmpContext)_localctx).result =  ((Binary_expression_cmpContext)_localctx).e1.result; checkCategory(cat, VAL, (((Binary_expression_cmpContext)_localctx).e1!=null?(((Binary_expression_cmpContext)_localctx).e1.start):null)); 
				setState(217); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(213);
						((Binary_expression_cmpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((Binary_expression_cmpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(214);
						((Binary_expression_cmpContext)_localctx).e2 = binary_expression_add(VAL);
						 ((Binary_expression_cmpContext)_localctx).result =  factory.createBinary(((Binary_expression_cmpContext)_localctx).op, _localctx.result, ((Binary_expression_cmpContext)_localctx).e2.result); 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(219); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				((Binary_expression_cmpContext)_localctx).e = binary_expression_add(cat);
				 ((Binary_expression_cmpContext)_localctx).result =  ((Binary_expression_cmpContext)_localctx).e.result; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_expression_addContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public Binary_expression_mulContext e1;
		public Token op;
		public Binary_expression_mulContext e2;
		public Binary_expression_mulContext e;
		public List<Binary_expression_mulContext> binary_expression_mul() {
			return getRuleContexts(Binary_expression_mulContext.class);
		}
		public Binary_expression_mulContext binary_expression_mul(int i) {
			return getRuleContext(Binary_expression_mulContext.class,i);
		}
		public Binary_expression_addContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Binary_expression_addContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_binary_expression_add; }
	}

	public final Binary_expression_addContext binary_expression_add(LamaSyntaxCategory cat) throws RecognitionException {
		Binary_expression_addContext _localctx = new Binary_expression_addContext(_ctx, getState(), cat);
		enterRule(_localctx, 30, RULE_binary_expression_add);
		int _la;
		try {
			int _alt;
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				((Binary_expression_addContext)_localctx).e1 = binary_expression_mul(VAL);
				((Binary_expression_addContext)_localctx).result =  ((Binary_expression_addContext)_localctx).e1.result; checkCategory(cat, VAL, (((Binary_expression_addContext)_localctx).e1!=null?(((Binary_expression_addContext)_localctx).e1.start):null)); 
				setState(232); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(228);
						((Binary_expression_addContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((Binary_expression_addContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(229);
						((Binary_expression_addContext)_localctx).e2 = binary_expression_mul(VAL);
						 ((Binary_expression_addContext)_localctx).result =  factory.createBinary(((Binary_expression_addContext)_localctx).op, _localctx.result, ((Binary_expression_addContext)_localctx).e2.result); 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(234); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				((Binary_expression_addContext)_localctx).e = binary_expression_mul(cat);
				 ((Binary_expression_addContext)_localctx).result =  ((Binary_expression_addContext)_localctx).e.result; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_expression_mulContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public Postfix_expressionContext e1;
		public Token op;
		public Postfix_expressionContext e2;
		public Postfix_expressionContext e;
		public List<Postfix_expressionContext> postfix_expression() {
			return getRuleContexts(Postfix_expressionContext.class);
		}
		public Postfix_expressionContext postfix_expression(int i) {
			return getRuleContext(Postfix_expressionContext.class,i);
		}
		public Binary_expression_mulContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Binary_expression_mulContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_binary_expression_mul; }
	}

	public final Binary_expression_mulContext binary_expression_mul(LamaSyntaxCategory cat) throws RecognitionException {
		Binary_expression_mulContext _localctx = new Binary_expression_mulContext(_ctx, getState(), cat);
		enterRule(_localctx, 32, RULE_binary_expression_mul);
		int _la;
		try {
			int _alt;
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				((Binary_expression_mulContext)_localctx).e1 = postfix_expression(VAL);
				((Binary_expression_mulContext)_localctx).result =  ((Binary_expression_mulContext)_localctx).e1.result; checkCategory(cat, VAL, (((Binary_expression_mulContext)_localctx).e1!=null?(((Binary_expression_mulContext)_localctx).e1.start):null)); 
				setState(247); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(243);
						((Binary_expression_mulContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
							((Binary_expression_mulContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(244);
						((Binary_expression_mulContext)_localctx).e2 = postfix_expression(VAL);
						 ((Binary_expression_mulContext)_localctx).result =  factory.createBinary(((Binary_expression_mulContext)_localctx).op, _localctx.result, ((Binary_expression_mulContext)_localctx).e2.result); 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(249); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				((Binary_expression_mulContext)_localctx).e = postfix_expression(cat);
				 ((Binary_expression_mulContext)_localctx).result =  ((Binary_expression_mulContext)_localctx).e.result; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Postfix_expressionContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public PrimaryContext e;
		public Call_suffixContext s;
		public ExpressionContext ind;
		public Token LIDENT;
		public Call_suffixContext suf;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<TerminalNode> LIDENT() { return getTokens(LamaLanguageParser.LIDENT); }
		public TerminalNode LIDENT(int i) {
			return getToken(LamaLanguageParser.LIDENT, i);
		}
		public List<Call_suffixContext> call_suffix() {
			return getRuleContexts(Call_suffixContext.class);
		}
		public Call_suffixContext call_suffix(int i) {
			return getRuleContext(Call_suffixContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
	}

	public final Postfix_expressionContext postfix_expression(LamaSyntaxCategory cat) throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState(), cat);
		enterRule(_localctx, 34, RULE_postfix_expression);
		try {
			int _alt;
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				((Postfix_expressionContext)_localctx).e = primary(cat);
				 ((Postfix_expressionContext)_localctx).result =  ((Postfix_expressionContext)_localctx).e.result; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				((Postfix_expressionContext)_localctx).e = primary(cat);
				 ((Postfix_expressionContext)_localctx).result =  ((Postfix_expressionContext)_localctx).e.result; 
				setState(278); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(278);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__5:
							{
							setState(261);
							((Postfix_expressionContext)_localctx).s = call_suffix();

							      ((Postfix_expressionContext)_localctx).result =  factory.createCall(_localctx.result, ((Postfix_expressionContext)_localctx).s.result.nodes, ((Postfix_expressionContext)_localctx).s.result.end);
							      checkCategory(cat, VAL, (((Postfix_expressionContext)_localctx).e!=null?(((Postfix_expressionContext)_localctx).e.start):null));
							  
							}
							break;
						case T__24:
							{
							setState(264);
							match(T__24);
							setState(265);
							((Postfix_expressionContext)_localctx).ind = expression(VAL);
							setState(266);
							match(T__25);

							      if (cat == VAL || cat == VOID) {
							        ((Postfix_expressionContext)_localctx).result =  factory.createElem(_localctx.result, ((Postfix_expressionContext)_localctx).ind.result);
							      } else {
							        ((Postfix_expressionContext)_localctx).result =  factory.createElemRef(_localctx.result, ((Postfix_expressionContext)_localctx).ind.result);
							      }
							  
							}
							break;
						case T__26:
							{
							setState(269);
							match(T__26);
							setState(270);
							((Postfix_expressionContext)_localctx).LIDENT = match(LIDENT);
							 List<LamaExpressionNode> parameters = new ArrayList<>(); parameters.add(_localctx.result); Token end = ((Postfix_expressionContext)_localctx).LIDENT; 
							setState(275);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
							case 1:
								{
								setState(272);
								((Postfix_expressionContext)_localctx).suf = call_suffix();
								 parameters.addAll(((Postfix_expressionContext)_localctx).suf.result.nodes); end = ((Postfix_expressionContext)_localctx).suf.result.end; 
								}
								break;
							}
							 ((Postfix_expressionContext)_localctx).result =  factory.createCall(factory.createRead(factory.createStringLiteral(((Postfix_expressionContext)_localctx).LIDENT, false)), parameters, end); 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(280); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_suffixContext extends ParserRuleContext {
		public SuffixResult result;
		public ExpressionContext expression;
		public Token end;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Call_suffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_suffix; }
	}

	public final Call_suffixContext call_suffix() throws RecognitionException {
		Call_suffixContext _localctx = new Call_suffixContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_call_suffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(T__5);
			 List<LamaExpressionNode> parameters = new ArrayList<>(); 
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__20) | (1L << T__24) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__42) | (1L << UIDENT) | (1L << LIDENT) | (1L << DECIMAL) | (1L << STRING) | (1L << CHAR))) != 0)) {
				{
				setState(286);
				((Call_suffixContext)_localctx).expression = expression(VAL);
				 parameters.add(((Call_suffixContext)_localctx).expression.result); 
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(288);
					match(T__1);
					setState(289);
					((Call_suffixContext)_localctx).expression = expression(VAL);
					 parameters.add(((Call_suffixContext)_localctx).expression.result); 
					}
					}
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(299);
			((Call_suffixContext)_localctx).end = match(T__6);
			 ((Call_suffixContext)_localctx).result =  new SuffixResult(parameters, ((Call_suffixContext)_localctx).end); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public Token DECIMAL;
		public Token m;
		public Token STRING;
		public Token CHAR;
		public Token LIDENT;
		public Token t;
		public Token f;
		public Scope_expressionContext e;
		public Token w;
		public ExpressionContext cond;
		public Scope_expressionContext body;
		public Token i;
		public Else_partContext el;
		public Scope_expressionContext init;
		public ExpressionContext inc;
		public Token s;
		public Token c;
		public ExpressionContext scr;
		public PatternContext p;
		public Token cons;
		public ExpressionContext ex;
		public Lambda_definitionContext l;
		public Binary_expressionContext fun;
		public TerminalNode DECIMAL() { return getToken(LamaLanguageParser.DECIMAL, 0); }
		public TerminalNode STRING() { return getToken(LamaLanguageParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(LamaLanguageParser.CHAR, 0); }
		public TerminalNode LIDENT() { return getToken(LamaLanguageParser.LIDENT, 0); }
		public List<Scope_expressionContext> scope_expression() {
			return getRuleContexts(Scope_expressionContext.class);
		}
		public Scope_expressionContext scope_expression(int i) {
			return getRuleContext(Scope_expressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Else_partContext else_part() {
			return getRuleContext(Else_partContext.class,0);
		}
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public TerminalNode UIDENT() { return getToken(LamaLanguageParser.UIDENT, 0); }
		public Lambda_definitionContext lambda_definition() {
			return getRuleContext(Lambda_definitionContext.class,0);
		}
		public Binary_expressionContext binary_expression() {
			return getRuleContext(Binary_expressionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PrimaryContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary(LamaSyntaxCategory cat) throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState(), cat);
		enterRule(_localctx, 38, RULE_primary);
		int _la;
		try {
			setState(448);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				((PrimaryContext)_localctx).DECIMAL = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createNumericLiteral(((PrimaryContext)_localctx).DECIMAL, 1); checkCategory(cat, VAL, ((PrimaryContext)_localctx).DECIMAL); 
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				((PrimaryContext)_localctx).m = match(T__20);
				setState(305);
				((PrimaryContext)_localctx).DECIMAL = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createNumericLiteral(((PrimaryContext)_localctx).DECIMAL, -1); checkCategory(cat, VAL, ((PrimaryContext)_localctx).m); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(307);
				((PrimaryContext)_localctx).STRING = match(STRING);
				 ((PrimaryContext)_localctx).result =  factory.createStringLiteral(((PrimaryContext)_localctx).STRING, true); checkCategory(cat, VAL, ((PrimaryContext)_localctx).STRING); 
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(309);
				((PrimaryContext)_localctx).CHAR = match(CHAR);
				 ((PrimaryContext)_localctx).result =  factory.createCharLiteral(((PrimaryContext)_localctx).CHAR); checkCategory(cat, VAL, ((PrimaryContext)_localctx).CHAR); 
				}
				break;
			case LIDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(311);
				((PrimaryContext)_localctx).LIDENT = match(LIDENT);
				 if (cat == VAL || cat == VOID) {
				          ((PrimaryContext)_localctx).result =  factory.createRead(factory.createStringLiteral(((PrimaryContext)_localctx).LIDENT, false));
				         } else {
				          ((PrimaryContext)_localctx).result =  factory.createReference(factory.createStringLiteral(((PrimaryContext)_localctx).LIDENT, false));
				         } 
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 6);
				{
				setState(313);
				((PrimaryContext)_localctx).t = match(T__27);
				 ((PrimaryContext)_localctx).result =  new LamaLongLiteralNode(1); checkCategory(cat, VAL, ((PrimaryContext)_localctx).t);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 7);
				{
				setState(315);
				((PrimaryContext)_localctx).f = match(T__28);
				 ((PrimaryContext)_localctx).result =  new LamaLongLiteralNode(0); checkCategory(cat, VAL, ((PrimaryContext)_localctx).f);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 8);
				{
				setState(317);
				match(T__5);
				setState(318);
				((PrimaryContext)_localctx).e = scope_expression(cat, true);
				setState(319);
				match(T__6);
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).e.result; 
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 9);
				{
				setState(322);
				((PrimaryContext)_localctx).w = match(T__29);
				setState(323);
				((PrimaryContext)_localctx).cond = expression(VAL);
				setState(324);
				match(T__30);
				setState(325);
				((PrimaryContext)_localctx).body = scope_expression(VOID, true);
				setState(326);
				match(T__31);
				 ((PrimaryContext)_localctx).result =  factory.createWhile(((PrimaryContext)_localctx).w, ((PrimaryContext)_localctx).cond.result, ((PrimaryContext)_localctx).body.result);
				  checkCategory(cat, VOID, ((PrimaryContext)_localctx).w); 
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 10);
				{
				setState(329);
				((PrimaryContext)_localctx).i = match(T__32);
				LamaExpressionNode elsePart = null; 
				setState(331);
				((PrimaryContext)_localctx).cond = expression(VAL);
				setState(332);
				match(T__33);
				setState(333);
				((PrimaryContext)_localctx).body = scope_expression(cat, true);
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__43 || _la==T__44) {
					{
					setState(334);
					((PrimaryContext)_localctx).el = else_part(cat);
					elsePart = ((PrimaryContext)_localctx).el.result; 
					}
				}

				setState(339);
				match(T__34);
				 ((PrimaryContext)_localctx).result =  factory.createIf(((PrimaryContext)_localctx).i, ((PrimaryContext)_localctx).cond.result, ((PrimaryContext)_localctx).body.result, elsePart); 
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 11);
				{
				setState(342);
				((PrimaryContext)_localctx).w = match(T__30);
				setState(343);
				((PrimaryContext)_localctx).body = scope_expression(VOID, false);
				setState(344);
				match(T__29);
				setState(345);
				((PrimaryContext)_localctx).cond = expression(VAL);
				setState(346);
				match(T__31);
				 ((PrimaryContext)_localctx).result =  factory.createDoWhile(((PrimaryContext)_localctx).w, ((PrimaryContext)_localctx).cond.result, ((PrimaryContext)_localctx).body.result);
				  checkCategory(cat, VOID, ((PrimaryContext)_localctx).w); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 12);
				{
				setState(349);
				((PrimaryContext)_localctx).f = match(T__35);
				setState(350);
				((PrimaryContext)_localctx).init = scope_expression(VOID, false);
				setState(351);
				match(T__1);
				setState(352);
				((PrimaryContext)_localctx).cond = expression(VAL);
				setState(353);
				match(T__1);
				setState(354);
				((PrimaryContext)_localctx).inc = expression(VOID);
				setState(355);
				match(T__30);
				setState(356);
				((PrimaryContext)_localctx).body = scope_expression(VOID, true);
				setState(357);
				match(T__31);

				  ((PrimaryContext)_localctx).result =  factory.createFor(((PrimaryContext)_localctx).f, ((PrimaryContext)_localctx).init.result, ((PrimaryContext)_localctx).cond.result, ((PrimaryContext)_localctx).inc.result, ((PrimaryContext)_localctx).body.result);
				  checkCategory(cat, VOID, ((PrimaryContext)_localctx).f);

				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 13);
				{
				setState(360);
				((PrimaryContext)_localctx).s = match(T__36);
				 ((PrimaryContext)_localctx).result =  new LamaSkipNode(); checkCategory(cat, VOID, ((PrimaryContext)_localctx).s); 
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 14);
				{
				setState(362);
				((PrimaryContext)_localctx).c = match(T__37);
				setState(363);
				((PrimaryContext)_localctx).scr = expression(VAL);
				setState(364);
				match(T__38);
				 List<LamaPatternNode> patterns = new ArrayList<>();
				                                    List<LamaExpressionNode> branches = new ArrayList<>();
				                                    factory.startBlock(); 
				setState(366);
				((PrimaryContext)_localctx).p = pattern();
				 patterns.add(((PrimaryContext)_localctx).p.result); 
				setState(368);
				match(T__39);
				setState(369);
				((PrimaryContext)_localctx).e = scope_expression(cat, true);
				 branches.add(((PrimaryContext)_localctx).e.result); factory.endScope(); 
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__40) {
					{
					{
					setState(371);
					match(T__40);
					 factory.startBlock(); 
					setState(373);
					((PrimaryContext)_localctx).p = pattern();
					 patterns.add(((PrimaryContext)_localctx).p.result); 
					setState(375);
					match(T__39);
					setState(376);
					((PrimaryContext)_localctx).e = scope_expression(cat, true);
					 branches.add(((PrimaryContext)_localctx).e.result); factory.endScope(); 
					}
					}
					setState(383);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(384);
				match(T__41);
				 ((PrimaryContext)_localctx).result =  factory.createCase(((PrimaryContext)_localctx).scr.result, patterns, branches); 
				}
				break;
			case UIDENT:
				enterOuterAlt(_localctx, 15);
				{
				setState(387);
				((PrimaryContext)_localctx).cons = match(UIDENT);
				 List<LamaExpressionNode> args = new ArrayList<>(); 
				setState(403);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(389);
					match(T__5);
					setState(390);
					((PrimaryContext)_localctx).ex = expression(VAL);
					 args.add(((PrimaryContext)_localctx).ex.result); 
					setState(398);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(392);
						match(T__1);
						setState(393);
						((PrimaryContext)_localctx).ex = expression(VAL);
						 args.add(((PrimaryContext)_localctx).ex.result); 
						}
						}
						setState(400);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(401);
					match(T__6);
					}
					break;
				}
				 ((PrimaryContext)_localctx).result =  factory.createSexp(((PrimaryContext)_localctx).cons.getText(), args); checkCategory(cat, VAL, ((PrimaryContext)_localctx).cons); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 16);
				{
				setState(406);
				((PrimaryContext)_localctx).c = match(T__7);
				 List<LamaExpressionNode> args = new ArrayList<>(); 
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__20) | (1L << T__24) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__42) | (1L << UIDENT) | (1L << LIDENT) | (1L << DECIMAL) | (1L << STRING) | (1L << CHAR))) != 0)) {
					{
					setState(408);
					((PrimaryContext)_localctx).ex = expression(VAL);
					 args.add(((PrimaryContext)_localctx).ex.result); 
					setState(416);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(410);
						match(T__1);
						setState(411);
						((PrimaryContext)_localctx).ex = expression(VAL);
						 args.add(((PrimaryContext)_localctx).ex.result); 
						}
						}
						setState(418);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(421);
				match(T__8);
				 ((PrimaryContext)_localctx).result =  factory.createList(new LamaLongLiteralNode(0), args);
				         checkCategory(cat, VAL, ((PrimaryContext)_localctx).c); 
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 17);
				{
				setState(423);
				((PrimaryContext)_localctx).c = match(T__24);
				 List<LamaExpressionNode> args = new ArrayList<>(); 
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__20) | (1L << T__24) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__42) | (1L << UIDENT) | (1L << LIDENT) | (1L << DECIMAL) | (1L << STRING) | (1L << CHAR))) != 0)) {
					{
					setState(425);
					((PrimaryContext)_localctx).ex = expression(VAL);
					 args.add(((PrimaryContext)_localctx).ex.result); 
					setState(433);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(427);
						match(T__1);
						setState(428);
						((PrimaryContext)_localctx).ex = expression(VAL);
						 args.add(((PrimaryContext)_localctx).ex.result); 
						}
						}
						setState(435);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(438);
				match(T__25);
				 ((PrimaryContext)_localctx).result =  factory.createArray(args); checkCategory(cat, VAL, ((PrimaryContext)_localctx).c); 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 18);
				{
				setState(440);
				((PrimaryContext)_localctx).f = match(T__4);
				setState(441);
				((PrimaryContext)_localctx).l = lambda_definition();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).l.result; checkCategory(cat, VAL, ((PrimaryContext)_localctx).f); 
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 19);
				{
				setState(444);
				match(T__42);
				setState(445);
				((PrimaryContext)_localctx).fun = binary_expression(VOID);
				 ((PrimaryContext)_localctx).result =  factory.createEta(((PrimaryContext)_localctx).fun.result); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_partContext extends ParserRuleContext {
		public LamaSyntaxCategory cat;
		public LamaExpressionNode result;
		public Token i;
		public ExpressionContext cond;
		public Scope_expressionContext body;
		public Else_partContext el;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Scope_expressionContext scope_expression() {
			return getRuleContext(Scope_expressionContext.class,0);
		}
		public Else_partContext else_part() {
			return getRuleContext(Else_partContext.class,0);
		}
		public Else_partContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Else_partContext(ParserRuleContext parent, int invokingState, LamaSyntaxCategory cat) {
			super(parent, invokingState);
			this.cat = cat;
		}
		@Override public int getRuleIndex() { return RULE_else_part; }
	}

	public final Else_partContext else_part(LamaSyntaxCategory cat) throws RecognitionException {
		Else_partContext _localctx = new Else_partContext(_ctx, getState(), cat);
		enterRule(_localctx, 40, RULE_else_part);
		int _la;
		try {
			setState(466);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__43:
				enterOuterAlt(_localctx, 1);
				{
				 LamaExpressionNode elsePart = null; 
				setState(451);
				((Else_partContext)_localctx).i = match(T__43);
				setState(452);
				((Else_partContext)_localctx).cond = expression(VAL);
				setState(453);
				match(T__33);
				setState(454);
				((Else_partContext)_localctx).body = scope_expression(cat, true);
				setState(458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__43 || _la==T__44) {
					{
					setState(455);
					((Else_partContext)_localctx).el = else_part(cat);
					 elsePart = ((Else_partContext)_localctx).el.result; 
					}
				}

				 ((Else_partContext)_localctx).result =  factory.createIf(((Else_partContext)_localctx).i, ((Else_partContext)_localctx).cond.result, ((Else_partContext)_localctx).body.result, elsePart); 
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 2);
				{
				setState(462);
				match(T__44);
				setState(463);
				((Else_partContext)_localctx).body = scope_expression(cat, true);
				 ((Else_partContext)_localctx).result =  ((Else_partContext)_localctx).body.result; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternContext extends ParserRuleContext {
		public LamaPatternNode result;
		public Simple_patternContext p;
		public List<Simple_patternContext> simple_pattern() {
			return getRuleContexts(Simple_patternContext.class);
		}
		public Simple_patternContext simple_pattern(int i) {
			return getRuleContext(Simple_patternContext.class,i);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_pattern);
		try {
			int _alt;
			setState(483);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(468);
				((PatternContext)_localctx).p = simple_pattern();
				 ((PatternContext)_localctx).result =  ((PatternContext)_localctx).p.result; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				List<LamaPatternNode> subpatterns = new ArrayList<>(); 
				setState(476); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(472);
						((PatternContext)_localctx).p = simple_pattern();
						setState(473);
						match(T__10);
						 subpatterns.add(((PatternContext)_localctx).p.result); 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(478); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(480);
				((PatternContext)_localctx).p = simple_pattern();
				 ((PatternContext)_localctx).result =  factory.createConsPattern(((PatternContext)_localctx).p.result, subpatterns); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_patternContext extends ParserRuleContext {
		public LamaPatternNode result;
		public Token UIDENT;
		public PatternContext p;
		public Token LIDENT;
		public Token DECIMAL;
		public Token STRING;
		public Token CHAR;
		public PatternContext pattern;
		public TerminalNode UIDENT() { return getToken(LamaLanguageParser.UIDENT, 0); }
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public TerminalNode LIDENT() { return getToken(LamaLanguageParser.LIDENT, 0); }
		public TerminalNode DECIMAL() { return getToken(LamaLanguageParser.DECIMAL, 0); }
		public TerminalNode STRING() { return getToken(LamaLanguageParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(LamaLanguageParser.CHAR, 0); }
		public Simple_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_pattern; }
	}

	public final Simple_patternContext simple_pattern() throws RecognitionException {
		Simple_patternContext _localctx = new Simple_patternContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_simple_pattern);
		int _la;
		try {
			setState(585);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(485);
				match(T__45);
				 ((Simple_patternContext)_localctx).result =  new LamaSkipPatternNode(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(487);
				((Simple_patternContext)_localctx).UIDENT = match(UIDENT);
				 List<LamaPatternNode> subpatterns = new ArrayList<>(); 
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(489);
					match(T__5);
					setState(490);
					((Simple_patternContext)_localctx).p = pattern();
					 subpatterns.add(((Simple_patternContext)_localctx).p.result); 
					setState(498);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(492);
						match(T__1);
						setState(493);
						((Simple_patternContext)_localctx).p = pattern();
						 subpatterns.add(((Simple_patternContext)_localctx).p.result); 
						}
						}
						setState(500);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(501);
					match(T__6);
					}
				}

				 ((Simple_patternContext)_localctx).result =  factory.createSexpPattern(((Simple_patternContext)_localctx).UIDENT.getText(), subpatterns); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(506);
				match(T__24);
				List<LamaPatternNode> subpatterns = new ArrayList<>(); 
				setState(519);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__20) | (1L << T__24) | (1L << T__27) | (1L << T__28) | (1L << T__45) | (1L << T__47) | (1L << UIDENT) | (1L << LIDENT) | (1L << DECIMAL) | (1L << STRING) | (1L << CHAR))) != 0)) {
					{
					setState(508);
					((Simple_patternContext)_localctx).p = pattern();
					 subpatterns.add(((Simple_patternContext)_localctx).p.result); 
					setState(516);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(510);
						match(T__1);
						setState(511);
						((Simple_patternContext)_localctx).p = pattern();
						 subpatterns.add(((Simple_patternContext)_localctx).p.result); 
						}
						}
						setState(518);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(521);
				match(T__25);
				 ((Simple_patternContext)_localctx).result =  factory.createArrayPattern(subpatterns); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(523);
				match(T__7);
				List<LamaPatternNode> subpatterns = new ArrayList<>(); 
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__20) | (1L << T__24) | (1L << T__27) | (1L << T__28) | (1L << T__45) | (1L << T__47) | (1L << UIDENT) | (1L << LIDENT) | (1L << DECIMAL) | (1L << STRING) | (1L << CHAR))) != 0)) {
					{
					setState(525);
					((Simple_patternContext)_localctx).p = pattern();
					 subpatterns.add(((Simple_patternContext)_localctx).p.result); 
					setState(533);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(527);
						match(T__1);
						setState(528);
						((Simple_patternContext)_localctx).p = pattern();
						 subpatterns.add(((Simple_patternContext)_localctx).p.result); 
						}
						}
						setState(535);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(538);
				match(T__8);
				 ((Simple_patternContext)_localctx).result =  factory.createConsPattern(LamaIntegerPatternNodeGen.create(0), subpatterns); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(540);
				((Simple_patternContext)_localctx).LIDENT = match(LIDENT);
				 LamaPatternNode pat = new LamaSkipPatternNode(); 
				setState(546);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__46) {
					{
					setState(542);
					match(T__46);
					setState(543);
					((Simple_patternContext)_localctx).p = pattern();
					 pat = ((Simple_patternContext)_localctx).p.result; 
					}
				}

				 ((Simple_patternContext)_localctx).result =  factory.createNamedPattern(((Simple_patternContext)_localctx).LIDENT.getText(), pat); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(549);
				match(T__27);
				 ((Simple_patternContext)_localctx).result =  LamaTruePatternNodeGen.create(); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(551);
				match(T__28);
				 ((Simple_patternContext)_localctx).result =  LamaFalsePatternNodeGen.create(); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(553);
				match(T__20);
				setState(554);
				((Simple_patternContext)_localctx).DECIMAL = match(DECIMAL);
				 ((Simple_patternContext)_localctx).result =  LamaIntegerPatternNodeGen.create(-Long.parseLong(((Simple_patternContext)_localctx).DECIMAL.getText())); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(556);
				((Simple_patternContext)_localctx).DECIMAL = match(DECIMAL);
				 ((Simple_patternContext)_localctx).result =  LamaIntegerPatternNodeGen.create(Long.parseLong(((Simple_patternContext)_localctx).DECIMAL.getText())); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(558);
				((Simple_patternContext)_localctx).STRING = match(STRING);
				 ((Simple_patternContext)_localctx).result =  LamaStringPatternNodeGen.create(factory.trim(((Simple_patternContext)_localctx).STRING.getText(), "\"")); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(560);
				((Simple_patternContext)_localctx).CHAR = match(CHAR);
				 ((Simple_patternContext)_localctx).result =  LamaIntegerPatternNodeGen.create(factory.parseChar(((Simple_patternContext)_localctx).CHAR)); 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(562);
				match(T__47);
				setState(563);
				match(T__48);
				 ((Simple_patternContext)_localctx).result =  LamaBoxKindPatternNodeGen.create(); 
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(565);
				match(T__47);
				setState(566);
				match(T__49);
				 ((Simple_patternContext)_localctx).result =  LamaValKindPatternNodeGen.create(); 
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(568);
				match(T__47);
				setState(569);
				match(T__50);
				 ((Simple_patternContext)_localctx).result =  LamaStringKindPatternNodeGen.create(); 
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(571);
				match(T__47);
				setState(572);
				match(T__51);
				 ((Simple_patternContext)_localctx).result =  LamaArrayKindPatternNodeGen.create(); 
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(574);
				match(T__47);
				setState(575);
				match(T__52);
				 ((Simple_patternContext)_localctx).result =  LamaSexpKindPatternNodeGen.create(); 
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(577);
				match(T__47);
				setState(578);
				match(T__4);
				 ((Simple_patternContext)_localctx).result =  LamaFunctionKindPatternNodeGen.create(); 
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(580);
				match(T__5);
				setState(581);
				((Simple_patternContext)_localctx).pattern = pattern();
				setState(582);
				match(T__6);
				 ((Simple_patternContext)_localctx).result =  ((Simple_patternContext)_localctx).pattern.result; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u024e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\5\4E\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5M\n\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7d"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0081\n\n\f\n\16\n\u0084"+
		"\13\n\5\n\u0086\n\n\3\13\3\13\3\13\3\13\3\13\7\13\u008d\n\13\f\13\16\13"+
		"\u0090\13\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\6\f\u009b\n\f\r\f"+
		"\16\f\u009c\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a5\n\f\3\r\3\r\3\r\3\r\3\r"+
		"\6\r\u00ac\n\r\r\r\16\r\u00ad\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b6\n\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\6\16\u00be\n\16\r\16\16\16\u00bf\3\16\3\16"+
		"\3\16\5\16\u00c5\n\16\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u00cd\n\17\r"+
		"\17\16\17\u00ce\3\17\3\17\3\17\5\17\u00d4\n\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\6\20\u00dc\n\20\r\20\16\20\u00dd\3\20\3\20\3\20\5\20\u00e3\n\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\6\21\u00eb\n\21\r\21\16\21\u00ec\3\21\3"+
		"\21\3\21\5\21\u00f2\n\21\3\22\3\22\3\22\3\22\3\22\3\22\6\22\u00fa\n\22"+
		"\r\22\16\22\u00fb\3\22\3\22\3\22\5\22\u0101\n\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\5\23\u0116\n\23\3\23\6\23\u0119\n\23\r\23\16\23\u011a\5\23\u011d\n"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0127\n\24\f\24\16\24"+
		"\u012a\13\24\5\24\u012c\n\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\5\25\u0154\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\7\25\u017e\n\25\f\25\16\25\u0181\13\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u018f\n\25\f\25\16"+
		"\25\u0192\13\25\3\25\3\25\5\25\u0196\n\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\7\25\u01a1\n\25\f\25\16\25\u01a4\13\25\5\25\u01a6\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u01b2\n\25\f\25"+
		"\16\25\u01b5\13\25\5\25\u01b7\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u01c3\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u01cd\n\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01d5\n\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\6\27\u01df\n\27\r\27\16\27\u01e0\3\27"+
		"\3\27\3\27\5\27\u01e6\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\7\30\u01f3\n\30\f\30\16\30\u01f6\13\30\3\30\3\30\5\30\u01fa"+
		"\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0205\n\30\f\30"+
		"\16\30\u0208\13\30\5\30\u020a\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\7\30\u0216\n\30\f\30\16\30\u0219\13\30\5\30\u021b\n\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0225\n\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u024c\n\30\3\30\2\2\31\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\5\3\2\20\25\3\2\26\27\3\2\30\32"+
		"\2\u0289\2\60\3\2\2\2\4\65\3\2\2\2\6D\3\2\2\2\bL\3\2\2\2\nN\3\2\2\2\f"+
		"]\3\2\2\2\16e\3\2\2\2\20p\3\2\2\2\22y\3\2\2\2\24\u0087\3\2\2\2\26\u00a4"+
		"\3\2\2\2\30\u00b5\3\2\2\2\32\u00c4\3\2\2\2\34\u00d3\3\2\2\2\36\u00e2\3"+
		"\2\2\2 \u00f1\3\2\2\2\"\u0100\3\2\2\2$\u011c\3\2\2\2&\u011e\3\2\2\2(\u01c2"+
		"\3\2\2\2*\u01d4\3\2\2\2,\u01e5\3\2\2\2.\u024b\3\2\2\2\60\61\b\2\1\2\61"+
		"\62\5\4\3\2\62\63\7\2\2\3\63\64\b\2\1\2\64\3\3\2\2\2\65;\b\3\1\2\66\67"+
		"\5\b\5\2\678\b\3\1\28:\3\2\2\29\66\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2"+
		"\2<>\3\2\2\2=;\3\2\2\2>?\5\6\4\2?@\b\3\1\2@\5\3\2\2\2AB\5\24\13\2BC\b"+
		"\4\1\2CE\3\2\2\2DA\3\2\2\2DE\3\2\2\2E\7\3\2\2\2FG\5\n\6\2GH\b\5\1\2HM"+
		"\3\2\2\2IJ\5\16\b\2JK\b\5\1\2KM\3\2\2\2LF\3\2\2\2LI\3\2\2\2M\t\3\2\2\2"+
		"NO\b\6\1\2OP\7\3\2\2PQ\5\f\7\2QX\b\6\1\2RS\7\4\2\2ST\5\f\7\2TU\b\6\1\2"+
		"UW\3\2\2\2VR\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2"+
		"[\\\7\5\2\2\\\13\3\2\2\2]^\7<\2\2^c\b\7\1\2_`\7\6\2\2`a\5\26\f\2ab\b\7"+
		"\1\2bd\3\2\2\2c_\3\2\2\2cd\3\2\2\2d\r\3\2\2\2ef\7\7\2\2fg\7<\2\2gh\7\b"+
		"\2\2hi\b\b\1\2ij\5\22\n\2jk\7\t\2\2kl\7\n\2\2lm\5\4\3\2mn\7\13\2\2no\b"+
		"\b\1\2o\17\3\2\2\2pq\7\b\2\2qr\b\t\1\2rs\5\22\n\2st\7\t\2\2tu\7\n\2\2"+
		"uv\5\4\3\2vw\7\13\2\2wx\b\t\1\2x\21\3\2\2\2y\u0085\b\n\1\2z{\5,\27\2{"+
		"\u0082\b\n\1\2|}\7\4\2\2}~\5,\27\2~\177\b\n\1\2\177\u0081\3\2\2\2\u0080"+
		"|\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2"+
		"\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0085z\3\2\2\2\u0085\u0086\3"+
		"\2\2\2\u0086\23\3\2\2\2\u0087\u008e\b\13\1\2\u0088\u0089\5\26\f\2\u0089"+
		"\u008a\b\13\1\2\u008a\u008b\7\5\2\2\u008b\u008d\3\2\2\2\u008c\u0088\3"+
		"\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\5\26\f\2\u0092\u0093\b"+
		"\13\1\2\u0093\u0094\b\13\1\2\u0094\25\3\2\2\2\u0095\u009a\b\f\1\2\u0096"+
		"\u0097\5\30\r\2\u0097\u0098\7\f\2\2\u0098\u0099\b\f\1\2\u0099\u009b\3"+
		"\2\2\2\u009a\u0096\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\5\30\r\2\u009f\u00a0\b"+
		"\f\1\2\u00a0\u00a5\3\2\2\2\u00a1\u00a2\5\30\r\2\u00a2\u00a3\b\f\1\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u0095\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a5\27\3\2\2"+
		"\2\u00a6\u00ab\b\r\1\2\u00a7\u00a8\5\32\16\2\u00a8\u00a9\7\r\2\2\u00a9"+
		"\u00aa\b\r\1\2\u00aa\u00ac\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b0\5\32\16\2\u00b0\u00b1\b\r\1\2\u00b1\u00b6\3\2\2\2\u00b2\u00b3\5"+
		"\32\16\2\u00b3\u00b4\b\r\1\2\u00b4\u00b6\3\2\2\2\u00b5\u00a6\3\2\2\2\u00b5"+
		"\u00b2\3\2\2\2\u00b6\31\3\2\2\2\u00b7\u00b8\5\34\17\2\u00b8\u00bd\b\16"+
		"\1\2\u00b9\u00ba\7\16\2\2\u00ba\u00bb\5\34\17\2\u00bb\u00bc\b\16\1\2\u00bc"+
		"\u00be\3\2\2\2\u00bd\u00b9\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c5\3\2\2\2\u00c1\u00c2\5\34\17\2\u00c2"+
		"\u00c3\b\16\1\2\u00c3\u00c5\3\2\2\2\u00c4\u00b7\3\2\2\2\u00c4\u00c1\3"+
		"\2\2\2\u00c5\33\3\2\2\2\u00c6\u00c7\5\36\20\2\u00c7\u00cc\b\17\1\2\u00c8"+
		"\u00c9\7\17\2\2\u00c9\u00ca\5\36\20\2\u00ca\u00cb\b\17\1\2\u00cb\u00cd"+
		"\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d4\3\2\2\2\u00d0\u00d1\5\36\20\2\u00d1\u00d2\b"+
		"\17\1\2\u00d2\u00d4\3\2\2\2\u00d3\u00c6\3\2\2\2\u00d3\u00d0\3\2\2\2\u00d4"+
		"\35\3\2\2\2\u00d5\u00d6\5 \21\2\u00d6\u00db\b\20\1\2\u00d7\u00d8\t\2\2"+
		"\2\u00d8\u00d9\5 \21\2\u00d9\u00da\b\20\1\2\u00da\u00dc\3\2\2\2\u00db"+
		"\u00d7\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de\u00e3\3\2\2\2\u00df\u00e0\5 \21\2\u00e0\u00e1\b\20\1\2\u00e1"+
		"\u00e3\3\2\2\2\u00e2\u00d5\3\2\2\2\u00e2\u00df\3\2\2\2\u00e3\37\3\2\2"+
		"\2\u00e4\u00e5\5\"\22\2\u00e5\u00ea\b\21\1\2\u00e6\u00e7\t\3\2\2\u00e7"+
		"\u00e8\5\"\22\2\u00e8\u00e9\b\21\1\2\u00e9\u00eb\3\2\2\2\u00ea\u00e6\3"+
		"\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00f2\3\2\2\2\u00ee\u00ef\5\"\22\2\u00ef\u00f0\b\21\1\2\u00f0\u00f2\3"+
		"\2\2\2\u00f1\u00e4\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f2!\3\2\2\2\u00f3\u00f4"+
		"\5$\23\2\u00f4\u00f9\b\22\1\2\u00f5\u00f6\t\4\2\2\u00f6\u00f7\5$\23\2"+
		"\u00f7\u00f8\b\22\1\2\u00f8\u00fa\3\2\2\2\u00f9\u00f5\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u0101\3\2\2\2\u00fd"+
		"\u00fe\5$\23\2\u00fe\u00ff\b\22\1\2\u00ff\u0101\3\2\2\2\u0100\u00f3\3"+
		"\2\2\2\u0100\u00fd\3\2\2\2\u0101#\3\2\2\2\u0102\u0103\5(\25\2\u0103\u0104"+
		"\b\23\1\2\u0104\u011d\3\2\2\2\u0105\u0106\5(\25\2\u0106\u0118\b\23\1\2"+
		"\u0107\u0108\5&\24\2\u0108\u0109\b\23\1\2\u0109\u0119\3\2\2\2\u010a\u010b"+
		"\7\33\2\2\u010b\u010c\5\24\13\2\u010c\u010d\7\34\2\2\u010d\u010e\b\23"+
		"\1\2\u010e\u0119\3\2\2\2\u010f\u0110\7\35\2\2\u0110\u0111\7<\2\2\u0111"+
		"\u0115\b\23\1\2\u0112\u0113\5&\24\2\u0113\u0114\b\23\1\2\u0114\u0116\3"+
		"\2\2\2\u0115\u0112\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u0119\b\23\1\2\u0118\u0107\3\2\2\2\u0118\u010a\3\2\2\2\u0118\u010f\3"+
		"\2\2\2\u0119\u011a\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011d\3\2\2\2\u011c\u0102\3\2\2\2\u011c\u0105\3\2\2\2\u011d%\3\2\2\2"+
		"\u011e\u011f\7\b\2\2\u011f\u012b\b\24\1\2\u0120\u0121\5\24\13\2\u0121"+
		"\u0128\b\24\1\2\u0122\u0123\7\4\2\2\u0123\u0124\5\24\13\2\u0124\u0125"+
		"\b\24\1\2\u0125\u0127\3\2\2\2\u0126\u0122\3\2\2\2\u0127\u012a\3\2\2\2"+
		"\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128"+
		"\3\2\2\2\u012b\u0120\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012e\7\t\2\2\u012e\u012f\b\24\1\2\u012f\'\3\2\2\2\u0130\u0131\7=\2\2"+
		"\u0131\u01c3\b\25\1\2\u0132\u0133\7\27\2\2\u0133\u0134\7=\2\2\u0134\u01c3"+
		"\b\25\1\2\u0135\u0136\7>\2\2\u0136\u01c3\b\25\1\2\u0137\u0138\7?\2\2\u0138"+
		"\u01c3\b\25\1\2\u0139\u013a\7<\2\2\u013a\u01c3\b\25\1\2\u013b\u013c\7"+
		"\36\2\2\u013c\u01c3\b\25\1\2\u013d\u013e\7\37\2\2\u013e\u01c3\b\25\1\2"+
		"\u013f\u0140\7\b\2\2\u0140\u0141\5\4\3\2\u0141\u0142\7\t\2\2\u0142\u0143"+
		"\b\25\1\2\u0143\u01c3\3\2\2\2\u0144\u0145\7 \2\2\u0145\u0146\5\24\13\2"+
		"\u0146\u0147\7!\2\2\u0147\u0148\5\4\3\2\u0148\u0149\7\"\2\2\u0149\u014a"+
		"\b\25\1\2\u014a\u01c3\3\2\2\2\u014b\u014c\7#\2\2\u014c\u014d\b\25\1\2"+
		"\u014d\u014e\5\24\13\2\u014e\u014f\7$\2\2\u014f\u0153\5\4\3\2\u0150\u0151"+
		"\5*\26\2\u0151\u0152\b\25\1\2\u0152\u0154\3\2\2\2\u0153\u0150\3\2\2\2"+
		"\u0153\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\7%\2\2\u0156\u0157"+
		"\b\25\1\2\u0157\u01c3\3\2\2\2\u0158\u0159\7!\2\2\u0159\u015a\5\4\3\2\u015a"+
		"\u015b\7 \2\2\u015b\u015c\5\24\13\2\u015c\u015d\7\"\2\2\u015d\u015e\b"+
		"\25\1\2\u015e\u01c3\3\2\2\2\u015f\u0160\7&\2\2\u0160\u0161\5\4\3\2\u0161"+
		"\u0162\7\4\2\2\u0162\u0163\5\24\13\2\u0163\u0164\7\4\2\2\u0164\u0165\5"+
		"\24\13\2\u0165\u0166\7!\2\2\u0166\u0167\5\4\3\2\u0167\u0168\7\"\2\2\u0168"+
		"\u0169\b\25\1\2\u0169\u01c3\3\2\2\2\u016a\u016b\7\'\2\2\u016b\u01c3\b"+
		"\25\1\2\u016c\u016d\7(\2\2\u016d\u016e\5\24\13\2\u016e\u016f\7)\2\2\u016f"+
		"\u0170\b\25\1\2\u0170\u0171\5,\27\2\u0171\u0172\b\25\1\2\u0172\u0173\7"+
		"*\2\2\u0173\u0174\5\4\3\2\u0174\u017f\b\25\1\2\u0175\u0176\7+\2\2\u0176"+
		"\u0177\b\25\1\2\u0177\u0178\5,\27\2\u0178\u0179\b\25\1\2\u0179\u017a\7"+
		"*\2\2\u017a\u017b\5\4\3\2\u017b\u017c\b\25\1\2\u017c\u017e\3\2\2\2\u017d"+
		"\u0175\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2"+
		"\2\2\u0180\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\7,\2\2\u0183"+
		"\u0184\b\25\1\2\u0184\u01c3\3\2\2\2\u0185\u0186\7;\2\2\u0186\u0195\b\25"+
		"\1\2\u0187\u0188\7\b\2\2\u0188\u0189\5\24\13\2\u0189\u0190\b\25\1\2\u018a"+
		"\u018b\7\4\2\2\u018b\u018c\5\24\13\2\u018c\u018d\b\25\1\2\u018d\u018f"+
		"\3\2\2\2\u018e\u018a\3\2\2\2\u018f\u0192\3\2\2\2\u0190\u018e\3\2\2\2\u0190"+
		"\u0191\3\2\2\2\u0191\u0193\3\2\2\2\u0192\u0190\3\2\2\2\u0193\u0194\7\t"+
		"\2\2\u0194\u0196\3\2\2\2\u0195\u0187\3\2\2\2\u0195\u0196\3\2\2\2\u0196"+
		"\u0197\3\2\2\2\u0197\u01c3\b\25\1\2\u0198\u0199\7\n\2\2\u0199\u01a5\b"+
		"\25\1\2\u019a\u019b\5\24\13\2\u019b\u01a2\b\25\1\2\u019c\u019d\7\4\2\2"+
		"\u019d\u019e\5\24\13\2\u019e\u019f\b\25\1\2\u019f\u01a1\3\2\2\2\u01a0"+
		"\u019c\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2"+
		"\2\2\u01a3\u01a6\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u019a\3\2\2\2\u01a5"+
		"\u01a6\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\7\13\2\2\u01a8\u01c3\b"+
		"\25\1\2\u01a9\u01aa\7\33\2\2\u01aa\u01b6\b\25\1\2\u01ab\u01ac\5\24\13"+
		"\2\u01ac\u01b3\b\25\1\2\u01ad\u01ae\7\4\2\2\u01ae\u01af\5\24\13\2\u01af"+
		"\u01b0\b\25\1\2\u01b0\u01b2\3\2\2\2\u01b1\u01ad\3\2\2\2\u01b2\u01b5\3"+
		"\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5"+
		"\u01b3\3\2\2\2\u01b6\u01ab\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\3\2"+
		"\2\2\u01b8\u01b9\7\34\2\2\u01b9\u01c3\b\25\1\2\u01ba\u01bb\7\7\2\2\u01bb"+
		"\u01bc\5\20\t\2\u01bc\u01bd\b\25\1\2\u01bd\u01c3\3\2\2\2\u01be\u01bf\7"+
		"-\2\2\u01bf\u01c0\5\26\f\2\u01c0\u01c1\b\25\1\2\u01c1\u01c3\3\2\2\2\u01c2"+
		"\u0130\3\2\2\2\u01c2\u0132\3\2\2\2\u01c2\u0135\3\2\2\2\u01c2\u0137\3\2"+
		"\2\2\u01c2\u0139\3\2\2\2\u01c2\u013b\3\2\2\2\u01c2\u013d\3\2\2\2\u01c2"+
		"\u013f\3\2\2\2\u01c2\u0144\3\2\2\2\u01c2\u014b\3\2\2\2\u01c2\u0158\3\2"+
		"\2\2\u01c2\u015f\3\2\2\2\u01c2\u016a\3\2\2\2\u01c2\u016c\3\2\2\2\u01c2"+
		"\u0185\3\2\2\2\u01c2\u0198\3\2\2\2\u01c2\u01a9\3\2\2\2\u01c2\u01ba\3\2"+
		"\2\2\u01c2\u01be\3\2\2\2\u01c3)\3\2\2\2\u01c4\u01c5\b\26\1\2\u01c5\u01c6"+
		"\7.\2\2\u01c6\u01c7\5\24\13\2\u01c7\u01c8\7$\2\2\u01c8\u01cc\5\4\3\2\u01c9"+
		"\u01ca\5*\26\2\u01ca\u01cb\b\26\1\2\u01cb\u01cd\3\2\2\2\u01cc\u01c9\3"+
		"\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\b\26\1\2\u01cf"+
		"\u01d5\3\2\2\2\u01d0\u01d1\7/\2\2\u01d1\u01d2\5\4\3\2\u01d2\u01d3\b\26"+
		"\1\2\u01d3\u01d5\3\2\2\2\u01d4\u01c4\3\2\2\2\u01d4\u01d0\3\2\2\2\u01d5"+
		"+\3\2\2\2\u01d6\u01d7\5.\30\2\u01d7\u01d8\b\27\1\2\u01d8\u01e6\3\2\2\2"+
		"\u01d9\u01de\b\27\1\2\u01da\u01db\5.\30\2\u01db\u01dc\7\r\2\2\u01dc\u01dd"+
		"\b\27\1\2\u01dd\u01df\3\2\2\2\u01de\u01da\3\2\2\2\u01df\u01e0\3\2\2\2"+
		"\u01e0\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3"+
		"\5.\30\2\u01e3\u01e4\b\27\1\2\u01e4\u01e6\3\2\2\2\u01e5\u01d6\3\2\2\2"+
		"\u01e5\u01d9\3\2\2\2\u01e6-\3\2\2\2\u01e7\u01e8\7\60\2\2\u01e8\u024c\b"+
		"\30\1\2\u01e9\u01ea\7;\2\2\u01ea\u01f9\b\30\1\2\u01eb\u01ec\7\b\2\2\u01ec"+
		"\u01ed\5,\27\2\u01ed\u01f4\b\30\1\2\u01ee\u01ef\7\4\2\2\u01ef\u01f0\5"+
		",\27\2\u01f0\u01f1\b\30\1\2\u01f1\u01f3\3\2\2\2\u01f2\u01ee\3\2\2\2\u01f3"+
		"\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f7\3\2"+
		"\2\2\u01f6\u01f4\3\2\2\2\u01f7\u01f8\7\t\2\2\u01f8\u01fa\3\2\2\2\u01f9"+
		"\u01eb\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u024c\b\30"+
		"\1\2\u01fc\u01fd\7\33\2\2\u01fd\u0209\b\30\1\2\u01fe\u01ff\5,\27\2\u01ff"+
		"\u0206\b\30\1\2\u0200\u0201\7\4\2\2\u0201\u0202\5,\27\2\u0202\u0203\b"+
		"\30\1\2\u0203\u0205\3\2\2\2\u0204\u0200\3\2\2\2\u0205\u0208\3\2\2\2\u0206"+
		"\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u020a\3\2\2\2\u0208\u0206\3\2"+
		"\2\2\u0209\u01fe\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\3\2\2\2\u020b"+
		"\u020c\7\34\2\2\u020c\u024c\b\30\1\2\u020d\u020e\7\n\2\2\u020e\u021a\b"+
		"\30\1\2\u020f\u0210\5,\27\2\u0210\u0217\b\30\1\2\u0211\u0212\7\4\2\2\u0212"+
		"\u0213\5,\27\2\u0213\u0214\b\30\1\2\u0214\u0216\3\2\2\2\u0215\u0211\3"+
		"\2\2\2\u0216\u0219\3\2\2\2\u0217\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218"+
		"\u021b\3\2\2\2\u0219\u0217\3\2\2\2\u021a\u020f\3\2\2\2\u021a\u021b\3\2"+
		"\2\2\u021b\u021c\3\2\2\2\u021c\u021d\7\13\2\2\u021d\u024c\b\30\1\2\u021e"+
		"\u021f\7<\2\2\u021f\u0224\b\30\1\2\u0220\u0221\7\61\2\2\u0221\u0222\5"+
		",\27\2\u0222\u0223\b\30\1\2\u0223\u0225\3\2\2\2\u0224\u0220\3\2\2\2\u0224"+
		"\u0225\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u024c\b\30\1\2\u0227\u0228\7"+
		"\36\2\2\u0228\u024c\b\30\1\2\u0229\u022a\7\37\2\2\u022a\u024c\b\30\1\2"+
		"\u022b\u022c\7\27\2\2\u022c\u022d\7=\2\2\u022d\u024c\b\30\1\2\u022e\u022f"+
		"\7=\2\2\u022f\u024c\b\30\1\2\u0230\u0231\7>\2\2\u0231\u024c\b\30\1\2\u0232"+
		"\u0233\7?\2\2\u0233\u024c\b\30\1\2\u0234\u0235\7\62\2\2\u0235\u0236\7"+
		"\63\2\2\u0236\u024c\b\30\1\2\u0237\u0238\7\62\2\2\u0238\u0239\7\64\2\2"+
		"\u0239\u024c\b\30\1\2\u023a\u023b\7\62\2\2\u023b\u023c\7\65\2\2\u023c"+
		"\u024c\b\30\1\2\u023d\u023e\7\62\2\2\u023e\u023f\7\66\2\2\u023f\u024c"+
		"\b\30\1\2\u0240\u0241\7\62\2\2\u0241\u0242\7\67\2\2\u0242\u024c\b\30\1"+
		"\2\u0243\u0244\7\62\2\2\u0244\u0245\7\7\2\2\u0245\u024c\b\30\1\2\u0246"+
		"\u0247\7\b\2\2\u0247\u0248\5,\27\2\u0248\u0249\7\t\2\2\u0249\u024a\b\30"+
		"\1\2\u024a\u024c\3\2\2\2\u024b\u01e7\3\2\2\2\u024b\u01e9\3\2\2\2\u024b"+
		"\u01fc\3\2\2\2\u024b\u020d\3\2\2\2\u024b\u021e\3\2\2\2\u024b\u0227\3\2"+
		"\2\2\u024b\u0229\3\2\2\2\u024b\u022b\3\2\2\2\u024b\u022e\3\2\2\2\u024b"+
		"\u0230\3\2\2\2\u024b\u0232\3\2\2\2\u024b\u0234\3\2\2\2\u024b\u0237\3\2"+
		"\2\2\u024b\u023a\3\2\2\2\u024b\u023d\3\2\2\2\u024b\u0240\3\2\2\2\u024b"+
		"\u0243\3\2\2\2\u024b\u0246\3\2\2\2\u024c/\3\2\2\2\63;DLXc\u0082\u0085"+
		"\u008e\u009c\u00a4\u00ad\u00b5\u00bf\u00c4\u00ce\u00d3\u00dd\u00e2\u00ec"+
		"\u00f1\u00fb\u0100\u0115\u0118\u011a\u011c\u0128\u012b\u0153\u017f\u0190"+
		"\u0195\u01a2\u01a5\u01b3\u01b6\u01c2\u01cc\u01d4\u01e0\u01e5\u01f4\u01f9"+
		"\u0206\u0209\u0217\u021a\u0224\u024b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}