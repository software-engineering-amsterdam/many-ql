// Output created by jacc on Tue Mar 03 18:06:16 CET 2015

package qls.parser;

import cons.ql.ast.*;
import cons.ql.ast.expression.*;
import cons.ql.ast.expression.type.*;
import cons.ql.ast.expression.literal.*;

@SuppressWarnings("all")

class QLSParser implements QLSTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private cons.ql.ast.ASTNode[] yysv;
    private cons.ql.ast.ASTNode yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new cons.ql.ast.ASTNode[yyss];
        yytok = (lexer.getToken()
                 );
    loop:
        for (;;) {
            switch (yyn) {
                case 0:
                    yyst[yysp] = 0;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 53:
                    switch (yytok) {
                        case STYLESHEET:
                            yyn = 3;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 54:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 106;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 55:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 56:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 4;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 57:
                    switch (yytok) {
                        case '{':
                            yyn = 5;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 58:
                    switch (yytok) {
                        case PAGE:
                            yyn = 10;
                            continue;
                        case WIDGET:
                            yyn = 11;
                            continue;
                        case '}':
                            yyn = 12;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 59:
                    switch (yytok) {
                        case '}':
                        case PAGE:
                        case WIDGET:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 60:
                    switch (yytok) {
                        case PAGE:
                            yyn = 10;
                            continue;
                        case WIDGET:
                            yyn = 11;
                            continue;
                        case '}':
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 61:
                    switch (yytok) {
                        case '}':
                            yyn = 14;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 62:
                    switch (yytok) {
                        case '}':
                        case PAGE:
                        case WIDGET:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 63:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 15;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 64:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 17;
                            continue;
                        case FLOAT:
                            yyn = 18;
                            continue;
                        case INTEGER:
                            yyn = 19;
                            continue;
                        case MONEY:
                            yyn = 20;
                            continue;
                        case STRING:
                            yyn = 21;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 65:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 66:
                    switch (yytok) {
                        case '}':
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 67:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 68:
                    switch (yytok) {
                        case '{':
                            yyn = 22;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 69:
                    switch (yytok) {
                        case WIDGET:
                            yyn = 24;
                            continue;
                        case '{':
                            yyn = 25;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 70:
                    switch (yytok) {
                        case '{':
                        case WIDGET:
                            yyn = yyr23();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 71:
                    switch (yytok) {
                        case '{':
                        case WIDGET:
                            yyn = yyr22();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    switch (yytok) {
                        case '{':
                        case WIDGET:
                            yyn = yyr20();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    switch (yytok) {
                        case '{':
                        case WIDGET:
                            yyn = yyr21();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    switch (yytok) {
                        case '{':
                        case WIDGET:
                            yyn = yyr24();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 75:
                    switch (yytok) {
                        case WIDGET:
                            yyn = 11;
                            continue;
                        case QUESTION:
                            yyn = 30;
                            continue;
                        case SECTION:
                            yyn = 31;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 76:
                    switch (yytok) {
                        case '}':
                        case PAGE:
                        case WIDGET:
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 77:
                    switch (yytok) {
                        case '.':
                            yyn = 33;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    switch (yytok) {
                        case STRINGLITERAL:
                            yyn = 36;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    switch (yytok) {
                        case '}':
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 80:
                    switch (yytok) {
                        case '}':
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 81:
                    switch (yytok) {
                        case '}':
                            yyn = 37;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    switch (yytok) {
                        case '}':
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 38;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    switch (yytok) {
                        case STRINGLITERAL:
                            yyn = 39;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    switch (yytok) {
                        case '}':
                        case PAGE:
                        case WIDGET:
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    switch (yytok) {
                        case '}':
                        case PAGE:
                        case WIDGET:
                            yyn = yyr30();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    switch (yytok) {
                        case STRINGLITERAL:
                            yyn = 36;
                            continue;
                        case '}':
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    switch (yytok) {
                        case '}':
                            yyn = 41;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    switch (yytok) {
                        case ':':
                            yyn = 42;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    switch (yytok) {
                        case '}':
                        case PAGE:
                        case WIDGET:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    switch (yytok) {
                        case WIDGET:
                            yyn = 24;
                            continue;
                        case '{':
                            yyn = 25;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    switch (yytok) {
                        case '{':
                            yyn = 44;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    switch (yytok) {
                        case '}':
                            yyn = yyr17();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    switch (yytok) {
                        case '}':
                        case PAGE:
                        case WIDGET:
                            yyn = yyr16();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    switch (yytok) {
                        case BOOLEANLITERAL:
                            yyn = 46;
                            continue;
                        case FLOATLITERAL:
                            yyn = 47;
                            continue;
                        case INTEGERLITERAL:
                            yyn = 48;
                            continue;
                        case MONEYLITERAL:
                            yyn = 49;
                            continue;
                        case STRINGLITERAL:
                            yyn = 50;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    switch (yytok) {
                        case '}':
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    switch (yytok) {
                        case WIDGET:
                            yyn = 11;
                            continue;
                        case QUESTION:
                            yyn = 30;
                            continue;
                        case SECTION:
                            yyn = 31;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case '}':
                            yyn = yyr19();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case '}':
                            yyn = yyr28();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case '}':
                            yyn = yyr27();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case '}':
                            yyn = yyr25();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case '}':
                            yyn = yyr26();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    switch (yytok) {
                        case STRINGLITERAL:
                        case '}':
                            yyn = yyr29();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    switch (yytok) {
                        case '}':
                            yyn = 52;
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
                    switch (yytok) {
                        case '}':
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 109;
                    continue;

                case 106:
                    return true;
                case 107:
                    yyerror("stack overflow");
                case 108:
                    return false;
                case 109:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        cons.ql.ast.ASTNode[] newyysv = new cons.ql.ast.ASTNode[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yyr1() { // top : stylesheet
        yysp -= 1;
        return 1;
    }

    private int yyr25() { // literal : INTEGERLITERAL
        yysp -= 1;
        return 45;
    }

    private int yyr26() { // literal : MONEYLITERAL
        yysp -= 1;
        return 45;
    }

    private int yyr27() { // literal : FLOATLITERAL
        yysp -= 1;
        return 45;
    }

    private int yyr28() { // literal : BOOLEANLITERAL
        yysp -= 1;
        return 45;
    }

    private int yyr29() { // literal : STRINGLITERAL
        yysp -= 1;
        return 45;
    }

    private int yyr8() { // page : PAGE IDENTIFIER '{' sectionContent '}'
        yysp -= 5;
        return 6;
    }

    private int yyr13() { // question : QUESTION IDENTIFIER typeset
        yysp -= 3;
        return 26;
    }

    private int yyr12() { // section : SECTION STRINGLITERAL '{' sectionContent '}'
        yysp -= 5;
        return 27;
    }

    private int yyr9() { // sectionContent : section
        yysp -= 1;
        return yypsectionContent();
    }

    private int yyr10() { // sectionContent : question
        yysp -= 1;
        return yypsectionContent();
    }

    private int yyr11() { // sectionContent : default
        yysp -= 1;
        return yypsectionContent();
    }

    private int yypsectionContent() {
        switch (yyst[yysp-1]) {
            case 22: return 28;
            default: return 51;
        }
    }

    private int yyr6() { // statement : page
        yysp -= 1;
        return 7;
    }

    private int yyr7() { // statement : default
        yysp -= 1;
        return 7;
    }

    private int yyr4() { // statements : statement statements
        yysp -= 2;
        return yypstatements();
    }

    private int yyr5() { // statements : statement
        yysp -= 1;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 5: return 8;
            default: return 13;
        }
    }

    private int yyr2() { // stylesheet : STYLESHEET IDENTIFIER '{' statements '}'
        yysp -= 5;
        return 2;
    }

    private int yyr3() { // stylesheet : STYLESHEET IDENTIFIER '{' '}'
        yysp -= 4;
        return 2;
    }

    private int yyr14() { // default : WIDGET type typeset
        yysp -= 3;
        switch (yyst[yysp-1]) {
            case 7: return 9;
            case 5: return 9;
            default: return 29;
        }
    }

    private int yyr20() { // type : INTEGER
        { yyrv = new QLInteger(); }
        yysv[yysp-=1] = yyrv;
        return 16;
    }

    private int yyr21() { // type : MONEY
        { yyrv = new QLFloat(); }
        yysv[yysp-=1] = yyrv;
        return 16;
    }

    private int yyr22() { // type : FLOAT
        { yyrv = new QLFloat(); }
        yysv[yysp-=1] = yyrv;
        return 16;
    }

    private int yyr23() { // type : BOOLEAN
        { yyrv = new QLBoolean(); }
        yysv[yysp-=1] = yyrv;
        return 16;
    }

    private int yyr24() { // type : STRING
        { yyrv = new QLString(); }
        yysv[yysp-=1] = yyrv;
        return 16;
    }

    private int yyr19() { // typerule : STRINGLITERAL ':' literal
        yysp -= 3;
        return 34;
    }

    private int yyr17() { // typerules : typerule typerules
        yysp -= 2;
        return yyptyperules();
    }

    private int yyr18() { // typerules : typerule
        yysp -= 1;
        return yyptyperules();
    }

    private int yyptyperules() {
        switch (yyst[yysp-1]) {
            case 25: return 35;
            default: return 40;
        }
    }

    private int yyr15() { // typeset : WIDGET widget
        yysp -= 2;
        return yyptypeset();
    }

    private int yyr16() { // typeset : '{' typerules '}'
        yysp -= 3;
        return yyptypeset();
    }

    private int yyptypeset() {
        switch (yyst[yysp-1]) {
            case 16: return 23;
            default: return 43;
        }
    }

    private int yyr30() { // widget : '.'
        yysp -= 1;
        return 32;
    }

    protected String[] yyerrmsgs = {
    };

private QLSLexer lexer; 

private ASTNode result;

public ASTNode getResult() {
  return result;
}

public QLSParser(QLSLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(yyerrno<0 ? msg : yyerrmsgs[yyerrno]);
}

}
