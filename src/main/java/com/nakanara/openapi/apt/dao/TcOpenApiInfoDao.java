package com.nakanara.openapi.apt.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by nakanara on 2017-07-12.
 */
@Entity
@Data
public class TcOpenApiInfoDao {

    @Id
    @Getter @Setter private String api_seq;
    @Getter @Setter private String api_name;
    @Getter @Setter private String api_desc;

    @Getter @Setter private String api_url_dev;
    @Getter @Setter private String api_url_op;
    @Getter @Setter private String api_reg_dttm;
    @Getter @Setter private String api_mod_dttm;

}
