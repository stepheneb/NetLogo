// (C) 2012 Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.threed

import org.nlogo.agent.World3D
import org.nlogo.api.Syntax
import org.nlogo.nvm.{ Context, Reporter }

class _minpzcor extends Reporter {
  override def syntax =
    Syntax.reporterSyntax(Syntax.NumberType)
  override def report(context: Context) =
    Double.box(world.asInstanceOf[World3D].minPzcor)
}
