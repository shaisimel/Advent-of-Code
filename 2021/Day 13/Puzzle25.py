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

    fold_point = instructions[0][1]
    next_points = set()
    for point in points:
        new_x = point[0]
        if point[0] >= fold_point:
            new_x = fold_point - (point[0]-fold_point)
        next_point = (new_x, point[1])
        next_points.add(next_point)

    points = next_points

    print(len(points))


__main()
