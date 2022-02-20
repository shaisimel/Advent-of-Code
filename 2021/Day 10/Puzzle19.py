def _is_opener(c):
    return c == '(' or c == '{' or c == '<' or c == '['


def _is_valid_combo(opener, closer):
    return (opener == '(' and closer == ')') or \
           (opener == '{' and closer == '}') or \
           (opener == '[' and closer == ']') or \
           (opener == '<' and closer == '>')


def _get_score(char):
    if char == ')': return 3
    if char == ']': return 57
    if char == '}': return 1197
    if char == '>': return 25137


def __main():
    with open('input.txt') as f:
        lines = f.readlines()
    f.close()

    score = 0

    for line in lines:
        stack = []
        for i in range(len(line)-1):
            c = line[i]
            if _is_opener(c):
                stack.append(c)
            elif not _is_valid_combo(stack.pop(), c):
                score += _get_score(c)
                break

    print(score)


__main()
