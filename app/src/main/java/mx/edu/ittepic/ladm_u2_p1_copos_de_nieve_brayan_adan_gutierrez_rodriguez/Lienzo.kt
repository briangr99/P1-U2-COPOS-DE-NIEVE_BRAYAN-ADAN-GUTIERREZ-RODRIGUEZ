package mx.edu.ittepic.ladm_u2_p1_copos_de_nieve_brayan_adan_gutierrez_rodriguez


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Lienzo(este:MainActivity): View(este) {
    var velocidad =5
    val este =este
    val circulos = Array<Circulo>(100,{ Circulo(this) })

    val coroutine = GlobalScope.launch {
        while (true){
            este.runOnUiThread{
                invalidate()
            }
            delay(20L)
        }
    }
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        //AQUI COMIENZA MI DIBUJOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        c.drawColor(Color.BLACK)

        val path2: Path = Path()
        path2.moveTo(650f,80f)//vertice de arriba
        path2.lineTo(1200f,1200f)//vertice derecho
        path2.lineTo(130f,1000f)//vertice izquierdo
        path2.close()
        p.setColor(Color.rgb(0,94,0))
        p.style = Paint.Style.FILL
        c?.drawPath(path2,p)


        este.setTitle("ancho${width} y el largo ${height}")
        val path: Path = Path()
        path.moveTo(100f,100f)//vertice de arriba
        path.lineTo(600f,1100f)//vertice derecho
        path.lineTo(-400f,1100f)//vertice izquierdo
        path.close()
        p.setColor(Color.rgb(0,85,0))
        p.style = Paint.Style.FILL
        c?.drawPath(path,p)



        //luna
        p.setColor(Color.YELLOW)
        c.drawCircle(370f,200f,150f,p)

        p.setColor(Color.BLACK)
        c.drawCircle(400f,160f,140f,p)

        //casa
        p.setColor(Color.rgb(58,126,156))
        c.drawRect(300f,800f,1317f,1200f,p)

        p.setColor(Color.rgb(71,152,186))

        c.drawRect(300f,800f,450f,1200f,p)

        //TECHO
        p.setColor(Color.rgb(84,55,44))
        c.drawRect(375f,650f,1317f,800f,p)

        val path3: Path = Path()
        path3.moveTo(375f,650f)//vertice de arriba
        path3.lineTo(450f,800f)//vertice derecho
        path3.lineTo(300F,800f)//vertice izquierdo
        path3.close()
        p.setColor(Color.rgb(94,63,49,))
        p.style = Paint.Style.FILL
        c?.drawPath(path3,p)

        //puertas y ventanas
        //ventana
        p.setColor(Color.rgb(255,255,193))
        c.drawRect(340f,850f,410f,930f,p)

        //puerta
        p.setColor(Color.rgb(255,255,193))
        c.drawRect(350f,1100f,400f,1200f,p)

        //ventana derecha
        p.setColor(Color.rgb(255,255,193))
        c.drawRect(600f,850f,690f,930f,p)

        //ventana derecha bajo
        p.setColor(Color.rgb(255,255,193))
        c.drawRect(600f,1060f,690f,1140f,p)


        //lampara
        p.setColor(Color.rgb(100,50,0))
        c.drawRect(230f,900f,250f,1200f,p)

        p.setColor(Color.rgb(255,255,98))
        c.drawCircle(239f,900f,30f,p)

        p.setColor(Color.argb(100,255,255,98))
        c.drawCircle(239f,900f,50f,p)

        p.setColor(Color.rgb(255,255,0))
        c.drawCircle(239f,900f,20f,p)


        //camino
        p.setColor(Color.YELLOW)


        c.drawRect(30f,1250f,50f,1270f,p)
        c.drawRect(130f,1250f,150f,1270f,p)
        c.drawRect(230f,1250f,250f,1270f,p)
        c.drawRect(330f,1250f,350f,1270f,p)
        c.drawRect(430f,1250f,450f,1270f,p)
        c.drawRect(530f,1250f,550f,1270f,p)
        c.drawRect(630f,1250f,650f,1270f,p)


        //PINO
        p.setColor(Color.rgb(64,0,0))
        c.drawRect(30f,900f,60f,1200f,p)
        c.drawRect(120f,900f,130f,1100f,p)

        val path5: Path = Path()
        path5.moveTo(45f,600f)//vertice de arriba
        path5.lineTo(80f,1000f)//vertice derecho
        path5.lineTo(10f,1000f)//vertice izquierdo
        path5.close()
        p.setColor(Color.rgb(0,119,0))
        p.style = Paint.Style.FILL
        c?.drawPath(path5,p)

        val path6: Path = Path()
        path6.moveTo(135f,750f)//vertice de arriba
        path6.lineTo(100f,1050f)//vertice derecho
        path6.lineTo(150f,1050f)//vertice izquierdo
        path6.close()
        p.setColor(Color.rgb(0,119,0))
        p.style = Paint.Style.FILL
        c?.drawPath(path6,p)

        p.color = Color.WHITE
        c.drawPoint(10f,10f,p)
        c.drawPoint(100f,15f,p)
        c.drawPoint(50f,20f,p)
        c.drawPoint(10f,100f,p)
        c.drawPoint(200f,200f,p)
        c.drawPoint(300f,300f,p)
        c.drawPoint(400f,10f,p)
        c.drawPoint(600f,10f,p)
        c.drawPoint(700f,20f,p)
        c.drawPoint(650f,30f,p)
        c.drawPoint(350f,400f,p)
        c.drawPoint(450f,200f,p)
        c.drawPoint(470f,150f,p)

        //AQUI TERMINA MI DIBUJOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO

        este.setTitle("Bolitas everywhere")


        for (circ in circulos){
            circ.mover()
            circ.pintar(c)
            circ.velocidad=circ.velocidad+0.05f
            if (circ.velocidad>=70f){circ.velocidad=0f
            }
            if (circ.velocidad.toInt()>0&& circ.velocidad.toInt()<20 )este.setTitle("${circ.velocidad.toInt()} Apenas viene la tormenta...")
            if (circ.velocidad.toInt()>20){
                este.setTitle("${circ.velocidad.toInt()} Esta Nevando fuerte")
                circ.pintar2(c)
            }
            if (circ.velocidad.toInt()>50) {
                este.setTitle("${circ.velocidad.toInt()} CAYO EL TORMENTON!!")
                circ.pintar3(c)
            }
            if (circ.velocidad.toInt()>63) {
                circ.llenar(c)
            }
            if (circ.velocidad.toInt()>65) {
                circ.llenar2(c)
            }
            if (circ.velocidad.toInt()>68) {
                circ.llenar3(c)
            }


        }





    }

}