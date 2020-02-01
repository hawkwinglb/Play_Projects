#import classes

#Problems:
# 1: names in inventory call
#1.a duplicates in inventory
# 2: fights NOT ending in game over

import PythonTextGameModule
from PythonTextGameModule import Item, Character, Monster
from random import seed
from random import choice, randint
import random
import time

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
    if currentRoom == "kitchen":
        print("Once, long ago, this was a lively place.")
        time.sleep(1)
    elif currentRoom ==  "cellar":
        print("There are footprints in the dust, but you can't see where they lead.")
        time.sleep(1)
    elif currentRoom == "dining room":
        print("This room is dusty and shows no sign of human life.")
        time.sleep(1)
    elif currentRoom == "cellar":
        print("There are footsteps in the dust, but you can't see where they lead.")
        time.sleep(1)
    elif currentRoom == "passageway":
        print("It is dark here.")
        time.sleep(1)
    elif currentRoom == "cave":
        print("It's dark and cold. You might be lost.")
        time.sleep(1)
    elif currentRoom == "cavern":
        print("You do not feel happy here.")
        time.sleep(1)

def openArea():
    player.addToInventory(book)
    if currentRoom == "cellar" and book in player.getInventory():
        rooms[currentRoom].__setitem__("down", "passageway")
        rooms.__setitem__("passageway", {"up" : "cellar", "north" : "cave"})
        rooms.__setitem__("cave", {"south" : "passageway", "north" : "cavern"})
        rooms.__setitem__("cavern", {"south" : "cave"})



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
                    break

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

itemList = [book, hockeystick, doll, knife, deadflower]

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
    if len(player.getInventory()) > 0:
        print("You have the following items in inventory: ")
        for i in range(len(player.getInventory())):
            print(player.getInventory()[i].getName())
        for i in range(len(player.getInventory())):
            invItem = player.getInventory()[i]
            if invItem.getEquippable() == True:
                player.addToEquippable(invItem)

def equipManage():
    equipped = player.getEquippedItem()
    if len(player.getEquippableItems()) > 0:
        print("You have ", len(player.getEquippableItems()), " items that can be equipped.")
        if equipped in player.getEquippableItems():
            print("You have ", equipped.getName(), " equipped.")

        changeEquipped = int(input("Press 1 to equip new item. Press any other key to continue."))
        if changeEquipped == 1:
            if equipped in player.getEquippableItems():
                withoutEquipped = [x for x in player.getEquippableItems() if x != equipped]
                for i in range(len(withoutEquipped)):
                print((i+1), ": ", withoutEquipped[i].getName())

                equip = int(input("If you want to equip one of these items, press the corresponding number:"))
                if equip in range(len(withoutEquipped)):
                    equip = equip-1
                    equipped = withoutEquipped[equip]
                    player.setEquippedItem(equipped)
                    print("You equipped: ", player.getEquippedItem().getName())
            elif equipped not in player.getEquippableItems():
                for i in range(len.player.getEquippableItems()):
                    print((i+1), ": ", player.getEquippableItems()[i].getName())
                equip = int(input("If you want to equip one of these items, press the corresponding number:"))
                if equip in range(len(player.getEquippableItems())):
                    equip = equip - 1
                    equipped = player.getEquippableItems[equip]
                    player.setEquippedItem(equipped)
                    print("You equipped: ", player.getEquippedItem().getName())


def manageDuplicates():
    inventory = player.getInventory()
    inventory2 = []
    for i in inventory:
        if i not in inventory2:
            inventory2.append(i)
    player.setInventory(inventory2)

    eqInventory = player.getEquippableItems()
    eqInventory2 = []
    for i in eqInventory:
        if i not in eqInventory2:
            eqInventory2.append(i)
    player.setEquippableItems(eqInventory2)

def isKey():
    inventory = player.getInventory()
    numItems = len(inventory)
    if numItems > 0:
        if key in inventory:
            playerhealth = player.getHealth()
            if playerhealth < 10:
                print("You touch the key in your pocket. You feel better.")
                player.setHealth(10)

#equippedItem

equipped = Item("none", "none", 0, True)

#empty inventory
inventory = []

#empty equippable Items
equippableItems = []

#set empty player name
playername = " "

#create player
player = Character(playername, "stranger", 10, 5, equipped, inventory, equippableItems)



print("It is 1900. You have come to the small village of Shadeham, Gloucester, in answer to a telegraph from the curate, an old friend of yours. He believes the long-abandoned Shadeham Hall is haunted, and wants your help to exorcise its ghosts.\nStrange, though. You expected he'd meet you at the train station. Instead, the only person you can see in the cold autumn sunshine is an elderly lady seated on a bench. She's reading a penny dreadful with a garish cover: THE CURSE OF THE BLOODY CHILD.")
time.sleep(1)
print("What do you want to do?")
time.sleep(1)
decision_lady = int(input("1. Talk to the old lady.\n2.Go look for Shadeham Hall: maybe you misremembered, and you were supposed to meet Father Brown there."))

while decision_lady <1 or decision_lady>2:
    decision_lady = input("Try again. 1. Talk. 2. Go to Shadeham Hall.")

if decision_lady == 1:
    print("\"Excuse me,\" you say.\nThe old lady glances up at you suspiciously. Her eyes are a peculiar shade of yellow.")
    print("YELLOW-EYED OLD LADY: \"Who are you, then?\"")
    time.sleep(1)
    playername = input("Well, who *are* you? Enter your name.")
    player.setName(playername)
    print("YELLOW-EYED OLD LADY:" + "\"" + player.getName() + ". You're the one he's waiting for up at the Hall. He asked me to give you this. Now go away. I want to finish my book. Oh, and mind the dog. It's been living in the cellar for years.\"")
    time.sleep(1)
    print("She hands you a " + key.getName() + ".It is a " + key.getDescription() + ". Maybe it opens a door at the Hall? But the old lady is definitely not paying you any more attention.")
    player.addToInventory(key)
elif decision_lady == 2:
    print("You decide to go look for the Hall. Oh, by the way. Who are you?")
    time.sleep(1)
    playername = input("Enter your name: ")
    player.setName(playername)
    itemList.append(key)


print("Hello, ", player.getName(), "!\n Your health is: ", player.getHealth(), "\nIn a fight, you'll deal: ", player.getDamage(), " damage.")
time.sleep(1)
print("You wander up through the village. Eventually, you reach Shadeham Hall. The door stands open, but there's no sign of the curate. Maybe he's inside. You go in.")
time.sleep(1)

currentRoom = "kitchen"
carryOn = 0

while carryOn == 0:

    picked = False
    #restore health if key
    isKey()

    #display location
    showStatus()
    time.sleep(1)

    #is there a monster?
   # monsterHere()

    #is there an item?
    itemHere()

    # manage equipment
    inventoryManage()

    #open new area
    openArea()

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



