def __main():
    with open('input.txt') as f:
        lines = f.readlines()
    f.close()

    segments = [6, 2, 5, 5, 4, 5, 6, 3, 7, 6]

    count = 0
    for line in lines:
        values = line.split(' | ')[1].split()
        for val in values:
            l = len(val)
            if l == segments[1] or l == segments[4] or l == segments[7] or l == segments[8]:
                count += 1

    print(count)


__main()
