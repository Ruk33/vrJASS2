vrJASS2
=======
This is the new version of my compiler vrJASS. It aims to have a very high
percentage of compatibility with vJASS. In fact, that is the primary goal of 
this project.

How to compile?
===============
```
cd path/to/vrj
gradle build
```

How to use it?
==============
```
cd path/to/vrj/builds/libs
java -jar vrjc.jar file1.j file2.j ...
```

For the moment, it will only translate or throw errors in the std.

Keep in mind that this is a very unstable version and many features are not 
implemented yet.

Project structure
=================
- **src/main/java/ruke/vrj/antlr:** All related to ANTLR (lexer, parser, etc.).
- **src/main/java/ruke/vrj/compiler:** Compile, run phases, store results.
- **src/main/java/ruke/vrj/phase:** Phases of the compiler. That is definition, 
typechecking & translation.
- **src/main/java/ruke/vrj/translator:** Classes that handle how each expession 
will be translated.
- **src/main/java/ruke/vrj/util**
- **src/main/java/ruke/vrj/exceptions**

Symbol
======
It will contain information (for example, where it was declared) about 
an specific element (meaning variables, functions, structs, libraries, etc.).

SymbolTable
===========
Maps a name (string) to a symbol. It will also provide functionality to fetch 
these symbols.

Definition phase
================
It will handle the declaration of symbols (for example variables, functions, etc.) 
and it will catch already defined errors.

TypeCheck phase
===============
It will handle the checking of the program (for example if a variable is used 
it will check that it is in fact declared).

Translation phase
=================
It will handle the translation of the program, from vrJASS to raw JASS.

Licence
=======
MIT