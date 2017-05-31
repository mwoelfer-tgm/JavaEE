package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1;
	
	
	/**
	 * Wird aufgerufen bei get
	 */
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response ) throws IOException, ServletException{
		this.process(request, response);
	}

	/**
	 * Wird aufgerufen bei post
	 */
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		this.process(request, response);
	}

	/**
	 * Führt post und get zusammen
	 * @param request mit diesem Objekt mann man Attribute speichern und weiterleitungen durchführen
	 * @param response mit diesem Objekt kann mit getWriter() geschrieben werden
	 * @throws IOException
	 * @throws ServletException
	 */
	protected void process(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		// mit request.getParameter(name) kann man sich die Werte holen, die von dem Formular übergeben wurden
		// ein Parameter ist deswegen nötig, weil von einem Formular mehrere Werte übergeben werden
		String firstChoice = request.getParameter("firstDropDown");
		String secondChoice = request.getParameter("secondDropDown");
		
		// Es wird überprüft ob das Servlet aufgerufen wird von dem Formular des ersten Dropdowns
		if(firstChoice != null){
			switch(firstChoice){
			// Falls Alle Hauptstädte ausgewählt wurde, wird eine Liste aus Attribut gespeichert,
			// zusätzlich wird noch eine Variable gesetzt welche bestimmt von wem die jsp aufgerufen
			// Zum schluss wird mit dem Requestdispatcher auf die jsp umgeleitet
			case "HS1": request.setAttribute("list", Model.getHautpstaedte());
						request.setAttribute("calledBy", "HS");
						request.getRequestDispatcher("PrintList.jsp").forward(request, response);
						break;
			// Falls Alle Bundesländer ausgewählt wurde, passiert exakt das gleiche nur für die Bundesländer
			case "BL": 	request.setAttribute("list", Model.getBundesLaender());
						request.setAttribute("calledBy", "BL");
						request.getRequestDispatcher("PrintList.jsp").forward(request, response);
						break;
			// Falls nun 'ein Bundesland' ausgewählt wird, wird nur die Liste als Attribut abgespeichert (damit ein
			// dropdown erstellt werden kann) und weitergeleitet anschließend
			case "HS2": request.setAttribute("list", Model.getBundesLaender());
						request.getRequestDispatcher("ChooseCapital.jsp").forward(request, response);
						break;
			// Falls alles schief läuft wird eine fehlernachricht ausgegeben, dieser fehler sollte eigentlich nie auftreten
			default: 	response.getWriter().println("<html><head></head><body>Oh nein, etwas ist schief gelaufen! "
					+ "Wie hast du das überhaupt geschafft? Das ist eigentlich komplett unmöglich!!!!! </br> </br> "
						+ "<a href='index.jsp'> Zurück zur Startseite</a></body></html>");
			}
		} else if (secondChoice != null){
			// Wenn man in dieses if gelangt, weiß man dass das servlet durch das zweite formular aufgerufen wurde
			
			// Es werden zwei Attribute gesetzt, einmal state und capital, wobei state einfach der Parameter des Dropdowns ist
			// und capital sich über das Model geholt wird
			request.setAttribute("state", secondChoice);
			request.setAttribute("capital", Model.getCapital(secondChoice));
			request.getRequestDispatcher("PrintCapital.jsp").forward(request, response);
		}
	}
}
