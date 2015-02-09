// Output created by jacc on Mon Feb 09 17:05:30 CET 2015

package cons.ql.parser;

import cons.ql.ast.*;
import cons.ql.ast.expr.*;
import cons.ql.ast.expr.unary.*;
import cons.ql.ast.expr.binary.*;

class QLParser implements QLTokens {
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
                case 80:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 81:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 160;
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case ENDINPUT:
                        case IDENT:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    yyn = yys7();
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    yyn = yys9();
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
                case 90:
                    yyn = yys10();
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
                case 91:
                    yyn = yys11();
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
                case 92:
                    switch (yytok) {
                        case IDENT:
                            yyn = 33;
                            continue;
                    }
                    yyn = 163;
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
                case 93:
                    yyn = yys13();
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
                case 94:
                    switch (yytok) {
                        case '(':
                            yyn = 35;
                            continue;
                    }
                    yyn = 163;
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
                case 95:
                    yyn = yys15();
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
                case 96:
                    yyn = yys16();
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
                case 97:
                    yyn = yys17();
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
                case 98:
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
                case 99:
                    yyn = yys19();
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
                case 100:
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
                case 101:
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
                case 102:
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
                case 103:
                    yyn = yys23();
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
                case 104:
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
                case 105:
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
                case 106:
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
                case 107:
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
                case 108:
                    yyn = yys28();
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
                case 109:
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
                case 110:
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
                case 111:
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
                case 112:
                    yyn = yys32();
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
                case 113:
                    switch (yytok) {
                        case '{':
                            yyn = 54;
                            continue;
                    }
                    yyn = 163;
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
                case 114:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 56;
                            continue;
                        case INT:
                            yyn = 57;
                            continue;
                        case MONEY:
                            yyn = 58;
                            continue;
                    }
                    yyn = 163;
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
                case 115:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 116:
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
                case 117:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 118:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 119:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 121:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 124:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 127:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    yyn = yys50();
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    yyn = yys52();
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 163;
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
                case 134:
                    switch (yytok) {
                        case IF:
                            yyn = 14;
                            continue;
                        case IDENT:
                            yyn = 64;
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    switch (yytok) {
                        case '{':
                            yyn = 65;
                            continue;
                    }
                    yyn = 163;
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
                case 136:
                    switch (yytok) {
                        case '{':
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 163;
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
                case 137:
                    switch (yytok) {
                        case '{':
                            yyn = yyr17();
                            continue;
                    }
                    yyn = 163;
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
                case 138:
                    switch (yytok) {
                        case '{':
                            yyn = yyr16();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
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
                case 141:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case IDENT:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    switch (yytok) {
                        case IF:
                            yyn = 14;
                            continue;
                        case IDENT:
                            yyn = 64;
                            continue;
                        case '}':
                            yyn = 68;
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    switch (yytok) {
                        case ':':
                            yyn = 34;
                            continue;
                    }
                    yyn = 163;
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
                case 145:
                    switch (yytok) {
                        case STRING:
                            yyn = 69;
                            continue;
                    }
                    yyn = 163;
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
                case 146:
                    switch (yytok) {
                        case '{':
                            yyn = 54;
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 67:
                    yyst[yysp] = 67;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 147:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case IDENT:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 163;
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
                case 148:
                    switch (yytok) {
                        case '}':
                        case ELSE:
                        case IF:
                        case ENDINPUT:
                        case IDENT:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 163;
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
                case 149:
                    switch (yytok) {
                        case '(':
                            yyn = 72;
                            continue;
                        case '}':
                            yyn = 73;
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 70:
                    yyst[yysp] = 70;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 150:
                    switch (yytok) {
                        case ELSE:
                            yyn = 75;
                            continue;
                        case '}':
                        case IF:
                        case ENDINPUT:
                        case IDENT:
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 151:
                    switch (yytok) {
                        case '}':
                            yyn = 76;
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 72:
                    yyst[yysp] = 72;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 152:
                    yyn = yys72();
                    continue;

                case 73:
                    yyst[yysp] = 73;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 153:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case ENDINPUT:
                        case IDENT:
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 74:
                    yyst[yysp] = 74;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 154:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case ENDINPUT:
                        case IDENT:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 75:
                    yyst[yysp] = 75;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 155:
                    switch (yytok) {
                        case '{':
                            yyn = 54;
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 76:
                    yyst[yysp] = 76;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 156:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case ENDINPUT:
                        case IDENT:
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 77:
                    yyst[yysp] = 77;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 157:
                    yyn = yys77();
                    continue;

                case 78:
                    yyst[yysp] = 78;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 158:
                    switch (yytok) {
                        case '}':
                        case IF:
                        case ENDINPUT:
                        case IDENT:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 79:
                    yyst[yysp] = 79;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 159:
                    switch (yytok) {
                        case '}':
                            yyn = yyr18();
                            continue;
                    }
                    yyn = 163;
                    continue;

                case 160:
                    return true;
                case 161:
                    yyerror("stack overflow");
                case 162:
                    return false;
                case 163:
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

    private int yys0() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case FORM:
                return 12;
            case IDENT:
                return 13;
            case IF:
                return 14;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 163;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 21;
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case OR:
                return 26;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
            case ENDINPUT:
                return yyr4();
        }
        return 163;
    }

    private int yys4() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr21();
        }
        return 163;
    }

    private int yys7() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr20();
        }
        return 163;
    }

    private int yys9() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr19();
        }
        return 163;
    }

    private int yys10() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr41();
        }
        return 163;
    }

    private int yys11() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr40();
        }
        return 163;
    }

    private int yys13() {
        switch (yytok) {
            case ':':
                return 34;
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '/':
            case '*':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr42();
        }
        return 163;
    }

    private int yys15() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr38();
        }
        return 163;
    }

    private int yys16() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr39();
        }
        return 163;
    }

    private int yys17() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys18() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys19() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys20() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys21() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys22() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys23() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys24() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys25() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys26() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys27() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys28() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys29() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys30() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys31() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys32() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys35() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys36() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr29();
        }
        return 163;
    }

    private int yys37() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr42();
        }
        return 163;
    }

    private int yys38() {
        switch (yytok) {
            case AND:
                return 21;
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case OR:
                return 26;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
            case ')':
                return 61;
        }
        return 163;
    }

    private int yys39() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr23();
        }
        return 163;
    }

    private int yys40() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr24();
        }
        return 163;
    }

    private int yys41() {
        switch (yytok) {
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
            case OR:
            case ')':
            case ENDINPUT:
            case AND:
                return yyr36();
        }
        return 163;
    }

    private int yys42() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr30();
        }
        return 163;
    }

    private int yys43() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr34();
        }
        return 163;
    }

    private int yys44() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr35();
        }
        return 163;
    }

    private int yys45() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr31();
        }
        return 163;
    }

    private int yys46() {
        switch (yytok) {
            case AND:
                return 21;
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
            case OR:
            case ')':
            case ENDINPUT:
                return yyr37();
        }
        return 163;
    }

    private int yys47() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr25();
        }
        return 163;
    }

    private int yys48() {
        switch (yytok) {
            case '*':
                return 27;
            case '/':
                return 30;
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr27();
        }
        return 163;
    }

    private int yys49() {
        switch (yytok) {
            case '*':
                return 27;
            case '/':
                return 30;
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr28();
        }
        return 163;
    }

    private int yys50() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr26();
        }
        return 163;
    }

    private int yys51() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr33();
        }
        return 163;
    }

    private int yys52() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case OR:
            case GEQ:
            case NEQ:
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr32();
        }
        return 163;
    }

    private int yys59() {
        switch (yytok) {
            case AND:
                return 21;
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case OR:
                return 26;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
        }
        return 163;
    }

    private int yys60() {
        switch (yytok) {
            case ')':
                return 66;
            case OR:
            case GEQ:
            case '/':
            case NEQ:
            case '-':
            case '+':
            case '<':
            case '>':
            case '*':
            case LEQ:
            case EQ:
            case AND:
                return yyr20();
        }
        return 163;
    }

    private int yys61() {
        switch (yytok) {
            case OR:
            case GEQ:
            case NEQ:
            case '-':
            case '+':
            case '*':
            case '/':
            case ')':
            case '<':
            case '>':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr22();
        }
        return 163;
    }

    private int yys72() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
            case IDENT:
                return 37;
        }
        return 163;
    }

    private int yys77() {
        switch (yytok) {
            case AND:
                return 21;
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case OR:
                return 26;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
            case ')':
                return 79;
        }
        return 163;
    }

    private int yyr1() { // top : node
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr18() { // assignment : '(' expr ')'
        yysp -= 3;
        return 71;
    }

    private int yyr6() { // block : '{' statements '}'
        yysp -= 3;
        switch (yyst[yysp-1]) {
            case 66: return 70;
            case 33: return 53;
            default: return 78;
        }
    }

    private int yyr11() { // elseBranch : ELSE block
        yysp -= 2;
        return 74;
    }

    private int yyr12() { // elseBranch : /* empty */
        return 74;
    }

    private int yyr19() { // expr : arithexpr
        yysp -= 1;
        return yypexpr();
    }

    private int yyr20() { // expr : relexpr
        yysp -= 1;
        return yypexpr();
    }

    private int yyr21() { // expr : literal
        yysp -= 1;
        return yypexpr();
    }

    private int yyr22() { // expr : '(' expr ')'
        { yyrv = ((Expr)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 35: return 59;
            case 32: return 52;
            case 31: return 51;
            case 30: return 50;
            case 29: return 49;
            case 28: return 48;
            case 27: return 47;
            case 26: return 46;
            case 25: return 45;
            case 24: return 44;
            case 23: return 43;
            case 22: return 42;
            case 21: return 41;
            case 20: return 40;
            case 19: return 39;
            case 18: return 38;
            case 17: return 36;
            case 0: return 2;
            default: return 77;
        }
    }

    private int yyr5() { // form : FORM IDENT block
        yysp -= 3;
        return 3;
    }

    private int yyr38() { // literal : INT
        yysp -= 1;
        return 4;
    }

    private int yyr39() { // literal : MONEY
        yysp -= 1;
        return 4;
    }

    private int yyr40() { // literal : FLOAT
        yysp -= 1;
        return 4;
    }

    private int yyr41() { // literal : BOOLEAN
        yysp -= 1;
        return 4;
    }

    private int yyr42() { // literal : IDENT
        yysp -= 1;
        return 4;
    }

    private int yyr2() { // node : form
        yysp -= 1;
        return 5;
    }

    private int yyr3() { // node : statement
        yysp -= 1;
        return 5;
    }

    private int yyr4() { // node : expr
        yysp -= 1;
        return 5;
    }

    private int yyr13() { // question : IDENT ':' questionType '{' STRING '}'
        yysp -= 6;
        return 6;
    }

    private int yyr14() { // question : IDENT ':' questionType '{' STRING assignment '}'
        yysp -= 7;
        return 6;
    }

    private int yyr15() { // questionType : BOOLEAN
        yysp -= 1;
        return 55;
    }

    private int yyr16() { // questionType : MONEY
        yysp -= 1;
        return 55;
    }

    private int yyr17() { // questionType : INT
        yysp -= 1;
        return 55;
    }

    private int yyr29() { // relexpr : '!' expr
        { yyrv = new Not(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yyprelexpr();
    }

    private int yyr30() { // relexpr : expr EQ expr
        { yyrv = new Eq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr31() { // relexpr : expr NEQ expr
        { yyrv = new NEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr32() { // relexpr : expr '>' expr
        { yyrv = new GT(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr33() { // relexpr : expr '<' expr
        { yyrv = new LT(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr34() { // relexpr : expr GEQ expr
        { yyrv = new GEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr35() { // relexpr : expr LEQ expr
        { yyrv = new LEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr36() { // relexpr : expr AND expr
        { yyrv = new And(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr37() { // relexpr : expr OR expr
        { yyrv = new Or(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyprelexpr() {
        switch (yyst[yysp-1]) {
            case 35: return 60;
            default: return 7;
        }
    }

    private int yyr9() { // statement : question
        yysp -= 1;
        return yypstatement();
    }

    private int yyr10() { // statement : IF '(' relexpr ')' block elseBranch
        yysp -= 6;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 54: return 62;
            case 0: return 8;
            default: return 67;
        }
    }

    private int yyr7() { // statements : statements statement
        yysp -= 2;
        return 63;
    }

    private int yyr8() { // statements : statement
        yysp -= 1;
        return 63;
    }

    private int yyr23() { // arithexpr : '+' expr
        { yyrv = new Pos(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 9;
    }

    private int yyr24() { // arithexpr : '-' expr
        { yyrv = new Neg(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 9;
    }

    private int yyr25() { // arithexpr : expr '*' expr
        { yyrv = new Mul(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 9;
    }

    private int yyr26() { // arithexpr : expr '/' expr
        { yyrv = new Div(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 9;
    }

    private int yyr27() { // arithexpr : expr '+' expr
        { yyrv = new Add(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 9;
    }

    private int yyr28() { // arithexpr : expr '-' expr
        { yyrv = new Sub(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 9;
    }

    protected String[] yyerrmsgs = {
    };

private QLLexer lexer; 

private ASTNode result;

public ASTNode getResult() {
  return result;
}

public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

}
