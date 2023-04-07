grammar Calculette;
//fonction

@parser::members {
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
            
}

start
    : calcul EOF {System.out.println($calcul.code);};

calcul returns [ String code ]
@init{ $code = new String(); }   // On initialise code, pour l'utiliser comme accumulateur 
//@after{ Systexm.out.println($code); } // On affiche l’ensemble du code produit

    : 
        (decl { $code += $decl.code; })*
        { $code += "  JUMP Main\n"; }
        NEWLINE*

        (fonction { $code += $fonction.code; })* 
        NEWLINE*

        { $code += "LABEL Main\n"; }
        (instruction { $code += $instruction.code; })*

        { $code += "HALT\n"; }
    ;

bloc returns [ String code ]  @init{ $code = new String(); } 
    : '{' 
        (instruction { $code += $instruction.code; })*
      '}'

      NEWLINE*
    ;

instruction returns [ String code ] 
    : expression finInstruction 
        { 
            $code = $expression.code;
        }

    | assignation finInstruction
        {
            $code = $assignation.code;
        }

    | lire finInstruction
        {
            $code = $lire.code;
        }

    | ecrire finInstruction
        {
            $code = $ecrire.code;
        }

    | plusEgal finInstruction
        {
            $code = $plusEgal.code;
        }

    | boucleWhile
        {
            $code = $boucleWhile.code;
        }

    | boucleFor
        {
            $code = $boucleFor.code;
        }

    | bloc
        {
            $code = $bloc.code;
        }

    | branchement
        {
            $code = $branchement.code;
        }

    | RETURN expression finInstruction
        {
            $code= $expression.code + returnChoix(var, $expression.type);
        }
        
   | finInstruction
        {
            $code="";
        }

    ;

expression returns [ String code, String type]
    : '(' e=expression ')' {$code = $e.code; $type=$e.type;}
    | '-' e=expression {$code = "PUSHI 0 \n" + $e.code + "SUB\n";$type = $e.type;}
    | a=expression op=('*'|'/') b=expression {$code = evalexpr($a.code,$op.text,$b.code, $a.type, $b.type); $type = $a.type;}
    | a=expression op=('+'|'-') b=expression {$code = evalexpr($a.code,$op.text,$b.code, $a.type, $b.type); $type = $a.type;}
    | IDENTIFIANT '(' ')' {$code = resFonction(tablesSymboles.getFunction($IDENTIFIANT.text)) + "CALL " + $IDENTIFIANT.text + "\n";
                            $type = tablesSymboles.getFunction($IDENTIFIANT.text);}
    | IDENTIFIANT '('args')' {$code = resFonction(tablesSymboles.getFunction($IDENTIFIANT.text)) + $args.code + "CALL " + $IDENTIFIANT.text + "\n" + videPile($args.size);
                                $type = tablesSymboles.getFunction($IDENTIFIANT.text);}
    | ENTIER {$code = "PUSHI " + $ENTIER.text + "\n"; 
              $type = "int";}
    | DOUBLE {$code = "PUSHF " + $DOUBLE.text + "\n"; 
              $type = "double";}
    | IDENTIFIANT {$code = pushChoix(tablesSymboles.getVar($IDENTIFIANT.text)); 
                   $type = tablesSymboles.getVar($IDENTIFIANT.text).type;}
    ;

decl returns [ String code]
    : 
        TYPE IDENTIFIANT finInstruction
        {
            $code = declaFloat($TYPE.text);
            tablesSymboles.addVarDecl($IDENTIFIANT.text, $TYPE.text);
        }

     | TYPE IDENTIFIANT '=' expression finInstruction
        {
            $code = $expression.code;
            tablesSymboles.addVarDecl($IDENTIFIANT.text, $TYPE.text);
        }
    ;

assignation returns [String code]
    : 
        IDENTIFIANT '=' expression
        {   var = tablesSymboles.getVar($IDENTIFIANT.text);
            $code = $expression.code  + assignationChoix(var);
        }
    ;

lire returns [ String code]
    : 
        'print(' IDENTIFIANT ')' 
        {   var = tablesSymboles.getVar($IDENTIFIANT.text);
            $code = printFloat(var.type, var);
        }

    | 'print(' expression ')'
        {
            $code = print($expression.code, $expression.type);
        }
    ;

ecrire returns [ String code]
    : 
        'input(' IDENTIFIANT ')' 
        {   var = tablesSymboles.getVar($IDENTIFIANT.text);
            $code = readFloat(var.type, var);
        }
    ;

plusEgal returns [ String code]
    : 
        IDENTIFIANT '+=' expression
        {   var = tablesSymboles.getVar($IDENTIFIANT.text);
            $code = "PUSH" + choix(var.scope) + var.address + "\n" + 
            $expression.code + "ADD\n" + "STORE" + 
            choix(var.scope) + var.address + "\n";
        }
    ;

condition returns [String code]
    : c=expression cd=('=='|'!='|'>'|'>='|'<'|'<=') d=expression {$code = evalcond($c.code,$cd.text,$d.code, $c.type, $d.type); }
    | 'true'  { $code = "  PUSHI 1\n"; }
    | 'false' { $code = "  PUSHI 0\n"; }
    | a=condition '&&' b=condition { $code = $a.code + "PUSHI 1\n" + "EQUAL\n" + $b.code + "PUSHI 1\n" + "EQUAL\n" + "ADD\n" + "PUSHI 2\n" + "EQUAL\n"; }
    | a=condition '||' b=condition { $code = $a.code + "PUSHI 1\n" + "EQUAL\n" + $b.code + "PUSHI 1\n" + "EQUAL\n" + "ADD\n" + "PUSHI 1\n" + "SUPEQ\n" ; }
    | '!' b=condition {String f = getNewLabel();
                                        String d = getNewLabel();
                                        $code = $b.code + "JUMPF " + f + "\n" + "PUSHI 0\n" + "JUMP " + d + "\n" + "LABEL " + f + "\n" + "PUSHI 1\n" + "LABEL " + d +"\n";}
    ;

boucleWhile returns [String code]
    : 'while' '(' condition ')' instruction { String d = getNewLabel();
                                       String f = getNewLabel();
                                       $code = "LABEL " + d +"\n" + $condition.code + "JUMPF " + f + "\n" + $instruction.code + "JUMP " + d + "\n" + "LABEL " + f + "\n";}
    ;

boucleFor returns [String code]
    : 'for' '(' a=assignation ';' condition ';' b=assignation ')' instruction { 
                                       String d = getNewLabel();
                                       String f = getNewLabel();
                                       $code = $a.code + "LABEL " + d +"\n" + $condition.code + "JUMPF " + f +"\n" +  $instruction.code + $b.code + "JUMP " + d + "\n" + "LABEL " + f + "\n";}
    ;

branchement returns [String code]
    : 'if' '(' condition* ')' instruction {String  f = getNewLabel();
                                            $code = $condition.code + "JUMPF " + f + "\n" + $instruction.code + "LABEL " + f +"\n";}
    |'if' '(' condition* ')' thenins=instruction 'else' elseins=instruction{ String f = getNewLabel();
                                        String d = getNewLabel();
                                        $code = $condition.code + "JUMPF " + f + "\n" + $thenins.code + "JUMP " + d + "\n" + "LABEL " + f + "\n" + $elseins.code + "LABEL " + d +"\n";
                                       }
    ;

fonction returns [String code]
    @init {tablesSymboles.enterFunction();}
    @after {tablesSymboles.exitFunction();}
    : TYPE IDENTIFIANT 
        {tablesSymboles.addFunction($IDENTIFIANT.text, $TYPE.text);} 
        '(' params ? ')'
        '{'
        {$code =  "LABEL " + $IDENTIFIANT.text + "\n";}

        NEWLINE?

        (decl {$code += $decl.code; })*

        NEWLINE*

        (instruction {$code += $instruction.code;})*
        '}'

    { $code += "RETURN\n";}
    NEWLINE*
    ;


params
    : TYPE IDENTIFIANT
    {
        tablesSymboles.addParam($IDENTIFIANT.text, $TYPE.text);
    }
    (',' TYPE IDENTIFIANT
    {
        tablesSymboles.addParam($IDENTIFIANT.text, $TYPE.text);
    }
    )*
    ;


args returns [String code, int size]
@init{$code = new String(); $size = 0;}
: ( expression
    {
        $code = $expression.code;
        $size = sizeArgsF($expression.type, $size);
    }
    (',' expression
    {
        $code = $code + $expression.code;
        $size = sizeArgsF($expression.type, $size);
    }
    )*
    )?
    ;


finInstruction : ( NEWLINE | ';' )+ ;

COMMENTAIREMULTI : '/*' .*? '*/' -> skip;

COMMENTAIRESIMPLE : '%' .*?  NEWLINE-> skip;

NEWLINE : '\r'? '\n';

WS : (' '|'\t')+ -> skip ;

ENTIER : ('0'..'9')+ ;

DOUBLE : ('0'..'9')+('.')('0'..'9')*;

TYPE : 'int' | 'double';

RETURN: 'return';

IDENTIFIANT : (('a'..'z')|('A'..'Z'))(('a'..'z')|('A'..'Z')|('0'..'9'))*;