// (C) 2012 Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.nvm

trait GeneratorInterface {
  def generate(): Array[Command]
}
