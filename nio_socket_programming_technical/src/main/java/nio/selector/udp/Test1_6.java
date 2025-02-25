package nio.selector.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class Test1_6 {

    public static void main(String[] args) throws IOException {

        DatagramChannel channel = DatagramChannel.open(StandardProtocolFamily.INET);
        channel.connect(new InetSocketAddress("224.0.0.5", 8088));
        channel.configureBlocking(false);

        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_WRITE);

        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            if(key.isWritable()){
                ByteBuffer byteBuffer = ByteBuffer.wrap("我来自客户端".getBytes());
                channel.send(byteBuffer, new InetSocketAddress("localhost", 8888));
                channel.close();
            }
        }
        System.out.println("client end!");
    }
}
