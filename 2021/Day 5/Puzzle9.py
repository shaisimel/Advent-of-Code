def inc_dict(dict, key):
    val = 0
    if dict.get(key):
        val = dict.get(key)
    dict[key] = val + 1


def __main():

    with open('input.txt') as f:
        lines = f.readlines()
        f.close()

        point_dict = dict()

        for line in lines:
            cords = line.split(' -> ')
            x1 = int(cords[0].split(',')[0])
            y1 = int(cords[0].split(',')[1])
            x2 = int(cords[1].split(',')[0])
            y2 = int(cords[1].split(',')[1])

            if x1 == x2:
                for i in range(min(y1, y2), max(y1, y2) + 1, 1):
                    inc_dict(point_dict, str(x1)+','+str(i))
            elif y1 == y2:
                for i in range(min(x1, x2), max(x1, x2) + 1, 1):
                    inc_dict(point_dict, str(i) + ',' + str(y1))

        count = 0
        for val in point_dict.values():
            if val > 1:
                count += 1

        print(count)

__main()
