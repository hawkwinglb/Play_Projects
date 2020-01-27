
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
        name = name

    def getDescription(self):
        return self.description
    
    def setDescription(description):
        description = description

    def getHealth(self):
        return self.health
    
    def setHealth(health):
        health = health
    
    def getDamage(self):
        return self.damage

    def setDamage(damage):
        damage = damage
    
    def getEquippedItem(self):
        return self.equippedItem

    def setEquippedItem(equippedItem):
        equippedItem = equippedItem

    def getInventory(self):
        return self.inventory

    def setInventory(inventory):
        inventory = inventory
    
    def getEquippableItems(self):
        return self.equippableItems

    def setEquippableItems(equippableItems):
        equippableItems = equippableItems

    def addToInventory(item):
        inventory.append(item)


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
    
    def setName(name):
        name = name

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

    def setDamage(damage):
        damage = damage

    def getIsHostile(self):
        return self.isHostile
    
    def setIsHostile(hostile):
        isHostile = hostile

    def setFlavourSpeech(flavourSpeech):
        flavourSpeech = flavourSpeech
    
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

    def setName(name):
        self.name = name
    
    def getDescription(self):
        return self.description

    def setDescription(description):
        self.description = description
    
    def getDamage(self):
        return self.damage 

    def setDamage(damage):
        self.damage = damage

    def getEquippable(self):
        return self.equippable

    def setEquippable(equippable):
        self.equippable = equippable