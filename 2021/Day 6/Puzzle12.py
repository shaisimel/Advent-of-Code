
def __main():

    with open('input.txt') as f:
        lines = f.readlines()
        f.close()

        fish = [0, 0, 0, 0, 0, 0, 0, 0, 0]

        for val in lines[0].split(','):
            fish[int(val)] += 1

        for i in range(256):
            next_fish = [0, 0, 0, 0, 0, 0, 0, 0, 0]
            for j in range(8):
                next_fish[j] = fish[j+1]
            next_fish[6] += fish[0]
            next_fish[8] += fish[0]
            fish = next_fish

        print(sum(fish))

__main()
