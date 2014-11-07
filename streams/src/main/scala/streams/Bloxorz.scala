package streams

/**
 * A main object that can be used to execute the Bloxorz solver
 */
object Bloxorz extends App {

  /**
   * A level constructed using the `InfiniteTerrain` trait which defines
   * the terrain to be valid at every position.
   */
  object InfiniteLevel extends Solver with InfiniteTerrain {
    val startPos = Pos(1,3)
    val goal = Pos(5,8)
  }
  
  println(InfiniteLevel.solution)

  /**
   * A simple level constructed using the StringParserTerrain 
   */
  abstract class Level extends Solver with StringParserTerrain
  
  object Level0 extends Level {
    val level =
      """------
        |--ST--
        |--oo--
        |--oo--
        |------""".stripMargin
  }

  println(Level0.solution)

  /**
   * Level 1 of the official Bloxorz game
   */
  object Level1 extends Level {
    val level =
      """ooo-------
        |oSoooo----
        |ooooooooo-
        |-ooooooooo
        |-----ooToo
        |------ooo-""".stripMargin
  }
  
  object Level3 extends Level {
    val level =
    """---------------  
      |------ooooooo--
      |oooo--ooo--oo--
      |ooooooooo--oooo
      |oSoo-------ooTo 
      |oooo-------oooo
      |------------ooo""".stripMargin
  }
  
  object Level4 extends Level {
    val level =
      """---------------  
      |---ooooooo----
      |---ooooooo----
      |oooo-----ooo--
      |ooo-------oo--
      |ooo-------oo--
      |oSo--ooooooooo
      |ooo--ooooooooo
      |-----oTo--oooo
      |-----ooo--oooo""".stripMargin  
  }
  
  object Level6 extends Level {
	val level =  
	  """---------------
	    |-----oooooo----
	    |-----o--ooo----
	    |-----o--ooooo--
	    |Sooooo-----oooo
	    |----ooo----ooTo
	    |----ooo-----ooo
	    |------o--oo----
	    |------ooooo----
	    |------ooooo----
	    |-------ooo-----""".stripMargin
  }

  println(Level1.solution)
}
