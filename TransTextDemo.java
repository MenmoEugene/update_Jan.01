/*
���󣺽���һ���ı�ת����������
�ͻ��˸�����˷����ı�������˻Ὣ�ı�ת�ɴ�д�ٷ��ظ��ͻ��ˡ�
���ҿͻ��˿��Բ��ϵĽ����ı�ת�������ͻ�������overʱ��ת��������

������
�ͻ��ˣ�
	��Ȼ�ǲ����豸�ϵ����ݣ���ô�Ϳ���ʹ��io������������io�Ĳ���������˼����
	Դ������¼�롣
	Ŀ�ģ������豸�������������
	���Ҳ��������ı����ݡ�����ѡ���ַ�����

���裺
1����������
2����ȡ����¼�롣
3�������ݷ�������ˡ�
4����ȡ����˷��صĴ�д���ݡ�
5������������Դ��

�����ı����ݣ�����ʹ���ַ������в�����ͬʱ���Ч�ʣ����뻺�塣
*/
import java.io.*;
import java.net.*;
class TransClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("192.168.1.102",10004);

		//�����ȡ�������ݵ�������

		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
	
		//����Ŀ�ģ�������д�뵽socket���������������ˡ�
/*���Լ�
		BufferedWriter bufOut = 
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
*/		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		//����һ��socket��ȡ������ȡ����˷��صĴ�д��Ϣ��
		BufferedReader bufIn =
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;

			out.println(line);
/*
			bufOut.write(line);
			bufOut.newLine();
			bufOut.flush();
*/
			String str = bufIn.readLine();
			System.out.println("server:"+str);
		}
		bufr.close();
		s.close();
	}
}
/*
����ˣ�
Դ��socket��ȡ����
Ŀ�ģ�socket�������
�����ı���װ�Ρ�
*/
class TransServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10004);

		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");

		//��ȡSocket��ȡ���е�����
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		//Ŀ�ġ�socket�����������д����д�뵽socket������������͸��ͻ��ˡ�
/*���Լ�
		BufferedWriter bufOut = 
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
*/
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		String line = null;
		while((line=bufIn.readLine())!=null)
		{
			System.out.println(line);

			out.println(line.toUpperCase());
/*���Լ�
			bufOut.write(line.toUpperCase());
			bufOut.newLine();
			bufOut.flush();
*/
		}
		s.close();
		ss.close();
	}
}

/*
�����ӳ��ֵ����⡣
	���󣺿ͻ��˺ͷ���˶���Ī���ĵȴ���
	����أ�
	��Ϊ�ͻ��˺ͷ���˶�������ʽ��������Щ����Ҫôû�ж���������ǣ�Ҫô��һֱ�ȣ�
	�Ӷ��������˶��ڵȴ���
*/