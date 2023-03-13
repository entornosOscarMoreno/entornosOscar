import java.util.Date

open class Orden {
    companion object{
        open var numero=0
    }


    open var nombre= numero+1
    open var fecha="1"
    open var realizada=false
    open var cuadranteDestino=Cuadrante()

    open fun ejecutarOrden(){}

open fun mostrarInfo(){

}
}