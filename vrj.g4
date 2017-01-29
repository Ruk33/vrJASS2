/**
 * MIT License
 *
 * Copyright (c) 2017 Franco Montenegro
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
grammar vrj;

init
  : (topDeclaration | NL)* EOF
  ;

topDeclaration
  : libraryDeclaration
  | scopeDeclaration
  | structDeclaration
  | typeDeclaration
  | nativeDeclaration
  | functionDeclaration
  | globalDeclaration
  ;

visibility
  : 'private'
  | 'public'
  ;

name
  : ID
  ;

type
  : expression
  | 'nothing'
  ;

param
  : type name
  ;

paramList
  : (param (',' param)*)
  | 'nothing'
  ;

typeDeclaration
  : 'type' typeName=name ('extends' typeExtends=name)? NL
  ;

functionSignature
  : name 'takes' paramList 'returns' type NL
  ;

nativeDeclaration
  : ('constant')? 'native' functionSignature
  ;

arguments
  : '(' expressionList? ')'
  ;

expression
  : '(' expression ')' #ParenthesisExpression
  | left=expression '.' right=expression #ChainExpression
  | variable=name ('[' index=expression ']')? #VariableExpression
  | function=name arguments #FunctionExpression
  | '-' expression #NegativeExpression
  | 'not' expression #NotExpression
  | left=expression '%' right=expression #ModuloExpression
  | left=expression operator=('/' | '*') right=expression #DivMultExpression
  | left=expression operator=('+' | '-') right=expression #SumSubExpression
  | left=expression operator=('==' | '!=' | '<=' | '<' | '>' | '>=') right=expression #ComparisonExpression
  | left=expression operator=('or' | 'and') right=expression #LogicalExpression
  | 'function' code=expression #CodeExpression
  | ('true' | 'false') #BooleanExpression
  | 'null' #NullExpression
  | STRING #StringExpression
  | REAL #RealExpression
  | INT #IntegerExpression
  ;

expressionList
  : expression (',' expression)*
  ;

variableDeclaration
  : type 'array' name NL #ArrayVariableDeclaration
  | type name ('=' value=expression)? NL #NonArrayVariableDeclaration
  ;

globalVariableDeclaration
  : visibility? (constant='constant')? variableDeclaration
  ;

globalDeclaration
  : 'globals' NL
      (globalVariableDeclaration | NL)*
    'endglobals' NL
  ;

loopStatement
  : 'loop' NL
      statements
    'endloop' NL
  ;

elseIfStatement
  : 'elseif' condition=expression 'then' NL statements
  ;

elseStatement
  : 'else' NL statements
  ;

ifStatement
  : (sstatic='static')? 'if' condition=expression 'then' NL
      statements
    elseIfStatement*
    elseStatement?
    'endif' NL
  ;

localVariableDeclaration
  : 'local' variableDeclaration
  ;

setVariableStatement
  : 'set' variable=expression '=' value=expression NL
  ;

exitWhenStatement
  : 'exitwhen' condition=expression NL
  ;

functionCallStatement
  : 'call' function=expression NL
  ;

returnStatement
  : 'return' expression? NL
  ;

statement
  : localVariableDeclaration
  | setVariableStatement
  | exitWhenStatement
  | functionCallStatement
  | returnStatement
  | ifStatement
  | loopStatement
  ;

statements
  : (statement | NL)*
  ;

functionDeclaration
  : visibility? 'function' functionSignature
      statements
    'endfunction' NL
  ;

libraryRequirementsExpression
  : name (',' name)*
  ;

libraryBody
  : ( globalDeclaration
    | functionDeclaration
    | structDeclaration
    | scopeDeclaration
    | NL
    )*
  ;

libraryDeclaration
  : 'library' name ('initializer' initializer=name)? ('requires' libraryRequirementsExpression)? NL
      libraryBody
    'endlibrary' NL
  ;

scopeBody
  : ( functionDeclaration
    | structDeclaration
    | globalDeclaration
    | scopeDeclaration
    | NL
    )*
  ;

scopeDeclaration
  : 'scope' name ('initializer' initializer=name)? NL
      scopeBody
    'endscope' NL
  ;

propertyDeclaration
  : visibility? (sstatic='static')? variableDeclaration
  ;

methodDeclaration
  : visibility? (sstatic='static')? 'method' (operator='operator')? functionSignature
      statements
    'endmethod' NL
  ;

extendsFromExpression
  : 'array'
  | expression
  ;

structBody
  : ( propertyDeclaration
    | methodDeclaration
    | NL
    )*
  ;

structDeclaration
  : visibility? 'struct' name ('extends' extendsFromExpression)? NL
      structBody
    'endstruct' NL
  ;

STRING
  : '"' .*? '"'
  ;

// Credits to WurstScript
REAL
  : [0-9]+ '.' [0-9]*
  | '.'[0-9]+
  ;

// Credits to WurstScript
INT
  : [0-9]+
  | '0x' [0-9a-fA-F]+
  | '\'' . . . . '\''
  | '\'' . '\''
  ;

NL
  : [\r\n]+
  ;

ID
  : [a-zA-Z_][a-zA-Z0-9_]*
  ;

WS
  : [ \t]+ -> channel(HIDDEN)
  ;

COMMENT
  : '/*' .*? '*/' -> channel(HIDDEN)
  ;

LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
