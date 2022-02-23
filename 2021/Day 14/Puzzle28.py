def __main():

    with open('input.txt') as f:
        lines = f.readlines()
    f.close()

    rules = dict()

    for line_index in range(2, len(lines), 1):
        line = lines[line_index].split(' -> ')
        rules[line[0]] = [line[0][0] + line[1].strip(), line[1].strip() + line[0][1]]

    template = lines[0].strip()

    pairs = dict()
    for index in range(len(template) - 1):
        current_element = template[index] + template[index + 1]
        if not pairs.get(current_element):
            pairs[current_element] = 0
        pairs[current_element] += 1

    for i in range(40):
        next_pairs = dict()
        for key in pairs.keys():
            for res in rules[key]:
                if not next_pairs.get(res):
                    next_pairs[res] = 0
                next_pairs[res] += pairs[key]
        pairs = next_pairs

    element_counter = dict()

    for key in pairs.keys():
        for i in range(len(key)):
            if not element_counter.get(key[i]):
                element_counter[key[i]] = 0
            element_counter[key[i]] += pairs[key]

    element_counter[template[0]] += 1
    element_counter[template[len(template)-1]] += 1

    most_common = max(element_counter.values())
    least_common = min(element_counter.values())

    print(int((most_common - least_common) / 2))

__main()