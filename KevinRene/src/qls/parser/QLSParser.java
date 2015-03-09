// Output created by jacc on Mon Mar 09 17:59:44 CET 2015

package qls.parser;

import javax.swing.text.html.StyleSheet;

import ql.ast.expression.Identifier;
import qls.ast.QLSNode;
import qls.ast.statement.Block;

@SuppressWarnings("all")

class QLSParser implements QLSTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private qls.ast.QLSNode[] yysv;
    private qls.ast.QLSNode yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new qls.ast.QLSNode[yyss];
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
                case 72:
                    switch (yytok) {
                        case STYLESHEET:
                            yyn = 3;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 144;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 147;
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
                case 75:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 4;
                            continue;
                    }
                    yyn = 147;
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
                case 76:
                    switch (yytok) {
                        case '{':
                            yyn = 5;
                            continue;
                    }
                    yyn = 147;
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
                case 77:
                    switch (yytok) {
                        case DEFAULT:
                            yyn = 8;
                            continue;
                        case PAGE:
                            yyn = 9;
                            continue;
                        case QUESTION:
                            yyn = 10;
                            continue;
                        case SECTION:
                            yyn = 11;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    switch (yytok) {
                        case DEFAULT:
                            yyn = 8;
                            continue;
                        case PAGE:
                            yyn = 9;
                            continue;
                        case QUESTION:
                            yyn = 10;
                            continue;
                        case SECTION:
                            yyn = 11;
                            continue;
                        case '}':
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    switch (yytok) {
                        case '}':
                            yyn = 13;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 80:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 15;
                            continue;
                        case FLOAT:
                            yyn = 16;
                            continue;
                        case INTEGER:
                            yyn = 17;
                            continue;
                        case MONEY:
                            yyn = 18;
                            continue;
                        case STRING:
                            yyn = 19;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 81:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 20;
                            continue;
                    }
                    yyn = 147;
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
                case 82:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 21;
                            continue;
                    }
                    yyn = 147;
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
                case 83:
                    switch (yytok) {
                        case STRINGLITERAL:
                            yyn = 22;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    switch (yytok) {
                        case '}':
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    switch (yytok) {
                        case WIDGET:
                            yyn = 24;
                            continue;
                        case '{':
                            yyn = 25;
                            continue;
                    }
                    yyn = 147;
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
                case 87:
                    switch (yytok) {
                        case WIDGET:
                        case '{':
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    switch (yytok) {
                        case WIDGET:
                        case '{':
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 147;
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
                case 89:
                    switch (yytok) {
                        case WIDGET:
                        case '{':
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 147;
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
                case 90:
                    switch (yytok) {
                        case WIDGET:
                        case '{':
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 147;
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
                case 91:
                    switch (yytok) {
                        case WIDGET:
                        case '{':
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 147;
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
                case 92:
                    switch (yytok) {
                        case '{':
                            yyn = 26;
                            continue;
                    }
                    yyn = 147;
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
                case 93:
                    yyn = yys21();
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
                case 94:
                    switch (yytok) {
                        case '{':
                            yyn = 28;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    switch (yytok) {
                        case SECTION:
                        case DEFAULT:
                        case '}':
                        case QUESTION:
                        case PAGE:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 147;
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
                case 96:
                    yyn = yys24();
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
                case 97:
                    yyn = yys25();
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    switch (yytok) {
                        case DEFAULT:
                            yyn = 8;
                            continue;
                        case PAGE:
                            yyn = 9;
                            continue;
                        case QUESTION:
                            yyn = 10;
                            continue;
                        case SECTION:
                            yyn = 11;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    switch (yytok) {
                        case WIDGET:
                            yyn = 24;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    switch (yytok) {
                        case DEFAULT:
                            yyn = 8;
                            continue;
                        case PAGE:
                            yyn = 9;
                            continue;
                        case QUESTION:
                            yyn = 10;
                            continue;
                        case SECTION:
                            yyn = 11;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    yyn = yys29();
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
                case 102:
                    yyn = yys30();
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
                case 103:
                    switch (yytok) {
                        case '(':
                            yyn = 48;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    switch (yytok) {
                        case '(':
                            yyn = 49;
                            continue;
                    }
                    yyn = 147;
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
                case 105:
                    switch (yytok) {
                        case '(':
                            yyn = 50;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 107:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 108:
                    switch (yytok) {
                        case ':':
                            yyn = 51;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
                    switch (yytok) {
                        case '}':
                            yyn = 53;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    switch (yytok) {
                        case ':':
                            yyn = yyr38();
                            continue;
                    }
                    yyn = 147;
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
                case 113:
                    switch (yytok) {
                        case ':':
                            yyn = yyr36();
                            continue;
                    }
                    yyn = 147;
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
                case 114:
                    switch (yytok) {
                        case ':':
                            yyn = yyr37();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    switch (yytok) {
                        case ':':
                            yyn = yyr35();
                            continue;
                    }
                    yyn = 147;
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
                case 116:
                    switch (yytok) {
                        case ':':
                            yyn = yyr34();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    switch (yytok) {
                        case '}':
                            yyn = 54;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 118:
                    switch (yytok) {
                        case '}':
                            yyn = 55;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 119:
                    switch (yytok) {
                        case '}':
                            yyn = 56;
                            continue;
                    }
                    yyn = 147;
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
                case 120:
                    switch (yytok) {
                        case BOOLEANLITERAL:
                            yyn = 59;
                            continue;
                        case FLOATLITERAL:
                            yyn = 60;
                            continue;
                        case INTEGERLITERAL:
                            yyn = 61;
                            continue;
                        case MONEYLITERAL:
                            yyn = 62;
                            continue;
                        case STRINGLITERAL:
                            yyn = 63;
                            continue;
                    }
                    yyn = 147;
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
                case 121:
                    switch (yytok) {
                        case BOOLEANLITERAL:
                            yyn = 59;
                            continue;
                        case FLOATLITERAL:
                            yyn = 60;
                            continue;
                        case INTEGERLITERAL:
                            yyn = 61;
                            continue;
                        case MONEYLITERAL:
                            yyn = 62;
                            continue;
                        case STRINGLITERAL:
                            yyn = 63;
                            continue;
                    }
                    yyn = 147;
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
                case 122:
                    switch (yytok) {
                        case BOOLEANLITERAL:
                            yyn = 59;
                            continue;
                        case FLOATLITERAL:
                            yyn = 60;
                            continue;
                        case INTEGERLITERAL:
                            yyn = 61;
                            continue;
                        case MONEYLITERAL:
                            yyn = 62;
                            continue;
                        case STRINGLITERAL:
                            yyn = 63;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    switch (yytok) {
                        case BOOLEANLITERAL:
                            yyn = 59;
                            continue;
                        case FLOATLITERAL:
                            yyn = 60;
                            continue;
                        case INTEGERLITERAL:
                            yyn = 61;
                            continue;
                        case MONEYLITERAL:
                            yyn = 62;
                            continue;
                        case STRINGLITERAL:
                            yyn = 63;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 124:
                    switch (yytok) {
                        case '}':
                            yyn = yyr30();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    switch (yytok) {
                        case SECTION:
                        case DEFAULT:
                        case '}':
                        case QUESTION:
                        case PAGE:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
                    switch (yytok) {
                        case SECTION:
                        case DEFAULT:
                        case '}':
                        case QUESTION:
                        case PAGE:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 127:
                    switch (yytok) {
                        case SECTION:
                        case DEFAULT:
                        case '}':
                        case QUESTION:
                        case PAGE:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    switch (yytok) {
                        case SECTION:
                        case DEFAULT:
                        case '}':
                        case QUESTION:
                        case PAGE:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    switch (yytok) {
                        case ',':
                            yyn = 67;
                            continue;
                        case ')':
                            yyn = yyr29();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    switch (yytok) {
                        case ')':
                            yyn = 68;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    yyn = yys60();
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    yyn = yys62();
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    yyn = yys63();
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    switch (yytok) {
                        case ')':
                            yyn = 69;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    switch (yytok) {
                        case ')':
                            yyn = 70;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    yyn = yys66();
                    continue;

                case 67:
                    yyst[yysp] = 67;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
                    switch (yytok) {
                        case BOOLEANLITERAL:
                            yyn = 59;
                            continue;
                        case FLOATLITERAL:
                            yyn = 60;
                            continue;
                        case INTEGERLITERAL:
                            yyn = 61;
                            continue;
                        case MONEYLITERAL:
                            yyn = 62;
                            continue;
                        case STRINGLITERAL:
                            yyn = 63;
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
                    yyn = yys68();
                    continue;

                case 69:
                    yyst[yysp] = 69;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 141:
                    yyn = yys69();
                    continue;

                case 70:
                    yyst[yysp] = 70;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    yyn = yys70();
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    switch (yytok) {
                        case ')':
                            yyn = yyr28();
                            continue;
                    }
                    yyn = 147;
                    continue;

                case 144:
                    return true;
                case 145:
                    yyerror("stack overflow");
                case 146:
                    return false;
                case 147:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        qls.ast.QLSNode[] newyysv = new qls.ast.QLSNode[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yys21() {
        switch (yytok) {
            case '{':
                return 27;
            case SECTION:
            case DEFAULT:
            case '}':
            case QUESTION:
            case PAGE:
                return yyr7();
        }
        return 147;
    }

    private int yys24() {
        switch (yytok) {
            case CHECKBOX:
                return 30;
            case DROPDOWN:
                return 31;
            case RADIO:
                return 32;
            case SLIDER:
                return 33;
            case SPINBOX:
                return 34;
            case TEXT:
                return 35;
        }
        return 147;
    }

    private int yys25() {
        switch (yytok) {
            case WIDGET:
                return 24;
            case COLOUR:
                return 40;
            case FONT:
                return 41;
            case FONTSIZE:
                return 42;
            case HEIGHT:
                return 43;
            case WIDTH:
                return 44;
        }
        return 147;
    }

    private int yys29() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case SECTION:
            case FONTSIZE:
            case DEFAULT:
            case '}':
            case QUESTION:
            case FONT:
            case PAGE:
            case COLOUR:
                return yyr21();
        }
        return 147;
    }

    private int yys30() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case SECTION:
            case FONTSIZE:
            case DEFAULT:
            case '}':
            case QUESTION:
            case FONT:
            case PAGE:
            case COLOUR:
                return yyr27();
        }
        return 147;
    }

    private int yys34() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case SECTION:
            case FONTSIZE:
            case DEFAULT:
            case '}':
            case QUESTION:
            case FONT:
            case PAGE:
            case COLOUR:
                return yyr22();
        }
        return 147;
    }

    private int yys35() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case SECTION:
            case FONTSIZE:
            case DEFAULT:
            case '}':
            case QUESTION:
            case FONT:
            case PAGE:
            case COLOUR:
                return yyr26();
        }
        return 147;
    }

    private int yys37() {
        switch (yytok) {
            case WIDGET:
                return 24;
            case COLOUR:
                return 40;
            case FONT:
                return 41;
            case FONTSIZE:
                return 42;
            case HEIGHT:
                return 43;
            case WIDTH:
                return 44;
            case '}':
                return yyr31();
        }
        return 147;
    }

    private int yys39() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case COLOUR:
                return yyr33();
        }
        return 147;
    }

    private int yys59() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case ',':
            case ')':
            case COLOUR:
                return yyr16();
        }
        return 147;
    }

    private int yys60() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case ',':
            case ')':
            case COLOUR:
                return yyr18();
        }
        return 147;
    }

    private int yys61() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case ',':
            case ')':
            case COLOUR:
                return yyr17();
        }
        return 147;
    }

    private int yys62() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case ',':
            case ')':
            case COLOUR:
                return yyr19();
        }
        return 147;
    }

    private int yys63() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case ',':
            case ')':
            case COLOUR:
                return yyr20();
        }
        return 147;
    }

    private int yys66() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case COLOUR:
                return yyr32();
        }
        return 147;
    }

    private int yys68() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case SECTION:
            case FONTSIZE:
            case DEFAULT:
            case '}':
            case QUESTION:
            case FONT:
            case PAGE:
            case COLOUR:
                return yyr25();
        }
        return 147;
    }

    private int yys69() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case SECTION:
            case FONTSIZE:
            case DEFAULT:
            case '}':
            case QUESTION:
            case FONT:
            case PAGE:
            case COLOUR:
                return yyr23();
        }
        return 147;
    }

    private int yys70() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case SECTION:
            case FONTSIZE:
            case DEFAULT:
            case '}':
            case QUESTION:
            case FONT:
            case PAGE:
            case COLOUR:
                return yyr24();
        }
        return 147;
    }

    private int yyr1() { // top : stylesheet
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr5() { // statement : PAGE IDENTIFIER '{' statements '}'
        yysp -= 5;
        return 6;
    }

    private int yyr6() { // statement : SECTION STRINGLITERAL '{' statements '}'
        yysp -= 5;
        return 6;
    }

    private int yyr7() { // statement : QUESTION IDENTIFIER
        yysp -= 2;
        return 6;
    }

    private int yyr8() { // statement : QUESTION IDENTIFIER '{' widget '}'
        yysp -= 5;
        return 6;
    }

    private int yyr9() { // statement : DEFAULT type widget
        yysp -= 3;
        return 6;
    }

    private int yyr10() { // statement : DEFAULT type '{' styleRules '}'
        yysp -= 5;
        return 6;
    }

    private int yyr3() { // statements : statement statements
        { yyrv = new Block(yysv[yysp-2], yysv[yysp-1]); }
        yysv[yysp-=2] = yyrv;
        return yypstatements();
    }

    private int yyr4() { // statements : statement
        { yyrv = new Block(yysv[yysp-1]); }
        yysv[yysp-=1] = yyrv;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 26: return 45;
            case 6: return 12;
            case 5: return 7;
            default: return 47;
        }
    }

    private int yyr34() { // styleProperty : WIDTH
        yysp -= 1;
        return 36;
    }

    private int yyr35() { // styleProperty : HEIGHT
        yysp -= 1;
        return 36;
    }

    private int yyr36() { // styleProperty : FONT
        yysp -= 1;
        return 36;
    }

    private int yyr37() { // styleProperty : FONTSIZE
        yysp -= 1;
        return 36;
    }

    private int yyr38() { // styleProperty : COLOUR
        yysp -= 1;
        return 36;
    }

    private int yyr32() { // styleRule : styleProperty ':' literal
        yysp -= 3;
        return 37;
    }

    private int yyr33() { // styleRule : widget
        yysp -= 1;
        return 37;
    }

    private int yyr30() { // styleRules : styleRule styleRules
        yysp -= 2;
        return yypstyleRules();
    }

    private int yyr31() { // styleRules : styleRule
        yysp -= 1;
        return yypstyleRules();
    }

    private int yypstyleRules() {
        switch (yyst[yysp-1]) {
            case 25: return 38;
            default: return 52;
        }
    }

    private int yyr2() { // stylesheet : STYLESHEET IDENTIFIER '{' statements '}'
        { yyrv = new StyleSheet(((Identifier)yysv[yysp-4]), yysv[yysp-2]); }
        yysv[yysp-=5] = yyrv;
        return 2;
    }

    private int yyr16() { // literal : BOOLEANLITERAL
        yysp -= 1;
        return yypliteral();
    }

    private int yyr17() { // literal : INTEGERLITERAL
        yysp -= 1;
        return yypliteral();
    }

    private int yyr18() { // literal : FLOATLITERAL
        yysp -= 1;
        return yypliteral();
    }

    private int yyr19() { // literal : MONEYLITERAL
        yysp -= 1;
        return yypliteral();
    }

    private int yyr20() { // literal : STRINGLITERAL
        yysp -= 1;
        return yypliteral();
    }

    private int yypliteral() {
        switch (yyst[yysp-1]) {
            case 51: return 66;
            default: return 57;
        }
    }

    private int yyr11() { // type : BOOLEAN
        yysp -= 1;
        return 14;
    }

    private int yyr12() { // type : INTEGER
        yysp -= 1;
        return 14;
    }

    private int yyr13() { // type : FLOAT
        yysp -= 1;
        return 14;
    }

    private int yyr14() { // type : MONEY
        yysp -= 1;
        return 14;
    }

    private int yyr15() { // type : STRING
        yysp -= 1;
        return 14;
    }

    private int yyr28() { // values : literal ',' values
        yysp -= 3;
        return yypvalues();
    }

    private int yyr29() { // values : literal
        yysp -= 1;
        return yypvalues();
    }

    private int yypvalues() {
        switch (yyst[yysp-1]) {
            case 50: return 65;
            case 49: return 64;
            case 48: return 58;
            default: return 71;
        }
    }

    private int yyr21() { // widget : WIDGET widgetType
        yysp -= 2;
        switch (yyst[yysp-1]) {
            case 27: return 46;
            case 14: return 23;
            default: return 39;
        }
    }

    private int yyr22() { // widgetType : SPINBOX
        yysp -= 1;
        return 29;
    }

    private int yyr23() { // widgetType : RADIO '(' values ')'
        yysp -= 4;
        return 29;
    }

    private int yyr24() { // widgetType : SLIDER '(' values ')'
        yysp -= 4;
        return 29;
    }

    private int yyr25() { // widgetType : DROPDOWN '(' values ')'
        yysp -= 4;
        return 29;
    }

    private int yyr26() { // widgetType : TEXT
        yysp -= 1;
        return 29;
    }

    private int yyr27() { // widgetType : CHECKBOX
        yysp -= 1;
        return 29;
    }

    protected String[] yyerrmsgs = {
    };

private QLSLexer lexer; 

private QLSNode result;

public QLSNode getResult() {
  return result;
}

public QLSParser(QLSLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(yyerrno<0 ? msg : yyerrmsgs[yyerrno]);
}

}
