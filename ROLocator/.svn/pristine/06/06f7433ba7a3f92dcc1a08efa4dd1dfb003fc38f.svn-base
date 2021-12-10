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
import java.util.Arrays;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 00029927
 */
public class MapLocations extends HttpServlet {

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
        String[] lats = null;
        String[] lngs = null;
        String latitude = request.getParameter("lat");
        String longitude = request.getParameter("long");
        try {
            lats = request.getParameter("latitude").split(",");
            lngs = request.getParameter("longitude").split(",");

        } catch (Exception e) {
            e.printStackTrace();
        }
        String query = "select a.ro_code,a.RO_NAME,a.RO_ADDRESS,nvl(PIN_CODE,' ') PIN_CODE,a.STATE,NVL(TELEPHONE,' ') TELEPHONE,NVL(LATITUDE,' ') LATITUDE,NVL(LONGITUDE,' ' ) LONGITUDE,"
                + "NVL(DEALER_NAME,' ') DEALER_NAME,NVL(NETWORKED,' ') NETWORKED,NVL(REST_AREA_AVAILABLE,' ') REST_AREA_AVAILABLE,NVL(PARKING,' ') PARKING,"
                + "NVL(ATM,' ') ATM,NVL(DHABA,' ') DHABA,NVL(RESTURENT,' ') RESTURENT,NVL(SERVICESTN,' ') SERVICESTN,NVL(CSTORE,' ') CSTORE,NVL(PUC,' ') PUC,"
                + "NVL(CARD,' ') CARD,NVL(WASHROOM,' ') WASHROOM,NVL(WORK_STIMING,' ') WORK_STIMING,NVL(WORK_ETIMING,' ') WORK_ETIMING,NVL(FIREBRIGADECONTNO,' ') FIREBRIGADECONTNO,"
                + "NVL(POLICECONTACTNO,' ') POLICECONTACTNO,NVL(AMBULANECONTNO,' ') AMBULANECONTNO,NVL(BREAKDOWN_SERVICE_NO,' ') BREAKDOWN_SERVICE_NO,"
                + "nvl(AUTOMATION,' ') AUTOMATION, nvl(XTRAPOWER,' ') XTRAPOWER, nvl(XTRAREWARD,' ') XTRAREWARD,nvl(SEPTOILET,' ') SEPTOILET,nvl(DRINKINGWATER,' ') DRINKINGWATER,"
                + "nvl(AIR,' ') AIR, Decode(MS,'NA','Not Available',MS) MS,Decode(Hsd,'NA','Not Available',Hsd) Hsd,Decode(Xp,'NA','Not Available',Xp) Xp,Decode(Xm,'NA','Not Available',Xm) Xm, nvl(TELF1,' ') TELF1, nvl(DEALER_NAME,' ') DEALER_NAME, "
                + "a.SALESORG_NAME,a.SALESOFF_NAME,a.SALESAREA_NAME,a.DISTRICT_NAME,a.CUST_STATE_NAME,c.promo_name,c.promo_code,"
                + " covid_special_ro,cov_relief_contact,cov_relief_contactno, nvl(Decode(Xp100,'NA','Not Available',Xp100),'Not Available') Xp100, "
                + " nvl(Decode(Xp95,'NA','Not Available',xp95),'Not Available') Xp95 ,"
                + " nvl(Decode(XG,'NA','Not Available',XG),'Not Available') XG ,"
                + " nvl(Decode(E100,'NA','Not Available',E100),'Not Available') E100 ,"
                + "case when  sysdate between c.promo_start_date and c.promo_end_date then 'Y' else 'N' END as Active  "
                + " FROM (select * from MV_MOB_CO_CUSTDATA where ms is not null and hsd is not null and xp is not null and xm is not null) a left outer join slspr_promo_ro b on a.ro_code=b.ro_code  left outer join slspr_promo_details c on b.promo_code=c.promo_code where   ";
        if (lats.length > 0 && lngs.length > 0) {
            for (int i = 0; i < lats.length; i++) {
                query = query + "(( latitude >= '"
                        + Double.toString((Double.parseDouble(lats[i]) - 0.045))
                        + "' AND latitude <= '"
                        + Double.toString((Double.parseDouble(lats[i]) + 0.045))
                        + "' AND (longitude >= '"
                        + Double.toString((Double.parseDouble(lngs[i]) - 0.055))
                        + "') AND longitude <= '" + Double.toString((Double.parseDouble(lngs[i]) + 0.055)) + "'))" + " OR ";
            }
            query = query.substring(0, query.lastIndexOf("OR")) + " order by ro_Code";

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            try {
                con = DbConn.getCon();
                st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = st.executeQuery(query);

                while (rs.next()) {
                    if (rs.getString("LATITUDE") != null && !rs.getString("LATITUDE").trim().equals("")
                            && rs.getString("LONGITUDE") != null && !rs.getString("LONGITUDE").trim().equals("")) {
                        arr += rs.getString("RO_NAME").replace("|", "") + "," + rs.getString("LATITUDE") + "," + rs.getString("LONGITUDE") + "," + rs.getString("RO_ADDRESS") + "," + rs.getString("WASHROOM") + "," + rs.getString("CARD") + ","
                                + rs.getString("REST_AREA_AVAILABLE") + "," + rs.getString("DHABA") + "," + rs.getString("PARKING") + "," + rs.getString("ATM") + "," + rs.getString("RESTURENT") + "," + rs.getString("NETWORKED") + "," + rs.getString("SERVICESTN") + "," + rs.getString("CSTORE") + "," + rs.getString("PUC") + ","
                                + rs.getString("WORK_STIMING") + "-" + rs.getString("WORK_ETIMING") + "," + rs.getString("FIREBRIGADECONTNO") + "," + rs.getString("POLICECONTACTNO") + "," + rs.getString("AMBULANECONTNO") + "," + rs.getString("AUTOMATION") + ","
                                + rs.getString("XTRAPOWER") + "," + rs.getString("XTRAREWARD") + "," + rs.getString("SEPTOILET") + "," + rs.getString("DRINKINGWATER") + "," + rs.getString("AIR") + ","
                                + rs.getString("MS") + "," + rs.getString("HSD") + "," + rs.getString("XP") + "," + rs.getString("XM") + "," + rs.getString("TELF1") + "," + rs.getString("DEALER_NAME").replace(",", "-") + "," + rs.getString("SALESORG_NAME") + ","
                                + rs.getString("SALESOFF_NAME") + "," + rs.getString("SALESAREA_NAME") + "," + rs.getString("DISTRICT_NAME") + "," + rs.getString("CUST_STATE_NAME") + "," + rs.getString("Telephone") + "," + DistanceCalculator.distance(latitude != null && !latitude.equals("") ? Double.parseDouble(latitude) : Double.parseDouble(rs.getString("LATITUDE")), longitude != null && !longitude.equals("") ? Double.parseDouble(longitude) : Double.parseDouble(rs.getString("LONGITUDE")), Double.parseDouble(rs.getString("LATITUDE")), Double.parseDouble(rs.getString("LONGITUDE")), "K") + "," + rs.getString("ro_code") + ","
                                + rs.getString("covid_special_ro") + "," + rs.getString("cov_relief_contact") + "," + rs.getString("cov_relief_contactno")
                                + "," + rs.getString("XP100") + "," + rs.getString("XP95")
                                + "," + rs.getString("XG") + "," + rs.getString("E100")
                                + "|";
                    }
                }

//                if (arr.contains("##")) {
//                    arr = arr.substring(0, arr.lastIndexOf("##"));
//                }
//
//                String newArr[] = arr.split("##");
//                Arrays.sort(newArr, new Comparator<String>() {
//                    public int compare(String str1, String str2) {
//                        String substr1 = str1.substring(str1.lastIndexOf(",") + 1, str1.length());
//                        String substr2 = str2.substring(str2.lastIndexOf(",") + 1, str2.length());
//
//                        return Double.valueOf(substr2).compareTo(Double.valueOf(substr1));
//                    }
//                });
//                arr = "";
//                for (int j = newArr.length - 1; j >= 0; j--) {
//                    arr += newArr[j] + "|";
//                }
                out.print(arr);
            } catch (Exception ex) {
                ex.printStackTrace();
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
                    ex.printStackTrace();
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

    }

    public double CalculationByDistance(double initialLat, double initialLong, double finalLat, double finalLong) {
        /*PRE: All the input values are in radians!*/

        double latDiff = finalLat - initialLat;
        double longDiff = finalLong - initialLong;
        double earthRadius = 6371; //In Km if you want the distance in km

        double distance = 2 * earthRadius * Math.asin(Math.sqrt(Math.pow(Math.sin(latDiff / 2.0), 2) + Math.cos(initialLat) * Math.cos(finalLat) * Math.pow(Math.sin(longDiff / 2), 2)));

        return distance;

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
