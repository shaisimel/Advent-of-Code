def __main():

    with open('input.txt') as f:
        lines = f.readlines()
    f.close()

    pairs = dict()

    for line_index in range(2, len(lines), 1):
        line = lines[line_index].split(' -> ')
        pairs[line[0]] = line[1].strip()

    template = lines[0].strip()

    for i in range(10):
        next_template = ''
        for index in range(len(template)-1):
            current_element = template[index] + template[index+1]
            next_template += template[index] + pairs[current_element]
        template = next_template + template[len(template)-1]

    element_counter = dict()

    for i in range(len(template)):
        if not element_counter.get(template[i]):
            element_counter[template[i]] = 0
        element_counter[template[i]] += 1

    most_common = max(element_counter.values())
    least_common = min(element_counter.values())

    print (most_common - least_common)

__main()
