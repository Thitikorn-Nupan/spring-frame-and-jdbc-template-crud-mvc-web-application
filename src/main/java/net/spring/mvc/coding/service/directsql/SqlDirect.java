package net.spring.mvc.coding.service.directsql;

public class SqlDirect {
    private final String CREATE = "insert into contacts(`firstname`,`age`,`email`,`address`) values(?,?,?,?) ;";
    private final String READS = "select * from contacts ;";
    private final String READ = "select * from contacts where id = ?;";
    private final String UPDATE = "update contacts set firstname =? , age = ? , email = ? , address = ? WHERE id = ? ;";
    private final String DELETE = "delete from contacts WHERE id = ? ;";

    public String getCREATE() {
        return CREATE;
    }

    public String getREADS() { return READS;}

    public String getREAD() {
        return READ;
    }

    public String getUPDATE() {
        return UPDATE;
    }

    public String getDELETE() { return DELETE;}
}
