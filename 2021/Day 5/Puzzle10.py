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
            else:
                step = 1
                if x2 < x1:
                    x3 = x1
                    y3 = y1
                    x1 = x2
                    y1 = y2
                    x2 = x3
                    y2 = y3

                if y2 < y1:
                    step = -1
                for i in range(0, max(x1, x2) - min(x1, x2) + 1, 1):
                    point = str(min(x1, x2)+i) + ',' + str(y1+(i*step))
                    inc_dict(point_dict, point)

        count = 0
        for val in point_dict.values():
            if val > 1:
                count += 1

        print(count)

__main()
