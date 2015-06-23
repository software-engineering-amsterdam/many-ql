import unittest as unittest
import QL.AST.form as form


class Tests(unittest.TestCase):
    def test_type_duplicates(self):
        l1 = list(range(1, 10))
        self.assertEqual(form.Form.check_duplicates(l1), [])

        l2 = [1, 2, 3, 4, 5, 6, 2, 9]
        self.assertEqual(form.Form.check_duplicates(l2), [2])

        l3 = [1, 2, 2, 9, 1, 1]
        self.assertEqual(form.Form.check_duplicates(l3), [1, 2])

    # Doesn't work anymore as a whole form now needs to be created
    # def test_type_check_ids(self):
    #     l1 = list(range(1, 10))
    #     self.assertEqual(form.ids_error_messages(l1), "")
    #
    #     l2 = [1, 2, 3, 4, 5, 6, 2, 9]
    #     self.assertEqual(form.ids_error_messages(l2), ["There are duplicate ids: [2]"])
    #
    #     l3 = [1, 2, 2, 9, 1, 1]
    #     self.assertEqual(form.ids_error_messages(l3), ["There are duplicate ids: [1, 2]"])
    #
    # def test_type_dependencies(self):
    #     d1 = {1: set(), 2: set()}
    #     self.assertEqual(form.dependencies_error_messages(d1), [])
    #
    #     d2 = {1: {0,2,3,4}, 2: {1,3,4}}
    #     self.assertEqual(form.dependencies_error_messages(d2), [])
    #
    #     d3 = {1: {0,2,3,4}, 2: {1,2}}
    #     self.assertEqual(form.dependencies_error_messages(d3), ["2 is dependent on itself"])
