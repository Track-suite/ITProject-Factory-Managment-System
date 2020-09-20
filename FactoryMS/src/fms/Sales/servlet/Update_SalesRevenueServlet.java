package fms.Sales.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fms.model.Sales_Revenue;

import fms.Sales.service.Sales_RevenueService;
import fms.Sales.service.Sales_RevenueServiceImpt;

/**
 * Servlet implementation class Update_SalesRevenueServlet
 */
/**
 * @author Zumry
 *IT NO:IT19175126
 *
 */

@WebServlet("/Update_SalesRevenueServlet")
public class Update_SalesRevenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_SalesRevenueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		Sales_Revenue Revenue = new Sales_Revenue();
		
		String RevenueID = request.getParameter("RevID");
		
		Revenue.setFactory_SalesID(request.getParameter("FactorySalesID"));
		Revenue.setDate(request.getParameter("RevDate"));
		Revenue.setTea_Grade(request.getParameter("Tea_Garde"));
		Revenue.setSold_Quantity(request.getParameter("Sold_Qty"));
		Revenue.setSales_Type(request.getParameter("Sales_Type"));
		Revenue.setSales_RevenueID(RevenueID);
		
		//Call back end
		Sales_RevenueService UpdateRevenue = new Sales_RevenueServiceImpt();
		UpdateRevenue.UpdateSalesRevenue(RevenueID, Revenue);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Interfaces/Sales/Sales_Add_Sales Revenue.jsp");
		dispatcher.forward(request, response);
	}

}
