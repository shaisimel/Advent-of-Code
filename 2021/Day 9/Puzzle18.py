def get_basin_size(land, row, col, prev_val):
    if row < 0 or row >= len(land) or col < 0 or col >= len(land[0]) or land[row][col] == 9 or land[row][col] < prev_val:
        return 0

    land[row][col] *= -1

    basin_size = 1 \
                 + get_basin_size(land, row - 1, col, abs(land[row][col])) \
                 + get_basin_size(land, row + 1, col, abs(land[row][col])) \
                 + get_basin_size(land, row, col + 1, abs(land[row][col])) \
                 + get_basin_size(land, row, col - 1, abs(land[row][col]))

    return basin_size


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

    basin_sizes = []

    for r in range(rows):
        for c in range(cols):

            up = r == 0 or land[r-1][c] > land[r][c]
            down = r == rows - 1 or land[r+1][c] > land[r][c]
            left = c == 0 or land[r][c-1] > land[r][c]
            right = c == cols - 1 or land[r][c + 1] > land[r][c]

            if up and down and left and right and land[r][c] >= 0:
                basin_sizes.append(get_basin_size(land, r, c, -1))

    result = 1

    for i in range(3):
        m = max(basin_sizes)
        basin_sizes.remove(m)
        result *= m

    print(result)


__main()
