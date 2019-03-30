package Add;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class NoMoss
{
	static BufferedReader in; 
	static BufferedWriter out;
	public NoMoss()throws IOException
	{
		File finput = new File(".\\input.txt"); 
		in = new BufferedReader(new FileReader(finput)); 
		FileWriter foutput = new FileWriter(".\\output.txt");  	
		out = new BufferedWriter(foutput);
	}
	
	public static int random(int x)	
	{
		return((int)(x*Math.random()));
	}
	public void edit()throws IOException
	{
		String st;
		st=in.readLine();
		int lang=0;
		if(st.equals("//1"))	//1 is JAVA
			lang=1;
		if(st.equals("//2"))	//2 is C
			lang=2;
		out.write("//filtered by NoMoss<br>");
		int rd=random(6);
		for(int i=0;i<rd;i++)
		{
			out.write("//");
			rd=random(20);
			for(int j=0;j<rd;j++)
			{
				out.write(""+random(10000));
			}
			out.write("<br>");
		}
		boolean firstBracket=false;
		if(lang==1)
			firstBracket=false;
		if(lang==2)
			firstBracket=true;
		boolean chng=false;
		int line=0;
		int fb=0;
		while((st=in.readLine())!=null)
		{
			++line;
			out.write("//0");
			rd=random(20);
			for(int j=0;j<rd;j++)
			{
				out.write(""+random(10000));
			}
			out.write("<br>");
			if(random(10)>=2&&chng==false&&st.indexOf('{')>=0)
			{
				if(firstBracket==true)
				{
					out.write(st.substring(0,st.indexOf('{')+1));
					rd=random(10);
					for(int j=0;j<rd;j++)
					{
						if(lang==1)
						{
							out.write("System.out.print(\"\");");
						}
						if(lang ==2)
						{
							out.write("printf(\"\");");
						}
					}
					out.write(st.substring(st.indexOf('{')+1));
					out.write("<br>");
					chng=true;
					fb=line;
				}
				firstBracket=true;
			}
			if(random(2)==1)
			{
				out.write("//");
				rd=random(20);
				for(int j=0;j<rd;j++)
				{
					out.write(""+random(100000));
				}
				out.write("<br>");
			}
			if(fb!=line)
				out.write(st+"<br>");
		}
	}
}	