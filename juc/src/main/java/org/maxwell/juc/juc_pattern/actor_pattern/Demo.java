package org.maxwell.juc.juc_pattern.actor_pattern;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/9/8 16:37
 */
public class Demo {

    //该Actor当收到消息message后，
    //会打印Hello message
    static class HelloActor extends UntypedAbstractActor {
        @Override
        public void onReceive(Object message) {
            System.out.println("Hello " + message);
        }
    }

    public static void main(String[] args) {
        //创建Actor系统
        ActorSystem system = ActorSystem.create("HelloSystem");
        //创建HelloActor
        ActorRef helloActor =
                system.actorOf(Props.create(HelloActor.class));
        //发送消息给HelloActor
        helloActor.tell("Actor", ActorRef.noSender());
    }


}
