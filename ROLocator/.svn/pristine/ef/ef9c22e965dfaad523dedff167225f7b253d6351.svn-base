/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Promo;

import GlobalData.DbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author t_nitesh
 */
public class promodetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String promo_code = request.getParameter("promo_code");
        String ro_code = request.getParameter("ro_code");
        Connection con = null;
        PreparedStatement ps1 = null, ps2 = null, ps3 = null;
        ResultSet rs1 = null, rs2 = null, rs3 = null;
        try {
            /* TODO output your page here. You may use following sample code. */

            con = DbConn.getCon();
            String divContent = "";
            String dateContent = "";
            String queryPromoDetails = "SELECT  a.promo_code,"
                    + "  a.ro_code,"
                    + "  b.promo_name,"
                    + "   to_char(promo_start_date,'dd-mm-yyyy') promo_start_date,"
                    + " to_char(promo_end_date,'dd-mm-yyyy')  promo_end_date,"
                    + "  b.promo_desc "
                    + "FROM slspr_promo_ro a "
                    + "JOIN slspr_promo_details b "
                    + " on a.promo_code=b.promo_code "
                    + "where a.ro_code=";
            ps1 = con.prepareStatement(queryPromoDetails);
            ps1.setString(1, ro_code);
            rs1 = ps1.executeQuery();
            if (rs1.next()) {
                divContent = divContent + "<h5>" + rs1.getString("Promo_desc") + "</h5>";
                dateContent = "<tr><td><b>Validity From </b></td><td> " + rs1.getString("promo_start_date") + " to " + rs1.getString("promo_end_date") + "</td></tr>";
            }

            String queryRunPurchase = "SELECT  a.promo_code,"
                    + "  a.ro_code,"
                    + "  b.product_code "
                    + " FROM slspr_promo_ro a "
                    + " JOIN slspr_promo_prods b "
                    + " on a.promo_code=b.promo_code "
                    + " where a.ro_code= ?  and a.promo_code= ?";

            ps2 = con.prepareStatement(queryRunPurchase);
            ps2.setString(1, ro_code);
            ps2.setString(2, promo_code);
            rs2 = ps2.executeQuery();
            String purchase = "";
            while (rs2.next()) {
                purchase = purchase + rs2.getString("product_code") + ",";
            }
            purchase = purchase.substring(0, purchase.length() - 1);
            divContent = divContent + "<table cellspacing='20' cellpadding='20'  width='100%' >"
                    + "<tr><td><b>Run On purchase of </b> </td><td>" + purchase + "</td></tr>";
            String queryPurchasethrough = "SELECT  a.promo_code,"
                    + "  a.ro_code,"
                    + "  b.pay_mode "
                    + "FROM slspr_promo_ro a "
                    + "JOIN slspr_promo_pay_mode b "
                    + "  on a.promo_code=b.promo_code "
                    + "where a.ro_code= ? and a.promo_code=?";
            ps3 = con.prepareStatement(queryPurchasethrough);
            ps2.setString(1, ro_code);
            ps2.setString(2, promo_code);
            rs3 = ps3.executeQuery();
            String purchaseThrough = "";
            while (rs3.next()) {
                purchaseThrough = purchaseThrough + rs3.getString("pay_mode") + ",";
            }
            purchaseThrough = purchaseThrough.substring(0, purchaseThrough.length() - 1);
            divContent = divContent + "<tr><td><b>Run On purchase through </b> </td><td>" + purchaseThrough + "</td></tr>";
            divContent = divContent + dateContent + "</table><br><b><i>For further details, Please Contact Petrol Pump.</i></b>"
                    + "<br/>* Terms and Conditions apply";
            out.print(divContent);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/exception.jsp");
        } finally {

            if (rs1 != null) {
                rs1.close();
                rs1 = null;
            }
            if (rs2 != null) {
                rs2.close();
                rs2 = null;
            }
            if (rs3 != null) {
                rs3.close();
                rs3 = null;
            }
            if (ps1 != null) {
                ps1.close();
                ps1 = null;
            }
            if (ps2 != null) {
                ps2.close();
                ps2 = null;
            }
            if (ps3 != null) {
                ps3.close();
                ps3 = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(promodetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(promodetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
