grammar GUI;

guiFile: component* EOF;

component
    : IDENTIFIER '{' (component | argumentList)* '}'  // Layouts como Column
    | IDENTIFIER '(' argumentList ')'                 // Componentes como Button, Text
    ;

argumentList
    : argument (',' argument)*  // Uma lista de argumentos
    ;

argument
    : IDENTIFIER '=' STRING  // Um argumento é uma chave-valor
    ;

IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;  // Um identificador para componentes e nomes de parâmetros
STRING: '"' (~["\\] | '\\' .)* '"';  // Um valor de string
WS: [ \t\r\n]+ -> skip;  // Espaços em branco são ignorados