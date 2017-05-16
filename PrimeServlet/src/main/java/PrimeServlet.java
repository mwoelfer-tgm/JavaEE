import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private PrimeClient pc;
	
	/**
	 * Gets called everytime the website is refreshed.
	 * 
	 * If it gets called the first time, the worker is being initialized.
	 * 
	 * Gets the HTML content from the method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("Seite wird neu geladen!");
		PrintWriter out = response.getWriter();
		if(this.pc != null){
			// If the worker was already started, get the dynamic HTML
			out.println(getHTML());	
		} else {
			// If it wasn't started, start it and get the first dynamic HTML contet
			this.pc = new PrimeClient(1000000000000001l);
			this.pc.start();
			out.println(getHTML());
		}
		out.close();
	}
	
	/**
	 * Create the dynamic webcode for the website.
	 * The css is being written static in the header, by converting the style.css to a string and then adding it to the html code
	 * 
	 * Several Classes and styling is used by css to make this look beatiful
	 * @return the html for the website
	 * @throws IOException
	 */
	private String getHTML() throws IOException{
		String output = "<html>"
				+ "<head>"
				+ "<style>"
				+ readFile("style.css")
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+ "<div class='normal'>"
				+ "Die Primzahl"
				+ "</div>"
				+ "<div class='prime'>"
				+ this.pc.getPrime()
				+ "</div>"
				+ "<div class='normal'>"
				+ " wurde gefunden um " 
				+ "</div>"
				+ "<div class='timestamp'>"
				+ new SimpleDateFormat("HH:mm:ss").format(this.pc.getDate())
				+ "</div>"
				+ "<div class='normal'>"
				+" Das Servlet läuft schon seit "
				+ "</div>"
				+ "<div class='timepassed'>" 
				+ this.pc.getTime()
				+ "</div>"
				+ "<div class='normal'>"
				+ "Suche nach neuer Primzahl läuft seit "
				+ "</div>"
				+ "<div class='timepassed2'>"
				+ this.pc.getSearchTime()
				+ "</div>"
				+ "</body>"
				+ "</html>";
		return output;
	}

	
	/**
	 * Reads a file and returns the content as a string
	 * src: http://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file
	 * @param pathname the path where the file is located
	 * @return a string with the content
	 * @throws IOException
	 */
	private String readFile(String pathname) throws IOException {
	
	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");
	
	    try {
	        while(scanner.hasNextLine()) {
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}
}
