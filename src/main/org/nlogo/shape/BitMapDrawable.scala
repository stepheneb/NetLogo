package org.nlogo.shape

import org.nlogo.render.Drawable
import java.awt.Toolkit
import org.nlogo.api.{GraphicsInterface}

class BitMapDrawable(shape:String) extends Drawable {

  def draw(g: GraphicsInterface, size: Double){
    g.drawImage(Toolkit.getDefaultToolkit.getImage(shape.substring(1)), 0, 0, 10, 10)
  }

  def adjustSize(objSize: Double, patchSize: Double): Double = 1
}