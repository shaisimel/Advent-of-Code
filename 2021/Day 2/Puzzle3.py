with open('input.txt') as f:
    lines = f.readlines()
    f.close()

    depth = 0
    position = 0

    for line in lines:
        com = line.split()
        command = com[0]
        distance = int(com[1])

        if command == 'forward':
            position += distance
        elif command == 'up':
            depth -= distance
        elif command == 'down':
            depth += distance

    print(depth * position)