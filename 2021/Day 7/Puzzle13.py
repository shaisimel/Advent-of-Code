def __main():
    with open('input.txt') as f:
        lines = f.readlines()
    f.close()

    crab_locations = []

    for val in lines[0].split(','):
        crab_locations.append(int(val))

    max_val = max(crab_locations)
    min_fuel = max_val * len(crab_locations)

    for i in range(max_val+1):
        current_fuel = 0
        for loc in crab_locations:
            current_fuel += abs(loc - i)
        min_fuel = min(min_fuel, current_fuel)

    print(min_fuel)


__main()
