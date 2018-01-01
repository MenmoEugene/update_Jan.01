import java.net.*;
class IPDemo
{
	public static void main(String[] args) throws Exception
	{
		InetAddress i = InetAddress.getLocalHost();

		sop(i.toString());
		sop("address:"+i.getHostAddress());
		sop("name:"+i.getHostName());

		//获取其他主机名称
		InetAddress ia = InetAddress.getByName("192.168.1.103");
		sop("address:"+ia.getHostAddress());
		sop("name:"+ia.getHostName());
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
