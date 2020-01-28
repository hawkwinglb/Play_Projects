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
    #"passageway" : {
   #     "up" :  "cellar",
    #    "north" : "cave"
    #},
    #"cave" : {
     #   "south" : "passageway",
     #   "north" : "cavern"
    #},
    #"cavern" : {
    #    "south" : "cave"
    #}

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

currentRoom = "kitchen"

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
            monsterDamage = pickedMonster.getDamage()
            monsterSpeech = pickedMonster.getFlavourSpeech()
            boundary = len(monsterSpeech)
            boundary = boundary-1
            ran = randint(0, boundary)
            says = monsterSpeech[ran]

            check = 0

            while pickedMonster.getIsHostile() == True and check !=2:
                print(pickedMonster.getName(), ": ", says)
                print("The ", pickedMonster.getName(), " attacks!")
                monsterDamage = pickedMonster.getDamage();
                print("It deals you ", monsterDamage, " damage.")
                health = player.getHealth()
                health = health - monsterDamage
                player.setHealth(health)
                print("Your health is: ", player.getHealth())


                while check == 0:
                    #basic validation
                    while True:
                        try:
                            runAway = int(input("Press 1 to fight back. Press 2 to run away."))
                        except ValueError:
                            print("Try again: not valid input.")
                            continue
                        else:
                            break
                    #choice validation
                    if runAway==2:
                        check = 2
                    elif runAway == 1:
                        playerDamage=player.getDamage()+equipped.getDamage()
                        print("You fight back, dealing ", playerDamage, " damage.")
                        pickedMonster.setHealth(pickedMonster.getHealth()-playerDamage)
                        check = 1
                    else:
                        print("That is not a good choice.")

                if pickedMonster.getHealth()<=0:
                    pickedMonster.setIsHostile(False)
                    print("The ", pickedMonster.getName(), " runs away.")

                if player.getHealth()<=0:
                    carryOn = 10
                    print("Your health dropped to 0. Game over.")

        elif pickedMonster.getIsHostile == False:
            print("The ", pickedMonster.getName(), " cowers away from you. Perhaps you should feel bad.")
        else:
            print("Something has gone wrong.")

    elif value == 0:
        print("You are alone.")
    else:
        print("Something is wrong.")

#okay we need to figure out how to assign items to rooms
# it's going to be easier to randomise assignment here I think?

itemList = [book, key, hockeystick, doll, knife, deadflower]

#create a function to draw a random item

def itemHere():
    values = [0, 1]
    value = random.choice(values)
    if value == 1:
        print("You see an object.")
        bound = len(itemList)
        bound = bound - 1
        ranNum = randint(0, bound)
        pickedItem = itemList[ranNum]
        print("It is a ", pickedItem.getName())
        pickedItem.showDetails()

        choice = input("Do you want to add this item to your inventory? Press 1 to add. Press any other key to continue.")
        if choice == "1":
            player.addToInventory(pickedItem)
            itemList.remove(pickedItem)
            print("Inventory: ")
            for i in range(len(player.getInventory())):
                print(player.getInventory()[i].getName())

def inventoryManage():
    equipped = player.getEquippedItem()
    inventory = player.getInventory()
    numItems = len(inventory)
    if numItems > 0:
        print("You have the following items in inventory: ")
        for i in range(len(player.getInventory())):
            print(player.getInventory()[i].getName())
        for i in range(numItems):
            invItem = inventory[i]
            if invItem.getEquippable() == True:
                player.addToEquippable(invItem)

    equippableItems = player.getEquippableItems()
    numEquippable = len(equippableItems)
    if numEquippable > 0:
        print("You have ", numEquippable, " items that can be equipped.")
        for i in range(numEquippable):
            print(i, ": ", equippableItems[i].getName())

        equip = int(input("If you want to equip one of these items, press the corresponding number:"))
        if equip in range(numEquippable):
            equipped = equippableItems[equip]
            player.setEquippedItem(equipped)
            print("You equipped: ", player.getEquippedItem())





currentRoom = "kitchen"

playername = input("What is your character's name?")


#equippedItem

equipped = Item("none", "none", 0, True)

#empty inventory
inventory = []

#empty equippable Items
equippableItems = []




player = Character(playername, "The smallest idiot.", 10, 5, equipped, inventory, equippableItems)
print("Hello,", player.getName())





        




carryOn = 0

while carryOn == 0:

    picked = False

    #display location
    showStatus()

    #is there a monster?
    monsterHere()

    #is there an item?
    itemHere()

    # manage equipment
    inventoryManage()





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



