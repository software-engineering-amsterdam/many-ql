// Output created by jacc on Tue Feb 10 16:49:53 CET 2015

package cons.ql.parser;

import cons.ql.ast.*;
import cons.ql.ast.expression.*;
import cons.ql.ast.expression.unary.*;
import cons.ql.ast.expression.literal.*;
import cons.ql.ast.expression.arithmetic.*;
import cons.ql.ast.expression.relational.*;
import cons.ql.ast.statement.*;

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
                case 83:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 166;
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    yyn = yys6();
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    yyn = yys8();
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
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
                case 93:
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
                case 94:
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
                case 95:
                    switch (yytok) {
                        case IDENT:
                            yyn = 39;
                            continue;
                    }
                    yyn = 169;
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
                case 96:
                    switch (yytok) {
                        case ':':
                            yyn = 40;
                            continue;
                    }
                    yyn = 169;
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
                case 97:
                    switch (yytok) {
                        case '(':
                            yyn = 41;
                            continue;
                    }
                    yyn = 169;
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
                case 98:
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
                case 99:
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
                case 100:
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
                case 101:
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
                case 102:
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
                case 103:
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
                case 104:
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
                case 105:
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
                case 106:
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
                case 107:
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
                case 108:
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
                case 109:
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
                case 110:
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
                case 111:
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
                case 112:
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
                case 113:
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
                case 114:
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
                case 115:
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
                case 116:
                    yyn = yys33();
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
                case 117:
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
                case 118:
                    yyn = yys35();
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
                case 119:
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
                case 120:
                    yyn = yys37();
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
                case 121:
                    yyn = yys38();
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
                case 122:
                    switch (yytok) {
                        case '{':
                            yyn = 58;
                            continue;
                    }
                    yyn = 169;
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
                case 123:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 10;
                            continue;
                        case FLOAT:
                            yyn = 11;
                            continue;
                        case INT:
                            yyn = 20;
                            continue;
                        case MONEY:
                            yyn = 21;
                            continue;
                        case STRING:
                            yyn = 22;
                            continue;
                    }
                    yyn = 169;
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
                case 124:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 127:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    yyn = yys50();
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    yyn = yys52();
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
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
                case 141:
                    switch (yytok) {
                        case IDENT:
                            yyn = 13;
                            continue;
                        case IF:
                            yyn = 14;
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    switch (yytok) {
                        case '{':
                            yyn = 64;
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
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
                case 144:
                    yyn = yys61();
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 145:
                    switch (yytok) {
                        case IDENT:
                            yyn = 13;
                            continue;
                        case IF:
                            yyn = 14;
                            continue;
                        case '}':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 146:
                    switch (yytok) {
                        case '}':
                            yyn = 67;
                            continue;
                    }
                    yyn = 169;
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
                case 147:
                    switch (yytok) {
                        case INITSTRING:
                            yyn = 68;
                            continue;
                    }
                    yyn = 169;
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
                case 148:
                    switch (yytok) {
                        case '{':
                            yyn = 69;
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 149:
                    switch (yytok) {
                        case '}':
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 169;
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
                case 150:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 169;
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
                case 151:
                    switch (yytok) {
                        case ASSIGN:
                            yyn = 70;
                            continue;
                        case '}':
                            yyn = 71;
                            continue;
                    }
                    yyn = 169;
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
                case 152:
                    switch (yytok) {
                        case IDENT:
                            yyn = 13;
                            continue;
                        case IF:
                            yyn = 14;
                            continue;
                    }
                    yyn = 169;
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
                case 153:
                    switch (yytok) {
                        case '(':
                            yyn = 73;
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 154:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case IDENT:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 72:
                    yyst[yysp] = 72;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 155:
                    switch (yytok) {
                        case '}':
                            yyn = 74;
                            continue;
                    }
                    yyn = 169;
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
                case 156:
                    yyn = yys73();
                    continue;

                case 74:
                    yyst[yysp] = 74;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 157:
                    switch (yytok) {
                        case ELSE:
                            yyn = 77;
                            continue;
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case IDENT:
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 75:
                    yyst[yysp] = 75;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 158:
                    yyn = yys75();
                    continue;

                case 76:
                    yyst[yysp] = 76;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 159:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case IDENT:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 77:
                    yyst[yysp] = 77;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 160:
                    switch (yytok) {
                        case '{':
                            yyn = 79;
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 78:
                    yyst[yysp] = 78;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 161:
                    switch (yytok) {
                        case '}':
                            yyn = 80;
                            continue;
                    }
                    yyn = 169;
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
                case 162:
                    switch (yytok) {
                        case IDENT:
                            yyn = 13;
                            continue;
                        case IF:
                            yyn = 14;
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 80:
                    yyst[yysp] = 80;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 163:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case IDENT:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 81:
                    yyst[yysp] = 81;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 164:
                    switch (yytok) {
                        case '}':
                            yyn = 82;
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 82:
                    yyst[yysp] = 82;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 165:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case IDENT:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 169;
                    continue;

                case 166:
                    return true;
                case 167:
                    yyerror("stack overflow");
                case 168:
                    return false;
                case 169:
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
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 27;
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case OR:
                return 32;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case ENDINPUT:
                return yyr4();
        }
        return 169;
    }

    private int yys4() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr14();
        }
        return 169;
    }

    private int yys6() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr16();
        }
        return 169;
    }

    private int yys8() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr15();
        }
        return 169;
    }

    private int yys9() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr13();
        }
        return 169;
    }

    private int yys10() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '{':
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr21();
        }
        return 169;
    }

    private int yys11() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '{':
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr20();
        }
        return 169;
    }

    private int yys15() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr27();
        }
        return 169;
    }

    private int yys16() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr26();
        }
        return 169;
    }

    private int yys17() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr24();
        }
        return 169;
    }

    private int yys18() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr25();
        }
        return 169;
    }

    private int yys19() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr28();
        }
        return 169;
    }

    private int yys20() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '{':
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr18();
        }
        return 169;
    }

    private int yys21() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '{':
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr19();
        }
        return 169;
    }

    private int yys22() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '{':
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr22();
        }
        return 169;
    }

    private int yys23() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys24() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys25() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys26() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys27() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys28() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys29() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys30() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys31() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys32() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys33() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys34() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys35() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys36() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys37() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys38() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys41() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys42() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr35();
        }
        return 169;
    }

    private int yys43() {
        switch (yytok) {
            case AND:
                return 27;
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case OR:
                return 32;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case ')':
                return 61;
        }
        return 169;
    }

    private int yys44() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr29();
        }
        return 169;
    }

    private int yys45() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr30();
        }
        return 169;
    }

    private int yys46() {
        switch (yytok) {
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case ')':
            case OR:
            case ENDINPUT:
            case AND:
                return yyr42();
        }
        return 169;
    }

    private int yys47() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr36();
        }
        return 169;
    }

    private int yys48() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr40();
        }
        return 169;
    }

    private int yys49() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr41();
        }
        return 169;
    }

    private int yys50() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr37();
        }
        return 169;
    }

    private int yys51() {
        switch (yytok) {
            case AND:
                return 27;
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case ')':
            case OR:
            case ENDINPUT:
                return yyr43();
        }
        return 169;
    }

    private int yys52() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr31();
        }
        return 169;
    }

    private int yys53() {
        switch (yytok) {
            case '*':
                return 33;
            case '/':
                return 36;
            case '+':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr33();
        }
        return 169;
    }

    private int yys54() {
        switch (yytok) {
            case '*':
                return 33;
            case '/':
                return 36;
            case '+':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr34();
        }
        return 169;
    }

    private int yys55() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr32();
        }
        return 169;
    }

    private int yys56() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr39();
        }
        return 169;
    }

    private int yys57() {
        switch (yytok) {
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr38();
        }
        return 169;
    }

    private int yys60() {
        switch (yytok) {
            case AND:
                return 27;
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case OR:
                return 32;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case ')':
                return 65;
        }
        return 169;
    }

    private int yys61() {
        switch (yytok) {
            case '+':
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case '-':
            case GEQ:
            case ENDINPUT:
            case AND:
                return yyr17();
        }
        return 169;
    }

    private int yys73() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INITBOOLEAN:
                return 15;
            case INITFLOAT:
                return 16;
            case INITINT:
                return 17;
            case INITMONEY:
                return 18;
            case INITSTRING:
                return 19;
            case INT:
                return 20;
            case MONEY:
                return 21;
            case STRING:
                return 22;
            case '!':
                return 23;
            case '(':
                return 24;
            case '+':
                return 25;
            case '-':
                return 26;
            case '*':
            case ')':
            case OR:
            case EQ:
            case NEQ:
            case '>':
            case '<':
            case LEQ:
            case '/':
            case GEQ:
            case AND:
                return yyr23();
        }
        return 169;
    }

    private int yys75() {
        switch (yytok) {
            case AND:
                return 27;
            case EQ:
                return 28;
            case GEQ:
                return 29;
            case LEQ:
                return 30;
            case NEQ:
                return 31;
            case OR:
                return 32;
            case '*':
                return 33;
            case '+':
                return 34;
            case '-':
                return 35;
            case '/':
                return 36;
            case '<':
                return 37;
            case '>':
                return 38;
            case ')':
                return 78;
        }
        return 169;
    }

    private int yyr1() { // top : node
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr11() { // elseBranch : ELSE '{' statements '}'
        yysp -= 4;
        return 76;
    }

    private int yyr12() { // elseBranch : /* empty */
        return 76;
    }

    private int yyr13() { // expression : type
        yysp -= 1;
        return yypexpression();
    }

    private int yyr14() { // expression : literal
        yysp -= 1;
        return yypexpression();
    }

    private int yyr15() { // expression : arithmeticExpression
        yysp -= 1;
        return yypexpression();
    }

    private int yyr16() { // expression : relationalExpression
        yysp -= 1;
        return yypexpression();
    }

    private int yyr17() { // expression : '(' expression ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 41: return 60;
            case 38: return 57;
            case 37: return 56;
            case 36: return 55;
            case 35: return 54;
            case 34: return 53;
            case 33: return 52;
            case 32: return 51;
            case 31: return 50;
            case 30: return 49;
            case 29: return 48;
            case 28: return 47;
            case 27: return 46;
            case 26: return 45;
            case 25: return 44;
            case 24: return 43;
            case 23: return 42;
            case 0: return 2;
            default: return 75;
        }
    }

    private int yyr5() { // form : FORM IDENT '{' statements '}'
        { yyrv = new Form(((QLIdent)yysv[yysp-4]), ((Block)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 3;
    }

    private int yyr23() { // literal : /* empty */
        return 4;
    }

    private int yyr24() { // literal : INITINT
        yysp -= 1;
        return 4;
    }

    private int yyr25() { // literal : INITMONEY
        yysp -= 1;
        return 4;
    }

    private int yyr26() { // literal : INITFLOAT
        yysp -= 1;
        return 4;
    }

    private int yyr27() { // literal : INITBOOLEAN
        yysp -= 1;
        return 4;
    }

    private int yyr28() { // literal : INITSTRING
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

    private int yyr4() { // node : expression
        yysp -= 1;
        return 5;
    }

    private int yyr35() { // relationalExpression : '!' expression
        { yyrv = new Not(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 6;
    }

    private int yyr36() { // relationalExpression : expression EQ expression
        { yyrv = new Eq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr37() { // relationalExpression : expression NEQ expression
        { yyrv = new NEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr38() { // relationalExpression : expression '>' expression
        { yyrv = new GT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr39() { // relationalExpression : expression '<' expression
        { yyrv = new LT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr40() { // relationalExpression : expression GEQ expression
        { yyrv = new GEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr41() { // relationalExpression : expression LEQ expression
        { yyrv = new LEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr42() { // relationalExpression : expression AND expression
        { yyrv = new And(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr43() { // relationalExpression : expression OR expression
        { yyrv = new Or(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr8() { // statement : IDENT ':' type '{' INITSTRING '}'
        { yyrv = new Question(((QLIdent)yysv[yysp-6]), ((QLType)yysv[yysp-4]), ((QLString)yysv[yysp-2])); }
        yysv[yysp-=6] = yyrv;
        return yypstatement();
    }

    private int yyr9() { // statement : IDENT ':' type '{' INITSTRING ASSIGN '(' expression ')' '}'
        { yyrv = new ComputedQuestion(((QLIdent)yysv[yysp-10]), ((QLType)yysv[yysp-8]), ((QLString)yysv[yysp-6]), ((Expression)yysv[yysp-3])); }
        yysv[yysp-=10] = yyrv;
        return yypstatement();
    }

    private int yyr10() { // statement : IF '(' expression ')' '{' statements '}' elseBranch
        yysp -= 8;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 0: return 7;
            default: return 62;
        }
    }

    private int yyr6() { // statements : statement statements
        { yyrv = new Block(((Statement)yysv[yysp-2]), ((Block)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypstatements();
    }

    private int yyr7() { // statements : statement
        { yyrv = new Block(((Statement)yysv[yysp-1])); }
        yysv[yysp-=1] = yyrv;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 69: return 72;
            case 62: return 66;
            case 58: return 63;
            default: return 81;
        }
    }

    private int yyr29() { // arithmeticExpression : '+' expression
        { yyrv = new Pos(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 8;
    }

    private int yyr30() { // arithmeticExpression : '-' expression
        { yyrv = new Neg(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 8;
    }

    private int yyr31() { // arithmeticExpression : expression '*' expression
        { yyrv = new Mul(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 8;
    }

    private int yyr32() { // arithmeticExpression : expression '/' expression
        { yyrv = new Div(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 8;
    }

    private int yyr33() { // arithmeticExpression : expression '+' expression
        { yyrv = new Add(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 8;
    }

    private int yyr34() { // arithmeticExpression : expression '-' expression
        { yyrv = new Sub(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 8;
    }

    private int yyr18() { // type : INT
        { yyrv = new QLInt(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr19() { // type : MONEY
        { yyrv = new QLFloat(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr20() { // type : FLOAT
        { yyrv = new QLFloat(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr21() { // type : BOOLEAN
        { yyrv = new QLBoolean(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr22() { // type : STRING
        { yyrv = new QLString(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyptype() {
        switch (yyst[yysp-1]) {
            case 40: return 59;
            default: return 9;
        }
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
  System.err.println(yyerrno<0 ? msg : yyerrmsgs[yyerrno]);
}

}
