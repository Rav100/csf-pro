package cn.chaseshu.activemq.test;

import org.apache.activemq.ActiveMQConnectionFactory; // 使用 ActiveMQ 的客户端实现
import javax.jms.*; // 使用 JMS API
import java.util.stream.IntStream;

/**
 * 1、点对点模型的队列（Queue）方式
 */
public class ActiveMQProducer {

    private static final String BROKER_URL = "tcp://127.0.0.1:61616";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private static final String QUEUE_NAME = "queue_demo"; // 只有 QUEUE_NAME 需要共享给 RabbitMQConsumer


    public static void main(String[] args) throws JMSException {

        // 创建连接
        Connection connection = getConnection();

        //创建会话
        Session session = getSession(connection);

        //创建队列
        Queue queue = getQueue(session);

        //创建 Producer
        MessageProducer producer = session.createProducer(queue);

        //发送消息
        IntStream.range(0, 3).forEach( i->{
            try {
                Message message = session.createTextMessage("Hello World " + i);
                producer.send(message);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

        //关闭会话
        session.close();

        //关闭连接
        connection.close();


    }

    public static Queue getQueue(Session session) throws JMSException {

        return session.createQueue(QUEUE_NAME);
    }

    public static Session getSession(Connection connection) throws JMSException {

        // 第一个方法参数 transacted ，是否开启事务。这里设置为 false ，无需开启
        // 第二个方法参数 acknowledgeMode ，确认模式。这里设置为 AUTO_ACKNOWLEDGE ，自动确认。推荐阅读 https://my.oschina.net/thinwonton/blog/995291
        return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }


    public static Connection getConnection() throws JMSException {

        // create connection
        ConnectionFactory factory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
        Connection connection = factory.createConnection();

        // start connection
        connection.start();

        return connection;


    }
}
