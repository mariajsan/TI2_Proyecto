package com.example.ti2_proyecto.entities

class User {
    var id:Int = 0
    var name:String? = null
    var gender:String? = null
    var color:String? = null
    var parent:String? = null
    var image:String? = null
    var level:Int = 0
    var session:Int = 0

    constructor(){}

    constructor(id:Int, name:String, gender:String, color:String, parent:String, image:String, level:Int, session:Int){
        this.id = id
        this.name = name
        this.gender = gender
        this.color = color
        this.parent = parent
        this.image = image
        this.level = level
        this.session = session
    }
}