
class Character():
    

    def __init__(self, name, description, health, damage, equippedItem, inventory, equippableItems):
        self.name = name
        self.description = description
        self.health = health
        self.damage = damage
        self.equippedItem = equippedItem
        self.inventory = inventory
        self.equippableItems = equippableItems
    

    def getName(self):
        return self.name 
    
    def setName(name):
        self.name = name

    def getDescription(self):
        return self.description
    
    def setDescription(description):
        self.description = description

    def getHealth(self):
        return self.health
    
    def setHealth(self, health):
        self.health = health
    
    def getDamage(self):
        return self.damage

    def setDamage(damage):
        self.damage = damage
    
    def getEquippedItem(self):
        return self.equippedItem

    def setEquippedItem(self, equippedItem):
        self.equippedItem = equippedItem

    def getInventory(self):
        return self.inventory

    def setInventory(self, inventory):
        self.inventory = inventory
    
    def getEquippableItems(self):
        return self.equippableItems

    def setEquippableItems(self, equippableItems):
        self.equippableItems = equippableItems

    def addToInventory(self, item):
        self.inventory.append(item)

    def addToEquippable(self, item):
        self.equippableItems.append(item)



class Monster():

    def __init__(self, name, description, health, damage, flavourSpeech, isHostile):
        self.name = name
        self.description = description
        self.health = health
        self.damage = damage
        self.flavourSpeech = flavourSpeech
        self.isHostile = isHostile

    def getName(self):
        return self.name
    
    def setName(self, name):
        self.name = name

    def getDescription(self):
        return self.description
    
    def setDescription(self, description):
        self.description = description

    def getHealth(self):
        return self.health
    
    def setHealth(self, health):
        self.health = health
    
    def getDamage(self):
        return self.damage

    def setDamage(self, damage):
        self.damage = damage

    def getIsHostile(self):
        return self.isHostile
    
    def setIsHostile(self, isHostile):
        self.isHostile = isHostile

    def setFlavourSpeech(self, flavourSpeech):
        self.flavourSpeech = flavourSpeech
    
    def getFlavourSpeech(self):
        return self.flavourSpeech

class Item():

    def __init__(self, name, description, damage, equippable):
        self.name = name
        self.description = description
        self.damage = damage
        self.equippable = equippable

    def getName(self):
        return self.name

    def setName(self, name):
        self.name = name
    
    def getDescription(self):
        return self.description

    def setDescription(self, description):
        self.description = description
    
    def getDamage(self):
        return self.damage 

    def setDamage(self, damage):
        self.damage = damage

    def getEquippable(self):
        return self.equippable

    def setEquippable(self, equippable):
        self.equippable = equippable

    def showDetails(self):
        print("You see that it is: ", self.description)
        if self.equippable == True:
            print("This item can be equipped.")
            print("Damage: ", self.damage)
