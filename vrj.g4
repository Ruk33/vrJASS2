grammar vrj;

init:
    ( typeDefinition
    | nativeDefinition
    | globalDefinition
    | functionDefinition
    | libraryDefinition
    | structDefinition
    | NL
    )*
    EOF
    ;

visibility: 'private' | 'public';

member: variableExpression | functionExpression;

memberExpression: member ('.' member)+;

name: ID;

type: memberExpression | name | 'nothing';

param: type name;

paramList:
    ( param (',' param)* )
    | 'nothing'
    ;

typeDefinition: 'type' typeName=name ('extends' typeExtends=name) NL;

functionSignature: name 'takes' paramList 'returns' type NL;

nativeDefinition: ('constant')? 'native' functionSignature;

arguments: '(' expressionList? ')';

functionExpression: name arguments;

variableExpression: name ('[' expression ']')?;

expression:
     '(' expression ')' #Parenthesis
    | '-' expression #Negative
    | 'not' expression #Not
    | expression '%' expression #Mod
    | expression '/' expression #Div
    | expression '*' expression #Mult
    | expression '+' expression #Sum
    | expression '-' expression #Sub
    | memberExpression #IgnoreMemberExpression
    | variableExpression #IgnoreVariableExpression
    | functionExpression #IgnoreFunctionExpression
    | expression operator=('=='|'!='|'<='|'<'|'>'|'>=') expression #Comparison
    | expression operator=('or'|'and') expression #Logical
    | 'function' name #Code
    | ('true'|'false') #Boolean
    | 'null' #Null
    | STRING #String
    | REAL #Real
    | INT #Integer
    ;

expressionList: expression (',' expression)*;

variableStatement: type (array='array')? name ('=' expression)? NL;

globalVariable: visibility? (constant='constant')? variableStatement;

globalDefinition:
    'globals' NL
        (globalVariable | NL)*
    'endglobals' NL;

loopStatement:
    'loop' NL
        statements
    'endloop' NL;

elseIfStatement: 'elseif' expression 'then' NL statements;

elseStatement: 'else' NL statements;

ifStatement:
    (sstatic='static')? 'if' expression 'then' NL
        statements
    elseIfStatement*
    elseStatement?
    'endif' NL;

localVariable: 'local' variableStatement;
setVariable: 'set' (variableExpression | memberExpression) '=' expression NL;
exitwhen: 'exitwhen' expression NL;
functionCall: 'call' (functionExpression | memberExpression) NL;
returnStatement: 'return' expression? NL;

statement:
      localVariable
    | setVariable
    | exitwhen
    | functionCall
    | returnStatement
    | ifStatement
    | loopStatement
    ;

statements: (statement | NL)*;

functionDefinition:
    visibility? 'function' functionSignature
        statements
    'endfunction' NL;

libraryRequirementExpression: name (',' name)*;

libraryBody:
    ( globalDefinition
    | functionDefinition
    | structDefinition
    | NL
    )*
    ;

libraryDefinition:
    'library' name ('initializer' initializer=name)? ('requires' libraryRequirementExpression)? NL
        libraryBody
     'endlibrary' NL;

 propertyStatement: visibility? (sstatic='static')? variableStatement;

 methodDefinition:
     visibility? (sstatic='static')? 'method' (operator='operator')? functionSignature
        statements
     'endmethod' NL;

extendable:
      'array'
    | name
    | memberExpression
    ;

structBody:
    ( propertyStatement
    | methodDefinition
    | NL
    )*
    ;

structDefinition:
    visibility? 'struct' name ('extends' extendsFrom=extendable)? NL
        structBody
    'endstruct' NL;

STRING: '"' .*? '"';
REAL: [0-9]+ '.' [0-9]* | '.'[0-9]+;
INT: [0-9]+ | '0x' [0-9a-fA-F]+ | '\'' . . . . '\'' | '\'' . '\'';

NL: [\r\n]+;
ID: [a-zA-Z_][a-zA-Z0-9_]*;

WS : [ \t]+ -> channel(HIDDEN);
COMMENT : '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);