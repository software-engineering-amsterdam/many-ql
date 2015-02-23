// Output created by jacc on Tue Feb 17 14:24:26 CET 2015

package cons.ql.parser;

import cons.ql.ast.*;
import cons.ql.ast.expression.*;
import cons.ql.ast.expression.type.*;
import cons.ql.ast.expression.literal.*;
import cons.ql.ast.expression.arithmetic.*;
import cons.ql.ast.expression.relational.*;
import cons.ql.ast.statement.*;

@SuppressWarnings("all")

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
                case 86:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 172;
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    yyn = yys6();
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    yyn = yys8();
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    yyn = yys9();
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
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
                case 97:
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
                case 98:
                    yyn = yys12();
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
                case 99:
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
                case 100:
                    yyn = yys14();
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
                case 101:
                    switch (yytok) {
                        case IDENTIFIER:
                            yyn = 40;
                            continue;
                    }
                    yyn = 175;
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
                case 102:
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
                case 103:
                    switch (yytok) {
                        case '(':
                            yyn = 42;
                            continue;
                    }
                    yyn = 175;
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
                case 104:
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
                case 105:
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
                case 106:
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
                case 107:
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
                case 108:
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
                case 109:
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
                case 110:
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
                case 111:
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
                case 112:
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
                case 113:
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
                case 114:
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
                case 115:
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
                case 116:
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
                case 117:
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
                case 118:
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
                case 119:
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
                case 120:
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
                case 121:
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
                case 122:
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
                case 123:
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
                case 124:
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
                case 125:
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
                case 126:
                    switch (yytok) {
                        case '{':
                            yyn = 60;
                            continue;
                    }
                    yyn = 175;
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
                case 127:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 11;
                            continue;
                        case FLOAT:
                            yyn = 13;
                            continue;
                        case INTEGER:
                            yyn = 18;
                            continue;
                        case MONEY:
                            yyn = 20;
                            continue;
                        case STRING:
                            yyn = 22;
                            continue;
                    }
                    yyn = 175;
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
                case 128:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    yyn = yys43();
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
                case 130:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    yyn = yys50();
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    yyn = yys52();
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
                    yyn = yys53();
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
                    yyn = yys54();
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 141:
                    yyn = yys55();
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    yyn = yys56();
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    yyn = yys58();
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 145:
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
                case 146:
                    switch (yytok) {
                        case IF:
                            yyn = 17;
                            continue;
                        case IDENTIFIER:
                            yyn = 66;
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 147:
                    switch (yytok) {
                        case '{':
                            yyn = 67;
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 148:
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
                case 149:
                    yyn = yys63();
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 150:
                    switch (yytok) {
                        case IF:
                            yyn = 17;
                            continue;
                        case IDENTIFIER:
                            yyn = 66;
                            continue;
                        case '}':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 151:
                    switch (yytok) {
                        case '}':
                            yyn = 70;
                            continue;
                    }
                    yyn = 175;
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
                case 152:
                    switch (yytok) {
                        case ':':
                            yyn = 41;
                            continue;
                    }
                    yyn = 175;
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
                case 153:
                    switch (yytok) {
                        case STRINGLITERAL:
                            yyn = 71;
                            continue;
                    }
                    yyn = 175;
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
                case 154:
                    switch (yytok) {
                        case '{':
                            yyn = 72;
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 69:
                    yyst[yysp] = 69;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 155:
                    switch (yytok) {
                        case '}':
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 175;
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
                case 156:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 175;
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
                case 157:
                    switch (yytok) {
                        case ASSIGN:
                            yyn = 73;
                            continue;
                        case '}':
                            yyn = 74;
                            continue;
                    }
                    yyn = 175;
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
                case 158:
                    switch (yytok) {
                        case IF:
                            yyn = 17;
                            continue;
                        case IDENTIFIER:
                            yyn = 66;
                            continue;
                    }
                    yyn = 175;
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
                case 159:
                    switch (yytok) {
                        case '(':
                            yyn = 76;
                            continue;
                    }
                    yyn = 175;
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
                case 160:
                    switch (yytok) {
                        case IF:
                        case IDENTIFIER:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 75:
                    yyst[yysp] = 75;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 161:
                    switch (yytok) {
                        case '}':
                            yyn = 77;
                            continue;
                    }
                    yyn = 175;
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
                case 162:
                    yyn = yys76();
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
                case 163:
                    switch (yytok) {
                        case ELSE:
                            yyn = 80;
                            continue;
                        case IF:
                        case IDENTIFIER:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 78:
                    yyst[yysp] = 78;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 164:
                    yyn = yys78();
                    continue;

                case 79:
                    yyst[yysp] = 79;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 165:
                    switch (yytok) {
                        case IF:
                        case IDENTIFIER:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 175;
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
                case 166:
                    switch (yytok) {
                        case '{':
                            yyn = 82;
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 81:
                    yyst[yysp] = 81;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 167:
                    switch (yytok) {
                        case '}':
                            yyn = 83;
                            continue;
                    }
                    yyn = 175;
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
                case 168:
                    switch (yytok) {
                        case IF:
                            yyn = 17;
                            continue;
                        case IDENTIFIER:
                            yyn = 66;
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 83:
                    yyst[yysp] = 83;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 169:
                    switch (yytok) {
                        case IF:
                        case IDENTIFIER:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 84:
                    yyst[yysp] = 84;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 170:
                    switch (yytok) {
                        case '}':
                            yyn = 85;
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 85:
                    yyst[yysp] = 85;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 171:
                    switch (yytok) {
                        case IF:
                        case IDENTIFIER:
                        case ENDINPUT:
                        case '}':
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 175;
                    continue;

                case 172:
                    return true;
                case 173:
                    yyerror("stack overflow");
                case 174:
                    return false;
                case 175:
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
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case FORM:
                return 15;
            case IDENTIFIER:
                return 16;
            case IF:
                return 17;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
        }
        return 175;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 28;
            case EQ:
                return 29;
            case GEQ:
                return 30;
            case LEQ:
                return 31;
            case NEQ:
                return 32;
            case OR:
                return 33;
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case '<':
                return 38;
            case '>':
                return 39;
            case ENDINPUT:
                return yyr4();
        }
        return 175;
    }

    private int yys4() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr15();
        }
        return 175;
    }

    private int yys6() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr18();
        }
        return 175;
    }

    private int yys8() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr17();
        }
        return 175;
    }

    private int yys9() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr14();
        }
        return 175;
    }

    private int yys10() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr16();
        }
        return 175;
    }

    private int yys11() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case '{':
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr23();
        }
        return 175;
    }

    private int yys12() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr28();
        }
        return 175;
    }

    private int yys13() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case '{':
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr22();
        }
        return 175;
    }

    private int yys14() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr27();
        }
        return 175;
    }

    private int yys16() {
        switch (yytok) {
            case ':':
                return 41;
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr13();
        }
        return 175;
    }

    private int yys18() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case '{':
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr20();
        }
        return 175;
    }

    private int yys19() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr25();
        }
        return 175;
    }

    private int yys20() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case '{':
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr21();
        }
        return 175;
    }

    private int yys21() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr26();
        }
        return 175;
    }

    private int yys22() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case '{':
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr24();
        }
        return 175;
    }

    private int yys23() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr29();
        }
        return 175;
    }

    private int yys24() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys25() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys26() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys27() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys28() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys29() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys30() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys31() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys32() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys33() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys34() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys35() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys36() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys37() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys38() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys39() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys42() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys43() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr36();
        }
        return 175;
    }

    private int yys44() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr13();
        }
        return 175;
    }

    private int yys45() {
        switch (yytok) {
            case AND:
                return 28;
            case EQ:
                return 29;
            case GEQ:
                return 30;
            case LEQ:
                return 31;
            case NEQ:
                return 32;
            case OR:
                return 33;
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case '<':
                return 38;
            case '>':
                return 39;
            case ')':
                return 63;
        }
        return 175;
    }

    private int yys46() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr30();
        }
        return 175;
    }

    private int yys47() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr31();
        }
        return 175;
    }

    private int yys48() {
        switch (yytok) {
            case EQ:
                return 29;
            case GEQ:
                return 30;
            case LEQ:
                return 31;
            case NEQ:
                return 32;
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case '<':
                return 38;
            case '>':
                return 39;
            case ')':
            case ENDINPUT:
            case OR:
            case AND:
                return yyr43();
        }
        return 175;
    }

    private int yys49() {
        switch (yytok) {
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '>':
            case '<':
            case NEQ:
            case LEQ:
            case AND:
                return yyr37();
        }
        return 175;
    }

    private int yys50() {
        switch (yytok) {
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '>':
            case '<':
            case NEQ:
            case LEQ:
            case AND:
                return yyr41();
        }
        return 175;
    }

    private int yys51() {
        switch (yytok) {
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '>':
            case '<':
            case NEQ:
            case LEQ:
            case AND:
                return yyr42();
        }
        return 175;
    }

    private int yys52() {
        switch (yytok) {
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '>':
            case '<':
            case NEQ:
            case LEQ:
            case AND:
                return yyr38();
        }
        return 175;
    }

    private int yys53() {
        switch (yytok) {
            case AND:
                return 28;
            case EQ:
                return 29;
            case GEQ:
                return 30;
            case LEQ:
                return 31;
            case NEQ:
                return 32;
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case '<':
                return 38;
            case '>':
                return 39;
            case ')':
            case ENDINPUT:
            case OR:
                return yyr44();
        }
        return 175;
    }

    private int yys54() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr32();
        }
        return 175;
    }

    private int yys55() {
        switch (yytok) {
            case '*':
                return 34;
            case '/':
                return 37;
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '>':
            case '<':
            case NEQ:
            case '-':
            case '+':
            case LEQ:
            case AND:
                return yyr34();
        }
        return 175;
    }

    private int yys56() {
        switch (yytok) {
            case '*':
                return 34;
            case '/':
                return 37;
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '>':
            case '<':
            case NEQ:
            case '-':
            case '+':
            case LEQ:
            case AND:
                return yyr35();
        }
        return 175;
    }

    private int yys57() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr33();
        }
        return 175;
    }

    private int yys58() {
        switch (yytok) {
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '>':
            case '<':
            case NEQ:
            case LEQ:
            case AND:
                return yyr40();
        }
        return 175;
    }

    private int yys59() {
        switch (yytok) {
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '>':
            case '<':
            case NEQ:
            case LEQ:
            case AND:
                return yyr39();
        }
        return 175;
    }

    private int yys62() {
        switch (yytok) {
            case AND:
                return 28;
            case EQ:
                return 29;
            case GEQ:
                return 30;
            case LEQ:
                return 31;
            case NEQ:
                return 32;
            case OR:
                return 33;
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case '<':
                return 38;
            case '>':
                return 39;
            case ')':
                return 68;
        }
        return 175;
    }

    private int yys63() {
        switch (yytok) {
            case ')':
            case EQ:
            case GEQ:
            case ENDINPUT:
            case OR:
            case '<':
            case NEQ:
            case '/':
            case '-':
            case '>':
            case '+':
            case '*':
            case LEQ:
            case AND:
                return yyr19();
        }
        return 175;
    }

    private int yys76() {
        switch (yytok) {
            case BOOLEAN:
                return 11;
            case BOOLEANLITERAL:
                return 12;
            case FLOAT:
                return 13;
            case FLOATLITERAL:
                return 14;
            case INTEGER:
                return 18;
            case INTEGERLITERAL:
                return 19;
            case MONEY:
                return 20;
            case MONEYLITERAL:
                return 21;
            case STRING:
                return 22;
            case STRINGLITERAL:
                return 23;
            case '!':
                return 24;
            case '(':
                return 25;
            case '+':
                return 26;
            case '-':
                return 27;
            case IDENTIFIER:
                return 44;
        }
        return 175;
    }

    private int yys78() {
        switch (yytok) {
            case AND:
                return 28;
            case EQ:
                return 29;
            case GEQ:
                return 30;
            case LEQ:
                return 31;
            case NEQ:
                return 32;
            case OR:
                return 33;
            case '*':
                return 34;
            case '+':
                return 35;
            case '-':
                return 36;
            case '/':
                return 37;
            case '<':
                return 38;
            case '>':
                return 39;
            case ')':
                return 81;
        }
        return 175;
    }

    private int yyr1() { // top : node
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr11() { // elseBranch : ELSE '{' statements '}'
        yysp -= 4;
        return 79;
    }

    private int yyr12() { // elseBranch : /* empty */
        return 79;
    }

    private int yyr13() { // expression : IDENTIFIER
        yysp -= 1;
        return yypexpression();
    }

    private int yyr14() { // expression : type
        yysp -= 1;
        return yypexpression();
    }

    private int yyr15() { // expression : literal
        yysp -= 1;
        return yypexpression();
    }

    private int yyr16() { // expression : unaryExpression
        yysp -= 1;
        return yypexpression();
    }

    private int yyr17() { // expression : arithmeticExpression
        yysp -= 1;
        return yypexpression();
    }

    private int yyr18() { // expression : relationalExpression
        yysp -= 1;
        return yypexpression();
    }

    private int yyr19() { // expression : '(' expression ')'
        { yyrv = ((Expression)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpression();
    }

    private int yypexpression() {
        switch (yyst[yysp-1]) {
            case 42: return 62;
            case 39: return 59;
            case 38: return 58;
            case 37: return 57;
            case 36: return 56;
            case 35: return 55;
            case 34: return 54;
            case 33: return 53;
            case 32: return 52;
            case 31: return 51;
            case 30: return 50;
            case 29: return 49;
            case 28: return 48;
            case 27: return 47;
            case 26: return 46;
            case 25: return 45;
            case 24: return 43;
            case 0: return 2;
            default: return 78;
        }
    }

    private int yyr5() { // form : FORM IDENTIFIER '{' statements '}'
        { yyrv = new Form(((Identifier)yysv[yysp-4]), ((Block)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 3;
    }

    private int yyr25() { // literal : INTEGERLITERAL
        yysp -= 1;
        return 4;
    }

    private int yyr26() { // literal : MONEYLITERAL
        yysp -= 1;
        return 4;
    }

    private int yyr27() { // literal : FLOATLITERAL
        yysp -= 1;
        return 4;
    }

    private int yyr28() { // literal : BOOLEANLITERAL
        yysp -= 1;
        return 4;
    }

    private int yyr29() { // literal : STRINGLITERAL
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

    private int yyr36() { // relationalExpression : '!' expression
        { yyrv = new Not(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 6;
    }

    private int yyr37() { // relationalExpression : expression EQ expression
        { yyrv = new Eq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr38() { // relationalExpression : expression NEQ expression
        { yyrv = new NEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr39() { // relationalExpression : expression '>' expression
        { yyrv = new GT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr40() { // relationalExpression : expression '<' expression
        { yyrv = new LT(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr41() { // relationalExpression : expression GEQ expression
        { yyrv = new GEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr42() { // relationalExpression : expression LEQ expression
        { yyrv = new LEq(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr43() { // relationalExpression : expression AND expression
        { yyrv = new And(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr44() { // relationalExpression : expression OR expression
        { yyrv = new Or(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 6;
    }

    private int yyr8() { // statement : IDENTIFIER ':' type '{' STRINGLITERAL '}'
        { yyrv = new Question(((Identifier)yysv[yysp-6]), ((QLType)yysv[yysp-4]), ((StringLiteral)yysv[yysp-2])); }
        yysv[yysp-=6] = yyrv;
        return yypstatement();
    }

    private int yyr9() { // statement : IDENTIFIER ':' type '{' STRINGLITERAL ASSIGN '(' expression ')' '}'
        { yyrv = new ComputedQuestion(((Identifier)yysv[yysp-10]), ((QLType)yysv[yysp-8]), ((StringLiteral)yysv[yysp-6]), ((Expression)yysv[yysp-3])); }
        yysv[yysp-=10] = yyrv;
        return yypstatement();
    }

    private int yyr10() { // statement : IF '(' expression ')' '{' statements '}' elseBranch
        { yyrv = new If(((Expression)yysv[yysp-6]), ((Block)yysv[yysp-3])); }
        yysv[yysp-=8] = yyrv;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 0: return 7;
            default: return 64;
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
            case 72: return 75;
            case 64: return 69;
            case 60: return 65;
            default: return 84;
        }
    }

    private int yyr32() { // arithmeticExpression : expression '*' expression
        { yyrv = new Mul(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 8;
    }

    private int yyr33() { // arithmeticExpression : expression '/' expression
        { yyrv = new Div(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 8;
    }

    private int yyr34() { // arithmeticExpression : expression '+' expression
        { yyrv = new Add(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 8;
    }

    private int yyr35() { // arithmeticExpression : expression '-' expression
        { yyrv = new Sub(((Expression)yysv[yysp-3]), ((Expression)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 8;
    }

    private int yyr20() { // type : INTEGER
        { yyrv = new QLInteger(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr21() { // type : MONEY
        { yyrv = new QLFloat(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr22() { // type : FLOAT
        { yyrv = new QLFloat(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr23() { // type : BOOLEAN
        { yyrv = new QLBoolean(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyr24() { // type : STRING
        { yyrv = new QLString(); }
        yysv[yysp-=1] = yyrv;
        return yyptype();
    }

    private int yyptype() {
        switch (yyst[yysp-1]) {
            case 41: return 61;
            default: return 9;
        }
    }

    private int yyr30() { // unaryExpression : '+' expression
        { yyrv = new Pos(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 10;
    }

    private int yyr31() { // unaryExpression : '-' expression
        { yyrv = new Neg(((Expression)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 10;
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
