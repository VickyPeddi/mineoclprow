/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GlobalData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 00505812
 */
@WebServlet(name = "DistrictWiseLocator", urlPatterns = {"/DistrictWiseLocator"})
public class DistrictWiseLocator extends HttpServlet {

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
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String arr = "";
        response.setContentType("text/html;charset=UTF-8");
        String district = request.getParameter("district").toUpperCase();

        String query1 = "select RO_CODE,RO_NAME,RO_ADDRESS,nvl(PIN_CODE,' ') PIN_CODE,STATE,NVL(TELEPHONE,' ') TELEPHONE,NVL(LATITUDE,' ') LATITUDE,NVL(LONGITUDE,' ' ) LONGITUDE,"
                + "NVL(DEALER_NAME,' ') DEALER_NAME,NVL(NETWORKED,' ') NETWORKED,NVL(REST_AREA_AVAILABLE,' ') REST_AREA_AVAILABLE,NVL(PARKING,' ') PARKING,"
                + "NVL(ATM,' ') ATM,NVL(DHABA,' ') DHABA,NVL(RESTURENT,' ') RESTURENT,NVL(SERVICESTN,' ') SERVICESTN,NVL(CSTORE,' ') CSTORE,NVL(PUC,' ') PUC,"
                + "NVL(CARD,' ') CARD,NVL(WASHROOM,' ') WASHROOM,NVL(WORK_STIMING,' ') WORK_STIMING,NVL(WORK_ETIMING,' ') WORK_ETIMING,NVL(FIREBRIGADECONTNO,' ') FIREBRIGADECONTNO,"
                + "NVL(POLICECONTACTNO,' ') POLICECONTACTNO,NVL(AMBULANECONTNO,' ') AMBULANECONTNO,NVL(BREAKDOWN_SERVICE_NO,' ') BREAKDOWN_SERVICE_NO,"
                + "nvl(AUTOMATION,' ') AUTOMATION, nvl(XTRAPOWER,' ') XTRAPOWER, nvl(XTRAREWARD,' ') XTRAREWARD,nvl(SEPTOILET,' ') SEPTOILET,nvl(DRINKINGWATER,' ') DRINKINGWATER,"
                + "nvl(AIR,' ') AIR,Decode(MS,'NA','Not Available',MS) MS,Decode(Hsd,'NA','Not Available',Hsd) Hsd,Decode(Xp,'NA','Not Available',Xp) Xp,Decode(Xm,'NA','Not Available',Xm) Xm, nvl(TELF1,' ') TELF1, nvl(DEALER_NAME,' ') DEALER_NAME"
                + ",SALESORG_NAME,SALESOFF_NAME,SALESAREA_NAME,DISTRICT_NAME,CUST_STATE_NAME"
                + " , covid_special_ro, cov_relief_contact, cov_relief_contactno,nvl(Decode(Xp100,'NA','Not Available',Xp100),'Not Available') Xp100 ,"
                + " nvl(Decode(Xp95,'NA','Not Available',xp95),'Not Available') Xp95, "
                + " nvl(Decode(XG,'NA','Not Available',XG),'Not Available') XG "
                + ", nvl(Decode(E100,'NA','Not Available',E100),'Not Available') E100"
                + " from "
                + "MV_MOB_CO_CUSTDATA "
                + "WHERE ro_code in (select custcode from iocl_md_aod_sales where upper(district) in (?))";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DbConn.getCon();
            ps = con.prepareStatement(query1);
            ps.setString(1, district);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("LATITUDE") != null && !rs.getString("LATITUDE").trim().equals("")
                        && rs.getString("LONGITUDE") != null && !rs.getString("LONGITUDE").trim().equals("")) {
                    arr += rs.getString("RO_NAME").replace("|", "") + "," + rs.getString("LATITUDE") + "," + rs.getString("LONGITUDE") + "," + rs.getString("RO_ADDRESS") + "," + rs.getString("WASHROOM") + "," + rs.getString("CARD") + ","
                            + rs.getString("REST_AREA_AVAILABLE") + "," + rs.getString("DHABA") + "," + rs.getString("PARKING") + "," + rs.getString("ATM") + "," + rs.getString("RESTURENT") + "," + rs.getString("NETWORKED") + "," + rs.getString("SERVICESTN") + "," + rs.getString("CSTORE") + "," + rs.getString("PUC") + ","
                            + rs.getString("WORK_STIMING") + "-" + rs.getString("WORK_ETIMING") + "," + rs.getString("FIREBRIGADECONTNO") + "," + rs.getString("POLICECONTACTNO") + "," + rs.getString("AMBULANECONTNO") + "," + rs.getString("AUTOMATION") + ","
                            + rs.getString("XTRAPOWER") + "," + rs.getString("XTRAREWARD") + "," + rs.getString("SEPTOILET") + "," + rs.getString("DRINKINGWATER") + "," + rs.getString("AIR") + ","
                            + rs.getString("MS") + "," + rs.getString("HSD") + "," + rs.getString("XP") + "," + rs.getString("XM") + "," + rs.getString("TELF1") + "," + rs.getString("DEALER_NAME").replace(",", "-") + "," + rs.getString("SALESORG_NAME") + ","
                            + rs.getString("SALESOFF_NAME") + "," + rs.getString("SALESAREA_NAME") + "," + rs.getString("DISTRICT_NAME") + "," + rs.getString("CUST_STATE_NAME") + "," + rs.getString("Telephone") + "," + rs.getString("RO_CODE") + ","
                            + rs.getString("covid_special_ro") + "," + rs.getString("cov_relief_contact") + "," + rs.getString("cov_relief_contactno") + ","
                            + "" + rs.getString("xp100")+ "," + rs.getString("xp95")+ "," + rs.getString("XG")+ "," + rs.getString("E100")
                            + "|";
                }
            }

            out.print(arr);
        } catch (Exception ex) {
            System.out.println("RetalDashBoard>>" + ex.getMessage());
            response.sendRedirect("/exception.jsp");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
            } catch (Exception ex) {
                System.out.println("RetalDashBoard>>" + ex.getMessage());
            } finally {
                if (con != null) {
                    try {
                        con.close();
                        con = null;
                    } catch (SQLException ex) {
                    }
                }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
