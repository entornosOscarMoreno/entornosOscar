
class Dron {
var activo=true
    companion object{
        var numeroTotal=0
    }

    constructor(){
        numeroTotal++
        numero= numeroTotal
    }
    var numero:Int= 0

fun dimeEstado():Boolean{
    if (activo){
        println("El dron $numero esta activo")
    }else{
        println("El dron $numero esta inactivo")
    }
    return activo
}

fun seEstropea(){
    var n =(1..10).random()
    when (n){
        in 1..2->{ activo=false
            println("Se ha estropeado el dron : $numero")
        }
        else->{
            println("El dron $numero esta en buen estado")
        }
    }


}
    fun seArregla(){
        activo=true
    }

   fun mostrarInfo(){
       println("Dron Numero : $numero")
       if (activo){
           println("Estado : Activo")
       }else{
           println("Estado : Inactivo")
           println()
       }

   }

}