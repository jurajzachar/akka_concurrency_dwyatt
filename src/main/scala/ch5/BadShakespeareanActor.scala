package ch5

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class BadShakespeareanActor extends Actor {

  //some responses to messages
  def receive = {
    case "Good Morning Sire" => println("Him: Forsooth 'tis the 'morn, but mourneth for thou doest I do!")
    case "You're terrible" => println("Him: Yup")
  }
}

object BadShakespear {

  val system = ActorSystem("BadShakespear")
  val actor = system.actorOf(Props[BadShakespeareanActor])

  // We'll use this utility method to talk with our Actor 
  def send(msg: String) {
    println("Me: " + msg)
    actor ! msg
    Thread.sleep(100)
  }

  // And our driver
  def main(args: Array[String]) {
    send("Good Morning")
    send("You're terrible")
    system.shutdown()
  }
  
}