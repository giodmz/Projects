package db.model.dao;

import db.DB;
import db.model.dao.impl.DepartmentDaoJDBC;
import db.model.dao.impl.SellerDaoJDBC;

//permite a não exposição da implementação, apenas a interface

public class DaoFactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }

}
