package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
    val list = string2Chars("halliday")
    val freqs = times(list)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }
  
  test("times counts char occurences") {
    new TestTrees {
      assert(times(list) === List(('y',1), ('a',2), ('i',1), ('l',2), ('h',1), ('d',1)))
      assert(times(List()) === List())
    }
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }
  
  test("singleton checks length of list") {
    new TestTrees {
      assert(singleton(List()) == false)
      assert(singleton(List(Leaf('a', 1))) == true)
      assert(singleton(List(Leaf('a', 1), Leaf('b', 2))) == false)
    }
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
  
  test("decode and encode a string") {
    val tree = createCodeTree(string2Chars("halliday"))
    assert(decode(tree, encode(tree)(string2Chars("hall"))) === string2Chars("hall"))
  }
  
  test("decode and quick encode a string") {
    val tree = createCodeTree(string2Chars("halliday"))
    assert(decode(tree, quickEncode(tree)(string2Chars("hall"))) === string2Chars("hall"))
  }
}
