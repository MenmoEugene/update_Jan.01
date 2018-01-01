
import java.io.*;
import java.net.*;
/*
��ʾTCP����Ŀͻ��˺ͷ���˵Ļ��á�

���󣺿ͻ��˸�����˷������ݣ�������յ��󣬸��ͻ��˷�����Ϣ��

�ͻ��ˣ�
1������socket����ָ��Ҫ���������Ͷ˿ڡ�
2����ȡsocket���е��������������д�������С�ͨ�����緢�͸�����ˡ�
3����ȡsocket���е���������������˷��������ݻ�ȡ��������ӡ��
4���رտͻ�����Դ��
*/

class TcpClient2
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("192.168.1.102",10010);

		OutputStream out = s.getOutputStream();

		out.write("ιιι".getBytes());

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);

		System.out.println(new String(buf,0,len));

		s.close();
	}
}
class TcpServer2
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10010);

		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);

		System.out.println(new String(buf,0,len));

		OutputStream out = s.getOutputStream();

		out.write("�յ��յ�".getBytes());

		s.close();
		ss.close();
	}
}
