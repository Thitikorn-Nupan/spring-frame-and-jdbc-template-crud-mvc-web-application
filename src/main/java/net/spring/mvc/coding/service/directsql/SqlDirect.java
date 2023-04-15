package net.spring.mvc.coding.service.directsql;

public class SqlDirect {
    private final String CREATE = "insert into contact(`firstname`,`age`,`email`,`address`)" +
            " values(?,?,?,?) ;";

    private final String READS = "select * from contact ;";
    private final String READ = "select * from contact where id = ?;";
    private final String UPDATE  = "UPDATE contact SET firstname =? , age = ? , email = ? , address = ? WHERE id = ? ;";
    private final String DELETE  = "DELETE FROM contact WHERE id = ? ;";

    public String getCREATE() {
        return CREATE;
    }

    public String getREADS() {
        return READS;
    }
    public String getREAD() {
        return READ;
    }

    public String getUPDATE() {
        return UPDATE;
    }

    public String getDELETE() {
        return DELETE;
    }
}
