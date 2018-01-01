/*
需求：通过UDP传输方式，将一段文字数据发送出去。
思路：
1，建立udpsocket服务
2，提供数据，并将数据封装到数据包中
3，通过socket服务的发送功能，将数据包发出去
4，关闭资源
*/
import java.net.*;
class UDPSend 
{
	public static void main(String[] args) throws Exception
	{
		//1，创建udp服务。通过DatagramSocket对象
		DatagramSocket ds = new DatagramSocket();

		//2，确定数据，并封装成数据包
		byte[] buf = "udp ge men lai le".getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByname"192.168.1.102"),10000);

		//3，将通过Socket服务，将已有的数据包发送出去，通过send方法。
		ds.send(dp);

		//4，关闭资源
		ds.close();

	}
}


/*
需求：
定义一个应用程序，用于接收udp数据并处理的

思路：
1，定义udpsocket服务。
2，定义一个数据包，因为要存储接收到的字节数据，
	因为数据包对象中有更多功能可以提取字节数据中的不同数据信息。
3，通过socket服务中的receive方法将收到的数据存入已定义好的数据包中。
4，通过数据包对象性的特有功能，将这些不同的数据取出，打印在控制台上。
5，关闭资源。
*/
class UDPRece
{
	public static void main(String[] args) throws Exception
	{
		//1，创建udp socket，建立断点。
		DatagramSocket ds = new DatagramSocket();

		//2，定义数据包，用于存储数据。
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);

		//3，通过服务的receive方法将收到的数据存入到数据包中。
		ds.receive(dp);

		//4，通过数据包的方法获取其中的数据。
		String ip = dp.getAddress().getHostAddress();

		String data = new String(dp.getData(),0,dp.getLength());

		int port = dp.getPort();

		System.out.println(ip+"::"+data+"::"+port);

		//5，关闭资源。
		ds.close();
	}
}