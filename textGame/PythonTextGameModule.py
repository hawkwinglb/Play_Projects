name = "name"
description = "description"

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
        return name 
    
    def setName(name):
        name = name

    def getDescription(self):
        return description
    
    def setDescription(description):
        description = description

    def getHealth(self):
        return health
    
    def setHealth(health):
        health = health
    
    def getDamage(self):
        return damage

    def setDamage(damage):
        damage = damage
    
    def getEquippedItem(self):
        return equippedItem

    def setEquippedItem(equippedItem):
        equippedItem = equippedItem

    def getInventory(self):
        return inventory

    def setInventory(inventory):
        inventory = inventory
    
    def getEquippableItems(self):
        return equippableItems

    def setEquippableItems(equippableItems):
        equippableItems = equippableItems

    def addToInventory(item):
        inventory.append(item)


class Monster():

    def __init__(self, name, description, health, damage, flavourSpeech, isHostile):
        name = name
        description = description
        health = health
        damage = damage
        flavourSpeech = flavourSpeech
        isHostile = isHostile

    def getName(self):
        return name
    
    def setName(name):
        name = name

    def getDescription(self):
        return description
    
    def setDescription(description):
        description = description

    def getHealth(self):
        return health
    
    def setHealth(health):
        health = health
    
    def getDamage(self):
        return damage

    def setDamage(damage):
        damage = damage

    def getIsHostile(self):
        return isHostile
    
    def setIsHostile(hostile):
        isHostile = hostile

    def setFlavourSpeech(flavourSpeech):
        flavourSpeech = flavourSpeech
    
    def getFlavourSpeech(self):
        return flavourSpeech

class Item():

    def __init__(self, name, description, damage, equippable):
        self.name = name
        self.description = description
        self.damage = damage
        self.equippable = equippable

    def getName(self):
        return name

    def setName(name):
        name = name
    
    def getDescription(self):
        return description

    def setDescription(description):
        description = description
    
    def getDamage(self):
        return damage 

    def setDamage(damage):
        damage = damage

    def getEquippable(self):
        return equippable

    def setEquippable(equippable):
        equippable = equippable