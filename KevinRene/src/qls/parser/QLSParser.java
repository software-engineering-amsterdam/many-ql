// Output created by jacc on Mon Mar 09 12:59:23 CET 2015

package qls.parser;

import ql.ast.*;
import ql.ast.expression.*;
import ql.ast.expression.type.*;
import ql.ast.expression.literal.*;

@SuppressWarnings("all")

class QLSParser implements QLSTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private ql.ast.ASTNode[] yysv;
    private ql.ast.ASTNode yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new ql.ast.ASTNode[yyss];
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
                case 68:
                    switch (yytok) {
                        case STYLESHEET:
                            yyn = 2;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 69:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 136;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 70:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 3;
                            continue;
                    }
                    yyn = 139;
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
                case 71:
                    switch (yytok) {
                        case DEFAULT:
                            yyn = 6;
                            continue;
                        case PAGE:
                            yyn = 7;
                            continue;
                        case QUESTION:
                            yyn = 8;
                            continue;
                        case SECTION:
                            yyn = 9;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 72:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 73:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 74:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 12;
                            continue;
                        case FLOAT:
                            yyn = 13;
                            continue;
                        case INTEGER:
                            yyn = 14;
                            continue;
                        case MONEY:
                            yyn = 15;
                            continue;
                        case STRING:
                            yyn = 16;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 7:
                    yyst[yysp] = 7;
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
                            yyn = 17;
                            continue;
                    }
                    yyn = 139;
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
                case 76:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 18;
                            continue;
                    }
                    yyn = 139;
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
                case 77:
                    switch (yytok) {
                        case STRINGLITERAL:
                            yyn = 19;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 78:
                    switch (yytok) {
                        case ENDINPUT:
                        case '}':
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 79:
                    switch (yytok) {
                        case WIDGET:
                            yyn = 21;
                            continue;
                        case '{':
                            yyn = 22;
                            continue;
                    }
                    yyn = 139;
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
                case 80:
                    switch (yytok) {
                        case WIDGET:
                        case '{':
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 139;
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
                case 81:
                    switch (yytok) {
                        case WIDGET:
                        case '{':
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 139;
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
                case 82:
                    switch (yytok) {
                        case WIDGET:
                        case '{':
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 139;
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
                case 83:
                    switch (yytok) {
                        case WIDGET:
                        case '{':
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 139;
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
                case 84:
                    switch (yytok) {
                        case WIDGET:
                        case '{':
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 139;
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
                case 85:
                    switch (yytok) {
                        case '{':
                            yyn = 23;
                            continue;
                    }
                    yyn = 139;
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
                case 86:
                    yyn = yys18();
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
                case 87:
                    switch (yytok) {
                        case '{':
                            yyn = 25;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    yyn = yys20();
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
                case 89:
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
                case 90:
                    yyn = yys22();
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    switch (yytok) {
                        case DEFAULT:
                            yyn = 6;
                            continue;
                        case PAGE:
                            yyn = 7;
                            continue;
                        case QUESTION:
                            yyn = 8;
                            continue;
                        case SECTION:
                            yyn = 9;
                            continue;
                    }
                    yyn = 139;
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
                case 92:
                    switch (yytok) {
                        case WIDGET:
                            yyn = 21;
                            continue;
                    }
                    yyn = 139;
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
                case 93:
                    switch (yytok) {
                        case DEFAULT:
                            yyn = 6;
                            continue;
                        case PAGE:
                            yyn = 7;
                            continue;
                        case QUESTION:
                            yyn = 8;
                            continue;
                        case SECTION:
                            yyn = 9;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    yyn = yys26();
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
                case 95:
                    yyn = yys27();
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
                case 96:
                    switch (yytok) {
                        case '(':
                            yyn = 45;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    switch (yytok) {
                        case '(':
                            yyn = 46;
                            continue;
                    }
                    yyn = 139;
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
                case 98:
                    switch (yytok) {
                        case '(':
                            yyn = 47;
                            continue;
                    }
                    yyn = 139;
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
                case 99:
                    yyn = yys31();
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
                case 100:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    switch (yytok) {
                        case ':':
                            yyn = 48;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    yyn = yys34();
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    switch (yytok) {
                        case '}':
                            yyn = 50;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    yyn = yys36();
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
                case 105:
                    switch (yytok) {
                        case ':':
                            yyn = yyr37();
                            continue;
                    }
                    yyn = 139;
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
                case 106:
                    switch (yytok) {
                        case ':':
                            yyn = yyr35();
                            continue;
                    }
                    yyn = 139;
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
                case 107:
                    switch (yytok) {
                        case ':':
                            yyn = yyr36();
                            continue;
                    }
                    yyn = 139;
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
                case 108:
                    switch (yytok) {
                        case ':':
                            yyn = yyr34();
                            continue;
                    }
                    yyn = 139;
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
                case 109:
                    switch (yytok) {
                        case ':':
                            yyn = yyr33();
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
                    switch (yytok) {
                        case '}':
                            yyn = 51;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    switch (yytok) {
                        case '}':
                            yyn = 52;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    switch (yytok) {
                        case '}':
                            yyn = 53;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    switch (yytok) {
                        case BOOLEANLITERAL:
                            yyn = 56;
                            continue;
                        case FLOATLITERAL:
                            yyn = 57;
                            continue;
                        case INTEGERLITERAL:
                            yyn = 58;
                            continue;
                        case MONEYLITERAL:
                            yyn = 59;
                            continue;
                        case STRINGLITERAL:
                            yyn = 60;
                            continue;
                    }
                    yyn = 139;
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
                case 114:
                    switch (yytok) {
                        case BOOLEANLITERAL:
                            yyn = 56;
                            continue;
                        case FLOATLITERAL:
                            yyn = 57;
                            continue;
                        case INTEGERLITERAL:
                            yyn = 58;
                            continue;
                        case MONEYLITERAL:
                            yyn = 59;
                            continue;
                        case STRINGLITERAL:
                            yyn = 60;
                            continue;
                    }
                    yyn = 139;
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
                case 115:
                    switch (yytok) {
                        case BOOLEANLITERAL:
                            yyn = 56;
                            continue;
                        case FLOATLITERAL:
                            yyn = 57;
                            continue;
                        case INTEGERLITERAL:
                            yyn = 58;
                            continue;
                        case MONEYLITERAL:
                            yyn = 59;
                            continue;
                        case STRINGLITERAL:
                            yyn = 60;
                            continue;
                    }
                    yyn = 139;
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
                case 116:
                    switch (yytok) {
                        case BOOLEANLITERAL:
                            yyn = 56;
                            continue;
                        case FLOATLITERAL:
                            yyn = 57;
                            continue;
                        case INTEGERLITERAL:
                            yyn = 58;
                            continue;
                        case MONEYLITERAL:
                            yyn = 59;
                            continue;
                        case STRINGLITERAL:
                            yyn = 60;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    switch (yytok) {
                        case '}':
                            yyn = yyr29();
                            continue;
                    }
                    yyn = 139;
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
                case 118:
                    yyn = yys50();
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
                case 119:
                    yyn = yys51();
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
                case 120:
                    yyn = yys52();
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
                case 121:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    switch (yytok) {
                        case ')':
                            yyn = 65;
                            continue;
                    }
                    yyn = 139;
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
                case 124:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
                    yyn = yys58();
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
                case 127:
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
                case 128:
                    yyn = yys60();
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    switch (yytok) {
                        case ')':
                            yyn = 66;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    switch (yytok) {
                        case ')':
                            yyn = 67;
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys63();
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    switch (yytok) {
                        case ')':
                            yyn = yyr27();
                            continue;
                    }
                    yyn = 139;
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    yyn = yys65();
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
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
                case 135:
                    yyn = yys67();
                    continue;

                case 136:
                    return true;
                case 137:
                    yyerror("stack overflow");
                case 138:
                    return false;
                case 139:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        ql.ast.ASTNode[] newyysv = new ql.ast.ASTNode[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yys4() {
        switch (yytok) {
            case DEFAULT:
                return 6;
            case PAGE:
                return 7;
            case QUESTION:
                return 8;
            case SECTION:
                return 9;
            case ENDINPUT:
            case '}':
                return yyr3();
        }
        return 139;
    }

    private int yys18() {
        switch (yytok) {
            case '{':
                return 24;
            case SECTION:
            case DEFAULT:
            case ENDINPUT:
            case '}':
            case QUESTION:
            case PAGE:
                return yyr6();
        }
        return 139;
    }

    private int yys20() {
        switch (yytok) {
            case SECTION:
            case DEFAULT:
            case ENDINPUT:
            case '}':
            case QUESTION:
            case PAGE:
                return yyr8();
        }
        return 139;
    }

    private int yys21() {
        switch (yytok) {
            case CHECKBOX:
                return 27;
            case DROPDOWN:
                return 28;
            case RADIO:
                return 29;
            case SLIDER:
                return 30;
            case SPINBOX:
                return 31;
            case TEXT:
                return 32;
        }
        return 139;
    }

    private int yys22() {
        switch (yytok) {
            case WIDGET:
                return 21;
            case COLOUR:
                return 37;
            case FONT:
                return 38;
            case FONTSIZE:
                return 39;
            case HEIGHT:
                return 40;
            case WIDTH:
                return 41;
        }
        return 139;
    }

    private int yys26() {
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
            case ENDINPUT:
            case COLOUR:
                return yyr20();
        }
        return 139;
    }

    private int yys27() {
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
            case ENDINPUT:
            case COLOUR:
                return yyr26();
        }
        return 139;
    }

    private int yys31() {
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
            case ENDINPUT:
            case COLOUR:
                return yyr21();
        }
        return 139;
    }

    private int yys32() {
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
            case ENDINPUT:
            case COLOUR:
                return yyr25();
        }
        return 139;
    }

    private int yys34() {
        switch (yytok) {
            case WIDGET:
                return 21;
            case COLOUR:
                return 37;
            case FONT:
                return 38;
            case FONTSIZE:
                return 39;
            case HEIGHT:
                return 40;
            case WIDTH:
                return 41;
            case '}':
                return yyr30();
        }
        return 139;
    }

    private int yys36() {
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
        return 139;
    }

    private int yys50() {
        switch (yytok) {
            case SECTION:
            case DEFAULT:
            case ENDINPUT:
            case '}':
            case QUESTION:
            case PAGE:
                return yyr9();
        }
        return 139;
    }

    private int yys51() {
        switch (yytok) {
            case SECTION:
            case DEFAULT:
            case ENDINPUT:
            case '}':
            case QUESTION:
            case PAGE:
                return yyr4();
        }
        return 139;
    }

    private int yys52() {
        switch (yytok) {
            case SECTION:
            case DEFAULT:
            case ENDINPUT:
            case '}':
            case QUESTION:
            case PAGE:
                return yyr7();
        }
        return 139;
    }

    private int yys53() {
        switch (yytok) {
            case SECTION:
            case DEFAULT:
            case ENDINPUT:
            case '}':
            case QUESTION:
            case PAGE:
                return yyr5();
        }
        return 139;
    }

    private int yys54() {
        switch (yytok) {
            case BOOLEANLITERAL:
                return 56;
            case FLOATLITERAL:
                return 57;
            case INTEGERLITERAL:
                return 58;
            case MONEYLITERAL:
                return 59;
            case STRINGLITERAL:
                return 60;
            case ')':
                return yyr28();
        }
        return 139;
    }

    private int yys56() {
        switch (yytok) {
            case WIDTH:
            case INTEGERLITERAL:
            case WIDGET:
            case STRINGLITERAL:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case ')':
            case MONEYLITERAL:
            case FLOATLITERAL:
            case COLOUR:
            case BOOLEANLITERAL:
                return yyr15();
        }
        return 139;
    }

    private int yys57() {
        switch (yytok) {
            case WIDTH:
            case INTEGERLITERAL:
            case WIDGET:
            case STRINGLITERAL:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case ')':
            case MONEYLITERAL:
            case FLOATLITERAL:
            case COLOUR:
            case BOOLEANLITERAL:
                return yyr17();
        }
        return 139;
    }

    private int yys58() {
        switch (yytok) {
            case WIDTH:
            case INTEGERLITERAL:
            case WIDGET:
            case STRINGLITERAL:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case ')':
            case MONEYLITERAL:
            case FLOATLITERAL:
            case COLOUR:
            case BOOLEANLITERAL:
                return yyr16();
        }
        return 139;
    }

    private int yys59() {
        switch (yytok) {
            case WIDTH:
            case INTEGERLITERAL:
            case WIDGET:
            case STRINGLITERAL:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case ')':
            case MONEYLITERAL:
            case FLOATLITERAL:
            case COLOUR:
            case BOOLEANLITERAL:
                return yyr18();
        }
        return 139;
    }

    private int yys60() {
        switch (yytok) {
            case WIDTH:
            case INTEGERLITERAL:
            case WIDGET:
            case STRINGLITERAL:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case ')':
            case MONEYLITERAL:
            case FLOATLITERAL:
            case COLOUR:
            case BOOLEANLITERAL:
                return yyr19();
        }
        return 139;
    }

    private int yys63() {
        switch (yytok) {
            case WIDTH:
            case WIDGET:
            case HEIGHT:
            case FONTSIZE:
            case '}':
            case FONT:
            case COLOUR:
                return yyr31();
        }
        return 139;
    }

    private int yys65() {
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
            case ENDINPUT:
            case COLOUR:
                return yyr24();
        }
        return 139;
    }

    private int yys66() {
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
            case ENDINPUT:
            case COLOUR:
                return yyr22();
        }
        return 139;
    }

    private int yys67() {
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
            case ENDINPUT:
            case COLOUR:
                return yyr23();
        }
        return 139;
    }

    private int yyr1() { // stylesheet : STYLESHEET IDENTIFIER statements
        yysp -= 3;
        return 1;
    }

    private int yyr4() { // statement : PAGE IDENTIFIER '{' statements '}'
        yysp -= 5;
        return 4;
    }

    private int yyr5() { // statement : SECTION STRINGLITERAL '{' statements '}'
        yysp -= 5;
        return 4;
    }

    private int yyr6() { // statement : QUESTION IDENTIFIER
        yysp -= 2;
        return 4;
    }

    private int yyr7() { // statement : QUESTION IDENTIFIER '{' widget '}'
        yysp -= 5;
        return 4;
    }

    private int yyr8() { // statement : DEFAULT type widget
        yysp -= 3;
        return 4;
    }

    private int yyr9() { // statement : DEFAULT type '{' styleRules '}'
        yysp -= 5;
        return 4;
    }

    private int yyr2() { // statements : statement statements
        yysp -= 2;
        return yypstatements();
    }

    private int yyr3() { // statements : statement
        yysp -= 1;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 23: return 42;
            case 4: return 10;
            case 3: return 5;
            default: return 44;
        }
    }

    private int yyr33() { // styleProperty : WIDTH
        yysp -= 1;
        return 33;
    }

    private int yyr34() { // styleProperty : HEIGHT
        yysp -= 1;
        return 33;
    }

    private int yyr35() { // styleProperty : FONT
        yysp -= 1;
        return 33;
    }

    private int yyr36() { // styleProperty : FONTSIZE
        yysp -= 1;
        return 33;
    }

    private int yyr37() { // styleProperty : COLOUR
        yysp -= 1;
        return 33;
    }

    private int yyr31() { // styleRule : styleProperty ':' literal
        yysp -= 3;
        return 34;
    }

    private int yyr32() { // styleRule : widget
        yysp -= 1;
        return 34;
    }

    private int yyr29() { // styleRules : styleRule styleRules
        yysp -= 2;
        return yypstyleRules();
    }

    private int yyr30() { // styleRules : styleRule
        yysp -= 1;
        return yypstyleRules();
    }

    private int yypstyleRules() {
        switch (yyst[yysp-1]) {
            case 22: return 35;
            default: return 49;
        }
    }

    private int yyr15() { // literal : BOOLEANLITERAL
        yysp -= 1;
        return yypliteral();
    }

    private int yyr16() { // literal : INTEGERLITERAL
        yysp -= 1;
        return yypliteral();
    }

    private int yyr17() { // literal : FLOATLITERAL
        yysp -= 1;
        return yypliteral();
    }

    private int yyr18() { // literal : MONEYLITERAL
        yysp -= 1;
        return yypliteral();
    }

    private int yyr19() { // literal : STRINGLITERAL
        yysp -= 1;
        return yypliteral();
    }

    private int yypliteral() {
        switch (yyst[yysp-1]) {
            case 48: return 63;
            default: return 54;
        }
    }

    private int yyr10() { // type : BOOLEAN
        yysp -= 1;
        return 11;
    }

    private int yyr11() { // type : INTEGER
        yysp -= 1;
        return 11;
    }

    private int yyr12() { // type : FLOAT
        yysp -= 1;
        return 11;
    }

    private int yyr13() { // type : MONEY
        yysp -= 1;
        return 11;
    }

    private int yyr14() { // type : STRING
        yysp -= 1;
        return 11;
    }

    private int yyr27() { // values : literal values
        yysp -= 2;
        return yypvalues();
    }

    private int yyr28() { // values : literal
        yysp -= 1;
        return yypvalues();
    }

    private int yypvalues() {
        switch (yyst[yysp-1]) {
            case 47: return 62;
            case 46: return 61;
            case 45: return 55;
            default: return 64;
        }
    }

    private int yyr20() { // widget : WIDGET widgetType
        yysp -= 2;
        switch (yyst[yysp-1]) {
            case 24: return 43;
            case 11: return 20;
            default: return 36;
        }
    }

    private int yyr21() { // widgetType : SPINBOX
        yysp -= 1;
        return 26;
    }

    private int yyr22() { // widgetType : RADIO '(' values ')'
        yysp -= 4;
        return 26;
    }

    private int yyr23() { // widgetType : SLIDER '(' values ')'
        yysp -= 4;
        return 26;
    }

    private int yyr24() { // widgetType : DROPDOWN '(' values ')'
        yysp -= 4;
        return 26;
    }

    private int yyr25() { // widgetType : TEXT
        yysp -= 1;
        return 26;
    }

    private int yyr26() { // widgetType : CHECKBOX
        yysp -= 1;
        return 26;
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
