package com.nakanara.openapi.apt.dao;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by nakanara on 2017-06-23.
 */

@Entity(name = "TcCodeDao")
@Data
public class TcCodeDao {

    @Id
    @Getter @Setter private String code_id;

    @Getter @Setter private String code_type;

    @Getter @Setter private String code_name;

    @Getter @Setter private String code_used;

    @Getter @Setter private Integer code_order;

    public TcCodeDao(){
    }
    public TcCodeDao(String code_id) {
        this.code_id = code_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TcCodeDao tcCodeDao = (TcCodeDao) o;

        if (code_id != null ? !code_id.equals(tcCodeDao.code_id) : tcCodeDao.code_id != null) return false;
        if (code_type != null ? !code_type.equals(tcCodeDao.code_type) : tcCodeDao.code_type != null) return false;
        if (code_name != null ? !code_name.equals(tcCodeDao.code_name) : tcCodeDao.code_name != null) return false;
        if (code_used != null ? !code_used.equals(tcCodeDao.code_used) : tcCodeDao.code_used != null) return false;
        return code_order != null ? code_order.equals(tcCodeDao.code_order) : tcCodeDao.code_order == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (code_id != null ? code_id.hashCode() : 0);
        result = 31 * result + (code_type != null ? code_type.hashCode() : 0);
        result = 31 * result + (code_name != null ? code_name.hashCode() : 0);
        result = 31 * result + (code_used != null ? code_used.hashCode() : 0);
        result = 31 * result + (code_order != null ? code_order.hashCode() : 0);
        return result;
    }
}
