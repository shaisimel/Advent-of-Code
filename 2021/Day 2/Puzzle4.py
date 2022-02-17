with open('input.txt') as f:
    lines = f.readlines()
    f.close()

    depth = 0
    position = 0
    aim = 0

    for line in lines:
        com = line.split()
        command = com[0]
        distance = int(com[1])

        if command == 'forward':
            position += distance
            depth += aim * distance
        elif command == 'up':
            aim -= distance
        elif command == 'down':
            aim += distance

    print(depth * position)