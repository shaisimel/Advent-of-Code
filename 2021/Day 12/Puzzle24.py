def is_visit_allowed(cave, current_route, double_visited):
    return cave.isupper() or (cave.islower() and not double_visited) \
           or (cave.islower() and double_visited and not current_route.__contains__(cave))


def get_num_of_paths(graph, node, target_node, current_route, double_visited):
    if not is_visit_allowed(node, current_route, double_visited) or (node == 'start' and len(current_route) > 0):
        return 0

    if node == target_node:
        return 1

    count = 0
    current_route.append(node)

    is_double_visit = node.islower() and current_route.count(node) == 2

    for cave in graph.get(node):
        count += get_num_of_paths(graph, cave, target_node, current_route, is_double_visit or double_visited)

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

    paths = get_num_of_paths(caves, 'start', 'end', [], False)

    print(paths)


__main()
