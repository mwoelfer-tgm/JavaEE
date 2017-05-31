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
	 * F�hrt post und get zusammen
	 * @param request mit diesem Objekt mann man Attribute speichern und weiterleitungen durchf�hren
	 * @param response mit diesem Objekt kann mit getWriter() geschrieben werden
	 * @throws IOException
	 * @throws ServletException
	 */
	protected void process(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		// mit request.getParameter(name) kann man sich die Werte holen, die von dem Formular �bergeben wurden
		// ein Parameter ist deswegen n�tig, weil von einem Formular mehrere Werte �bergeben werden
		String firstChoice = request.getParameter("firstDropDown");
		String secondChoice = request.getParameter("secondDropDown");
		
		// Es wird �berpr�ft ob das Servlet aufgerufen wird von dem Formular des ersten Dropdowns
		if(firstChoice != null){
			switch(firstChoice){
			// Falls Alle Hauptst�dte ausgew�hlt wurde, wird eine Liste aus Attribut gespeichert,
			// zus�tzlich wird noch eine Variable gesetzt welche bestimmt von wem die jsp aufgerufen
			// Zum schluss wird mit dem Requestdispatcher auf die jsp umgeleitet
			case "HS1": request.setAttribute("list", Model.getHautpstaedte());
						request.setAttribute("calledBy", "HS");
						request.getRequestDispatcher("PrintList.jsp").forward(request, response);
						break;
			// Falls Alle Bundesl�nder ausgew�hlt wurde, passiert exakt das gleiche nur f�r die Bundesl�nder
			case "BL": 	request.setAttribute("list", Model.getBundesLaender());
						request.setAttribute("calledBy", "BL");
						request.getRequestDispatcher("PrintList.jsp").forward(request, response);
						break;
			// Falls nun 'ein Bundesland' ausgew�hlt wird, wird nur die Liste als Attribut abgespeichert (damit ein
			// dropdown erstellt werden kann) und weitergeleitet anschlie�end
			case "HS2": request.setAttribute("list", Model.getBundesLaender());
						request.getRequestDispatcher("ChooseCapital.jsp").forward(request, response);
						break;
			// Falls alles schief l�uft wird eine fehlernachricht ausgegeben, dieser fehler sollte eigentlich nie auftreten
			default: 	response.getWriter().println("<html><head></head><body>Oh nein, etwas ist schief gelaufen! "
					+ "Wie hast du das �berhaupt geschafft? Das ist eigentlich komplett unm�glich!!!!! </br> </br> "
						+ "<a href='index.jsp'> Zur�ck zur Startseite</a></body></html>");
			}
		} else if (secondChoice != null){
			// Wenn man in dieses if gelangt, wei� man dass das servlet durch das zweite formular aufgerufen wurde
			
			// Es werden zwei Attribute gesetzt, einmal state und capital, wobei state einfach der Parameter des Dropdowns ist
			// und capital sich �ber das Model geholt wird
			request.setAttribute("state", secondChoice);
			request.setAttribute("capital", Model.getCapital(secondChoice));
			request.getRequestDispatcher("PrintCapital.jsp").forward(request, response);
		}
	}
}
