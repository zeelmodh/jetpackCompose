package com.example.jetpackcompose

data class NamePosition (var name : String, var itemList: ItemList)

class ItemList(var positionList: List<String>)
