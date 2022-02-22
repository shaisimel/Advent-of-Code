def is_visit_allowed(cave, current_route):
    return cave.isupper() or (cave.islower() and not current_route.__contains__(cave))


def get_num_of_paths(graph, node, target_node, current_route):
    if not is_visit_allowed(node, current_route):
        return 0

    if node == target_node:
        return 1

    count = 0
    current_route.append(node)

    for cave in graph.get(node):
        count += get_num_of_paths(graph, cave, target_node, current_route)

    current_route.pop()

    return count


def __main():

    with open('input.txt') as f:
        lines = f.readlines()
    f.close()

    caves = dict()

    for line in lines:
        vals = line.split('-')
        cave1 = vals[0].strip()
        cave2 = vals[1].strip()

        if not caves.get(cave1):
            caves[cave1] = []

        if not caves.get(cave2):
            caves[cave2] = []

        caves[cave1].append(cave2)
        caves[cave2].append(cave1)

    paths = get_num_of_paths(caves, 'start', 'end', [])

    print(paths)


__main()
