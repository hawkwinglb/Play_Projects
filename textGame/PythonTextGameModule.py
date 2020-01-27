class Character():
    

    def __init__(self, name, description, health, damage, equippedItem, inventory, equippableItems):
        self.name = name
        self.description = description
        self.health = health
        self.damage = damage
        self.equippedItem = equippedItem
        self.inventory = inventory
        self.equippableItems = equippableItems
    

    def getName():
        return name 
    
    def setName(name):
        name = name

    def getDescription():
        return description
    
    def setDescription(description):
        description = description

    def getHealth():
        return health
    
    def setHealth(health):
        health = health
    
    def getDamage():
        return damage

    def setDamage():
        damage = damage
    
    def getEquippedItem():
        return equippedItem

    def setEquippedItem(equippedItem):
        equippedItem = equippedItem

    def getInventory():
        return inventory

    def setInventory(inventory):
        inventory = inventory
    
    def getEquippableItems():
        return equippableItems

    def setEquippableItems(equippableItems):
        equippableItems = equippableItems

    def addToInventory(item):
        inventory.append(item)


class Monster():

    def __init__(self, name, description, health, damage, flavourSpeech):
        self.name = name
        self.description = description
        self.health = health
        self.damage = damage
        self.flavourSpeech = flavourSpeech
        isHostile = True

    def getName():
        return name 
    
    def setName(name):
        name = name

    def getDescription():
        return description
    
    def setDescription(description):
        description = description

    def getHealth():
        return health
    
    def setHealth(health):
        health = health
    
    def getDamage():
        return damage

    def setDamage():
        damage = damage

    def getIsHostile():
        return isHostile
    
    def setIsHostile(hostile):
        isHostile = hostile

    def setFlavourSpeech(flavourSpeech):
        flavourSpeech = flavourSpeech
    
    def getFlavourSpeech():
        return flavourSpeech

class Item():

    def __init__(self, name, description, damage, equippable):
        self.name = name
        self.description = description
        self.damage = damage
        self.equippable = equippable

    def getName():
        return name

    def setName(name):
        name = name
    
    def getDescription():
        return description

    def setDescription(description):
        description = description
    
    def getDamage():
        return damage 

    def setDamage(damage):
        damage = damage

    def getEquippable():
        return equippable

    def setEquippable(equippable):
        equippable = equippable