import unittest
import QL.Grammar.grammar as grammar


class Tests(unittest.TestCase):
    def test_grammar_id(self):
        # Test simple _id
        result = grammar.characters.parseString("this_is_an_id").asList()
        self.assertEqual(result, ["this_is_an_id"])

        # ids cannot have spaces
        result = grammar.characters.parseString("this_is_an_id a").asList()
        self.assertIsNot(result, ["this_is_and_id a"])

    def test_grammar_sentence(self):
        # Test simple sentence, btw between every word (or punctuation) comes a space
        result = grammar.sentence.parseString("this is a sentence.").asList()
        self.assertEqual(result, ["this is a sentence ."])

    @unittest.expectedFailure
    def test_grammar_sentence_fail(self):
        # This sentence has no end sign and therefore will fail
        result = grammar.sentence.parseString("this is a sentence").asList()
        self.assertEqual(result, ["this is a sentence"])

    def test_grammar_sentences(self):
        # Multiple sentences with escaped characters
        result = grammar.sentences.parseString("this is a sentence. Is this another one? Can we escape \? , \!  and \. ?").asList()
        self.assertEqual(result, ["this is a sentence .", "Is this another one ?", 'Can we escape ? , ! and . ?'])

    @unittest.expectedFailure
    def test_grammar_answer_format_fail(self):
        # Not an _answer possibility
        result = grammar.answer_type.parseString("set").asList()
        self.assertEqual(result, ["set"])

    # TODO add expression and form parsing


