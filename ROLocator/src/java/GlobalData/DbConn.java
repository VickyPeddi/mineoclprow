/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GlobalData;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author t_nitesh
 */
public class DbConn {

    public DbConn() {
    }

    public static Connection getConForRecordingCount() {
        Connection con = null;
        try {
//            InitialContext jndiCntx = new InitialContext();
//            DataSource ds = (DataSource) jndiCntx.lookup("java:/RETAILDB");
//            con = ds.getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");
////            /*live db*/
//            con = DriverManager.getConnection("jdbc:oracle:thin:@RETAILORASCAN.DS.INDIANOIL.IN/MKTRETAILDB", "retaildb", "retaildb#321");
//            /*testing DB*///con = DriverManager.getConnection("jdbc:oracle:thin:@10.146.64.105/ORCL.DS.INDIANOIL.IN", "retaildb", "RETAILDB123");
            con = DriverManager.getConnection("jdbc:oracle:thin:@test19cscan.ds.indianoil.in/TESTRETAILRACK", "RETAILDB", "retaildb#321");
        } catch (Exception ex) {
            System.out.print("Error in creating database connection ---------------" + ex.getMessage());
        }
        return con;
    }

    public static Connection getCon() throws Exception {
        Connection con ;
//            InitialContext jndiCntx = new InitialContext();
//            DataSource ds = (DataSource) jndiCntx.lookup("java:/RETAILDB");
//            con = ds.getConnection();
        Class.forName("oracle.jdbc.driver.OracleDriver");
//            /*live db*/
//            con = DriverManager.getConnection("jdbc:oracle:thin:@RETAILORASCAN.DS.INDIANOIL.IN/MKTRETAILDB", "retaildb", "retaildb#321");
        /*testing DB*///con = DriverManager.getConnection("jdbc:oracle:thin:@10.146.64.105/ORCL.DS.INDIANOIL.IN", "retaildb", "RETAILDB123");
        con = DriverManager.getConnection("jdbc:oracle:thin:@test19cscan.ds.indianoil.in/TESTRETAILRACK", "RETAILDB", "retaildb#321");

//        insertupdatedataForConnCount("insert into PUMP_LOCATOR_CONN_COUNT select systimestamp from dual");

        return con;
    }

    public static ResultSet getDetails(String query) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            con = getCon();
            stmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();

            return rs;
        } catch (Exception ex) {
            System.out.println("RetalDashBoard>>" + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                        con = null;
                    } catch (SQLException ex) {
                        Logger.getLogger(DbConn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return null;
    }

//    public static ResultSet getDetails(String query, Connection con) {
//        ResultSet rs = null;
//        Statement stmt = null;
//        try {
//
//            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rs = stmt.executeQuery(query);
//
//        } catch (Exception ex) {
//            System.out.println("RetalDashBoard>>" + ex.getMessage());
//        } finally {
//            try {
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        return rs;
//    }
    public static boolean insertupdatedata(String query, boolean addToBatch) {
        boolean res = false;
        Connection con = null;
        Statement stmt = null;
        try {
            con = getCon();
            con.setAutoCommit(false);
            stmt = con.createStatement();

            if (addToBatch) {
                String[] queries = query.split("#");

                for (int i = 0; i < queries.length - 1; i++) {
                    stmt.addBatch(queries[i]);
                }

                int[] count = stmt.executeBatch();
                if (count.length > 0) {
                    res = true;
                }
            } else {
                int count = stmt.executeUpdate(query);

                if (count >= 0) {
                    res = true;
                }

            }
            con.commit();
        } catch (Exception ex) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException logOrIgnore) {
                    System.out.println("RetalDashBoard>>" + logOrIgnore.getMessage());
                }
            }

            System.out.println("RetalDashBoard>>" + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }

            } catch (Exception ex) {
            } finally {
                if (con != null) {
                    try {
                        con.close();
                        con = null;
                    } catch (Exception ex) {
                    }
                }
            }
        }
        return res;
    }

    public static boolean insertupdatedataForConnCount(String query) {
        boolean res = false;
        Connection con = null;
        Statement stmt = null;
        try {
            con = getConForRecordingCount();
            con.setAutoCommit(false);
            stmt = con.createStatement();

            int count = stmt.executeUpdate(query);

            if (count >= 0) {
                res = true;
            }

            con.commit();
        } catch (Exception ex) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException logOrIgnore) {
                    System.out.println("RetalDashBoard>>" + logOrIgnore.getMessage());
                }
            }

            System.out.println("RetalDashBoard>>" + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }

            } catch (Exception ex) {
            } finally {
                if (con != null) {
                    try {
                        con.close();
                        con = null;
                    } catch (Exception ex) {
                    }
                }
            }
        }
        return res;
    }

    public static String escape(String orig) {
        StringBuffer buffer = new StringBuffer(orig.length());

        for (int i = 0; i < orig.length(); i++) {
            char c = orig.charAt(i);
            switch (c) {
                case '\b':
                    buffer.append("\\b");
                    break;
                case '\f':
                    buffer.append("\\f");
                    break;
                case '\n':
                    buffer.append("<br />");
                    break;
                case '\r':
                    // ignore
                    break;
                case '\t':
                    buffer.append("\\t");
                    break;
                case '\'':
                    buffer.append("''");
                    break;
                case '\"':
                    buffer.append("\\\"");
                    break;
                case '\\':
                    buffer.append("\\\\");
                    break;
                case '<':
                    buffer.append("&lt;");
                    break;
                case '>':
                    buffer.append("&gt;");
                    break;
                case '&':
                    buffer.append("&amp;");
                    break;
                case ';':
                    buffer.append("&#59;");
                    break;
                default:
                    buffer.append(c);
            }
        }

        return buffer.toString();
    }

}
