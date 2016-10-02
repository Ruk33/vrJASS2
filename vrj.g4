grammar vrj;

init: (
    typeDefinition |
    nativeDefinition |
    globalDefinition |
    functionDefinition |
    NL
)* EOF;

name: ID;

type: ID | 'nothing';

param: type name;

paramList: (param (',' param)*) | 'nothing';

typeDefinition: 'type' typeName=name ('extends' typeExtends=name) NL;

functionSignature: name 'takes' paramList 'returns' type NL;

nativeDefinition: ('constant')? 'native' functionSignature;

arguments: '(' expressionList? ')';

functionExpression: name arguments;

variableExpression: name ('[' expression ']')?;

expression:
'(' expression ')' #Parenthesis |
'-' expression #Negative |
'not' expression #Not |
expression '%' expression #Mod |
expression '/' expression #Div |
expression '*' expression #Mult |
expression '+' expression #Sum |
expression '-' expression #Sub |
variableExpression #IgnoreVariableExpression |
functionExpression #IgnoreFunctionExpression |
expression operator=('=='|'!='|'<='|'<'|'>'|'>=') expression #Comparison |
expression operator=('or'|'and') expression #Logical |
'function' name #Code |
('true'|'false') #Boolean |
'null' #Null |
STRING #String |
REAL #Real |
INT #Integer;

expressionList: expression (',' expression)*;

variableStatement: type ('array')? name ('=' expression)? NL;

globalDefinition:
'globals' NL
    ((('constant')? variableStatement) | NL)*
'endglobals' NL;

loopStatement:
'loop' NL
    statements
'endloop' NL;

elseIfStatement: 'elseif' expression 'then' NL statements;

elseStatement: 'else' NL statements;

ifStatement:
'if' expression 'then' NL
    statements
elseIfStatement*
elseStatement?
'endif' NL;

statement:
'local' variableStatement #LocalVariable |
'set' variableExpression '=' expression NL #SetVariable |
'exitwhen' expression NL #Exitwhen |
'call' functionExpression NL #FunctionCall |
'return' expression? NL #Return |
ifStatement #IgnoreIf |
loopStatement #IgnoreLoop;

statements: (statement | NL)*;

functionDefinition:
'function' functionSignature
    statements
'endfunction' NL;

STRING: '"' .*? '"';
REAL: [0-9]+ '.' [0-9]* | '.'[0-9]+;
INT: [0-9]+ | '0x' [0-9a-fA-F]+ | '\'' . . . . '\'' | '\'' . '\'';

NL: [\r\n]+;
ID: [a-zA-Z_][a-zA-Z0-9_]*;

WS : [ \t]+ -> channel(HIDDEN);
COMMENT : '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);