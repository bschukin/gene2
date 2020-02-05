package boris.gene2.ui

import com.jogamp.opengl.*
import com.jogamp.opengl.awt.GLCanvas
import com.jogamp.opengl.util.FPSAnimator
import org.anglur.joglext.jogl2d.GLGraphics2D
import java.awt.Color
import kotlin.system.exitProcess


object GridView : GLEventListener {

    private val WINDOW_WIDTH = 840
    private val WINDOW_HEIGHT = 840
    private val FPS = 60

    val glCanvas = GLCanvas(GLCapabilities(null))
    private val animator = FPSAnimator(
        glCanvas,
        FPS, true)
    val g = GLGraphics2D() //Create GL2D wrapper
    var flag = false

    init {
        GLProfile.initSingleton()
    }

    fun open() {

        glCanvas.addGLEventListener(this)
        glCanvas.setBounds(100, 0, 500, 500)


        /*glCanvas.addKeyListener(object : KeyListener{
            override fun keyPressed(e: KeyEvent?) {
                if(e!!.keyChar.equals('c', true))
                    println("hello")
            }

            override fun keyReleased(e: KeyEvent?) {

            }

        })*/
        animator.start()
    }


    override fun display(gLDrawable: GLAutoDrawable) {
        println("display")
        val gl2 = gLDrawable.gl.gL2

        gl2.glClear(GL.GL_COLOR_BUFFER_BIT)

        g.prePaint(gLDrawable.context) //Updated wrapper to latest glContext
        g.color = Color.WHITE
        g.fillRect(0, 0, 300, 300)
        g.color = Color.BLUE
        g.fillRect(200, 200, 100, 400)
        g.color = Color.black
        g.drawLine(0, 0, 100, 100)
        g.color = Color.RED
        g.drawString("HELLOW GENTLEMEN", 100, 100)

        if(flag) {
            g.drawOval(300, 200, 50, 50)
            g.color = Color.GREEN
            g.fillOval(300, 200, 49, 49)
        }

    }

    override fun init(glDrawable: GLAutoDrawable) {
    }

    override fun reshape(gLDrawable: GLAutoDrawable, x: Int, y: Int, width: Int, height: Int) {
        val gl = gLDrawable.gl.gL2
        gl.glViewport(0, 0, width, height)
    }

    override fun dispose(gLDrawable: GLAutoDrawable) {
        g.glDispose()
    }

    fun close(){
        g.dispose()
        //thread {
            if (animator.isStarted)
                animator.stop()
            exitProcess(0)
        //}.start()
    }

}


fun main(args: Array<String>) {

    GridView.open()
}
