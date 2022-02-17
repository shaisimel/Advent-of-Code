with open('input.txt') as f:
    lines = f.readlines()

    val = 9999999999
    count = 0

    for line in lines:
        if int(line) > val:
            count += 1
        val = int(line)

    f.close()

    print(count)