package common

import streams.Bloxorz
import streams.GameDef

object test {

  // Create a game
  val game = new GameDef {
    val startPos = Pos(1,1)
    val goal = Pos(5,5)
    val terrain = ((p: Pos) => true)
  }                                               //> game  : streams.GameDef = common.test$$anonfun$main$1$$anon$1@5d593d1
  // Now do stuff with it.
  game.Pos(2, 2).x                                //> res0: Int = 2

  Bloxorz.Level3.startPos                         //> res1: streams.Bloxorz.Level3.Pos = Pos(4,1)
  Bloxorz.Level3.goal                             //> res2: streams.Bloxorz.Level3.Pos = Pos(4,13)
  
  Bloxorz.Level3.pathsFromStart                   //> res3: Stream[(streams.Bloxorz.Level3.Block, List[streams.Bloxorz.Level3.Move
                                                  //| ])] = Stream((Block(Pos(4,1),Pos(4,1)),List()), ?)
  
  Bloxorz.Level6.pathsToGoal                      //> res4: Stream[(streams.Bloxorz.Level6.Block, List[streams.Bloxorz.Level6.Move
                                                  //| ])] = Stream((Block(Pos(5,13),Pos(5,13)),List(Right, Down, Down, Right, Down
                                                  //| , Right, Right, Up, Left, Down, Down, Right, Right, Right, Up, Up, Up, Left,
                                                  //|  Up, Up, Left, Left, Left, Up, Right, Down, Down, Right, Down, Down, Right, 
                                                  //| Down, Right, Right, Right)), ?)
}