import random

# rock class
class Rock:
    def __init__(self):
        self.item = 'rock' 
    def attack (self,randItem):
        return randItem.attackbyRock()
    def attackbyRock(self):
        return 'Its a tie!'
    def attackbyScissor(self):
        return 'Your opponent wins!'
    def attackbyPaper(self):
        return 'You win!'

# paper class
class Paper:
    def __init__(self):
        self.item = 'paper'
    def attack (self,randItem):
        return randItem.attackbyPaper()
    def attackbyRock(self):
        return 'Your opponent wins!'
    def attackbyScissor(self):
        return 'You win!'
    def attackbyPaper(self):
        return 'Its a tie!'

# scissor class
class Scissor:
    def __init__(self):
        self.item = 'scissor'
    def attack (self,randItem):
        return randItem.attackbyScissor()
    def attackbyRock(self):
        return 'You win!'
    def attackbyScissor(self):
        return 'Its a tie!'
    def attackbyPaper(self):
        return 'Your opponent wins!'

class RockPaperScissors:
    # scoring variables
    playerScore = 0
    pcScore = 0

    # generate random item
    def getRandomItem(self):
        index = random.randint(0, 2)
        if (index == 0):
            randItem = Rock()
        elif (index == 1):
            randItem = Paper()
        else:
            randItem = Scissor()
        return randItem

    # main program  
    def main(self):        
        # ask for rounds
        rounds = int(input('How many rounds?'))
        counter = rounds
        print('Game started')

        # loop through rounds
        while(rounds > 0):
            rounds = rounds - 1
            
            # accept choice from player
            print ('Make your choice for round : ' + str(counter - rounds))
            playerItem = input()

            # generate random item
            randItem = self.getRandomItem()

            # object creation
            if (playerItem == 'rock'):
                operation = Rock();
            elif (playerItem == 'paper'):
                operation = Paper()
            elif (playerItem == 'scissor'):
                operation = Scissor()

            # call
            result = operation.attack(randItem)

            # register results
            if (result == 'You win!'):
                self.playerScore = self.playerScore + 1
            elif (result == 'Your opponent wins!'):
                self.pcScore = self.pcScore + 1

            # print round score
            print('You chose {0}, your opponent chose {1}. {2}'.format(playerItem,randItem.item,result))

        # print final score
        print ('Result: You Won {0} times, your opponent won {1} times.'.format(self.playerScore,self.pcScore))
        if(self.playerScore == self.pcScore):
            print ('Its a tie!')
        elif (self.playerScore > self.pcScore):
            print ('You Win! Congratulations!!')
        elif (self.playerScore < self.pcScore):
            print ('Your opponent won! Better luck next time!!')

if __name__ == '__main__':
    rps = RockPaperScissors()
    rps.main()
