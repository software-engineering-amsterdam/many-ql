import collections


def check_duplicates(l):
    duplicates = [x for x, y in collections.Counter(l).items() if y > 1]
    return duplicates


def check_ids(ids):
    duplicates = check_duplicates(ids)
    if duplicates:
        return ["There are duplicate ids: " + str(duplicates)]
    else:
        return ""


def check_labels(labels):
    messages = []
    duplicates = check_duplicates(labels)
    for i in duplicates:
        messages.append("duplicate label: " + i)
    return messages


def check_dependencies(dependencies):
    message = []
    for d in dependencies:
        if d in dependencies[d]:
            message += [str(d) + " is dependent on itself"]
    return message