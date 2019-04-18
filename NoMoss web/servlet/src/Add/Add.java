
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add")

public class Add extends HttpServlet {


    public void service(HttpServletRequest r,HttpServletResponse s) throws IOException
    {

        String i=r.getParameter("t1");
        String lang=r.getParameter("t2");
        PrintWriter out=s.getWriter();
//		String relativeWebPath = "/WEB-INF/static/file1.ext";
//		String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
//		File file = new File(absoluteDiskPath);
//		InputStream input = new FileInputStream(file);

        FileWriter createIn=new FileWriter(".\\input.txt");
        BufferedWriter oin=new BufferedWriter(createIn);
        if(lang.equals("JAVA"))
            oin.write("//1\n");
        if(lang.equals("C"))
            oin.write("//2\n");
        oin.write(i);
        oin.close();
        createIn.close();

        NoMoss ob=new NoMoss();
        ob.edit();
        ob.in.close();
        ob.out.close();

        File finput = new File(".\\output.txt");
        BufferedReader in = new BufferedReader(new FileReader(finput));
        String st,pr="";
        while((st=in.readLine())!=null)
        {
            pr+=(st+"\n");
        }
        out.write(pr);;
        out.close();
    }
}