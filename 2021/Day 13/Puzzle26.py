def __main():

    with open('input.txt') as f:
        lines = f.readlines()
    f.close()

    points = set()
    instructions = []

    for line in lines:
        if len(line) > 1:
            if line.startswith('fold'):
                ins = line.split('=')
                instructions.append([ins[0], int(ins[1])])
            else:
                point = line.split(',')
                points.add((int(point[0]), int(point[1])))

    for instruction in instructions:
        fold_point = instruction[1]
        next_points = set()
        for point in points:
            if instruction[0] == 'fold along x':
                new_x = point[0]
                if point[0] >= fold_point:
                    new_x = fold_point - (point[0]-fold_point)
                next_point = (new_x, point[1])
            else:
                new_y = point[1]
                if point[1] >= fold_point:
                    new_y = fold_point - (point[1] - fold_point)
                next_point = (point[0], new_y)
            next_points.add(next_point)
        points = next_points

    max_x = 0
    max_y = 0
    for point in points:
        if point[1] > max_y:
            max_y = point[1]
        if point[0] > max_x:
            max_x = point[0]

    result = [['  ' for x in range(max_x+1)] for y in range(max_y+1)]
    for p in points:
        result[p[1]][p[0]] = '[]'

    for i in range(len(result)):
        line = ''
        for j in range(len(result[i])):
            line += result[i][j]
        print(line)


__main()
