package objsets

import common._

object practice {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(258); 

    //TweetReader.allTweets
    //GoogleVsApple.appleTweets.getElem
    //GoogleVsApple.appleTweets
    
    val descending = GoogleVsApple.googleTweets.union(GoogleVsApple.appleTweets).descendingByRetweet;System.out.println("""descending  : objsets.TweetList = """ + $show(descending ));$skip(20); val res$0 = 
    descending.head;System.out.println("""res0: objsets.Tweet = """ + $show(res$0));$skip(25); val res$1 = 
    descending.tail.head;System.out.println("""res1: objsets.Tweet = """ + $show(res$1));$skip(30); val res$2 = 
    descending.tail.tail.head;System.out.println("""res2: objsets.Tweet = """ + $show(res$2));$skip(35); val res$3 = 
    descending.tail.tail.tail.head;System.out.println("""res3: objsets.Tweet = """ + $show(res$3));$skip(26); 

    val set1 = new Empty;System.out.println("""set1  : objsets.Empty = """ + $show(set1 ));$skip(55); 
    val set2 = set1.incl(new Tweet("a", "a body", 20));System.out.println("""set2  : objsets.TweetSet = """ + $show(set2 ));$skip(55); 
    val set3 = set2.incl(new Tweet("b", "b body", 20));System.out.println("""set3  : objsets.TweetSet = """ + $show(set3 ))}
}
