// Generated from C:/Users/Ruke/IntelliJ/vrj\vrj.g4 by ANTLR 4.5.3
package ruke.vrj.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class vrjParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

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
		T__45=46, T__46=47, STRING=48, REAL=49, INT=50, NL=51, ID=52, WS=53, COMMENT=54, 
		LINE_COMMENT=55;
	public static final int
		RULE_init = 0, RULE_name = 1, RULE_type = 2, RULE_param = 3, RULE_paramList = 4, 
		RULE_typeDefinition = 5, RULE_functionSignature = 6, RULE_nativeDefinition = 7, 
		RULE_arguments = 8, RULE_functionExpression = 9, RULE_variableExpression = 10, 
		RULE_expression = 11, RULE_expressionList = 12, RULE_variableStatement = 13, 
		RULE_globalDefinition = 14, RULE_loopStatement = 15, RULE_elseIfStatement = 16, 
		RULE_elseStatement = 17, RULE_ifStatement = 18, RULE_statement = 19, RULE_statements = 20, 
		RULE_functionDefinition = 21;
	public static final String[] ruleNames = {
		"init", "name", "type", "param", "paramList", "typeDefinition", "functionSignature", 
		"nativeDefinition", "arguments", "functionExpression", "variableExpression", 
		"expression", "expressionList", "variableStatement", "globalDefinition", 
		"loopStatement", "elseIfStatement", "elseStatement", "ifStatement", "statement", 
		"statements", "functionDefinition"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'nothing'", "','", "'type'", "'extends'", "'takes'", "'returns'", 
		"'constant'", "'native'", "'('", "')'", "'['", "']'", "'-'", "'not'", 
		"'%'", "'/'", "'*'", "'+'", "'=='", "'!='", "'<='", "'<'", "'>'", "'>='", 
		"'or'", "'and'", "'function'", "'true'", "'false'", "'null'", "'array'", 
		"'='", "'globals'", "'endglobals'", "'loop'", "'endloop'", "'elseif'", 
		"'then'", "'else'", "'if'", "'endif'", "'local'", "'set'", "'exitwhen'", 
		"'call'", "'return'", "'endfunction'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"STRING", "REAL", "INT", "NL", "ID", "WS", "COMMENT", "LINE_COMMENT"
	};
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
	public String getGrammarFileName() { return "vrj.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public vrjParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(vrjParser.EOF, 0); }
		public List<TypeDefinitionContext> typeDefinition() {
			return getRuleContexts(TypeDefinitionContext.class);
		}
		public TypeDefinitionContext typeDefinition(int i) {
			return getRuleContext(TypeDefinitionContext.class,i);
		}
		public List<NativeDefinitionContext> nativeDefinition() {
			return getRuleContexts(NativeDefinitionContext.class);
		}
		public NativeDefinitionContext nativeDefinition(int i) {
			return getRuleContext(NativeDefinitionContext.class,i);
		}
		public List<GlobalDefinitionContext> globalDefinition() {
			return getRuleContexts(GlobalDefinitionContext.class);
		}
		public GlobalDefinitionContext globalDefinition(int i) {
			return getRuleContext(GlobalDefinitionContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(vrjParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(vrjParser.NL, i);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__26) | (1L << T__32) | (1L << NL))) != 0)) {
				{
				setState(49);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(44);
					typeDefinition();
					}
					break;
				case T__6:
				case T__7:
					{
					setState(45);
					nativeDefinition();
					}
					break;
				case T__32:
					{
					setState(46);
					globalDefinition();
					}
					break;
				case T__26:
					{
					setState(47);
					functionDefinition();
					}
					break;
				case NL:
					{
					setState(48);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(EOF);
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(vrjParser.ID, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(ID);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(vrjParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==ID) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			type();
			setState(61);
			name();
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

	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_paramList);
		int _la;
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(63);
				param();
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(64);
					match(T__1);
					setState(65);
					param();
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(T__0);
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

	public static class TypeDefinitionContext extends ParserRuleContext {
		public NameContext typeName;
		public NameContext typeExtends;
		public TerminalNode NL() { return getToken(vrjParser.NL, 0); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitTypeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefinitionContext typeDefinition() throws RecognitionException {
		TypeDefinitionContext _localctx = new TypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__2);
			setState(75);
			((TypeDefinitionContext)_localctx).typeName = name();
			{
			setState(76);
			match(T__3);
			setState(77);
			((TypeDefinitionContext)_localctx).typeExtends = name();
			}
			setState(79);
			match(NL);
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

	public static class FunctionSignatureContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NL() { return getToken(vrjParser.NL, 0); }
		public FunctionSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionSignature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitFunctionSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionSignatureContext functionSignature() throws RecognitionException {
		FunctionSignatureContext _localctx = new FunctionSignatureContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionSignature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			name();
			setState(82);
			match(T__4);
			setState(83);
			paramList();
			setState(84);
			match(T__5);
			setState(85);
			type();
			setState(86);
			match(NL);
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

	public static class NativeDefinitionContext extends ParserRuleContext {
		public FunctionSignatureContext functionSignature() {
			return getRuleContext(FunctionSignatureContext.class,0);
		}
		public NativeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativeDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitNativeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NativeDefinitionContext nativeDefinition() throws RecognitionException {
		NativeDefinitionContext _localctx = new NativeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_nativeDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(88);
				match(T__6);
				}
			}

			setState(91);
			match(T__7);
			setState(92);
			functionSignature();
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

	public static class ArgumentsContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__8);
			setState(96);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__12) | (1L << T__13) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << STRING) | (1L << REAL) | (1L << INT) | (1L << ID))) != 0)) {
				{
				setState(95);
				expressionList();
				}
			}

			setState(98);
			match(T__9);
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

	public static class FunctionExpressionContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionExpressionContext functionExpression() throws RecognitionException {
		FunctionExpressionContext _localctx = new FunctionExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			name();
			setState(101);
			arguments();
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

	public static class VariableExpressionContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableExpressionContext variableExpression() throws RecognitionException {
		VariableExpressionContext _localctx = new VariableExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			name();
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(104);
				match(T__10);
				setState(105);
				expression(0);
				setState(106);
				match(T__11);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullContext extends ExpressionContext {
		public NullContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ModContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitLogical(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SumContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(vrjParser.STRING, 0); }
		public StringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CodeContext extends ExpressionContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public CodeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(vrjParser.INT, 0); }
		public IntegerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IgnoreVariableExpressionContext extends ExpressionContext {
		public VariableExpressionContext variableExpression() {
			return getRuleContext(VariableExpressionContext.class,0);
		}
		public IgnoreVariableExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitIgnoreVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegativeContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegativeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitNegative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealContext extends ExpressionContext {
		public TerminalNode REAL() { return getToken(vrjParser.REAL, 0); }
		public RealContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitReal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanContext extends ExpressionContext {
		public BooleanContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IgnoreFunctionExpressionContext extends ExpressionContext {
		public FunctionExpressionContext functionExpression() {
			return getRuleContext(FunctionExpressionContext.class,0);
		}
		public IgnoreFunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitIgnoreFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(111);
				match(T__8);
				setState(112);
				expression(0);
				setState(113);
				match(T__9);
				}
				break;
			case 2:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(T__12);
				setState(116);
				expression(17);
				}
				break;
			case 3:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(T__13);
				setState(118);
				expression(16);
				}
				break;
			case 4:
				{
				_localctx = new IgnoreVariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				variableExpression();
				}
				break;
			case 5:
				{
				_localctx = new IgnoreFunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				functionExpression();
				}
				break;
			case 6:
				{
				_localctx = new CodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(T__26);
				setState(122);
				name();
				}
				break;
			case 7:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 8:
				{
				_localctx = new NullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(T__29);
				}
				break;
			case 9:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(STRING);
				}
				break;
			case 10:
				{
				_localctx = new RealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				match(REAL);
				}
				break;
			case 11:
				{
				_localctx = new IntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				match(INT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(151);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ModContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(130);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(131);
						match(T__14);
						setState(132);
						expression(16);
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(133);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(134);
						match(T__15);
						setState(135);
						expression(15);
						}
						break;
					case 3:
						{
						_localctx = new MultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(136);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(137);
						match(T__16);
						setState(138);
						expression(14);
						}
						break;
					case 4:
						{
						_localctx = new SumContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(139);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(140);
						match(T__17);
						setState(141);
						expression(13);
						}
						break;
					case 5:
						{
						_localctx = new SubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(142);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(143);
						match(T__12);
						setState(144);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(146);
						((ComparisonContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
							((ComparisonContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(147);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new LogicalContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(148);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(149);
						((LogicalContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
							((LogicalContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(150);
						expression(8);
						}
						break;
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			expression(0);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(157);
				match(T__1);
				setState(158);
				expression(0);
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class VariableStatementContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode NL() { return getToken(vrjParser.NL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitVariableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableStatementContext variableStatement() throws RecognitionException {
		VariableStatementContext _localctx = new VariableStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			type();
			setState(166);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(165);
				match(T__30);
				}
			}

			setState(168);
			name();
			setState(171);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(169);
				match(T__31);
				setState(170);
				expression(0);
				}
			}

			setState(173);
			match(NL);
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

	public static class GlobalDefinitionContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(vrjParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(vrjParser.NL, i);
		}
		public List<VariableStatementContext> variableStatement() {
			return getRuleContexts(VariableStatementContext.class);
		}
		public VariableStatementContext variableStatement(int i) {
			return getRuleContext(VariableStatementContext.class,i);
		}
		public GlobalDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitGlobalDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalDefinitionContext globalDefinition() throws RecognitionException {
		GlobalDefinitionContext _localctx = new GlobalDefinitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_globalDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__32);
			setState(176);
			match(NL);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << NL) | (1L << ID))) != 0)) {
				{
				setState(182);
				switch (_input.LA(1)) {
				case T__0:
				case T__6:
				case ID:
					{
					{
					setState(178);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(177);
						match(T__6);
						}
					}

					setState(180);
					variableStatement();
					}
					}
					break;
				case NL:
					{
					setState(181);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			match(T__33);
			setState(188);
			match(NL);
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

	public static class LoopStatementContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(vrjParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(vrjParser.NL, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__34);
			setState(191);
			match(NL);
			setState(192);
			statements();
			setState(193);
			match(T__35);
			setState(194);
			match(NL);
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

	public static class ElseIfStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NL() { return getToken(vrjParser.NL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitElseIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__36);
			setState(197);
			expression(0);
			setState(198);
			match(T__37);
			setState(199);
			match(NL);
			setState(200);
			statements();
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

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(vrjParser.NL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(T__38);
			setState(203);
			match(NL);
			setState(204);
			statements();
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

	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(vrjParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(vrjParser.NL, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<ElseIfStatementContext> elseIfStatement() {
			return getRuleContexts(ElseIfStatementContext.class);
		}
		public ElseIfStatementContext elseIfStatement(int i) {
			return getRuleContext(ElseIfStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__39);
			setState(207);
			expression(0);
			setState(208);
			match(T__37);
			setState(209);
			match(NL);
			setState(210);
			statements();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36) {
				{
				{
				setState(211);
				elseIfStatement();
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(218);
			_la = _input.LA(1);
			if (_la==T__38) {
				{
				setState(217);
				elseStatement();
				}
			}

			setState(220);
			match(T__40);
			setState(221);
			match(NL);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IgnoreIfContext extends StatementContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IgnoreIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitIgnoreIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends StatementContext {
		public TerminalNode NL() { return getToken(vrjParser.NL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LocalVariableContext extends StatementContext {
		public VariableStatementContext variableStatement() {
			return getRuleContext(VariableStatementContext.class,0);
		}
		public LocalVariableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitLocalVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends StatementContext {
		public FunctionExpressionContext functionExpression() {
			return getRuleContext(FunctionExpressionContext.class,0);
		}
		public TerminalNode NL() { return getToken(vrjParser.NL, 0); }
		public FunctionCallContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExitwhenContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NL() { return getToken(vrjParser.NL, 0); }
		public ExitwhenContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitExitwhen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IgnoreLoopContext extends StatementContext {
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public IgnoreLoopContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitIgnoreLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetVariableContext extends StatementContext {
		public VariableExpressionContext variableExpression() {
			return getRuleContext(VariableExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NL() { return getToken(vrjParser.NL, 0); }
		public SetVariableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitSetVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statement);
		int _la;
		try {
			setState(246);
			switch (_input.LA(1)) {
			case T__41:
				_localctx = new LocalVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				match(T__41);
				setState(224);
				variableStatement();
				}
				break;
			case T__42:
				_localctx = new SetVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				match(T__42);
				setState(226);
				variableExpression();
				setState(227);
				match(T__31);
				setState(228);
				expression(0);
				setState(229);
				match(NL);
				}
				break;
			case T__43:
				_localctx = new ExitwhenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				match(T__43);
				setState(232);
				expression(0);
				setState(233);
				match(NL);
				}
				break;
			case T__44:
				_localctx = new FunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				match(T__44);
				setState(236);
				functionExpression();
				setState(237);
				match(NL);
				}
				break;
			case T__45:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(239);
				match(T__45);
				setState(241);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__12) | (1L << T__13) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << STRING) | (1L << REAL) | (1L << INT) | (1L << ID))) != 0)) {
					{
					setState(240);
					expression(0);
					}
				}

				setState(243);
				match(NL);
				}
				break;
			case T__39:
				_localctx = new IgnoreIfContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(244);
				ifStatement();
				}
				break;
			case T__34:
				_localctx = new IgnoreLoopContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(245);
				loopStatement();
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

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(vrjParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(vrjParser.NL, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << NL))) != 0)) {
				{
				setState(250);
				switch (_input.LA(1)) {
				case T__34:
				case T__39:
				case T__41:
				case T__42:
				case T__43:
				case T__44:
				case T__45:
					{
					setState(248);
					statement();
					}
					break;
				case NL:
					{
					setState(249);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionSignatureContext functionSignature() {
			return getRuleContext(FunctionSignatureContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode NL() { return getToken(vrjParser.NL, 0); }
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__26);
			setState(256);
			functionSignature();
			setState(257);
			statements();
			setState(258);
			match(T__46);
			setState(259);
			match(NL);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u0108\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\7\6E\n\6\f\6\16\6H\13\6\3\6\5\6K\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\5\t\\\n\t\3\t\3\t\3\t\3\n\3\n\5\nc"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\fo\n\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0083\n"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\7\r\u009a\n\r\f\r\16\r\u009d\13\r\3\16\3\16\3\16\7\16"+
		"\u00a2\n\16\f\16\16\16\u00a5\13\16\3\17\3\17\5\17\u00a9\n\17\3\17\3\17"+
		"\3\17\5\17\u00ae\n\17\3\17\3\17\3\20\3\20\3\20\5\20\u00b5\n\20\3\20\3"+
		"\20\7\20\u00b9\n\20\f\20\16\20\u00bc\13\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\7\24\u00d7\n\24\f\24\16\24\u00da\13\24\3"+
		"\24\5\24\u00dd\n\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00f4\n\25"+
		"\3\25\3\25\3\25\5\25\u00f9\n\25\3\26\3\26\7\26\u00fd\n\26\f\26\16\26\u0100"+
		"\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\2\3\30\30\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,\2\6\4\2\3\3\66\66\3\2\36\37\3\2\25\32\3"+
		"\2\33\34\u011d\2\65\3\2\2\2\4:\3\2\2\2\6<\3\2\2\2\b>\3\2\2\2\nJ\3\2\2"+
		"\2\fL\3\2\2\2\16S\3\2\2\2\20[\3\2\2\2\22`\3\2\2\2\24f\3\2\2\2\26i\3\2"+
		"\2\2\30\u0082\3\2\2\2\32\u009e\3\2\2\2\34\u00a6\3\2\2\2\36\u00b1\3\2\2"+
		"\2 \u00c0\3\2\2\2\"\u00c6\3\2\2\2$\u00cc\3\2\2\2&\u00d0\3\2\2\2(\u00f8"+
		"\3\2\2\2*\u00fe\3\2\2\2,\u0101\3\2\2\2.\64\5\f\7\2/\64\5\20\t\2\60\64"+
		"\5\36\20\2\61\64\5,\27\2\62\64\7\65\2\2\63.\3\2\2\2\63/\3\2\2\2\63\60"+
		"\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\7\2\2\39\3\3\2\2\2:;\7\66\2\2;\5"+
		"\3\2\2\2<=\t\2\2\2=\7\3\2\2\2>?\5\6\4\2?@\5\4\3\2@\t\3\2\2\2AF\5\b\5\2"+
		"BC\7\4\2\2CE\5\b\5\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GK\3\2\2\2"+
		"HF\3\2\2\2IK\7\3\2\2JA\3\2\2\2JI\3\2\2\2K\13\3\2\2\2LM\7\5\2\2MN\5\4\3"+
		"\2NO\7\6\2\2OP\5\4\3\2PQ\3\2\2\2QR\7\65\2\2R\r\3\2\2\2ST\5\4\3\2TU\7\7"+
		"\2\2UV\5\n\6\2VW\7\b\2\2WX\5\6\4\2XY\7\65\2\2Y\17\3\2\2\2Z\\\7\t\2\2["+
		"Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\7\n\2\2^_\5\16\b\2_\21\3\2\2\2`b\7\13"+
		"\2\2ac\5\32\16\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\f\2\2e\23\3\2\2\2f"+
		"g\5\4\3\2gh\5\22\n\2h\25\3\2\2\2in\5\4\3\2jk\7\r\2\2kl\5\30\r\2lm\7\16"+
		"\2\2mo\3\2\2\2nj\3\2\2\2no\3\2\2\2o\27\3\2\2\2pq\b\r\1\2qr\7\13\2\2rs"+
		"\5\30\r\2st\7\f\2\2t\u0083\3\2\2\2uv\7\17\2\2v\u0083\5\30\r\23wx\7\20"+
		"\2\2x\u0083\5\30\r\22y\u0083\5\26\f\2z\u0083\5\24\13\2{|\7\35\2\2|\u0083"+
		"\5\4\3\2}\u0083\t\3\2\2~\u0083\7 \2\2\177\u0083\7\62\2\2\u0080\u0083\7"+
		"\63\2\2\u0081\u0083\7\64\2\2\u0082p\3\2\2\2\u0082u\3\2\2\2\u0082w\3\2"+
		"\2\2\u0082y\3\2\2\2\u0082z\3\2\2\2\u0082{\3\2\2\2\u0082}\3\2\2\2\u0082"+
		"~\3\2\2\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\u009b\3\2\2\2\u0084\u0085\f\21\2\2\u0085\u0086\7\21\2\2\u0086\u009a\5"+
		"\30\r\22\u0087\u0088\f\20\2\2\u0088\u0089\7\22\2\2\u0089\u009a\5\30\r"+
		"\21\u008a\u008b\f\17\2\2\u008b\u008c\7\23\2\2\u008c\u009a\5\30\r\20\u008d"+
		"\u008e\f\16\2\2\u008e\u008f\7\24\2\2\u008f\u009a\5\30\r\17\u0090\u0091"+
		"\f\r\2\2\u0091\u0092\7\17\2\2\u0092\u009a\5\30\r\16\u0093\u0094\f\n\2"+
		"\2\u0094\u0095\t\4\2\2\u0095\u009a\5\30\r\13\u0096\u0097\f\t\2\2\u0097"+
		"\u0098\t\5\2\2\u0098\u009a\5\30\r\n\u0099\u0084\3\2\2\2\u0099\u0087\3"+
		"\2\2\2\u0099\u008a\3\2\2\2\u0099\u008d\3\2\2\2\u0099\u0090\3\2\2\2\u0099"+
		"\u0093\3\2\2\2\u0099\u0096\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\31\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a3"+
		"\5\30\r\2\u009f\u00a0\7\4\2\2\u00a0\u00a2\5\30\r\2\u00a1\u009f\3\2\2\2"+
		"\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\33"+
		"\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a8\5\6\4\2\u00a7\u00a9\7!\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ad\5\4"+
		"\3\2\u00ab\u00ac\7\"\2\2\u00ac\u00ae\5\30\r\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\7\65\2\2\u00b0\35\3\2\2"+
		"\2\u00b1\u00b2\7#\2\2\u00b2\u00ba\7\65\2\2\u00b3\u00b5\7\t\2\2\u00b4\u00b3"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b9\5\34\17\2"+
		"\u00b7\u00b9\7\65\2\2\u00b8\u00b4\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bd\u00be\7$\2\2\u00be\u00bf\7\65\2\2\u00bf\37\3\2\2"+
		"\2\u00c0\u00c1\7%\2\2\u00c1\u00c2\7\65\2\2\u00c2\u00c3\5*\26\2\u00c3\u00c4"+
		"\7&\2\2\u00c4\u00c5\7\65\2\2\u00c5!\3\2\2\2\u00c6\u00c7\7\'\2\2\u00c7"+
		"\u00c8\5\30\r\2\u00c8\u00c9\7(\2\2\u00c9\u00ca\7\65\2\2\u00ca\u00cb\5"+
		"*\26\2\u00cb#\3\2\2\2\u00cc\u00cd\7)\2\2\u00cd\u00ce\7\65\2\2\u00ce\u00cf"+
		"\5*\26\2\u00cf%\3\2\2\2\u00d0\u00d1\7*\2\2\u00d1\u00d2\5\30\r\2\u00d2"+
		"\u00d3\7(\2\2\u00d3\u00d4\7\65\2\2\u00d4\u00d8\5*\26\2\u00d5\u00d7\5\""+
		"\22\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dd\5$"+
		"\23\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00df\7+\2\2\u00df\u00e0\7\65\2\2\u00e0\'\3\2\2\2\u00e1\u00e2\7,\2\2"+
		"\u00e2\u00f9\5\34\17\2\u00e3\u00e4\7-\2\2\u00e4\u00e5\5\26\f\2\u00e5\u00e6"+
		"\7\"\2\2\u00e6\u00e7\5\30\r\2\u00e7\u00e8\7\65\2\2\u00e8\u00f9\3\2\2\2"+
		"\u00e9\u00ea\7.\2\2\u00ea\u00eb\5\30\r\2\u00eb\u00ec\7\65\2\2\u00ec\u00f9"+
		"\3\2\2\2\u00ed\u00ee\7/\2\2\u00ee\u00ef\5\24\13\2\u00ef\u00f0\7\65\2\2"+
		"\u00f0\u00f9\3\2\2\2\u00f1\u00f3\7\60\2\2\u00f2\u00f4\5\30\r\2\u00f3\u00f2"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f9\7\65\2\2"+
		"\u00f6\u00f9\5&\24\2\u00f7\u00f9\5 \21\2\u00f8\u00e1\3\2\2\2\u00f8\u00e3"+
		"\3\2\2\2\u00f8\u00e9\3\2\2\2\u00f8\u00ed\3\2\2\2\u00f8\u00f1\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9)\3\2\2\2\u00fa\u00fd\5(\25\2"+
		"\u00fb\u00fd\7\65\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\u0100"+
		"\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff+\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0101\u0102\7\35\2\2\u0102\u0103\5\16\b\2\u0103\u0104\5"+
		"*\26\2\u0104\u0105\7\61\2\2\u0105\u0106\7\65\2\2\u0106-\3\2\2\2\30\63"+
		"\65FJ[bn\u0082\u0099\u009b\u00a3\u00a8\u00ad\u00b4\u00b8\u00ba\u00d8\u00dc"+
		"\u00f3\u00f8\u00fc\u00fe";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}