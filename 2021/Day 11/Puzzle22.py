def is_valid(land, row, col):
    if row < 0 or row >= len(land) or col < 0 or col >= len(land[row]) or land[row][col] > 9:
        return False
    return True


def __main():

    with open('input.txt') as f:
        lines = f.readlines()
    f.close()

    rows = len(lines)
    cols = len(lines[0])-1
    directions = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]

    land = [[0 for x in range(cols)] for y in range(rows)]

    for r in range(rows):
        for c in range(cols):
            land[r][c] = int(lines[r][c])

    flash_queue = []
    did_all_flash = False
    turns = 0
    while not did_all_flash:
        turns += 1
        for r in range(rows):
            for c in range(cols):
                land[r][c] += 1
                if land[r][c] > 9:
                    flash_queue.append([r, c])

        while len(flash_queue) > 0:
            loc = flash_queue.pop(0)
            for direction in directions:
                next_row = loc[0] + direction[0]
                next_col = loc[1] + direction[1]
                if is_valid(land, next_row, next_col):
                    land[next_row][next_col] += 1
                    if land[next_row][next_col] > 9:
                        flash_queue.append([next_row, next_col])

        did_all_flash = True
        for r in range(rows):
            for c in range(cols):
                if land[r][c] > 9:
                    land[r][c] = 0
                else:
                    did_all_flash = False

    print(turns)


__main()
