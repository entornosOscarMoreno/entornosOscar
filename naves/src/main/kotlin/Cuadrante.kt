class Cuadrante {
    var dronesAsignados=ArrayList<Dron>(0)
    var posicion=Array<Int>(2){0}
    var nombre=""
    var ordenesPendientes=ArrayList<Orden>()
    var ordenesCumplidas=ArrayList<Orden>()
    var mecanico="Jack "
    var supervisora="Vika "
    var encargado=Tet()

constructor(x:Int,y:Int,tet: Tet){
    posicion[0]=x
    posicion[1]=y
    nombre=(x+1).toString()+", "+(y+1).toString()
    mecanico+=(posicion[0]+1).toString()+(posicion[1]+1).toString()
    supervisora+=(posicion[0]+1).toString()+(posicion[1]+1).toString()
    encargado=tet

}
    constructor()


    fun recorrerCuadrante (){

        var i =0
        while (i<dronesAsignados.size){
            var dronARevisar=dronesAsignados[i]
            if (dronARevisar.activo){
            dronARevisar.seEstropea()
            }
            i++
        }
    }
    fun dameDron(n:Int):Dron{
        return dronesAsignados[n]
    }

    fun dimeNDrones():Int{
        return dronesAsignados.size
    }
fun añadirDron(dron: Dron){
    dronesAsignados.add(Dron())

}
    fun pedirDron(almacen:Tet){
        println("Se ha solicitado un dron al Tet")
        if (almacen.compruebaAlmacen()) {
            añadirDron(almacen.enviarDron())
        }else{
            println("No se puede asignar un nuevo dron")
        }
    }

    fun añadirOrden(orden:Orden){
    ordenesPendientes.add(orden)
    }

fun dimeOrdenesPendiente():Int{
    return ordenesPendientes.size

}
fun resuelveOrdenes(){

   while (ordenesPendientes.isNotEmpty()){
       mandarOrden(0)

   }
}


    fun mandarOrden(indice:Int){
        var orden=ordenesPendientes[indice]
            orden.ejecutarOrden()
        ordenesCumplidas.add(orden)
        ordenesPendientes.removeAt(indice)
    }


    fun tirarDron(dron: Dron){
        dronesAsignados.remove(dron)

    }

    fun resumen() {
        println("Coordenadas cuadrante= $nombre")
        println("Mecanico= $mecanico")
        println("Supervisora= $supervisora")
        println("Drones asignados= ${dronesAsignados.size}  ")
        listarDrones()
        println("Ordenes totales recibidas: ${(ordenesCumplidas.size)+(ordenesPendientes.size)} :")
        println("Cumplidas: ${ordenesCumplidas.size}   Pendientes : ${ordenesPendientes.size}")
        println("Ordenes Cumplidas: ")
        listarOrdenes(1)
        println("Ordenes pendientes:")
        listarOrdenes(2)
    }
    fun listarDrones(){
        var i=0
        while (i<dronesAsignados.size){
            println()
            dronesAsignados[i].mostrarInfo()
            i++
        }
    }
    fun enseñarOrden(orden: Orden):String{
        return orden.toString()
    }
fun listarOrdenes(t:Int){
    println()
    var i=0
    when (t){
        1->{
            if (ordenesCumplidas.isNotEmpty()){

            while (i<ordenesCumplidas.size){
                println()
                var o=ordenesCumplidas[i]
                o.mostrarInfo()
                i++
            }
            }else{
                println()
                println("No se ha cumplido ninguna orden")
            }

        }
        2->{
            if (ordenesPendientes.isNotEmpty()){
            while (i<ordenesPendientes.size){
                var o=ordenesPendientes[i]
                    o.mostrarInfo()
                i++
            }
            }else{
                println("No hay ordenes pendientes")
            }
        }


    }


}

}
