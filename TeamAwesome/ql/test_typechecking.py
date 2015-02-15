import argparse
import glob

from AST import AST
import type_checker

def run_test(test_filename):
    ast = AST(test_filename)
    type_check_result = type_checker.check(ast)

    expected_num_messages = int(
        test_filename.split('.')[0].split('-')[2]
    )

    num_messages = len(type_check_result.messages)
    success = num_messages == expected_num_messages

    if(not success):
        print(('-'*10)+'Type check test FAIL')

        for m in type_check_result.messages:
            print(message)

        print( '^'+('-'*9)+test_filename+': '\
             + 'got '+str(num_messages)+' message(s) but expected '\
             + str(expected_num_messages) + ('-'*10)
             ) 
        
    return success

def main():
    arg_parser = argparse.ArgumentParser()
    arg_parser.add_argument('-f'
                           ,'--file'
                           ,help="Test only this file."
                           )
    args = arg_parser.parse_args()

    failures = 0

    if args.file:
        test_filenames = [args.file]
    else:
        test_filenames = glob.glob('type-check-*.ql')

    for test_filename in test_filenames:
        if(not run_test(test_filename)):
            ++failures

    print( '\n'\
         + str(failures) + ' error(s) total.\n'\
         + 'Tested '+str(len(test_filenames))+' file(s): '\
         + str(test_filenames)
         )

if __name__ == '__main__':
    main()
