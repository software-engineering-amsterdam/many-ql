grammar QL;
import QLLexerRules;

/**
 * TODO:
 * Expression support
 * If statement support
 */

/** parsing section */

openForm    : FORM FormID OBRACE questionSet CBRACE ;                      // construct the form

/** question structures */

questionSet : questionDef+ ;                                               // the set of questions within form
questionDef : NEWLINE QuestionID ': "' QuestionDesc '"' QuestionDataType ; // construction of a question
