/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GlobalData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 00029927
 */
public class NearLocations extends HttpServlet {

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
        String arr = "";
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        String query = "";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
//        System.out.println(query);
        try {
            con = DbConn.getCon();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int i = 1;
            boolean loop = true;
            while (loop) {
                query = "select RO_CODE, RO_NAME,RO_ADDRESS,nvl(PIN_CODE,' ') PIN_CODE,STATE,NVL(TELEPHONE,' ') TELEPHONE,NVL(LATITUDE,' ') LATITUDE,NVL(LONGITUDE,' ' ) LONGITUDE,"
                        + "NVL(DEALER_NAME,' ') DEALER_NAME,NVL(NETWORKED,' ') NETWORKED,NVL(REST_AREA_AVAILABLE,' ') REST_AREA_AVAILABLE,NVL(PARKING,' ') PARKING,"
                        + "NVL(ATM,' ') ATM,NVL(DHABA,' ') DHABA,NVL(RESTURENT,' ') RESTURENT,NVL(SERVICESTN,' ') SERVICESTN,NVL(CSTORE,' ') CSTORE,NVL(PUC,' ') PUC,"
                        + "NVL(CARD,' ') CARD,NVL(WASHROOM,' ') WASHROOM,NVL(WORK_STIMING,' ') WORK_STIMING,NVL(WORK_ETIMING,' ') WORK_ETIMING,NVL(FIREBRIGADECONTNO,' ') FIREBRIGADECONTNO,"
                        + "NVL(POLICECONTACTNO,' ') POLICECONTACTNO,NVL(AMBULANECONTNO,' ') AMBULANECONTNO,NVL(BREAKDOWN_SERVICE_NO,' ') BREAKDOWN_SERVICE_NO,"
                        + "nvl(AUTOMATION,' ') AUTOMATION, nvl(XTRAPOWER,' ') XTRAPOWER, nvl(XTRAREWARD,' ') XTRAREWARD,nvl(SEPTOILET,' ') SEPTOILET,nvl(DRINKINGWATER,' ') DRINKINGWATER,"
                        + "nvl(AIR,' ') AIR, Decode(MS,'NA','Not Available',MS) MS,Decode(Hsd,'NA','Not Available',Hsd) Hsd,Decode(Xp,'NA','Not Available',Xp) Xp,Decode(Xm,'NA','Not Available',Xm) Xm, nvl(TELF1,' ') TELF1, nvl(DEALER_NAME,' ') DEALER_NAME"
                        + ", SALESORG_NAME,SALESOFF_NAME,SALESAREA_NAME,DISTRICT_NAME,CUST_STATE_NAME ,covid_special_ro, cov_relief_contact, "
                        + "cov_relief_contactno, nvl(Decode(Xp100,'NA','Not Available',Xp100),'Not Available') Xp100 ,"
                        + " nvl(Decode(Xp95,'NA','Not Available',xp95),'Not Available') Xp95, "
                        + " nvl(Decode(XG,'NA','Not Available',XG),'Not Available') XG, "
                        + " nvl(Decode(E100,'NA','Not Available',E100),'Not Available') E100 "
                        + " from (select * from MV_MOB_CO_CUSTDATA where ms is not null and hsd is not null and xp is not null and xm is not null) WHERE (latitude >= '"
                        + Double.toString((Double.parseDouble(latitude) - 0.045 * i))
                        + "' AND latitude <= '"
                        + Double.toString((Double.parseDouble(latitude) + 0.045 * i))
                        + "') AND (longitude >= '"
                        + Double.toString((Double.parseDouble(longitude) - 0.055 * i))
                        + "' AND longitude <= '" + Double.toString((Double.parseDouble(longitude) + 0.055 * i)) + "') order by ro_code";
                rs = st.executeQuery(query);
                if (rs.next()) {
                    loop = false;
                } else {
                    i = i + 1;
                }
            }
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("LATITUDE") != null && !rs.getString("LATITUDE").trim().equals("")
                        && rs.getString("LONGITUDE") != null && !rs.getString("LONGITUDE").trim().equals("")) {
                    arr += rs.getString("RO_NAME").replace("|", "") + "," + rs.getString("LATITUDE") + "," + rs.getString("LONGITUDE") + "," + rs.getString("RO_ADDRESS") + "," + rs.getString("WASHROOM") + "," + rs.getString("CARD") + ","
                            + rs.getString("REST_AREA_AVAILABLE") + "," + rs.getString("DHABA") + "," + rs.getString("PARKING") + "," + rs.getString("ATM") + "," + rs.getString("RESTURENT") + "," + rs.getString("NETWORKED") + "," + rs.getString("SERVICESTN") + "," + rs.getString("CSTORE") + "," + rs.getString("PUC") + ","
                            + rs.getString("WORK_STIMING") + "-" + rs.getString("WORK_ETIMING") + "," + rs.getString("FIREBRIGADECONTNO") + "," + rs.getString("POLICECONTACTNO") + "," + rs.getString("AMBULANECONTNO") + "," + rs.getString("AUTOMATION") + ","
                            + rs.getString("XTRAPOWER") + "," + rs.getString("XTRAREWARD") + "," + rs.getString("SEPTOILET") + "," + rs.getString("DRINKINGWATER") + "," + rs.getString("AIR") + ","
                            + rs.getString("MS") + "," + rs.getString("HSD") + "," + rs.getString("XP") + "," + rs.getString("XM") + "," + rs.getString("TELF1") + "," + rs.getString("DEALER_NAME").replace(",", "-") + "," + rs.getString("SALESORG_NAME") + ","
                            + rs.getString("SALESOFF_NAME") + "," + rs.getString("SALESAREA_NAME") + "," + rs.getString("DISTRICT_NAME") + ","
                            + rs.getString("CUST_STATE_NAME") + "," + rs.getString("Telephone") + ","
                            + DistanceCalculator.distance(latitude != null && !latitude.equals("") ? Double.parseDouble(latitude) : Double.parseDouble(rs.getString("LATITUDE")), longitude != null && !longitude.equals("") ? Double.parseDouble(longitude) : Double.parseDouble(rs.getString("LONGITUDE")), Double.parseDouble(rs.getString("LATITUDE")),
                                    Double.parseDouble(rs.getString("LONGITUDE")), "K") + "," + rs.getString("RO_CODE") + ","
                            + rs.getString("covid_special_ro") + "," + rs.getString("cov_relief_contact") + "," + rs.getString("cov_relief_contactno")
                            + "," + rs.getString("XP100") + "," + rs.getString("XP95")
                            + "," + rs.getString("XG") + "," + rs.getString("E100")
                            + "|";

                }
            }
//            if (arr.contains("##")) {
//                arr = arr.substring(0, arr.lastIndexOf("##"));
//            }
//            String newArr[] = arr.split("##");
//            Arrays.sort(newArr, new Comparator<String>() {
//                public int compare(String str1, String str2) {
//                    String substr1 = str1.substring(str1.lastIndexOf(",") + 1, str1.length());
//                    String substr2 = str2.substring(str2.lastIndexOf(",") + 1, str2.length());
//
//                    return Double.valueOf(substr2).compareTo(Double.valueOf(substr1));
//                }
//            });
//            arr = "";
//            for (int j = newArr.length - 1; j >= 0; j--) {
//                arr += newArr[j] + "|";
//            }
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
                if (st != null) {
                    st.close();
                    st = null;
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
