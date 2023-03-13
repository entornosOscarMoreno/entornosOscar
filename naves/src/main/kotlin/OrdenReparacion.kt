public class OrdenReparacion : Orden {

    var dronAReparar = Dron()
    var estadoDronAntes = false
    var estadoDronDespues = false

    constructor(cuadrante: Cuadrante, dron: Dron, fecha: String) {
        this.fecha = fecha
        dronAReparar = dron
        cuadranteDestino = cuadrante
        numero++
        nombre = numero
        println("Se ha generado la orden nº $nombre en el cuadrante ${cuadrante.nombre} para el dron nº ${dronAReparar.numero}")
    }

    override fun ejecutarOrden() {
        println("Orden ${this.nombre} completada :")
        var n = (1..10).random()
        when (n) {
            in 1..5 -> {
                dronAReparar.seArregla()
                println("Se ha arreglado el dron ${dronAReparar.numero}")
                estadoDronDespues = true
            }

            else -> {
                println("El dron ${dronAReparar.numero} no tiene arreglo")
                cuadranteDestino.tirarDron(dronAReparar)
                var e = cuadranteDestino.encargado
                cuadranteDestino.pedirDron(e)

            }

        }
        realizada = true

    }

    override var fecha: String
        get() = super.fecha
        set(value) {}

    override fun mostrarInfo() {
        println("Orden : ${nombre}")
        println("Fecha : $fecha")
        print("Realizada : ")
        println("Cuadrante destino : ${(cuadranteDestino.nombre)}")
        if (realizada) {
            println("Si")
            println("Dron a reparar ${dronAReparar.numero}")
            println("Estado anterior del dron : Inactivo")
            if (estadoDronDespues) {
                println("Estado posterior del dron : Operativo")
            } else {
                println("Estado posterior del dron : Fallido")
            }
        } else {
            println("No")
            println("Dron a reparar ${dronAReparar.numero}")
            println("Estado del dron : Inactivo")
        }
    }


    fun añadirDron(dron: Dron) {
        dronAReparar = Dron()
    }


}






