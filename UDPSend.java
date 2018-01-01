/*
����ͨ��UDP���䷽ʽ����һ���������ݷ��ͳ�ȥ��
˼·��
1������udpsocket����
2���ṩ���ݣ��������ݷ�װ�����ݰ���
3��ͨ��socket����ķ��͹��ܣ������ݰ�����ȥ
4���ر���Դ
*/
import java.net.*;
class UDPSend 
{
	public static void main(String[] args) throws Exception
	{
		//1������udp����ͨ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket();

		//2��ȷ�����ݣ�����װ�����ݰ�
		byte[] buf = "udp ge men lai le".getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByname"192.168.1.102"),10000);

		//3����ͨ��Socket���񣬽����е����ݰ����ͳ�ȥ��ͨ��send������
		ds.send(dp);

		//4���ر���Դ
		ds.close();

	}
}


/*
����
����һ��Ӧ�ó������ڽ���udp���ݲ������

˼·��
1������udpsocket����
2������һ�����ݰ�����ΪҪ�洢���յ����ֽ����ݣ�
	��Ϊ���ݰ��������и��๦�ܿ�����ȡ�ֽ������еĲ�ͬ������Ϣ��
3��ͨ��socket�����е�receive�������յ������ݴ����Ѷ���õ����ݰ��С�
4��ͨ�����ݰ������Ե����й��ܣ�����Щ��ͬ������ȡ������ӡ�ڿ���̨�ϡ�
5���ر���Դ��
*/
class UDPRece
{
	public static void main(String[] args) throws Exception
	{
		//1������udp socket�������ϵ㡣
		DatagramSocket ds = new DatagramSocket();

		//2���������ݰ������ڴ洢���ݡ�
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);

		//3��ͨ�������receive�������յ������ݴ��뵽���ݰ��С�
		ds.receive(dp);

		//4��ͨ�����ݰ��ķ�����ȡ���е����ݡ�
		String ip = dp.getAddress().getHostAddress();

		String data = new String(dp.getData(),0,dp.getLength());

		int port = dp.getPort();

		System.out.println(ip+"::"+data+"::"+port);

		//5���ر���Դ��
		ds.close();
	}
}