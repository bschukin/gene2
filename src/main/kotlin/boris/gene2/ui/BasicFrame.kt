package boris.gene2.ui


import com.jogamp.opengl.GLAutoDrawable
import com.jogamp.opengl.GLCapabilities
import com.jogamp.opengl.GLEventListener
import com.jogamp.opengl.GLProfile
import com.jogamp.opengl.awt.GLCanvas
import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.FlowLayout.LEFT
import java.awt.Toolkit
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.*


class BasicFrame : GLEventListener {

    override fun display(arg0: GLAutoDrawable) {
        // method body
    }

    override fun dispose(arg0: GLAutoDrawable) {
        //method body
    }

    override fun init(arg0: GLAutoDrawable) {
        // method body
    }

    override fun reshape(arg0: GLAutoDrawable, arg1: Int, arg2: Int, arg3: Int, arg4: Int) {
        // method body
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            //getting the capabilities object of GL2 profile
            val profile = GLProfile.get(GLProfile.GL2)
            val capabilities = GLCapabilities(profile)

            // The canvas
            val glcanvas = GLCanvas(capabilities)
            val b = BasicFrame()
            glcanvas.addGLEventListener(b)

            //creating frame
            val frame = JFrame(" Basic Frame")
            val contentPane = JPanel()
            contentPane.border = BorderFactory.createEmptyBorder(5, 5, 5, 5)
            //contentPane.background = Color.GRAY
            contentPane.setBounds(0, 0, 300, 100)
            contentPane.layout = BoxLayout(contentPane, BoxLayout.Y_AXIS);

            //frame.add(contentPane)

            frame.add(contentPane, BorderLayout.WEST)



            val button = JButton("btn599999")
            contentPane.add(button)

            val label = JLabel("                                                        ")
            contentPane.add(label)

            val button2 = JButton("btn2")
            //button2.margin = Insets(20, 20, 20, 20)
            contentPane.add(button2)

            val label1 = JLabel("                                                        ")
            contentPane.add(label1)

            val panel = JPanel()
            panel.layout = FlowLayout(LEFT)

            val model = SpinnerNumberModel(10.0, 1.0, 15.0, 0.1)
            val spinner = JSpinner(model)
            spinner.setSize(20, 20)
            panel.add(JLabel("spinner: ")
                .also { it.setFont (label.getFont ().deriveFont (16.0f))
            })
            panel.add(spinner)
            contentPane.add(panel)


            val button3 = JButton("btn3")
           // contentPane.add(button3)

            //adding canvas to it
            GridView.open()

            frame.add(GridView.glCanvas, BorderLayout.CENTER)
            button.addActionListener {
                GridView.flag = !GridView.flag
            }
            button2.addActionListener({
                //GridView.glCanvas.setBounds(button2.x+button2.width+10, 0, 600, 600)
                //frame.pack()
            })

            //frame.pack(); // give a suitable size to window automatically

            frame.addWindowListener(object : WindowAdapter(){
                override fun windowClosing(e: WindowEvent?) {
                    super.windowClosing(e)
                    GridView.close()
                }
            })



            val screenSize = Toolkit.getDefaultToolkit().getScreenSize()
            frame.setSize(screenSize.width, screenSize.height)
            frame.setLocationRelativeTo(null)
            frame.toFront()
            frame.isVisible = true
            frame.extendedState = frame.getExtendedState() or JFrame.MAXIMIZED_BOTH


        }//end of main
    }

}//end of classimport