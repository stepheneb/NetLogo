// (C) 2012 Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.headless

import org.nlogo.api.{ Observer, Turtle, Patch, Link, LogoList }

class TestAllStoredValues extends AbstractTestModels {
  testModel("all agents included", Model()) {
    observer>> "crt 10 [ create-links-with other turtles ]"
    val vals = world.allStoredValues.toStream
    expect(1) {
      vals.collect{case o: Observer => o}.size
    }
    // squared because the turtles also appear in the end1 and end2 variables of the links
    expect(world.turtles.count * world.turtles.count) {
      vals.collect{case t: Turtle => t}.size
    }
    expect(world.patches.count) {
      vals.collect{case p: Patch => p}.size
    }
    expect(world.links.count) {
      vals.collect{case l: Link => l}.size
    }
  }
  testModel("sample agent variable included", Model()) {
    assert(!world.allStoredValues.contains("foo"))
    observer>> "ask one-of patches [ set plabel \"foo\" ]"
    assert(world.allStoredValues.contains("foo"))
  }
  testModel("inside nested list", Model()) {
    observer>> "ask one-of patches [ set plabel [[[[\"foo\"]]]] ]"
    val vals = world.allStoredValues.toStream
    expect(4) {
      vals.collect{case l: LogoList => l}.size
    }
    expect(1) {
      vals.collect{case "foo" => true}.size
    }
  }
}
