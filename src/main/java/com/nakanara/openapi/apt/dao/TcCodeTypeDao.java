package com.nakanara.openapi.apt.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * create table TC_CODE_TYPE (
 cod_typ_id varchar2(20),
 cod_typ_name varchar2(200),
 cod_typ_used varchar2(1)
 )
 * Created by nakanara on 2017-06-29.
 */
@Entity
@Data
public class TcCodeTypeDao {

    @Id
    @Getter @Setter private String cod_typ_id;
    @Getter @Setter private String cod_typ_name;
    @Getter @Setter private String cod_typ_used;

}
