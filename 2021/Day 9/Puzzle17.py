def __main():

    with open('input.txt') as f:
        lines = f.readlines()
    f.close()

    rows = len(lines)
    cols = len(lines[0])-1

    land = [[0 for x in range(cols)] for y in range(rows)]

    for r in range(rows):
        for c in range(cols):
            land[r][c] = int(lines[r][c])

    low_points_sum = 0

    for r in range(rows):
        for c in range(cols):

            up = r == 0 or land[r-1][c] > land[r][c]
            down = r == rows - 1 or land[r+1][c] > land[r][c]
            left = c == 0 or land[r][c-1] > land[r][c]
            right = c == cols - 1 or land[r][c + 1] > land[r][c]

            if up and down and left and right:
                low_points_sum += land[r][c] + 1

    print(low_points_sum)


__main()
