package com.nakanara.openapi.apt.dao;

import javax.persistence.Id;

/**
 * create table TC_CODE_TYPE (
 cod_typ_id varchar2(20),
 cod_typ_name varchar2(200),
 cod_typ_used varchar2(1)
 )
 * Created by nakanara on 2017-06-29.
 */
public class TcCodeTypeDao {

    @Id
    private String cod_typ_id;
    private String cod_typ_name;
    private String cod_typ_used;

    public String getCod_typ_id() {
        return cod_typ_id;
    }

    public void setCod_typ_id(String cod_typ_id) {
        this.cod_typ_id = cod_typ_id;
    }

    public String getCod_typ_name() {
        return cod_typ_name;
    }

    public void setCod_typ_name(String cod_typ_name) {
        this.cod_typ_name = cod_typ_name;
    }

    public String getCod_typ_used() {
        return cod_typ_used;
    }

    public void setCod_typ_used(String cod_typ_used) {
        this.cod_typ_used = cod_typ_used;
    }
}
