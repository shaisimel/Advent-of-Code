def getval(vals , mul):
    options = vals

    for i in range(len(vals[0])):

        zero_options = []
        ones_options = []

        for option in options:
            if option[i] == '0':
                zero_options.append(option)
            elif option[i] == '1':
                ones_options.append(option)
            else:
                continue

        if len(zero_options) * mul > len(ones_options) * mul:
            options = zero_options
        elif len(zero_options) == len(ones_options):
            if mul == 1:
                options = ones_options
            else:
                options = zero_options
        else:
            options = ones_options

        if len(options) == 1:
            return options[0]


with open('input.txt') as f:
    lines = f.readlines()
    f.close()

    oxygen_generator_rating = getval(lines, 1)
    CO2_scrubber_rating = getval(lines, -1)

    result = int(oxygen_generator_rating, 2) * int(CO2_scrubber_rating, 2)

    print(result)
