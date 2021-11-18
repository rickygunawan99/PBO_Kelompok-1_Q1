package model;

import helper.KoneksiDB;
import java.sql.*;

public class ModelAbstract {
    Connection conn = KoneksiDB.getConnection();
    PreparedStatement stat;
    ResultSet rs;
    String sql = "";
}
