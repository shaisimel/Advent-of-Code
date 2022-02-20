def _is_opener(c):
    return c == '(' or c == '{' or c == '<' or c == '['


def _is_valid_combo(opener, closer):
    return (opener == '(' and closer == ')') or \
           (opener == '{' and closer == '}') or \
           (opener == '[' and closer == ']') or \
           (opener == '<' and closer == '>')

def _get_score(char):
    if char == '(': return 1
    if char == '[': return 2
    if char == '{': return 3
    if char == '<': return 4


def __main():
    with open('input.txt') as f:
        lines = f.readlines()
    f.close()

    scores = []

    for line in lines:
        stack = []
        is_valid = True
        for i in range(len(line)-1):
            c = line[i]
            if _is_opener(c):
                stack.append(c)
            else:
                if not _is_valid_combo(stack.pop(), c):
                    is_valid = False
                    break

        if not is_valid:
            continue

        score = 0
        while len(stack) > 0:
            score *= 5
            score += _get_score(stack.pop())
        scores.append(score)

    scores.sort()
    print(scores[int((len(scores)/2))])


__main()
