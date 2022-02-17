with open('input.txt') as f:
    lines = f.readlines()
    count = 0

    for i in range(len(lines)-3):
        val1 = int(lines[i]) + int(lines[i+1]) + int(lines[i+2])
        val2 = int(lines[i+3]) + int(lines[i + 1]) + int(lines[i + 2])
        if val2 > val1:
            count += 1

    f.close()

    print(count)