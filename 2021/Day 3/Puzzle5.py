with open('input.txt') as f:
    lines = f.readlines()
    f.close()

    gamma = ''
    epsilon = ''

    for i in range(len(lines[0])):
        zeros = 0
        ones = 0

        for line in lines:
            if line[i] == '0':
                zeros += 1
            elif line[i] == '1':
                ones += 1

        if zeros > ones:
            gamma += '0'
            epsilon += '1'
        elif zeros < ones:
            gamma += '1'
            epsilon += '0'


    result = int(gamma, 2) * int(epsilon, 2)

    print(result)