def __main():
    with open('input.txt') as f:
        lines = f.readlines()
    f.close()

    segments = [6, 2, 5, 5, 4, 5, 6, 3, 7, 6]
    total_sum = 0

    count = 0
    for line in lines:
        inputs = line.split(' | ')

        six_segments = []
        five_segments = []
        numbers = ['', '', '', '', '', '', '', '', '', '']

        for value in inputs[0].split():
            sorted_value = "".join(sorted(value))
            val_len = len(sorted_value)
            if val_len == 2:
                numbers[1] = sorted_value
            elif val_len == 3:
                numbers[7] = sorted_value
            elif val_len == 4:
                numbers[4] = sorted_value
            elif val_len == 5:
                five_segments.append(sorted_value)
            elif val_len == 6:
                six_segments.append(sorted_value)
            elif val_len == 7:
                numbers[8] = sorted_value

        for curr_segment in five_segments:
            is_three = True
            for i in range(len(numbers[1])):
                if not curr_segment.__contains__(numbers[1][i]):
                    is_three = False
                    break
            if is_three:
                numbers[3] = curr_segment
                five_segments.remove(curr_segment)
                break

        for curr_segment in six_segments:
            is_six = False
            for i in range(len(numbers[1])):
                if not curr_segment.__contains__(numbers[1][i]):
                    is_six = True
                    break
            if is_six:
                numbers[6] = curr_segment
                six_segments.remove(curr_segment)
                break

        for curr_segment in six_segments:
            is_nine = True
            for i in range(len(numbers[4])):
                if not curr_segment.__contains__(numbers[4][i]):
                    is_nine = False
                    break
            if is_nine:
                numbers[9] = curr_segment
                six_segments.remove(curr_segment)
                break

        numbers[0] = six_segments[0]

        for curr_segment in five_segments:
            is_five = True
            for i in range(len(curr_segment)):
                if not numbers[9].__contains__(curr_segment[i]):
                    is_five = False
                    break
            if is_five:
                numbers[5] = curr_segment
                five_segments.remove(curr_segment)
                break
        numbers[2] = five_segments[0]

        nums_dict = dict()
        for i in range(len(numbers)):
            nums_dict[numbers[i]] = i

        current_input = 0
        for value in inputs[1].split():
            sorted_value = "".join(sorted(value))
            current_input *= 10
            current_input += nums_dict[sorted_value]

        total_sum += current_input

    print(total_sum)


__main()
