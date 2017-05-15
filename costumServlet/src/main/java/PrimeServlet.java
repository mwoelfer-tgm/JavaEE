import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private PrimeClient pc;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("Seite wird neu geladen!");
		PrintWriter out = response.getWriter();
		if(this.pc != null){
			out.println(getHTML());	
		} else {
			this.pc = new PrimeClient(1000001l);
			this.pc.start();
			try {
				this.pc.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println(getHTML());
		}
		out.close();
	}
	
	private String getHTML(){
		String output = "<html>"
				+ "<body>"
				+ "<h1>"
				+ this.pc.nextPrime()
				+"</h1>"
				+"Zeit: " + this.pc.getTime()
				+ "</body>"
				+ "</html>";
		return output;
	}
}
