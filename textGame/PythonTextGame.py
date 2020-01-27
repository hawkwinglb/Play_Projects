#import classes

import PythonTextGameModule
from PythonTextGameModule import Item, Character, Monster
from random import seed
from random import choice, randint
import random

#set up rooms as nested dictionary
#dictionary seems to be more straightforward to navigate than Java's HashMaps

rooms = {
    #start with kitchen
    "kitchen" : {
        "north" : "dining room",
        "east" : "hall",
        "south" : "cellar",
        "west" : "garden",
    },
    "hall" : {
        "west" : "kitchen",
        "east" : "dining room"
    },
    "dining room" : {
        "south" : "kitchen",
        "east" : "hall",
        "west" : "ballroom"
    },
    "garden" : {
        "east" : "kitchen",
        "north" : "ballroom"
    },
    "ballroom" : {
        "south" : "garden",
        "east" : "dining room"
    },
    "cellar" : {
        "north" : "kitchen"
    },
    "passageway" : {
        "up" :  "cellar",
        "north" : "cave"
    },
    "cave" : {
        "south" : "passageway",
        "north" : "cavern"
    },
    "cavern" : {
        "south" : "cave"
    }

}


#create a function to display location

def showStatus():
    print("-----------------")
    print("You are in a " + currentRoom)
    print("-----------------")




#create items

book = Item("Distant Whispers", "a book. From its pages you think you hear the murmur of far-off voices", 0, False)
doll = Item("bloody doll", "a child's doll, with staring glass eyes, covered in blood", 0, False)
knife = Item("sharp knife", "a boning knife, sharpened to a keen edge", 5, True)
hockeystick = Item("hockey stick", "a field hockey stick, with gravel embedded in its head and its handle peeling", 5, True)
deadflower = Item("dead rose", "a dead rose in a plant pot", 2, True)
key = Item("key", "small iron key", 0, False)

#create speech lists for monsters
beastSpeech = ["*scream*", "*howl*", "*growl*", "*groan*", "..."]
hauntedSpeech = ["You will die now.", "Your bones will feed our children!", "So sweet the meat.", "We bring your doom!"]

#create monsters

badDog = Monster("slavering dog", "The dog has bared teeth and a foam-specked muzzle.", 7, 5, beastSpeech, True)
angryBird = Monster("evil bird", "The bird has mad eyes and a wickedly hooked beak.", 5, 3, beastSpeech, True)

ghost = Monster("wisp", "The wisp has a translucent, human-like shape. You can see the wall through it.", 5, 2, hauntedSpeech, True);
creepyChild = Monster("revenant child", "The blood dripping from its eyes and pointed teeth gives you the first clue that this isn't a normal human child...", 7, 7, hauntedSpeech, True);

#create monster list for random encounters

monsterList = [badDog, angryBird, ghost, creepyChild]

#create a function to randomise monster presence and fight monsters




def monsterHere():
    values = [0, 1]
    value = random.choice(values)
    if value == 1:
        print("You are not alone.")
        bound = len(monsterList)
        bound = bound-1
        ranNum = randint(0, bound)
        pickedMonster = monsterList[ranNum]
        monsterName = pickedMonster.getName()
        print("You see a ", monsterName)
        if pickedMonster.getIsHostile() == True:
            while pickedMonster.getIsHostile() == True:
                print("The " + pickedMonster.getName() + " attacks!")
                monsterDamage = pickedMonster.getDamage();
                print("It deals you ", monsterDamage, " damage.")
                health = player.getHealth() - monsterDamage
                player.setHealth(health)
                print("Your health is: ", player.getHealth())
                runAway = input("Press 1 to fight back. Press 2 to run away.")

                if runAway==2:
                    currentRoom = random.choice(rooms)
                elif runAway == 1:
                    playerDamage=player.getDamage()+equipped.getDamage()
                    print("You fight back, dealing ", playerDamage)
                    pickedMonster.setHealth(pickedMonster.getHealth()-playerDamage)
                else:
                    print("That is not a good choice.")

                if pickedMonster.getHealth()<=0:
                    pickedMonster.setIsHostile(False)
                    print("The ", pickedMonster.getName(), " runs away.")        
    elif value == 0:
        print("You are alone.")
    else:
        print("Something is wrong.")



currentRoom = "kitchen"

playername = input("What is your character's name?")

#equippedItem

equipped = Item("none", "none", 0, True)


#empty inventory
inventory = []

#empty equippable items

equippableItems = []

player = Character(playername, "The smallest idiot.", 10, 5, equipped, inventory, equippableItems)






        




carryOn = 0

while carryOn == 0:
    picked = False
    showStatus()
    monsterHere()

    #manage navigation
    move = " "

    while move == " ":
        #prompt for input
        print("You can move:")
        for i in rooms[currentRoom]:
            print(i)

        move = input("Go: ")
        move.lower().strip()

        if move in rooms[currentRoom]:
            currentRoom = rooms[currentRoom][move]
        else:
            print("You can\'t got that way.")

