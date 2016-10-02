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
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, STRING=55, REAL=56, INT=57, NL=58, ID=59, WS=60, COMMENT=61, 
		LINE_COMMENT=62;
	public static final int
		RULE_init = 0, RULE_visibility = 1, RULE_name = 2, RULE_type = 3, RULE_param = 4, 
		RULE_paramList = 5, RULE_typeDefinition = 6, RULE_functionSignature = 7, 
		RULE_nativeDefinition = 8, RULE_arguments = 9, RULE_functionExpression = 10, 
		RULE_variableExpression = 11, RULE_expression = 12, RULE_expressionList = 13, 
		RULE_variableStatement = 14, RULE_globalDefinition = 15, RULE_loopStatement = 16, 
		RULE_elseIfStatement = 17, RULE_elseStatement = 18, RULE_ifStatement = 19, 
		RULE_statement = 20, RULE_statements = 21, RULE_functionDefinition = 22, 
		RULE_libraryRequirementExpression = 23, RULE_libraryDefinition = 24;
	public static final String[] ruleNames = {
		"init", "visibility", "name", "type", "param", "paramList", "typeDefinition", 
		"functionSignature", "nativeDefinition", "arguments", "functionExpression", 
		"variableExpression", "expression", "expressionList", "variableStatement", 
		"globalDefinition", "loopStatement", "elseIfStatement", "elseStatement", 
		"ifStatement", "statement", "statements", "functionDefinition", "libraryRequirementExpression", 
		"libraryDefinition"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'private'", "'public'", "'.'", "'nothing'", "','", "'type'", "'extends'", 
		"'takes'", "'returns'", "'constant'", "'native'", "'('", "')'", "'['", 
		"']'", "'-'", "'not'", "'%'", "'/'", "'*'", "'+'", "'=='", "'!='", "'<='", 
		"'<'", "'>'", "'>='", "'or'", "'and'", "'function'", "'true'", "'false'", 
		"'null'", "'array'", "'='", "'globals'", "'endglobals'", "'loop'", "'endloop'", 
		"'elseif'", "'then'", "'else'", "'if'", "'endif'", "'local'", "'set'", 
		"'exitwhen'", "'call'", "'return'", "'endfunction'", "'library'", "'initializer'", 
		"'requires'", "'endlibrary'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "STRING", "REAL", "INT", "NL", 
		"ID", "WS", "COMMENT", "LINE_COMMENT"
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
		public List<LibraryDefinitionContext> libraryDefinition() {
			return getRuleContexts(LibraryDefinitionContext.class);
		}
		public LibraryDefinitionContext libraryDefinition(int i) {
			return getRuleContext(LibraryDefinitionContext.class,i);
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
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__9) | (1L << T__10) | (1L << T__29) | (1L << T__35) | (1L << T__50) | (1L << NL))) != 0)) {
				{
				setState(56);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(50);
					typeDefinition();
					}
					break;
				case T__9:
				case T__10:
					{
					setState(51);
					nativeDefinition();
					}
					break;
				case T__35:
					{
					setState(52);
					globalDefinition();
					}
					break;
				case T__0:
				case T__1:
				case T__29:
					{
					setState(53);
					functionDefinition();
					}
					break;
				case T__50:
					{
					setState(54);
					libraryDefinition();
					}
					break;
				case NL:
					{
					setState(55);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
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

	public static class VisibilityContext extends ParserRuleContext {
		public VisibilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibility; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitVisibility(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VisibilityContext visibility() throws RecognitionException {
		VisibilityContext _localctx = new VisibilityContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_visibility);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
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

	public static class NameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(vrjParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(vrjParser.ID, i);
		}
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
		enterRule(_localctx, 4, RULE_name);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(ID);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(66);
					match(T__2);
					setState(67);
					match(ID);
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==ID) ) {
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
		enterRule(_localctx, 8, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			type();
			setState(76);
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
		enterRule(_localctx, 10, RULE_paramList);
		int _la;
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(78);
				param();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(79);
					match(T__4);
					setState(80);
					param();
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(T__3);
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
		enterRule(_localctx, 12, RULE_typeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__5);
			setState(90);
			((TypeDefinitionContext)_localctx).typeName = name();
			{
			setState(91);
			match(T__6);
			setState(92);
			((TypeDefinitionContext)_localctx).typeExtends = name();
			}
			setState(94);
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
		enterRule(_localctx, 14, RULE_functionSignature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			name();
			setState(97);
			match(T__7);
			setState(98);
			paramList();
			setState(99);
			match(T__8);
			setState(100);
			type();
			setState(101);
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
		enterRule(_localctx, 16, RULE_nativeDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(103);
				match(T__9);
				}
			}

			setState(106);
			match(T__10);
			setState(107);
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
		enterRule(_localctx, 18, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__11);
			setState(111);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << STRING) | (1L << REAL) | (1L << INT) | (1L << ID))) != 0)) {
				{
				setState(110);
				expressionList();
				}
			}

			setState(113);
			match(T__12);
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
		enterRule(_localctx, 20, RULE_functionExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			name();
			setState(116);
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
		enterRule(_localctx, 22, RULE_variableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			name();
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(119);
				match(T__13);
				setState(120);
				expression(0);
				setState(121);
				match(T__14);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(126);
				match(T__11);
				setState(127);
				expression(0);
				setState(128);
				match(T__12);
				}
				break;
			case 2:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				match(T__15);
				setState(131);
				expression(17);
				}
				break;
			case 3:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				match(T__16);
				setState(133);
				expression(16);
				}
				break;
			case 4:
				{
				_localctx = new IgnoreVariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				variableExpression();
				}
				break;
			case 5:
				{
				_localctx = new IgnoreFunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				functionExpression();
				}
				break;
			case 6:
				{
				_localctx = new CodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(T__29);
				setState(137);
				name();
				}
				break;
			case 7:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				_la = _input.LA(1);
				if ( !(_la==T__30 || _la==T__31) ) {
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
				setState(139);
				match(T__32);
				}
				break;
			case 9:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(STRING);
				}
				break;
			case 10:
				{
				_localctx = new RealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(REAL);
				}
				break;
			case 11:
				{
				_localctx = new IntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(INT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(166);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ModContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(146);
						match(T__17);
						setState(147);
						expression(16);
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(148);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(149);
						match(T__18);
						setState(150);
						expression(15);
						}
						break;
					case 3:
						{
						_localctx = new MultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(151);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(152);
						match(T__19);
						setState(153);
						expression(14);
						}
						break;
					case 4:
						{
						_localctx = new SumContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(154);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(155);
						match(T__20);
						setState(156);
						expression(13);
						}
						break;
					case 5:
						{
						_localctx = new SubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(157);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(158);
						match(T__15);
						setState(159);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(160);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(161);
						((ComparisonContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((ComparisonContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(162);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new LogicalContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(163);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(164);
						((LogicalContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
							((LogicalContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(165);
						expression(8);
						}
						break;
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		enterRule(_localctx, 26, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			expression(0);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(172);
				match(T__4);
				setState(173);
				expression(0);
				}
				}
				setState(178);
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
		enterRule(_localctx, 28, RULE_variableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			type();
			setState(181);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(180);
				match(T__33);
				}
			}

			setState(183);
			name();
			setState(186);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(184);
				match(T__34);
				setState(185);
				expression(0);
				}
			}

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
		enterRule(_localctx, 30, RULE_globalDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__35);
			setState(191);
			match(NL);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << NL) | (1L << ID))) != 0)) {
				{
				setState(197);
				switch (_input.LA(1)) {
				case T__3:
				case T__9:
				case ID:
					{
					{
					setState(193);
					_la = _input.LA(1);
					if (_la==T__9) {
						{
						setState(192);
						match(T__9);
						}
					}

					setState(195);
					variableStatement();
					}
					}
					break;
				case NL:
					{
					setState(196);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(202);
			match(T__36);
			setState(203);
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
		enterRule(_localctx, 32, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__37);
			setState(206);
			match(NL);
			setState(207);
			statements();
			setState(208);
			match(T__38);
			setState(209);
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
		enterRule(_localctx, 34, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__39);
			setState(212);
			expression(0);
			setState(213);
			match(T__40);
			setState(214);
			match(NL);
			setState(215);
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
		enterRule(_localctx, 36, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__41);
			setState(218);
			match(NL);
			setState(219);
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
		enterRule(_localctx, 38, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__42);
			setState(222);
			expression(0);
			setState(223);
			match(T__40);
			setState(224);
			match(NL);
			setState(225);
			statements();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39) {
				{
				{
				setState(226);
				elseIfStatement();
				}
				}
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(233);
			_la = _input.LA(1);
			if (_la==T__41) {
				{
				setState(232);
				elseStatement();
				}
			}

			setState(235);
			match(T__43);
			setState(236);
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
		enterRule(_localctx, 40, RULE_statement);
		int _la;
		try {
			setState(261);
			switch (_input.LA(1)) {
			case T__44:
				_localctx = new LocalVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				match(T__44);
				setState(239);
				variableStatement();
				}
				break;
			case T__45:
				_localctx = new SetVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(T__45);
				setState(241);
				variableExpression();
				setState(242);
				match(T__34);
				setState(243);
				expression(0);
				setState(244);
				match(NL);
				}
				break;
			case T__46:
				_localctx = new ExitwhenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				match(T__46);
				setState(247);
				expression(0);
				setState(248);
				match(NL);
				}
				break;
			case T__47:
				_localctx = new FunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				match(T__47);
				setState(251);
				functionExpression();
				setState(252);
				match(NL);
				}
				break;
			case T__48:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(254);
				match(T__48);
				setState(256);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << STRING) | (1L << REAL) | (1L << INT) | (1L << ID))) != 0)) {
					{
					setState(255);
					expression(0);
					}
				}

				setState(258);
				match(NL);
				}
				break;
			case T__42:
				_localctx = new IgnoreIfContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(259);
				ifStatement();
				}
				break;
			case T__37:
				_localctx = new IgnoreLoopContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(260);
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
		enterRule(_localctx, 42, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__42) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << NL))) != 0)) {
				{
				setState(265);
				switch (_input.LA(1)) {
				case T__37:
				case T__42:
				case T__44:
				case T__45:
				case T__46:
				case T__47:
				case T__48:
					{
					setState(263);
					statement();
					}
					break;
				case NL:
					{
					setState(264);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(269);
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
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
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
		enterRule(_localctx, 44, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__1) {
				{
				setState(270);
				visibility();
				}
			}

			setState(273);
			match(T__29);
			setState(274);
			functionSignature();
			setState(275);
			statements();
			setState(276);
			match(T__49);
			setState(277);
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

	public static class LibraryRequirementExpressionContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public LibraryRequirementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_libraryRequirementExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitLibraryRequirementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LibraryRequirementExpressionContext libraryRequirementExpression() throws RecognitionException {
		LibraryRequirementExpressionContext _localctx = new LibraryRequirementExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_libraryRequirementExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			name();
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(280);
				match(T__4);
				setState(281);
				name();
				}
				}
				setState(286);
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

	public static class LibraryDefinitionContext extends ParserRuleContext {
		public NameContext initializer;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(vrjParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(vrjParser.NL, i);
		}
		public LibraryRequirementExpressionContext libraryRequirementExpression() {
			return getRuleContext(LibraryRequirementExpressionContext.class,0);
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
		public LibraryDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_libraryDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof vrjVisitor ) return ((vrjVisitor<? extends T>)visitor).visitLibraryDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LibraryDefinitionContext libraryDefinition() throws RecognitionException {
		LibraryDefinitionContext _localctx = new LibraryDefinitionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_libraryDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(T__50);
			setState(288);
			name();
			setState(291);
			_la = _input.LA(1);
			if (_la==T__51) {
				{
				setState(289);
				match(T__51);
				setState(290);
				((LibraryDefinitionContext)_localctx).initializer = name();
				}
			}

			setState(295);
			_la = _input.LA(1);
			if (_la==T__52) {
				{
				setState(293);
				match(T__52);
				setState(294);
				libraryRequirementExpression();
				}
			}

			setState(297);
			match(NL);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__29) | (1L << T__35) | (1L << NL))) != 0)) {
				{
				setState(301);
				switch (_input.LA(1)) {
				case T__35:
					{
					setState(298);
					globalDefinition();
					}
					break;
				case T__0:
				case T__1:
				case T__29:
					{
					setState(299);
					functionDefinition();
					}
					break;
				case NL:
					{
					setState(300);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(306);
			match(T__53);
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
		case 12:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u0137\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\7\7T\n\7\f\7\16\7W\13\7\3\7\5\7Z\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\5\nk\n\n\3\n\3\n\3\n\3\13\3\13\5\13r\n"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r~\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u0092\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00a9\n\16"+
		"\f\16\16\16\u00ac\13\16\3\17\3\17\3\17\7\17\u00b1\n\17\f\17\16\17\u00b4"+
		"\13\17\3\20\3\20\5\20\u00b8\n\20\3\20\3\20\3\20\5\20\u00bd\n\20\3\20\3"+
		"\20\3\21\3\21\3\21\5\21\u00c4\n\21\3\21\3\21\7\21\u00c8\n\21\f\21\16\21"+
		"\u00cb\13\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\7"+
		"\25\u00e6\n\25\f\25\16\25\u00e9\13\25\3\25\5\25\u00ec\n\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\5\26\u0103\n\26\3\26\3\26\3\26\5\26\u0108\n\26"+
		"\3\27\3\27\7\27\u010c\n\27\f\27\16\27\u010f\13\27\3\30\5\30\u0112\n\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u011d\n\31\f\31\16"+
		"\31\u0120\13\31\3\32\3\32\3\32\3\32\5\32\u0126\n\32\3\32\3\32\5\32\u012a"+
		"\n\32\3\32\3\32\3\32\3\32\7\32\u0130\n\32\f\32\16\32\u0133\13\32\3\32"+
		"\3\32\3\32\2\3\32\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\2\7\3\2\3\4\4\2\6\6==\3\2!\"\3\2\30\35\3\2\36\37\u0152\2<\3\2\2\2"+
		"\4A\3\2\2\2\6C\3\2\2\2\bK\3\2\2\2\nM\3\2\2\2\fY\3\2\2\2\16[\3\2\2\2\20"+
		"b\3\2\2\2\22j\3\2\2\2\24o\3\2\2\2\26u\3\2\2\2\30x\3\2\2\2\32\u0091\3\2"+
		"\2\2\34\u00ad\3\2\2\2\36\u00b5\3\2\2\2 \u00c0\3\2\2\2\"\u00cf\3\2\2\2"+
		"$\u00d5\3\2\2\2&\u00db\3\2\2\2(\u00df\3\2\2\2*\u0107\3\2\2\2,\u010d\3"+
		"\2\2\2.\u0111\3\2\2\2\60\u0119\3\2\2\2\62\u0121\3\2\2\2\64;\5\16\b\2\65"+
		";\5\22\n\2\66;\5 \21\2\67;\5.\30\28;\5\62\32\29;\7<\2\2:\64\3\2\2\2:\65"+
		"\3\2\2\2:\66\3\2\2\2:\67\3\2\2\2:8\3\2\2\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2"+
		"\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\7\2\2\3@\3\3\2\2\2AB\t\2\2\2B\5\3\2"+
		"\2\2CH\7=\2\2DE\7\5\2\2EG\7=\2\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2"+
		"\2I\7\3\2\2\2JH\3\2\2\2KL\t\3\2\2L\t\3\2\2\2MN\5\b\5\2NO\5\6\4\2O\13\3"+
		"\2\2\2PU\5\n\6\2QR\7\7\2\2RT\5\n\6\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3"+
		"\2\2\2VZ\3\2\2\2WU\3\2\2\2XZ\7\6\2\2YP\3\2\2\2YX\3\2\2\2Z\r\3\2\2\2[\\"+
		"\7\b\2\2\\]\5\6\4\2]^\7\t\2\2^_\5\6\4\2_`\3\2\2\2`a\7<\2\2a\17\3\2\2\2"+
		"bc\5\6\4\2cd\7\n\2\2de\5\f\7\2ef\7\13\2\2fg\5\b\5\2gh\7<\2\2h\21\3\2\2"+
		"\2ik\7\f\2\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\r\2\2mn\5\20\t\2n\23\3"+
		"\2\2\2oq\7\16\2\2pr\5\34\17\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\17\2\2"+
		"t\25\3\2\2\2uv\5\6\4\2vw\5\24\13\2w\27\3\2\2\2x}\5\6\4\2yz\7\20\2\2z{"+
		"\5\32\16\2{|\7\21\2\2|~\3\2\2\2}y\3\2\2\2}~\3\2\2\2~\31\3\2\2\2\177\u0080"+
		"\b\16\1\2\u0080\u0081\7\16\2\2\u0081\u0082\5\32\16\2\u0082\u0083\7\17"+
		"\2\2\u0083\u0092\3\2\2\2\u0084\u0085\7\22\2\2\u0085\u0092\5\32\16\23\u0086"+
		"\u0087\7\23\2\2\u0087\u0092\5\32\16\22\u0088\u0092\5\30\r\2\u0089\u0092"+
		"\5\26\f\2\u008a\u008b\7 \2\2\u008b\u0092\5\6\4\2\u008c\u0092\t\4\2\2\u008d"+
		"\u0092\7#\2\2\u008e\u0092\79\2\2\u008f\u0092\7:\2\2\u0090\u0092\7;\2\2"+
		"\u0091\177\3\2\2\2\u0091\u0084\3\2\2\2\u0091\u0086\3\2\2\2\u0091\u0088"+
		"\3\2\2\2\u0091\u0089\3\2\2\2\u0091\u008a\3\2\2\2\u0091\u008c\3\2\2\2\u0091"+
		"\u008d\3\2\2\2\u0091\u008e\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2"+
		"\2\2\u0092\u00aa\3\2\2\2\u0093\u0094\f\21\2\2\u0094\u0095\7\24\2\2\u0095"+
		"\u00a9\5\32\16\22\u0096\u0097\f\20\2\2\u0097\u0098\7\25\2\2\u0098\u00a9"+
		"\5\32\16\21\u0099\u009a\f\17\2\2\u009a\u009b\7\26\2\2\u009b\u00a9\5\32"+
		"\16\20\u009c\u009d\f\16\2\2\u009d\u009e\7\27\2\2\u009e\u00a9\5\32\16\17"+
		"\u009f\u00a0\f\r\2\2\u00a0\u00a1\7\22\2\2\u00a1\u00a9\5\32\16\16\u00a2"+
		"\u00a3\f\n\2\2\u00a3\u00a4\t\5\2\2\u00a4\u00a9\5\32\16\13\u00a5\u00a6"+
		"\f\t\2\2\u00a6\u00a7\t\6\2\2\u00a7\u00a9\5\32\16\n\u00a8\u0093\3\2\2\2"+
		"\u00a8\u0096\3\2\2\2\u00a8\u0099\3\2\2\2\u00a8\u009c\3\2\2\2\u00a8\u009f"+
		"\3\2\2\2\u00a8\u00a2\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\33\3\2\2\2\u00ac\u00aa\3\2\2"+
		"\2\u00ad\u00b2\5\32\16\2\u00ae\u00af\7\7\2\2\u00af\u00b1\5\32\16\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\35\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\5\b\5\2\u00b6\u00b8"+
		"\7$\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00bc\5\6\4\2\u00ba\u00bb\7%\2\2\u00bb\u00bd\5\32\16\2\u00bc\u00ba\3"+
		"\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\7<\2\2\u00bf"+
		"\37\3\2\2\2\u00c0\u00c1\7&\2\2\u00c1\u00c9\7<\2\2\u00c2\u00c4\7\f\2\2"+
		"\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c8"+
		"\5\36\20\2\u00c6\u00c8\7<\2\2\u00c7\u00c3\3\2\2\2\u00c7\u00c6\3\2\2\2"+
		"\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc"+
		"\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\'\2\2\u00cd\u00ce\7<\2\2\u00ce"+
		"!\3\2\2\2\u00cf\u00d0\7(\2\2\u00d0\u00d1\7<\2\2\u00d1\u00d2\5,\27\2\u00d2"+
		"\u00d3\7)\2\2\u00d3\u00d4\7<\2\2\u00d4#\3\2\2\2\u00d5\u00d6\7*\2\2\u00d6"+
		"\u00d7\5\32\16\2\u00d7\u00d8\7+\2\2\u00d8\u00d9\7<\2\2\u00d9\u00da\5,"+
		"\27\2\u00da%\3\2\2\2\u00db\u00dc\7,\2\2\u00dc\u00dd\7<\2\2\u00dd\u00de"+
		"\5,\27\2\u00de\'\3\2\2\2\u00df\u00e0\7-\2\2\u00e0\u00e1\5\32\16\2\u00e1"+
		"\u00e2\7+\2\2\u00e2\u00e3\7<\2\2\u00e3\u00e7\5,\27\2\u00e4\u00e6\5$\23"+
		"\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8"+
		"\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ec\5&\24\2\u00eb"+
		"\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\7."+
		"\2\2\u00ee\u00ef\7<\2\2\u00ef)\3\2\2\2\u00f0\u00f1\7/\2\2\u00f1\u0108"+
		"\5\36\20\2\u00f2\u00f3\7\60\2\2\u00f3\u00f4\5\30\r\2\u00f4\u00f5\7%\2"+
		"\2\u00f5\u00f6\5\32\16\2\u00f6\u00f7\7<\2\2\u00f7\u0108\3\2\2\2\u00f8"+
		"\u00f9\7\61\2\2\u00f9\u00fa\5\32\16\2\u00fa\u00fb\7<\2\2\u00fb\u0108\3"+
		"\2\2\2\u00fc\u00fd\7\62\2\2\u00fd\u00fe\5\26\f\2\u00fe\u00ff\7<\2\2\u00ff"+
		"\u0108\3\2\2\2\u0100\u0102\7\63\2\2\u0101\u0103\5\32\16\2\u0102\u0101"+
		"\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0108\7<\2\2\u0105"+
		"\u0108\5(\25\2\u0106\u0108\5\"\22\2\u0107\u00f0\3\2\2\2\u0107\u00f2\3"+
		"\2\2\2\u0107\u00f8\3\2\2\2\u0107\u00fc\3\2\2\2\u0107\u0100\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108+\3\2\2\2\u0109\u010c\5*\26\2"+
		"\u010a\u010c\7<\2\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c\u010f"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e-\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0112\5\4\3\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2"+
		"\2\2\u0112\u0113\3\2\2\2\u0113\u0114\7 \2\2\u0114\u0115\5\20\t\2\u0115"+
		"\u0116\5,\27\2\u0116\u0117\7\64\2\2\u0117\u0118\7<\2\2\u0118/\3\2\2\2"+
		"\u0119\u011e\5\6\4\2\u011a\u011b\7\7\2\2\u011b\u011d\5\6\4\2\u011c\u011a"+
		"\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\61\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7\65\2\2\u0122\u0125\5\6\4"+
		"\2\u0123\u0124\7\66\2\2\u0124\u0126\5\6\4\2\u0125\u0123\3\2\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0128\7\67\2\2\u0128\u012a\5"+
		"\60\31\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u0131\7<\2\2\u012c\u0130\5 \21\2\u012d\u0130\5.\30\2\u012e\u0130\7<\2"+
		"\2\u012f\u012c\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u012e\3\2\2\2\u0130\u0133"+
		"\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0134\u0135\78\2\2\u0135\63\3\2\2\2\37:<HUYjq}\u0091\u00a8"+
		"\u00aa\u00b2\u00b7\u00bc\u00c3\u00c7\u00c9\u00e7\u00eb\u0102\u0107\u010b"+
		"\u010d\u0111\u011e\u0125\u0129\u012f\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}