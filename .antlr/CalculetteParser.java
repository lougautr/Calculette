// Generated from /Users/antoninmontagne/Desktop/Info/L3/S6/LangagesCompilation/TP/TP5/Calculette.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, COMMENTAIREMULTI=30, 
		COMMENTAIRESIMPLE=31, NEWLINE=32, WS=33, ENTIER=34, DOUBLE=35, TYPE=36, 
		RETURN=37, IDENTIFIANT=38;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_bloc = 2, RULE_instruction = 3, 
		RULE_expression = 4, RULE_decl = 5, RULE_assignation = 6, RULE_lire = 7, 
		RULE_ecrire = 8, RULE_plusEgal = 9, RULE_condition = 10, RULE_boucleWhile = 11, 
		RULE_boucleFor = 12, RULE_branchement = 13, RULE_fonction = 14, RULE_params = 15, 
		RULE_args = 16, RULE_finInstruction = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "bloc", "instruction", "expression", "decl", "assignation", 
			"lire", "ecrire", "plusEgal", "condition", "boucleWhile", "boucleFor", 
			"branchement", "fonction", "params", "args", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "'-'", "'*'", "'/'", "'+'", "'='", 
			"'print('", "'input('", "'+='", "'=='", "'!='", "'>'", "'>='", "'<'", 
			"'<='", "'true'", "'false'", "'&&'", "'||'", "'!'", "'while'", "'for'", 
			"';'", "'if'", "'else'", "','", null, null, null, null, null, null, null, 
			"'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "COMMENTAIREMULTI", "COMMENTAIRESIMPLE", 
			"NEWLINE", "WS", "ENTIER", "DOUBLE", "TYPE", "RETURN", "IDENTIFIANT"
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
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private String evalexpr (String x, String op, String y, String typex, String typey) {
	        String flt = floatChoix(typex,typey);
	        if ( op.equals("*") ){
	            return x + y + flt + "MUL\n";
	        } else if ( op.equals("+") ){
	           return x + y + flt + "ADD\n";
	        } else if (op.equals("/")){
	            return x + y + flt + "DIV\n";
	        }else if (op.equals("-")){
	            return x + y + flt + "SUB\n";
	        }else{
	           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
	        }
	    }

	    private String evalcond (String x, String op, String y, String typex, String typey) {
	        String flt = floatChoix(typex,typey);
	        if ( op.equals("==") ){
	            return x + y + flt + "EQUAL\n" ;
	        } else if (op.equals("!=")){
	             return x + y + flt + "NEQ\n";
	        }else if (op.equals("<")){
	            return x + y + flt + "INF\n";
	        }else if (op.equals(">=")){
	            return x + y + flt + "SUPEQ\n";
	        }else if (op.equals(">")){
	            return x + y + flt + "SUP\n";
	        }else if (op.equals("<=")){
	            return x + y + flt + "INFEQ\n";
	        }
	        else{
	           System.err.println("Opérateur de comparaison incorrect : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur de comparaison incorrect : '"+op+"'");
	        }
	    }

	    private TablesSymboles tablesSymboles = new TablesSymboles();

	    private int _cur_label = 1;
	    /** générateur de nom d'étiquettes pour les boucles */
	    private String getNewLabel() { return "Label"+(_cur_label++); }

	    private String videPile(int x){
	       String res = "";
	            for(int i = 0; i<x; i++){
	                res += "POP\n";
	        }
	        return res;
	    }

	    private String choix(Object y){
	            if(y.toString().equals("PARAM")|y.toString().equals("LOCAL")){
	                return "L ";
	            }else{
	                return "G ";
	            }
	    }

	    private String type(Object typeVar){
	        if(typeVar.equals("double")){
	            return "F";
	        }
	        return "";
	    } 

	    private String declaFloat(String type){
	        if(type.equals("double")){
	            return "PUSHF 0.0\n";
	        }
	        return "PUSHI 0\n";
	    }

	    private String printFloat(String type, VariableInfo var){
	        String push = "PUSH" + choix(var.scope);
	        if(type.equals("double")){
	            return push + var.address + "\n" + push + (var.address + 1) + "\n" +"WRITEF\n" + "POP\n" + "POP\n";
	        }
	        return push + var.address + "\n" +  "WRITE\n" + "POP\n";
	    }

	    private String print(String expr, String type){
	        if(type.equals("double")){
	            return expr + "WRITEF\n";
	        }
	        return expr + "WRITE\n";
	    }


	    private String readFloat(String type, VariableInfo var){
	        String read = "STORE" + choix(var.scope);
	        if(type.equals("double")){
	            return "READF\n" + read + (var.address+1) + "\n" + read + var.address + "\n";
	        }
	        return "READ\n" + read + var.address + "\n";
	    }

	    private String floatChoix(String typea, String typeb){
	        if((typea.equals("double")) || (typeb.equals("double"))){
	            return "F";
	        }
	        return "";
	    }

	    private String pushChoix(VariableInfo var){
	       String p = "PUSH" + choix(var.scope);
	         if(var.type.equals("double")){
	              return p + var.address + "\n" + p + (var.address+1) + "\n";
	         }
	            return p + var.address + "\n";
	    }

	    private String returnChoix(VariableInfo var, String type){
	         if(type.equals("double")){
	              return "STOREL " + (tablesSymboles.getReturn().address+1) + "\n" + "STOREL " + tablesSymboles.getReturn().address + "\n" + "RETURN\n";
	         }
	            return "STOREL " + tablesSymboles.getReturn().address + "\n" + "RETURN\n";
	    }

	    private String resFonction(String type){
	        if(type.equals("double")){
	            return "PUSHF 0.0\n";
	        }
	        return "PUSHI 0\n";
	    }

	    private String assignationChoix(VariableInfo var){
	        String store = "STORE" + choix(var.scope);
	        if(var.type.equals("double")){
	            return store + (var.address+1) + "\n" + store + var.address + "\n";
	        }
	        return store + var.address + "\n";
	    }

	    private int sizeArgsF(String type, int x){
	        if(type.equals("double")){
	            return x+2;
	        }
	        return x+1;
	    }



	    private VariableInfo var;
	            

	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public CalculContext calcul;
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalculetteParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			((StartContext)_localctx).calcul = calcul();
			setState(37);
			match(EOF);
			System.out.println(((StartContext)_localctx).calcul.code);
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

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public FonctionContext fonction;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40);
					((CalculContext)_localctx).decl = decl();
					 _localctx.code += ((CalculContext)_localctx).decl.code; 
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			 _localctx.code += "  JUMP Main\n"; 
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(49);
					match(NEWLINE);
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(55);
				((CalculContext)_localctx).fonction = fonction();
				 _localctx.code += ((CalculContext)_localctx).fonction.code; 
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(63);
					match(NEWLINE);
					}
					} 
				}
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			 _localctx.code += "LABEL Main\n"; 
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << NEWLINE) | (1L << ENTIER) | (1L << DOUBLE) | (1L << RETURN) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(70);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "HALT\n"; 
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

	public static class BlocContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloc);
		 ((BlocContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__0);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << NEWLINE) | (1L << ENTIER) | (1L << DOUBLE) | (1L << RETURN) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(81);
				((BlocContext)_localctx).instruction = instruction();
				 _localctx.code += ((BlocContext)_localctx).instruction.code; 
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(T__1);
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(90);
					match(NEWLINE);
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public AssignationContext assignation;
		public LireContext lire;
		public EcrireContext ecrire;
		public PlusEgalContext plusEgal;
		public BoucleWhileContext boucleWhile;
		public BoucleForContext boucleFor;
		public BlocContext bloc;
		public BranchementContext branchement;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public LireContext lire() {
			return getRuleContext(LireContext.class,0);
		}
		public EcrireContext ecrire() {
			return getRuleContext(EcrireContext.class,0);
		}
		public PlusEgalContext plusEgal() {
			return getRuleContext(PlusEgalContext.class,0);
		}
		public BoucleWhileContext boucleWhile() {
			return getRuleContext(BoucleWhileContext.class,0);
		}
		public BoucleForContext boucleFor() {
			return getRuleContext(BoucleForContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public BranchementContext branchement() {
			return getRuleContext(BranchementContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CalculetteParser.RETURN, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				((InstructionContext)_localctx).expression = expression(0);
				setState(97);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				((InstructionContext)_localctx).assignation = assignation();
				setState(101);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				((InstructionContext)_localctx).lire = lire();
				setState(105);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).lire.code;
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				((InstructionContext)_localctx).ecrire = ecrire();
				setState(109);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).ecrire.code;
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(112);
				((InstructionContext)_localctx).plusEgal = plusEgal();
				setState(113);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).plusEgal.code;
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(116);
				((InstructionContext)_localctx).boucleWhile = boucleWhile();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).boucleWhile.code;
				        
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(119);
				((InstructionContext)_localctx).boucleFor = boucleFor();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).boucleFor.code;
				        
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(122);
				((InstructionContext)_localctx).bloc = bloc();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).bloc.code;
				        
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(125);
				((InstructionContext)_localctx).branchement = branchement();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).branchement.code;
				        
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(128);
				match(RETURN);
				setState(129);
				((InstructionContext)_localctx).expression = expression(0);
				setState(130);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code + returnChoix(var, ((InstructionContext)_localctx).expression.type);
				        
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(133);
				finInstruction();

				            ((InstructionContext)_localctx).code = "";
				        
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

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public String type;
		public ExpressionContext a;
		public ExpressionContext e;
		public Token IDENTIFIANT;
		public ArgsContext args;
		public Token ENTIER;
		public Token DOUBLE;
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public TerminalNode DOUBLE() { return getToken(CalculetteParser.DOUBLE, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(139);
				match(T__2);
				setState(140);
				((ExpressionContext)_localctx).e = expression(0);
				setState(141);
				match(T__3);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).e.code; ((ExpressionContext)_localctx).type = ((ExpressionContext)_localctx).e.type;
				}
				break;
			case 2:
				{
				setState(144);
				match(T__4);
				setState(145);
				((ExpressionContext)_localctx).e = expression(8);
				((ExpressionContext)_localctx).code =  "PUSHI 0 \n" + ((ExpressionContext)_localctx).e.code + "SUB\n";((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).e.type;
				}
				break;
			case 3:
				{
				setState(148);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(149);
				match(T__2);
				setState(150);
				match(T__3);
				((ExpressionContext)_localctx).code =  resFonction(tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null))) + "CALL " + (((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null) + "\n";
				                            ((ExpressionContext)_localctx).type =  tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				}
				break;
			case 4:
				{
				setState(152);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(153);
				match(T__2);
				setState(154);
				((ExpressionContext)_localctx).args = args();
				setState(155);
				match(T__3);
				((ExpressionContext)_localctx).code =  resFonction(tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null))) + ((ExpressionContext)_localctx).args.code + "CALL " + (((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null) + "\n" + videPile(((ExpressionContext)_localctx).args.size);
				                                ((ExpressionContext)_localctx).type =  tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				}
				break;
			case 5:
				{
				setState(158);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?((ExpressionContext)_localctx).ENTIER.getText():null) + "\n"; 
				              ((ExpressionContext)_localctx).type =  "int";
				}
				break;
			case 6:
				{
				setState(160);
				((ExpressionContext)_localctx).DOUBLE = match(DOUBLE);
				((ExpressionContext)_localctx).code =  "PUSHF " + (((ExpressionContext)_localctx).DOUBLE!=null?((ExpressionContext)_localctx).DOUBLE.getText():null) + "\n"; 
				              ((ExpressionContext)_localctx).type =  "double";
				}
				break;
			case 7:
				{
				setState(162);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				((ExpressionContext)_localctx).code =  pushChoix(tablesSymboles.getVar((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null))); 
				                   ((ExpressionContext)_localctx).type =  tablesSymboles.getVar((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null)).type;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(166);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(167);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(168);
						((ExpressionContext)_localctx).b = expression(8);
						((ExpressionContext)_localctx).code =  evalexpr(((ExpressionContext)_localctx).a.code,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).b.code, ((ExpressionContext)_localctx).a.type, ((ExpressionContext)_localctx).b.type); ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).a.type;
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(171);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(172);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__7) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(173);
						((ExpressionContext)_localctx).b = expression(7);
						((ExpressionContext)_localctx).code =  evalexpr(((ExpressionContext)_localctx).a.code,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).b.code, ((ExpressionContext)_localctx).a.type, ((ExpressionContext)_localctx).b.type); ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).a.type;
						}
						break;
					}
					} 
				}
				setState(180);
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

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decl);
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(182);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(183);
				finInstruction();

				            ((DeclContext)_localctx).code =  declaFloat((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				            tablesSymboles.addVarDecl((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(187);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(188);
				match(T__8);
				setState(189);
				((DeclContext)_localctx).expression = expression(0);
				setState(190);
				finInstruction();

				            ((DeclContext)_localctx).code =  ((DeclContext)_localctx).expression.code;
				            tablesSymboles.addVarDecl((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				        
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

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(196);
			match(T__8);
			setState(197);
			((AssignationContext)_localctx).expression = expression(0);
			   var = tablesSymboles.getVar((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
			            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code  + assignationChoix(var);
			        
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

	public static class LireContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lire; }
	}

	public final LireContext lire() throws RecognitionException {
		LireContext _localctx = new LireContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lire);
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(T__9);
				setState(201);
				((LireContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(202);
				match(T__3);
				   var = tablesSymboles.getVar((((LireContext)_localctx).IDENTIFIANT!=null?((LireContext)_localctx).IDENTIFIANT.getText():null));
				            ((LireContext)_localctx).code =  printFloat(var.type, var);
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				match(T__9);
				setState(205);
				((LireContext)_localctx).expression = expression(0);
				setState(206);
				match(T__3);

				            ((LireContext)_localctx).code =  print(((LireContext)_localctx).expression.code, ((LireContext)_localctx).expression.type);
				        
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

	public static class EcrireContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public EcrireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ecrire; }
	}

	public final EcrireContext ecrire() throws RecognitionException {
		EcrireContext _localctx = new EcrireContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ecrire);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__10);
			setState(212);
			((EcrireContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(213);
			match(T__3);
			   var = tablesSymboles.getVar((((EcrireContext)_localctx).IDENTIFIANT!=null?((EcrireContext)_localctx).IDENTIFIANT.getText():null));
			            ((EcrireContext)_localctx).code =  readFloat(var.type, var);
			        
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

	public static class PlusEgalContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PlusEgalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusEgal; }
	}

	public final PlusEgalContext plusEgal() throws RecognitionException {
		PlusEgalContext _localctx = new PlusEgalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_plusEgal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			((PlusEgalContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(217);
			match(T__11);
			setState(218);
			((PlusEgalContext)_localctx).expression = expression(0);
			   var = tablesSymboles.getVar((((PlusEgalContext)_localctx).IDENTIFIANT!=null?((PlusEgalContext)_localctx).IDENTIFIANT.getText():null));
			            ((PlusEgalContext)_localctx).code =  "PUSH" + choix(var.scope) + var.address + "\n" + 
			            ((PlusEgalContext)_localctx).expression.code + "ADD\n" + "STORE" + 
			            choix(var.scope) + var.address + "\n";
			        
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

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ConditionContext a;
		public ExpressionContext c;
		public Token cd;
		public ExpressionContext d;
		public ConditionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__4:
			case ENTIER:
			case DOUBLE:
			case IDENTIFIANT:
				{
				setState(222);
				((ConditionContext)_localctx).c = expression(0);
				setState(223);
				((ConditionContext)_localctx).cd = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
					((ConditionContext)_localctx).cd = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(224);
				((ConditionContext)_localctx).d = expression(0);
				((ConditionContext)_localctx).code =  evalcond(((ConditionContext)_localctx).c.code,(((ConditionContext)_localctx).cd!=null?((ConditionContext)_localctx).cd.getText():null),((ConditionContext)_localctx).d.code, ((ConditionContext)_localctx).c.type, ((ConditionContext)_localctx).d.type); 
				}
				break;
			case T__18:
				{
				setState(227);
				match(T__18);
				 ((ConditionContext)_localctx).code =  "  PUSHI 1\n"; 
				}
				break;
			case T__19:
				{
				setState(229);
				match(T__19);
				 ((ConditionContext)_localctx).code =  "  PUSHI 0\n"; 
				}
				break;
			case T__22:
				{
				setState(231);
				match(T__22);
				setState(232);
				((ConditionContext)_localctx).b = condition(1);
				String f = getNewLabel();
				                                        String d = getNewLabel();
				                                        ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).b.code + "JUMPF " + f + "\n" + "PUSHI 0\n" + "JUMP " + d + "\n" + "LABEL " + f + "\n" + "PUSHI 1\n" + "LABEL " + d +"\n";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(247);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(237);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(238);
						match(T__20);
						setState(239);
						((ConditionContext)_localctx).b = condition(4);
						 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + "PUSHI 1\n" + "EQUAL\n" + ((ConditionContext)_localctx).b.code + "PUSHI 1\n" + "EQUAL\n" + "ADD\n" + "PUSHI 2\n" + "EQUAL\n"; 
						}
						break;
					case 2:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(242);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(243);
						match(T__21);
						setState(244);
						((ConditionContext)_localctx).b = condition(3);
						 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + "PUSHI 1\n" + "EQUAL\n" + ((ConditionContext)_localctx).b.code + "PUSHI 1\n" + "EQUAL\n" + "ADD\n" + "PUSHI 1\n" + "SUPEQ\n" ; 
						}
						break;
					}
					} 
				}
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class BoucleWhileContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public InstructionContext instruction;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public BoucleWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boucleWhile; }
	}

	public final BoucleWhileContext boucleWhile() throws RecognitionException {
		BoucleWhileContext _localctx = new BoucleWhileContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_boucleWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(T__23);
			setState(253);
			match(T__2);
			setState(254);
			((BoucleWhileContext)_localctx).condition = condition(0);
			setState(255);
			match(T__3);
			setState(256);
			((BoucleWhileContext)_localctx).instruction = instruction();
			 String d = getNewLabel();
			                                       String f = getNewLabel();
			                                       ((BoucleWhileContext)_localctx).code =  "LABEL " + d +"\n" + ((BoucleWhileContext)_localctx).condition.code + "JUMPF " + f + "\n" + ((BoucleWhileContext)_localctx).instruction.code + "JUMP " + d + "\n" + "LABEL " + f + "\n";
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

	public static class BoucleForContext extends ParserRuleContext {
		public String code;
		public AssignationContext a;
		public ConditionContext condition;
		public AssignationContext b;
		public InstructionContext instruction;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
		}
		public BoucleForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boucleFor; }
	}

	public final BoucleForContext boucleFor() throws RecognitionException {
		BoucleForContext _localctx = new BoucleForContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_boucleFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(T__24);
			setState(260);
			match(T__2);
			setState(261);
			((BoucleForContext)_localctx).a = assignation();
			setState(262);
			match(T__25);
			setState(263);
			((BoucleForContext)_localctx).condition = condition(0);
			setState(264);
			match(T__25);
			setState(265);
			((BoucleForContext)_localctx).b = assignation();
			setState(266);
			match(T__3);
			setState(267);
			((BoucleForContext)_localctx).instruction = instruction();
			 
			                                       String d = getNewLabel();
			                                       String f = getNewLabel();
			                                       ((BoucleForContext)_localctx).code =  ((BoucleForContext)_localctx).a.code + "LABEL " + d +"\n" + ((BoucleForContext)_localctx).condition.code + "JUMPF " + f +"\n" +  ((BoucleForContext)_localctx).instruction.code + ((BoucleForContext)_localctx).b.code + "JUMP " + d + "\n" + "LABEL " + f + "\n";
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

	public static class BranchementContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public InstructionContext instruction;
		public InstructionContext thenins;
		public InstructionContext elseins;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public BranchementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchement; }
	}

	public final BranchementContext branchement() throws RecognitionException {
		BranchementContext _localctx = new BranchementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_branchement);
		int _la;
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				match(T__26);
				setState(271);
				match(T__2);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__18) | (1L << T__19) | (1L << T__22) | (1L << ENTIER) | (1L << DOUBLE) | (1L << IDENTIFIANT))) != 0)) {
					{
					{
					setState(272);
					((BranchementContext)_localctx).condition = condition(0);
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(278);
				match(T__3);
				setState(279);
				((BranchementContext)_localctx).instruction = instruction();
				String  f = getNewLabel();
				                                            ((BranchementContext)_localctx).code =  ((BranchementContext)_localctx).condition.code + "JUMPF " + f + "\n" + ((BranchementContext)_localctx).instruction.code + "LABEL " + f +"\n";
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(T__26);
				setState(283);
				match(T__2);
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__18) | (1L << T__19) | (1L << T__22) | (1L << ENTIER) | (1L << DOUBLE) | (1L << IDENTIFIANT))) != 0)) {
					{
					{
					setState(284);
					((BranchementContext)_localctx).condition = condition(0);
					}
					}
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(290);
				match(T__3);
				setState(291);
				((BranchementContext)_localctx).thenins = instruction();
				setState(292);
				match(T__27);
				setState(293);
				((BranchementContext)_localctx).elseins = instruction();
				 String f = getNewLabel();
				                                        String d = getNewLabel();
				                                        ((BranchementContext)_localctx).code =  ((BranchementContext)_localctx).condition.code + "JUMPF " + f + "\n" + ((BranchementContext)_localctx).thenins.code + "JUMP " + d + "\n" + "LABEL " + f + "\n" + ((BranchementContext)_localctx).elseins.code + "LABEL " + d +"\n";
				                                       
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

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public DeclContext decl;
		public InstructionContext instruction;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fonction);
		tablesSymboles.enterFunction();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			((FonctionContext)_localctx).TYPE = match(TYPE);
			setState(299);
			((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			tablesSymboles.addFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null), (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
			setState(301);
			match(T__2);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(302);
				params();
				}
			}

			setState(305);
			match(T__3);
			setState(306);
			match(T__0);
			((FonctionContext)_localctx).code =   "LABEL " + (((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null) + "\n";
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(308);
				match(NEWLINE);
				}
				break;
			}
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(311);
				((FonctionContext)_localctx).decl = decl();
				_localctx.code += ((FonctionContext)_localctx).decl.code; 
				}
				}
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(319);
					match(NEWLINE);
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << NEWLINE) | (1L << ENTIER) | (1L << DOUBLE) | (1L << RETURN) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(325);
				((FonctionContext)_localctx).instruction = instruction();
				_localctx.code += ((FonctionContext)_localctx).instruction.code;
				}
				}
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(333);
			match(T__1);
			 _localctx.code += "RETURN\n";
			setState(338);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(335);
					match(NEWLINE);
					}
					} 
				}
				setState(340);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
			_ctx.stop = _input.LT(-1);
			tablesSymboles.exitFunction();
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

	public static class ParamsContext extends ParserRuleContext {
		public Token TYPE;
		public Token IDENTIFIANT;
		public List<TerminalNode> TYPE() { return getTokens(CalculetteParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CalculetteParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(CalculetteParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(CalculetteParser.IDENTIFIANT, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(342);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

			        tablesSymboles.addParam((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
			    
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__28) {
				{
				{
				setState(344);
				match(T__28);
				setState(345);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(346);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				        tablesSymboles.addParam((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
				    
				}
				}
				setState(352);
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

	public static class ArgsContext extends ParserRuleContext {
		public String code;
		public int size;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_args);
		((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0;
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << ENTIER) | (1L << DOUBLE) | (1L << IDENTIFIANT))) != 0)) {
				{
				setState(353);
				((ArgsContext)_localctx).expression = expression(0);

				        ((ArgsContext)_localctx).code =  ((ArgsContext)_localctx).expression.code;
				        ((ArgsContext)_localctx).size =  sizeArgsF(((ArgsContext)_localctx).expression.type, _localctx.size);
				    
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__28) {
					{
					{
					setState(355);
					match(T__28);
					setState(356);
					((ArgsContext)_localctx).expression = expression(0);

					        ((ArgsContext)_localctx).code =  _localctx.code + ((ArgsContext)_localctx).expression.code;
					        ((ArgsContext)_localctx).size =  sizeArgsF(((ArgsContext)_localctx).expression.type, _localctx.size);
					    
					}
					}
					setState(363);
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

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(367); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(366);
					_la = _input.LA(1);
					if ( !(_la==T__25 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(369); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 10:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u0176\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3\3"+
		"\3\7\3\65\n\3\f\3\16\38\13\3\3\3\3\3\3\3\7\3=\n\3\f\3\16\3@\13\3\3\3\7"+
		"\3C\n\3\f\3\16\3F\13\3\3\3\3\3\3\3\3\3\7\3L\n\3\f\3\16\3O\13\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\7\4W\n\4\f\4\16\4Z\13\4\3\4\3\4\7\4^\n\4\f\4\16\4a\13"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5\u008b\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6\u00a7\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00b3\n\6\f"+
		"\6\16\6\u00b6\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"\u00c4\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t"+
		"\u00d4\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ee\n\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00fa\n\f\f\f\16\f\u00fd\13\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\7\17\u0114\n\17\f\17\16\17\u0117\13\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\7\17\u0120\n\17\f\17\16\17\u0123\13\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\5\17\u012b\n\17\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u0132\n\20\3\20\3\20\3\20\3\20\5\20\u0138\n\20\3\20\3\20\3\20\7\20\u013d"+
		"\n\20\f\20\16\20\u0140\13\20\3\20\7\20\u0143\n\20\f\20\16\20\u0146\13"+
		"\20\3\20\3\20\3\20\7\20\u014b\n\20\f\20\16\20\u014e\13\20\3\20\3\20\3"+
		"\20\7\20\u0153\n\20\f\20\16\20\u0156\13\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\7\21\u015f\n\21\f\21\16\21\u0162\13\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\7\22\u016a\n\22\f\22\16\22\u016d\13\22\5\22\u016f\n\22\3\23\6"+
		"\23\u0172\n\23\r\23\16\23\u0173\3\23\2\4\n\26\24\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$\2\6\3\2\b\t\4\2\7\7\n\n\3\2\17\24\4\2\34\34\"\""+
		"\2\u0190\2&\3\2\2\2\4/\3\2\2\2\6R\3\2\2\2\b\u008a\3\2\2\2\n\u00a6\3\2"+
		"\2\2\f\u00c3\3\2\2\2\16\u00c5\3\2\2\2\20\u00d3\3\2\2\2\22\u00d5\3\2\2"+
		"\2\24\u00da\3\2\2\2\26\u00ed\3\2\2\2\30\u00fe\3\2\2\2\32\u0105\3\2\2\2"+
		"\34\u012a\3\2\2\2\36\u012c\3\2\2\2 \u0157\3\2\2\2\"\u016e\3\2\2\2$\u0171"+
		"\3\2\2\2&\'\5\4\3\2\'(\7\2\2\3()\b\2\1\2)\3\3\2\2\2*+\5\f\7\2+,\b\3\1"+
		"\2,.\3\2\2\2-*\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2"+
		"\61/\3\2\2\2\62\66\b\3\1\2\63\65\7\"\2\2\64\63\3\2\2\2\658\3\2\2\2\66"+
		"\64\3\2\2\2\66\67\3\2\2\2\67>\3\2\2\28\66\3\2\2\29:\5\36\20\2:;\b\3\1"+
		"\2;=\3\2\2\2<9\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?D\3\2\2\2@>\3\2\2"+
		"\2AC\7\"\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2"+
		"\2GM\b\3\1\2HI\5\b\5\2IJ\b\3\1\2JL\3\2\2\2KH\3\2\2\2LO\3\2\2\2MK\3\2\2"+
		"\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\b\3\1\2Q\5\3\2\2\2RX\7\3\2\2ST\5\b"+
		"\5\2TU\b\4\1\2UW\3\2\2\2VS\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2"+
		"\2\2ZX\3\2\2\2[_\7\4\2\2\\^\7\"\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3"+
		"\2\2\2`\7\3\2\2\2a_\3\2\2\2bc\5\n\6\2cd\5$\23\2de\b\5\1\2e\u008b\3\2\2"+
		"\2fg\5\16\b\2gh\5$\23\2hi\b\5\1\2i\u008b\3\2\2\2jk\5\20\t\2kl\5$\23\2"+
		"lm\b\5\1\2m\u008b\3\2\2\2no\5\22\n\2op\5$\23\2pq\b\5\1\2q\u008b\3\2\2"+
		"\2rs\5\24\13\2st\5$\23\2tu\b\5\1\2u\u008b\3\2\2\2vw\5\30\r\2wx\b\5\1\2"+
		"x\u008b\3\2\2\2yz\5\32\16\2z{\b\5\1\2{\u008b\3\2\2\2|}\5\6\4\2}~\b\5\1"+
		"\2~\u008b\3\2\2\2\177\u0080\5\34\17\2\u0080\u0081\b\5\1\2\u0081\u008b"+
		"\3\2\2\2\u0082\u0083\7\'\2\2\u0083\u0084\5\n\6\2\u0084\u0085\5$\23\2\u0085"+
		"\u0086\b\5\1\2\u0086\u008b\3\2\2\2\u0087\u0088\5$\23\2\u0088\u0089\b\5"+
		"\1\2\u0089\u008b\3\2\2\2\u008ab\3\2\2\2\u008af\3\2\2\2\u008aj\3\2\2\2"+
		"\u008an\3\2\2\2\u008ar\3\2\2\2\u008av\3\2\2\2\u008ay\3\2\2\2\u008a|\3"+
		"\2\2\2\u008a\177\3\2\2\2\u008a\u0082\3\2\2\2\u008a\u0087\3\2\2\2\u008b"+
		"\t\3\2\2\2\u008c\u008d\b\6\1\2\u008d\u008e\7\5\2\2\u008e\u008f\5\n\6\2"+
		"\u008f\u0090\7\6\2\2\u0090\u0091\b\6\1\2\u0091\u00a7\3\2\2\2\u0092\u0093"+
		"\7\7\2\2\u0093\u0094\5\n\6\n\u0094\u0095\b\6\1\2\u0095\u00a7\3\2\2\2\u0096"+
		"\u0097\7(\2\2\u0097\u0098\7\5\2\2\u0098\u0099\7\6\2\2\u0099\u00a7\b\6"+
		"\1\2\u009a\u009b\7(\2\2\u009b\u009c\7\5\2\2\u009c\u009d\5\"\22\2\u009d"+
		"\u009e\7\6\2\2\u009e\u009f\b\6\1\2\u009f\u00a7\3\2\2\2\u00a0\u00a1\7$"+
		"\2\2\u00a1\u00a7\b\6\1\2\u00a2\u00a3\7%\2\2\u00a3\u00a7\b\6\1\2\u00a4"+
		"\u00a5\7(\2\2\u00a5\u00a7\b\6\1\2\u00a6\u008c\3\2\2\2\u00a6\u0092\3\2"+
		"\2\2\u00a6\u0096\3\2\2\2\u00a6\u009a\3\2\2\2\u00a6\u00a0\3\2\2\2\u00a6"+
		"\u00a2\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00b4\3\2\2\2\u00a8\u00a9\f\t"+
		"\2\2\u00a9\u00aa\t\2\2\2\u00aa\u00ab\5\n\6\n\u00ab\u00ac\b\6\1\2\u00ac"+
		"\u00b3\3\2\2\2\u00ad\u00ae\f\b\2\2\u00ae\u00af\t\3\2\2\u00af\u00b0\5\n"+
		"\6\t\u00b0\u00b1\b\6\1\2\u00b1\u00b3\3\2\2\2\u00b2\u00a8\3\2\2\2\u00b2"+
		"\u00ad\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\13\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7&\2\2\u00b8\u00b9"+
		"\7(\2\2\u00b9\u00ba\5$\23\2\u00ba\u00bb\b\7\1\2\u00bb\u00c4\3\2\2\2\u00bc"+
		"\u00bd\7&\2\2\u00bd\u00be\7(\2\2\u00be\u00bf\7\13\2\2\u00bf\u00c0\5\n"+
		"\6\2\u00c0\u00c1\5$\23\2\u00c1\u00c2\b\7\1\2\u00c2\u00c4\3\2\2\2\u00c3"+
		"\u00b7\3\2\2\2\u00c3\u00bc\3\2\2\2\u00c4\r\3\2\2\2\u00c5\u00c6\7(\2\2"+
		"\u00c6\u00c7\7\13\2\2\u00c7\u00c8\5\n\6\2\u00c8\u00c9\b\b\1\2\u00c9\17"+
		"\3\2\2\2\u00ca\u00cb\7\f\2\2\u00cb\u00cc\7(\2\2\u00cc\u00cd\7\6\2\2\u00cd"+
		"\u00d4\b\t\1\2\u00ce\u00cf\7\f\2\2\u00cf\u00d0\5\n\6\2\u00d0\u00d1\7\6"+
		"\2\2\u00d1\u00d2\b\t\1\2\u00d2\u00d4\3\2\2\2\u00d3\u00ca\3\2\2\2\u00d3"+
		"\u00ce\3\2\2\2\u00d4\21\3\2\2\2\u00d5\u00d6\7\r\2\2\u00d6\u00d7\7(\2\2"+
		"\u00d7\u00d8\7\6\2\2\u00d8\u00d9\b\n\1\2\u00d9\23\3\2\2\2\u00da\u00db"+
		"\7(\2\2\u00db\u00dc\7\16\2\2\u00dc\u00dd\5\n\6\2\u00dd\u00de\b\13\1\2"+
		"\u00de\25\3\2\2\2\u00df\u00e0\b\f\1\2\u00e0\u00e1\5\n\6\2\u00e1\u00e2"+
		"\t\4\2\2\u00e2\u00e3\5\n\6\2\u00e3\u00e4\b\f\1\2\u00e4\u00ee\3\2\2\2\u00e5"+
		"\u00e6\7\25\2\2\u00e6\u00ee\b\f\1\2\u00e7\u00e8\7\26\2\2\u00e8\u00ee\b"+
		"\f\1\2\u00e9\u00ea\7\31\2\2\u00ea\u00eb\5\26\f\3\u00eb\u00ec\b\f\1\2\u00ec"+
		"\u00ee\3\2\2\2\u00ed\u00df\3\2\2\2\u00ed\u00e5\3\2\2\2\u00ed\u00e7\3\2"+
		"\2\2\u00ed\u00e9\3\2\2\2\u00ee\u00fb\3\2\2\2\u00ef\u00f0\f\5\2\2\u00f0"+
		"\u00f1\7\27\2\2\u00f1\u00f2\5\26\f\6\u00f2\u00f3\b\f\1\2\u00f3\u00fa\3"+
		"\2\2\2\u00f4\u00f5\f\4\2\2\u00f5\u00f6\7\30\2\2\u00f6\u00f7\5\26\f\5\u00f7"+
		"\u00f8\b\f\1\2\u00f8\u00fa\3\2\2\2\u00f9\u00ef\3\2\2\2\u00f9\u00f4\3\2"+
		"\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\27\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\7\32\2\2\u00ff\u0100\7\5\2"+
		"\2\u0100\u0101\5\26\f\2\u0101\u0102\7\6\2\2\u0102\u0103\5\b\5\2\u0103"+
		"\u0104\b\r\1\2\u0104\31\3\2\2\2\u0105\u0106\7\33\2\2\u0106\u0107\7\5\2"+
		"\2\u0107\u0108\5\16\b\2\u0108\u0109\7\34\2\2\u0109\u010a\5\26\f\2\u010a"+
		"\u010b\7\34\2\2\u010b\u010c\5\16\b\2\u010c\u010d\7\6\2\2\u010d\u010e\5"+
		"\b\5\2\u010e\u010f\b\16\1\2\u010f\33\3\2\2\2\u0110\u0111\7\35\2\2\u0111"+
		"\u0115\7\5\2\2\u0112\u0114\5\26\f\2\u0113\u0112\3\2\2\2\u0114\u0117\3"+
		"\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117"+
		"\u0115\3\2\2\2\u0118\u0119\7\6\2\2\u0119\u011a\5\b\5\2\u011a\u011b\b\17"+
		"\1\2\u011b\u012b\3\2\2\2\u011c\u011d\7\35\2\2\u011d\u0121\7\5\2\2\u011e"+
		"\u0120\5\26\f\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3"+
		"\2\2\2\u0121\u0122\3\2\2\2\u0122\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124"+
		"\u0125\7\6\2\2\u0125\u0126\5\b\5\2\u0126\u0127\7\36\2\2\u0127\u0128\5"+
		"\b\5\2\u0128\u0129\b\17\1\2\u0129\u012b\3\2\2\2\u012a\u0110\3\2\2\2\u012a"+
		"\u011c\3\2\2\2\u012b\35\3\2\2\2\u012c\u012d\7&\2\2\u012d\u012e\7(\2\2"+
		"\u012e\u012f\b\20\1\2\u012f\u0131\7\5\2\2\u0130\u0132\5 \21\2\u0131\u0130"+
		"\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\7\6\2\2\u0134"+
		"\u0135\7\3\2\2\u0135\u0137\b\20\1\2\u0136\u0138\7\"\2\2\u0137\u0136\3"+
		"\2\2\2\u0137\u0138\3\2\2\2\u0138\u013e\3\2\2\2\u0139\u013a\5\f\7\2\u013a"+
		"\u013b\b\20\1\2\u013b\u013d\3\2\2\2\u013c\u0139\3\2\2\2\u013d\u0140\3"+
		"\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0144\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0141\u0143\7\"\2\2\u0142\u0141\3\2\2\2\u0143\u0146\3\2"+
		"\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u014c\3\2\2\2\u0146"+
		"\u0144\3\2\2\2\u0147\u0148\5\b\5\2\u0148\u0149\b\20\1\2\u0149\u014b\3"+
		"\2\2\2\u014a\u0147\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c"+
		"\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\7\4"+
		"\2\2\u0150\u0154\b\20\1\2\u0151\u0153\7\"\2\2\u0152\u0151\3\2\2\2\u0153"+
		"\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\37\3\2\2"+
		"\2\u0156\u0154\3\2\2\2\u0157\u0158\7&\2\2\u0158\u0159\7(\2\2\u0159\u0160"+
		"\b\21\1\2\u015a\u015b\7\37\2\2\u015b\u015c\7&\2\2\u015c\u015d\7(\2\2\u015d"+
		"\u015f\b\21\1\2\u015e\u015a\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3"+
		"\2\2\2\u0160\u0161\3\2\2\2\u0161!\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0164"+
		"\5\n\6\2\u0164\u016b\b\22\1\2\u0165\u0166\7\37\2\2\u0166\u0167\5\n\6\2"+
		"\u0167\u0168\b\22\1\2\u0168\u016a\3\2\2\2\u0169\u0165\3\2\2\2\u016a\u016d"+
		"\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016f\3\2\2\2\u016d"+
		"\u016b\3\2\2\2\u016e\u0163\3\2\2\2\u016e\u016f\3\2\2\2\u016f#\3\2\2\2"+
		"\u0170\u0172\t\5\2\2\u0171\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0171"+
		"\3\2\2\2\u0173\u0174\3\2\2\2\u0174%\3\2\2\2\37/\66>DMX_\u008a\u00a6\u00b2"+
		"\u00b4\u00c3\u00d3\u00ed\u00f9\u00fb\u0115\u0121\u012a\u0131\u0137\u013e"+
		"\u0144\u014c\u0154\u0160\u016b\u016e\u0173";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}