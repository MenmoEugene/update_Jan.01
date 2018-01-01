/*
����ͨ��UDP���䷽ʽ����һ���������ݷ��ͳ�ȥ��
����һ��udp�ķ��Ͷˡ�
˼·��
1������udpsocket����
2���ṩ���ݣ��������ݷ�װ�����ݰ���
3��ͨ��socket����ķ��͹��ܣ������ݰ�����ȥ
4���ر���Դ
*/
import java.net.*;
class UdpSend 
{
	public static void main(String[] args) throws Exception
	{
		//1������udp����ͨ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket(8888);

		//2��ȷ�����ݣ�����װ�����ݰ���DatagramSocket(byte[] buf,int length,InetAddress address,int port)
		byte[] buf = "xml ni jin lai ke hao?".getBytes();
		DatagramPacket dp = 
			new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.102"),10000);

		//3����ͨ��Socket���񣬽����е����ݰ����ͳ�ȥ��ͨ��send������
		ds.send(dp);

		//4���ر���Դ
		ds.close();

	}
}


/*
����
����һ��Ӧ�ó������ڽ���udp���ݲ������

����udp�Ľ��ն�
˼·��
1������udpsocket����ͨ�������һ���˿ڣ���ʵ���Ǹ������������Ӧ�ó��������ֱ�ʶ��
	��������ȷ��Щ���ݹ�����Ӧ�ó�����Դ���

2������һ�����ݰ�����ΪҪ�洢���յ����ֽ����ݣ�
	��Ϊ���ݰ��������и��๦�ܿ�����ȡ�ֽ������еĲ�ͬ������Ϣ��
3��ͨ��socket�����е�receive�������յ������ݴ����Ѷ���õ����ݰ��С�
4��ͨ�����ݰ������Ե����й��ܣ�����Щ��ͬ������ȡ������ӡ�ڿ���̨�ϡ�
5���ر���Դ��
*/
class UdpRece
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds = new DatagramSocket(10000);
		while(true)
		{
			//1������udp socket�������ϵ㡣

			//2���������ݰ������ڴ洢���ݡ�
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);

			//3��ͨ�������receive�������յ������ݴ��뵽���ݰ��С�
			ds.receive(dp);//����ʽ������

			//4��ͨ�����ݰ��ķ�����ȡ���е����ݡ�
			String ip = dp.getAddress().getHostAddress();

			String data = new String(dp.getData(),0,dp.getLength());

			int port = dp.getPort();

			System.out.println(ip+"::"+data+"::"+port);
		}
			//5���ر���Դ��
			//ds.close();
	}
}