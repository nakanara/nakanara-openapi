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

}
