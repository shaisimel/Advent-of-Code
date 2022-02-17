matrix_size = 5


def create_matrix(vals, index):
    result = [[0 for x in range(matrix_size)] for y in range(matrix_size)]

    for i in range(matrix_size):
        result[i] = [int(numeric_string) for numeric_string in vals[index+i].split()]

    return result


def mark_board(board, winning_number):
    for i in range(matrix_size):
        for j in range(matrix_size):
            if board[j][i] == winning_number:
                board[j][i] *= -1


def is_board_winner(board):
    for i in range(matrix_size):
        col = 0
        row = 0
        for j in range(matrix_size):
            if board[j][i] < 0:
                col += 1
            if board[i][j] < 0:
                row += 1
        if row == matrix_size or col == matrix_size:
            return True
    return False


def sum_board(board):
    total = 0
    for i in range(matrix_size):
        for j in range(matrix_size):
            if board[j][i] >= 0:
                total += board[j][i]
    return total


def __main():

    with open('input.txt') as f:
        lines = f.readlines()
        f.close()

        winning_numbers = [int(numeric_string) for numeric_string in lines[0].split(',')]
        boards = []

        for i in range(2, len(lines), 6):
            boards.append(create_matrix(lines, i))

        for number in winning_numbers:
            boards_to_remove = []
            for board in boards:
                mark_board(board, number)
                if is_board_winner(board):
                    if len(boards) == 1:
                        print(number * sum_board(board))
                        return
                    else:
                        boards_to_remove.append(board)
            for b in boards_to_remove:
                boards.remove(b)


__main()
